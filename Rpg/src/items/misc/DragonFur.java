package items.misc;

import items.Item;

import java.io.Serializable;
/**
 * La clase DragonFur es una clase que extiende de Item e implementa la interfaz Serializable. Representa un objeto específico en un juego.
 */
public class DragonFur extends Item implements Serializable {

    public DragonFur(){
        super("Piel de dragon", "Piel de dragon, es usado para crear armaduras.", 50);
    }
}
