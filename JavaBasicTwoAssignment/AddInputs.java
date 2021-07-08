package JavaBasicTwoAssignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddInputs {

    static boolean isNumber(String s){

        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static boolean isDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args){
        double sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter multiple values to add(Q to exit): ");
        List<String> list = new ArrayList<String>();

        while (scanner.hasNext()){

                String num = scanner.next();
                if(isNumber(num)||isDouble(num)){
                    list.add(num);
                }
                else if(num.equals("Q")||num.equals("q")){
                    break;
                }

                }
        for(String d:list){
            double value = Double.parseDouble(d);
            sum += value;
        }
        System.out.println("The valid values inputs are "+list+". The sum of them are "+sum);
        }

    }
