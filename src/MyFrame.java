import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 19.11.13
 * Time: 10:41
 * To change this template use File | Settings | File Templates.
 */
public class MyFrame extends JFrame {

    private static final int CELL_SIZE = 16;
    private final Unit unit;
    private int screenHeight;
    private int screenWidth;

    MyFrame() {
        screenWidth = 400;
        screenHeight = 300;
        setSize(screenWidth, screenHeight);
        setVisible(true);
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());

        unit = new Unit(14, 14);

    }


    private void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            unit.move(MyDirection.UP);
        }
        if (e.getKeyChar() == 'd') {
            unit.move(MyDirection.RIGHT);
        }
        if (e.getKeyChar() == 'a') {
            unit.move(MyDirection.LEFT);
        }
        if (e.getKeyChar() == 's') {
            unit.move(MyDirection.DOWN);
        }
        repaint();
    }

    private class MyDispatcher implements KeyEventDispatcher {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                MyFrame.this.keyPressed(e);
            }
            return false;
        }
    }

    @Override
    public void paint(Graphics g) {
        // TODO move paint method to JPanel
        super.paint(g);
        screenWidth = getWidth();
        screenHeight = getHeight();
        g.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, CELL_SIZE));
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, screenWidth, screenHeight);
        for (int x = -1; x <= screenWidth / CELL_SIZE; x++) {
            for (int y = -1; y <= screenHeight / CELL_SIZE; y++) {
                if (Math.random() > 0.5f) {
                    g.setColor(Color.GRAY);
                } else if (Math.random() < 0.3f) {
                    g.setColor(Color.ORANGE);
                } else if (Math.random() < 0.3f) {
                    g.setColor(Color.LIGHT_GRAY);
                } else {
                    g.setColor(Color.blue);
                }
                if (Math.random() > 0.3f) {
                    g.drawString(".", x * CELL_SIZE, y * CELL_SIZE);
                } else if (Math.random() > 0.3f) {

                    g.drawString(",", x * CELL_SIZE, y * CELL_SIZE);
                } else {
                    g.drawString(" ", x * CELL_SIZE, y * CELL_SIZE);
                }
            }
        }
        if (unit != null) {
            g.setColor(Color.CYAN);
            g.drawString("@", unit.getX() * CELL_SIZE, unit.getY() * CELL_SIZE);
        }
    }
}
