<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <link rel="stylesheet" type="text/css" href="style.css" />
                <title>Liste de Films</title>
            </head>
            <body>
                <div class="header">
                    <img src="logo.png" alt="logo site" class="logo-image" />
                    <input type="text" id="searchInput" placeholder="Rechercher un film..." />
                    <div id="searchResults"></div>
                </div>

                <ul>
                    <xsl:for-each select="movies/movie">
                        <div class="movie" style="min-height: 150px;">
                            <strong class="movie-title"><xsl:value-of select="title" /></strong> (<xsl:value-of select="releaseDate" />)
                        <br></br>
                            <br></br>
                            <button class="see-more-button">Voir Plus</button>
                            <ul class="hidden">
                                <li>
                                    <p><xsl:value-of select="originalTitle" /></p>
                                    <p><xsl:value-of select="status" /></p>
                                    <p><xsl:value-of select="vote_average" /></p>
                                    <p><xsl:value-of select="vote_count" /></p>
                                    <p><xsl:value-of select="runtime" /></p>
                                    <p><xsl:value-of select="certification" /></p>
                                    <p><xsl:value-of select="poster_path" /></p>
                                    <p><xsl:value-of select="budget" /></p>
                                    <p><xsl:value-of select="tagline" /></p>
                                    <p><strong>Genre(s):</strong></p>
                                    <ul>
                                        <xsl:for-each select="genres/genre">
                                            <li><xsl:value-of select="id" /></li>
                                            <li><xsl:value-of select="nom" /></li>
                                            <p>......................</p>
                                        </xsl:for-each>
                                    </ul>
                                    <p><strong>Directeur(s):</strong></p>
                                    <ul>
                                        <xsl:for-each select="directors/director">
                                            <li><xsl:value-of select="nom" /></li>
                                            <li><xsl:value-of select="id" /></li>
                                            <p>......................</p>
                                        </xsl:for-each>
                                    </ul>
                                    <p><strong>Acteur(s):</strong></p>
                                    <ul>
                                        <xsl:for-each select="actors/actor">
                                            <li><xsl:value-of select="id" /></li>
                                            <li><xsl:value-of select="nom" /></li>
                                            <li><xsl:value-of select="personnage" /></li>
                                            <p>......................</p>
                                        </xsl:for-each>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </xsl:for-each>
                </ul>

                <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
                <script>
                    $(document).ready(function () {
                    $(".movie .see-more-button").click(function () {
                    $(this).siblings("ul.hidden").slideToggle();
                    });

                    // Cacher les détails par défaut
                    $(".movie ul.hidden").hide();

                    // Sélectionnez l'élément d'entrée de recherche
                    var searchInput = document.getElementById("searchInput");

                    // Sélectionnez l'élément où afficher les résultats
                    var searchResults = document.getElementById("searchResults");

                    // Sélectionnez tous les éléments de film
                    var movies = document.querySelectorAll(".movie");

                    searchInput.addEventListener("input", function () {
                    var searchTerm = searchInput.value.toLowerCase();

                    // Réinitialisez les résultats de recherche
                    searchResults.innerHTML = "";

                    movies.forEach(function (movie) {
                    var title = movie.querySelector(".movie-title").textContent.toLowerCase();

                    if (title.includes(searchTerm)) {
                    // Si le titre correspond, ajoutez le film aux résultats de recherche
                    searchResults.appendChild(movie.cloneNode(true));
                    }
                    });
                    });
                    });
                </script>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>

