package items.weapons.bow;

import items.weapons.Weapon;
import player.Stats;

import java.io.Serializable;

public class Bow extends Weapon implements Serializable {

    public Bow(){
        super("Arco", "Un simple arco de caza",4) ;
    }

    @Override
    public String effect(){
        return null;
    }

    @Override
    protected void initStats(){

        switch (rarity){
            case COMMON:
                stats.put(Stats.ATTACK,1);
                break;
            case UNCOMMON:
                stats.put(Stats.ATTACK, 2);
                stats.put(Stats.DEXTERITY, 1);
            case RARE:
                stats.put(Stats.ATTACK, 3);
                stats.put(Stats.DEXTERITY, 2);
                stats.put(Stats.LUCK, 1);
            case EPIC:
                stats.put(Stats.ATTACK, 4);
                stats.put(Stats.DEXTERITY, 3);
                stats.put(Stats.LUCK, 2);
                break;
            case LEGENDARY:
                stats.put(Stats.ATTACK, 5);
                stats.put(Stats.DEXTERITY, 4);
                stats.put(Stats.LUCK, 3);
                stats.put(Stats.RESISTANCE, 2);
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
        return "Arco de madera";
    }
}
