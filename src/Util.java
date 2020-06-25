import java.util.*;
public class Util {
    public static double findBPM(List<TimingPoint> timingPoints){
        Map<Double, Integer> map = new HashMap<>();
        double lastBpmUnit = -1;
        for(int i = 0; i < timingPoints.size(); i++){
            double bpmUnit = timingPoints.get(i).getBeatLength();
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
        double mostCommonBpmUnit = 0;
        for (Map.Entry<Double, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                mostCommonBpmUnit = entry.getKey();
            }
        }

        return 60000.0 / mostCommonBpmUnit;
    }
}
