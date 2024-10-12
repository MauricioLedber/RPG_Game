package items.weapons.excalibur;

import items.weapons.Weapon;
import player.Stats;

import java.io.Serializable;

public class Excalibur extends Weapon implements Serializable {

    public Excalibur(){
        super("Excálibur", "Espada del Rey Arturo", 999);
    }
    @Override
    public String effect(){
        return null;
    }

    @Override
    protected void initStats(){

        switch (rarity){
            case EPIC:
                stats.put(Stats.ATTACK, 500);
                stats.put(Stats.DEXTERITY, 400);
                stats.put(Stats.LUCK, 300);
                stats.put(Stats.RESISTANCE, 300);
                break;
            case LEGENDARY:
                stats.put(Stats.ATTACK, 600);
                stats.put(Stats.DEXTERITY, 500);
                stats.put(Stats.LUCK, 400);
                stats.put(Stats.RESISTANCE, 300);
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
        return "Excálibur";
    }

}
