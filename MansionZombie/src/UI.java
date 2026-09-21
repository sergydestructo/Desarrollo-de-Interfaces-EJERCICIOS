import java.util.Scanner;

public class UI {
    private Sala sala;
    private Scanner scan;

    public UI() {
        this.scan = new Scanner(System.in);
    }

    public void empezarPartida() {
        selectorDificultad();

        while (sala.getNumSala() <= sala.getMaxSalas() || sala.getElio().getVidaActual() > 0) {
            if (sala.getNumZombies() != 0) {
                System.out.println("Hay " + sala.getNumZombies() + "Zombie(s) en la sala");
                System.out.println("1. Atacar");
                combate();
            } else {
                System.out.println("1. Buscar por la habitación");
                System.out.println("2. Avanzar a la siguiente habitación");
            }
        }
    }

    public void combate() {

    }

    public void busqueda() {

    }

    public void avance() {

    }

    public void curacion() {

    }

    public void selectorDificultad() {
        System.out.println("Introduzca la dificultad que desea");
        System.out.println("1. Fácil (El juego tendrá 5 habitaciones)");
        System.out.println("2. Difícil (El juego tendrá 10 habitaciones)");

        int dificultad = Integer.parseInt(scan.nextLine());

        while (dificultad <= 0 || dificultad >= 3) {
            System.out.println("Introduzca un valor válido");
            dificultad = Integer.parseInt(scan.nextLine());
        }

        setSala(dificultad);
    }

    private void setSala(int dificultad) {
        this.sala = new Sala(dificultad);
    }
}


