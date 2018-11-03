package com.example.xeviu.ad_act3;

import android.content.Intent;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MyDBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void OnClick(View v) {
        startActivity(new Intent(this,Preferences.class));
    }

    public void OnClick2(View v) {
        startActivity(new Intent(this,Estudiantes.class));
    }
    public void OnClick3(View v) {
        startActivity(new Intent(this,Profesores.class));
    }
}
