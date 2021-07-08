package JavaBasicThreeAssignment;

import java.io.File;

public class GetFileList {
    static void RecursivePrint(File[] arr, int index, int level){
        // base case
        if(index == arr.length) return;
        //tabs for internal levels
        for(int i = 0; i< level; i++){
            System.out.print('\t');
        }

        //for files
        if(arr[index].isFile()){
            System.out.println(arr[index].getName());
        }
        // for sub-directories
        else if(arr[index].isDirectory()){
            System.out.println("["+arr[index].getName()+"]");
            // recursion for sub-directories
            RecursivePrint(arr[index].listFiles(),0,level+1);
        }
        // recursion for main directory
        RecursivePrint(arr,++index, level);
    }
    public static void main(String[] args){
        String maindirPath = ".";
        File maindir = new File(maindirPath);
        if(maindir.exists()&&maindir.isDirectory()){
            File [] arr= maindir.listFiles();
            System.out.println("**********************************************");
            System.out.println("Files from main directory : " + maindir);
            System.out.println("**********************************************");

            // Calling recursive method
            RecursivePrint(arr,0,0);

        }

    }
}
