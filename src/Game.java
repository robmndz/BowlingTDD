import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Round> listOfRounds;

    public Game(List<Round> listOfRounds) {
        this.listOfRounds = listOfRounds;
    }


    public int getTotalPointsInGame() {

        int totalPoints = 0;
        boolean lastRoundWasSplit = false;
        boolean lastRoundWasAStrike = false;
        boolean doubleStrike = false;

        for (Round round : listOfRounds) {
            totalPoints += round.getTotalPinsDownInRound();

            if(lastRoundWasSplit){
                totalPoints += round.getPinsDownInFirstAttempt();
            }

            if(doubleStrike){
                totalPoints += round.getPinsDownInFirstAttempt();
                doubleStrike = false;
            }

            if(lastRoundWasAStrike){
                if(!round.isAStrike()){
                    totalPoints += round.getPinsDownInFirstAttempt() + round.getPinsDownInSecondAttempt();
                } else {
                    doubleStrike = true;
                    totalPoints += round.getPinsDownInFirstAttempt();
                }
            }
            lastRoundWasAStrike = round.isAStrike();
            lastRoundWasSplit = round.isASplit();

        }
        return totalPoints;
    }
}
