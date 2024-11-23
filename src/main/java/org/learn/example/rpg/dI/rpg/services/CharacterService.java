package org.learn.example.rpg.dI.rpg.services;

import org.learn.example.rpg.dI.rpg.characters.Character;
import org.learn.example.rpg.dI.rpg.characters.CharacterType;
import org.learn.example.rpg.dI.rpg.characters.enemies.Goblin;
import org.learn.example.rpg.dI.rpg.characters.supporter.*;
import org.learn.example.rpg.dI.rpg.weapons.Weapon;


public class CharacterService {

    private final WeaponService weaponService;

    /**
     * ここでWeaponService を外部から入れている
     * AdvancedWeaponService など、仕様変更で別クラスを使いたい場合
     *   現状は、型まで変更しないといけない
     *   interface や継承を行うことで型変更しないでインジェクションすることが可能
     */
    public CharacterService(WeaponService weaponService){
        this.weaponService = weaponService;
    }

    public Character createCharacter(String name, CharacterType characterType) {
        Weapon weapon = weaponService.getWeapon(characterType);
        return switch (characterType) {
            case WARRIOR -> new Warrior(name, weapon);
            case MAGE -> new Mage(name, weapon);
            case HEALER -> new Healer(name, weapon);
            case THIEF -> new Thief(name, weapon);
            case PALADIN -> new Paladin(name, weapon);
            default -> throw new IllegalArgumentException("未知のキャラクタータイプです。");
        };
    }

    public Character createEnemy(String name, CharacterType enemyType) {
        Weapon weapon = weaponService.getWeapon(enemyType);
        if (enemyType == CharacterType.GOBLIN) {
            return new Goblin(name, weapon);
            // ORCやTROLLに適した武器を追加可能
        }
        throw new IllegalArgumentException("未知の敵キャラクタータイプです。");
    }

}
