package items.armors.head;

import items.armors.Armor;
import items.armors.ArmorType;
import player.Player;
import player.Stats;

import java.io.Serializable;
/**
 * La clase WoodHelmet es una subclase de la clase head. Es un Casco de Madera que el jugador puede encontrar en el juego.
 */
public class WoodHelmet extends Armor implements Serializable {

	public WoodHelmet() {

		super("Casco de Madera",
				"Un casco de madera que no protege mucho, pero es mejor que nada.", 5);
		this.armorType = ArmorType.HEAD;
	}
	/**
	 * Función que da las especificaciones de cada casco dependiendo de que tipo sea.
	 */
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
				stats.put(Stats.DEFENSE, 5);
				stats.put(Stats.RESISTANCE, 3);
				stats.put(Stats.INTELLIGENCE, 3);
				stats.put(Stats.DEXTERITY, 1);
				break;

		}
	}
}
