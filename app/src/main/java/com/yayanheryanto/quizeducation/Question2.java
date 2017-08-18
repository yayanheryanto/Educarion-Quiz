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

public class Question2 extends AppCompatActivity {

    private Button buttonNext2;
    private boolean checkbox1, checkbox2, checkbox3, checkbox4;
    private int nilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        nilai = Integer.parseInt(getIntent().getStringExtra(NILAI));
        bindingData();

        buttonNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void bindingData() {
        buttonNext2 = (Button) findViewById(R.id.button_next2);
    }

    private void answer2(){
        checkbox1 = ((CheckBox) findViewById(R.id.checkbox1)).isChecked();
        checkbox2 = ((CheckBox) findViewById(R.id.checkbox2)).isChecked();
        checkbox3 = ((CheckBox) findViewById(R.id.checkbox3)).isChecked();
        checkbox4 = ((CheckBox) findViewById(R.id.checkbox4)).isChecked();
    }

    private void checkAnswer(){
        answer2();
        if (checkbox1==false && checkbox2==false && checkbox3==false && checkbox4==false){
            Toast.makeText(this, "Please Choose Your Answer", Toast.LENGTH_SHORT).show();
        }else {
            if (checkbox1 && checkbox2 && checkbox3 && checkbox4==false) {
                nilai += 20;
                }
            Log.d(NILAI, String.valueOf(nilai));
            Intent intent = new Intent(Question2.this, Question3.class);
            intent.putExtra(NILAI,String.valueOf(nilai));
            startActivity(intent);
            finish();
        }
    }

}
