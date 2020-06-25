import java.util.*;
public class EventComponent extends BeatmapComponent {
    EventComponent(String type, List<String> fields){
        super(type);
        for(int i = 0; i < fields.size(); i++){
            Event event;
            String[] eventVars = fields.get(i).split(",");
            String eventType = eventVars[0];
            if(eventType.equals("0")){
                event = new Background(eventVars[0], Integer.parseInt(eventVars[1]), eventVars[2]);
                this.events.add(event);
            }
            else if(eventType.equals("1") || eventType.equals("Video")){
                event = new Video(eventVars[0], Integer.parseInt(eventVars[1]), eventVars[2]);
                this.events.add(event);
            }
            else if(eventType.equals("2") || eventType.equals("Break")){
                event = new Break(eventVars[0], Integer.parseInt(eventVars[1]), eventVars[2]);
                this.events.add(event);
            }
            else{
                System.out.println("Unrecognized attribute in [Events]");
                System.out.println("Skipping " + fields.get(i));
            }

        }
    }

    private List<Event> events = new ArrayList<Event>();

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public String toString(){
        String finalString = super.toString();
        for(int i = 0; i < events.size(); i++){
            finalString += "\n" + events.get(i).toString();
        }
        return finalString;
    }
}
