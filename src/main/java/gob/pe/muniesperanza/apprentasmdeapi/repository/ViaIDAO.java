package gob.pe.muniesperanza.apprentasmdeapi.repository;

import gob.pe.muniesperanza.apprentasmdeapi.model.Via;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface ViaIDAO {
  List<Via> listarVias();

  Via insertarVia(Via via);

  public ClsResultDAO insertarVias(Via via) throws Exception;

  public ClsResultDAO actualizarVia(Via via) throws Exception;

  public ClsResultDAO obtenerVia(Integer codVia)   throws Exception;
}
