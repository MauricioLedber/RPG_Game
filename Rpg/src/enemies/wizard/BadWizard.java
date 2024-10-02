package enemies.wizard;

import enemies.Enemy;
import player.Player;
import player.Stats;


import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

@RegularEnemy
public class BadWizard extends Enemy implements Serializable {
    public BadWizard(Player player) {

        super(player, "Mago malvado", 5, 5, 5, 5);
        stats.put(Stats.ATTACK, 8);
        stats.put(Stats.DEFENSE, 4);
        stats.put(Stats.LUCK, 4);
        stats.put(Stats.SPEED, 2);
        stats.put(Stats.DEXTERITY, 5);
    }



    public String simpleAttack(Player player) {

        int damage = getDamage(player);
        String message = String.format("¡%s ataca con %d punto(s) de daño!\n", getName(), damage);
        message += player.takeDamage(damage);
        return message;
    }

    public String runAway() {

        this.hp = 0;
        return "¡El mago ha escapado de la batalla !\n";
    }


}
