public class Event {
    Event(String eventType, int startTime, String eventParams){
        this.eventType = eventType;
        this.startTime = startTime;
        this.eventParams = eventParams;
    }
    private String eventType;
    private int startTime;
    private String eventParams;
}
