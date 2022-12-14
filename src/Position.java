import java.util.HashMap;
import java.util.Map;

public class Position {

    private String id;

    private String name;
    private String description;
    private Map<String, String> direction;

    public Position(String id) {
        this.id = id;
        this.name = "";
        this.description = "";
        this.direction = new HashMap<String, String>();
    }

    public Position(String id, String name, String description, Map<String, String> direction) {
        this.name = name;
        this.description = description;
        this.direction = direction;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        String[] lineBreaker = description.split("<break>");
        String lineBreak = "";
        for (String s : lineBreaker) {
            lineBreak += "%s\n".formatted(s);
        }
        return lineBreak.trim();
    }

    public Map<String, String> getDirection() {

        return direction;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addDirection(String directionkey, String id) {
        this.direction.put(directionkey, id);
    }

    public void clearDirection() {
        this.direction.clear();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
