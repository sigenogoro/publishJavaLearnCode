package org.learn.example.connection;

public class Wallet {
    private int bill1;
    private int bill5;
    private int bill10;
    private int bill20;
    private int bill50;
    private int bill100;
    private static final int[] number = new int[]{1, 5, 10, 20, 50, 100};
    private final int[] bills = new int[]{bill1, bill5, bill10, bill20, bill50, bill100};

    public Wallet(int initialMoney, String denomination){
        setHighestFirst(initialMoney);
    }

    public int[] getBills(){
        return new int[]{bill1, bill5, bill10, bill20, bill50, bill100};
    }

    public int[] getHighestFirst(int money){
        int[] highesFirstList = new int[number.length];
        for(int i = number.length - 1; i >= 0; i--){
            int billNum = money / number[i];
            money -= number[i] * billNum;
            highesFirstList[i] = billNum;
        }
        return highesFirstList;
    }

    public void setHighestFirst(int money) {
        for(int i = number.length - 1; i >= 0; i--){
            money -= insertBill(number[i], money / number[i]);
        }
    }

    public int[] removeHighestFirst(int money) {
        int[] removeHighesFirstList = new int[number.length];
        for(int i = number.length - 1; i >= 0; i--){
            if(bills[i] < money / number[i]) {
                System.out.println("特定の紙幣が足らないため削除できませんでした");
                return new int[number.length];
            }
            int billNum = money / number[i];
            money -= removeBill(number[i], billNum);
            removeHighesFirstList[i] = billNum;
        }
        return removeHighesFirstList;
    }


    public int[] getDollars(int money) {
        int[] dollarsList = new int[number.length];
        dollarsList[0] = money / number[0];
        return dollarsList;
    }

    public void setDollars(int money) {
        insertBill(number[0], money);
    }

    public int[] removeDollars(int money){
        int[] removeDollarsList = new int[number.length];
        if(this.bill1 < number[0] * money) {
            System.out.println("特定の紙幣が足らないため削除できませんでした");
            return removeDollarsList;
        }
        removeBill(number[0], money);
        return removeDollarsList;
    }

    public int[] getTwenties(int money) {
        int billNum = money / number[3];
        money -= number[3] * billNum;
        int[] result = getHighestFirst(money);
        result[3] += billNum;
        return result;
    }

    public void setTwenties(int money){
        money -= insertBill(number[3], money);
        setHighestFirst(money);
    }

    public int[] removeTwenties(int money) {
        int billNum = money / number[3];
        if(bill20 <= billNum){
            System.out.println("特定の紙幣が足らないため削除できませんでした");
            return new int[number.length];
        }
        money -= number[3] * billNum;
        int[] removeResult = removeHighestFirst(money);
        removeResult[3] += billNum;
        return removeResult;
    }

    public int getTotalMoney(){
        return (1*bill1) + (5*bill5) + (10*bill10) + (20*bill20) + (50*bill50) + (100*bill100);
    }

    public int removeBill(int bill, int amount) {
        switch(bill){
            case(1):
                bill1 -= amount;
                break;
            case(5):
                bill5 -= amount;
                break;
            case(10):
                bill10 -= amount;
                break;
            case(20):
                bill20 -= amount;
                break;
            case(50):
                bill50 -= amount;
                break;
            case(100):
                bill100 -= amount;
                break;
            default:
                return 0;
        }
        return bill*amount;
    }
    public int insertBill(int bill, int amount){
        switch(bill){
            case(1):
                bill1 += amount;
                break;
            case(5):
                bill5 += amount;
                break;
            case(10):
                bill10 += amount;
                break;
            case(20):
                bill20 += amount;
                break;
            case(50):
                bill50 += amount;
                break;
            case(100):
                bill100 += amount;
                break;
            default:
                return 0;
        }
        return bill*amount;
    }
}

