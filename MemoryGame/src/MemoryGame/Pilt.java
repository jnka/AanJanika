package MemoryGame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by janikaa on 13.12.2015.
 */
public class Pilt extends Rectangle{
    private boolean olenAllesPilt = true;
    public Pilt(int i) {
        super();
        setWidth(i);
        setHeight(i);
        setFill(Color.BLUE);
        setStroke(Color.BLACK);//seda vıib ka mitte teha
        setOnMouseClicked(event -> {
            System.out.println("Klikkisin");
            String pildiId = getId();//teeme id1 ja id2 ja siis if lauses kontrollime, kas vırduvad omavahel, selle asemel, et kontrollime kas on Pilt1 vıi Pilt2?
            if (pildiId.equals("pilt1")) {//peame siia kahe erineva pildi vırdluse tekitama ja kaks klikki tuleb teha enne hinnangut. If kui on paar.
                setFill(Color.WHITESMOKE);
                setId("paar");
            } else if (pildiId.equals("pilt2")) {//if kui ei ole paar
                setFill((Color.BLUE));//kui ei olnud paar, siis v‰rvib siniseks tagasi
                setId(("arvamata"));//panime praegu, et on arvamata, et game overit kontrollida, kui j‰tame id pilt2, siis ei jıuagi m‰ngu lıppu pilteAlles meetodis
            } else if (pildiId.equals("paar")) {
                System.out.println("Juba arvatud pilt!");
            }
            if (!kasOledAlles()) {//kui pilte ei ole alles siis prindib m‰ng l‰bi
                System.out.println("M‰ng l‰bi!");
                //gameOver();
            }
        });
    }

    public boolean kasOledAlles() {//EI T÷÷TA, sest ei saa lauda k‰tte, aga see meetod peaks pigem siin asuma
        return olenAllesPilt;//tagastab meetodi tulemuse ehk et pilte on veel alles, kui seda k‰sku n‰eb, siis enam edasi ei l‰he
    }

}
