package Modele;

import Modele.Acteur;
import Modele.Genres;
import Modele.Realisateur;
import java.util.ArrayList;
import java.util.Date;

public class Movie {
    private int id;
    private String title;
    private String originalTitle;
    private Date releaseDate;
    private String status;
    private int vote_average;
    private int vote_count;
    private int runtime;
    private float certification;
    private String poster_path;
    private int budget;
    private String tagline;
    private ArrayList<Genres> genres = new ArrayList<Genres>();
    private ArrayList<Realisateur> directors = new ArrayList<Realisateur>();
    private ArrayList<Acteur> actor = new ArrayList<Acteur>();
    public Movie()
    {

    }

    public void setId(int id) {this.id = id;}
    public void setTitle(String title) {this.title = title;}
    public void setOriginalTitle(String originalTitle) {this.originalTitle = originalTitle;}
    public void setReleaseDate(Date releaseDate) {this.releaseDate = releaseDate;}
    public void setStatus(String status) {this.status = status;}

    public void setVote_average(int vote_average) {
        this.vote_average = vote_average;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public void setCertification(float certification) {
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

    public void setActor(ArrayList<Acteur> actor) {
        this.actor = actor;
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getStatus() {
        return status;
    }

    public int getVote_average() {
        return vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public int getRuntime() {
        return runtime;
    }

    public float getCertification() {
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

    public ArrayList<Acteur> getActor() {
        return actor;
    }
}
