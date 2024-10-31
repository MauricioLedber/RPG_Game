import entities.Player;
import entities.Enemies.Enemy;


public class Main {
    public static void main(String[] args) {
        class Game {
            private Player player;
            private Enemy enemy;

            public Game() {
                this.player = new Player("Hero");
                this.enemy = new Enemy("Goblin");
            }

            public void startGame() {
                while (player.isAlive() && enemy.isAlive()) {
                    player.attack(enemy);
                    if (enemy.isAlive()) {
                        enemy.attack(player);
                    }
                }

                if (player.isAlive()) {
                    System.out.println("You defeated the enemy!");
                } else {
                    System.out.println("Game over. You were defeated by the enemy.");
                }
            }
        }
    }
}