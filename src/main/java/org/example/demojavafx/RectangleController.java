package org.example.demojavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class RectangleController {
    @FXML
    Label label1;
    @FXML
    Label label2;
    @FXML
    TextField textx;
    @FXML
    Label texty;
    @FXML
    VBox vbox1;
    @FXML
    Rectangle recJFX;

    public void readFile() {
            String fname = textx.getText();
            try {
                Scanner scanner = new Scanner(new File(fname));
                int sumArea = 0;
                int i = 0;
                String check = "Стороны отрицательные у rec №: ";
                int checkSize=check.length();
                ArrayList<RectangleMy> list = new ArrayList<>();
                while (scanner.hasNext()){
                    i++;
                    int a = scanner.nextInt();
                    int b = scanner.nextInt();
                    String color = scanner.next();
                    try{
                        RectangleMy r = new RectangleMy(a, b, color);
                        sumArea+=r.area();
                        list.add(r);
                    }
                    catch (Exception e){check= check + i +" ";}
                }
                if (check.length()>checkSize) label2.setText(check);
                texty.setText(String.valueOf(sumArea));
                printRectangles(list);
            }
            catch(FileNotFoundException e){label2.setText("Ошибка чтения файла");}
    }
    public void printRectangles(ArrayList<RectangleMy> r){
        for(RectangleMy x: r)
        {
            recJFX = new Rectangle(x.x,x.y);
            recJFX.setFill(Paint.valueOf(x.color));
            vbox1.getChildren().add(recJFX);
        }
    }

}