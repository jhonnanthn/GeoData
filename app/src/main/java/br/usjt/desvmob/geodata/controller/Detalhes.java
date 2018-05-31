package br.usjt.desvmob.geodata.controller;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.TextView;

import br.usjt.desvmob.geodata.R;
import br.usjt.desvmob.geodata.model.Pais;

/**
 * Jhonnanthn William Carlos Balsas
 * 816119078 - CCP3AN-MCA
 */
public class Detalhes extends Activity {

    /**
     * Detalhes sobre o país selecionado pelo usuário.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pais);
        TextView txtPais = (TextView)findViewById(R.id.txtPais);
        Intent intent = getIntent();
        Pais pais = (Pais)intent.getSerializableExtra(Listar.PAIS);
        txtPais.setText(pais.toString());

        android.support.v4.app.FragmentManager fm = getSupportFragmentManager ( );
        if (savedInstanceState == null){
            FragmentTransaction ft = fm.beginTransaction();
            ft.add (R.id.txtPais , pais, pais.toString());
            ft.commit();
        }
    }
}
