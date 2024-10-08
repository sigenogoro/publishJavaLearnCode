package org.learn.example.dI.rpg.weapons;

public class Bow implements Weapon {

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.BOW;
    }

    @Override
    public String useWeapon() {
        return "弓で射抜いた！";
    }

    @Override
    public int getDamage() {
        return 15;
    }
}
