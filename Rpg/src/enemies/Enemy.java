package enemies;

import characters.BasicCharacter;
import gui.panels.DialogPanel;
import player.Player;
import player.Stats;
import java.awt.*;
import java.io.Serializable;
import java.util.HashMap;

public abstract class Enemy extends BasicCharacter implements Serializable {

	protected final int adjustmentFactor = 3;
	protected final String name;
	protected final HashMap<Stats, Integer> stats = new HashMap<>();
	protected final int gold;
	protected final int experience;
	protected final int level;
	protected final int maxLevel;
	protected final Player player;
	private static final int BASE_LEVEL = 1;

	public Enemy(Player player, String name, int maxLevel, int health, int gold, int experience) {

		super(name, health, 0);
		this.player = player;
		this.maxLevel = maxLevel;
		this.level = getLevel(player, maxLevel);
		this.name = name;
		this.maxHp = getHealth(health);
		this.hp = maxHp;
		this.gold = getGold(gold);
		this.experience = getExperience(experience);
	}


	protected int getDefense(Player player) {

		int defense = getAdjustedDefense();
		if (stats.get(Stats.LUCK) > player.getDexterity()) {
			//TODO: Implement críticos (optional)
		}
		return defense;
	}

	public int getAdjustedSpeed() {
		return stats.get(Stats.SPEED) + (player.getLevel() - BASE_LEVEL) * adjustmentFactor;
	}

	public int getAdjustedAttack() {

		int adjustedAttack = stats.get(Stats.ATTACK) + (player.getLevel() - BASE_LEVEL) * adjustmentFactor;
		if (adjustedAttack <= player.getDefense()) adjustedAttack = player.getDefense() + adjustmentFactor;
		return adjustedAttack;
	}

	public int getAdjustedDefense() {

		int adjustedDefense = stats.get(Stats.DEFENSE) + (player.getLevel() - BASE_LEVEL) * adjustmentFactor;
		if (adjustedDefense >= player.getDamage()) adjustedDefense = player.getDamage() - adjustmentFactor;
		return adjustedDefense;
	}

	protected int getDamage(Player player) {

		int damage = getAdjustedAttack();
		if (stats.get(Stats.DEXTERITY) > player.getLuck()) {
			//TODO: Implement críticos (optional)
		}
		return damage;
	}

	private int getLevel(Player player, int maxLevel) {

		return Math.min(player.getLevel(), maxLevel); // Ensure level doesn't exceed maxLevel
	}

	public int getLevel() {

		return level;
	}

	public String getName() {

		return name;
	}

	public int getGold() {

		return gold;
	}

	public int getExperience() {

		return experience;
	}

	public int calculateDamage(Player player) {

		return Math.max(0, (player.getDamage() - getDefense(player)));
	}

	public String takeDamage(Player player) {

		int damage = calculateDamage(player);
		String message = String.format("¡%s ataca con %d punto(s) de daño!\n", player.getName(), player.getDamage());
		message += String.format("¡%s sufre %d punto(s) de daño!\n", name, damage);
		hp -= damage;
		if (isDead()) {
			message += String.format("¡%s ha sido derrotado!\n", name);
		}
		return message;
	}

	public void attack() {
		// No exception thrown, handle dead enemy case
		if (isDead()) {
			DialogPanel.getInstance().addText(String.format("%s está muerto y no puede atacar.\n", name));
			return
		}
	}