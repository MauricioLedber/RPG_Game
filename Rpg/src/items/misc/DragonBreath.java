package items.misc;

import items.Item;

import java.io.Serializable;

/**
 * La clase DragonBreath es una clase que extiende de Item e implementa la interfaz Serializable. Representa un objeto específico en un juego.
 */
public class DragonBreath extends Item implements Serializable {

    public DragonBreath () {
        super("Aliento de Dragón", "Aleinto de Dragón, un item de alto valor",10);
    }
}
