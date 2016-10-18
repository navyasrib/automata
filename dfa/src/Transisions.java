import java.util.HashMap;
import java.util.Map;

public class Transisions {
    private Map<State, Map<String, State>> states = new HashMap();

    public void create(State currentState, String alphabet, State nextState) {
        states.putIfAbsent(currentState, new HashMap<>());
        states.get(currentState).put(alphabet, nextState);
    }
//    public void setTransisions(Map<State, Map<String, State>> transisions) {
//        this.states = transisions;
//    }
    public Map<State, Map<String, State>> getAllStates() {
        return states;
    }

    @Override
    public String toString() {
        return "Transisions{" +
                "states=" + states +
                '}';
    }
}
