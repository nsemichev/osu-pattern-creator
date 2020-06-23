import java.util.*;
public class Song {
    Song(String format, String general, String editor, String metadata, String difficulty, String events, String timingPoints, String colors, String objects){
        this.format = format;
        this.general = general;
        this.editor = editor;
        this.metadata = metadata;
        this.difficulty = difficulty;
        this.events = events;
        this.timingPoints = timingPoints;
        this.colors = colors;
        this.objects = objects;
        this.BPM = findBPM(this.timingPoints);
        this.startTimePoint = findStartTimePoint(this.timingPoints);
        this.endTimePoint = findEndTimePoint(this.timingPoints);


    }

    private float findStartTimePoint(String timingPoints) {
        String[] timings = timingPoints.split("\n");
        return Float.parseFloat(timings[1].split(",")[0]);
    }

    private float findEndTimePoint(String timingPoints) {
        String[] timings = timingPoints.split("\n");
        return Float.parseFloat(timings[timings.length-1].split(",")[0]);
    }

    // Format
    private String format;

    // General
    private String general;

    private String AudioFilename;
    private int AudioLeadIn;
    private int PreviewTime;
    private int countdown;
    private String SampleSet;
    private float StackLeniency;
    private int Mode;
    private int LetterboxInBreaks;

    private int UseSkinSprites;
    private String OverlayPosition;
    private String SkinPreference;
    private int EpilepsyWarning;
    private int CountdownOffset;
    private int SpecialStyle;
    private int WidescreenStoryboard;
    private int SamplesMatchPlaybackRate;

    // Editor
    private String editor;

    private String Bookmarks;
    private float DistanceSpacing;
    private float BeatDivisor;
    private int GridSize;
    private float TimelineZoom;

    // Metadata
    private String metadata;

    private String Title;
    private String TitleUnicode;
    private String Artist;
    private String ArtistUnicode;
    private String Creator;
    private String Version;
    private String Source;
    private String Tags;
    private int BeatmapID;
    private int BeatmapSetID;

    // Difficulty
    private String difficulty;

    private float HPDrainRate;
    private float CircleSize;
    private float OverallDifficulty;
    private float ApproachRate;
    private float SliderMultiplier;
    private float SliderTickRate;

    // Events

    private String[] events;

    private String background_video;

    // Timing Points
    private String timingPoints;

    private float startTimePoint;
    private float endTimePoint;

    // Colors

    private String colors;

    // Hit objects

    private String objects;

    private float BPM;

    public float findBPM(String timingPoints){
        Map<Float, Integer> map = new HashMap<>();
        String[] lines = timingPoints.split("\n");
        float lastBpmUnit = -1;
        for(int i = 1; i < lines.length; i++){
            String[] timingVals = lines[i].split(",");
            float bpmUnit = Float.parseFloat(timingVals[1]);
            if(bpmUnit > 0){
                if(map.containsKey(bpmUnit)){
                    map.replace(bpmUnit, map.get(bpmUnit) + 1);
                }
                else {
                    map.put(bpmUnit, 1);
                }
                lastBpmUnit = bpmUnit;
            }
            else{
                try{
                    map.replace(lastBpmUnit, map.get(lastBpmUnit) + 1);
                } catch (Exception e){
                    System.out.println("Error in timing section of beatmap file.");
                    e.printStackTrace();
                    System.exit(0);
                }

            }

        }

        int maxValueInMap = Collections.max(map.values());
        float mostCommonBpmUnit = 0;
        for (Map.Entry<Float, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                mostCommonBpmUnit = entry.getKey();
            }
        }

        return (float) (60000.0 / mostCommonBpmUnit);

    }

    public String getFormat(){
        return format;
    }

    public String getGeneral(){
        return general;
    }

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

    public float getBPM(){
        return BPM;
    }

    public float getStartTimePoint(){
        return startTimePoint;
    }

    public float getEndTimePoint(){
        return endTimePoint;
    }

}
