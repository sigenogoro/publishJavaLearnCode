package org.learn.example.rpg.dI.rpg.weapons;

public class Dagger implements Weapon {

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.DAGGER;
    }

    @Override
    public String useWeapon() {
        return "短剣で切り付けた！";
    }

    @Override
    public int getDamage() {
        return 15;
    }
}
