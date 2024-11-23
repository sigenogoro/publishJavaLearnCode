package org.learn.example.dI.rpg.characters.supporter;

import org.learn.example.dI.rpg.characters.Character;
import org.learn.example.dI.rpg.characters.CharacterType;
import org.learn.example.dI.rpg.weapons.Weapon;
import org.learn.example.dI.rpg.weapons.WeaponType;

// 戦士
public class Healer extends Character {
    public Healer(String name, Weapon weapon){
        super(name, CharacterType.HEALER,100, 200, weapon);
        if(!(weapon.getWeaponType() == WeaponType.STAFF)) {
            throw new IllegalArgumentException("ヒーラーは剣または斧しか使えません。");
        }
    }
}
