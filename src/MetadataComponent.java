import java.util.*;
public class MetadataComponent extends BeatmapComponent {
   MetadataComponent(String type, List<String> fields){
       super(type);
       // fields format : key:value
       for(int i = 0; i < fields.size(); i++) {
           String[] line = fields.get(i).split(":");
           switch (line[0]) {
               case "Title":
                   this.Title = line[1];
                   break;
               case "TitleUnicode":
                   this.TitleUnicode = line[1];
                   break;
               case "Artist":
                   this.Artist = line[1];
                   break;
               case "ArtistUnicode":
                   this.ArtistUnicode = line[1];
                   break;
               case "Creator":
                   this.Creator = line[1];
                   break;
               case "Version":
                   this.Version = line[1];
                   break;
               case "Source":
                   this.Source = line[1];
                   break;
               case "Tags":
                   this.Tags = line[1];
                   break;
               case "BeatmapID":
                   this.BeatmapID = Integer.parseInt(line[1]);
                   break;
               case "BeatmapSetID":
                   this.BeatmapSetID = Integer.parseInt(line[1]);
                   break;
               default:
                   System.out.println("Invalid attribute in [Metadata]");
                   System.out.println("Skipping " + line[0]);
           }
       }
    }
    private String Title="";
    private String TitleUnicode="";
    private String Artist="";
    private String ArtistUnicode="";
    private String Creator="";
    private String Version="";
    private String Source="";
    private String Tags="";
    private int BeatmapID=0;
    private int BeatmapSetID=0;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTitleUnicode() {
        return TitleUnicode;
    }

    public void setTitleUnicode(String titleUnicode) {
        TitleUnicode = titleUnicode;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public String getArtistUnicode() {
        return ArtistUnicode;
    }

    public void setArtistUnicode(String artistUnicode) {
        ArtistUnicode = artistUnicode;
    }

    public String getCreator() {
        return Creator;
    }

    public void setCreator(String creator) {
        Creator = creator;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getTags() {
        return Tags;
    }

    public void setTags(String tags) {
        Tags = tags;
    }

    public int getBeatmapID() {
        return BeatmapID;
    }

    public void setBeatmapID(int beatmapID) {
        BeatmapID = beatmapID;
    }

    public int getBeatmapSetID() {
        return BeatmapSetID;
    }

    public void setBeatmapSetID(int beatmapSetID) {
        BeatmapSetID = beatmapSetID;
    }

    public String toString(){
        String finalString = super.toString();
        finalString += "\n" + "Title:" + Title;
        finalString += "\n" + "TitleUnicode:" + TitleUnicode;
        finalString += "\n" + "Artist:" + Artist;
        finalString += "\n" + "ArtistUnicode:" + ArtistUnicode;
        finalString += "\n" + "Creator:" + Creator;
        finalString += "\n" + "Version:" + Version;
        finalString += "\n" + "Source:" + Source;
        finalString += "\n" + "Tags:" + Tags;
        finalString += "\n" + "BeatmapID:" + BeatmapID;
        finalString += "\n" + "BeatmapSetID:" + BeatmapSetID;
        return finalString;
    }
}
