package MemoryGame;


import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;



/**
 * Created by janikaa on 4.12.2015.
 */
public class Laud {
    Stage mang; //programmi aken, kuhu peale ehitame mängu; klassimuutuja, klassis igalpool kättesaadav
    GridPane laud; //asetab elemendid ruudustiku järgi tabelisse;
    int pildiKylg = 150; //pildi küljepikkus
    int laualTulpasid = 4; //tulpade arv mängulaual
    int laualRidasid = 4; //ridade arv mängulaual
    int piltideVahe = 5; //piltidel on vahed
    int piksleidLai = pildiKylg*laualTulpasid+(laualTulpasid*piltideVahe);//see on sellepärast selline, et mahuks aknasse ära, vaatame mingi parema lahenduse
    int piksleidKorge = pildiKylg*laualRidasid+(laualRidasid*piltideVahe);
    FlowPane flow = new FlowPane(laud);//Paigutab elemendid vasakult paremale, katkeb järgmisele reale, kui sisu enam ära ei mahu

    public Laud(){
        mang = new Stage();
        laud = new GridPane();
        Scene manguStseen = new Scene(laud, piksleidLai, piksleidKorge);
        mang.setScene(manguStseen);
        mang.show();//ava aken
        mang.setTitle("Memoriin");//mängu pealkiri
        mang.setOnCloseRequest(event -> System.exit(0));//akna sulgedes läheb programm kinni

        genereeriPildid();
        //genereeriPildid();
        //reageeriKlikile();
        System.out.println("Olen Laua juurde jõudnud!");

    }

    private void genereeriPildid() {
        for (int i = 0; i < laualRidasid; i++) {
            for (int j = 0; j < laualTulpasid; j++) {
                Rectangle pilt = new Rectangle(pildiKylg, pildiKylg);//Ristküliku loomine, antud alguskoordinaadid ja laius/kõrgus
                pilt.setId("Pilt");
                pilt.setFill(Color.BLUE);
                pilt.setStroke(Color.BLACK);//seda võib ka mitte teha
                laud.setHgap(piltideVahe);//lisame vaba ruumi horisontaalselt
                laud.setVgap(piltideVahe);//lisame vaba ruumi vertikaalselt
                laud.add(pilt, i, j);
                System.out.println("Olen piltide genereerimise juurde jõudnud!");
            }
        }
    }
}
