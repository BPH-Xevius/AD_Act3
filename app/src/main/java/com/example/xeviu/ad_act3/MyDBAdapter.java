package com.example.xeviu.ad_act3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDBAdapter{

    private static final String DATABASE_NAME = "inst.db";
    private static final String DATABASE_TABLE = "estudiantes";
    private static final String DATABASE_TABLE2 = "profesores";
    private static final int DATABASE_VERSION = 1;

    private static final String A_NOMBRE = "nombre";
    private static final String A_EDAD = "edad";
    private static final String A_CICLO = "ciclo";
    private static final String A_CURSO = "curso";
    private static final String A_NOTAM = "notamedia";

    private static final String P_NOMBRE = "nombre";
    private static final String P_EDAD = "edad";
    private static final String P_CICLO = "ciclo";
    private static final String P_CURSO = "curso";
    private static final String P_DESP = "despacho";

    private static final String DATABASE_CREATE = "CREATE TABLE "+DATABASE_TABLE+" (_id integer primary key autoincrement, nombre text, edad integer, ciclo text, curso text, notamedia float);";
    private static final String DATABASE_DROP = "DROP TABLE IF EXISTS "+DATABASE_TABLE+";";


    private static final String DATABASE_CREATE2 = "CREATE TABLE "+DATABASE_TABLE2+" (_id integer primary key autoincrement, nombre text, edad integer, ciclo text, curso text, despacho text);";
    private static final String DATABASE_DROP2 = "DROP TABLE IF EXISTS "+DATABASE_TABLE2+";";


    private final Context context;
    private MyDbHelper dbHelper;
    private SQLiteDatabase db;

    public MyDBAdapter (Context c){

        context = c;
        dbHelper = new MyDbHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void open(){

        try{
            db = dbHelper.getWritableDatabase();
        }catch(SQLiteException e){
            db = dbHelper.getReadableDatabase();
        }

    }

    public void insertarEstudiante(String n, int e, String dam, String s, double v){
        ContentValues newValues = new ContentValues();
        newValues.put(A_NOMBRE,n);
        newValues.put(A_EDAD,e);
        newValues.put(A_CICLO,n);
        newValues.put(A_CURSO,e);
        newValues.put(A_NOTAM,n);
        db.insert(DATABASE_TABLE,null,newValues);
    }

    public void insertarProfesor(String n, int e, String dam, String s, String s1){
        ContentValues newValues = new ContentValues();
        newValues.put(P_NOMBRE,n);
        newValues.put(P_EDAD,e);
        newValues.put(P_CICLO,n);
        newValues.put(P_CURSO,e);
        newValues.put(P_DESP,n);
        db.insert(DATABASE_TABLE2,null,newValues);
    }

    public ArrayList<String> recuperarEstudiantes(){
        ArrayList<String> estudiantes = new ArrayList<String>();

        Cursor cursor = db.query(DATABASE_TABLE,null,null,null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            do{
                estudiantes.add(cursor.getString(1));
            }while (cursor.moveToNext());
        }
        return estudiantes;
    }

    public ArrayList<String> recuperarProfesores(){
        ArrayList<String> profesores = new ArrayList<String>();

        Cursor cursor = db.query(DATABASE_TABLE2,null,null,null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            do{
                profesores.add(cursor.getString(1));
            }while (cursor.moveToNext());
        }
        return profesores;
    }

    private static class MyDbHelper extends SQLiteOpenHelper {

        public MyDbHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
            super(context,name,factory,version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DATABASE_DROP);
            onCreate(db);
        }

    }
}