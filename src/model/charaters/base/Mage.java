package model.charaters.base;

import model.base.Armor;
import model.base.Character;
import model.base.Weapon;
import model.weapons.WizardsStaff;

public abstract class Mage extends Character {
    public Mage(String name, Weapon weapon, Armor armor) {
        super(name, weapon, armor);
        manaPoints = 100;
        maxMana = 100;
    }

    public int getManaPoints() {
        return manaPoints;
    }

    public void decreaseMana(int mana) {
        manaPoints -= mana;
        if (manaPoints < 0)
            manaPoints = 0;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void addMana(int mana) {
        manaPoints += mana;
        if (manaPoints > maxMana)
            manaPoints = maxMana;
    }

    private int manaPoints;
    private int maxMana;

    @Override
    public void updateLevel() {
        super.updateLevel();
        maxMana += 10;
    }

    @Override
    public void attack(Character target) {
        if (manaPoints > 0)
            super.attack(target);
        else
            System.out.println("Недостаточно маны для атаки");
        if (super.getWeapon() instanceof WizardsStaff)
            decreaseMana(super.getWeapon().getDamage() / 10);
    }
}