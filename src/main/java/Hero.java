import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Hero {
    private int x;
    private int y;

    public Hero(int i, int i1) {
        setX(i);
        setY(i1);
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void moveUp() {
        setY(y - 1);
    }
    public void moveDown() {
        setY(y + 1);
    }
    public void moveLeft() {
        setX(x - 1);
    }
    public void moveRight() {
        setX(x + 1);
    }

    public void draw(Screen screen) {
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
    }
}
