package annotations.myprocessor.processor;

import annotations.myprocessor.annotation.Factory;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author https://wangwei.one
 * @date 8/4/20
 */
public class FactoryGroupedClasses {

    /**
     * Will be added to the name of the generated factory class
     */
    private static final String SUFFIX = "Factory";

    private final String qualifiedClassName;

    private final Map<String, FactoryAnnotatedClass> itemsMap = new LinkedHashMap<>();

    public FactoryGroupedClasses(String qualifiedClassName) {
        this.qualifiedClassName = qualifiedClassName;
    }

    public void add(FactoryAnnotatedClass toInsert) throws ProcessingException {
        FactoryAnnotatedClass existing = itemsMap.get(toInsert.getId());
        if (existing != null) {
            // Already existing
            throw new ProcessingException(toInsert.getTypeElement(),
                    "Conflict: The class %s is annotated with @%s with id ='%s' but %s already uses the same id",
                    toInsert.getTypeElement().getQualifiedName().toString(), Factory.class.getSimpleName(),
                    toInsert.getId(), existing.getTypeElement().getQualifiedName().toString());
        }
        itemsMap.put(toInsert.getId(), toInsert);
    }

    public void generateCode(Elements elementUtils, Filer filer) throws IOException {
        TypeElement superClassName = elementUtils.getTypeElement(qualifiedClassName);
        String factoryClassName = superClassName.getSimpleName() + SUFFIX;
        PackageElement pkg = elementUtils.getPackageOf(superClassName);
        String packageName = pkg.isUnnamed() ? null : pkg.getQualifiedName().toString();

        MethodSpec.Builder builder = MethodSpec.methodBuilder("order")
                .addModifiers(Modifier.PUBLIC)
                .returns(TypeName.get(superClassName.asType()))
                .addParameter(String.class, "mealName")
                .endControlFlow();

        // check if id is null
        builder.beginControlFlow("if (mealName == null)")
                .addStatement("throw new IllegalArgumentException($S)", "id is null!");

        // Generate items map
        for (FactoryAnnotatedClass item : itemsMap.values()) {
            builder.beginControlFlow("if ($S.equals(id))", item.getId());
            builder.addStatement("return new $L()", item.getTypeElement().getQualifiedName().toString());
            builder.endControlFlow();
        }
        builder.addStatement("throw new IllegalArgumentException($S + id)", "Unknown id = ");

        TypeSpec factoryType = TypeSpec.classBuilder(factoryClassName)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(builder.build())
                .build();

        JavaFile javaFile = JavaFile.builder(packageName, factoryType).build();
        javaFile.writeTo(filer);
    }
}
