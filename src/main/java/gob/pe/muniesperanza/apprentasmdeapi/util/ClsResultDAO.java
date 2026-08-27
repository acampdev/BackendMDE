package gob.pe.muniesperanza.apprentasmdeapi.util;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
@Component
public class ClsResultDAO implements Serializable {


  private static final long serialVersionUID = 1L;

  Map<String, Object> resultado = new LinkedHashMap<String, Object>();
  public static final String CODIGO_RESPUESTA = "CODIGO_RESPUESTA";
  public static final String MENSAJE_RESPUESTA = "MENSAJE_RESPUESTA";
  public static final String INSERTADO = "INSERTADO";
  public static final String ERROR_THROW = "0";

  public void put(String id, Object objeto) {
    resultado.put(id, objeto);
  }

  public Object get(String id) {
    return resultado.get(id);
  }

}