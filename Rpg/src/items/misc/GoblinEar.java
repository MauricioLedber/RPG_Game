package items.misc;

import items.Item;

import java.io.Serializable;
/**
 * La clase GoblinEar es una clase que extiende de Item e implementa la interfaz Serializable. Representa un objeto específico en un juego.
 */
public class GoblinEar extends Item implements Serializable {

	public GoblinEar() {

		super("Oreja de duende", "Una oreja de duende que puede ser vendida por un buen precio.",
				10);
	}
}
