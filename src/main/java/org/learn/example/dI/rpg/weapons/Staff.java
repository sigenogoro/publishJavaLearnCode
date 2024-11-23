package org.learn.example.dI.rpg.weapons;

public class Staff implements Weapon {

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.STAFF;
    }

    @Override
    public String useWeapon() {
        return "魔法を使った！";
    }

    @Override
    public int getDamage() {
        return 25;
    }
}
