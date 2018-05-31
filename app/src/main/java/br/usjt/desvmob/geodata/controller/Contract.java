package br.usjt.desvmob.geodata.controller;

import android.provider.BaseColumns;

/**
 * Jhonnanthn William Carlos Balsas
 * 816119078 - CCP3AN-MCA
 */

public class Contract {

    public static abstract class PaisEntry implements BaseColumns{
        public static final String TABLE_NAME = "pais";
        public static final String NOME = "nome";
        public static final String REGIAO = "regiao";
        public static final String CAPITAL = "capital";
        public static final String BANDEIRA = "bandeira";
        public static final String CODIGO = "codigo";


    }
}
