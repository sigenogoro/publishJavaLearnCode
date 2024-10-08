package org.learn.example.dI.rpg.characters.supporter;

import org.learn.example.dI.rpg.characters.Character;
import org.learn.example.dI.rpg.characters.CharacterType;
import org.learn.example.dI.rpg.weapons.Weapon;
import org.learn.example.dI.rpg.weapons.WeaponType;

// 戦士
public class Warrior extends Character {
    public Warrior(String name, Weapon weapon){
        super(name, CharacterType.WARRIOR,200, 30, weapon);
        if(!(weapon.getWeaponType() == WeaponType.SWORD || weapon.getWeaponType() == WeaponType.AXE)) {
            throw new IllegalArgumentException("剣士は剣または斧しか使えません。");
        }
    }
}
