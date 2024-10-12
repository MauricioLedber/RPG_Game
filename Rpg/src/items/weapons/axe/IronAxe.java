package items.weapons.axe;

import items.weapons.Weapon;
import player.Stats;

import java.io.Serializable;

public class IronAxe extends Weapon implements Serializable {

    public IronAxe (){
        super("Hacha de hierro", "Una hacha de hierro", 9);
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
                break;
            case UNCOMMON:
                stats.put(Stats.ATTACK, 3);
                stats.put(Stats.DEXTERITY, 2);
            case RARE:
                stats.put(Stats.ATTACK, 4);
                stats.put(Stats.DEXTERITY, 3);
                stats.put(Stats.LUCK, 2);
            case EPIC:
                stats.put(Stats.ATTACK, 5);
                stats.put(Stats.DEXTERITY, 4);
                stats.put(Stats.LUCK, 3);
                break;
            case LEGENDARY:
                stats.put(Stats.ATTACK, 6);
                stats.put(Stats.DEXTERITY, 5);
                stats.put(Stats.LUCK, 4);
                stats.put(Stats.RESISTANCE, 3);
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
        return "Hacha de hierro";
    }
}
