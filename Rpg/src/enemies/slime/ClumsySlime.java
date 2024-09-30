package enemies.slime;

import enemies.Enemy;
import player.Player;
import player.Stats;
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

@RegularEnemy
public class ClumsySlime extends Enemy implements Serializable {
    public ClumsySlime (Player player){
        super(player, "Slime torpe", 2, 3, 1, 1);
        stats.put(Stats.ATTACK, 3);
        stats.put(Stats.DEFENSE, 1);
        stats.put(Stats.LUCK, 0);
        stats.put(Stats.SPEED, 2);
        stats.put(Stats.DEXTERITY, 0);
    }

    @Override
    public String getAttack() throws EnemyDeadException{

        String message = "";
        if (!isDead()){

            double plainAttackProbability = 0.5;
            double runAwayProbability = 0.5;
            double totalProbability = plainAttackProbability + runAwayProbability;
            double ratio = Randomized.randomizeDouble(totalProbability);
            if (ratio <= plainAttackProbability) message = simpleAttack(player);
            else message = runAway();
        } else {
        throw new EnemyDeadException();
        }
        return message;
    }

    @Override
    public void dropItem (Player player){

        int ratio = Randomized.randomizeNumber(1, 100);
        player.getInventory().addItem(ratio > 50 ? new SlimeHeart() : new SlimeCorpse());
    }

    public String simpleAttack(Player player) {

        int damage = getDamage(player);
        String message = String.format("¡%s ataca con %d punto(s) de daño!\n", getName(), damage);
        message += player.takeDamage(damage);
        return message;
    }

    public String runAway(){
        this.hp = 0;
        return "¡El Slime ha escapado de la batalla!\n";
    }

}
