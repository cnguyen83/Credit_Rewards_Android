package com.example.christina.creditrewards;

/**
 * Created by Christina on 11/10/16.
 */

public class Profile {
    private int score, numCards, apr;
    private boolean ftf, naf;
    private String rewards;

    public int getApr() {
        return apr;
    }

    public int getNumCards() {
        return numCards;
    }

    public int getScore() {
        return score;
    }

    public String getRewards() {
        return rewards;
    }

    public boolean getFtf() {
        return ftf;
    }

    public boolean isFtf() {
        return ftf;
    }

    public boolean getNaf() {
        return naf;
    }

    public boolean isNaf() {
        return naf;
    }

    public void setApr(int apr) {
        this.apr = apr;
    }

    public void setNumCards(int numCards) {
        this.numCards = numCards;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setRewards(String rewards) {
        this.rewards = rewards;
    }

    public void setFtf(boolean ftf) {
        this.ftf = ftf;
    }

    public void setNaf(boolean naf) {
        this.naf = naf;
    }
}
