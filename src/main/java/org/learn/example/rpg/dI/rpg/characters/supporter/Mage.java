package org.learn.example.rpg.dI.rpg.characters.supporter;

import org.learn.example.rpg.dI.rpg.characters.Character;
import org.learn.example.rpg.dI.rpg.characters.CharacterType;
import org.learn.example.rpg.dI.rpg.weapons.Weapon;
import org.learn.example.rpg.dI.rpg.weapons.WeaponType;

// 戦士
public class Mage extends Character {
    public Mage(String name, Weapon weapon){
        super(name, CharacterType.MAGE,100, 200, weapon);
        if(!(weapon.getWeaponType() == WeaponType.STAFF)){
            throw new IllegalArgumentException("魔法使いは杖しか使えません。");
        }
    }
}
