public class BeatmapComponent {
    BeatmapComponent(){

    }
    BeatmapComponent(String type){
        this.type = type;
    }
    private String type;

    public String toString(){
        return type;
    }

    public String getType(){
        return type;
    }
}
