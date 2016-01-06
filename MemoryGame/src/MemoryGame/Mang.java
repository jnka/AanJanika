package MemoryGame;

import javafx.stage.Stage;

/**
 * Created by janikaa on 10.12.2015.
 * Mängu käivitamine
 */
public class Mang {
    Stage mang;

  public Mang () {
        mang = new Stage();

        //loome objektid
        Laud laud = new Laud();
        Mangija mangija = new Mangija();

        mangija.Tervitus();//ilmub konsoolis
  }

}
