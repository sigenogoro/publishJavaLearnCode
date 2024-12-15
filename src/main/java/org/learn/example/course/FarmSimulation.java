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
        List<Animal> animals = new ArrayList<>();
        animals.addAll(farm.chicken);
        animals.addAll(farm.cow);
        animals.addAll(farm.horse);
        for(Animal animal: animals) {
            System.out.println(animal.status());
        }

    }

    // 動物を飼う
    public void setKeep(Cow cow, Horse horse, Chicken chicken){
        if(cow == null && horse == null && chicken == null) {
            System.out.println("No animals provided to add to the farm.");
            return;
        }
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

    // 現在の利益を出力
    public int getProfit(){
        return this.profit;
    }
}

// 牛クラス
class Cow extends Mammal {
    private double milk;
    public Cow(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex, double furLengthCm, String furType, double avgBodyTemperatureC) {
        super(species, heightM, weightKg, lifeSpanDays, biologicalSex, furLengthCm, furType, avgBodyTemperatureC);
        if(mammaryGland) {
            this.milk = 0;
        }
    }

    // ミルク量を取得
    public double getMilk() {
        return this.milk;
    }

    // ミルクが出る
    public void setMilk(){
        produceMilk();
        this.milk = 1.5;
    }

    public BMI getBMI(){
        return this.bmi;
    }
}

// 馬クラス
class Horse extends Mammal {
    private double mileage = 0;
    public Horse(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex, double furLengthCm, String furType, double avgBodyTemperatureC, double mileage) {
        super(species, heightM, weightKg, lifeSpanDays, biologicalSex, furLengthCm, furType, avgBodyTemperatureC);
        this.mileage = mileage;
    }

    public double getMileage(){
        return mileage;
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
    private static final int PRICE_PER_KM = 5; //1キロメートルの価格

    // 鶏の重量での利益
    public static int chickenBMI(Chicken chicken){
        return (int) (chicken.getBMI().getWeightKg() * PRICE_PER_KG);
    }

    // 牛の重量での利益
    public static int cowBMI(Cow cow) {
        return (int) (cow.getBMI().getWeightKg() * PRICE_PER_KG);
    }

    // 牛のミルクでの利益
    public static int cowMilk(Cow cow) {
        return (int) (cow.getMilk() * PRICE_PER_KG);
    }

    // 卵の利益
    public static int chickenEgg(Chicken chicken) {
        return chicken.removeEgg() * PRICE_PER_EGG;
    }

    // 走行距離での利益
    public static int horseMileage(Horse horse){
        return (int) horse.getMileage() * PRICE_PER_KM;
    }
}

// 牛と鶏の肉の価格の重量は BMI（体重）で判断
// 馬の価格は走行速度（mileage）で判断

// シミュレーションシステムからの入力値を表現
public class FarmSimulation {
    public static void main(String[] args) {
        // 農場主の作成
        Person farmer = new Person("Homo sapiens", 1.75, 70, 30000, "male", 0, "none", 36.5);

        // 農場の初期化
        Cow cow = new Cow("Cow", 1.4, 500, 5000, "female", 0.2, "thick", 38.0);
        Chicken chicken = new Chicken("Chicken", 0.4, 3, 1500, "female");
        Horse horse = new Horse("Horse", 1.6, 450, 7000, "male", 0.1, "short", 37.8, 0);

        // 動物の飼育
        farmer.setKeep(cow, null, null);
        farmer.setKeep(null, horse, null);
        farmer.setKeep(null, null, chicken);

        // 動物の行動
        cow.eat();
        cow.setMilk();
        chicken.layEgg();
        horse.increaseBodyHeat(1.2);

        // 農場の状況を出力
        farmer.farmStatus();

        // 利益の計算
        int cowProfit = FarmProfitManager.cowMilk(cow) + FarmProfitManager.cowBMI(cow);
        int chickenProfit = FarmProfitManager.chickenBMI(chicken) + FarmProfitManager.chickenEgg(chicken);
        int horseProfit = FarmProfitManager.horseMileage(horse);

        // 合計利益を計算
        int totalProfit = cowProfit + chickenProfit + horseProfit;
        System.out.println("Total farm profit: " + totalProfit + " yen");

        // 農場主の利益に追加
        farmer.setProfit(totalProfit);
        System.out.println("Farmer's total profit: " + farmer.getProfit() + " yen");
    }
}
