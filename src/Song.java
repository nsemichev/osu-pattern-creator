import java.util.*;

public class Song {
    Song(String format, String general, String editor, String metadata, String difficulty, String events, String timingPoints, String colors, String objects){
        this.format = format;

        this.beatmapComponents = new BeatmapComponent[8];

        List<String> generalLines = Arrays.asList(general.split("\n"));
        this.beatmapComponents[0] = new GeneralComponent(generalLines.get(0), generalLines.subList(1, generalLines.size()));

        List<String> editorLines = Arrays.asList(editor.split("\n"));
        this.beatmapComponents[1] = new EditorComponent(editorLines.get(0), editorLines.subList(1, editorLines.size()));

        List<String> metadataLines = Arrays.asList(metadata.split("\n"));
        this.beatmapComponents[2] = new MetadataComponent(metadataLines.get(0), metadataLines.subList(1, metadataLines.size()));

        List<String> difficultyLines = Arrays.asList(difficulty.split("\n"));
        this.beatmapComponents[3] = new DifficultyComponent(difficultyLines.get(0), difficultyLines.subList(1, difficultyLines.size()));

        List<String> eventLines = Arrays.asList(events.split("\n"));
        this.beatmapComponents[4] = new EventComponent(eventLines.get(0), eventLines.subList(1, eventLines.size()));

        List<String> timingPointLines = Arrays.asList(timingPoints.split("\n"));
        this.beatmapComponents[5] = new TimingPointsComponent(timingPointLines.get(0), timingPointLines.subList(1, timingPointLines.size()));

        List<String> colorLines = Arrays.asList(colors.split("\n"));
        this.beatmapComponents[6] = new ColorsComponent(colorLines.get(0), colorLines.subList(1, colorLines.size()));

        List<String> hitObjectLines = Arrays.asList(objects.split("n"));
        this.beatmapComponents[7] = new HitObjectsComponent(hitObjectLines.get(0), hitObjectLines.subList(1, hitObjectLines.size()));

        this.BPM = Util.findBPM(((TimingPointsComponent) this.beatmapComponents[5]).getTimingPoints());
        this.startTimePoint = ((TimingPointsComponent) this.beatmapComponents[5]).getStartTimePoint().getTime();
        this.endTimePoint = ((TimingPointsComponent) this.beatmapComponents[5]).getEndTimePoint().getTime();


    }

    // Format
    private String format;

    private BeatmapComponent[] beatmapComponents;

    private double BPM;
    private int startTimePoint;
    private int endTimePoint;

    public String getFormat(){
        return format;
    }

    public BeatmapComponent[] getBeatmapComponents(){
        return beatmapComponents;
    }

    /*
    public String getEditor(){
        return editor;
    }

    public String getMetadata(){
        return metadata;
    }

    public String getDifficulty(){
        return difficulty;
    }

    public String getEvents(){
        return events;
    }

    public String getTimingPoints(){
        return timingPoints;
    }

    public String getColors(){
        return colors;
    }

    public String getObjects(){
        return objects;
    }

    public void setFormat(String format){
        this.format = format;
    }

    public void setGeneral(String general){
        this.general = general;
    }

    public void setEditor(String editor){
        this.editor = editor;
    }

    public void setMetadata(String metadata){
        this.metadata = metadata;
    }

    public void setDifficulty(String difficulty){
        this.difficulty = difficulty;
    }

    public void setEvents(String events){
        this.events = events;
    }

    public void setTimingPoints(String timingPoints){
        this.timingPoints = timingPoints;
    }

    public void setColors(String colors){
        this.colors = colors;
    }

    public void setObjects(String objects){
        this.objects = objects;
    }
    */

    public double getBPM(){
        return BPM;
    }

    public double getStartTimePoint(){
        return startTimePoint;
    }

    public double getEndTimePoint(){
        return endTimePoint;
    }

    public String toString(){
        String finalString = format;
        for(int i = 0; i < 8; i++){
            finalString += "\n\n" + beatmapComponents[i].toString();
        }
        return finalString;
    }

}
