# Toteutusdokumentti
Tiralabra 2018

## Ohjelman yleisrakenne

Ohjelman algoritmit sijaitsevat reitinhakualgoritmien.vertailu packagessa, jossa algoritmin Dijkstran luokka
sisältää myös algoritmin käyttämät metodit seuraavan käsiteltävän solmun hakuun sekä solmun ja vierussolmun minimi etäisyyden laskemiseen.
Omat tietorakenteet löytyvät tietorakenteet packagesta.

Molempien algoritmien toteutus on hyvin tavallinen. Dijkstran algoritmia pystyisi tietysti parannella käyttämällä keko-tietorakennetta.

## Aikavaativuus

Dijkstran algoritmin aikavaativuus on O(V^2), mitä pystyisi parantamaan aikaan O(E log(V)) käyttämällä minimikekoa. Edellä E viittaa kaarien määrään
ja V viittaa solmujen määrään.

Floyd-Warshall algoritmin aikavaativuus on selvästi kolmen for-lauseen takia O(V^3). Täten toteutettu Dijkstran algoritmi on (ainakin paperilla) Floyd-Warshallia nopeampi.

## Suorituskyky- ja O-analyysivertailu

Suorituskykyvertailua toteutettiin siten, että tehtiin yksinkertainen verkko (helppo toteuttaa) siten, että valittiin solmujen määrä n ja solmujen välille paino w.
Tällöin verkko muodostui seuraavanlaiseksi 1-w->2-w->3-w->...-w->n. Tämän jälkeen tarkasteltiin kuinka monta millisekuntia kummallakin algoritmilla kului aikaa. Ehkä vähän yksinkertainen ja tylsä tapa, mutta toimiva.


Suorituskykyvertailussa selvisi, että riittävän suurilla verkoilla Dijkstran algoritmi on huomattavasti nopeampi.
Esimerkiksi solmujen lukumäärällä 3000 (ja painolla 5) Dijkstran algoritmilla kului 18 millisekuntia ja Floyd-Warshallilla kului 12635 millisekunttia. 
Mikä on uskottava tulos aikavaativuuden kannalta. Tästä lisää testausdokumentissa.

## Puutteet

Dijkstran algoritmin olisi voinut toteuttaa aikavaativuudeltaan paremmaksi.

Ohjelmasta puuttuu (ainakin vielä) mahdollisuus löydetyn lyhimmän polun printtaamiseen.

Olisi myös ollut kiinnostavaa testata tiheillä verkoilla algoritmeja. Ehkä siihen löytyy vielä aikaa tulevaisuudessa.

## Lähteet

1 [Tietorakenteet ja algoritmit-kurssin materiaali](https://www.cs.helsinki.fi/u/saska/tira.pdf)

2 [geeksforgeeks.org Floyd-Warshall algoritmi](https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/)

3 [brilliant.org Floyd-Warshall algoritmi](https://brilliant.org/wiki/floyd-warshall-algorithm/)

4 [geeksforgeeks.org Dijkstran algoritmi](https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/)

5 [java2s.com LinkedList tietorakenne](http://www.java2s.com/Code/Java/Collections-Data-Structure/BuildyourownLinkedListclass.htm)