import java.awt.print.Book;
import java.util.*;
public class EditorComponent extends BeatmapComponent {
    EditorComponent(String type, List<String> fields){
        super(type);
        // fields format: key: value
        for(int i = 0; i < fields.size(); i++) {
            String[] line = fields.get(i).split(": ");
            switch (line[0]) {
                case "Bookmarks":
                    this.Bookmarks = line[1];
                    break;
                case "DistanceSpacing":
                    this.DistanceSpacing = Double.parseDouble(line[1]);
                    break;
                case "BeatDivisor":
                    this.BeatDivisor = Double.parseDouble(line[1]);
                    break;
                case "GridSize":
                    this.GridSize = Integer.parseInt(line[1]);
                    break;
                case "TimelineZoom":
                    this.TimelineZoom = Double.parseDouble(line[1]);
                    break;
                default:
                    System.out.println("Invalid attribute in [Editor]");
                    System.out.println("Skipping " + line[0]);
            }
        }
    }

    private String Bookmarks="";
    private double DistanceSpacing=0;
    private double BeatDivisor=0;
    private int GridSize=0;
    private double TimelineZoom=0;

    public String getBookmarks() {
        return Bookmarks;
    }

    public void setBookmarks(String bookmarks) {
        Bookmarks = bookmarks;
    }

    public double getDistanceSpacing() {
        return DistanceSpacing;
    }

    public void setDistanceSpacing(double distanceSpacing) {
        DistanceSpacing = distanceSpacing;
    }

    public double getBeatDivisor() {
        return BeatDivisor;
    }

    public void setBeatDivisor(double beatDivisor) {
        BeatDivisor = beatDivisor;
    }

    public int getGridSize() {
        return GridSize;
    }

    public void setGridSize(int gridSize) {
        GridSize = gridSize;
    }

    public double getTimelineZoom() {
        return TimelineZoom;
    }

    public void setTimelineZoom(double timelineZoom) {
        TimelineZoom = timelineZoom;
    }

    public String toString(){
        String finalString = super.toString();
        finalString += "\n" + "Bookmarks: " + Bookmarks;
        finalString += "\n" + "DistanceSpacing: " + DistanceSpacing;
        finalString += "\n" + "BeatDivisor: " + BeatDivisor;
        finalString += "\n" + "GridSize: " + GridSize;
        finalString += "\n" + "TimelineZoom: " + TimelineZoom;
        return finalString;
    }
}
