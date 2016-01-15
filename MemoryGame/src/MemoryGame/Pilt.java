
package MemoryGame;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
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
    private int pildiKylg = 150;
    public Text number = new Text();

    public Pilt(String value) {
        Rectangle kaart = new Rectangle();//teeb kaardi
        kaart.setWidth(pildiKylg);//kaardi laius
        kaart.setHeight(pildiKylg);//kaardi kõrgus
        kaart.setFill(Color.BLUE);//sinist värvi kaart
        kaart.setStroke(Color.BLACK);//kaardi piirjooned

        number.setText(value);
        number.setFont(Font.font(90));//numbri suurus pildil
        number.setMouseTransparent(true);//ütleme, et numbrile ehk textile ei saa klikkida

        setAlignment(Pos.CENTER);//number asetseb pildi keskel
        getChildren().addAll(kaart, number); //paneb lapsed ehk kaardi ja numbri vanemale ehk stackpane'ile, kaart on numbri taga, sest on sulgudes eespool

        //Lisame kaartidele hajuva liikuva värvi
        FadeTransition varvHajub = new FadeTransition(Duration.millis(30000), kaart);
        varvHajub.setFromValue(1.0);
        varvHajub.setToValue(0.1);
        varvHajub.setCycleCount(Timeline.INDEFINITE);
        varvHajub.setAutoReverse(true);
        varvHajub.play();
    }

    //meetod, mis kontrollib kas pilt on avatud või mitte, kui on 1, siis on avatud
    public boolean piltOnAvatud() {
        return number.getOpacity() == 1;
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
