public class TimingPoint {
    TimingPoint(String timingPoint){
        String[] params = timingPoint.split(",");
        this.time = Integer.parseInt(params[0]);
        this.beatLength = Double.parseDouble(params[1]);
        this.meter = Integer.parseInt(params[2]);
        this.sampleSet = Integer.parseInt(params[3]);
        this.sampleIndex = Integer.parseInt(params[4]);
        this.volume = Integer.parseInt(params[5]);
        this.uninherited = Integer.parseInt(params[6]);
        this.effects = Integer.parseInt(params[7]);
    }
    private int time;
    private double beatLength;
    private int meter;
    private int sampleSet;
    private int sampleIndex;
    private int volume;
    private int uninherited;
    private int effects;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getBeatLength() {
        return beatLength;
    }

    public void setBeatLength(double beatLength) {
        this.beatLength = beatLength;
    }

    public int getMeter() {
        return meter;
    }

    public void setMeter(int meter) {
        this.meter = meter;
    }

    public int getSampleSet() {
        return sampleSet;
    }

    public void setSampleSet(int sampleSet) {
        this.sampleSet = sampleSet;
    }

    public int getSampleIndex() {
        return sampleIndex;
    }

    public void setSampleIndex(int sampleIndex) {
        this.sampleIndex = sampleIndex;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getUninherited() {
        return uninherited;
    }

    public void setUninherited(int uninherited) {
        this.uninherited = uninherited;
    }

    public int getEffects() {
        return effects;
    }

    public void setEffects(int effects) {
        this.effects = effects;
    }

    public String toString(){
        return time + "," + beatLength + "," + meter + "," + sampleSet + "," + sampleIndex + "," + volume + "," + uninherited + "," + effects;
    }
}
