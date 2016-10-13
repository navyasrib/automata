import java.util.HashMap;
import java.util.Map;

public class Delta {
    private Map<State,Map<String, State>> flow = new HashMap<>();

    public Delta(Map<State, Map<String, State>> transitions) {
        this.flow = transitions;
    }

    public State getNextState(State state, String alphabet) {
        return flow.get(state).get(alphabet);
    }

}
