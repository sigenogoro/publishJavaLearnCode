package org.learn.example.rpg.inheritance;


// 登場するキャラクター基本クラス（親クラス）
class Character {
    // private にしてしまうと、Characterクラスでしか利用できない
    protected String name;
    protected int hp;

    public Character(String name, int hp){
        this.name = name;
        this.hp = hp;
    }
}
// 戦士クラス（サブクラス・子クラス）
// super()を利用することで Characterクラスコンストラクタを宣言
class Warrior extends Character {
    private int attackPower;

    Warrior(String name, int hp, int attackPower) {
        super(name, hp);
        this.attackPower = attackPower;
    }

    void attack() {
        System.out.println(this.name + "は剣で攻撃した！ ダメージ：" + attackPower);
    }
}

// 魔法使いクラス
class Mage extends Character {
    // アクセス範囲を定義しない場合、パッケージプライベートとなる
    // パッケージ外からアクセスすることができない
    int magicPower;

    Mage(String name, int hp, int magicPower) {
        super(name, hp);
        this.magicPower = magicPower;
    }

    void castSpell() {
        System.out.println(name + "は魔法を唱えた！ ダメージ：" + magicPower);
    }
}


public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("アーサー", 100, 15);
        Mage mage = new Mage("メルリン", 80, 20);

        warrior.attack();
        mage.castSpell();
    }
}
