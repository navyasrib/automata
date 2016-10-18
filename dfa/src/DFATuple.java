import java.util.ArrayList;

public class DFATuple {
    private final State initialState;
    private final AlphabetSet alphabetSet;
    private final States statesSet;
    private final Delta delta;
    private final ArrayList<State> finalStates;

    DFATuple(State initialState, AlphabetSet alphabetSet, States statesSet, Delta delta, ArrayList<State> finalStates) {
        this.initialState = initialState;
        this.alphabetSet = alphabetSet;
        this.statesSet = statesSet;
        this.delta = delta;
        this.finalStates = finalStates;
    }

    boolean isAccept(String inputString) {
        String[] input = inputString.split("");
        State currentState = this.initialState;
        for (String alphabet : input) {
            currentState = this.delta.getNextState(currentState, alphabet);
        }
        return isFinalState(currentState);
    }

    private boolean isFinalState(State state) {
        for (State finalState : this.finalStates) {
            if(finalState.equals(state)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "DFATuple{" +
                "initialState=" + initialState +
                ", alphabetSet=" + alphabetSet +
                ", statesSet=" + statesSet +
                ", delta=" + delta +
                ", finalStates=" + finalStates +
                '}';
    }
}
