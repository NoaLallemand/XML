package Modele;

import java.util.Comparator;

public class ComparatorFilm implements Comparator<Movie>{
    @Override
    public int compare(Movie film1, Movie film2) {
        // Comparaison basée sur la note moyenne (ascendante)
        return Double.compare(film1.getVote_average(), film2.getVote_average());
    }
}
