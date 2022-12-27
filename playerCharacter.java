package com.example.finalproject;


    public class playerCharacter {
        private int hitPoints ;
        private int strength;
        private int dexterity;
        private int intelligence;
        private int totalGold;

        public playerCharacter(int hitPoints, int strength, int dexterity, int intelligence, int totalGold) {
            this.hitPoints = 20;
            this.strength = (int)(Math.random() * 6+1) + (int)(Math.random() * 6+1) + (int)(Math.random() * 6+1);;
            this.dexterity = (int)(Math.random() * 6+1) + (int)(Math.random() * 6+1) + (int)(Math.random() * 6+1);;
            this.intelligence = (int)(Math.random() * 6+1) + (int)(Math.random() * 6+1) + (int)(Math.random() * 6+1);;
            this.totalGold = totalGold;
        }

        public int getHitPoints() {
            return hitPoints;
        }

        public int getStrength() {
            return strength;
        }

        public int getDexterity() {
            return dexterity;
        }

        public int getIntelligence() {
            return intelligence;
        }

        public int getTotalGold() {
            return totalGold;
        }

        public void setTotalGold(int totalGold) {
            this.totalGold = totalGold;
        }

        public void setHitPoints(int hitPoints){
            this.hitPoints = hitPoints;
        }
    }


