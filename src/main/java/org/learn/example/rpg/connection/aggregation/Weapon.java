package org.learn.example.rpg.connection.aggregation;

class Weapon {
    String name;
    int attackBonus;
    String type;

    public Weapon(
        String name, int attackBonus, String type
    ){
        this.name = name;
        this.attackBonus = attackBonus;
        this.type = type;
    }

    @Override
    public String toString(){
        return "Weapon{name='" + name + "', attackBonus=" + attackBonus + ", type='" + type + "'}";
    }
}
