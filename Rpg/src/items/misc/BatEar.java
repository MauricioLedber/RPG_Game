package items.misc;

import items.Item;

import java.io.Serializable;
/**
 * La clase BatEar es una clase que extiende de Item e implementa la interfaz Serializable. Representa un objeto específico en un juego.
 */
public class BatEar extends Item implements Serializable {

	public BatEar() {
		super("Oreja de murciélago", "Una oreja de murciélago diminuto. Se puede vender por un buen precio.",
				5);
	}
}
