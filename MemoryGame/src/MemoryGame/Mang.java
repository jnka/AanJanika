package MemoryGame;

/**
 * Created by janikaa on 4.12.2015.
 * Pildi ja Laua genereerimine
 * Kui pilt eon veel laual,
 *  küsi kasutajalt sisendkoordinaadid
 *  vali kaarte
 *  anna tagasisidet
 * Mäng on läbi
 */

public class Mang {
    public Mang() {//Konstruktor käivitab objekti "Mang" (objekt on klassiga alati sama nimega, siis ta oskab käivitada seda)
        System.out.println("START MÄNG"); //Prindime välja teksti "START MÄNG"

        // Loome objektid Laud ja Pilt:
        Laud laud = new Laud (4); //Genereerime laua ruudustiku 4x4
        //Mangija mangija = new Mangija();

        //mängu töös hoidmine
        //while (laud.kasPilteOnAlles()){
         //   System.out.println("NEXT ROUND");

    }
}


