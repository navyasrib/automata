import java.util.Map;

public class Tuple {
    private States states;
    private AlphabetSet alphabets;
    private Map<State, Map<String, State>> delta;
    private State start_state;
    private States final_states;

    public States getStates() {
        return states;
    }

    public void setStates(States states) {
        this.states = states;
    }

    public AlphabetSet getAlphabets() {
        return alphabets;
    }

    public void setAlphabets(AlphabetSet alphabets) {
        this.alphabets = alphabets;
    }

    public Map<State, Map<String, State>> getDelta() {
        return delta;
    }

    public void setDelta(Map<State, Map<String, State>> delta) {
        this.delta = delta;
    }

    public State getStart_state() {
        return start_state;
    }

    public void setStart_state(State start_state) {
        this.start_state = start_state;
    }

    public States getFinal_states() {
        return final_states;
    }

    public void setFinal_states(String[] final_states) {
        States sampleStates = new States();
        for (String state : final_states) {
            State state1 = new State(state);
            sampleStates.add(state1);
        }
        this.final_states = sampleStates;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "states=" + states +
                ", alphabets=" + alphabets +
                ", delta=" + delta +
                ", start_state=" + start_state +
                ", final_states=" + final_states +
                '}';
    }
}
