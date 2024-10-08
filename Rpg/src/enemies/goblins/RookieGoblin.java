package enemies.goblins;

import enemies.Enemy;
import player.Player;
import player.Stats;
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 * La clase RookieGoblin es una subclase de la clase Enemy. Es un enemigo básico que el jugador puede encontrar en el juego.
 * Tiene un método de ataque único que le permite realizar una de tres acciones: plainAttack, runAway, or stealGold.
 * El método plainAttack permite al RookieGoblin atacar al jugador e infligir una cantidad determinada de daño.
 * El método runAway permite al RookieGoblin huir de la batalla.
 * El método stealGold permite al RookieGoblin robar una cantidad determinada de oro del jugador.
 */
@RegularEnemy
public class RookieGoblin extends Enemy implements Serializable {

	/**
	 * Constructor de la clase RookieGoblin.
	 */
	public RookieGoblin(Player player) {

		super(player, "D. Novato", 5, 5, 5, 2);
		stats.put(Stats.ATTACK, 7);
		stats.put(Stats.DEFENSE, 3);
		stats.put(Stats.LUCK, 3);
		stats.put(Stats.SPEED, 4);
		stats.put(Stats.DEXTERITY, 3);
	}

	/**
	 * Función que permite al RookieGoblin atacar al jugador.
	 *
	 * @param player Jugador al que se le ataca.
	 */
	private String plainAttack(@NotNull Player player) {

		int damage = getDamage(player);
		String message = String.format("¡%s ataca con %d punto(s) de daño!\n", getName(), damage);
		message += player.takeDamage(damage);
		return message;
	}

	/**
	 * Función que permite al RookieGoblin huir de la batalla.
	 */
	public String runAway() {

		this.hp = 0;
		return "¡El Duende novato huye de la batalla!\n";
	}

	/**
	 * Función que permite al RookieGoblin robar oro del jugador.
	 *
	 * @param player Jugador al que se le roba el oro.
	 */
	public String stealGold(@NotNull Player player) {

		String message = "";
		try {
			int minus = player.getGold() - 5;
			if (minus < 0)
				throw new ZeroException();
			player.setGold(minus);
			message += "¡El Duende novato roba 5 de oro!\n";
		} catch (ZeroException e) {
			player.setGold(0);
			message += "¡El Duende novato roba todo el oro del jugador!\n";
		}
		return message;
	}

}
