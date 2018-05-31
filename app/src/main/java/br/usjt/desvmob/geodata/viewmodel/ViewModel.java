package br.usjt.desvmob.geodata.viewmodel;

import java.util.ArrayList;

import br.usjt.desvmob.geodata.model.Pais;

/**
 * Created by jhonasbalsas on 31/05/18.
 */

public interface ViewModel {
    ArrayList<String> listarNomes(Pais[] paises);
    Pais[] listarPaises(String continente);
    ArrayList<Pais> todosPaises() ;
}
