import java.util.HashMap;
import java.util.Map;

public class Transition {
    private Map<String, Map<String, String>> states = new HashMap();

    public void create(String currentState, String alphabet, String nextState) {
        states.putIfAbsent(currentState, new HashMap<>());
        states.get(currentState).put(alphabet, nextState);
    }

    public Map<String, Map<String, String>> getAllStates() {
        return states;
    }
}
