package items.misc;

import items.Item;

import java.io.Serializable;
/**
 * La clase WolfFur es una clase que extiende de Item e implementa la interfaz Serializable. Representa un objeto específico en un juego.
 */
public class WolfFur extends Item implements Serializable {

	public WolfFur() {

		super("Piel de lobo", "Una piel de lobo que puede ser vendida por un buen precio.",
				15);
	}
}
