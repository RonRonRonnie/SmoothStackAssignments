package JavaBasicThreeAssignment;

import java.io.FileWriter;
import java.io.IOException;

public class AppendTextToFile {
    public static void main(String[] args){
        String path = System.getProperty("user.dir")+"\\src\\test.txt";
        String text = "Added Text";

        try{
            FileWriter fw = new FileWriter(path,true);
            fw.write(text);
            fw.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
