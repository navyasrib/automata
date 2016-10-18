import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class DFATupleTest {
    @Test
    public void dfaCanRecognisePowerOfTwo() throws Exception {
        State q0 = new State("q0");
        State q1 = new State("q1");
        State q2 = new State("q2");

        Transisions statesSet = new Transisions();
        statesSet.create(q0,"0",q0);
        statesSet.create(q0,"1",q1);
        statesSet.create(q1,"0",q1);
        statesSet.create(q1,"1",q2);
        statesSet.create(q2,"0",q2);
        statesSet.create(q2,"1",q2);

        States states = new States();
        states.add(q0);
        states.add(q1);

        AlphabetSet alphabetSet = new AlphabetSet();
        alphabetSet.add("1");
        alphabetSet.add("0");

        ArrayList<State> finalStates = new ArrayList<>();
        finalStates.add(q1);
        Delta delta = new Delta(statesSet.getAllStates());

        DFATuple dfaTuple = new DFATuple(q0, alphabetSet, states, delta, finalStates);

        assertTrue(dfaTuple.isAccept("100"));
        assertFalse(dfaTuple.isAccept("101"));
    }
}