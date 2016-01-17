package MemoryGame;



import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;



/**
 * Created by janikaa on 10.12.2015.
 */
public class Laud {
    Stage mang;//klassimuutuja, klassis igalpool kättesaadav
    BorderPane maailm;
    GridPane laud;//klassimuutuja, klassis igalpool kättesaadav
    private int pildiKylg = 150;
    private int laualRidasid = 4;
    private int laualTulpasid = laualRidasid;
    private int paarideArv = (laualRidasid*laualTulpasid)/2;
    private int piltideVaheLauas = 5;
    private int piksleidLai = pildiKylg*laualTulpasid+(laualTulpasid*piltideVaheLauas);
    private int piksleidKorge = pildiKylg*laualRidasid+(laualRidasid*piltideVaheLauas);
    ArrayList<Pilt> pildid = new ArrayList<>(paarideArv);
    public Pilt esimenePilt;
    public Pilt arvatudPilt;


    public Laud () {
        mang = new Stage();
        mang.setTitle("Memoriin");
        maailm = new BorderPane();
        laud = new GridPane();
        maailm.getChildren().add(laud);
        Scene manguStseen = new Scene(maailm, piksleidLai, piksleidKorge);

        //MENÜÜRIBA
        MenuBar menuuRiba = new MenuBar();
        maailm.setTop(menuuRiba);

        //Menüü nupp "Tegevus"
        Menu tegevused = new Menu("Tegevus");

        //Menüü "tegevus" alategevused
        MenuItem uusMang = new MenuItem("Uus mäng");
        MenuItem sulgeMang = new MenuItem("Sulge mäng");

        //Lisa alategevused menuu nupu "Tegevus" alla
        tegevused.getItems().addAll(uusMang, sulgeMang);

        //Menüü nupp "Spikker"
        Menu spikker = new Menu("Spikker");

        //Menüü "Spikker" alategevused
        MenuItem kuidasMangida = new MenuItem("Kuidas mängida?");
        spikker.getItems().addAll(kuidasMangida);

        //Lisa menüü nupud menüüribale
        menuuRiba.getMenus().addAll(tegevused, spikker);

        //VALIKUTERIBA
        ToolBar valikuteriba = new ToolBar();
        maailm.setBottom(valikuteriba);

        //Valikuteriba nupp "Alusta mängu", Pausi nupp "Paus", timer läheb tööle, kui vajutatakse "Alusta mängu" nuppu
        Button alustaMangu = new Button("Alusta mängu");
        Button stop = new Button("Stop");

        //Taimer
        KTimer ktimer;
        Label timeLabel;
        ktimer = new KTimer();
        timeLabel = new Label(ktimer.getSspTime().get());
        ktimer.getSspTime().addListener(new InvalidationListener() {

            @Override
            public void invalidated(Observable observable) {
                timeLabel.setText(ktimer.getSspTime().get());
            }
        });

        valikuteriba.getItems().addAll(alustaMangu, stop, timeLabel);

        //Taimer hakkab tööle, kui vajutada nuppu "Alusta mängu", siit saab ka pausi peale panna.
        alustaMangu.setOnAction(e -> {
            ktimer.startTimer(ktimer.getTime());
        });

        //Peata taimer
        stop.setOnAction(e -> {
            ktimer.stopTimer();
        });

        mang.setScene(manguStseen);
        mang.show();//ava aken
        mang.setOnCloseRequest(event -> System.exit(0));//akna sulgedes läheb programm kinni


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

            //kui pilt on juba avatud, siis ära tee midagi (ütleb konsoolis, et on juba avatud)
            if (pilt.piltOnAvatud())
                return;

            //kui ühtegi pili ei ole avatud siis avab esimese, kui üks on juba avatud siis avab teise
            //EI JÄTA PAARE AVATUKS
            if (!kasVahemaltUksPiltOnAvatud()) {
                System.out.println("ühtegi pilti ei ole veel avatud");
                pilt.avaEsimenePilt(() -> {
                    esimenePilt = pilt;
                    System.out.println(esimenePilt);
                    System.out.println(esimenePilt.getId());
                });
            } else if (kasVahemaltUksPiltOnAvatud()) {
                System.out.println("vähemalt üks pilt on juba avatud");
                pilt.avaTeinePilt(() -> {
                    System.out.println(pilt);
                    System.out.println(pilt.getId());
                    if (!esimenePilt.number.getText().equals(pilt.number.getText())) {
                        System.out.println("Ei ole paar!");
                        esimenePilt.peidaPilt();
                        pilt.peidaPilt();

                    } else {
                        System.out.println("Paar!");
                        esimenePilt.setId("Arvatud");
                        System.out.println(esimenePilt);
                        pilt.setId("Arvatud");
                        System.out.println(pilt);
                    }
                });
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
