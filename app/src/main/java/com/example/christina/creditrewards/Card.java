package com.example.christina.creditrewards;

/**
 * Created by Christina on 11/7/16.
 */

public class Card {
    private String name, rewards, bonus, af, apr, btfee, forex;

    public Card(String initName, String initRewards, String initBonus, String initAF, String initAPR, String initBTfee, String initForex) {
        name = initName ;
        rewards = initRewards;
        bonus = initBonus;
        af = initAF;
        apr = initAPR;
        btfee = initBTfee;
        forex = initForex;
    }

    //Getter methods
    public String getAf() {
        return af;
    }
    public String getApr() {
        return apr;
    }
    public String getBonus() {
        return bonus;
    }
    public String getBtfee() {
        return btfee;
    }
    public String getForex() {
        return forex;
    }
    public String getName() {
        return name;
    }
    public String getRewards() {
        return rewards;
    }

    //Setter methods
    public void setAf(String af) {
        this.af = af;
    }
    public void setApr(String apr) {
        this.apr = apr;
    }
    public void setBonus(String bonus) {
        this.bonus = bonus;
    }
    public void setBtfee(String btfee) {
        this.btfee = btfee;
    }
    public void setForex(String forex) { this.forex = forex; }
    public void setName(String name) {
        this.name = name;
    }
    public void setRewards(String rewards) {
        this.rewards = rewards;
    }
}
