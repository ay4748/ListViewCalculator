package com.example.listviewcalculator;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    boolean isHeshbonit;
    Button btnHeshbon,btnHandasa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        btnHeshbon = findViewById(R.id.btnHeshbon);
        btnHandasa = findViewById(R.id.btnHandasa);

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
            Toast.makeText(this, "Invalid input", Toast.LENGTH_LONG).show();
            return false;
        } else {
            return true;
        }
    }


    public void goNext(View view) {
        String num1 = btnHeshbon.getText().toString();
        String num2 = btnHandasa.getText().toString();
        if (canAct(num1) && canAct(num2)) {

        }
    }
}