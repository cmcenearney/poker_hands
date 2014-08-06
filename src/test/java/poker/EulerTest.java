package poker;

import org.junit.Test;

import static org.junit.Assert.*;

public class EulerTest {

    @Test
    public void testProjectEulerProblem54Solution(){
        String[] testArgs = new String[0];
        Euler.main(testArgs);
        assert(Euler.playerOneWins == 376);
    }
}