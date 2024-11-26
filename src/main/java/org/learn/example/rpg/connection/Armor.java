package org.learn.example.rpg.connection;

import org.learn.example.rpg.connection.armor.Arms;
import org.learn.example.rpg.connection.armor.Body;
import org.learn.example.rpg.connection.armor.Head;
import org.learn.example.rpg.connection.armor.Legs;

class Armor {
    private Head head;
    private Arms arms;
    private Body body;
    private Legs legs;

    public Armor(Head head, Arms arms, Body body, Legs legs) {
        this.head = head;
        this.arms = arms;
        this.body = body;
        this.legs = legs;
    }

    @Override
    public String toString() {
        return "Armor{head=" + head + ", arms=" + arms + ", body=" + body + ", legs=" + legs + "}";
    }
}
