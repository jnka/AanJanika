package MemoryGame;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by janikaa on 17.01.2016.
 */
public class Teade {
    public static void teade (String pealkiri, String sisuTekst) {
        Stage teade = new Stage();
        teade.initModality(Modality.APPLICATION_MODAL);//Saad ainult seda akent klikkida, mänguaken on taustal ja klikkida ei saa
        teade.setTitle(pealkiri);
        teade.setMinWidth(500);
        teade.setMinHeight(100);

        Label sisu = new Label();
        sisu.setText(sisuTekst);

        Button sainAruNupp = new Button("Sain aru");
        sainAruNupp.setOnAction(event -> teade.close());

        VBox teateKujundus = new VBox(10);
        teateKujundus.getChildren().addAll(sisu, sainAruNupp);
        teateKujundus.setAlignment(Pos.CENTER);

        Scene teateStseen = new Scene(teateKujundus);
        teade.setScene(teateStseen);
        teade.showAndWait();//ootab ära, kuni vajutatakse alusta mängu

    }
}
