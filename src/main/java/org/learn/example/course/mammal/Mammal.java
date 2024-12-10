package org.learn.example.course.mammal;

import org.learn.example.course.animal.Animal;

public class Mammal extends Animal {
    private double furLengthCm; // 毛の長さ
    private String furType; // 毛のタイプ:
    private int toothCounter; // 歯の数
    private double bodyTemperatureC; // 体温
    private double avgBodyTemperatureC; // 平均体温
    private boolean mammaryGland = false; // 乳腺の有無
    private boolean sweatGland = true; //汗腺の有無
    private boolean isPregnant = false; //妊娠の有無

    public Mammal(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex, double furLengthCm, String furType, double avgBodyTemperatureC){
        super(species, heightM, weightKg, lifeSpanDays, biologicalSex);
        this.furLengthCm = furLengthCm;
        this.furType = furType;
        // 全てのメスの哺乳類は乳腺があります。
        this.mammaryGland = (biologicalSex == "female");
        this.avgBodyTemperatureC = avgBodyTemperatureC;
        // 初期体温を平均体温Cに設定します。
        this.bodyTemperatureC = this.avgBodyTemperatureC;
    }


    // 汗をかく
    public void sweat(){
        if(!this.isAlive()) return;
        if(this.sweatGland) System.out.print("Sweating....");
        // 体温の低下
        this.bodyTemperatureC -= 0.3;
        System.out.print("Body temperature is now " + this.bodyTemperatureC + "C");
        System.out.println();
    }

    // 母乳を出す
    public void produceMilk(){
        if(!this.isAlive()) return;
        if(this.isPregnant() && this.mammaryGland) System.out.println("Producing milk...");
        else System.out.println("Cannot produce milk");
        System.out.println();
    }

    // 交尾をする
    // 哺乳類は同種の他の哺乳類と交尾します。その際に、動物が雄でパートナーが雌の場合、パートナーは受精します。
    public void mate(Mammal mammal){
        if(!this.isAlive()) return;
        if(this.species != mammal.species) return;
        if(this.biologicalSex == "female" && mammal.biologicalSex == "male") this.fertalize();
        else if(this.biologicalSex == "male" && mammal.biologicalSex == "female") mammal.fertalize();
    }

    // 受精する
    public void fertalize(){
        if(!this.isAlive()) return;
        this.isPregnant = true;
    }

    // 妊娠しているかどうか
    public boolean isPregnant(){
        if(!this.isAlive()) return false;
        return this.isPregnant;
    }

    // 噛む
    public void bite(){
        if(!this.isAlive()) return;
        System.out.println(this.species + " bites with their single lower jaws which has" +  (this.toothCounter == 0 ? " not" : "")  + " replaced its teeth: " + (this.toothCounter > 0));
        System.out.println();
    }

    // 歯が生え変わる
    // 哺乳類は一生のうちに一度しか歯を入れ替えることがないという一般的な特性を表現するreplaceTeeth()メソッドも定義
    public void replaceTeeth(){
        if(!this.isAlive()) return;
        if(this.toothCounter == 0) this.toothCounter++;
    }

    // 体温の上昇
    public void increaseBodyHeat(double celcius){
        this.bodyTemperatureC+=celcius;
    }

    // 体温の低下
    public void decreaseBodyHeat(double celcius){
        this.bodyTemperatureC-=celcius;
    }

    // 動物の体温を適切な体温に設定します。
    public void adjustBodyHeat(){
        this.bodyTemperatureC = this.avgBodyTemperatureC;
    }
}

