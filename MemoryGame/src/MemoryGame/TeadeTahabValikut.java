package MemoryGame;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by janikaa on 17.01.2016.
 */
public class TeadeTahabValikut {
    static boolean vastus;

    public static boolean teadeTahabValikut (String pealkiri, String sisuTekst) {
        Stage teade = new Stage();
        teade.initModality(Modality.APPLICATION_MODAL);//Saad ainult seda akent klikkida, mänguaken on taustal ja klikkida ei saa
        teade.setTitle(pealkiri);
        teade.setMinWidth(300);
        teade.setMinHeight(100);
        Label sisu = new Label();
        sisu.setText(sisuTekst);

        //Teeme kaks nuppu valikute jaoks
        Button jahNupp = new Button("Jah");
        Button eiNupp = new Button("Ei");

        jahNupp.setOnAction(event -> {
            vastus = true;
            System.exit(0);
        });

        eiNupp.setOnAction(event -> {
            vastus = false;
            teade.close();
        });

        HBox teateKujundus = new HBox(10);
        teateKujundus.getChildren().addAll(sisu, jahNupp, eiNupp);
        teateKujundus.setAlignment(Pos.CENTER);

        Scene teateStseen = new Scene(teateKujundus);
        teade.setScene(teateStseen);
        teade.showAndWait();//ootab kuni valik tehakse ja aken suletakse

        return vastus;
    }
}
