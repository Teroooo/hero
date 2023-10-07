import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;


public class Hero {
    private Position position;

    public Hero(int i, int i1) {
        position = new Position(i, i1);
    }
    public void setX(int i) {
        position.setX(i);
    }
    public void setY(int i) {
        position.setY(i);
    }

    public Position moveUp() {
        return new Position(position.getX(), position.getY() - 1);
    }
    public Position moveDown() {
        return new Position(position.getX(), position.getY() + 1);
    }
    public Position moveLeft() {
        return new Position(position.getX() - 1, position.getY());
    }
    public Position moveRight() {
        return new Position(position.getX() + 1, position.getY());
    }


    public void draw(Screen screen) {
        screen.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter('X')[0]);
    }

    public void setPosition(Position position_) {
        position = position_;
    }
}