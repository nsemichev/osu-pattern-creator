import java.util.*;
public class GeneralComponent extends BeatmapComponent {
    GeneralComponent(String type, List<String> fields){
        super(type);
        // fields format: key: value
        for(int i = 0; i < fields.size(); i++){
            String[] line = fields.get(i).split(": ");
            switch (line[0]){
                case "AudioFilename":
                    this.AudioFilename = line[1];
                    break;
                case "AudioLeadIn":
                    this.AudioLeadIn = Integer.parseInt(line[1]);
                    break;
                case "PreviewTime":
                    this.PreviewTime = Integer.parseInt(line[1]);
                    break;
                case "Countdown":
                    this.countdown = Integer.parseInt(line[1]);
                    break;
                case "SampleSet":
                    this.SampleSet = line[1];
                    break;
                case "StackLeniency":
                    this.StackLeniency = Double.parseDouble(line[1]);
                    break;
                case "Mode":
                    this.Mode = Integer.parseInt(line[1]);
                    break;
                case "LetterboxInBreaks":
                    this.LetterboxInBreaks = Integer.parseInt(line[1]);
                    break;
                case "UseSkinSprites":
                    this.UseSkinSprites = Integer.parseInt(line[1]);
                    break;
                case "OverlayPosition":
                    this.OverlayPosition = line[1];
                    break;
                case "SkinPreference":
                    this.SkinPreference = line[1];
                    break;
                case "EpilepsyWarning":
                    this.EpilepsyWarning= Integer.parseInt(line[1]);
                    break;
                case "CountdownOffset":
                    this.CountdownOffset = Integer.parseInt(line[1]);
                    break;
                case "SpecialStyle":
                    this.SpecialStyle = Integer.parseInt(line[1]);
                    break;
                case "WidescreenStoryboard":
                    this.WidescreenStoryboard = Integer.parseInt(line[1]);
                    break;
                case "SamplesMatchPlaybackRate":
                    this.SamplesMatchPlaybackRate = Integer.parseInt(line[1]);
                    break;
                default:
                    System.out.println("Invalid attribute in [General]");
                    System.out.println("Skipping " + line[0]);
            }
        }
    }

    private String AudioFilename="";
    private int AudioLeadIn=0;
    private int PreviewTime=-1;
    private int countdown=1;
    private String SampleSet="Normal";
    private double StackLeniency=0.7;
    private int Mode=0;
    private int LetterboxInBreaks=0;
    private int UseSkinSprites=0;
    private String OverlayPosition="NoChange";
    private String SkinPreference="";
    private int EpilepsyWarning=0;
    private int CountdownOffset=0;
    private int SpecialStyle=0;
    private int WidescreenStoryboard=0;
    private int SamplesMatchPlaybackRate=0;

    public String getAudioFilename() {
        return AudioFilename;
    }

    public void setAudioFilename(String audioFilename) {
        AudioFilename = audioFilename;
    }

    public int getAudioLeadIn() {
        return AudioLeadIn;
    }

    public void setAudioLeadIn(int audioLeadIn) {
        AudioLeadIn = audioLeadIn;
    }

    public int getPreviewTime() {
        return PreviewTime;
    }

    public void setPreviewTime(int previewTime) {
        PreviewTime = previewTime;
    }

    public int getCountdown() {
        return countdown;
    }

    public void setCountdown(int countdown) {
        this.countdown = countdown;
    }

    public String getSampleSet() {
        return SampleSet;
    }

    public void setSampleSet(String sampleSet) {
        SampleSet = sampleSet;
    }

    public double getStackLeniency() {
        return StackLeniency;
    }

    public void setStackLeniency(double stackLeniency) {
        StackLeniency = stackLeniency;
    }

    public int getMode() {
        return Mode;
    }

    public void setMode(int mode) {
        Mode = mode;
    }

    public int getLetterboxInBreaks() {
        return LetterboxInBreaks;
    }

    public void setLetterboxInBreaks(int letterboxInBreaks) {
        LetterboxInBreaks = letterboxInBreaks;
    }

    public int getUseSkinSprites() {
        return UseSkinSprites;
    }

    public void setUseSkinSprites(int useSkinSprites) {
        UseSkinSprites = useSkinSprites;
    }

    public String getOverlayPosition() {
        return OverlayPosition;
    }

    public void setOverlayPosition(String overlayPosition) {
        OverlayPosition = overlayPosition;
    }

    public String getSkinPreference() {
        return SkinPreference;
    }

    public void setSkinPreference(String skinPreference) {
        SkinPreference = skinPreference;
    }

    public int getEpilepsyWarning() {
        return EpilepsyWarning;
    }

    public void setEpilepsyWarning(int epilepsyWarning) {
        EpilepsyWarning = epilepsyWarning;
    }

    public int getCountdownOffset() {
        return CountdownOffset;
    }

    public void setCountdownOffset(int countdownOffset) {
        CountdownOffset = countdownOffset;
    }

    public int getSpecialStyle() {
        return SpecialStyle;
    }

    public void setSpecialStyle(int specialStyle) {
        SpecialStyle = specialStyle;
    }

    public int getWidescreenStoryboard() {
        return WidescreenStoryboard;
    }

    public void setWidescreenStoryboard(int widescreenStoryboard) {
        WidescreenStoryboard = widescreenStoryboard;
    }

    public int getSamplesMatchPlaybackRate() {
        return SamplesMatchPlaybackRate;
    }

    public void setSamplesMatchPlaybackRate(int samplesMatchPlaybackRate) {
        SamplesMatchPlaybackRate = samplesMatchPlaybackRate;
    }

    public String toString(){
        String finalString = super.toString();
        finalString += "\n" + "AudioFileName: " + AudioFilename;
        finalString += "\n" + "AudioLeadIn: " + AudioLeadIn;
        finalString += "\n" + "PreviewTime: " + PreviewTime;
        finalString += "\n" + "Countdown: " + countdown;
        finalString += "\n" + "SampleSet: " + SampleSet;
        finalString += "\n" + "StackLeniency: " + StackLeniency;
        finalString += "\n" + "Mode: " + Mode;
        finalString += "\n" + "LetterboxInBreaks: " + LetterboxInBreaks;
        finalString += "\n" + "UseSkinSprites: " + UseSkinSprites;
        finalString += "\n" + "OverlayPosition: " + OverlayPosition;
        finalString += "\n" + "SkinPreference: " + SkinPreference;
        finalString += "\n" + "EpilepsyWarning: " + EpilepsyWarning;
        finalString += "\n" + "CountdownOffset: " + CountdownOffset;
        finalString += "\n" + "SpecialStyle: " + SpecialStyle;
        finalString += "\n" + "WidescreenStoryboard: " + WidescreenStoryboard;
        finalString += "\n" + "SamplesMatchPlaybackRate: " + SamplesMatchPlaybackRate;
        return finalString;
    }
}
