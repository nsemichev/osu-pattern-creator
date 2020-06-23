public class Video extends Event {
    Video(String eventType, int startTime, String eventParams){
        super(eventType, startTime, eventParams);
        String[] params = eventParams.split(",");
        this.filename = params[0];
        if(params.length == 2){
            this.xOffset = Integer.parseInt(params[1]);
        }
        else if(params.length == 3){
            this.xOffset = Integer.parseInt(params[1]);
            this.yOffset = Integer.parseInt(params[2]);
        }
    }
    private String filename;
    private int xOffset;
    private int yOffset;
}
