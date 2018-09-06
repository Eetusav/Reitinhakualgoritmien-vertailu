# Määrittelydokumentti
Tiralabra 2018

Tavoitteena on vertailla paria reitinhakualgoritmia ja tutkia minkäläisia eroja algoritmien ajankulutuksella on. Nyt on valittu 
kaksi algoritmia, jolla on selvästi eri aikavaativuudet, jotta saataisiin eroavia tuloksia ulos. 
Valitut algoritmit: 
* Floyd-Warshall, joka etsii lyhimmän polujen kaikkien solmuparien välille. O(|V|^{3})
* Dijkstra, joka lähtösolmusta etsii lyhimmän polun kaikkiin muihin solmuihin. O((|E|+|V|)log|V|)

Tietorakenteina toteutetaan kyseisiin algoritemihin tarvittavat tietorakenteet, esim keko.
Ohjelmaan voi antaa erilaisia syötteitä, jotka vaikuttavat siihen minkälaista verkkoa tutkitaan.
Tavoitteena tietysti saavuttaa algoritmeille määritellyt aikavaativuudet ja lisäksi saada selvä ero algoritmien välileillä erilaisilla syötteillä.
Pääasiallisena lähteenä käytetään Tietorakenteet ja algoritmit-kurssin materiaalia.

## Floyd-Warshall
* Floyd-Warshall tarjoaa laajemman soveltuvuuden sillä se toimii myös negatiivisilla kaarilla ja etsii aina lyhimmän polun kaikille verkon solmuille.
* Oletuksena on, että verkko ei sisällä negatiivisia syklejä

### Toimintaidea lyhyesti (1, kalvo 546)
* Algoritmi hajoittaa ongelman pienempiin osaongelmiin ja laskee välituloksenaan etäisyysmatriiseja D0, D1,..., Dn.
* Matriisin Dk alkio Dk(i,j) pitää yllä tietoa siitä mikä on solmujen i, j lyhin etäisyys, jos niitä yhdistävä polku käyttää ainoastaan solmuja 1,2,3,...,k.
* Matriisi Dn kertoo halutun lopputuloksen kaikille solmuille i,j joukossa V

## Dijkstra 
* Dijkstran algoritmi tarjoaa nopeamman aikavaativuuden, mutta löytää vain lyhimmän polun lähtösolmusta
* Ei toimi negatiivisilla kaarilla
* Dijkstraa voi kutsua myös kaikille verkon solmuille, mutta aikavaativuus on Floyd-Warshallia hitaampi (tiheillä verkoilla)

### Toimintaidea lyhyesti (1, kalvo 527)
* Dijkstran algoritmi pitää yllä joukkoa S, joka muodostuu solmiosta joiden lyhin etäisyys solmuun s on jo selvitetty
* Algoritmi valitsee toistuvasti solmun u joukosta V\S, jonka etäisyysarvio solmuun s on pienin
  * Valittu solmu u lisätään joukkoon S, ja
  * kaikkien solmun u vierussolmujen v etäisyysarvio solmuun s sekä polkutieto päivitetään


## Lähteet
1 [Tietorakenteet ja algoritmit-kurssin materiaali](https://www.cs.helsinki.fi/u/saska/tira.pdf)
