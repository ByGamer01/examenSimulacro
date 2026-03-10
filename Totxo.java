import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Totxo {
    private int x, y;
    private final int AMPLE = 70;
    private final int ALT = 25;
    private Color color;
    private boolean actiu;

    public Totxo(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.actiu = true;
    }

    public void dibuixar(Graphics2D g2d) {
        if (actiu) {
            g2d.setColor(color);
            g2d.fillRect(x, y, AMPLE, ALT);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(x, y, AMPLE, ALT);
        }
    }

    public Rectangle getRectangle() {
        return new Rectangle(x, y, AMPLE, ALT);
    }

    // Getters
    public boolean isActiu() { return actiu; }
    public int getX() { return x; }
    public int getY() { return y; }
    public int getAmple() { return AMPLE; }
    public int getAlt() { return ALT; }

    // Setters
    public void setActiu(boolean actiu) { this.actiu = actiu; }
}
