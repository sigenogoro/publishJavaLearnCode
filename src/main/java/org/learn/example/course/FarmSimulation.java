package org.learn.example.course;


import org.learn.example.course.animal.Animal;
import org.learn.example.course.bmi.BMI;
import org.learn.example.course.mammal.Mammal;

import java.util.ArrayList;
import java.util.List;

// 農場クラス
// 農場では牛・鶏・馬を飼うことができる
class Farm {
    protected List<Cow> cow;
    protected List<Horse> horse;
    protected List<Chicken> chicken;

    public Farm() {
        this.cow = new ArrayList<>();
        this.horse = new ArrayList<>();
        this.chicken = new ArrayList<>();
    }

    public int getTotal(){
        return this.cow.size() + this.horse.size() + this.chicken.size();
    }
}

// 人間
class Person extends Mammal {
    private int profit; // 利益金
    private Farm farm; // 農場
    public Person(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex, double furLengthCm, String furType, double avgBodyTemperatureC) {
        super(species, heightM, weightKg, lifeSpanDays, biologicalSex, furLengthCm, furType, avgBodyTemperatureC);
        // 人間がいない == 農場がなくなる→コンポジットとする
        this.farm = new Farm();
        this.profit = 0;
    }

    public void farmStatus() {
        for (Chicken chicken: farm.chicken){
            System.out.println(chicken.status());
        }
        for (Horse horse: farm.horse){
            System.out.println(horse.status());
        }
        for (Cow cow: farm.cow){
            System.out.println(cow.status());
        }
    }

    // 動物を飼う
    public void setKeep(Cow cow, Horse horse, Chicken chicken){
        if(cow != null) {
            farm.cow.add(cow) ;
        } else if (horse != null) {
            farm.horse.add(horse);
        } else {
            farm.chicken.add(chicken);
        }
    }

    // 利益を蓄える
    public void setProfit(int money){
        this.profit += money;
    }
}

// 牛クラス
class Cow extends Mammal {
    public Cow(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex, double furLengthCm, String furType, double avgBodyTemperatureC) {
        super(species, heightM, weightKg, lifeSpanDays, biologicalSex, furLengthCm, furType, avgBodyTemperatureC);
    }
}

// 馬クラス
class Horse extends Mammal {
    private double mileage;
    public Horse(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex, double furLengthCm, String furType, double avgBodyTemperatureC, double mileage) {
        super(species, heightM, weightKg, lifeSpanDays, biologicalSex, furLengthCm, furType, avgBodyTemperatureC);
        this.mileage = mileage;
    }
}

// 鳥クラス
class Bird extends Animal {
    public Bird(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex) {
        super(species, heightM, weightKg, lifeSpanDays, biologicalSex);
    }
}

// オウム鳥クラス
class Parrot extends Bird {
    public Parrot(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex) {
        super(species, heightM, weightKg, lifeSpanDays, biologicalSex);
    }
}

// 鶏クラス
class Chicken extends Bird {
    private int eggCount = 0;
    private Boolean canLayEggs; // 卵を産むことができるのか？
    public Chicken(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex) {
        super(species, heightM, weightKg, lifeSpanDays, biologicalSex);
        this.canLayEggs = "Female".equalsIgnoreCase(biologicalSex);
    }

    public void layEgg() {
        if (!this.isAlive()) {
            return;
        }

        if (!canLayEggs) {
            return;
        }

        System.out.println(this.species + " laid an egg! Total eggs: " + this.eggCount);
        this.eggCount++;
    }

    public BMI getBMI(){
        return this.bmi;
    }

    // 卵を取り出す
    public int removeEgg() {
        int eggCount = this.eggCount;
        this.eggCount = 0;
        return eggCount;
    }

    public int getEggCount(int eggCount) {
        return this.eggCount;
    }

    public String status() {
        return this.species + " status:" + " Hunger - " + this.hungerPercent + "%, " + "sleepiness:"+this.sleepPercent + "%" + ", Alive - " + this.isAlive() + ". First created at " + this.dateCreated() + ", eggCount - " + this.eggCount;
    }
}

// 農場シミュレーションの利益システム
class FarmProfitManager {
    private static final int PRICE_PER_KG = 1000; // 1kgあたりの価格
    private static final int PRICE_PER_EGG = 30; // 1個あたりの価格

    // 鶏の重量での利益
    public int chickenProfit(Chicken chicken){
        return (int) (chicken.getBMI().getWeightKg() * PRICE_PER_KG);
    }

    // 卵の利益
    public int chickenEggProfit(Chicken chicken) {
        return chicken.removeEgg() * PRICE_PER_EGG;
    }
}

// 牛と鶏の肉の価格の重量は BMI（体重）で判断
// 馬の価格は走行速度（mileage）で判断

// シミュレーションシステムからの入力値を表現
public class FarmSimulation {
    public static void main(String[] args) {
        // 人間が生まれる
        Person farmer = new Person("Homo sapiens", 1.75, 70.0, 29200, "Male", 1, "Short", 36.0);


        Cow cow1 = new Cow("Cow", 1.5, 600.0, 5475, "Female", 2.0, "Thick", 38.0);
        Cow cow2 = new Cow("Cow", 1.4, 550.0, 5475, "Male", 2.0, "Thick", 38.0);
        Horse horse1 = new Horse("Horse", 1.8, 700.0, 9125, "Female", 1.5, "Smooth", 37.5, 50.0);
        Chicken chicken1 = new Chicken("Chicken1", 0.5, 2.0, 1825, "Female");
        Chicken chicken2 = new Chicken("Chicken2", 0.5, 2.5, 1825, "Male");

        // 動物を農場に追加
        farmer.setKeep(cow1, null, null);
        farmer.setKeep(cow2, null, null);
        farmer.setKeep(null, horse1, null);
        farmer.setKeep(null, null, chicken1);
        farmer.setKeep(null, null, chicken2);

        // 農場の状態を出力
        System.out.println("Initial farm state:");
        farmer.farmStatus();

        // 動物のアクション
        System.out.println("\nCow1 eats:");
        cow1.eat();
        System.out.println(cow1.status());

        System.out.println("\nHorse1 sweats:");
        horse1.sweat();

        System.out.println("\nChicken1 moves:");
        chicken1.move();

        System.out.println("\nFarmer adjusts body heat for Cow1:");
        cow1.adjustBodyHeat();
        System.out.println(cow1.status());

        // 最終状態を表示
        System.out.println("\nFinal farm state:");
        farmer.farmStatus();

        chicken1.layEgg();
        System.out.println("\nChiken:");
        System.out.println(chicken1.status());
    }
}
