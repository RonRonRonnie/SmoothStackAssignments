package JavaBasicFiveAssigment.Assignment2;

public class Recursion{
    public static boolean ArraySum(int start,int [] arr,int target){
        if(start >= arr.length)
            return target == 0;

        int i = start;
        int sum = 0;

        while(i < arr.length && arr[start] == arr[i]) {
            sum += arr[i];
            i++;
        }

        if(ArraySum(i, arr, target - sum))
            return true;

        return ArraySum(i, arr, target);

    }

    public static void main(String[] args){
        int [] test1 = {2, 4, 8};
        int [] test2 = {1, 2, 4, 8, 1};
        int [] test3 = {2, 4, 4, 8};
        System.out.println(ArraySum(0,test1,10));
        System.out.println(ArraySum(0,test2,14)) ;
        System.out.println(ArraySum(0,test3,14)) ;



    }
}

