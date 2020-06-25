import java.util.*;
public class BeatmapGenerator {
    BeatmapGenerator(Song song){
        this.song = song;
        this.songBPM = song.getBPM();
        this.halfTick = 60000 / (2 * this.songBPM);
        this.quarterTick = 60000 / (4 * this.songBPM);
        this.startTimePoint = song.getStartTimePoint();
        this.endTimePoint = song.getEndTimePoint();
    }

    private final int max_x = 512;
    private final int max_y = 384;

    private Song song;
    private double songBPM;
    private double halfTick;
    private double quarterTick;
    private double startTimePoint;
    private double endTimePoint;

    private int linearStackSpacing = 10;

    public List<HitObject> generateBeatmap(String config){
        String[] configParts = config.split("\\|");
        String[] typeParts = configParts[0].split(",");
        String[] difficultyOverride = configParts[1].split(",");
        String difficultyName = configParts[2];
        setDifficulty(difficultyOverride);
        setDifficultyName(difficultyName);

        if(typeParts[0].equals("RS")){
            return randomStack(Integer.parseInt(typeParts[1]), Integer.parseInt(typeParts[2]), typeParts[3]);
        }
        else {
            System.out.println("Unrecognized type.");
            System.exit(0);
        }
        return null;
    }

    private void setDifficultyName(String name){
        BeatmapComponent[] songComponents = song.getBeatmapComponents();
        MetadataComponent metadataComponent = (MetadataComponent) songComponents[2];
        metadataComponent.setVersion(name);
    }

    private void setDifficulty(String[] difficulty){
        BeatmapComponent[] songComponents = song.getBeatmapComponents();
        DifficultyComponent difficultyComponent = (DifficultyComponent) songComponents[3];
        difficultyComponent.setHPDrainRate(Double.parseDouble(difficulty[0]));
        difficultyComponent.setCircleSize(Double.parseDouble(difficulty[1]));
        difficultyComponent.setOverallDifficulty(Double.parseDouble(difficulty[2]));
        difficultyComponent.setApproachRate(Double.parseDouble(difficulty[3]));
    }

    private List<HitObject> randomStack(int num, int spacing, String type) {
        double curTime = startTimePoint;
        List<HitObject> hitObjects = new ArrayList<HitObject>();
        //String objects = "[HitObjects]\n";
        int curCombo = 0;
        while(curTime < endTimePoint){
            //if(curTime + halfTick + (num - 1) * quarterTick > endTimePoint) break;
            double[] timings = generateTimingPattern(curTime, num);
            if(type.equals("normal")) {
                Random random = new Random();
                int x_coord = random.nextInt(max_x - 20) + 10;
                int y_coord = random.nextInt(max_y - 20) + 10;
                for (int i = 0; i < num; i++) {
                    if (i == 0 && curCombo + num > 16) {
                        hitObjects.add(new HitCircle(x_coord, y_coord, (int) timings[i], 5, 0,"", ""));
                        //objects += String.valueOf(x_coord) + "," + String.valueOf(y_coord) + "," + String.valueOf((int) timings[i]) + ",5,0" + "\n";
                        curCombo = 0;
                    } else hitObjects.add(new HitCircle(x_coord, y_coord, (int) timings[i], 1, 0,"", ""));
                    //objects += String.valueOf(x_coord) + "," + String.valueOf(y_coord) + "," + String.valueOf((int) timings[i]) + ",1,0" + "\n";
                }
            }
            else if(type.equals("linear")) {
                return linearStack(num, spacing);
            }
            else{
                System.out.println("Invalid type: " + type);
            }
            curTime += halfTick + (num - 1) * quarterTick;
            curCombo += num;
        }
        return hitObjects;
    }

