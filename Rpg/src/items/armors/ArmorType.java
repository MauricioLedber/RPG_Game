package items.armors;

import java.io.Serializable;
/**
 * El enum ArmorType es una enumeración que representa los diferentes tipos de armadura que se pueden encontrar en un juego.
 */
public enum ArmorType implements Serializable {

	HEAD, BODY, LEGS, FEET, HANDS;

	public static String getArmorType(ArmorType type) {

		return switch (type) {
			case HEAD -> "CABEZA";
			case BODY -> "PECHO";
			case LEGS -> "PIERNAS";
			case FEET -> "PIES";
			case HANDS -> "MANOS";
			//case SHIELD -> "ESCUDO";
		};
	}
}
