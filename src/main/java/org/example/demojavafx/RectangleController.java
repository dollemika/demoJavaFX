package org.example.demojavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RectangleController {
    @FXML
    Label label1;
    @FXML
    Label label2;
    @FXML
    TextField textx;
    @FXML
    Label texty;

    public void readFile() {
            String fname = textx.getText();
            try {
                Scanner scanner = new Scanner(new File(fname));
                int sumArea = 0;
                int i = 0;
                String check = "Стороны отрицательные у rec №: ";
                int checkSize=check.length();
                while (scanner.hasNext()){
                    i++;
                    int a = scanner.nextInt();
                    int b = scanner.nextInt();
                    try{
                        Rectangle r = new Rectangle(a, b);
                        sumArea+=r.area();
                    }
                    catch (Exception e){check= check + i +" ";}
                }
                if (check.length()>checkSize) label2.setText(check);
                texty.setText(String.valueOf(sumArea));
            }
            catch(FileNotFoundException e){label2.setText("Ошибка чтения файла");}
    }

}