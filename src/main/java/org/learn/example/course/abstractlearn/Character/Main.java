package org.learn.example.course.abstractlearn.Character;

//// キャラクターの共通クラス
//// キャラクタークラス
//// 名前（name）、HP（health）、MP（mana）を持つ
//// 「攻撃する（attack）」や「防御する（defend）」といったアクションを持つ
//class Character {
//    protected String name;
//    protected int health;
//    protected int mana;
//
//    public Character(String name, int health, int mana) {
//        this.name = name;
//        this.health = health;
//        this.mana = mana;
//    }
//
//    public void attack() {
//        System.out.println(name + " swings a sword!");
//    }
//}
//
//
//// 戦士クラス
//class Warrior extends Character {
//    public Warrior(String name, int health, int mana) {
//        super(name, health, mana);
//    }
//
//    public void attack() {
//        super.attack();
//    }
//}
//
//// 魔法使いクラス
//class Mage extends Character {
//    public Mage(String name, int health, int mana) {
//        super(name, health, mana);
//    }
//
//    public void attack() {
//        System.out.println(name + " casts a fireball!");
//    }
//}
//----------↑ 抽象クラスではなく、クラスでの継承を利用して

abstract class Character {
    protected String name;
    protected int health;
    protected int mana;

    public Character(String name, int health, int mana) {
        this.name = name;
        this.health = health;
        this.mana = mana;
    }

    // 抽象メソッド: 子クラスに具体的な攻撃方法を委ねる
    public abstract void attack();
}

// 戦士クラス
class Warrior extends Character {
    public Warrior(String name, int health, int mana) {
        super(name, health, mana);
    }

    @Override
    public void attack() {
        System.out.println(name + " swings a sword!");
    }
}

// 魔法使いクラス
class Mage extends Character {
    public Mage(String name, int health, int mana) {
        super(name, health, mana);
    }

    @Override
    public void attack() {
        System.out.println(name + " casts a fireball!");
    }
}

// 新しいキャラクタータイプ（例: 弓使い）
class Archer extends Character {
    public Archer(String name, int health, int mana) {
        super(name, health, mana);
    }

    @Override
    public void attack() {
        System.out.println(name + " casts a casts a bow and arrow!");
    }
}

//- キャラクターの特徴:
//    - すべてのキャラクターは、名前（name）、HP（health）、MP（mana）を持つ
//    - キャラクターは「攻撃する（attack）」や「防御する（defend）」といったアクションを取る
//    - しかし、キャラクターごとに攻撃方法が異なる（例: 戦士は剣で攻撃、魔法使いは呪文を使う）
//    - 一部のキャラクターは特有の行動（例: 回復魔法を使う）が可能
//- 敵の特徴:
//    - 敵もキャラクターとして扱うが、プレイヤーキャラクター（PC）とは行動のパターンが異なる
//- 共通ルール:
//    - すべてのキャラクターには、基本的な能力や行動が共通しているが、詳細な行動はキャラクターによって異なる
class Main3 {
    public static void main(String[] args) {
        Character warrior = new Warrior("Warrior", 100, 50);
        Character archer = new Archer("archer", 30, 200);

        warrior.attack();
        archer.attack();
    }
}
