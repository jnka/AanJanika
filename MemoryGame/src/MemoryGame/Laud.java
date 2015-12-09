package MemoryGame;


import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Created by janikaa on 4.12.2015.
 */
public class Laud {
    GridPane laud;
    StackPane maailm;
    Stage programmiAken = new Stage();
    int laualTulpasid = 4;
    int laualRidasid = 4;
    int ruuduKylg = 50;


    Laud(){
    programmiAken.setTitle("Memoriin");
        System.out.println("Olen Laua juurde jõudnud!");
        seadistaStseen();
        //genereeriPildid();
        //reageeriKlikile();

        programmiAken.show(); //Näita Mängu
    }

    private void seadistaStseen() {
        int piksleidLai = laualTulpasid * ruuduKylg;
        int piksleidKorge = laualRidasid * ruuduKylg;
        maailm = new StackPane();
        Rectangle taust = new Rectangle(piksleidLai, piksleidKorge);
        taust.setFill(Color.BLUE);
        maailm.getChildren().add(taust);

        laud = new GridPane();
        maailm.getChildren().add(laud);

        Scene scene = new Scene(maailm, piksleidKorge, piksleidLai);
        programmiAken.setScene(scene);
        programmiAken.setOnCloseRequest(event -> System.exit(0));
        System.out.println("Olen Stseeni seadistamise juurde jõudnud!");
    }


}
