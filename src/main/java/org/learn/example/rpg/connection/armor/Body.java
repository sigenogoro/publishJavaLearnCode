package org.learn.example.rpg.connection.armor;

public class Body {
    private String name;
    private int defenseBonus;
    private int magicDefenseBonus;

    public Body(String name, int defenseBonus, int magicDefenseBonus) {
        this.name = name;
        this.defenseBonus = defenseBonus;
        this.magicDefenseBonus = magicDefenseBonus;
    }

    @Override
    public String toString() {
        return "{name='" + name + "', defenseBonus=" + defenseBonus + ", magicDefenseBonus=" + magicDefenseBonus + "}";
    }
}

