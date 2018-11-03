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

        /*dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();
        dbAdapter.insertarEstudiante("Pepe",22, "DAM", "2a",2.5);
        dbAdapter.insertarEstudiante("Andres",25, "DAM", "2a",8.5);
        dbAdapter.insertarProfesor("Juan",25, "DAM", "2a","2.2.3");
        dbAdapter.insertarProfesor("Miguel",25, "DAM", "2a","2.3.6");

        TextView textView = (TextView) this.findViewById(R.id.textView);
        TextView textView3 = (TextView) this.findViewById(R.id.textView3);

        ArrayList<String> estudiantes = dbAdapter.recuperarEstudiantes();
        textView.setText(estudiantes.get(0));
        textView3.setText(estudiantes.get(1));*/

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
