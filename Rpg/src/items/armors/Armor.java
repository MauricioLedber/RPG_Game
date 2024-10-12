package items.armors;

import items.Item;
import items.ItemType;
import player.Stats;

import java.io.Serializable;
import java.util.HashMap;
/**
 * La clase Armor es una clase abstracta que extiende de Item e implementa la interfaz Serializable. Representa un tipo de objeto que se utiliza en un juego de rol para proporcionar protección y estadísticas adicionales al personaje.
 */
public abstract class Armor extends Item implements Serializable {

	protected HashMap<Stats, Integer> stats = new HashMap<>();
	protected ArmorType armorType;
	/**
	 * constructor de Armor.
	 */
	public Armor(String name, String description, int price) {

		super(name, description, price);
		initStats();
		type = ItemType.ARMOR;
	}

	protected abstract void initStats();

	public HashMap<Stats, Integer> getStats() {

		return stats;
	}

	public void setStats(HashMap<Stats, Integer> stats) {

		this.stats = stats;
	}

	public ArmorType getArmorType() {

		return armorType;
	}
}
