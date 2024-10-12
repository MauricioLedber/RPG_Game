package items.misc;

import items.Item;

import java.io.Serializable;

public class SlimeCorpse extends Item implements Serializable {

    public SlimeCorpse(){
        super("Cadáver de slime", "Solo es basura " +
                ", no sirve para nada", 0);
    }
}
