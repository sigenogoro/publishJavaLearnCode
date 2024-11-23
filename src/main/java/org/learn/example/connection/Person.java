package org.learn.example.connection;

import java.util.EnumSet;

class Person{
    private String firstName;
    private String lastName;
    private int age;
    private double heightM;
    private double weightKg;
    private Wallet wallet;
    private String denomination = Denomination.highestFirst.toString();

    public Person(String firstName, String lastName, int age, double heightM, double weightKg, int initialMoney){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.heightM = heightM;
        this.weightKg = weightKg;
        if(initialMoney > 0){
            this.wallet = new Wallet(initialMoney, this.denomination);
        } else this.wallet = null;
    }

    enum Denomination {
        highestFirst,
        dollars,
        twenties
    }

    public void setDenominationPreference(String denomination) {
        if(EnumSet.allOf(Denomination.class).contains(Denomination.valueOf(denomination))) {
            this.denomination = denomination;
        } else {
            throw new IllegalArgumentException(denomination + "は存在しません");
        }
    }

    public int getCash(){
        if(this.wallet == null) return 0;
        return this.wallet.getTotalMoney();
    }

    public int[] spendMoney(int money) {
        if(this.wallet == null) return null;
        switch (this.denomination) {
            case ("highestFirst") -> {
                return this.wallet.removeHighestFirst(money);
            }
            case ("dollars") -> {
                return this.wallet.removeDollars(money);
            }
            case ("twenties") -> {
                return this.wallet.removeTwenties(money);
            }
            default -> {
                return null;
            }
        }
    }

    public int[] getPaid(int money) {
        if (this.wallet == null) return null;
        switch (this.denomination) {
            case ("highestFirst") -> {
                this.wallet.setHighestFirst(money);
                return this.wallet.getHighestFirst(money);
            }
            case ("dollars") -> {
                this.wallet.setDollars(money);
                return this.wallet.getDollars(money);
            }
            case ("twenties") -> {
                this.wallet.setTwenties(money);
                return this.wallet.getTwenties(money);
            }
            default -> {
                return null;
            }
        }
    }

    public void addWallet(Wallet wallet){
        this.wallet = wallet;
    }

    public Wallet dropWallet() {
        Wallet dropWallet = this.wallet;
        this.wallet = null;
        return dropWallet;
    }

    public void printState(){
        System.out.println("firstname - " + this.firstName);
        System.out.println("lastname - " + this.lastName);
        System.out.println("age - " + this.age);
        System.out.println("height - " + this.heightM);
        System.out.println("weight - " + this.weightKg);
        System.out.println("Current Money - " + this.getCash());
        System.out.println(this.denomination);
        System.out.println();
    }

    public void printWallet(){
        System.out.println("bill1 - " + this.wallet.getBills()[0]);
        System.out.println("bill5 - " + this.wallet.getBills()[1]);
        System.out.println("bill10 - " + this.wallet.getBills()[2]);
        System.out.println("bill20 - " + this.wallet.getBills()[3]);
        System.out.println("bill50 - " + this.wallet.getBills()[4]);
        System.out.println("bill100 - " + this.wallet.getBills()[5]);
    }
}

