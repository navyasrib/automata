import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeltaTest {
    private Transition transitions;

    @Before
    public void setUp() throws Exception {
        transitions = new Transition();
        transitions.create("q1","0","q2");
        transitions.create("q1","1","q1");
        transitions.create("q2","0","q2");
        transitions.create("q2","1","q1");
    }

    @Test
    public void shouldReturnNextValidState() throws Exception {
        Delta delta = new Delta(transitions.getAllStates());

        assertEquals("q1", delta.getNextState("q1","1"));
        assertEquals("q2", delta.getNextState("q1","0"));
        assertEquals("q1", delta.getNextState("q2","1"));
        assertEquals("q2", delta.getNextState("q2","0"));
    }

    @After
    public void tearDown() throws Exception {
        transitions = null;
    }
}