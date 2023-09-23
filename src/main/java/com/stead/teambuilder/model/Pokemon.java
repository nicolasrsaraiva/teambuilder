package com.stead.teambuilder.model;

import java.util.Random;

public class Pokemon {
    private String name;
    private double height;
    private double weight;
    private Type mainType;
    private Type secondType;
    private int spd;
    private int atk;
    private int atkM;
    private int def;
    private int defM;
    private int hp;

    public Pokemon(){
        super();
    }

    public Pokemon(String name, double height, double weight, Type mainType, Type secondType) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.mainType = mainType;
        this.secondType = secondType;
        insertEVs();
    }

    public Pokemon(String name, double height, double weight, Type mainType) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.mainType = mainType;
        this.secondType = mainType;
        insertEVs();
    }

    private void insertEVs(){
        Random random = new Random();
        this.spd = random.nextInt(32);
        this.atk = random.nextInt(32);
        this.atkM = random.nextInt(32);
        this.def = random.nextInt(32);
        this.defM = random.nextInt(32);
        this.hp = random.nextInt(32);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Type getMainType() {
        return mainType;
    }

    public void setMainType(Type mainType) {
        this.mainType = mainType;
    }

    public Type getSecondType() {
        return secondType;
    }

    public void setSecondType(Type secondType) {
        this.secondType = secondType;
    }

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getAtkM() {
        return atkM;
    }

    public void setAtkM(int atkM) {
        this.atkM = atkM;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getDefM() {
        return defM;
    }

    public void setDefM(int defM) {
        this.defM = defM;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
