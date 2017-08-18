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

import static com.yayanheryanto.quizeducation.Question1.NILAI;

public class Question4 extends AppCompatActivity {

    private Button buttonNext4;
    private RadioGroup soal4;
    private RadioButton radioButton;
    private int idJawab;
    private int nilai = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);

        nilai = Integer.parseInt(getIntent().getStringExtra(NILAI));
        bindingData();

        buttonNext4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void bindingData() {
        buttonNext4 = (Button) findViewById(R.id.button_next4);
        soal4 = (RadioGroup) findViewById(R.id.soal1);
    }

    private String answer4(){
        idJawab = soal4.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(idJawab);
        return radioButton.getText().toString();
    }

    private void checkAnswer(){
        if (soal4.getCheckedRadioButtonId()==-1){
            Toast.makeText(this, "Please Choose Your Answer", Toast.LENGTH_LONG).show();
        }else {
            if (answer4().equalsIgnoreCase("j.k.rowling")) {
                nilai += 20;
            }
            Log.d(NILAI, String.valueOf(nilai));
            Intent intent = new Intent(Question4.this, Question5.class);
            intent.putExtra(NILAI, String.valueOf(nilai));
            startActivity(intent);
            finish();
        }
    }

}
