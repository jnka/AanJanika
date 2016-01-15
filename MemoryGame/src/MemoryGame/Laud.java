package MemoryGame;


import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;



/**
 * Created by janikaa on 10.12.2015.
 */
public class Laud {
    Stage mang;//klassimuutuja, klassis igalpool kättesaadav
    StackPane maailm;
    GridPane laud;//klassimuutuja, klassis igalpool kättesaadav
    private int pildiKylg = 150;
    private int laualRidasid = 4;
    private int laualTulpasid = laualRidasid;
    private int paarideArv = (laualRidasid*laualTulpasid)/2;
    private int piltideVaheLauas = 5;
    private int piksleidLai = pildiKylg*laualTulpasid+(laualTulpasid*piltideVaheLauas);
    private int piksleidKorge = pildiKylg*laualRidasid+(laualRidasid*piltideVaheLauas);
    ArrayList<Pilt> pildid = new ArrayList<>(paarideArv);


    public Laud () {
        maailm = new StackPane();
        mang = new Stage();
        laud = new GridPane();
        maailm.getChildren().add(laud);
        Scene manguStseen = new Scene(maailm, piksleidLai, piksleidKorge);
        mang.setScene(manguStseen);
        mang.show();//ava aken
        mang.setOnCloseRequest(event -> System.exit(0));//akna sulgedes läheb programm kinni
        mang.setTitle("Memoriin");

        genereeriPildid();
        reageeriKlikile();
    }

    //klikile reageerimise meetod
    private void reageeriKlikile() {
        laud.setOnMouseClicked(event -> {

            //event.getTarget teab millisele rectagelile ehk kaardile klikiti
            Rectangle kaart = (Rectangle) event.getTarget();

            //võtame kasutusse rectangeli vanema ehk pildi
            Pilt pilt = (Pilt) kaart.getParent();
            System.out.println(pilt);

            //määrame piltidele uued nimed, et neid võrrelda
            Pilt pilt1 = pilt;
            Pilt pilt2 = pilt;

            //kui pilt on juba avatud, siis ära tee midagi (ütleb konsoolis, et on juba avatud)
            if (pilt.piltOnAvatud())
                return;

            //kui ühtegi pili ei ole avatud siis avab esimese, kui üks on juba avatud siis avab teise
            //EI LEIA PAARE, sest ei oska panna võrdlema kahe pildi ID-sid, mis on pildil oleva numbriga sama väärtusega
            if (!kasVahemaltUksPiltOnAvatud()) {
                System.out.println("ühtegi pilti ei ole veel avatud");
                pilt1.avaEsimenePilt(() -> {
                    System.out.println(pilt1);
                    System.out.println(pilt1.getId());
                });
            } else if (kasVahemaltUksPiltOnAvatud()) {
                System.out.println("vähemalt üks pilt on juba avatud");
                pilt2.avaTeinePilt(() -> {
                    System.out.println(pilt2);
                    System.out.println(pilt2.getId());
                    suleKoikPildid();
                });
            }



            //paari testimine, aga Ei tööta! leiab paari kummagi pildi kohta iseendaga.
            if (pilt1.number.getText().equals(pilt2.number.getText())) {
                System.out.println("Paar!");
            }

        });
        //sule mängu alguses kõik pildid
        suleKoikPildid();
    }


    //küsib pildi klassist iga pildi käest kas ta on avatud
    public boolean kasVahemaltUksPiltOnAvatud() {
        for (Pilt pilt : pildid) {
            boolean vahemaltUksPiltOnAvatud = pilt.piltOnAvatud();
            if (vahemaltUksPiltOnAvatud) {
                return true;//tagastab meetodi tulemuse ehk et vähemalt üks pilt on avatud, kui seda käsku näeb, siis enam edasi ei lähe
            }
        }
        return false;//if käib kõik pildid läbi ja kui ei jõudnud tulemuseni, et mingi pilt oleks avatud, siis tuleb siia
    }

    /*//kutsub pildi klassist meetodi avaPilt
    public void avaPilt () {
        for (Pilt pilt : pildid) {
            pilt.avaEsimenePilt(() -> {
            });
        }
    }*/

    //kutsub pildi klaasist meetodi peidaPilt
    public void suleKoikPildid() {
        for (Pilt pilt : pildid) {
            pilt.peidaPilt();
        }
    }

    //meetod, mis loob pildid, segab ja asetab lauale
    public void genereeriPildid() {

        //loome piltide paarid ArrayListi
        int nr = 1;

        //kui see lause tõsta laua klassi külge, siis boolean kasVahemaltUksPiltOnAvatud ei näita viga, aga ei tea kas ikka töötab
        for (int i = 0; i < paarideArv; i++) {
            pildid.add(new Pilt(String.valueOf(nr)));//Pildi loomine, prindib numbri tektiväärtusteks, sama mis Pilt pilt = new Pilt(String.valueOf(nr));
            pildid.add(new Pilt(String.valueOf(nr)));
            nr++;//suurendab pildile tulevaid numbreid ühe võrra
        }

        //segame pildid
        Collections.shuffle(pildid);
        System.out.println(pildid);

        //paneme pildid lauda
        for (int i=0; i < pildid.size(); i++) {
            Pilt pilt = pildid.get(i);
            pilt.setTranslateX((pildiKylg+piltideVaheLauas) * (i % laualRidasid));
            pilt.setTranslateY((pildiKylg+piltideVaheLauas) * (i / laualTulpasid));
            laud.getChildren().add(pilt);
        }
    }
}
