package enemies.zombie;

import enemies.Enemy;
import player.Player;
import player.Stats;


import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
/**
 * La clase StrongZombie es una subclase de la clase Enemy. Es un enemigo básico que el jugador puede encontrar en el juego.
 * Tiene un método de ataque único que le permite realizar una de tres acciones: simpleAttack, screech.
 * El método simpleAttack permite al StrongZombie atacar al jugador e infligir una cantidad determinada de daño.
 * El método screech permite que StrongZombie de golpes.
 */
@RegularEnemy
public class StrongZombie extends Enemy implements Serializable {
    /**
     * Constructor de la clase StrongZombie.
     */
    public StrongZombie (Player player) {
        super(player, "Zombie fuerte", 2, 5, 5, 5);
        stats.put(Stats.ATTACK, 7);
        stats.put(Stats.DEFENSE, 2);
        stats.put(Stats.LUCK, 3);
        stats.put(Stats.SPEED, 5);
        stats.put(Stats.DEXTERITY, 4);
    }


    /**
     * Función que permite al StrongZombie atacar al jugador.
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
     * Función que permite al StrongZombie dar un golpe en la batalla.
     */
    public String screech(Player player) {

        int damage = getAdjustedAttack() + 3;
        String message = String.format("¡%s da golpes que causa %d punto(s) de daño!\n", getName(),
                damage);
        message += player.takeDamage(damage);
        return message;
    }


}
