# Toteutusdokumentti
Tiralabra 2018

## Ohjelman yleisrakenne

Ohjelman algoritmit sijaitsevat reitinhakualgoritmien.vertailu packagessa, jossa algoritmin Dijkstran luokka
sis�lt�� my�s algoritmin k�ytt�m�t metodit seuraavan k�sitelt�v�n solmun hakuun sek� solmun ja vierussolmun minimi et�isyyden laskemiseen.
Omat tietorakenteet l�ytyv�t tietorakenteet packagesta.

Molempien algoritmien toteutus on hyvin tavallinen. Dijkstran algoritmia pystyisi tietysti parannella k�ytt�m�ll� keko-tietorakennetta.

## Aikavaativuus

Dijkstran algoritmin aikavaativuus on O(V(V+E)), mit� pystyisi parantamaan aikaan O(E log(V)) k�ytt�m�ll� minimikekoa. Edell� E viittaa kaarien m��r��n
ja V viittaa solmujen m��r��n.

Floyd-Warshall algoritmin aikavaativuus on selv�sti kolmen for-lauseen takia O(V^3). T�ten toteutettu Dijkstran algoritmi on Floyd-Warshallia nopeampi verkoilla, joissa kaarien lukum��r� ei ole valtava.

## Suorituskyky- ja O-analyysivertailu

Suorituskykyvertailua toteutettiin siten, ett� tehtiin yksinkertainen verkko (helppo toteuttaa) siten, ett� valittiin solmujen m��r� n ja solmujen v�lille paino w.
T�ll�in verkko muodostui seuraavanlaiseksi 1-w->2-w->3-w->...-w->n. T�m�n j�lkeen tarkasteltiin kuinka monta millisekuntia kummallakin algoritmilla kului aikaa. Ehk� v�h�n yksinkertainen ja tyls� tapa, mutta toimiva.


Suorituskykyvertailussa selvisi, ett� riitt�v�n suurilla verkoilla Dijkstran algoritmi on huomattavasti nopeampi.
Esimerkiksi solmujen lukum��r�ll� 3000 (ja painolla 5) Dijkstran algoritmilla kului 18 millisekuntia ja Floyd-Warshallilla kului 12635 millisekunttia. 
Mik� on uskottava tulos aikavaativuuden kannalta. J�lkeen p�in lis�ttiin my�s Dijkstran algoritmille aikavaativuustarkastelu, kun tutkittavana oli tiheit� verkkoja. T�st� lis�� testausdokumentissa.

T�ytyy tietysti muistaa, ett� Dijkstran algoritmi mahdollistaa vain lyhimpien polkujen etsimiseen l�ht�solmusta (eli yhdest� solmusta), kun taas Floyd-Warshall tarjoaa kaikkien polkujen l�ytymisen.

## Puutteet

Dijkstran algoritmin olisi voinut toteuttaa aikavaativuudeltaan paremmaksi.

Ohjelmasta puuttuu (ainakin viel�) mahdollisuus l�ydetyn lyhimm�n polun printtaamiseen.


## L�hteet

1 [Tietorakenteet ja algoritmit-kurssin materiaali](https://www.cs.helsinki.fi/u/saska/tira.pdf)

2 [geeksforgeeks.org Floyd-Warshall algoritmi](https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/)

3 [brilliant.org Floyd-Warshall algoritmi](https://brilliant.org/wiki/floyd-warshall-algorithm/)

4 [geeksforgeeks.org Dijkstran algoritmi](https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/)

5 [java2s.com LinkedList tietorakenne](http://www.java2s.com/Code/Java/Collections-Data-Structure/BuildyourownLinkedListclass.htm)