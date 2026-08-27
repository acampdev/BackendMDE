package gob.pe.muniesperanza.apprentasmdeapi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

  public static String doGenerarNombreArchivoAleatorio() {
    SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyyMMddHHmmss");
    String response="";
    try{
      response=formatoDeFecha.format(new Date());
      response+= "" +  aleatorio(1000,9999);
    }catch(Exception e){
      response="";
    }
    return response;
  }

  public static int aleatorio(int max,int min){
    return (int)(Math.random()*(max-min))+min;
  }

  public static String doConvertDateToString(Date dtFecha) {
    SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
    return formatoDeFecha.format(dtFecha);
  }

  public static Date doConvertStringToDate(String vcFecha) {
    try {
      SimpleDateFormat formatoDeFecha =
              new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date fecha_convertida = formatoDeFecha.parse(vcFecha);
      return fecha_convertida;
    } catch (ParseException e) {
     return null;
    }
  }

}

