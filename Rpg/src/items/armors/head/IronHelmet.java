package items.armors.head;

import items.armors.Armor;
import items.armors.ArmorType;
import player.Player;
import player.Stats;

import java.io.Serializable;
/**
 * La clase IronHelmet es una subclase de la clase head. Es un Casco de Madera que el jugador puede encontrar en el juego.
 */
public class IronHelmet extends Armor implements Serializable {
	private int counter;

	public IronHelmet() {

		super("Casco de Hierro",
				"Un casco de hierro que protege más que el de madera.", 10);
		this.counter = 0;
		this.armorType = ArmorType.HEAD;
	}
	/**
	 * Función que da las especificaciones de cada casco dependiendo de que tipo sea.
	 */
	@Override
	protected void initStats() {

		switch (rarity) {
			case COMMON:
				stats.put(Stats.DEFENSE, 2);
				break;
			case RARE:
				stats.put(Stats.DEFENSE, 4);
				stats.put(Stats.RESISTANCE, 1);
				break;
			case EPIC:
				stats.put(Stats.DEFENSE, 6);
				stats.put(Stats.RESISTANCE, 2);
				stats.put(Stats.INTELLIGENCE, 2);
				break;
			case LEGENDARY:
				stats.put(Stats.DEFENSE, 8);
				stats.put(Stats.RESISTANCE, 4);
				stats.put(Stats.INTELLIGENCE, 6);
				stats.put(Stats.DEXTERITY, 3);
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
