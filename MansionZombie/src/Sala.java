import java.util.Random;

public class Sala {
    private int maxSalas;
    private int numSala;
    private int intentosBusqueda;
    private int numZombies;
    private Zombie zombie;
    private Jugador jugador;

    public Sala(int dificultad) {
        this.maxSalas = 5 * dificultad;
        this.numSala = 1;
        this.intentosBusqueda = 3;
        this.numZombies = 0;
        this.zombie = crearZombie();
        this.jugador = new Jugador();
    }

    private Zombie crearZombie() {
        numZombies++;
        return new Zombie();
    }

    public void busqueda(int resultado) {
        intentosBusqueda--;
        if (resultado <= 75) {
            int ruido = hacerRuido();

            if (ruido <= 40) {
                System.out.println("NADA");
            } else if (ruido <= 80) {
                crearZombie();
                System.out.println("sombi");
            } else {
                crearZombie();
                crearZombie();
                System.out.println("sombi 2");
            }
        } else if (resultado <= 90) {
            if (jugador.isBotiquin()) {
                System.out.println("Encuentras un botiquín pero ya tienes uno");
            } else {
                System.out.println("Encuentras un botiquín");
                jugador.setBotiquin(true);
            }
        } else if (resultado <= 95) {
            System.out.println("Encuentras una protección");
            jugador.setProtecciones(jugador.getProtecciones() + 1);
        } else {
            System.out.println("Encuentras un arma");
            jugador.setArmas(jugador.getArmas() + 1);
        }
    }

    private int hacerRuido() {
        Random dado = new Random();

        return dado.nextInt(100) + 1;
    }

    public void combate() {
        int turno = 0;

        while (zombie.getVidaActual() > 0 || jugador.getVidaActual() > 0) {
            turno++;
            System.out.println("TURNO " + turno);

            int ataqueJugador = jugador.atacar();
            zombie.setVidaActual(zombie.getVidaActual() - ataqueJugador);
            System.out.println("El sombi recibe " + ataqueJugador + " puntos de daño");

            if (zombie.getVidaActual() <= 0) {
                System.out.println("sa morio");
                numZombies--;
            } else {
                System.out.println("No sa morio");

                int ataqueZombie = zombie.atacar() - jugador.getProtecciones();
                jugador.setVidaActual(jugador.getVidaActual() - ataqueZombie);
                System.out.println("Recibes " + ataqueZombie + " puntos de daño");
            }
        }
    }

    public void avanzar() {
        numSala++;
        intentosBusqueda = 3;
        crearZombie();
    }

    public int getNumSala() {
        return numSala;
    }

    public int getMaxSalas() {
        return maxSalas;
    }

    public int getIntentosBusqueda() {
        return intentosBusqueda;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public int getNumZombies() {
        return numZombies;
    }
}
