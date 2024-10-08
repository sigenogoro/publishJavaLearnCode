package org.learn.example.dI.rpg.weapons;

public interface Weapon {
    WeaponType getWeaponType();
    String useWeapon();
    int getDamage();
}
