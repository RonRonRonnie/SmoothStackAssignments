package JavaBasicFiveAssigment.Assignment2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

interface PerformOperation {
    boolean check(int a);
}
class Math {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public static PerformOperation isOdd(){
        return a -> a % 2 != 0;
    }

    public static PerformOperation isPrime(){
        return a ->{ for (int i = 2; i * i <= a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
            return true;
        };
    }

    public static PerformOperation isPalindrome() {
        return a -> a == Integer.parseInt(new StringBuilder(String.valueOf(a)).reverse().toString());
    }
}
class Lambdas {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret;
        String ans = null;
        while (T--> 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = Math.isOdd();
                ret = Math.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = Math.isPrime();
                ret = Math.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = Math.isPalindrome();
                ret = Math.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}
