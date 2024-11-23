package org.learn.example.dI.rpg.services;

import org.learn.example.dI.rpg.characters.CharacterType;
import org.learn.example.dI.rpg.weapons.*;

import java.util.Random;
import java.util.SortedMap;

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
