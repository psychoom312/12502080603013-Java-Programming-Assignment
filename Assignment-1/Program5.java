class Match {
    protected String format;
    protected String team1;
    protected String team2;

    public Match(String format, String team1, String team2) {
        this.format = format; 
        this.team1 = team1;
        this.team2 = team2;
    }

    public void displayBasicInfo() {
        System.out.println("Match Format: " + format);
        System.out.println("Teams: " + team1 + " vs " + team2);
    }
}

class CricketMatch extends Match {
    private int target;
    private double currentOvers;
    private int currentScore;

    public CricketMatch(String format, String team1, String team2, int target, int score, double overs) {
        super(format, team1, team2);
        this.target = target;
        this.currentScore = score;
        this.currentOvers = overs;
    }

    public double calculateRunRate() {
        return currentScore / currentOvers;
    }

    public int getRequiredRuns() {
        return target - currentScore;
    }

    public void displayStatus() {
        displayBasicInfo();
        System.out.println("Score: " + currentScore + " (Target: " + target + ")");
        System.out.println("Overs: " + currentOvers);
        System.out.printf("Current Run Rate: %.2f\n", calculateRunRate());
        System.out.println("Runs Needed: " + getRequiredRuns());
    }
}

public class CricketSystem {
    public static void main(String[] args) {
        if (args.length < 6) {
            System.out.println("Usage: java CricketSystem <Format> <Team1> <Team2> <Target> <CurrentScore> <Overs>");
            return;
        }

        try {
            String format = args[0];
            String t1 = args[1];
            String t2 = args[2];
            int target = Integer.parseInt(args[3]);
            int score = Integer.parseInt(args[4]);
            double overs = Double.parseDouble(args[5]);

            CricketMatch match = new CricketMatch(format, t1, t2, target, score, overs);
            match.displayStatus();
        } catch (NumberFormatException e) {
            System.out.println("Error: Target, Score, and Overs must be numeric.");
        }
    }
}
