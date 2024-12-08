package org.learn.example.rpg.connection.dependency.DI;

class Weapon {
    private String name;
    private int damage;

    // コンストラクタ
    public Weapon(String name, int damage){
        this.name = name;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }
}


class Character {
    private String name;
    private int health;
    // Characterクラスが Weaponクラスへの依存は依然として残る
    private Weapon weapon;

    // 武器生成する WeaponProviderの生成は Mainクラスで行ってもらう
    // コンストラクトインジェクションを利用
    //
    public Character(String name, int health, Weapon weapon){
        this.name = name;
        this.health = health;
        this.weapon = weapon;
    }

    // 武器を装備する
    public void equipWeapon(Weapon weapon){
        this.weapon = weapon;
        System.out.println(name + "は" + weapon.getName() + "を装備した！");
    }

    public void attack(Character target){
        if (weapon == null){
            System.out.println(name + "は武器を持っていないので攻撃できない！");
            return;
        }
        System.out.println(name + "は" + target.name + "を攻撃！");
        target.takeDamage(weapon.getDamage());
    }

    public void takeDamage(int damage){
        health -= damage;
        System.out.println(name + "は" + damage + "のダメージを受けた！ 残りHP: " + health);
        if (health <= 0) {
            System.out.println(name + "は倒れた...");
        }
    }
}

// 武器生成を行うクラス
class WeaponProvider {
    public Weapon getWeapon(WeaponType type) {
        return switch (type) {
            case SWORD -> new Weapon("剣", 20);
            case BOW -> new Weapon("弓", 15);
            default -> new Weapon("素手", 5);
        };
    }
}

enum WeaponType {
    SWORD,
    BOW,
    HAND
}


class Main {
    public static void main(String[] args) {
        WeaponProvider provider = new WeaponProvider();
        // キャラクター作成・デフォルトの武器は全員「素手」
        Character hero = new Character("勇者", 100, provider.getWeapon(WeaponType.SWORD));
        Character monster = new Character("モンスター", 80, provider.getWeapon(WeaponType.BOW));
    }
}