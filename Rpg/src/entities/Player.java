import javax.swing.*;
import java.util.HashMap;

public class Player {

    private String name;
    private HashMap<Stats, Integer> stats;

    public Player(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        /**
         * Inicialización de estadísticas con valores por defecto
         */
        this.stats.put(Stats.MAX_HP, 100);
        this.stats.put(Stats.HP, 100);
        this.stats.put(Stats.MAX_MP, 50);
        this.stats.put(Stats.MP, 50);
        this.stats.put(Stats.ATTACK, 10);
        this.stats.put(Stats.DEFENSE, 5);
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

    public void attack(Enemy enemy) {
        int baseDamage = stats.get(Stats.ATTACK);
        int defense = enemy.getStats().get(Stats.DEFENSE);
        int accuracy = stats.get(Stats.ACCURACY);
        int evasion = enemy.getStats().get(Stats.EVASION);
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
                int newHP = enemy.getStats().get(Stats.HP) - damage;
                enemy.getStats().put(Stats.HP, Math.max(newHP, 0));
                JOptionPane.showMessageDialog(null, this.name + " atacó a " + enemy.getName() + " e hizo " + damage + " puntos de daño.");
            } else {
                JOptionPane.showMessageDialog(null, this.name + " falló el ataque contra " + enemy.getName());
            }
        } else {
            JOptionPane.showMessageDialog(null, enemy.getName() + " esquivó el ataque de " + this.getName());
        }
    }

    private int calculateDamage(int baseDamage, int defense, int accuracy, int evasion, int criticalHitChance, int criticalDamage) {
        int damage = Math.max(0, baseDamage - defense);
        return damage;
    }

}