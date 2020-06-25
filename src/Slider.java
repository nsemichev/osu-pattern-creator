public class Slider extends HitObject{
    Slider(int x, int y, int time, int type, int hitSound, String objectParams, String hitSample){
        super(x, y, time, type, hitSound, objectParams, hitSample);
        String[] params = objectParams.split("\\|");
        this.curveType = params[0];
        String[] other_params = params[1].split(",");
        this.curvePoints = other_params[0];
        this.slides = Integer.parseInt(other_params[1]);
        this.length = Double.parseDouble(other_params[2]);
        this.edgeSounds = other_params[3];
        this.edgeSets = other_params[4];
    }
    private String curveType;
    private String curvePoints;
    private int slides;
    private double length;
    private String edgeSounds;
    private String edgeSets;

    public String getCurveType() {
        return curveType;
    }

    public void setCurveType(String curveType) {
        this.curveType = curveType;
    }

    public String getCurvePoints() {
        return curvePoints;
    }

    public void setCurvePoints(String curvePoints) {
        this.curvePoints = curvePoints;
    }

    public int getSlides() {
        return slides;
    }

    public void setSlides(int slides) {
        this.slides = slides;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getEdgeSounds() {
        return edgeSounds;
    }

    public void setEdgeSounds(String edgeSounds) {
        this.edgeSounds = edgeSounds;
    }

    public String getEdgeSets() {
        return edgeSets;
    }

    public void setEdgeSets(String edgeSets) {
        this.edgeSets = edgeSets;
    }

    public String toString(){
        String[] hitObject = super.toString().split(",");
        String objectParams = curveType + "|" + curvePoints + "," + slides + "," + length + "," + edgeSounds + "," + edgeSets;
        String finalString = "";
        for(int i = 0; i < 5; i++){
            finalString += hitObject[i] + ",";
        }
        return finalString + hitObject[hitObject.length - 1];
    }
}
