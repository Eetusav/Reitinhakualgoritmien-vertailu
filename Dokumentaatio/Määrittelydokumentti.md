# Määrittelydokumentti
Tiralabra 2018

Tavoitteena on vertailla paria reitinhakualgoritmia ja tukia minkäläisia eroja ajankulutuksella on. Nyt on valittu 
kaksi algoritmia, jolla on selvästi eri aikavaativuudet, jotta saataisiin eroavia tuloksia ulos. 
Valitut algoritmit: 
* Floyd-Warshall, joka etsii lyhimmän polujen kaikkien solmuparien välille. O(|V|^{3})
* Dijkstra, joka lähtösolmusta etsii lyhimmän polun kaikkiin muihin solmuihin. O((|E|+|V|)log|V|)

Tietorakenteina toteutetaan kyseisiin algoritemihin tarvittavat tietorakenteet.
Ohjelmaan voi antaa erilaisia syötteitä, jotka vaikuttavat siihen minkälaista verkkoa tutkitaan.
Tavoitteena tietysti saavuttaa algoritmeille määritellyt aikavaativuudet ja lisäksi saada selvä ero algoritmien välileillä erilaisilla syötteillä.
Pääasiallisena lähteenä käytetään Tietorakenteet ja algoritmit-kurssin materiaalia.
