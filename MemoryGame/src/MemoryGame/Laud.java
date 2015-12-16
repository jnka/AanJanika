package MemoryGame;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Arrays;


/**
 * Created by janikaa on 10.12.2015.
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
    Pilt [] pildistik = new Pilt[laualRidasid*laualTulpasid];


    public Laud () {
        mang = new Stage();
        laud = new GridPane();//elemendid saavad kõik identse suuruse, paigutab elemendid vasakult paremale, katkeb järgmisele reale kui sisu enam ära ei mahu.
        Scene manguStseen = new Scene(laud, piksleidLai, piksleidKorge);
        mang.setScene(manguStseen);
        mang.show();//ava aken
        mang.setOnCloseRequest(event -> System.exit(0));//akna sulgedes läheb programm kinni
        mang.setTitle("Memoriin");



        genereeriPildid();

        System.out.println("Olen Laua juurde jõudnud!");
    }

    public boolean kasOnPilteAlles() {
         for (Pilt pilt : pildistik) {
            boolean olenAllesPilt = pilt.kasOledAlles();
            if (olenAllesPilt) {
                return true;//tagastab meetodi tulemuse ehk et pilte on veel alles, kui seda käsku näeb, siis enam edasi ei lähe
            }
        }
        return false;//if käib kõik pildid läbi ja kui ei jõudnud tulemuseni, et pilte on alles, siis tuleb siia
    }

    private void genereeriPildid() {//tsükkel piltide lauale asetamiseks
        for (int i = 0; i < laualRidasid; i++) {
            for (int j = 0; j < laualTulpasid; j++) {
                Pilt pilt = new Pilt(pildiKylg);//pildi loomine etteantud mõõtmetega
                int rand = (int) (Math.random() * 2 * laualTulpasid);//meie peame siia tegema rohkem kui kaks valikut, sest paare on üle kahe, võiks korrutada (*2*laualTulpasid), aga kuidas, siis if tsükkel, teha, et ta nii palju erinevaid pilte annaks?
                if (rand == 1) {
                    pilt.setId("pilt1");//pilt1 teab, et on pilt1, aga siia võib igale pildile mingi oma nime panna, et neid erinevalt midagi tegema panna
                } else {
                    pilt.setId("pilt2");
                }
                //if (id =="Pilt1"){ //tuleb mõelda, kuidas erinevad ID-d omavahale sobitada ja võrrelda
                //pilt.setId("pilt2");
                //}
                laud.setHgap(piltideVahe);//tekitab piltide asetuses vahed, et pildid ei oleks üksteise küljes
                laud.setVgap(piltideVahe);
                laud.add(pilt, i, j);
            }
        }
    }

}
