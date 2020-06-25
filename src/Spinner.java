public class Spinner extends HitObject{
    Spinner(int x, int y, int time, int type, int hitSound, String objectParams, String hitSample){
        super(x, y, time, type, hitSound, objectParams, hitSample);
        this.endTime = Integer.parseInt(objectParams);
    }
    private int endTime;

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String toString(){
        String[] hitObject = super.toString().split(",");
        hitObject[5] = String.valueOf(endTime);
        String finalString = hitObject[0];
        for(int i = 1; i < hitObject.length; i++){
            finalString += "," + hitObject[i];
        }
        return finalString;
    }
}

