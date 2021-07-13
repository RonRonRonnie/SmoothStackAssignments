package JavaBasicFiveAssigment.Assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


interface Utils{
 static int sort1(String n1,String n2){
     return n1.length() - n2.length();
 }
static int sort2(String n1,String n2){
     return n2.length()-n1.length();
}

static int sort3(String n1,String n2){
    return n1.charAt(0) - n2.charAt(0);
}

static int sort4(String n1,String n2){
    long countE1 =  n2.chars().filter(ch -> ch == 'e').count();
    long countE2 = n1.chars().filter(ch -> ch == 'e').count();
    return (int) (countE1 - countE2);

}

}

public class LambdaFunction {

    public static void main(String[] args){
        List<String> names = new ArrayList<>();
        names.add("Amy");
        names.add("John");
        names.add("William");
        names.add("James");
        names.add("Evelyn");
        names.add("Harper");
        names.add("Scarlett");
        // sorted list shortest to longest
        names.sort((n1,n2)->n1.length()-n2.length());
        System.out.println(names);
        // sorted list longest to shortest
        names.sort((n1,n2)->n2.length()-n1.length());
        System.out.println(names);
        //sorted alphabetically by the first character
        names.sort((str1, str2) -> str1.charAt(0) - str2.charAt(0));
        System.out.println(names);
        //Strings that contain “e” first, everything else second.
        names.sort((n1,n2)->{
           long countE1 =  n2.chars().filter(ch -> ch == 'e').count();
           long countE2 = n1.chars().filter(ch -> ch == 'e').count();
           return (int) (countE1 - countE2);
        });
        System.out.println(names);

        //Redo the previous problem, but use a static helper method so that
        System.out.println("**********************************************");
        System.out.println("Redo the previous problem, but use a static helper method so that");
        System.out.println("**********************************************");
        // sorted list shortest to longest
        names.sort((n1,n2)->Utils.sort1(n1,n2));
        System.out.println(names);
        // sorted list longest to shortest
        names.sort((n1,n2)->Utils.sort2(n1,n2));
        System.out.println(names);
        //sorted alphabetically by the first character
        names.sort((n1,n2)->Utils.sort3(n1,n2));
        System.out.println(names);
        //Strings that contain “e” first, everything else second.
        names.sort((n1,n2)->Utils.sort4(n1,n2));
        System.out.println(names);




        System.out.println("**********************************************");
        System.out.println("test for method that returns a comma separated string based on a given list of integers.");
        System.out.println("**********************************************");
        //test for method that returns a comma separated string based on a given list of integers.
        List<Integer> test = new ArrayList<>();
        test.add(3);
        test.add(44);
        System.out.println(test);
        String test1 = commaSeparated(test);
        System.out.println(test1);

        System.out.println("**********************************************");
        System.out.println("method that returns a list of all strings that start with the letter 'a' (lower case) and have exactly 3 letters.");
        System.out.println("**********************************************");
        List<String> test2 = new ArrayList<>();
        test2.add("amy");
        test2.add("apple");
        test2.add("aby");
        test2.add("jim");
        System.out.println(test2);
        List<String> test3 = filterA(test2);
        System.out.println(test3);

    }

    //method that returns a comma separated string based on a given list of integers.
    public static String commaSeparated(List<Integer> list){
        return list.stream().map(i -> i % 2==0?"e"+i:"o"+i)
                .collect(Collectors.joining(","));
    }

    // method that returns a list of all strings that start with the letter 'a' (lower case) and have exactly 3 letters.
    public static List<String> filterA(List<String> list){
        return list.stream()
                .filter(s -> s.startsWith("a"))
                .filter(s -> s.length() == 3)
                .collect(Collectors.toList());
    }

}