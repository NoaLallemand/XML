package controler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.LocalDate;

import Modele.*;

import javax.annotation.processing.SupportedSourceVersion;

public class Container {
    private static Container instance;
    private ArrayList<Movie> films = new ArrayList<Movie>();

    private Container() {
    }
    public static Container getInstance() {
        if (instance == null) {
            instance = new Container();
        }
        return instance;
    }

    public void Lecture() {
        try {
            // Spécifiez le chemin du fichier que vous souhaitez lire
            //File file = new File("C:\\BLOC_3\\XML LABO\\XML\\1000movies.txt");
            File file = new File("C:\\Users\\utilisateur\\OneDrive\\Cours informatique\\Bloc 3\\Bases de données avancées et XML\\Laboratoire\\XML\\1000movies.txt");

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            // Lisez chaque ligne du fichier
            while ((line = bufferedReader.readLine()) != null) {

                //appelle de la fonction parse qui va décomposer chaque ligne du buffer
                Movie m = parse(line);

                System.out.println(m.toString());
                System.out.println("=====================================================================");

                films.add(m);
                //System.out.println(line);
                //System.out.println("=====================================================================");
            }

            // Fermez le BufferedReader et le FileReader après avoir terminé
            bufferedReader.close();
            fileReader.close();

            for(Movie m: films)
            {
                System.out.println(m.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //cette fonction va prendre un buffer chaine de charactere et le décomposer pour crée des obj movies et les stockers
    //a chaque séparateur rencontrer on va incrémenter PlaceMovie pour changer de place dans le switch et ainsi crée toute les variables de mon obj movier

    ////////////////////////////////A LIRE////////////////////////////////////////////////
    //le probleme ici est que a chaque varibale je crée un string il faudras savoir
    //ou son les dates et autre type pour crée une varibale de ce meme type en conséquence
    //////////////////////////////////////////////////////////////////////////////////////
    public Movie parse(String ligne) throws IOException
    {
        Movie film = new Movie();

        //va crée un tableau de string chaque case fait
        String[] elements = ligne.split("‣");

        int i = 0;
        for(String element : elements)
        {
            switch(i)
            {
                case 0 :
                    int id = convertStrToInt(element);
                    film.setId(id);
                    break;
                case 1 :
                    film.setTitle(element);
                    break;
                case 2 :
                    film.setOriginalTitle(element);
                    break;
                case 3 :
                    if(!element.isEmpty()) {
                        LocalDate date = LocalDate.parse(element);
                        film.setReleaseDate(date);
                    }
                    else {
                        film.setReleaseDate(LocalDate.MIN);
                    }
                    break;
                case 4 :
                    film.setStatus(element);
                    break;
                case 5 :
                    float voteaverage = Float.parseFloat(element);
                    film.setVote_average(voteaverage);
                    break;
                case 6 :
                    int votecount = convertStrToInt(element);
                    film.setVote_count(votecount);
                    break;
                case 7 :
                    int dureefilm = convertStrToInt(element);
                    film.setRuntime(dureefilm);
                    break;
                case 8 :
                    film.setCertification(element);
                    break;
                case 9 :
                    film.setPoster_path(element);
                    break;
                case 10 :
                    int budget = convertStrToInt(element);
                    film.setBudget(budget);
                    break;
                case 11 :
                    film.setTagline(element);
                    break;
                case 12 : {
                    String[] Tabgenres = element.split("‖");

                    for(String genre : Tabgenres)
                    {
                        Genres newGenre = new Genres();

                        String[] champsGenre = genre.split("․");
                        for(int j = 0; j < champsGenre.length; j++)
                        {
                            //System.out.println(champsGenre[j]);
                            switch(j)
                            {
                                case 0:
                                    newGenre.id = convertStrToInt(champsGenre[j]);
                                    break;

                                case 1:
                                    newGenre.genre = champsGenre[j];
                                    break;
                            }
                        }
                        film.getGenres().add(newGenre);
                    }
                    break;
                }

                case 13 : {
                    String[] Tabreals = element.split("‖");

                    for(String realisateur : Tabreals) {
                        Realisateur real = new Realisateur();

                        String[] champsReal = realisateur.split("․");
                        for(int j = 0; j < champsReal.length; j++)
                        {
                            //System.out.println(champsReal[j]);
                            switch(j)
                            {
                                case 0:
                                    real.id = convertStrToInt(champsReal[j]);
                                    break;

                                case 1:
                                    real.nom = champsReal[j];
                                    break;
                            }
                        }
                        film.getDirectors().add(real);
                    }
                    break;
                }

                case 14 :
                    String[] Tabacteurs = element.split("‖");

                    for(String acteur : Tabacteurs) {

                        Acteur act = new Acteur();
                        String[] champsActeur = acteur.split("․");

                        for(int j = 0; j < champsActeur.length; j++)
                        {
                            //System.out.println(champsActeur[j]);
                            switch(j)
                            {
                                case 0:
                                    act.id = convertStrToInt(champsActeur[j]);
                                    break;

                                case 1:
                                    act.nom = champsActeur[j];
                                    break;

                                case 2:
                                    act.personnage = champsActeur[j];
                                    break;
                            }
                        }
                        film.getActors().add(act);
                    }
                    break;
            }
            i++;
        }
        return film;
    }

    private int convertStrToInt(String str)
    {
        int val = -1;
        try {
            val = Integer.parseInt(str);
        }
        catch(NumberFormatException e) {}

        return val;
    }

    public void writeXML() {

    }
}
