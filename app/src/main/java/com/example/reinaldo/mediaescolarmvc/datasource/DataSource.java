package com.example.reinaldo.mediaescolarmvc.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.reinaldo.mediaescolarmvc.datamodel.MediaEscolarDataModel;

public class DataSource extends SQLiteOpenHelper {

    //Declara variaveis com o nome do banco e a versão


    private static final String DB_NAME = "media_escolar.sqlite";
    private static final int DB_VERSION = 1;

    SQLiteDatabase db;

    public DataSource(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try{

            db.execSQL(MediaEscolarDataModel.criarTabela());

        }catch (Exception e){

            Log.e("Media", "DB---> ERRO: "+e.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {



    }

    public boolean insert(String tabela, ContentValues dados){

        boolean sucesso = true;

       try {

            sucesso = db.insert(tabela, null, dados) > 0;

        }catch (Exception e){

           sucesso = false;

        }

        return sucesso;
    }

}
