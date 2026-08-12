import java.util.*;

class Checker implements Comparator<Player> {
    public int compare(Player a, Player b) {
        // Higher score first
        if (a.score != b.score) {
            return b.score - a.score;
        }

        // Alphabetical order if scores are equal
        return a.name.compareTo(b.name);
    }
}
