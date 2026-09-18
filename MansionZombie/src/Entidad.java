abstract class Entidad {
    protected int vidaMax;
    protected int vidaActual;
    protected int ataque;

    public abstract int atacar();

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    public int getAtaque() {
        return ataque;
    }
}
