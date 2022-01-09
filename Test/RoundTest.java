import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RoundTest {

    @Test
    public void getNumberOfAttempt() {

        List<Integer> attempts = new ArrayList<Integer>();
        attempts.add(2);
        attempts.add(3);

        Round round = new Round(attempts);
        assertEquals(2, round.getNumberOfAttempt());

        List<Integer> attempts2 = new ArrayList<Integer>();
        attempts2.add(10);

        Round round2 = new Round(attempts2);
        assertEquals(1, round2.getNumberOfAttempt());

        List<Integer> attempts3 = new ArrayList<Integer>();
        attempts3.add(10);
        attempts3.add(10);
        attempts3.add(10);

        Round round3 = new Round(attempts3);
        assertEquals(3, round3.getNumberOfAttempt());

    }

    @Test
    public void getPinsDownInFirstAttempt() {
        List<Integer> attempts = new ArrayList<Integer>();
        attempts.add(6);
        attempts.add(3);

        Round round = new Round(attempts);
        assertEquals(6, round.getPinsDownInFirstAttempt());

        List<Integer> attempts2 = new ArrayList<Integer>();
        attempts2.add(10);

        Round round2 = new Round(attempts2);
        assertEquals(10, round2.getPinsDownInFirstAttempt());

    }

    @Test
    public void getPinsDownInSecondAttempt() {
        List<Integer> attempts = new ArrayList<Integer>();
        attempts.add(6);
        attempts.add(3);

        Round round = new Round(attempts);
        assertEquals(3, round.getPinsDownInSecondAttempt());

        List<Integer> attempts2 = new ArrayList<Integer>();
        attempts2.add(6);
        attempts2.add(3);

        Round round2 = new Round(attempts2);
        assertEquals(3, round2.getPinsDownInSecondAttempt());

    }

    @Test
    public void getPinsDownInThirdAttempt() {
        List<Integer> attempts = new ArrayList<Integer>();
        attempts.add(8);
        attempts.add(2);
        attempts.add(0);

        Round round = new Round(attempts);
        assertEquals(0, round.getPinsDownInThirdAttempt());

        List<Integer> attempts2 = new ArrayList<Integer>();
        attempts2.add(6);
        attempts2.add(4);
        attempts2.add(10);

        Round round2 = new Round(attempts2);
        assertEquals(10, round2.getPinsDownInThirdAttempt());

    }

    @Test
    public void getTotalPinsDownInRound() {
        List<Integer> attempts = new ArrayList<Integer>();
        attempts.add(8);
        attempts.add(2);

        Round round = new Round(attempts);
        assertEquals(10, round.getTotalPinsDownInRound());

        List<Integer> attempts2 = new ArrayList<Integer>();
        attempts2.add(2);
        attempts2.add(3);

        Round round2 = new Round(attempts2);
        assertEquals(5, round2.getTotalPinsDownInRound());
    }

    @Test
    public void isASplit() {
        List<Integer> attempts = new ArrayList<Integer>();
        attempts.add(8);
        attempts.add(2);

        Round round = new Round(attempts);
        assertTrue(round.isASplit());

        List<Integer> attempts2 = new ArrayList<Integer>();
        attempts2.add(2);
        attempts2.add(3);

        Round round2 = new Round(attempts2);
        assertFalse(round2.isASplit());

        List<Integer> attempts3 = new ArrayList<Integer>();
        attempts3.add(10);

        Round round3 = new Round(attempts3);
        assertFalse(round3.isASplit());
    }
}