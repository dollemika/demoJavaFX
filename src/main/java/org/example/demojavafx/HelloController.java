package org.example.demojavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    Label label1;
    @FXML
    Label label2;
    @FXML
    Label area;
    @FXML
    TextField textx;
    @FXML
    TextField texty;
    public void doPlus(){
        label1.setText("Сложение");
        label2.setText(String.valueOf(Integer.parseInt(textx.getText())+Integer.parseInt(texty.getText())));
    }
    public void doMinus(){
        label1.setText("Вычитание");
        label2.setText(String.valueOf(Integer.parseInt(textx.getText())-Integer.parseInt(texty.getText())));
    }
    public void sqArea(){
        label1.setText("Площадь прямоугольника");
        int x = Integer.parseInt(textx.getText());
        int y = Integer.parseInt(texty.getText());
        try {
            RectangleMy r = new RectangleMy(x, y);
            label2.setText(String.valueOf(r.area()));
        }
        catch (Exception e){
            label2.setText("Стороны не подходят");
        }
    }

}