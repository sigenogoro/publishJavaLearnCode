package org.learn.example.rpg.connection.aggregation;

import org.learn.example.rpg.connection.aggregation.armor.Arms;
import org.learn.example.rpg.connection.aggregation.armor.Body;
import org.learn.example.rpg.connection.aggregation.armor.Head;
import org.learn.example.rpg.connection.aggregation.armor.Legs;

public class Main {
    public static  void main(String[] args) {
        Weapon weapon = new Weapon("鋼の剣", 10, "Sword");
        Head head = new Head("鋼のヘルメット", 5, 3);
        Arms arms = new Arms("鋼のガントレット", 3, 1);
        Body body = new Body("鋼の鎧", 5, 1);
        Legs legs = new Legs("鋼のレギンス", 7, 2);
        Armor armor = new Armor(head, arms, body, legs);
        Human human = new Human(
            "アルバート",
            "男性",
            50,
            40,
            10,
            20,
            15,
            weapon,
            armor
        );
        human.println();
    }
}
