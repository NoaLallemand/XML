package controler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
                parse(bufferedReader);

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
    public void parse(BufferedReader buffer) throws IOException
    {
        try{
            Movie film = new Movie();
            int PlaceMovie = 0;
            char caractere;
            StringBuilder motBuilder = new StringBuilder();

            //lis charactere par caractere
            while ((caractere = (char) buffer.read()) != -1)
            {
                //si un charactere est un separateur alors on remplis la variable concerner de film et on incremente placemovie
                if("/" == caractere)
                {
                    String mot = motBuilder.toString();
                    switch (PlaceMovie)
                    {
                        case 0 :
                            break;
                        case 1 : film.setTitle(mot);
                            break;
                        case 2 : film.setReleaseDate(mot);
                            break;
                        case 3 :
                            break;
                        case 4 :
                            break;
                        case 5 :
                            break;
                        case 6 :
                            break;
                        case 7 :
                            break;
                        case 8 :
                            break;
                        case 9 :
                            break;
                        case 10 :
                            break;
                        case 11 :
                            break;
                        case 12 :
                            break;
                        case 13 ://attention ici tableau a remplir
                            break;
                        case 14 ://attention ici tableau a remplir
                            break;
                        case 15 ://attention ici tableau a remplir
                            break;
                    }
                    PlaceMovie++;
                }
                else
                {
                    //ici on compose le champs qui va etre mis dans mon obj
                    char caractereLu = (char) caractere;
                    motBuilder.append(caractereLu);
                }
            }
        }
        catch(IOException e){
            System.out.print("erreur de lecture de charactere");
        }
    }

    public void writeXML() {

    }
}
