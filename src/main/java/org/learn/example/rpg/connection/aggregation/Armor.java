package org.learn.example.rpg.connection.aggregation;

import org.learn.example.rpg.connection.aggregation.armor.Arms;
import org.learn.example.rpg.connection.aggregation.armor.Body;
import org.learn.example.rpg.connection.aggregation.armor.Head;
import org.learn.example.rpg.connection.aggregation.armor.Legs;

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
