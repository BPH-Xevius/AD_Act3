package com.example.xeviu.ad_act3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Profesores extends AppCompatActivity {

    private MyDBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesores);


    }

    public void OnClick(View v) {

        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();
        dbAdapter.insertarProfesor("Juan",25, "DAM", "2a","2.2.3");
        dbAdapter.insertarProfesor("Miguel",25, "DAM", "2a","2.3.6");

    }

    public void OnClick2(View v) {

        TextView textView = (TextView) this.findViewById(R.id.textView);
        TextView textView2 = (TextView) this.findViewById(R.id.textView2);

        ArrayList<String> profesores = dbAdapter.recuperarProfesores();
        textView.setText(profesores.get(0));
        textView2.setText(profesores.get(1));

    }
}
