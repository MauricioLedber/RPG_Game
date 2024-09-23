import java.util.Random;
import javax.swing.JOptionPane;


public class Main {
    public static void main(String[] args) {
        /**
         * Creacion de personajes
         */
        Player player = new Player("Héroe");
        Enemy enemy = new Enemy("Goblin");

        /** 
         * Mostrar información inicial*/
        JOptionPane.showMessageDialog(null, "Bienvenido al juego de rol!");
        JOptionPane.showMessageDialog(null, "Tu personaje:\n"+player);
        JOptionPane.showMessageDialog(null, "Tu enemigo:\n"+enemy);


        /**
         * Inicializar generador de números aleatorios
         */
        Random random = new Random();

        /**
         * Bucle principal del juego
         */
        while (player.isAlive() && enemy.isAlive()) {
            JOptionPane.showMessageDialog(null, "\nTurno del jugador:");
            player.attack(enemy);

            if (enemy.isAlive()) {
                JOptionPane.showMessageDialog(null, "\nTurno del enemigo:");
                enemy.attack(player);
            }

            /**
             * Pausa entre turnos
             */
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /**
         * Mostrar mensaje de victoria o derrota
         */
        if (player.isAlive()) {
            JOptionPane.showMessageDialog(null, "¡Has derrotado al enemigo!");
        } else {
            JOptionPane.showMessageDialog(null, "Game over. Has sido derrotado por el enemigo.");
        }
    }
}