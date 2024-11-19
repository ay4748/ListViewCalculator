package com.example.listviewcalculator;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    boolean isHeshbonit;
    Button btnHeshbon,btnHandasa;
    EditText eTFirst,eTmana;
    int numFirst,numMana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        btnHeshbon = findViewById(R.id.btnHeshbon);
        btnHandasa = findViewById(R.id.btnHandasa);
        eTFirst = findViewById(R.id.eTFirst);
        eTmana = findViewById(R.id.eTmana);

    }

    public void heshbonit(View view) {
        isHeshbonit = true;
        btnHandasa.setBackgroundTintList(ColorStateList.valueOf(Color.GRAY));
        btnHeshbon.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
    }

    public void handasit(View view) {
        isHeshbonit = false;
        btnHandasa.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        btnHeshbon.setBackgroundTintList(ColorStateList.valueOf(Color.GRAY));
    }

    public boolean canAct(String st) {
        if (st.isEmpty() || st.equals("-") || st.equals(".") || st.equals("+") || st.equals("-.") || st.equals("+.")) {
            return false;
        } else {
            return true;
        }
    }


    public void goNext(View view) {
        //Intent si = new Intent(this,MainActivityResult.class);
        //startActivity(si)
        String first = eTFirst.getText().toString();
        String mana = eTmana.getText().toString();
        if (!(canAct(first) && canAct(mana))) {
            Toast.makeText(this, "Invalid input", Toast.LENGTH_LONG).show();
        }
        else {
            Intent si = new Intent(this,MainActivityResult.class);
            numFirst = Integer.parseInt(first);
            numMana = Integer.parseInt(mana);
            si.putExtra("isHeshbonit", isHeshbonit);
            si.putExtra("numFirst", numFirst);
            si.putExtra("numMana", numMana);
            startActivity(si);



        }
    }
}