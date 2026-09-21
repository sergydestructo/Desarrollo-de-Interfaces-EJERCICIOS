import java.util.Random;

public class Sala {
    private int maxSalas;
    private int numSala;
    private int intentosBusqueda;
    private int numZombies;
    private Zombie javi;
    private Jugador elio;

    public Sala(int dificultad) {
        this.maxSalas = 5 * dificultad;
        this.numSala = 1;
        this.intentosBusqueda = 3;
        this.numZombies = 0;
        this.javi = crearZombie();
        this.elio = new Jugador();
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
            if (elio.isBotiquin()) {
                System.out.println("Encuentras un botiquín pero ya tienes uno");
            } else {
                System.out.println("Encuentras un botiquín");
                elio.setBotiquin(true);
            }
        } else if (resultado <= 95) {
            System.out.println("Encuentras una protección");
            elio.setProtecciones(elio.getProtecciones() + 1);
        } else {
            System.out.println("Encuentras un arma");
            elio.setArmas(elio.getArmas() + 1);
        }
    }

    private int hacerRuido() {
        Random dado = new Random();

        return dado.nextInt(100) + 1;
    }

    public void combate() {
        int turno = 0;

        while (javi.getVidaActual() > 0 || elio.getVidaActual() > 0) {
            turno++;
            System.out.println("TURNO " + turno);

            int ataqueJugador = elio.atacar();
            javi.setVidaActual(javi.getVidaActual() - ataqueJugador);
            System.out.println("El sombi recibe " + ataqueJugador + " puntos de daño");

            if (javi.getVidaActual() <= 0) {
                System.out.println("sa morio");
                numZombies--;
            } else {
                System.out.println("No sa morio");

                int ataqueZombie = javi.atacar() - elio.getProtecciones();
                elio.setVidaActual(elio.getVidaActual() - ataqueZombie);
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

    public Jugador getElio() {
        return elio;
    }

    public void setElio(Jugador elio) {
        this.elio = elio;
    }

    public int getNumZombies() {
        return numZombies;
    }
}
