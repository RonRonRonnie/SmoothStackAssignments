package JavaBasicTwoAssignment;

public class TwoDArray {



    public static void main(String[] args){
        int maxNum=0;
        int temp = 0;
        int [] position = {0,0};


        int [][] arr = new int[10][10];
        for (int i = 0;i<arr.length;i++){
            for(int j = 0;j <arr[i].length;j++){
                arr[i][j] = i+j;
            }
        }

        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                if(arr[i][j]>temp){
                    temp = arr[i][j];
                    maxNum = temp;
                    position[0] = i;
                    position[1] = j;
                }
            }
        }

        System.out.println("The max value of this 2D array is "+maxNum +", and it's position is "+position[0]+" and "+position[1]);

    }
}
