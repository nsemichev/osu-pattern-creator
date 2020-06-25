import java.util.*;
public class HitObjectsComponent extends BeatmapComponent {
    HitObjectsComponent(String type, List<String> fields){
        super(type);
        for(int i = 0; i < fields.size(); i ++){
            String[] params = fields.get(i).split(",");
            int objectType = Integer.parseInt(params[3]);
            if(objectType % 2 == 1){
                hitObjects.add(new HitCircle(Integer.parseInt(params[0]), Integer.parseInt(params[1]), Integer.parseInt(params[2]), Integer.parseInt(params[3]), Integer.parseInt(params[4]), "", ""));
            }
            else if((objectType / 2) % 2 == 1){ // Slider
                hitObjects.add(new HitCircle(Integer.parseInt(params[0]), Integer.parseInt(params[1]), Integer.parseInt(params[2]), Integer.parseInt(params[3]), Integer.parseInt(params[4]), "", ""));

            }
            else hitObjects.add(new HitCircle(Integer.parseInt(params[0]), Integer.parseInt(params[1]), Integer.parseInt(params[2]), Integer.parseInt(params[3]), Integer.parseInt(params[4]), "", ""));
        }
    }
    private List<HitObject> hitObjects = new ArrayList<HitObject>();

    public List<HitObject> getHitObjects() {
        return hitObjects;
    }

    public void setHitObjects(List<HitObject> hitObjects) {
        this.hitObjects = hitObjects;
    }

    public String toString(){
        String finalString = super.toString();
        for(int i = 0; i < hitObjects.size(); i++){
            finalString += "\n" + hitObjects.get(i).toString();
        }
        return finalString;
    }
}

