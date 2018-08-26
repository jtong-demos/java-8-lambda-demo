package com.thoughtworks.java8.lambda.jtong;

public class Player {

    private final String name;

    public Player(String name, int hp, int ap) {

        this.name = name;
        this.hp = hp;
        this.ap = ap;
    }

    private int hp;
    private int ap;

    public int getHp() {
        return hp;
    }

    public int getAp() {
        return ap;
    }

    public String getName() {
        return name;
    }
}
