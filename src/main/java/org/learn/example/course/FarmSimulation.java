package org.learn.example.course;


import org.learn.example.course.animal.Animal;
import org.learn.example.course.mammal.Mammal;

import java.util.ArrayList;
import java.util.List;

// 農場クラス
// 農場では牛・鶏・馬を飼うことができる
class Farm {
    private List<Cow> cow;
    private List<Horse> horse;
    private List<Chicken> chicken;

    public Farm() {
        this.cow = new ArrayList<>();
        this.horse = new ArrayList<>();
        this.chicken = new ArrayList<>();
    }

    // 農場に存在する動物
    public String toString() {
        return "cow: " + this.cow + " horse: " + this.horse + "chiken: " + this.chicken;
    }

    // 動物を飼う
    public void setKeep(Cow cow, Horse horse, Chicken chicken){
        if(cow != null) {
            this.cow.add(cow) ;
        } else if (horse != null) {
            this.horse.add(horse);
        } else {
            this.chicken.add(chicken);
        }
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
}

// 牛クラス
class Cow extends Mammal {
    public Cow(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex, double furLengthCm, String furType, double avgBodyTemperatureC) {
        super(species, heightM, weightKg, lifeSpanDays, biologicalSex, furLengthCm, furType, avgBodyTemperatureC);
    }
}

// 馬クラス
class Horse extends Mammal {
    protected double mileage;
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
    public Chicken(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex) {
        super(species, heightM, weightKg, lifeSpanDays, biologicalSex);
    }
}

// 農場シミュレーションの利益システム
class FarmProfitManager {

}

// 牛と鶏の肉の価格の重量は weightKg（体重）で判断
// 馬の価格は走行速度（mileage）で判断

// シミュレーションシステムからの入力値を表現
public class FarmSimulation {
    public static void main(String[] args) {
        // 人間が生まれる
        Person player1 = new Person("Homo sapiens", 1.75, 70.0, 29200, "Male", 1, "Short", 36.0);


    }
}
