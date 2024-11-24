package org.learn.example.sampleUML.basic;

import org.learn.example.sampleUML.basic.armor.Arms;
import org.learn.example.sampleUML.basic.armor.Body;
import org.learn.example.sampleUML.basic.armor.Head;
import org.learn.example.sampleUML.basic.armor.Legs;

public class Main {
    public static  void main(String[] args) {

        Human human = new Human(
            "アルバート",
            "男性",
            50,
            40,
            10,
            20,
            15,
            new Weapon("鋼の剣", 10, "Sword"),
            new Armor(
                new Head("鋼のヘルメット", 5, 3),
                new Arms("鋼のガントレット", 3, 1),
                new Body("鋼の鎧", 5, 1),
                new Legs("鋼のレギンス", 7, 2)
            )
        );
        human.println();
    }
}
