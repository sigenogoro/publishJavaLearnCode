package org.learn.example.rpg.dI.rpg.characters.supporter;

import org.learn.example.rpg.dI.rpg.characters.Character;
import org.learn.example.rpg.dI.rpg.characters.CharacterType;
import org.learn.example.rpg.dI.rpg.weapons.Weapon;
import org.learn.example.rpg.dI.rpg.weapons.WeaponType;

// 戦士
public class Paladin extends Character {
    public Paladin(String name, Weapon weapon){
        super(name, CharacterType.PALADIN,100, 200, weapon);
        if(!(weapon.getWeaponType() == WeaponType.SWORD || weapon.getWeaponType() == WeaponType.HAMMER)){
            throw new IllegalArgumentException("パラディンは剣またはハンマーしか使えません。");
        }
    }
}
