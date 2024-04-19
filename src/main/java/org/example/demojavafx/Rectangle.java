package org.example.demojavafx;

public class Rectangle {
    int x,y;

    public Rectangle(int x, int y) throws Exception {
        Exception e = new Exception();
        if (x<0 || y<0) throw e;
        this.x = x;
        this.y = y;
    }

    public int area(){
        return x*y;
    }
}
