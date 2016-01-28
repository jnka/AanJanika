package MemoryGame;

import javafx.stage.Stage;

/**
 * Created by janikaa on 10.12.2015.
 */
public class Mang {
    Stage mang;//klassimuutuja, klassis igalpool kättesaadav

    public Mang () {
        mang = new Stage();

        //loome laua ja mängija objektid
        Laud laud = new Laud();
        Mangija mangija = new Mangija();

        //Mängu sisu.
        while (!laud.kasKoikPaaridOnLeitud()) {
            boolean paar = laud.kasTekkisPaar();
            if (paar) {
                mangija.paar();
            } else {
                mangija.arvamata();
            }
        }
        mangija.gameover();
    }
}
