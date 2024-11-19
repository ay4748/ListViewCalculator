package com.example.listviewcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityResult extends AppCompatActivity {
    ListView lV;
    TextView tVFirst,tVHefresh,tVindex,tVSumUntil;
    boolean isHeshbonit;
    int numFirst, numMana;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_result);

        initViews();
        Intent gi = getIntent();
        numFirst = gi.getIntExtra("numFirst",0);
        numMana = gi.getIntExtra("numMana",0);
        isHeshbonit = gi.getBooleanExtra("isHeshbonit",false);

        tVFirst.setText("X1 " + numFirst);



    }

    private void initViews() {
        lV = findViewById(R.id.lV);
        tVFirst = findViewById(R.id.tvFirst);
        tVHefresh = findViewById(R.id.tVHefresh);
        tVindex = findViewById(R.id.tVIndex);
        tVSumUntil = findViewById(R.id.tVSumUntil);
    }

    private void heshboint(int numFirst,int numMana)
    {
        tVHefresh.setText("d = " + numMana);
    }
}