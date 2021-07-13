package JavaBasicFiveAssigment.Assignment2;


import java.util.ArrayList;
import java.util.List;

public class ThreeFunctional {

    public List<Integer> rightDigit(List<Integer> nums) {
        nums.replaceAll(n -> n % 10);
        return nums;
    }

    public List<String> noX(List<String> strings) {
        strings.replaceAll(n -> n.replace("x", ""));
        return strings;
    }

    public List<Integer> doubling(List<Integer> nums) {
        nums.replaceAll(n -> n * 2);
        return nums;
    }


    public static void main(String[] args){
        List<Integer> test1 = new ArrayList<>();
        test1.add(1);
        test1.add(22);
        test1.add(93);
        List<Integer> test2 = new ArrayList<>();
        test2.add(1);
        test2.add(2);
        test2.add(3);
        List<String> test3 = new ArrayList<>();
        test3.add("ax");
        test3.add("bb");
        test3.add("cx");
        System.out.println("Original Lists: ");
        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);
        System.out.println("Lists after edited: ");
        ThreeFunctional threeFunctional = new ThreeFunctional();
        threeFunctional.rightDigit(test1);
        threeFunctional.doubling(test2);
        threeFunctional.noX(test3);
        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);


    }
}
