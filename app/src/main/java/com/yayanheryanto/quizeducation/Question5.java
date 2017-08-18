package com.yayanheryanto.quizeducation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import static com.yayanheryanto.quizeducation.Question1.NILAI;

public class Question5 extends AppCompatActivity {

    private Button buttonNext5;
    private boolean checkbox1, checkbox2, checkbox3, checkbox4;
    private int nilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);

        nilai = Integer.parseInt(getIntent().getStringExtra(NILAI));
        bindingData();

        buttonNext5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void bindingData() {
        buttonNext5 = (Button) findViewById(R.id.button_next5);
    }

    private void answer5(){
        checkbox1 = ((CheckBox) findViewById(R.id.checkbox5)).isChecked();
        checkbox2 = ((CheckBox) findViewById(R.id.checkbox6)).isChecked();
        checkbox3 = ((CheckBox) findViewById(R.id.checkbox7)).isChecked();
        checkbox4 = ((CheckBox) findViewById(R.id.checkbox8)).isChecked();
    }

    private void checkAnswer(){
        answer5();
        if (checkbox1==false && checkbox2==false && checkbox3==false && checkbox4==false){
            Toast.makeText(this, "Please Choose Your Answer", Toast.LENGTH_SHORT).show();
        }else {
            if (checkbox1 && checkbox2 && checkbox3==false && checkbox4==false) {
                nilai += 20;
            }
            Log.d(NILAI, String.valueOf(nilai));
            Intent intent = new Intent(Question5.this, ScoreActivity.class);
            intent.putExtra(NILAI,String.valueOf(nilai));
            startActivity(intent);
            finish();
        }
    }

}
