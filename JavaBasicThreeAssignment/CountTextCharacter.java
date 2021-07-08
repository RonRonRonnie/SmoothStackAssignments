package JavaBasicThreeAssignment;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CountTextCharacter {
    static int countCharacter(String path,char target) throws FileNotFoundException {
        int count = 0;
        Scanner scanner = new Scanner(new FileReader(path));
        try{
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                for(int i = 0; i<line.length();i++){
                    if(line.charAt(i)==target){
                        count++;
                    }
                }
            }
        }finally {
            scanner.close();
        }

        return count;
    }



    public static void main(String[] args) throws FileNotFoundException {
        int ans = 0;
        //change path to your local path when doing testing
        String path = "/Users/macbook/Downloads/Test.txt";
        System.out.println("Enter the character you want to count: ");
        Scanner scanner = new Scanner(System.in);
        char target = scanner.next().charAt(0);
        ans = countCharacter(path,target);
        if(ans==0){
            System.out.println("the Text doesn't have any "+target);
        }

        System.out.println("Text contains "+ans+" times "+ target);

    }
}

