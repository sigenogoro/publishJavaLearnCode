package org.learn.example.dI.rpg.weapons;

public class Club implements Weapon {

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.CLUB;
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
