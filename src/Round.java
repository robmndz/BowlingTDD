import java.util.List;

public class Round {

    private List<Integer> attempts;

    public Round(List<Integer> attempts) {
        this.attempts = attempts;
    }

    public int getNumberOfAttempt() {
        return attempts.size();
    }

    public int getPinsDownInFirstAttempt() {
        return attempts.get(0);
    }

    public int getPinsDownInSecondAttempt() {
        return attempts.get(1);
    }

    public int getPinsDownInThirdAttempt() {
        return attempts.get(2);
    }

    public int getTotalPinsDownInRound() {

//        return attempts.stream()
//                .reduce(0, Integer::sum);

        int sumAttempts = 0;
        for (int attempt : attempts) {
            sumAttempts += attempt;
        }
        return sumAttempts;
    }

    public boolean isASplit() {
        return ((getTotalPinsDownInRound() == 10) && (getNumberOfAttempt() == 2));
    }

    public boolean isAStrike() {
        return ((getTotalPinsDownInRound() == 10) && (getNumberOfAttempt() == 1));
    }
}
