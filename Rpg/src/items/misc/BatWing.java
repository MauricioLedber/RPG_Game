package items.misc;

import items.Item;

import java.io.Serializable;
/**
 * La clase BatWing es una clase que extiende de Item e implementa la interfaz Serializable. Representa un objeto específico en un juego.
 */
public class BatWing extends Item implements Serializable {

	public BatWing() {
		super("Ala de murciélago", "Una ala de murciélago diminuto. Se puede vender por un buen precio.",
				7);
	}
}
