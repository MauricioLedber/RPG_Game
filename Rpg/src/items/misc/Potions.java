package items.misc;

import items.Item;

import java.io.Serializable;

public class Potions extends Item implements Serializable {

    public  Potions(){
        super("poción de vida", "Posión de curación, se puede vender a buen precio", 6);
    }
}
