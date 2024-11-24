package org.learn.example.sampleUML.basic.armor;

public class Arms {
    private String name;
    private int defenseBonus;
    private int magicDefenseBonus;

    public Arms(String name, int defenseBonus, int magicDefenseBonus) {
        this.name = name;
        this.defenseBonus = defenseBonus;
        this.magicDefenseBonus = magicDefenseBonus;
    }

    @Override
    public String toString() {
        return "{name='" + name + "', defenseBonus=" + defenseBonus + ", magicDefenseBonus=" + magicDefenseBonus + "}";
    }
}