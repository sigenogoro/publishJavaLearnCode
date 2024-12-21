package org.learn.example.course.farmSimulation.bmi;

// 人間や動物のBMI（Body Mass Index：肥満度を表す指数）を計算するクラス
public class BMI{
    private double heightM; // 身長
    private double weightKg; // 体重

    public BMI(double heightM, double weightKg){
        this.heightM = heightM;
        this.weightKg = weightKg;
    }

    public double getWeightKg(){
        return this.weightKg;
    }

    public double getValue(){
        return this.weightKg/(this.heightM*this.heightM);
    }

    public String toString(){
        return this.heightM + " meters, " + this.weightKg + "kg, BMI:" + this.getValue();
    }
}

