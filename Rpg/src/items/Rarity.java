package items;

import java.io.Serializable;
/**
 *Esta clase Rarity es una enumeración que define los posibles niveles de rareza de un item en un juego de rol..
 * */
public enum Rarity implements Serializable {
	COMMON, UNCOMMON, RARE, EPIC, LEGENDARY;

	public static Rarity getRandomRarity() {

		return values()[(int) (Math.random() * values().length)];
	}
}
