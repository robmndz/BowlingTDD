import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void getTotalPointsInGameZeroPoints() {

        List<Round> listOfRounds = new ArrayList<Round>();

        List<Integer> attempts = new ArrayList<Integer>();
        attempts.add(0);
        attempts.add(0);

        for (int i = 1; i <= 10; i++) {
            listOfRounds.add(new Round(attempts));
        }

        Game game = new Game(listOfRounds);
        assertEquals(0, game.getTotalPointsInGame());

    }

    @Test
    public void getTotalPointsInGameTenPoints() {

        List<Round> listOfRounds = new ArrayList<Round>();

        List<Integer> attempts = new ArrayList<Integer>();
        attempts.add(1);
        attempts.add(0);

        for (int i = 1; i <= 10; i++) {
            listOfRounds.add(new Round(attempts));
        }
        Game game = new Game(listOfRounds);
        assertEquals(10, game.getTotalPointsInGame());

    }


    @Test
    public void getTotalPointsInGameWithOneSplit() {

        List<Round> listOfRounds = new ArrayList<Round>();

        List<Integer> attempts = new ArrayList<Integer>();
        attempts.add(5);
        attempts.add(5);

        listOfRounds.add(new Round(attempts));

        List<Integer> attemptsOneOne = new ArrayList<Integer>();
        attemptsOneOne.add(1);
        attemptsOneOne.add(1);

        for (int i = 2; i <= 10; i++) {
            listOfRounds.add(new Round(attemptsOneOne));
        }

        Game game = new Game(listOfRounds);
        assertEquals(29, game.getTotalPointsInGame());

        /// With one split first and all other attempts 2 down

        List<Round> listOfRounds2 = new ArrayList<Round>();


        listOfRounds2.add(new Round(attempts));

        List<Integer> attemptsTwoTwo = new ArrayList<Integer>();
        attemptsTwoTwo.add(2);
        attemptsTwoTwo.add(2);

        for (int i = 2; i <= 10; i++) {
            listOfRounds2.add(new Round(attemptsTwoTwo));
        }

        Game game2 = new Game(listOfRounds2);
        assertEquals(48, game2.getTotalPointsInGame());

    }


    @Test
    public void getTotalPointsInGameWithOneStrike() {

        List<Round> listOfRounds = new ArrayList<Round>();

        List<Integer> attempts = new ArrayList<Integer>();
        attempts.add(10);

        listOfRounds.add(new Round(attempts));

        List<Integer> attemptsOneOne = new ArrayList<Integer>();
        attemptsOneOne.add(1);
        attemptsOneOne.add(1);

        for (int i = 2; i <= 10; i++) {
            listOfRounds.add(new Round(attemptsOneOne));
        }

        Game game = new Game(listOfRounds);
        assertEquals(30, game.getTotalPointsInGame());
    }


    @Test
    public void getTotalPointsInGameWithOneStrikeFollowedByASplit() {

        List<Round> listOfRounds = new ArrayList<Round>();

        List<Integer> attempts = new ArrayList<Integer>();
        attempts.add(10);

        listOfRounds.add(new Round(attempts));

        List<Integer> attemptsSplit = new ArrayList<Integer>();
        attemptsSplit.add(5);
        attemptsSplit.add(5);

        listOfRounds.add(new Round(attemptsSplit));

        List<Integer> attemptsOneOne = new ArrayList<Integer>();
        attemptsOneOne.add(1);
        attemptsOneOne.add(1);

        for (int i = 3; i <= 10; i++) {
            listOfRounds.add(new Round(attemptsOneOne));
        }

        Game game = new Game(listOfRounds);
        assertEquals(47, game.getTotalPointsInGame());
    }

    @Test
    public void getTotalPointsInGameWithOneStrikeFollowedByAStrike() {

        List<Round> listOfRounds = new ArrayList<Round>();

        List<Integer> attempts = new ArrayList<Integer>();
        attempts.add(10);

        listOfRounds.add(new Round(attempts));
        listOfRounds.add(new Round(attempts));

        List<Integer> attemptsOneOne = new ArrayList<Integer>();
        attemptsOneOne.add(1);
        attemptsOneOne.add(1);

        for (int i = 3; i <= 10; i++) {
            listOfRounds.add(new Round(attemptsOneOne));
        }

        Game game = new Game(listOfRounds);
        assertEquals(49, game.getTotalPointsInGame());
    }
    @Test
    public void getTotalPointsInGamePerfectGame() {

        List<Round> listOfRounds = new ArrayList<Round>();

        List<Integer> attempts = new ArrayList<Integer>();
        attempts.add(10);

        for (int i = 1; i <= 9; i++) {
            listOfRounds.add(new Round(attempts));
        }

        List<Integer> attemptsFinal = new ArrayList<Integer>();
        attemptsFinal.add(10);
        attemptsFinal.add(10);
        attemptsFinal.add(10);

        listOfRounds.add(new Round(attemptsFinal));

        Game game = new Game(listOfRounds);
        assertEquals(300, game.getTotalPointsInGame());

    }

    @Test
    public void getTotalPointsInParcialGame() {

        List<Round> listOfRounds = new ArrayList<Round>();

        List<Integer> attempts = new ArrayList<Integer>();
        attempts.add(1);
        attempts.add(1);

        for (int i = 1; i <= 5; i++) {
            listOfRounds.add(new Round(attempts));
        }

        Game game = new Game(listOfRounds);
        assertEquals(10, game.getTotalPointsInGame());

        // Strike
        List<Round> listOfRounds2 = new ArrayList<Round>();

        List<Integer> attempts2 = new ArrayList<Integer>();
        attempts2.add(10);

        Game game2 = new Game(listOfRounds2);
        assertEquals(10, game.getTotalPointsInGame());

    }



}