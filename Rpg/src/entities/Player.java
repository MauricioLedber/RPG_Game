package entities;
import entities.Enemies.Enemy;

import java.util.HashMap;

public class Player {
    private String name;
    private HashMap<Stats, Integer> stats;

    public enum Stats {
        MAX_HP, HP, MAX_MP, MP, ATTACK, DEFENSE
    }

    /*Constructor*/
    public Player(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        this.stats.put(Stats.MAX_HP, 50);
        this.stats.put(Stats.HP, 50);
        this.stats.put(Stats.ATTACK, 5);
        this.stats.put(Stats.DEFENSE, 2);
    }

    /* Metodo para obtener el nombre del player */
    public String getName() {
        return this.name;
    }

    /* Metodo para obtener una copia de los stats del enemigo */
    public HashMap<Stats, Integer> getStats() {
        HashMap<Stats, Integer> statsCopy = new HashMap<>(this.stats);
        return statsCopy;
    }

    /* Metodo para atacar a player */
    public void attack(Enemy enemy) {
        int damage = this.stats.get(Stats.ATTACK) - enemy.getStats().get(Stats.DEFENSE);
        if (damage > 0) {
            enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
            System.out.println(this.name + " attacks " + enemy.getName() + " for " + damage + " damage!");
        } else {
            System.out.println(this.name + " attacks " + enemy.getName() + " but does no damage!");
        }
    }


    public void takeDamage(int damage) {
        // Implement logic to deduct damage from enemy's HP
    }

    public void restoreHp(int amount) {
        // Implement logic to restore HP
    }

    /* Metodo para saber si esta vivo o no el player */
    public boolean isAlive() {
        return this.stats.get(Stats.HP) > 0;
    }
}
