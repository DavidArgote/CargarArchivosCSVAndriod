package com.davidargote.appficherocsv.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagerHelper {

    ControlHelper controlHelper;
    SQLiteDatabase db;

    public ManagerHelper(Context context) {
        this.controlHelper = new ControlHelper(context);
    }

    public void openRd(){
        db = controlHelper.getReadableDatabase();
    }

    public void openWr(){
        db = controlHelper.getWritableDatabase();
    }

    public void closeDb(){
        if (db != null){
            db.close();
        }
    }

    public long insertDatas(Datos datos){

        openWr();

        ContentValues values = new ContentValues();

        values.put(Constantes.COLUMN_1, datos.getName());
        values.put(Constantes.COLUMN_2, datos.getState());
        values.put(Constantes.COLUMN_3, datos.getStateAbbrv());
        values.put(Constantes.COLUMN_4, datos.getFips());

        long insert = db.insert(Constantes.NAME_TABLA_1, null, values);

        closeDb();

        return insert;

    }

    public List<Datos> listDatas(){

        openRd();

        ArrayList<Datos> list = new ArrayList<>();

        Cursor cursor = db.rawQuery(Constantes.QUERY_ALL_TABLE_1, null);

        if (cursor.moveToFirst()){
            do{

                Datos datos = new Datos();

                datos.setName(cursor.getString(0));
                datos.setState(cursor.getString(1));
                datos.setStateAbbrv(cursor.getString(2));
                datos.setFips(cursor.getString(3));


                list.add(datos);

            }while(cursor.moveToNext());
        }

        closeDb();

        return list;

    }



}
