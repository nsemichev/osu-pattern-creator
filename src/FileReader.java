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
            while (sc.hasNextLine()) {
                String next = sc.nextLine();
                if(next.startsWith("//")) continue;
                else text += next + "\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File was not found.");
            System.exit(0);
        }
        return extractSongParameters(text);
    }

    public Song extractSongParameters(String file_text){
        String[] lines = file_text.split("\n\n");
        if(lines.length != 9){
            System.out.println("Invalid beatmap format.");
            System.exit(0);
        }
        return new Song(lines[0], lines[1], lines[2], lines[3], lines[4], lines[5], lines[6], lines[7], lines[8]);
    }

    public int writeFile(String filename, Song song){
        // Create new file
        File file = new File(filename);
        try{
            file.createNewFile();
        } catch(IOException e) {
            System.out.println("Error occured while creating a new file.");
            System.exit(0);
        }
        // Fill all the required parts in the file
        try{
            FileWriter writer = new FileWriter(filename);
            writer.write(song.toString());
            writer.close();
            System.out.println("Wrote file successfully.");
        } catch(IOException e) {
            System.out.println("Error occurred while writing to a file.");
            e.printStackTrace();
            System.exit(0);
        }

        return 0;
    }
}
