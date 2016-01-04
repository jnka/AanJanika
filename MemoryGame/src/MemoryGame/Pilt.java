package MemoryGame;

import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * Created by janikaa on 13.12.2015.
 */
public class Pilt extends StackPane {
    int pildiKylg = 150;
    Text number = new Text();

    public Pilt selected = null; //Alguses pole ükski pilt valitud, sellepärast alustame "null'ist"

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

        setOnMouseClicked(event -> {
            if (KasAvatud()) {//Kui kaart on avatud ja selle peale uuesti vajutada, siis tagastab sama kaardi ehk ei juhtu midagi.
                return;
            }
            if (selected==null){//Kui valitud pole ühtegi kaarti, ehk null
                selected=this;
                avaPilt(() ->{}); //Run meetodi jaoks
            }
            else{//Kui selected pole null, siis peame uuesti kontrollima, kas mõni pilt on avatud
                avaPilt(()->{
                    if(!kasSamaValue(selected)){ //Kontrollime, kas avatud on samasugused kaardid
                        selected.peidaPilt();
                        this.peidaPilt();
                    }

                    selected = null;

                });

             }
        });

        peidaPilt();
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
