package com.example.andres.dungeonmasterstoolbox;

public class Encounter {

    public String Name;
    public int CR;
    public int EXP;

    public Encounter(String name, int cr, int exp){
        Name = name;
        CR = cr;
        EXP = exp;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getCR() {
        return CR;
    }

    public void setCR(int CR) {
        this.CR = CR;
    }

    public int getEXP() {
        return EXP;
    }

    public void setEXP(int EXP) {
        this.EXP = EXP;
    }
}
