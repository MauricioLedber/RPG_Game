package items.misc;
import items.Item;
import java.io.Serializable;

public class RottingMeat extends Item implements Serializable {
    public RottingMeat(){
        super("Carne en descomposición", "Estó no se puede comer!!", 0);
    }
}
