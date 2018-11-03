package com.example.xeviu.ad_act3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Estudiantes extends AppCompatActivity {

    private MyDBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiantes);



    }

    public void OnClick(View v) {

        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();
        dbAdapter.insertarEstudiante("Pepe",22, "DAM", "2a",2.5);
        dbAdapter.insertarEstudiante("Andres",25, "DAM", "2a",8.5);

    }

    public void OnClick2(View v) {

        TextView textView = (TextView) this.findViewById(R.id.textView);
        TextView textView2 = (TextView) this.findViewById(R.id.textView2);

        ArrayList<String> estudiantes = dbAdapter.recuperarEstudiantes();
        textView.setText(estudiantes.get(0));
        textView2.setText(estudiantes.get(1));

    }
}
