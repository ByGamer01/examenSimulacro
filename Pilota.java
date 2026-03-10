import java.awt.Color;
import java.awt.Graphics2D;

public class Pilota {
    private int x, y;
    private int dx, dy;
    private final int DIAMETRO = 15;

    public Pilota(int x, int y) {
        this.x = x;
        this.y = y;
        this.dx = 4;
        this.dy = -4;
    }

    public void moure() {
        x += dx;
        y += dy;
    }

    public void invertirDx() {
        dx = -dx;
    }

    public void invertirDy() {
        dy = -dy;
    }

    public void dibuixar(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.fillOval(x, y, DIAMETRO, DIAMETRO);
    }

    public void resetPosition(int centreX, int centreY) {
        this.x = centreX;
        this.y = centreY;
        this.dx = 4;
        this.dy = -4;
    }

    // Getters
    public int getX() { return x; }
    public int getY() { return y; }
    public int getDiametro() { return DIAMETRO; }
    public int getDx() { return dx; }
    public int getDy() { return dy; }

    // Setters
    public void setY(int y) { this.y = y; }
    public void setX(int x) { this.x = x; }
}
