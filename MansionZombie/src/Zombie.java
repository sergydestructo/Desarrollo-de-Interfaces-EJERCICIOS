import java.util.Random;

public class Zombie extends Entidad {

    public Zombie() {
        Random dado = new Random();
        this.vidaMax = dado.nextInt(2) + 2; // añadir suma de num de habitacion
        this.vidaActual = vidaMax;
        this.ataque = dado.nextInt(2) + 2; // añadir suma de num de habitacion
    }

    public int atacar() {
        Random dado = new Random();
        return dado.nextInt(ataque) + 1;
    }
}
