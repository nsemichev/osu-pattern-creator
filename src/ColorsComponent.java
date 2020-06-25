import java.util.*;
public class ColorsComponent extends BeatmapComponent {
    ColorsComponent(String type, List<String> fields){
        super(type);
        this.colors = fields;
    }
    private List<String> colors;

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public String toString(){
        String finalString = super.toString();
        for(int i = 0; i < colors.size(); i++){
            finalString += "\n" + colors.get(i).toString();
        }
        return finalString;
    }
}
