package annotations.myprocessor.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author https://wangwei.one
 * @date 8/4/20
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface Factory {

    /**
     * the name of the factory
     *
     * @return
     */
    Class type();

    /**
     * the identifier for determining which item should be instantiated
     *
     * @return
     */
    String id();
}
