package items.armors.hand;

import items.armors.Armor;
import items.armors.ArmorType;
import player.Player;
import player.Stats;

import java.io.Serializable;

public class MeshGloves extends Armor implements Serializable {

    private int counter;
    public MeshGloves(){

        super("Guantes de malla", "Te protegue las manos",5);
        this.counter = 0;
        this.armorType = ArmorType.HANDS;
    }

    @Override
    protected void initStats() {

        switch (rarity) {
            case COMMON:
                stats.put(Stats.DEFENSE, 1);
                break;
            case RARE:
                stats.put(Stats.DEFENSE, 2);
                stats.put(Stats.RESISTANCE, 1);
                break;
            case EPIC:
                stats.put(Stats.DEFENSE, 3);
                stats.put(Stats.RESISTANCE, 2);
                stats.put(Stats.INTELLIGENCE, 1);
                break;
            case LEGENDARY:
                stats.put(Stats.DEFENSE, 4);
                stats.put(Stats.RESISTANCE, 3);
                stats.put(Stats.INTELLIGENCE, 2);
                stats.put(Stats.DEXTERITY, 1);
                break;

        }
    }

    public void update(Player player) {

        if (counter > 0) {
            counter--;
            if (counter == 0) {
                player.setDefense(player.getDefense() - 2);
            }
        }
    }
}
