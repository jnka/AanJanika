package MemoryGame;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import javax.management.timer.Timer;
import java.time.Duration;

/**
 * Created by janikaa on 10.12.2015.
 */
public class MemoryGame extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        new Mang();//käivitame mängu, siia saab hiljem uusi mängijaid luua, uusi Mange lisades
    }
    public static void main(String[] args) {
        launch(args);
    }

}


/*
*Iga klass või objekt: 1) hoiab mingit infot (teab infot, muutuja); 2) teeb midagi (oskab midagi teha, meetod).
* Meie mängus "Memoriin" (MemoryGame) on 4 klassi ja üks subklass:
*
* MemoryGame ehk Main
*   Oskab mängu käivitada
* Mang (Stage)
*    Oskab mängu seadistada
*    Oskab mängu töös hoida
*    Oskab mängu lõpetada
* Mangija (kasutajaga suhtlemine)
*   Oskab mängijaga suhelda
* Laud (kõik tegevused, mis on piltide grupiga seotud)
*    Teab piltide asukohta
*    Oskab paigutada pildid lauale
*    Oskab koordineerida pilte (oskab neid tagurpidi keerata, kui pildipaar on leitud)
*    Oskab kontrollida, kas laual on veel pilte, mis ei ole avatud (ja leidnud paarilist)
* Pilt (kaart ise, mis asub lauas), on Laua alamklass:
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
*    Objektorienteerituse praktikumid Laevadepommitamise kohta JavaFX-is ja OOP, Krister Viirsaar,
*    JavaFX Game Tutorial: Memory Puzzle, kättesaadav: https://www.youtube.com/watch?v=QjuytZhQYo8
*    Värvide hajuvus: https://docs.oracle.com/javafx/2/animations/basics.htm
*    Taimer: http://stackoverflow.com/questions/9355303/javafx-stopwatch-timer
*    GUI: http://www.javak.co.za/tutorials/guiprimer/
*
*
*/
