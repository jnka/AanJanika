package MemoryGame;

import javafx.stage.Stage;

/**
 * Created by janikaa on 10.12.2015.
 *
 * Laua genereerimine.
 * Kontrollib, kas tekkis paar ja kui paarid leitud, siis lõpetab mängu.
 *
 */
public class Mang {
    Stage mang;//klassimuutuja, klassi piires igalpool kättesaadav

  public Mang () {
        mang = new Stage();

        //loome objektid
        Laud laud = new Laud();
        Mangija mangija = new Mangija();

        /*mängu sisu
        while (laud.kasOnPilteAlles()) {
            boolean paar = laud.kasTekkisPaar;//kasTekkisPaar meetod on kirjutamata
            if (paar) {
                mangija.paar();
            } else {
                mangija.arvamata();
            }
        }
        mangija.gameover();*/
    }
}