import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private TerminalScreen screen;
    private Arena arena;

    public Game(int width, int height) throws IOException {

        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null); // we don't need a cursor
        screen.startScreen(); // screens must be started
        screen.doResizeIfNecessary(); // resize screen if necessary

        arena = new Arena(width, height);
    }

    public void run() throws IOException {
        while(true) {
            draw();
            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
                screen.close();
            if (key.getKeyType() == KeyType.EOF)
                break;
            processKey(key);
        }
    }

    private void processKey(KeyStroke key) {
        arena.processKey(key);
    }

    private void draw() throws IOException {
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }
}