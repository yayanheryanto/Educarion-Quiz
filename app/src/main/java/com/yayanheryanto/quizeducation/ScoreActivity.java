package com.yayanheryanto.quizeducation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.yayanheryanto.quizeducation.MainActivity.MY_PREFERENCES;
import static com.yayanheryanto.quizeducation.MainActivity.NAMA;
import static com.yayanheryanto.quizeducation.Question1.NILAI;

public class ScoreActivity extends AppCompatActivity {

    private String nilai, myName;
    private TextView textScore, textName;
    private Button buttonAnswer, buttonMain;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        nilai = getIntent().getStringExtra(NILAI);
        getPreferences();
        bindingData();
        displayScore("Your Score :" + nilai);
        displayName(myName);

        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_answer);
                linearLayout.setVisibility(View.VISIBLE);
            }
        });

        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void getPreferences(){
        pref = this.getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        myName = pref.getString(NAMA,"");
    }

    private void bindingData() {
        textScore = (TextView) findViewById(R.id.text_score);
        textName = (TextView) findViewById(R.id.text_name);
        buttonAnswer = (Button) findViewById(R.id.button_answer);
        buttonMain = (Button) findViewById(R.id.button_main);
    }

    private void displayScore(String score){
        textScore.setText(score);
    }

    private void displayName(String name){
        textName.setText(name);
    }
}
