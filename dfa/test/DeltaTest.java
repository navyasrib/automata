import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeltaTest {
    private Transisions transitions;
    private State q1;
    private State q2;

    @Before
    public void setUp() throws Exception {
        transitions = new Transisions();
        q1 = new State("q1");
        q2 = new State("q2");
        transitions.create(q1,"0",q2);
        transitions.create(q1,"1",q1);
        transitions.create(q2,"0",q2);
        transitions.create(q2,"1",q1);
    }

    @Test
    public void shouldReturnNextValidState() throws Exception {
        Delta delta = new Delta(transitions.getAllStates());

        assertTrue(q1.equals(delta.getNextState(q1,"1")));
        assertTrue(q2.equals(delta.getNextState(q1,"0")));
        assertTrue(q1.equals(delta.getNextState(q2,"1")));
        assertTrue(q2.equals(delta.getNextState(q2,"0")));
    }

    @After
    public void tearDown() throws Exception {
        transitions = null;
        q1 = null;
        q2 = null;
    }
}