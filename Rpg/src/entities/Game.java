import javax.swing.*;

public class Game {
    private Player player;
    private Enemy enemy;

    public Game() {
        /**
         *Nombres de los pesonajes
         */
        this.player = new Player("Hero");
        this.enemy = new Enemy("Goblin");
    }

    public void startGame() {
        /**
         * Funcion que inicia el juego
         */
        while (player.isAlive() && enemy.isAlive()) {
            player.attack(enemy);
            if (enemy.isAlive()) {
                enemy.attack(player);
            }
        }
        /**
         * Funcion que se ejecuta mientras alguno de los personajes muera
         */
        if (player.isAlive()) {
            JOptionPane.showMessageDialog(null,"Derrotaste al anemigo");
        } else {
            JOptionPane.showMessageDialog(null,"Fin del juego");
        }
    }
}