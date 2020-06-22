import java.io.*;
import java.util.Scanner;
public class FileReader {
    FileReader(){

    }

    public Song readFile(String filename){
        String text = "";
        try{
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine())
                text += sc.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return extractSongParameters(text);
    }

    public Song extractSongParameters(String file_text){

        return null;
    }

    public int writeFile(String filename){
        return 0;
    }
}
