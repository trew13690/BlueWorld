package com.trewdev.blueworld.mechanics.characters;

/**
 * Created by trew1 on 5/18/2017.
 */
public abstract class Skills {

    String skillName;
    String skillDesc;
    int defaultSkillAllocation;
    int MaxSkillLevel;


    public Skills(){

    }
    public abstract void allocateSkillsPoints();
    public abstract void getDescription();
    public abstract void getSkillLevel();
    public abstract void getMaxLevel();



}
