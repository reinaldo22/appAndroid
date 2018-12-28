package com.example.reinaldo.mediaescolarmvc.controller;

import android.content.ContentValues;
import android.content.Context;

import com.example.reinaldo.mediaescolarmvc.datamodel.MediaEscolarDataModel;
import com.example.reinaldo.mediaescolarmvc.datasource.DataSource;
import com.example.reinaldo.mediaescolarmvc.model.MediaEscolar;

public class MediaEscolarController extends DataSource {


    ContentValues dados;

    public MediaEscolarController(Context context) {
        super(context);
    }

    public void calcularMedia() {

    }

    public void resultadoFinal() {

    }

    public boolean salvar(MediaEscolar obj){

        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(MediaEscolarDataModel.getMateria(), obj.getMateria());
        dados.put(MediaEscolarDataModel.getBimestre(), obj.getBimestre());
        dados.put(MediaEscolarDataModel.getSituacao(), obj.getSituacao());
        dados.put(MediaEscolarDataModel.getNotaProva(), obj.getNotaProva());
        dados.put(MediaEscolarDataModel.getNotaMateria(), obj.getNotaMateria());
        dados.put(MediaEscolarDataModel.getMediaFinal(), obj.getMediaFinal());

        sucesso = insert(MediaEscolarDataModel.getTABELA(), dados);

        return sucesso;
    }
}

