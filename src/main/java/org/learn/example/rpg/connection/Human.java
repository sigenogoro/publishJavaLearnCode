package org.learn.example.rpg.connection;

import org.learn.example.rpg.connection.armor.Armor;

class Human {
    private String name;
    private String gender;
    private int attackPower;
    private int defensePower;
    private int magicAttackPower;
    private int magicDefensePower;
    private int luck;
    private Weapon weapon;
    private Armor armor;

    public Human(
        String name,
        String gender,
        int attackPower,
        int defensePower,
        int magicAttackPower,
        int magicDefensePower,
        int luck,
        Weapon weapon,
        Armor armor
    ){
        this.name = name;
        this.gender = gender;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
        this.magicAttackPower = magicAttackPower;
        this.magicDefensePower = magicDefensePower;
        this.luck = luck;
        this.weapon = weapon;
        this.armor = armor;
    }

    public void println() {
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Attack Power: " + attackPower);
        System.out.println("Defense Power: " + defensePower);
        System.out.println("Magic Attack Power: " + magicAttackPower);
        System.out.println("Magic Defense Power: " + magicDefensePower);
        System.out.println("Luck: " + luck);
        System.out.println("Weapon: " + weapon);
        System.out.println("Armor: " + armor);
    }

    public void attack(){}
    public void defense(){}
}
