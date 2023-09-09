package com.twister.listadecurso.controller;

import android.content.SharedPreferences;

import com.twister.listadecurso.model.Pessoa;
import com.twister.listadecurso.view.MainActivity;

public class PessoaController {
    SharedPreferences.Editor listavip;
    SharedPreferences preferences;


    public static final String  NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity){
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listavip = preferences.edit();
    }


    public void salvar(Pessoa pessoa) {
        listavip.putString("PrimeiroNome",pessoa.getPrimeiroNome());
        listavip.putString("SobreNome",pessoa.getSobreNome());
        listavip.putString("TelefoneContato",pessoa.getTelefoneContato());
        listavip.putString("CursoDesejado",pessoa.getCursoDesejado());
        listavip.apply();
    }

    public Pessoa buscar(Pessoa pessoa){
          pessoa.setPrimeiroNome(preferences.getString("PrimeiroNome",""));
          pessoa.setSobreNome(preferences.getString("SobreNome",""));
          pessoa.setCursoDesejado(preferences.getString("CursoDesejado",""));
          pessoa.setTelefoneContato(preferences.getString("TelefoneContato",""));
          return pessoa;
    }

    public void limpar(){
        listavip.clear();
        listavip.apply();
    }
}