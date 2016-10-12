import org.junit.Test;

import static org.junit.Assert.*;

public class TransitionTest {
    @Test
    public void shouldReturnNextValidState() throws Exception {
        Transition transition = new Transition();
        transition.setFlow("q1","0","q2");
        transition.setFlow("q1","1","q1");
        transition.setFlow("q2","0","q2");
        transition.setFlow("q2","1","q1");
        assertEquals("q1", transition.delta("q1","1"));
        assertEquals("q2", transition.delta("q1","0"));
        assertEquals("q1", transition.delta("q2","1"));
        assertEquals("q2", transition.delta("q2","0"));
    }
}