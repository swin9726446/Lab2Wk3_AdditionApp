package com.example.a9726446.lab2wk3_additionapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            addValue();
        }
    };

    private void addValue() {
        ((TextView)findViewById(R.id.txtAnswer)).setText("hi");
        //findViewById(R.id.txtAnswer).setText("hi");
        //findViewById(R.id.etFirstNum);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialiseUI();
    }

    private void initialiseUI() {
        findViewById(R.id.btnAdd).setOnClickListener(clickListener);
        //Button add = findViewById(R.id.btnAdd);
        //add.setOnClickListener(clickListener);
    }

    

}
