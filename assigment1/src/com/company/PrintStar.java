package com.company;

class PrintStar{
    public void pattern1() {
        System.out.println("1)");
        for (int i = 1; i <= 4; i++) {
            for(int j = 1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println(".........");
    }

    public void pattern2(){
        System.out.println("2)");
        System.out.println(".........");
        for(int i = 4; i>=1;i--){
            for(int j = 1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void pattern3(){
        System.out.println("3)");
        int row = 4;
        int space = row - 1;
        for(int i = 1;i<=row;i++){
            for(int j = 1;j<=space;j++){
                System.out.print(" ");
            }
            space--;
            for(int j = 1; j<=2*i-1; j++ ){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("...........");
    }

    public void pattern4(){
        System.out.println("4)");
        System.out.println("...........");
        for(int i = 4; i>=1;i--){

            for(int j = i; j<4;j++ ){
                System.out.print(" ");
            }

            for(int j = 1;j<=2*i-1;j++){
                System.out.print("*");
            }

            System.out.println();
        }

    }

}

class Main {

    public static void main(String[] args) {
    PrintStar printStar = new PrintStar();
    printStar.pattern1();
    printStar.pattern2();
    printStar.pattern3();
    printStar.pattern4();
    }
}
