package com.example.meus_gastos.common;

import java.util.Date;
import java.text.SimpleDateFormat;

public class ConversorData {
    public static String converterDateParaDataHora(Date data){
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        return formatador.format(data);
    }
}
