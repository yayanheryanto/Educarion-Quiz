package com.yayanheryanto.quizeducation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonStart, buttonExit;
    public static final String NAMA = "NAMA";
    public static final String MY_PREFERENCES = "MY_PREFERENCES";
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializePreferences();
        bindingData();

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputName();
            }
        });

        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }

    private void initializePreferences() {
        pref = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    private void bindingData() {
        buttonStart = (Button) findViewById(R.id.button_start);
        buttonExit = (Button) findViewById(R.id.button_exit);
    }

    private void inputName(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Quiz");
        builder.setMessage("Enter Your Name");
        final EditText editTextNama = new EditText(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        editTextNama.setLayoutParams(params);
        builder.setView(editTextNama);
        builder.setPositiveButton("Start Quiz", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    String myName = editTextNama.getText().toString();
                    if (myName.equalsIgnoreCase("")){
                        Toast.makeText(MainActivity.this, "Name must be fiiled", Toast.LENGTH_SHORT).show();
                    }else {
                        editor.putString(NAMA, myName);
                        editor.apply();
                        Intent intent = new Intent(MainActivity.this, Question1.class);
                        startActivity(intent);
                        finish();
                    }
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
