package org.learn.example.rpg.dI.rpg.weapons;

public class Sword implements Weapon {
    @Override
    public WeaponType getWeaponType() {
        return WeaponType.SWORD;
    }

    @Override
    public String useWeapon() {
        return "剣で切り付けた！";
    }

    @Override
    public int getDamage() {
        return 20;
    }
}
