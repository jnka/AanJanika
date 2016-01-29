package MemoryGame;

import javafx.animation.FadeTransition;
import javafx.animation.StrokeTransition;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * Created by janikaa on 8.01.2016.
 */
public class Pilt extends StackPane {
    private Rectangle kaart = new Rectangle();//teeb kaardi
    private int pildiKylg = 150;
    public Text number = new Text();

    public Pilt(String value) {
        kaart.setWidth(pildiKylg);//kaardi laius
        kaart.setHeight(pildiKylg);//kaardi kõrgus
        kaart.setArcWidth(10);//kaardi ümarad nurgad
        kaart.setArcHeight(10);//kaardi ümarad nurgad
        kaart.setFill(Color.BLUE);//sinist värvi kaart
        kaart.setStroke(Color.DARKBLUE);//kaardi piirjooned
        kaart.setStrokeWidth(3);//kaardi piirjoone paksus

        number.setText(value);
        number.setFont(Font.font(90));//numbri suurus pildil
        number.setMouseTransparent(true);//ütleme, et numbrile ehk textile ei saa klikkida

        setAlignment(Pos.CENTER);//number asetseb pildi keskel
        getChildren().addAll(kaart, number);//paneb lapsed ehk kaardi ja numbri vanemale ehk stackpane'ile, kaart on numbri taga, sest on sulgudes eespool
    }

    //meetod, mis kontrollib kas pilt on avatud või mitte, kui on 1, siis on avatud
    public boolean piltOnAvatud() {
        return number.getOpacity() == 1;
    }

    //meetod, mis paneb pildi piirjooned vilkuma
    public void vilgutaPildiPiirjooni () {
        StrokeTransition vilgu = new StrokeTransition(Duration.seconds(0.5), kaart, Color.DARKBLUE, Color.YELLOW);
        vilgu.setCycleCount(4);
        vilgu.setAutoReverse(true);
        vilgu.play();
    }

    //meetod, mis avab esimese pildi
    public void avaEsimenePilt(Runnable action) {
        setId("Esimene");
        FadeTransition ft = new FadeTransition(Duration.seconds(0.2), number);
        ft.setToValue(1);
        ft.setOnFinished(event -> action.run());
        ft.play();
    }

    //meetod, mis avab teise pildi
    public void avaTeinePilt(Runnable action) {
        setId("Teine");
        FadeTransition ft = new FadeTransition(Duration.seconds(0.2), number);
        ft.setToValue(1);
        ft.setOnFinished(event -> action.run());
        ft.play();
    }

    //meetod, mis peidab pildi
    public void peidaPilt() {
        FadeTransition ft = new FadeTransition(Duration.seconds(0.2), number);
        ft.setToValue(0);
        ft.play();
    }
}
