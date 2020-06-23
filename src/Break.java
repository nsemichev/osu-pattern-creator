public class Break extends Event{
    Break(String eventType, int startTime, String eventParams){
        super(eventType, startTime, eventParams);
        this.endTime = Integer.parseInt(eventParams);
    }
    private int endTime;
}
