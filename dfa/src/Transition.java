import java.util.HashMap;
import java.util.Map;

public class Transition {
    private Map<String,Map<String,String>> flow = new HashMap<>();

    public void setFlow(String currentState, String alphabet, String nextState) {
        flow.putIfAbsent(currentState, new HashMap<>());
        flow.get(currentState).put(alphabet,nextState);
    }

    public String delta(String state, String alphabet) {
        return flow.get(state).get(alphabet);
    }

}
