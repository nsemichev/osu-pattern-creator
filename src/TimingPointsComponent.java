import java.util.*;
public class TimingPointsComponent extends BeatmapComponent {
    TimingPointsComponent(String type, List<String> fields){
        super(type);
        for(int i = 0; i < fields.size(); i++){
            this.timingPoints.add(new TimingPoint(fields.get(i)));
        }
        this.startTimePoint = timingPoints.get(0);
        this.endTimePoint = timingPoints.get(timingPoints.size()-1);
    }
    private List<TimingPoint> timingPoints = new ArrayList<TimingPoint>();
    private TimingPoint startTimePoint;
    private TimingPoint endTimePoint;

    public List<TimingPoint> getTimingPoints() {
        return timingPoints;
    }

    public void setTimingPoints(List<TimingPoint> timingPoints) {
        this.timingPoints = timingPoints;
    }

    public TimingPoint getStartTimePoint() {
        return startTimePoint;
    }

    public void setStartTimePoint(TimingPoint startTimePoint) {
        this.startTimePoint = startTimePoint;
    }

    public TimingPoint getEndTimePoint() {
        return endTimePoint;
    }

    public void setEndTimePoint(TimingPoint endTimePoint) {
        this.endTimePoint = endTimePoint;
    }

    public String toString(){
        String finalString = super.toString();
        for(int i = 0; i < timingPoints.size(); i++){
            finalString += "\n" + timingPoints.get(i).toString();
        }
        return finalString;
    }

}
