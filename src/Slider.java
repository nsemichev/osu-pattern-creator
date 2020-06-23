public class Slider extends HitObject{
    Slider(int x, int y, int time, int type, String objectParams, String hitSample){
        super(x, y, time, type, objectParams, hitSample);
        String[] params = objectParams.split("|");
        this.curveType = params[0];
        String[] other_params = params[1].split(",");
        this.curvePoints = other_params[0];
        this.slides = Integer.parseInt(other_params[1]);
        this.length = Float.parseFloat(other_params[2]);
        this.edgeSounds = other_params[3];
        this.edgeSets = other_params[4];
    }
    private String curveType;
    private String curvePoints;
    private int slides;
    private float length;
    private String edgeSounds;
    private String edgeSets;
}
