package org.learn.example.rpg.dI.rpg.main;


import org.learn.example.rpg.dI.rpg.characters.Character;
import org.learn.example.rpg.dI.rpg.characters.CharacterType;
import org.learn.example.rpg.dI.rpg.services.CharacterService;
import org.learn.example.rpg.dI.rpg.services.WeaponService;

public class Main {
    public static  void main(String[] args) {
        WeaponService weaponService = new WeaponService();
        CharacterService characterService = new CharacterService(weaponService);

        // キャラクターを作成して注入
        Character warrior = characterService.createCharacter("Arthur", CharacterType.WARRIOR);
        Character mage = characterService.createCharacter("Merlin", CharacterType.MAGE);
        Character healer = characterService.createCharacter("Luna", CharacterType.HEALER);
        Character thief = characterService.createCharacter("Robin", CharacterType.THIEF);
        Character paladin = characterService.createCharacter("Gawain", CharacterType.PALADIN);

        Character goblin = characterService.createEnemy("Grunt", CharacterType.GOBLIN);

        // 戦闘シミュレーション
        System.out.println("-- " + warrior.getName() + " vs " + goblin.getName() + " --");
        warrior.attack(goblin);
        goblin.attack(warrior);

        System.out.println("-- " + mage.getName() + " vs " + goblin.getName() + " --");
        mage.attack(goblin);
        goblin.attack(mage);
    }
}
