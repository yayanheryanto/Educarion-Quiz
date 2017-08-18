package com.yayanheryanto.quizeducation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question1 extends AppCompatActivity {

    private Button buttonNext1;
    private RadioGroup soal1;
    private RadioButton radioButton;
    private int idJawab;
    private int nilai = 0;
    public static final String NILAI = "NILAI";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        bindingData();

        buttonNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void bindingData() {
        buttonNext1 = (Button) findViewById(R.id.button_next1);
        soal1 = (RadioGroup) findViewById(R.id.soal1);
    }

    private String answer1(){
        idJawab = soal1.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(idJawab);
        return radioButton.getText().toString();
    }

    private void checkAnswer(){
        if (soal1.getCheckedRadioButtonId()==-1){
            Toast.makeText(this, "Please Choose Your Answer", Toast.LENGTH_LONG).show();
        }else {
            if (answer1().equalsIgnoreCase("thomas alfa edison")) {
                nilai += 20;
            }
            Log.d(NILAI, String.valueOf(nilai));
            Intent intent = new Intent(Question1.this, Question2.class);
            intent.putExtra(NILAI, String.valueOf(nilai));
            startActivity(intent);
            finish();
        }
    }
}
