package one.wangwei.java.rtti.generics;


import net.mindview.util.CountingGenerator;
import static net.mindview.util.Print.*;

/**
 * Created by wangwei on 11/28/14.
 */
class ClassAsFactory<T>{
    T x;
    public ClassAsFactory(Class<T> kind){
        try {
            x = kind.newInstance();
        } catch (Exception e) {
            throw  new RuntimeException();
        }
    }
}

class Employee{

}

public class InstantiateGenericType {
    public  static  void  main(String[] args){
        ClassAsFactory<Employee> fe = new ClassAsFactory<Employee>(Employee.class);
        print("fe:" + fe);
        try{
            ClassAsFactory<Integer> fi  = new ClassAsFactory<Integer>(Integer.class);
        }catch (Exception e){
            print("ClassAsFactory<Integer> failed!");
        }
    }
}
