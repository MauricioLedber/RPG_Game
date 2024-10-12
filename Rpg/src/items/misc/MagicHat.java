package items.misc;
import items.Item;

import java.io.Serializable;
/**
 * La clase MagicHat es una clase que extiende de Item e implementa la interfaz Serializable. Representa un objeto específico en un juego.
 */
public class MagicHat extends Item implements Serializable {

    public MagicHat (){
        super("Sombrero magico ", "Un buen sombrero para que te veas bien o lo vendas.",
                5);
    }
}