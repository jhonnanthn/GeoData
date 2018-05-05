package br.usjt.desvmob.geodata.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.desvmob.geodata.R;
import br.usjt.desvmob.geodata.model.Pais;
import br.usjt.desvmob.geodata.util.Network;

/**
 * Jhonnanthn William Carlos Balsas
 * 816119078 - CCP3AN-MCA
 */
public class MainActivity extends Activity {
    public static final String PAIS = "br.usjt.desvmob.geodata.controller.MainActivity.ListaPaises";
    private Spinner spinContinente;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        spinContinente = findViewById(R.id.continente);
    }

    public void listarPaises(View view) {
        String continente = spinContinente.getSelectedItem().toString();
        if (continente.equals("Todos")) {
            new JSONPaises().execute("https://restcountries.eu/rest/v2/all");
        } else {
            new JSONPaises().execute("https://restcountries.eu/rest/v2/region/" + continente);
        }
    }

    private class JSONPaises extends AsyncTask<String, Void, ArrayList<Pais>> {


        @Override
        protected ArrayList<Pais> doInBackground(String... strings) {
            ArrayList<Pais> paises = new ArrayList<>();
            try {
                paises = Network.buscarPaises(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return paises;
        }

        protected void onPostExecute(ArrayList<Pais> paises) {
            Intent intent = new Intent(context, ListaPaisesActivity.class);
            intent.putExtra(PAIS, paises);
            startActivity(intent);
        }

    }
}
