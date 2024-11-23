package org.learn.example.dI.rpg.weapons;

public class Axe implements Weapon {

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.AXE;
    }

    @Override
    public String useWeapon() {
        return "斧で切り付けた！";
    }

    @Override
    public int getDamage() {
        return 15;
    }
}
