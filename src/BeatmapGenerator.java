import java.util.*;
public class BeatmapGenerator {
    BeatmapGenerator(Song song){
        this.songBPM = song.getBPM();
        this.halfTick = 60000 / (2 * this.songBPM);
        this.quarterTick = 60000 / (4 * this.songBPM);
        this.startTimePoint = song.getStartTimePoint();
        this.endTimePoint = song.getEndTimePoint();
    }
    private int max_x = 512;
    private int max_y = 384;
    private float songBPM;
    private float halfTick;
    private float quarterTick;
    private float startTimePoint;
    private float endTimePoint;

    public String generateBeatmap(String type){
        if(type.contains("RS")){
            return randomStack(Integer.parseInt(type.substring(2)));
        }

        else {
            System.out.println("Unrecognized type.");
            System.exit(0);
        }
        return "";
    }

    private String randomStack(int num){
        float curTime = startTimePoint;
        String objects = "[HitObjects]\n";
        while(curTime < endTimePoint){
            //if(curTime + halfTick + (num - 1) * quarterTick > endTimePoint) break;
            float[] timings = generateTimingPattern(curTime, num);
            Random random = new Random();
            int x_coord = random.nextInt(max_x+1);
            int y_coord = random.nextInt(max_y+1);
            for(int i = 0; i < num; i++){
                objects += String.valueOf(x_coord) + "," + String.valueOf(y_coord) + "," + String.valueOf((int) timings[i]) + ",1,0" + "\n";
            }
            curTime += halfTick + (num - 1) * quarterTick;
        }
        return objects;
    }

    private float[] generateTimingPattern(float curTime, int num){
        float[] timings = new float[num];
        timings[0] = curTime + halfTick;
        for(int i = 1; i < num; i++){
            timings[i] = timings[i-1] + quarterTick;
        }
        return timings;
    }
}

