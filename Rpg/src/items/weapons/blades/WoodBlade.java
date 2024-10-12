package items.weapons.blades;

import items.weapons.Weapon;
import player.Stats;

import java.io.Serializable;
/**
 * La clase WoodBlade es una subclase de Weapon que implementa la interfaz Serializable. Esta clase representa una espada de madera en un juego de rol.
 */
public class WoodBlade extends Weapon implements Serializable {
	/**
	 * El constructor WoodBlade() inicializa la espada de madera
	 * */
	public WoodBlade() {

		super("Espada de madera", "Una simple espada de madera", 5);
	}
	/**
	 *Este método devuelve un string que representa el efecto de la espada de madera.
	 * */
	@Override
	public String effect() {

		return null;
	}
	/**
	 *Este método inicializa las estadísticas de la espada de madera según su rareza.
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
	 *Este método no hace nada en este caso.
	 * */
	@Override
	public String toString() {

		return "Espada de madera";
	}
}
