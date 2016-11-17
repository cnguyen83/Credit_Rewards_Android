package com.example.christina.creditrewards;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Profile user = new Profile();

    Card amexBlueCash = new Card("American Express Blue Cash preferred", "Cash back: 6% on US supermarkets up to $6,000 a year, 3% on US gas stations and department stores, 1% everything else", "$150 after $1,000 spent in first 3 months; 5% cash back on up to $4,000 of travel purcahses in the first 6 months", "$95", "13.24% - 23.24%", "The greater of: $5 or 3% of transfer amount", "2.7% per transaction");

    Card amexSPG = new Card("American Express Starwood Preferred Guest", "5 Starpoints per dollar spent at SPG hotels, 1 Starpoint per dollar everything else", "2 free nights at an SPG hotel after $3,000 spent in first 3 months", "$95 (waived first year)", "15.49% - 19.49%", "The greater of: $5 or 3% of transfer amount", "None");

    Card bankAmericard = new Card("BankAmericard Travel Rewards", "Unlimited 1.5 points per dollar", "20,000 points after $1,000 spent in first 90 days", "None", "15.24% - 23.24%", "3% of transfer amount; minimum $10", "None");

    Card barclaycardRewards = new Card("Barclaycard Rewards MasterCard", "2 points per dollar on gas, utility, and grocery stores; 1 point per dollar everything else", "None", "None", "25.24%", "The greater of: $5 or 3% of transfer amount", "3% per transaction");

    Card capitalOneSecured = new Card("Capital One Secured MasterCard", "None", "None", "None, but $200 initial, refundable deposit", "24.99%", "None", "None");

    Card capitalOneQuicksilver = new Card("Capital One QuicksilverOne", "Unlimited 1.5% cash back", "Every 10th Uber ride is free up to $15", "$39", "23.24%", "None", "None");

    Card chaseFreedom = new Card("Chase Freedom", "Cash back: 5% on up to $1,500 in combined purchases in quarterly bonus categories, 1% everything else", "$150 after $500 spent in first 3 months", "None", "14.24% - 23.24%", "The greater of: $5 or 5% of transfer amount", "3% per transaction");

    Card chaseSapphire = new Card("Chase Sapphire Preferred", "2 points per dollar on travel and dining, 1 point per dollar everything else", "50,000 points after $4,000 spent in first 3 months", "$95 (waived first year)", "16.24% - 23.24%", "The greater of: $5 or 5% of transfer amount", "None");

    Card discoverIT = new Card("Discover it", "Cash back: 5% on up to $1,500 in combined purchases in quarterly bonus cateogires, 1% everything else", "Cash back match 100% of first year rewards", "None", "11.24% - 23.24%", "3% of transfer amount", "None");

    Card citiDouble = new Card("Citi Double Cash", "Cash back: 1% on purchases and 1% when balance is paid", "None", "None", "13.24% - 23.24%", "The greater of: $5 or 3% of transfer amount", "3% per transaction");

    private void changeDisplay(Card display) {
        TextView card = (TextView) findViewById(R.id.cardName);
        TextView rewards = (TextView) findViewById(R.id.rewardsDisplay);
        TextView bonus = (TextView) findViewById(R.id.bonusDisplay);
        TextView annFee = (TextView) findViewById(R.id.afDisplay);
        TextView apr = (TextView) findViewById(R.id.aprDisplay);
        TextView btFee = (TextView) findViewById(R.id.btfeeDisplay);
        TextView ftFee = (TextView) findViewById(R.id.forexDisplay);

        card.setText(display.getName());
        rewards.setText(display.getRewards());
        bonus.setText(display.getBonus());
        annFee.setText(display.getAf());
        apr.setText(display.getApr());
        btFee.setText(display.getBtfee());
        ftFee.setText(display.getForex());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ImageView image = (ImageView) findViewById(R.id.cardImage);

        Intent intent = getIntent();
        user.setScore(intent.getIntExtra("score", -1));
        user.setNumCards(intent.getIntExtra("numCards", -1));
        user.setNaf(intent.getBooleanExtra("naf", true));
        user.setApr(intent.getIntExtra("apr", 30));
        user.setFtf(intent.getBooleanExtra("ftf", false));
        user.setRewards(intent.getStringExtra("rewards"));

        if (user.getScore() > 0) {
            if (user.getScore() < 650) {
                changeDisplay(capitalOneSecured);
                image.setImageResource(R.drawable.capitalone_secured);
            } else if (user.getScore() < 700) {
                changeDisplay(barclaycardRewards);
                image.setImageResource(R.drawable.barclaycard);
            } else if (user.getNaf()) {
                if (user.getRewards().equals("Cash Back")) {
                    changeDisplay(citiDouble);
                    image.setImageResource(R.drawable.citi_double_cashback);
                } else if (user.getRewards().equals("Everyday Use")) {
                    if ((user.getFtf()) || (user.getApr() < 15)) {
                        changeDisplay(discoverIT);
                        image.setImageResource(R.drawable.discover_it);
                    } else {
                        changeDisplay(chaseFreedom);
                        image.setImageResource(R.drawable.freedom);
                    }
                } else if (user.getRewards().equals("Starter / Secured")) {
                    if ((user.getApr() < 21) && !user.getFtf()) {
                        changeDisplay(chaseFreedom);
                        image.setImageResource(R.drawable.freedom);
                    } else {
                        changeDisplay(barclaycardRewards);
                        image.setImageResource(R.drawable.barclaycard);
                    }
                } else {
                    changeDisplay(bankAmericard);
                    image.setImageResource(R.drawable.bankamericard);
                }
            } else {
                if (user.getRewards().equals("Cash Back")) {
                    if (user.getApr() < 21) {
                        changeDisplay(citiDouble);
                        image.setImageResource(R.drawable.citi_double_cashback);
                    } else {
                        changeDisplay(capitalOneQuicksilver);
                        image.setImageResource(R.drawable.capitalone_quicksilver);
                    }
                } else if (user.getRewards().equals("Everyday Use")) {
                    changeDisplay(amexBlueCash);
                    image.setImageResource(R.drawable.bluecash);
                } else if (user.getRewards().equals("Starter / Secured")) {
                    if ((user.getApr() < 21) && user.getFtf()) {
                        changeDisplay(discoverIT);
                        image.setImageResource(R.drawable.discover_it);
                    } else if (user.getApr() < 21) {
                        changeDisplay(chaseFreedom);
                        image.setImageResource(R.drawable.freedom);
                    } else {
                        changeDisplay(capitalOneSecured);
                        image.setImageResource(R.drawable.capitalone_secured);
                    }
                } else {
                    if (user.getFtf()) {
                        changeDisplay(amexSPG);
                        image.setImageResource(R.drawable.spg);
                    } else {
                        changeDisplay(chaseSapphire);
                        image.setImageResource(R.drawable.csp);
                    }
                }
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int target = item.getItemId();
        if (target == R.id.profile) {
            startActivity(new Intent(this, UserInfoActivity.class));
        }
        return true;
    }

}
