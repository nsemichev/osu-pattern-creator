import java.util.Scanner;

public class Driver {
    //private static String DIR_PATH = "C:\\Users\\Nikita\\AppData\\Local\\osu!\\Songs\\11742 Rossini & MC F 40 - Guillaume Tell\\Rossini & MC F 40 - Guillaume Tell (Sushi971) [Heavy].osu";
    private static String DIR_PATH = "/Applications/osu!.app/Contents/Resources/drive_c/osu!/Songs/558694 xi - Glorious Crown/xi - Glorious Crown (Monstrata) [FOUR DIMENSIONS].osu";
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        //System.out.print("Enter filename: ");
        String filename = DIR_PATH; // + sc.nextline();
        System.out.println("Enter configuration: PatternType|HP,CS,OD,AR|DifficultyName");
        String config = sc.nextLine();
        System.out.println("Enter new difficulty name: ");
        String diffName = sc.nextLine();

        FileReader fileReader = new FileReader();
        Song song = fileReader.readFile(filename);
        if(song != null){
            System.out.println(song.getBPM());
        }
        else{
            System.out.println("Couldn't read the file.");
            System.exit(0);
        }

        BeatmapGenerator bg = new BeatmapGenerator(song);
        BeatmapComponent[] songComponents = song.getBeatmapComponents();
        HitObjectsComponent hitObjectsComponent = (HitObjectsComponent) songComponents[7];
        hitObjectsComponent.setHitObjects(bg.generateBeatmap(config));

        //fileReader.writeFile(String.format("C:\\Users\\Nikita\\AppData\\Local\\osu!\\Songs\\11742 Rossini & MC F 40 - Guillaume Tell\\Rossini & MC F 40 - Guillaume Tell (Sushi971) [%s].osu", diffName), song);
        fileReader.writeFile(String.format("/Applications/osu!.app/Contents/Resources/drive_c/osu!/Songs/558694 xi - Glorious Crown/xi - Glorious Crown (Monstrata) [%s].osu", diffName), song);

    }
}

