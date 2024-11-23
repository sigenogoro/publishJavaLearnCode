package org.learn.example.rpg.dI.rpg.characters.supporter;

import org.learn.example.rpg.dI.rpg.characters.Character;
import org.learn.example.rpg.dI.rpg.characters.CharacterType;
import org.learn.example.rpg.dI.rpg.weapons.Weapon;
import org.learn.example.rpg.dI.rpg.weapons.WeaponType;

// 戦士
public class Thief extends Character {
    public Thief(String name, Weapon weapon){
        super(name, CharacterType.THIEF,100, 200, weapon);
        if(!(weapon.getWeaponType() == WeaponType.DAGGER)) {
            throw new IllegalArgumentException("盗賊は短剣しか使えません。");
        }
    }
}
