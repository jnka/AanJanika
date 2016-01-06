package MemoryGame;

import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collections;



/**
 * Created by janikaa on 10.12.2015.
 */
public class Laud {
    Stage mang;//klassimuutuja, klassis igalpool kättesaadav
    GridPane laud;//klassimuutuja, klassis igalpool kättesaadav
    int pildiKylg = 150;
    int laualTulpasid = 2;
    int laualRidasid = laualTulpasid;
    int paarideArv = (laualRidasid*laualTulpasid)/2;
    int piltideVahe = 5;
    int piksleidLai = pildiKylg*laualTulpasid+(laualTulpasid*piltideVahe);//see on sellepärast selline, et mahuks aknasse ära, vaatame mingi parema lahenduse
    int piksleidKorge = pildiKylg*laualRidasid+(laualRidasid*piltideVahe);
    Pilt [] pildistik = new Pilt[laualRidasid*laualTulpasid];
    private Pilt selected = null; //Alguses pole ükski pilt valitud, sellepärast alustame "null'ist"
    public int klikiLugeja = 2; //vajalik selleks, et aktiveerib esimesed kaks klikki (ülejäänuid ignoreerib), sest me kontrollime vaid kahte asja antud mängus



    public Laud () {
        mang = new Stage();
        laud = new GridPane();
        Scene manguStseen = new Scene(laud, piksleidLai, piksleidKorge);
        mang.setScene(manguStseen);
        mang.show();//ava aken
        mang.setOnCloseRequest(event -> System.exit(0));//akna sulgedes läheb programm kinni
        mang.setTitle("Memoriin");

        genereeriPildid();
    }

    //tsükkel piltide lauale asetamiseks
    private void genereeriPildid() {
        int nr = 1; //alustab numbrist 1
        ArrayList<Pilt> pildid = new ArrayList<>(paarideArv);
        for (int i = 0; i < paarideArv; i++) {
            pildid.add(new Pilt(String.valueOf(nr)));//Pildi loomine, prindib numbri tektiväärtusteks
            pildid.add(new Pilt(String.valueOf(nr)));//Tuleb teha kaks korda, kuna meil kaartide arv lauas = 2 x paarideArv
            nr++;//suurendab numbreid ühe võrra
        }

        //segame pildid lauas
        Collections.shuffle(pildid);
        System.out.println(pildid);//prindime pildid välja

        for (int i=0; i < pildid.size(); i++) {
            Pilt pilt = pildid.get(i);
            pilt.setTranslateX((pildiKylg+piltideVahe) * (i % laualRidasid));
            pilt.setTranslateY((pildiKylg+piltideVahe) * (i / laualTulpasid));
            laud.getChildren().add(pilt);
        }

    }

    public class Pilt extends StackPane {
        int pildiKylg = 150;
        Text number = new Text();

        public Pilt(String value) {
            Rectangle kaart = new Rectangle();//teeb kaardi
            kaart.setWidth(pildiKylg);//kaardi laius
            kaart.setHeight(pildiKylg);//kaardi kõrgus
            kaart.setFill(Color.BLUE);//sinist värvi kaart
            kaart.setStroke(Color.BLACK);//kaardi piirjooned

            number.setText(value);
            number.setFont(Font.font(90));//numbri suurus pildil

            setAlignment(Pos.CENTER);//number asetseb keskel
            getChildren().addAll(kaart, number);

            setOnMouseClicked(this::Klikk);
            peidaPilt();
        }

        public void Klikk(MouseEvent mouseEvent){
            if (KasAvatud() || klikiLugeja==0)
                return;

                klikiLugeja--;

            if (selected==null){//Kui valitud pole ühtegi kaarti, ehk null
                selected=this;
                avaPilt(() ->{}); //Run meetodi jaoks
            }
            else{//teise kliki jaoks vajalik kontroll
                avaPilt(()->{
                    if(!kasSamaValue(selected)){ //Kontrollime, kas avatud on samasugused kaardid
                        selected.peidaPilt();
                        this.peidaPilt();
                    }

                    selected = null;
                    klikiLugeja=2;

                });

            }
        }

        public boolean KasAvatud(){
            return number.getOpacity()==1; //Kui kaart = 1, siis on ta avatud seisuses.
        }

        public void avaPilt(Runnable action) {
            FadeTransition peida = new FadeTransition(Duration.seconds(0.5), number);
            peida.setToValue(1);
            peida.setOnFinished(e-> action.run());
            peida.play();
        }

        public void peidaPilt() {
            FadeTransition peida = new FadeTransition(Duration.seconds(0.5), number);
            peida.setToValue(0);
            peida.play();
        }

        public boolean kasSamaValue(Pilt muu){
            return number.getText().equals(muu.number.getText());
        }

    }


}
