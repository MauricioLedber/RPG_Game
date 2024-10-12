package items.weapons.shield;

import items.weapons.Weapon;
import player.Stats;

import java.io.Serializable;

public class Shield extends Weapon implements Serializable {

    public Shield(){
        super("Escudo de madera", "Te ayuda a protegerte", 15);
    }

    @Override
    public String effect(){
        return null;
    }

    @Override
    protected void initStats(){

        switch (rarity){
            case COMMON:
                stats.put(Stats.ATTACK,2);
                stats.put(Stats.RESISTANCE, 2);
                break;
            case UNCOMMON:
                stats.put(Stats.ATTACK, 3);
                stats.put(Stats.DEXTERITY, 2);
                stats.put(Stats.RESISTANCE, 3);
            case RARE:
                stats.put(Stats.ATTACK, 4);
                stats.put(Stats.DEXTERITY, 3);
                //stats.put(Stats.LUCK, 2);
                stats.put(Stats.RESISTANCE, 4);
            case EPIC:
                stats.put(Stats.ATTACK, 5);
                stats.put(Stats.DEXTERITY, 4);
                //stats.put(Stats.LUCK, 3);
                stats.put(Stats.RESISTANCE, 5);
                break;
            case LEGENDARY:
                stats.put(Stats.ATTACK, 6);
                stats.put(Stats.DEXTERITY, 5);
                //stats.put(Stats.LUCK, 4);
                stats.put(Stats.RESISTANCE, 6);
                break;
            default:
                throw new IllegalArgumentException("Invalid rarity: " + rarity);
        }
    }

    @Override
    public void callEffect(){
    }

    @Override
    public String toString(){
        return "Escudo de madera";
    }
}
