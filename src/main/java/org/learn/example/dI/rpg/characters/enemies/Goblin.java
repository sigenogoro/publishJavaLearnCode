package org.learn.example.dI.rpg.characters.enemies;

import org.learn.example.dI.rpg.characters.Character;
import org.learn.example.dI.rpg.characters.CharacterType;
import org.learn.example.dI.rpg.characters.EnemyType;
import org.learn.example.dI.rpg.weapons.Weapon;
import org.learn.example.dI.rpg.weapons.WeaponType;

// 戦士
public class Goblin extends Character {
    public Goblin(String name, Weapon weapon){
        super(name,CharacterType.GOBLIN,100, 200, weapon);
        if(weapon.getWeaponType() != WeaponType.CLUB){
            throw new IllegalArgumentException("ゴブリンは棍棒しか使えません。");
        }
    }
}
