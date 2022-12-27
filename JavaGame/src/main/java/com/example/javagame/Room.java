package com.example.javagame;

public class Room {
    private boolean NPC;
    private boolean blocked;
    private int gold;


    public Room( boolean NPCMonster, boolean blocked, int gold) {
        this.NPC = Math.random() < 0.5;
        this.blocked = Math.random() < 0.5;
        this.gold = (int)(Math.random() * 10);
    }

    public boolean isNPC() {
        return NPC;
    }

    public void setNPC(boolean NPC) {
        this.NPC = NPC;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}