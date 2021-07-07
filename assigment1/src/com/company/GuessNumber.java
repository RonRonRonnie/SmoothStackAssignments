package com.company;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args){
        int chances = 5;
        int min = 1;
        int max = 100;
        int guess;
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        int ans = min + random.nextInt(max-min+1);
        //
        while(chances > 0){
            System.out.println(
                    "Guess a number between 1 and 100: ");
            guess = in.nextInt();

            if(((guess+10==ans)&&(ans-guess<=10))||((guess-10==ans)&&(guess-ans<=10))||guess==ans){
                System.out.println(ans);
                break;
            }else{
                chances --;
                if(chances==0){
                    break;
                }
                System.out.print("keep guessing, ");

            }
        }
        if(chances == 0){
            System.out.println("Sorry,correct answer is "+ans);
        }

    }
}
