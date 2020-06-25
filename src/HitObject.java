public class HitObject {
    HitObject(){

    }
    HitObject(int x, int y, int time, int type, int hitSound, String objectParams, String hitSample){
        this.x = x;
        this.y = y;
        this.time = time;
        this.type = type;
        this.hitSound = hitSound;
        this.objectParams = objectParams;
        this.hitSample = hitSample;
    }
    private int x;
    private int y;
    private int time;
    private int type;
    private int hitSound;
    private String objectParams;
    private String hitSample;

    public String toString(){
        String finalString = String.valueOf(x) + "," + String.valueOf(y) + "," + String.valueOf(time) + "," + String.valueOf(type) + "," + String.valueOf(hitSound);
        if(!objectParams.equals("")) finalString += "," + objectParams;
        if(!hitSample.equals("")) finalString += hitSample;
        return finalString;
    }
}
