import java.util.HashMap;
import java.util.Map;

public class Delta {
    private Map<String,Map<String,String>> flow = new HashMap<>();

    public Delta(Map<String, Map<String, String>> transitions) {
        this.flow = transitions;
    }

    public String getNextState(String state, String alphabet) {
        return flow.get(state).get(alphabet);
    }

}
