package MemoryGame;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by janikaa on 10.12.2015.
 */
public class MemoryGame extends Application {
    //Stage mang;//klassimuutuja, klassis igalpool kättesaadav

    @Override //märge, mis ütleb, et käesolev meetod on super klassist (Application) üle kirjutatud.
    public void start(Stage primaryStage) throws Exception {
        new Mang();//käivitame mängu, siia saab hiljem uusi mängijaid luua, uusi Mange lisades
    }
}

/*
*Iga klass või objekt: 1) hoiab mingit infot (teab infot, muutuja); 2) teeb midagi (oskab midagi teha, meetod).
* Meie mängus "Memoriin" (MemoryGame) on 5 klassi:
*
* MemoryGame ehk Main
*   Oskab mängu käivitada
* Mang (Stage)
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
