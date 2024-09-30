package enemies.dragon;

import enemies.Enemy;
import player.Player;
import player.Stats;
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
/**
 * La clase RedDragon es una subclase de la clase Enemy. Es un enemigo básico que el jugador puede encontrar en el juego.
 * Tiene un método de ataque único que le permite realizar una de tres acciones: simpleAttack, screech.
 * El método simpleAttack permite que AloneWolf ataque al jugador con una cantidad determinada de daño.
 * El método screech permite que RedDragon lance fuego.
 */

@RegularEnemy
public class RedDragon extends Enemy implements Serializable {
    /**
     * Constructor de la clase Dragon rojo.
     */
    public RedDragon(Player player) {

        super(player, "Dragón Rojo", 5, 5, 8, 5);
        stats.put(Stats.ATTACK, 7);
        stats.put(Stats.DEFENSE, 4);
        stats.put(Stats.LUCK, 4);
        stats.put(Stats.SPEED, 5);
        stats.put(Stats.DEXTERITY, 4);
    }

    /**
     * Función que permite al Dragon rojo atacar al jugador.
     */
    @Override
    public String getAttack() throws EnemyDeadException {

        String message = "";
        if (!isDead()) {

            double simpleAttackProbability = 0.5;
            double screechProbability = 0.5;
            double totalProbability = simpleAttackProbability + screechProbability;
            double ratio = Randomized.randomizeDouble(totalProbability);
            // simpleAttackProbability = 50%, screechProbability = 50%
            // simpleAttackProbability + screechProbability = 100%
            // ratio = 0.0 - 0.5 -> simpleAttack, ratio = 0.51 - 1.0 -> screech
            if (ratio <= simpleAttackProbability) message = simpleAttack(player);
            else message = screech(player);
        } else {
            throw new EnemyDeadException();
        }
        return message;
    }
    /**
     * Función que permite al Dragon rojo soltar un objeto al morir.
     *
     * @param player Jugador al que se le suelta el objeto.
     */
    @Override
    public void dropItem(Player player) {

        int ratio = Randomized.randomizeNumber(1, 100);
        player.getInventory().addItem(ratio > 50 ? new DragonBreath() : new DragonFur());
    }
    /**
     * Función que permite al Dragon rojo atacar.
     *
     * @param player Jugador al que se le ataca.
     */
    public String simpleAttack(Player player) {

        int damage = getDamage(player);
        String message = String.format("¡%s ataca con %d punto(s) de daño!\n", getName(), damage);
        message += player.takeDamage(damage);
        return message;
    }

    /**
     * Función que permite al Dragon rojo Lanzar fuego.
     *
     * @param player Jugador al que se le ataca.
     */
    public String screech(Player player) {

        int damage = getAdjustedAttack() + 3;
        String message = String.format("¡%s Lanza fuego que causa %d punto(s) de daño!\n", getName(),
                damage);
        message += player.takeDamage(damage);
        return message;
    }

}
