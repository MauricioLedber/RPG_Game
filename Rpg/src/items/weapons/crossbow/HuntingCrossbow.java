package items.weapons.crossbow;

import items.weapons.Weapon;
import player.Stats;

import java.io.Serializable;
/**
 *La clase HuntingCrossbow es una subclase de Weapon que implementa la interfaz Serializable.
 * */
public class HuntingCrossbow extends Weapon implements Serializable {
    /**
     * El constructor HuntingCrossbow() inicializa la Ballesta de caza.
     * */
    public HuntingCrossbow() {

        super("Ballesta de caza", "Una simple Ballesta de caza", 6);
    }
    /**
     *Este método devuelve un string que representa el efecto de la ballesta de caza.
     * */
    @Override
    public String effect() {

        return null;
    }
    /**
     *Este método inicializa las estadísticas de la ballesta de caza según su rareza.
     * */
    @Override
    protected void initStats() {

        switch (rarity) {
            case COMMON:
                stats.put(Stats.ATTACK, 1);
                break;
            case UNCOMMON:
                stats.put(Stats.ATTACK, 2);
                stats.put(Stats.DEXTERITY, 1);
                break;
            case RARE:
                stats.put(Stats.ATTACK, 3);
                stats.put(Stats.DEXTERITY, 2);
                stats.put(Stats.LUCK, 1);
                break;
            case EPIC:
                stats.put(Stats.ATTACK, 4);
                stats.put(Stats.DEXTERITY, 3);
                stats.put(Stats.LUCK, 2);
                break;
            case LEGENDARY:
                stats.put(Stats.ATTACK, 5);
                stats.put(Stats.DEXTERITY, 4);
                stats.put(Stats.LUCK, 3);
                stats.put(Stats.RESISTANCE, 1);
                break;
            default:
                throw new IllegalArgumentException("Invalid rarity: " + rarity);
        }
    }
    /**
     *Este método no hace nada en este caso.
     * */
    @Override
    public void callEffect() {

    }
    /**
     *Este método devuelve una representación de cadena de la ballesta de caza.
     * */
    @Override
    public String toString() {

        return "Ballesta de caza";
    }
}
