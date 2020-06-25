import java.util.*;
public class DifficultyComponent extends BeatmapComponent{
    DifficultyComponent(String type, List<String> fields){
        super(type);
        // fields format : key:value
        for(int i = 0; i < fields.size(); i++) {
            String[] line = fields.get(i).split(":");
            switch (line[0]) {
                case "HPDrainRate":
                    this.HPDrainRate = Double.parseDouble(line[1]);
                    break;
                case "CircleSize":
                    this.CircleSize = Double.parseDouble(line[1]);
                    break;
                case "OverallDifficulty":
                    this.OverallDifficulty = Double.parseDouble(line[1]);
                    break;
                case "ApproachRate":
                    this.ApproachRate = Double.parseDouble(line[1]);
                    break;
                case "SliderMultiplier":
                    this.SliderMultiplier = Double.parseDouble(line[1]);
                    break;
                case "SliderTickRate":
                    this.SliderTickRate = Double.parseDouble(line[1]);
                    break;
                default:
                    System.out.println("Invalid attribute in [Difficulty]");
                    System.out.println("Skipping " + line[0]);
            }
        }
    }
    private double HPDrainRate=0;
    private double CircleSize=0;
    private double OverallDifficulty=0;
    private double ApproachRate=0;
    private double SliderMultiplier=0;
    private double SliderTickRate=0;

    public double getHPDrainRate() {
        return HPDrainRate;
    }

    public void setHPDrainRate(double HPDrainRate) {
        this.HPDrainRate = HPDrainRate;
    }

    public double getCircleSize() {
        return CircleSize;
    }

    public void setCircleSize(double circleSize) {
        CircleSize = circleSize;
    }

    public double getOverallDifficulty() {
        return OverallDifficulty;
    }

    public void setOverallDifficulty(double overallDifficulty) {
        OverallDifficulty = overallDifficulty;
    }

    public double getApproachRate() {
        return ApproachRate;
    }

    public void setApproachRate(double approachRate) {
        ApproachRate = approachRate;
    }

    public double getSliderMultiplier() {
        return SliderMultiplier;
    }

    public void setSliderMultiplier(double sliderMultiplier) {
        SliderMultiplier = sliderMultiplier;
    }

    public double getSliderTickRate() {
        return SliderTickRate;
    }

    public void setSliderTickRate(double sliderTickRate) {
        SliderTickRate = sliderTickRate;
    }

    public String toString(){
        String finalString = super.toString();
        finalString += "\n" + "HPDrainRate:" + HPDrainRate;
        finalString += "\n" + "CircleSize:" + CircleSize;
        finalString += "\n" + "OverallDifficulty:" + OverallDifficulty;
        finalString += "\n" + "ApproachRate:" + ApproachRate;
        finalString += "\n" + "SliderMultiplier:" + SliderMultiplier;
        finalString += "\n" + "SliderTickRate:" + SliderTickRate;
        return finalString;
    }
}
