public class HitObject {
    HitObject(int x, int y, int time, int type, String objectParams, String hitSample){
        this.x = x;
        this.y = y;
        this.time = time;
        this.type = type;
        this.objectParams = objectParams;
        this.hitSample = hitSample;
    }
    private int x;
    private int y;
    private int time;
    private int type;
    private String objectParams;
    private String hitSample;

    @Override
    public String toString(){
        return String.valueOf(x) + "," + String.valueOf(y) + "," + String.valueOf(time) + "," + String.valueOf(type) + "," + objectParams + "," + hitSample;
    }
}
