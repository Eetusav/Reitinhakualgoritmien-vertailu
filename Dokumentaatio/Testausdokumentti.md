# Testausdokumentti
Tiralabra 2018

## Yksikk�testaus

Ihan perus jUnit-testeill� yritet��n saada koodikattavuus mahdollisimman korkeaksi. Testit ovat uudelleen ajettavissa. Testit pystyy ajamaan kansiossa 
Reitinhakualgoritmien-vertailu komennolla mvn test. 

### Dijkstra ja Floyd-Warshall

Molempien algoritmien kattavuus saatiin 100%:iin, joten ne ovat ok.

### Tietorakenteet

My�s tietorakenteet ovat testattu kattavasti. Ainoana puutteena on MyLinkedListin testaus, sill� luokka ei sis�ll� (viel�) mit��n gettereita yms. MyHashSetin koodikattavuus on 0%, sill� sit� ei k�ytet� ohjelmassa, joten sit� ei ole tarpeellista testata.

### Utiliteetit

K�ytt�liittym�� ja VerkkoGeneraattoria ei ole oikein mielek�st� testata. VerkkoGeneraattori on tehty l�hinn� siihen, ett� eri tuloksia 
aikavaativuuksiin liittyen ulos ja ett� algoritmeja on helppo esitell�.


## Manuaalinen testaus

Manuaalista testausta suoritettiin 18:sta eri sy�tteen koolla v�lilt� 10-4000. Kummallakin algoritmilla otettiin kolme tulosta jokaisesta sy�tteest� ja kirjattiin ne yl�s. Alla olevissa kuvissa kannattaa ottaa huomioon
y-akselin skaalautuvuus. Dijkstran algoritmissa saatiin arvoja 1-25 millisekunnin v�lilt� ja Floyd-Warshallissa arvoja saatiin v�lilt� 1-30000 millisekunttia, joten algoritmeiss� oli suuria eroja. Kuvissa n�kyy vaaleansinisin� pistein�/palluroina otokset ja mustina pistein� n�kyy aina kolmen
otoksen (sama sy�te) keskiarvo.

Dijkstran algoritmin ajankulutuksen kasvu sy�tteen kasvaessa n�ytt�� eritt�in maltilliselta. Floyd-Warshallin algoritmin ajankulutus taas n�ytt�� mallintavan eksponentiaalista kasvua ja ajankulutus suorastaan r�j�ht�� sy�tteen koon kasvaessa.
Floyd-Warshallin algoritmissa esiintyi jotain v��ristym�� sy�tteiden koilla 2500-3000, muuten kasvu esitti eksponentiaalista mallia. En osaa sanoa johtuiko virhe tavallisesta varianssista vai koneen lagista vai tekeek� Java jotain omia taikojaan taustalla. Todenn�k�isesti viimeisimm�st�. 

T�m�n lis�ksi j�lkeenp�in tehtiin manuaalista testausta tihe�ll� verkolla, vastaavalla tavalla kuin yll�. Tihe� verkko muodostui siten, ett� jokaisesta solmusta menee kaari kaikkiin muihin solmuihin. T�ll�in Dijkstran algoritmi ei en��
n�ytt�nyt en�� niin maltillista kasvua, mutta kuitenkin viel� Floyd-Warshallia nopeampi. Kasvu n�ytt�� lineaariselta, mutta olisin kyll�kin odottanut pikemminkin eksponentiaalista kasvua. On oletettavaa, ett� verkon tiheydell� ei ole vaikutusta Floyd-Warshallin algoritmin ajankulutukseen, joten sit� ei ole testattu.

### Johtop��t�ksi�

Jos halutaan l�yt�� lyhimm�t polut vain yhdest� solmusta, niin t�ll�in Dijkstran algoritmi on aina parempi vaihtoehto, my�s tiheill� verkoilla. Jos halutaan l�yt�� kaikista solmuista lyhimm�t polut, niin usein on parempi valita Floyd-Warhsallin algoritmi. 
Verkossa, jossa kaarien lukum��r� ei ole kovin suuri, Floyd-Warshallin ja Dijkstran k�ytt�m�n ajan suhde n�ytt�� olevan riippuvainen sy�tteen koosta. Hieman yksinkertaisesti ajatellen, jos kertoo Dijkstran k�ytt�m�n ajan sy�tteen koolla (eli etsit��n kaikkien solmujen lyhimm�t polut), niin tulos 
on aina Floyd-Warshallin k�ytt�m�� aikaa suurempi. T�m� johtunee siit�, ett� Dijkstrassa suoritetaan enemm�n vakioaikaisia operaatioita kuin Floyd-Warshallissa. Jos verkko on tihe�, niin t�m� tulos korostuu viel� enemm�n. T�ten on j�rkev�� ajatella, ett� kaikkien solmujen lyhimpien polkujen etsimiseen
Floyd-Warshall on nopeampi valinta.


![Dijkstra](https://github.com/Eetusav/Reitinhakualgoritmien-vertailu/blob/master/Dokumentaatio/Dijkstra1.png)

![Dijkstra](https://github.com/Eetusav/Reitinhakualgoritmien-vertailu/blob/master/Dokumentaatio/DijkstraDense.png)

![Floyd-Warshall](https://github.com/Eetusav/Reitinhakualgoritmien-vertailu/blob/master/Dokumentaatio/FloydWarshall1.png)

![Tilasto](https://github.com/Eetusav/Reitinhakualgoritmien-vertailu/blob/master/Dokumentaatio/Tilasto1.PNG)

