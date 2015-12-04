package MemoryGame;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by janikaa on 4.12.2015.
 */
public class Pilt {
    private int[] asukoht;//teab oma asukohta, xy-massiv;
    private boolean arvamata = true;//teab, kas on pihta saanud;

    public Pilt(int lauaServaPikkus) {
        //System.out.println("START PILT");
        genereeriAsukoht(lauaServaPikkus);
    }

    private void genereeriAsukoht(int lauaServaPikkus) {
        Random rand = new Random();
        int x = rand.nextInt(lauaServaPikkus);
        int y = rand.nextInt(lauaServaPikkus);
        asukoht = new int[] {x, y};
        System.out.println(Arrays.toString(asukoht));
    }

    public boolean kasOledArvamata(){
        return arvamata;
    }

}
