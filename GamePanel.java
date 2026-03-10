import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    // Elements del joc
    private Pilota pilota;
    private Pala pala;
    private Totxo[][] totxos;

    // Estat del joc
    private int puntuacio = 0;
    private int vides = 3;
    private boolean gameOver = false;

    // Configuració
    private final int FILES_TOTXOS = 4;
    private final int COLS_TOTXOS = 9;
    private final int DELAY = 10;
    private Timer timer;

    // Colors per cada fila de totxos
    private Color[] colorFiles = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN};

    public GamePanel() {
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        inicialitzarJoc();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void inicialitzarJoc() {
        pilota = new Pilota(400, 400);
        pala = new Pala(350, 540);

        // Crear matriu de totxos
        totxos = new Totxo[FILES_TOTXOS][COLS_TOTXOS];
        for (int fila = 0; fila < FILES_TOTXOS; fila++) {
            for (int col = 0; col < COLS_TOTXOS; col++) {
                int x = 40 + col * 80;
                int y = 50 + fila * 35;
                totxos[fila][col] = new Totxo(x, y, colorFiles[fila]);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Dibuixar totxos
        for (int fila = 0; fila < FILES_TOTXOS; fila++) {
            for (int col = 0; col < COLS_TOTXOS; col++) {
                totxos[fila][col].dibuixar(g2d);
            }
        }

        // Dibuixar pilota i pala
        pilota.dibuixar(g2d);
        pala.dibuixar(g2d);

        // ============================================================
        // TODO 1: Dibuixar el HUD (puntuació i vides)
        // - Mostrar "Puntuació: X" a la part superior esquerra (x=10, y=25)
        // - Mostrar "Vides: X" a la part superior dreta
        // - Utilitzar font Arial Bold mida 18 i color blanc
        // ============================================================



        // ============================================================
        // TODO 2: Mostrar missatge de GAME OVER o VICTORIA
        // - Si gameOver és true i vides <= 0: mostrar "GAME OVER" centrat
        // - Si gameOver és true i tots els totxos estan eliminats: 
        //   mostrar "HAS GUANYAT!" centrat
        // - Utilitzar font Arial Bold mida 50
        // ============================================================


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) return;

        pilota.moure();

        // ============================================================
        // TODO 3: Rebot de la pilota amb les parets (esquerra, dreta, dalt)
        // i detecció de pèrdua de vida (paret inferior = sol)
        //
        // - Si la pilota toca la paret esquerra (x <= 0): invertir dx
        // - Si la pilota toca la paret dreta (x + diàmetre >= getWidth): invertir dx
        // - Si la pilota toca el sostre (y <= 0): invertir dy
        // - Si la pilota cau pel sol (y + diàmetre >= getHeight):
        //     · Restar una vida
        //     · Si vides <= 0: gameOver = true
        //     · Si queden vides: resetar posició de la pilota al centre
        // ============================================================



        // ============================================================
        // TODO 4: Col·lisió pilota-pala
        // Utilitza Rectangle.intersects() per comprovar si la pilota
        // col·lideix amb la pala.
        // - Crea un Rectangle per la pilota amb (getX, getY, diàmetre, diàmetre)
        // - Crea un Rectangle per la pala amb (getX, getY, ample, alt)
        // - Si intersecten: invertir dy i reposicionar la pilota
        //   just a sobre de la pala per evitar que es quedi "enganxada"
        // ============================================================



        // ============================================================
        // TODO 5: Col·lisió pilota-totxos
        // Recorre la matriu de totxos. Per cada totxo ACTIU:
        // - Crea un Rectangle per la pilota
        // - Comprova si intersecta amb el rectangle del totxo (usa getRectangle())
        // - Si hi ha col·lisió:
        //     · Desactiva el totxo (setActiu(false))
        //     · Inverteix dy de la pilota
        //     · Suma 10 punts a la puntuació
        //     · Fes break per sortir del bucle (1 col·lisió per frame)
        // - Després comprova si tots els totxos estan eliminats → gameOver = true
        // ============================================================



        // ============================================================
        // TODO 6: Limitar el moviment de la pala (boundary clamping)
        // - Si la pala surt per l'esquerra (x < 0): posar x = 0
        // - Si la pala surt per la dreta (x + ample > getWidth): 
        //   posar x = getWidth - ample
        // ============================================================



        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            pala.moureEsquerra();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            pala.moureDreta();
        }
        // Reiniciar joc amb ESPAI si gameOver
        if (e.getKeyCode() == KeyEvent.VK_SPACE && gameOver) {
            puntuacio = 0;
            vides = 3;
            gameOver = false;
            inicialitzarJoc();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    // Mètode auxiliar per comprovar si tots els totxos estan eliminats
    private boolean totsEliminats() {
        for (int fila = 0; fila < FILES_TOTXOS; fila++) {
            for (int col = 0; col < COLS_TOTXOS; col++) {
                if (totxos[fila][col].isActiu()) return false;
            }
        }
        return true;
    }
}
