package com.example.christina.creditrewards;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ToggleButton;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
    }

    Profile user = new Profile();

    public int maxApr(String apr) {
        if (apr.equals("< 14%")) {
            return 14;
        } else if (apr.equals("< 20%")) {
            return 20;
        } else if (apr.equals("<24%")) {
            return 24;
        } else {
            return 100;
        }
    }

    public void findCard(View view) {
        EditText score = (EditText) findViewById(R.id.csF);
        EditText numCards = (EditText) findViewById(R.id.numCardsF);
        Spinner apr = (Spinner) findViewById(R.id.aprF);
        String aprVal = apr.getSelectedItem().toString();
        ToggleButton ftf = (ToggleButton) findViewById(R.id.ftfToggle);
        ToggleButton naf = (ToggleButton) findViewById(R.id.afToggle);
        Spinner rewards = (Spinner) findViewById(R.id.rewardsCategory);

        String scoreStr = score.getText().toString();
        String numStr = numCards.getText().toString();

        if (scoreStr.equals("")) {
            user.setScore(500);
        } else {
            user.setScore(Integer.parseInt(score.getText().toString()));
        }

        if (numStr.equals("")) {
            user.setNumCards(0);
        } else {
            user.setNumCards(Integer.parseInt(numCards.getText().toString()));
        }
        user.setApr(maxApr(aprVal));
        user.setFtf(ftf.isChecked());
        user.setNaf(naf.isChecked());
        user.setRewards(rewards.getSelectedItem().toString());

        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra("score", user.getScore());
        intent.putExtra("numCards", user.getNumCards());
        intent.putExtra("apr", user.getApr());
        intent.putExtra("ftf", user.getFtf());
        intent.putExtra("naf", user.getNaf());
        intent.putExtra("rewards", user.getRewards());
        startActivity(intent);
    }
}
