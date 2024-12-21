package org.learn.example.course.farmSimulation.animal;

import org.learn.example.course.farmSimulation.bmi.BMI;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Animal{
    protected String species; // 種名
    protected BMI bmi; // BMIオブジェクト
    protected double lifeSpanDays; // 寿命（日数）
    protected String biologicalSex; // 性別
    protected Date spawnTime; // 誕生時間
    protected Date deathTime; // 死亡時間
    protected int hungerPercent = 100; // 空腹度
    protected int sleepPercent = 100; // 睡眠度

    public Animal(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex){
        this.species = species;
        this.bmi = new BMI(heightM, weightKg);
        this.lifeSpanDays = lifeSpanDays;
        this.biologicalSex = biologicalSex;
        this.spawnTime = new java.util.Date();
    }

    // 食事をするメソッド、食事をすると空腹度が0になります。
    public void eat(){
        if(!this.isAlive()) return;
        this.hungerPercent = 0;
    }

    // 空腹状態にするメソッド、空腹度を100にします。
    public void setAsHungry(){
        if(!this.isAlive()) return;
        this.hungerPercent = 100;
    }

    // 空腹かどうかを判定するメソッド、空腹度が70以上の場合に空腹と判断します。
    public boolean isHungry(){
        return this.hungerPercent >= 70;
    }

    // 睡眠をするメソッド、睡眠を取ると睡眠度が0になります。
    public void sleep(){
        if(!this.isAlive()) return;
        this.sleepPercent = 0;
    }

    // 睡眠不足の状態にするメソッド、睡眠度を100にします。
    public void setAsSleepy(){
        if(!this.isAlive()) return;
        this.sleepPercent = 100;
    }

    // 睡眠不足かどうかを判定するメソッド、睡眠度が70以上の場合に睡眠不足と判断します。
    public boolean isSleepy(){
        return this.sleepPercent >= 70;
    }

    // 動物を死亡させるメソッド、睡眠度と空腹度を0にし、死亡時間を現在の時刻に設定します。
    public void die(){
        this.sleepPercent = 0;
        this.hungerPercent = 0;
        this.deathTime = new java.util.Date();
    }

    // 動物が生きているかどうかを判定するメソッド、死亡時間がnullの場合に生きていると判断します。
    public boolean isAlive(){
        return this.deathTime == null;
    }

    // 動物が移動するメソッド、動物が死亡していない場合にメッセージを出力します。
    public void move(){
        if(!this.isAlive()) return;
        System.out.println("This animal just moved...");
    }

    // このクラスのインスタンスの情報を文字列として返すメソッド。
    public String toString(){
        return this.species + this.bmi + " lives " + this.lifeSpanDays + " days/" + "gender:" + this.biologicalSex + "." + this.status();
    }

    // 動物の状態を文字列として返すメソッド。
    public String status(){
        return this.species + " status:" + " Hunger - " + this.hungerPercent + "%, " + "sleepiness:"+this.sleepPercent + "%" + ", Alive - " + this.isAlive() + ". First created at " + this.dateCreated();
    }

    // 動物が誕生した時間を"月/日/年 時:分:秒"のフォーマットで返すメソッド
    public String dateCreated(){
        return new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(this.spawnTime);
    }
}

