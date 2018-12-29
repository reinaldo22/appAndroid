package com.example.reinaldo.mediaescolarmvc.controller;

import android.content.ContentValues;
import android.content.Context;

import com.example.reinaldo.mediaescolarmvc.datamodel.MediaEscolarDataModel;
import com.example.reinaldo.mediaescolarmvc.datasource.DataSource;
import com.example.reinaldo.mediaescolarmvc.model.MediaEscolar;

public class MediaEscolarController extends DataSource {

    ContentValues dados = new ContentValues();


    public MediaEscolarController(Context context) {
        super(context);
    }

    public void calcularMedia() {

    }

    public void resultadoFinal() {

    }

    public void salvar(MediaEscolar obj) {




        ContentValues dados = new ContentValues();

        dados.put(MediaEscolarDataModel.getMateria(), obj.getMateria());
        dados.put(MediaEscolarDataModel.getBimestre(), obj.getBimestre());
        dados.put(MediaEscolarDataModel.getSituacao(), obj.getSituacao());
        dados.put(MediaEscolarDataModel.getNotaProva(), obj.getNotaProva());
        dados.put(MediaEscolarDataModel.getNotaMateria(), obj.getNotaMateria());
        dados.put(MediaEscolarDataModel.getMediaFinal(), obj.getMediaFinal());

        insert(MediaEscolarDataModel.getTABELA(), dados);


    }
    public  boolean deletar (MediaEscolar obj){

        boolean sucesso = true;

        sucesso = deletar(MediaEscolarDataModel.getTABELA(), obj.getId());

        return true;
    }

}