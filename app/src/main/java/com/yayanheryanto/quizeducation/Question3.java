package com.yayanheryanto.quizeducation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.yayanheryanto.quizeducation.Question1.NILAI;

public class Question3 extends AppCompatActivity {

    private Button buttonNext3;
    private EditText soal3;
    private int nilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        nilai = Integer.parseInt(getIntent().getStringExtra(NILAI));
        bindingData();

        buttonNext3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void bindingData() {
        buttonNext3 = (Button) findViewById(R.id.button_next3);
        soal3 = (EditText) findViewById(R.id.soal3);
    }

    public String answer3(){
        return soal3.getText().toString();
    }

    private void checkAnswer(){
        if (answer3().equalsIgnoreCase("")) {
            Toast.makeText(this, "Please Fill the Blank", Toast.LENGTH_SHORT).show();
        }else{
            if (answer3().equalsIgnoreCase("geologi")){
                nilai +=20;
            }
            Log.d(NILAI, String.valueOf(nilai));
            Intent intent = new Intent(Question3.this, Question4.class);
            intent.putExtra(NILAI, String.valueOf(nilai));
            startActivity(intent);
            finish();
        }
    }
}
