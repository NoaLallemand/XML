package controler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import Modele.*;

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
            File file = new File("C:\\BLOC_3\\XML LABO\\XML\\1000movies.txt");

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            // Lisez chaque ligne du fichier
            while ((line = bufferedReader.readLine()) != null) {

                //appelle de la fonction parse qui va décomposer chaque ligne du buffer
                //parse(line);

                System.out.println(line);
                System.out.println("=====================================================================");
            }

            // Fermez le BufferedReader et le FileReader après avoir terminé
            bufferedReader.close();
            fileReader.close();

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
    public void parse(String ligne) throws IOException
    {
        Movie film = new Movie();
        int i = 0;

        //va crée un tableau de string chaque case fait
        String[] elements = ligne.split("\u2023");

        for(String element : elements)
        {
            switch(i)
            {
                case 0 :
                    int id = Integer.parseInt(elements[i]);
                    film.setId(id);
                    break;
                case 1 :
                    film.setTitle(elements[i]);
                    break;
                case 2 :
                    film.setOriginalTitle(elements[i]);
                    break;
                case 3 :

                    LocalDate date = LocalDate.parse(elements[i]);
                    film.setReleaseDate(date);
                    break;
                case 4 :
                    film.setStatus(elements[i]);
                    break;
                case 5 :
                    int voteaverage = Integer.parseInt(elements[i]);
                    film.setVote_average(voteaverage);
                    break;
                case 6 :
                    int votecount = Integer.parseInt(elements[i]);
                    film.setVote_count(votecount);
                    break;
                case 7 :
                    int dureefilm = Integer.parseInt(elements[i]);
                    film.setRuntime(dureefilm);
                    break;
                case 8 :
                    film.setCertification(elements[i]);
                    break;
                case 9 :
                    film.setPoster_path(elements[i]);
                    break;
                case 10 :
                    int budget = Integer.parseInt(elements[i]);
                    film.setBudget(budget);
                    break;
                case 11 :
                    film.setTagline(elements[i]);
                    break;
                case 12 :
                    String[] Tabgenres = elements[12].split("\u2024");
                    Genres genre = new Genres();

                    for(String element1 : Tabgenres) {

                    }

                    break;
                case 13 :
                    String[] Tabreals = elements[13].split("\u2024");

                    for(String element2 : Tabreals) {

                    }

                    break;
                case 14 :
                    String[] Tabacteurs = elements[14].split("\u2024");

                    for(String element3 : Tabacteurs) {

                    }

                    break;
            }
            i++;
        }
    }

    public void writeXML() {

    }
}
