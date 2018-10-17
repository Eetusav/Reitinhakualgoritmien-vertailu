# Testausdokumentti
Tiralabra 2018

## Yksikkötestaus

Ihan perus jUnit-testeillä yritetään saada koodikattavuus mahdollisimman korkeaksi. Testit ovat uudelleen ajettavissa. Testit pystyy ajamaan kansiossa 
Reitinhakualgoritmien-vertailu komennolla mvn test. 

### Dijkstra ja Floyd-Warshall

Molempien algoritmien kattavuus saatiin 100%:iin, joten ne ovat ok.

### Tietorakenteet

Myös tietorakenteet ovat testattu kattavasti. Ainoana puutteena on MyLinkedListin testaus, sillä luokka ei sisällä (vielä) mitään gettereita yms. MyHashSetin koodikattavuus on 0%, sillä sitä ei käytetä ohjelmassa, joten sitä ei ole tarpeellista testata.

### Utiliteetit

Käyttöliittymää ja VerkkoGeneraattoria ei ole oikein mielekästä testata. VerkkoGeneraattori on tehty lähinnä siihen, että eri tuloksia 
aikavaativuuksiin liittyen ulos ja että algoritmeja on helppo esitellä.


## Manuaalinen testaus

Manuaalista testausta suoritettiin 18:sta eri syötteen koolla väliltä 10-4000. Kummallakin algoritmilla otettiin kolme tulosta jokaisesta syötteestä ja kirjattiin ne ylös. Alla olevissa kuvissa kannattaa ottaa huomioon
y-akselin skaalautuvuus. Dijkstran algoritmissa saatiin arvoja 1-25 millisekunnin väliltä ja Floyd-Warshallissa arvoja saatiin väliltä 1-30000 millisekunttia, joten algoritmeissä oli suuria eroja. Kuvissa näkyy vaaleansinisinä pisteinä/palluroina otokset ja mustina pisteinä näkyy aina kolmen
otoksen (sama syöte) keskiarvo.

Dijkstran algoritmin ajankulutuksen kasvu syötteen kasvaessa näyttää erittäin maltilliselta. Floyd-Warshallin algoritmin ajankulutus taas näyttää mallintavan eksponentiaalista kasvua ja ajankulutus suorastaan räjähtää syötteen koon kasvaessa.
Floyd-Warshallin algoritmissa esiintyi jotain vääristymää syötteiden koilla 2500-3000, muuten kasvu esitti eksponentiaalista mallia. En osaa sanoa johtuiko virhe tavallisesta varianssista vai koneen lagista vai tekeekö Java jotain omia taikojaan taustalla. Todennäköisesti viimeisimmästä. 

Tämän lisäksi jälkeenpäin tehtiin manuaalista testausta tiheällä verkolla, vastaavalla tavalla kuin yllä. Tiheä verkko muodostui siten, että jokaisesta solmusta menee kaari kaikkiin muihin solmuihin. Tällöin Dijkstran algoritmi ei enää
näyttänyt enää niin maltillista kasvua, mutta kuitenkin vielä Floyd-Warshallia nopeampi. Kasvu näyttää lineaariselta, mutta olisin kylläkin odottanut pikemminkin eksponentiaalista kasvua. On oletettavaa, että verkon tiheydellä ei ole vaikutusta Floyd-Warshallin algoritmin ajankulutukseen, joten sitä ei ole testattu.

### Johtopäätöksiä

Jos halutaan löytää lyhimmät polut vain yhdestä solmusta, niin tällöin Dijkstran algoritmi on aina parempi vaihtoehto, myös tiheillä verkoilla. Jos halutaan löytää kaikista solmuista lyhimmät polut, niin usein on parempi valita Floyd-Warhsallin algoritmi. 
Verkossa, jossa kaarien lukumäärä ei ole kovin suuri, Floyd-Warshallin ja Dijkstran käyttämän ajan suhde näyttää olevan riippuvainen syötteen koosta. Hieman yksinkertaisesti ajatellen, jos kertoo Dijkstran käyttämän ajan syötteen koolla (eli etsitään kaikkien solmujen lyhimmät polut), niin tulos 
on aina Floyd-Warshallin käyttämää aikaa suurempi. Tämä johtunee siitä, että Dijkstrassa suoritetaan enemmän vakioaikaisia operaatioita kuin Floyd-Warshallissa. Jos verkko on tiheä, niin tämä tulos korostuu vielä enemmän. Täten on järkevää ajatella, että kaikkien solmujen lyhimpien polkujen etsimiseen
Floyd-Warshall on nopeampi valinta.


![Dijkstra](https://github.com/Eetusav/Reitinhakualgoritmien-vertailu/blob/master/Dokumentaatio/Dijkstra1.png)

![Dijkstra](https://github.com/Eetusav/Reitinhakualgoritmien-vertailu/blob/master/Dokumentaatio/DijkstraDense.png)

![Floyd-Warshall](https://github.com/Eetusav/Reitinhakualgoritmien-vertailu/blob/master/Dokumentaatio/FloydWarshall1.png)

![Tilasto](https://github.com/Eetusav/Reitinhakualgoritmien-vertailu/blob/master/Dokumentaatio/Tilasto1.PNG)

