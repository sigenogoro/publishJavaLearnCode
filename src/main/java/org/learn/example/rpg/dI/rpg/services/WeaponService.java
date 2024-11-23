package org.learn.example.rpg.dI.rpg.services;

import org.learn.example.rpg.dI.rpg.characters.CharacterType;
import org.learn.example.rpg.dI.rpg.weapons.*;

// 武器提供を行うサービスクラス
public class WeaponService {
    public Weapon getWeapon(CharacterType characterType){
        return switch (characterType) {
            case WARRIOR -> new Sword();
            case MAGE, HEALER -> new Staff();
            case THIEF -> new Dagger();
            case PALADIN -> new Hammer();
            case GOBLIN -> new Club();
            default -> throw new IllegalArgumentException("未知のキャラクタータイプです。");
        };
    }
}
