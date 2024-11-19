package com.example.listviewcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityResult extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView lV;
    TextView tVFirst,tVHefresh,tVindex,tVSumUntil;
    boolean isHeshbonit;
    int numFirst, numMana;
    double[] dodge = new double[20];
    String[] dodgeString = new String[20];





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
        if(isHeshbonit)
        {
            heshboint(numFirst, numMana);
        }
        else
        {
            handasit(numFirst,numMana);
        }

        lV.setChoiceMode(lV.CHOICE_MODE_SINGLE);
        lV.setOnItemClickListener(this);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, dodgeString);
        lV.setAdapter(adp);




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

        for(int i = 1; i < 21; i++){
            dodge[i-1] = numFirst + (i - 1) * numMana;

        }

        for(int i = 0; i < 20; i++)
        {
            if(dodge[i] > 1000000 || dodge[i] < -1000000)
            {
                dodgeString[i] = bigNumSimplifier(dodge[i]);
            }
            else{
                dodgeString[i] = String.format("%.4f", dodge[i]);
            }
        }
    }

    private void handasit(int numFirst,int numMana)
    {
        tVHefresh.setText("q = " + numMana);

        for(int i = 1; i < 21; i++){
            dodge[i-1] = numFirst * Math.pow(numMana, i - 1);

        }

        for(int i = 0; i < 20; i++)
        {
            if(dodge[i] > 1000000 || dodge[i] < -1000000)
            {
                dodgeString[i] = bigNumSimplifier(dodge[i]);
            }
            else{
                dodgeString[i] = String.format("%.4f", dodge[i]);
            }
        }
    }


    public String bigNumSimplifier(double value){
        String scientificNotation = String.format("%.4e", value);
        String[] parts = scientificNotation.split("e");
        double base = Double.parseDouble(parts[0]) / 10.0;
        int exponent = Integer.parseInt(parts[1]) + 1;

        return String.format("%.4f * 10^%d", base, exponent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        double sum;
        if(isHeshbonit){
            sum = (position * (numFirst + dodge[position + 1])) / 2;

        }
        else{
            sum = (numFirst * (Math.pow(numMana, position) - 1)) / (numMana - 1);
        }
        tVSumUntil.setText("Sum until d = " + position + " = " + String.format("%.4f", sum));
        tVindex.setText("index = " + (position+1));

    }

    public void goback(View view) {
        finish();
    }
}