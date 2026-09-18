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
        this.numZombies = 1;
        this.javi = crearZombie();

    }

    private Zombie crearZombie() {
        numZombies++;
        return new Zombie();
    }

    public void busqueda(int resultado) {
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

        }
    }

    private int hacerRuido() {
        return -1;
    }

}
