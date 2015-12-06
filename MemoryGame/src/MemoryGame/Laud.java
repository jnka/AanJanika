package MemoryGame;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by janikaa on 4.12.2015.
 */
public class Laud {
    private Pilt[][] pildid;
    //private String[] sõnad ={"esimene", "teine", "kolmas", "neljas", "viies", "kuues", "seitsmes", "kaheksas"};
    private Random r;
    private Scanner lugeja;

    Laud(){
        r=new Random();
        lugeja=new Scanner(System.in);
        pildid = new Pilt[4][4];
        System.out.println(pildid);
    }
  //  private int lauaServaPikkus;//salvestab klassi külge ja siis saab seda tsüklites kasutada edaspidi üle terve klassi;
   // private Pilt[]pildid = new Pilt[2]; //"[]" - tähistab massiivi, tuleb 16 pilti (4x4);
    //Klass ei oska vastu võtta parameetrit, sellepärast ongi vaja konstruktorit;

  /*  public Laud (int pikkus) {//Loome konstruktori "Laud";
        System.out.println("START LAUD");//Kui käivitan programmi, saan kontrollida, kas ta on siia jõudnud
        lauaServaPikkus = pikkus;//Salvestame pikkuse
        looPildid();
    }

    private void looPildid() {//Laua käes on pildid, salvestame pildid laua külge:
        for (int i = 0; i < pildid.length; i++) {
            pildid[i] = new Pilt(lauaServaPikkus);
        }
    }
    public boolean kasPilteOnAlles(){
        for (Pilt pilt : pildid){
            boolean arvamata = pilt.kasOledArvamata();//küsib iga pildi käest
            if (arvamata){
                return true;
            }
        }
        return false;
    }*/
}
