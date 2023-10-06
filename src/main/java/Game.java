import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    private int y=10;
    private int x=10;

    public Game() throws IOException {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if necessary
            screen.clear();
            screen.setCharacter(10, 10, TextCharacter.fromCharacter('X')[0]);
            screen.refresh();
    }

    public void draw() throws IOException {
            screen.clear();
            screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
            screen.refresh();
    }

    private void processKey(KeyStroke key) throws IOException {
            if (key.getKeyType() == KeyType.ArrowUp) {
                y--;
                draw();
            }
            if (key.getKeyType() == KeyType.ArrowDown) {
                y++;
                draw();

            }
            if (key.getKeyType() == KeyType.ArrowRight) {
                x++;
                draw();
            }
            if (key.getKeyType() == KeyType.ArrowLeft) {
                x--;
                draw();
            }

    }

    public void run() throws IOException {
        while(true) {
            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
                screen.close();
                break;
            }
            processKey(key);
        }
    }
}
