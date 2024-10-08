package enemies.wolfs;

import enemies.Enemy;
import player.Player;
import player.Stats;


import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 * La clase AloneWolf es una subclase de la clase Enemy. Es un enemigo básico que el jugador puede encontrar en el juego.
 * Tiene un método de ataque único que le permite realizar una de tres acciones: simpleAttack, howl, or bite.
 * El método simpleAttack permite que AloneWolf ataque al jugador con una cantidad determinada de daño.
 * El método howl permite que AloneWolf aúlle.
 * El método bite permite que AloneWolf muerda al jugador provocando una cantidad determinada de daño.
 */
@RegularEnemy
public class AloneWolf extends Enemy implements Serializable {

	/**
	 * Constructor de la clase Lobo solitario.
	 */
	public AloneWolf(Player player) {

		super(player, "Lobo Solitario", 10, 10, 5, 4);
		stats.put(Stats.ATTACK, 8);
		stats.put(Stats.DEFENSE, 3);
		stats.put(Stats.LUCK, 3);
		stats.put(Stats.SPEED, 5);
		stats.put(Stats.DEXTERITY, 4);
	}

	/**
	 * Función que permite al lobo solitario atacar.
	 *
	 * @param player Jugador al que se le ataca.
	 */
	public String simpleAttack(Player player) {

		int damage = getDamage(player);
		String message = String.format("¡%s ataca con %d punto(s) de daño!\n", getName(), damage);
		message += player.takeDamage(damage);
		return message;
	}

	/**
	 * Función que permite al lobo solitario aullar.
	 *
	 * @param player Jugador al que se le aúlla.
	 */
	public String howl(Player player) {

		//TODO: Implementar efecto de aullido.
		return String.format("¡%s aúlla!\n", getName());
	}

	/**
	 * Función que permite al lobo lanzar una mordida poderosa.
	 *
	 * @param player Jugador al que se le muerde.
	 */
	public String bite(Player player) {

		int totalDamage = getAdjustedAttack() + 1;
		String message = String.format("¡%s muerde con %d punto(s) de daño!\n", getName(), totalDamage);
		return message + player.takeDamage(totalDamage);
	}


}
