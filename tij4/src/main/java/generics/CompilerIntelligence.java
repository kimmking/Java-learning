package generics;
// generics/CompilerIntelligence.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.Arrays;
import java.util.List;

public class CompilerIntelligence {

    public static void main(String[] args) {
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Apple a = (Apple) flist.get(0); // No warning
        System.out.println(flist.contains(new Apple())); // Argument is 'Object'
        System.out.println(flist.indexOf(new Apple()));  // Argument is 'Object'
    }
}
