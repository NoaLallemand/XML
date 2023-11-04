package Modele;

import java.time.LocalDate;
import java.util.ArrayList;

public class Movie {
    private int id;
    private String title;
    private String originalTitle;
    private LocalDate releaseDate;
    private String status;
    private float vote_average;
    private int vote_count;
    private int runtime;
    private String certification;
    private String poster_path;
    private int budget;
    private String tagline;
    private ArrayList<Genres> genres = new ArrayList<Genres>();
    private ArrayList<Realisateur> directors = new ArrayList<Realisateur>();
    private ArrayList<Acteur> actors = new ArrayList<Acteur>();
    public Movie()
    {

    }

    public void setId(int id) {this.id = id;}
    public void setTitle(String title) {this.title = title;}
    public void setOriginalTitle(String originalTitle) {this.originalTitle = originalTitle;}
    public void setReleaseDate(LocalDate releaseDate) {this.releaseDate = releaseDate;}
    public void setStatus(String status) {this.status = status;}

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public void setGenres(ArrayList<Genres> genres) {
        this.genres = genres;
    }

    public void setDirectors(ArrayList<Realisateur> directors) {
        this.directors = directors;
    }

    public void setActors(ArrayList<Acteur> actors) {
        this.actors = actors;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getStatus() {
        return status;
    }

    public float getVote_average() {
        return vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public int getRuntime() {
        return runtime;
    }

    public String getCertification() {
        return certification;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public int getBudget() {
        return budget;
    }

    public String getTagline() {
        return tagline;
    }

    public ArrayList<Genres> getGenres() {
        return genres;
    }

    public ArrayList<Realisateur> getDirectors() {
        return directors;
    }

    public ArrayList<Acteur> getActors() {
        return actors;
    }

    @Override
    public String toString() {
        return "id: " + getId() +
                "\ntitle: " + getTitle() +
                "\noriginal_title: " + getOriginalTitle() +
                "\nrelease_date: " + getReleaseDate().toString() +
                "\nstatus: " +getStatus() +
                "\nvote_average: " + getVote_average() +
                "\nvote_count: " + getVote_count() +
                "\nruntime: " + getRuntime() +
                "\ncertification: " + getCertification() +
                "\nposter_path: " + getPoster_path() +
                "\nbudget: " + getBudget() +
                "\ntagline: " + getTagline() +
                getGenresToString() +
                getDirectorsToString() +
                getActorsToString();
    }

    private String getGenresToString()
    {
        StringBuilder genresStr = new StringBuilder("\ngenres: [");
        for(Genres g: genres)
        {
            genresStr.append("\n\t{\n\t\tid: " + g.id + "\n\t\tgenre: " + g.genre + "\n\t},");
        }
        genresStr.append("\n]");
        return genresStr.toString();
    }

    private String getDirectorsToString()
    {
        StringBuilder directorsStr = new StringBuilder("\ndirectors: [ ");
        for(Realisateur r: directors)
        {
            directorsStr.append("\n\t{\n\t\tid: " + r.id + "\n\t\tnom: " + r.nom + "\n\t},");
        }
        directorsStr.append("\n]");
        return directorsStr.toString();
    }

    private String getActorsToString()
    {
        StringBuilder actorsStr = new StringBuilder("\nactors: [ ");
        for(Acteur a: actors)
        {
            actorsStr.append("\n\t{\n\t\tid: " + a.id + "\n\t\tnom: " + a.nom + "\n\t\tpersonnage: " + a.personnage + "\n\t},");
        }
        actorsStr.append("\n]");
        return actorsStr.toString();
    }
}
