package org.learn.example.rpg.dI.rpg.characters;

import org.learn.example.rpg.dI.rpg.weapons.Weapon;

public class Character {
    protected String name;
    protected int hp;
    protected int mp;
    protected Weapon weapon;
    protected CharacterType characterType;

    public String getName() {
        return name;
    }

    // コンストラクタ
    public Character(String name, CharacterType characterType, int hp, int mp, Weapon weapon) {
        this.name = name;
        this.characterType = characterType;
        this.hp = hp;
        this.mp = mp;
        this.weapon = weapon;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        System.out.println(name + "は" + damage + " のダメージを受けた");
        if(hp <= 0){
            System.out.println(name + " は倒れた");
        }
    }

    public void attack(Character target){
        System.out.println(name + "が攻撃します" + weapon.useWeapon());
        target.takeDamage(weapon.getDamage());
    }
}
