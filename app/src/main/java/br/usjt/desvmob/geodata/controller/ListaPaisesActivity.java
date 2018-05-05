package br.usjt.desvmob.geodata.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import br.usjt.desvmob.geodata.R;
import br.usjt.desvmob.geodata.model.Data;
import br.usjt.desvmob.geodata.model.Pais;
import br.usjt.desvmob.geodata.util.PaisAdapter;

/**
 * Jhonnanthn William Carlos Balsas
 * 816119078 - CCP3AN-MCA
 */

public class ListaPaisesActivity extends Activity {
    public static final String PAIS = "br.usjt.desvmob.geodata.model.pais";
    Activity atividade;
    Pais[] paises;
    ArrayList<String> nomes;

    /**
     * Lista de paises
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);
        atividade = this;
        Intent intent = getIntent();
        String continente = intent.getStringExtra(MainActivity.CHAVE);
        paises = Data.listarPaises(continente);
        nomes = Data.listarNomes(paises);

        ListView listView = (ListView) findViewById(R.id.lista_paises);
        PaisAdapter adapter = new PaisAdapter(paises, this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // manda para a tela de detalhe
                Intent intent = new Intent(atividade, DetalhePaisActivity.class);
                intent.putExtra(PAIS, paises[position]);

                startActivity(intent);

            }

        });
    }
}
