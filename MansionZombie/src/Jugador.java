import java.util.Random;

public class Jugador extends Entidad{
    private int armas;
    private int protecciones;
    private boolean botiquin;

    public Jugador() {
        this.vidaMax = 20;
        this.vidaActual = vidaMax;
        this.ataque = 4;
        this.armas = 0;
        this.protecciones = 0;
        this.botiquin = false;
    }

    public int atacar() {
        Random dado = new Random();
        return dado.nextInt(ataque + armas) + 1;
    }

    public void curar() {
        setBotiquin(false);
        setVidaActual(Math.min(vidaActual + 4, vidaMax));
    }

    public int buscar() {
        Random dado = new Random();
        return dado.nextInt(100) + 1;
    }

    public boolean isBotiquin() {
        return botiquin;
    }

    public void setBotiquin(boolean botiquin) {
        this.botiquin = botiquin;
    }

    public int getArmas() {
        return armas;
    }

    public void setArmas(int armas) {
        this.armas = armas;
    }

    public int getProtecciones() {
        return protecciones;
    }

    public void setProtecciones(int protecciones) {
        this.protecciones = protecciones;
    }
}
