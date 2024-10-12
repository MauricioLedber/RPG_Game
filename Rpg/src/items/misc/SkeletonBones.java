package items.misc;
import items.Item;
import java.io.Serializable;
/**
 * La clase SkeletonBones es una clase que extiende de Item e implementa la interfaz Serializable. Representa un objeto específico en un juego.
 */
public class SkeletonBones extends Item implements Serializable {

    public SkeletonBones(){

        super("Huesos de esqueleto", "Una ecxelente alternativa de fertilizante", 7);
    }
}
