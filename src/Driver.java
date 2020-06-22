import java.util.Scanner;

public class Driver {
    private static String DIR_PATH = "C:\\Users\\Nikita\\AppData\\Local\\osu!\\Songs\\751896 Cranky - Rave 2 Rave\\";
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter filename: ");
        String filename = sc.nextLine() + DIR_PATH;
        FileReader fileReader = new FileReader();
        fileReader.readFile(filename);

    }
}

