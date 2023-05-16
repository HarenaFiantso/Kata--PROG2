public class SimpleCardGame {
    public static String winner(String[] deckSteve, String[] deckJosh) {
        int scoreSteve = 0;
        int scoreJosh = 0;

        for (int i = 0; i < deckSteve.length; i++) {
            int rankSteve = "23456789TJQKA".indexOf(deckSteve[i]);
            int rankJosh = "23456789TJQKA".indexOf(deckJosh[i]);
            if (rankSteve > rankJosh) {
                scoreSteve++;
            } else if (rankJosh > rankSteve) {
                scoreJosh++;
            }
        }

        if (scoreSteve > scoreJosh) {
            return "Steve wins " + scoreSteve + " to " + scoreJosh;
        } else if (scoreJosh > scoreSteve) {
            return "Josh wins " + scoreJosh + " to " + scoreSteve;
        } else {
            return "Tie";
        }
    }

}
