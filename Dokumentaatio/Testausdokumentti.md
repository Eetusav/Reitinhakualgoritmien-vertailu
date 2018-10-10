# Testausdokumentti
Tiralabra 2018

## Yksikkötestaus

Ihan perus jUnit-testeillä yritetään saada koodikattavuus mahdollisimman korkeaksi. Testit ovat uudelleen ajettavissa. Testit pystyy ajamaan kansiossa 
Reitinhakualgoritmien-vertailu komennolla mvn test. 

### Dijkstra ja Floyd-Warshall

Molempien algoritmien kattavuus saatiin 100%:iin, joten ne ovat ok.

### Tietorakenteet

Myös tietorakenteet ovat testattu kattavasti. Ainoana puutteena on MyLinkedListin testaus, sillä luokka ei sisällä (vielä) mitään gettereita yms.

### Utiliteetit

Käyttöliittymää ja VerkkoGeneraattoria ei ole oikein mielekästä testata. VerkkoGeneraattori on tehty lähinnä siihen, että eri tuloksia 
aikavaativuuksiin liittyen ulos ja että algoritmeja on helppo esitellä.


## Manuaalinen testaus

Manuaalista testausta suoritettiin 18:sta eri syötteen koolla väliltä 10-4000. Kummallakin algoritmilla otettiin kolme tulosta jokaisesta syötteestä ja kirjattiin ne ylös. Alla olevissa kuvissa kannattaa ottaa huomioon
y-akselin skaalautuvuus. Dijkstran algoritmissa saatiin arvoja 1-25 millisekunnin väliltä ja Floyd-Warshallissa arvoja saatiin väliltä 1-30000 millisekunttia, joten algoritmeissä oli suuria eroja. Kuvissa näkyy vaaleansinisinä pisteinä/palluroina otokset ja mustina pisteinä näkyy aina kolmen
otoksen (sama syöte) keskiarvo.

Dijkstran algoritmin ajankulutuksen kasvu syötteen kasvaessa näyttää erittäin maltilliselta. Floyd-Warshallin algoritmin ajankulutus taas näyttää mallintavan eksponentiaalista kasvua ja ajankulutus suorastaan räjähtää syötteen koon kasvaessa.
Floyd-Warshallin algoritmissa esiintyi jotain vääristymää syötteiden koilla 2500-3000, muuten kasvu esitti eksponentiaalista mallia. En osaa sanoa johtuiko virhe tavallisesta varianssista vai koneen lagista vai mistä.

![Dijkstra](https://github.com/Eetusav/Reitinhakualgoritmien-vertailu/blob/master/Dokumentaatio/Dijkstra1.png)

![Floyd-Warshall](https://github.com/Eetusav/Reitinhakualgoritmien-vertailu/blob/master/Dokumentaatio/FloydWarshall1.png)

![Tilasto](https://github.com/Eetusav/Reitinhakualgoritmien-vertailu/blob/master/Dokumentaatio/Tilasto1.png)

