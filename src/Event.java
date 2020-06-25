public class Event {
    Event(String eventType, int startTime, String eventParams){
        this.eventType = eventType;
        this.startTime = startTime;
        this.eventParams = eventParams;
    }
    private String eventType;
    private int startTime;
    private String eventParams;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public String getEventParams() {
        return eventParams;
    }

    public void setEventParams(String eventParams) {
        this.eventParams = eventParams;
    }

    public String toString(){
        return eventType + "," + String.valueOf(startTime) + "," + eventParams;
    }
}
