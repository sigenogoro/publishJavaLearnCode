package org.learn.example.dI.rpg.weapons;

public class Hammer implements Weapon {

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.HAMMER;
    }

    @Override
    public String useWeapon() {
        return "ハンマーで叩きつけた！";
    }

    @Override
    public int getDamage() {
        return 20;
    }
}
