package controler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.LocalDate;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


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

            String path = System.getProperty("user.dir");
            String filePath = path + "\\1000movies.txt";
            File file = new File(filePath);

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            // Lit chaque ligne du fichier
            while ((line = bufferedReader.readLine()) != null) {

                //appelle de la fonction parse qui va décomposer chaque ligne du buffer
                Movie m = parse(line);
                films.add(m);
            }

            // Ferme le BufferedReader et le FileReader après avoir terminé
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

    //cette fonction va utiliser le tableau de film du singleton pour crée un fichier xml contenant tout les films
    public void writeXML()
    {
        try
        {
            //  responsable de la configuration de la création de documents XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Il prend en charge la création d'éléments, d'attributs, de texte
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Une fois que vous avez un DocumentBuilder, vous utilisez cette instance pour créer un nouveau
            // document vide (Document). Ce document est l'objet central avec lequel vous travaillez
            // pour créer la structure du fichier XML. Vous ajoutez des éléments, des attributs et d'autres nœuds à ce document.
            Document document = builder.newDocument();

            // ici on stocke des film donc voilas
            Element rootElement = document.createElement("movies");
            document.appendChild(rootElement);

            //ici pour chaque film on va alors ajouter element par element
            for (Movie film : films) {
                Element movieElement = document.createElement("movie");
                rootElement.appendChild(movieElement);

                // Ajoutez les données du film comme des éléments à l'élément "movie"
                Element idElement = document.createElement("id");
                idElement.appendChild(document.createTextNode(String.valueOf(film.getId())));
                movieElement.appendChild(idElement);

                Element titleElement = document.createElement("title");
                titleElement.appendChild(document.createTextNode(film.getTitle()));
                movieElement.appendChild(titleElement);

                Element originalTitleElement = document.createElement("originalTitle");
                originalTitleElement.appendChild(document.createTextNode(film.getOriginalTitle()));
                movieElement.appendChild(originalTitleElement);

                Element releaseDateElement = document.createElement("releaseDate");
                releaseDateElement.appendChild(document.createTextNode(film.getReleaseDate().toString()));
                movieElement.appendChild(releaseDateElement);

                Element statusElement = document.createElement("status");
                statusElement.appendChild(document.createTextNode(film.getStatus()));
                movieElement.appendChild(statusElement);

                Element voteAverageElement = document.createElement("voteAverage");
                voteAverageElement.appendChild(document.createTextNode(String.valueOf(film.getVote_average())));
                movieElement.appendChild(voteAverageElement);

                Element voteCountElement = document.createElement("voteCount");
                voteCountElement.appendChild(document.createTextNode(String.valueOf(film.getVote_count())));
                movieElement.appendChild(voteCountElement);

                Element runtimeElement = document.createElement("runtime");
                runtimeElement.appendChild(document.createTextNode(String.valueOf(film.getRuntime())));
                movieElement.appendChild(runtimeElement);

                Element certificationElement = document.createElement("certification");
                certificationElement.appendChild(document.createTextNode(film.getCertification()));
                movieElement.appendChild(certificationElement);

                Element posterPathElement = document.createElement("posterPath");
                posterPathElement.appendChild(document.createTextNode(film.getPoster_path()));
                movieElement.appendChild(posterPathElement);

                Element budgetElement = document.createElement("budget");
                budgetElement.appendChild(document.createTextNode(String.valueOf(film.getBudget())));
                movieElement.appendChild(budgetElement);

                Element taglineElement = document.createElement("tagline");
                taglineElement.appendChild(document.createTextNode(film.getTagline()));
                movieElement.appendChild(taglineElement);

                Element listGenresElement = document.createElement("genres");
                for(Genres genre: film.getGenres()) {
                    Element genreElement = document.createElement("genre");
                    listGenresElement.appendChild(genreElement);

                    Element idGenreElement = document.createElement("id");
                    idGenreElement.appendChild(document.createTextNode(String.valueOf(genre.id)));
                    genreElement.appendChild(idGenreElement);

                    Element nomGenreElement = document.createElement("nom");
                    nomGenreElement.appendChild(document.createTextNode(genre.genre));
                    genreElement.appendChild(nomGenreElement);
                }
                movieElement.appendChild(listGenresElement);

                Element listRealElement = document.createElement("directors");
                for(Realisateur real: film.getDirectors()) {
                    Element directorElement = document.createElement("director");
                    listRealElement.appendChild(directorElement);

                    Element idDirectorElement = document.createElement("id");
                    idDirectorElement.appendChild(document.createTextNode(String.valueOf(real.id)));
                    directorElement.appendChild(idDirectorElement);

                    Element nomDirectorElement = document.createElement("nom");
                    nomDirectorElement.appendChild(document.createTextNode(real.nom));
                    directorElement.appendChild(nomDirectorElement);
                }
                movieElement.appendChild(listRealElement);

                Element listActeursElement = document.createElement("actors");
                for(Acteur acteur: film.getActors()) {
                    Element acteurElement = document.createElement("actor");
                    listActeursElement.appendChild(acteurElement);

                    Element idActeurElement = document.createElement("id");
                    idActeurElement.appendChild(document.createTextNode(String.valueOf(acteur.id)));
                    acteurElement.appendChild(idActeurElement);

                    Element nomActeurElement = document.createElement("nom");
                    nomActeurElement.appendChild(document.createTextNode(acteur.nom));
                    acteurElement.appendChild(nomActeurElement);
                }
                movieElement.appendChild(listActeursElement);
            }

            // Enregistrez le document XML dans un fichier
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("movies.xml"));
            transformer.transform(source, result);

            System.out.println("Fichier XML créé avec succès.");
        }
        catch (TransformerException | ParserConfigurationException e)
        {
            e.printStackTrace();
        }
    }

}
