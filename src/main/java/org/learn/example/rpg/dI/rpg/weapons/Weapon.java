package org.learn.example.rpg.dI.rpg.weapons;

public interface Weapon {
    WeaponType getWeaponType();
    String useWeapon();
    int getDamage();
}
