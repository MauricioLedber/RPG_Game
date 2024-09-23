import javax.swing.*;
import java.util.HashMap;

public class Enemy {
    private String name;
    private HashMap<Stats, Integer> stats;

    public Enemy(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        /**
         * Inicialización de estadísticas con valores por defecto
         */

        this.stats.put(Stats.MAX_HP, 50);
        this.stats.put(Stats.HP, 50);
        this.stats.put(Stats.ATTACK, 5);
        this.stats.put(Stats.DEFENSE, 2);
        this.stats.put(Stats.SPEED, 5);
        this.stats.put(Stats.DEXTERITY, 5);
        this.stats.put(Stats.LUCK, 5);
        this.stats.put(Stats.ACCURACY, 50);
        this.stats.put(Stats.EVASION, 5);
        this.stats.put(Stats.CRITICAL_HIT, 5);
        this.stats.put(Stats.CRITICAL_DAMAGE, 10);
    }

    public String getName() {
        return name;
    }

    public HashMap<Stats, Integer> getStats() {
        return stats;
    }

    public boolean isAlive() {
        return stats.get(Stats.HP) > 0;
    }

    public void attack(Player player) {
        int baseDamage = stats.get(Stats.ATTACK);
        int defense = player.getStats().get(Stats.DEFENSE);
        int accuracy = stats.get(Stats.ACCURACY);
        int evasion = player.getStats().get(Stats.EVASION);
        int criticalHitChance = stats.get(Stats.CRITICAL_HIT);
        int criticalDamage = stats.get(Stats.CRITICAL_DAMAGE);

        /**
         * Comprobar golpe crítico
         */

        boolean isCriticalHit = Math.random() * 100 < criticalHitChance;
        int damage = calculateDamage(baseDamage, defense, evasion, criticalDamage, criticalHitChance, accuracy);
        if (isCriticalHit) {
            damage *= criticalDamage;
            JOptionPane.showMessageDialog(null, "Golpe crítico!");
        }

        /**
         * Comprobar esquiva
         */

        if (Math.random() * 100 > evasion) {
            if (damage > 0) {
                int newHP = player.getStats().get(Stats.HP) - damage;
                player.getStats().put(Stats.HP, Math.max(newHP, 0));
                JOptionPane.showMessageDialog(null, this.name + " atacó a " + player.getName() + " e hizo " + damage + " puntos de daño.");
            } else {
                JOptionPane.showMessageDialog(null, this.name + " falló el ataque contra " + player.getName());
            }
        } else {
            JOptionPane.showMessageDialog(null, player.getName() + " esquivó el ataque de " + this.getName());
        }
    }

    private int calculateDamage(int baseDamage, int defense, int accuracy, int evasion, int criticalHitChance, int criticalDamage) {

        int damage = Math.max(0, baseDamage - defense);

        return damage;
    }

}