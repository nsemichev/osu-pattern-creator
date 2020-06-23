public class Spinner extends HitObject{
    Spinner(int x, int y, int time, int type, String objectParams, String hitSample){
        super(x, y, time, type, objectParams, hitSample);
        this.endTime = Integer.parseInt(objectParams);
    }
    private int endTime;
}
