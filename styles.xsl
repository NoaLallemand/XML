<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>Liste de Films</title>
                <style>
                    h1 { font-size: 24px; }
                    li { margin-bottom: 10px; }
                </style>
            </head>
            <body>
                <h1>Liste de Films</h1>

                <ul>
                    <xsl:for-each select="movies/movie">
                        <li>
                            <strong><xsl:value-of select="title" /></strong> (<xsl:value-of select="releaseDate" />)

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
                        <p>////////////////////////////////////////////////////////////////////////</p>
                    </xsl:for-each>
                </ul>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
