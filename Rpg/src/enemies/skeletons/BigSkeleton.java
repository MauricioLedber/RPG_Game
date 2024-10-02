package enemies.skeletons;

import enemies.Enemy;
import player.Player;
import player.Stats;
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
/**
 * La clase BigSkeleton es una subclase de la clase Enemy. Es un enemigo básico que el jugador puede encontrar en el juego.
 * Tiene un método de ataque único que le permite realizar una de tres acciones: simpleAttack, runAway.
 * El método simpleAttack permite al BigSkeleton atacar al jugador e infligir una cantidad determinada de daño.
 * El método runAway permite al BigSkeleton huir de la batalla.
 */

@RegularEnemy
public class BigSkeleton extends Enemy implements Serializable {
    /**
     * Constructor de la clase BigSkeleton.
     */
    public BigSkeleton(Player player) {

        super(player, "Esqueleto grande", 5, 5, 5, 5);
        stats.put(Stats.ATTACK, 7);
        stats.put(Stats.DEFENSE, 3);
        stats.put(Stats.LUCK, 3);
        stats.put(Stats.SPEED, 4);
        stats.put(Stats.DEXTERITY, 3);
    }


    /**
     * Función que permite al BigSkeleton atacar al jugador.
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
     * Función que permite al BigSkeleton huir de la batalla.
     */
    public String runAway() {

        this.hp = 0;
        return "¡El esqueleto huye de la batalla!\n";
    }

    @Override
    public Image getImage() {
        return ImageManager.getInstance().getImage("skeleton",
                new ImageIcon("img\\enemies\\skeleton\\skeleton.png").getImage());
    }
}
