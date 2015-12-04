package MemoryGame;

/**
 * Created by janikaa on 4.12.2015.
 */
public class MemoryGame {
    public static void main(String[] args) {//Main meetod
        new Mang(); // käivitame mängu
        // Ideaalis siia klassi rohkem midagi ei tee, sest igal koodijupil on oma ülesanne, mis omakorda käivitatakse oma klassis
    }
}


/*
*Iga klass või objekt: 1) hoiab mingit infot (teab infot, muutuja); 2) teeb midagi (oskab midagi teha, meetod).
* Meie mängus "Memoriin" (MemoryGame) on 5 klassi:
*
* MemoryGame ehk Main (1)
*   Oskab mängu käivitada
* Mang (2)
*    Oskab mängu seadistada
*    Oskab mängu töös hoida
*    Oskab mängu lõpetada
* Mangija (kasutajaga suhtlemine)
*    Oskab küsida mängijalt, millist kaarti avada
*    Oskab anda tagasisidet, kui pildipaar arvati ära
*    Oskab anda tagasisidet, kui pildipaari ei arvatud ära
*    Oskab anda tagasisidet, kui mäng on läbi
* Laud (kõik tegevused, mis on piltide grupiga seotud)
*    Teab piltide asukohta
*    Oskab paigutada pildid lauale
*    Oskab koordineerida pilte (oskab neid tagurpidi keerata, kui pildipaar on leitud)
*    Oskab kontrollida, kas laual on veel pilte, mis ei ole avatud (ja leidnud paarilist)
*    Oskab mängu seisu näidata (prindib laua välja)
* Pilt (kaart ise, mis asub lauas)
*    Teab oma asukohta
*    Teab, kas ta on arvatud (avastatud mängija poolt)
*    Oskab laual kohta valida (tsükliga)
*    Oskab saada äraarvatuks (leiab paarilise ja lahkub mängust)
*    Oskab ennast ümberpöörata
*    Oskab jääda avatuks, kui on ära arvatud
*    Oskab öelda, kas on veel arvamata
*
*
*    VIITED ALLIKALE:
*    Objektorienteerituse loeng, Krister Viirsaar,
*/

