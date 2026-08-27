package gob.pe.muniesperanza.apprentasmdeapi.service;

import gob.pe.muniesperanza.apprentasmdeapi.model.Via;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface ViaService {
  List<Via> listarVias();

  Via insertarVias(Via via);

  public ClsResultDAO insertarVia(Via via)  throws Exception;

  public ClsResultDAO actualizarVia(Via via)  throws Exception;
}
