package com.example.reinaldo.mediaescolarmvc.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.reinaldo.mediaescolarmvc.datamodel.MediaEscolarDataModel;
import com.example.reinaldo.mediaescolarmvc.model.MediaEscolar;

import java.util.ArrayList;
import java.util.List;

public class DataSource extends SQLiteOpenHelper {

    //Declara variaveis com o nome do banco e a versão


    private static final String DB_NAME = "media_escolar.sqlite";
    private static final int DB_VERSION = 1;

    //Declaração de Variáveis do banco
    SQLiteDatabase db;

    Cursor cursor;//O cursor precisa da coluna e o id

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

    public boolean deletar(String tabela, int id){

        boolean sucesso = true;

        sucesso = db.delete(tabela,"id=?",new String[]{Integer.toString(id)}) > 0;


        return true;
    }

    public boolean alterar (String tabela, ContentValues dados){

        boolean sucesso = true;

        int id = dados.getAsInteger("id");

        sucesso = db.update(tabela,dados,"id=?", new String[]{Integer.toString(id)}) > 0;

        return sucesso;
    }
    public List<MediaEscolar> getAllMediaEscolar(){

        MediaEscolar obj;

        List<MediaEscolar> lista = new ArrayList<>();

        String sql = " SELECT * FROM "+MediaEscolarDataModel.getTABELA()+" ORDER BY materia ";

        //rawQuery() é uma consulta livre de sintaxe para consulta
        cursor = db.rawQuery(sql,null);

        //Se caso existir algum valor, mover para o indice
        if(cursor.moveToFirst()){

            //faz a buscado indice do id da coluna materia
            do {
                obj = new MediaEscolar();
                obj.setId(cursor.getInt(cursor.getColumnIndex(MediaEscolarDataModel.getId())));
                obj.setMateria(cursor.getString(cursor.getColumnIndex(MediaEscolarDataModel.getMateria())));

                lista.add(obj);


            }while (cursor.moveToNext());

        }
        cursor.close();

        return lista;

    }

}
