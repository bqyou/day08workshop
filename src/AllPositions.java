import java.util.HashMap;
import java.util.Map;

public class AllPositions {

    private Map<String, Position> positionList = new HashMap<String, Position>();

    public AllPositions() {
        this.positionList = new HashMap<String, Position>();
    }

    public Map<String, Position> getPositionList() {
        return positionList;
    }

    public void setPositionList(String id, Position currentPosition) {
        this.positionList.put(id, currentPosition);
    }

}
