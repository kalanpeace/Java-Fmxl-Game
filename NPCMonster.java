package com.example.finalproject;

public class NPCMonster {

    private int hitPoints;
    private int Strength;
    private int Dexterity;
    private int Intelligence;

    public NPCMonster(int hitPoints, int strength, int dexterity, int intelligence) {
        this.hitPoints = (int) (Math.random() * 6+1);
        Strength = this.hitPoints*2;
        Dexterity =  this.hitPoints*2;
        Intelligence =  this.hitPoints*2;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return Strength;
    }

    public int getDexterity() {
        return Dexterity;
    }

    public int getIntelligence() {
        return Intelligence;
    }


}
