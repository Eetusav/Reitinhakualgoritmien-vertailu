# Testausdokumentti
Tiralabra 2018

## Yksikk�testaus

Ihan perus jUnit-testeill� yritet��n saada koodikattavuus mahdollisimman korkeaksi. Testit ovat uudelleen ajettavissa. Testit pystyy ajamaan kansiossa 
Reitinhakualgoritmien-vertailu komennolla mvn test. 

### Dijkstra ja Floyd-Warshall

Molempien algoritmien kattavuus saatiin 100%:iin, joten ne ovat ok.

### Tietorakenteet

My�s tietorakenteet ovat testattu kattavasti. Ainoana puutteena on MyLinkedListin testaus, sill� luokka ei sis�ll� (viel�) mit��n gettereita yms.

### Utiliteetit

K�ytt�liittym�� ja VerkkoGeneraattoria ei ole oikein mielek�st� testata. VerkkoGeneraattori on tehty l�hinn� siihen, ett� eri tuloksia 
aikavaativuuksiin liittyen ulos ja ett� algoritmeja on helppo esitell�.


## Manuaalinen testaus

Manuaalista testausta suoritettiin 18:sta eri sy�tteen koolla v�lilt� 10-4000. Kummallakin algoritmilla otettiin kolme tulosta jokaisesta sy�tteest� ja kirjattiin ne yl�s. Alla olevissa kuvissa kannattaa ottaa huomioon
y-akselin skaalautuvuus. Dijkstran algoritmissa saatiin arvoja 1-25 millisekunnin v�lilt� ja Floyd-Warshallissa arvoja saatiin v�lilt� 1-30000 millisekunttia, joten algoritmeiss� oli suuria eroja. Kuvissa n�kyy vaaleansinisin� pistein�/palluroina otokset ja mustina pistein� n�kyy aina kolmen
otoksen (sama sy�te) keskiarvo.

Dijkstran algoritmin ajankulutuksen kasvu sy�tteen kasvaessa n�ytt�� eritt�in maltilliselta. Floyd-Warshallin algoritmin ajankulutus taas n�ytt�� mallintavan eksponentiaalista kasvua ja ajankulutus suorastaan r�j�ht�� sy�tteen koon kasvaessa.
Floyd-Warshallin algoritmissa esiintyi jotain v��ristym�� sy�tteiden koilla 2500-3000, muuten kasvu esitti eksponentiaalista mallia. En osaa sanoa johtuiko virhe tavallisesta varianssista vai koneen lagista vai mist�.

![Dijkstra](https://github.com/Eetusav/Reitinhakualgoritmien-vertailu/blob/master/Dokumentaatio/Dijkstra1.png)

![Floyd-Warshall](https://github.com/Eetusav/Reitinhakualgoritmien-vertailu/blob/master/Dokumentaatio/FloydWarshall1.png)

![Tilasto](https://github.com/Eetusav/Reitinhakualgoritmien-vertailu/blob/master/Dokumentaatio/Tilasto1.PNG)

