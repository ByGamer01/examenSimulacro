import java.awt.Color;
import java.awt.Graphics2D;

public class Pala {
    private int x, y;
    private final int AMPLE = 100;
    private final int ALT = 12;
    private final int VELOCITAT = 20;

    public Pala(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moureEsquerra() {
        x -= VELOCITAT;
    }

    public void moureDreta() {
        x += VELOCITAT;
    }

    public void dibuixar(Graphics2D g2d) {
        g2d.setColor(Color.CYAN);
        g2d.fillRect(x, y, AMPLE, ALT);
    }

    // Getters
    public int getX() { return x; }
    public int getY() { return y; }
    public int getAmple() { return AMPLE; }
    public int getAlt() { return ALT; }

    // Setters
    public void setX(int x) { this.x = x; }
}
