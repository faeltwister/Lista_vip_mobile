package com.twister.listadecurso.view;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.twister.listadecurso.R;
import com.twister.listadecurso.controller.PessoaController;
import com.twister.listadecurso.model.Pessoa;

//devemos importar os botoes e textos

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Pessoa pessoa = new Pessoa();
    PessoaController pessoaController;


    //devemos usar o import do Edit e button para atribuir as variaveis
    EditText editPrimeironome;
    EditText editSobrenome;
    EditText editCurso;
    EditText editTelefone;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       PessoaController pessoaController = new PessoaController(MainActivity.this);
       pessoaController.buscar(pessoa);

        //nomes
        editPrimeironome = findViewById(R.id.txtPrimeiroNome);
        editSobrenome = findViewById(R.id.txtSobrenone);
        editCurso = findViewById(R.id.txtCurso);
        editTelefone = findViewById(R.id.txtTelefone);

        editPrimeironome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobreNome());
        editCurso.setText(pessoa.getCursoDesejado());
        editTelefone.setText(pessoa.getTelefoneContato());

        //botões
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar= findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        //atribuir ao setText os gets da classe pessoa

        editPrimeironome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobreNome());
        editCurso.setText(pessoa.getCursoDesejado());
        editTelefone.setText(pessoa.getTelefoneContato());


        btnLimpar.setOnClickListener(view -> {
            editPrimeironome.setText("");
            editSobrenome.setText("");
            editCurso.setText("");
            editTelefone.setText("");
            pessoaController.limpar();
        });

        btnFinalizar.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this,"Volte Sempre",Toast.LENGTH_LONG).show();
            finish();
        });

        btnSalvar.setOnClickListener(view -> {
            pessoa.setPrimeiroNome(editPrimeironome.getText().toString());
            pessoa.setSobreNome(editSobrenome.getText().toString());
            pessoa.setCursoDesejado(editCurso.getText().toString());
            pessoa.setTelefoneContato(editTelefone.getText().toString());

            Toast.makeText(MainActivity.this,"Salvo com sucesso! " + pessoa.getPrimeiroNome(),Toast.LENGTH_LONG).show();
            pessoaController.salvar(pessoa);
        });

    }
}