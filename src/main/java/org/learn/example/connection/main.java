package org.learn.example.connection;

import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Person person = new Person("Ryu","Poolhopper", 40, 1.8, 140, 512);
        person.setDenominationPreference("dollars");
        person.printState();

        System.out.println(Arrays.toString(person.getPaid(111)));
        person.printWallet();
        System.out.println(person.getCash());
        System.out.println();
        System.out.println(Arrays.toString(person.spendMoney(123)));
        person.printWallet();
        System.out.println(person.getCash());
        System.out.println();
    }
}