    private List<HitObject> linearStack(int num, int spacing){
        List<HitObject> hitObjects = new ArrayList<HitObject>();
        Random random = new Random();
        int start_x = random.nextInt(max_x-20)+10;
        int start_y = random.nextInt(max_y-20)+10;
        double curTime = startTimePoint;
        //String objects = "[HitObjects]\n";
        int lastDir = 0; // -1 = N -2 = E 1 = S 2 = W
        int cur_x = start_x;
        int cur_y = start_y;
        int curCombo = 0;
        while(curTime < endTimePoint){
            int randNum = random.nextInt(num) + 1;
            if (randNum % 2 == 0) randNum += 1;
            //if(curTime + halfTick + (num - 1) * quarterTick > endTimePoint) break;
            double[] timings = generateTimingPattern(curTime, randNum);
            int[] x_coords = new int[randNum];
            int[] y_coords = new int[randNum];

            int nextDir = chooseDir(lastDir, spacing, cur_x, cur_y, randNum);

            int incrX = 0;
            int incrY = 0;

            if(nextDir == -2){
                cur_x += spacing;
                incrX = 1;
            }
            else if (nextDir == -1){
                cur_y -= spacing;
                incrY = -1;
            }
            else if (nextDir == 1){
                cur_y += spacing;
                incrY = 1;
            }
            else {
                cur_x -= spacing;
                incrX = -1;
            }

            x_coords[0] = cur_x;
            y_coords[0] = cur_y;

            for(int i = 1; i < randNum; i++){
                x_coords[i] = x_coords[i-1] + incrX * linearStackSpacing;
                y_coords[i] = y_coords[i-1] + incrY * linearStackSpacing;
            }

            for(int i = 0; i < randNum; i++){
                if(i == 0 && curCombo + randNum > 16) {
                    //objects += String.valueOf(x_coords[i]) + "," + String.valueOf(y_coords[i]) + "," + String.valueOf((int) timings[i]) + ",5,0" + "\n";
                    hitObjects.add(new HitCircle(x_coords[i], y_coords[i], (int) timings[i], 5, 0, "", ""));
                    curCombo = 0;
                }
                else hitObjects.add(new HitCircle(x_coords[i], y_coords[i], (int) timings[i], 1, 0, "", ""));
                //else objects += String.valueOf(x_coords[i]) + "," + String.valueOf(y_coords[i]) + "," + String.valueOf((int) timings[i]) + ",1,0" + "\n";
            }

            curTime += halfTick + (randNum - 1) * quarterTick;
            lastDir = nextDir;
            cur_x = x_coords[randNum-1];
            cur_y = y_coords[randNum-1];
            curCombo += randNum;
        }
        return hitObjects;
    }

    private int chooseDir(int lastDir, int spacing, int x_coord, int y_coord, int num){
        if(lastDir == 0) {
            while(true){
                Random random = new Random();
                int nextDir = random.nextInt(5) - 2;
                if(nextDir == 1 && (y_coord + spacing + linearStackSpacing *  (num - 1) < 374)) return nextDir;
                if(nextDir == -1 && (y_coord - spacing - linearStackSpacing *  (num - 1) > 10)) return nextDir;
                if(nextDir == -2 && (x_coord + spacing + linearStackSpacing *  (num - 1) < 502)) return nextDir;
                if(nextDir == 2 && (x_coord - spacing - linearStackSpacing *  (num - 1) > 10)) return nextDir;
            }
        }
        else{
            while(true){
                Random random = new Random();
                int nextDir = random.nextInt(5) - 2;
                if(nextDir + lastDir == 0) continue;
                if(nextDir == 1 && (y_coord + spacing + linearStackSpacing *  (num - 1) < 374)) return nextDir;
                if(nextDir == -1 && (y_coord - spacing - linearStackSpacing *  (num - 1) > 10)) return nextDir;
                if(nextDir == -2 && (x_coord + spacing + linearStackSpacing *  (num - 1) < 502)) return nextDir;
                if(nextDir == 2 && (x_coord - spacing - linearStackSpacing *  (num - 1) > 10)) return nextDir;
            }
        }
    }

    private double[] generateTimingPattern(double curTime, int num){
        double[] timings = new double[num];
        timings[0] = curTime + halfTick;
        for(int i = 1; i < num; i++){
            timings[i] = timings[i-1] + quarterTick;
        }
        return timings;
    }
}

