package com.example.el_24deseptiembre;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TableRow;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String Database_name="usuarios.db";
    public static final String table_name="usuario_table";
    public static final String col1="ID";
    public static final String col2="Nombre";
    public static final String col3="Apellido";
    public static final String col4="Correo";

    public DataBaseHelper(@Nullable Context context) {
        super(context, Database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+table_name+
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT, Nombre TEXT , Apellido TEXT, Correo TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+table_name);
        onCreate(db);
    }
    public boolean insertData(String nombre, String apellido, String correo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contendvalues = new ContentValues();
        contendvalues.put(col2,nombre);
        contendvalues.put(col3,apellido);
        contendvalues.put(col4,correo);
        long result = db.insert(table_name,null,contendvalues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+ table_name,null);
        return res;
    }
}
