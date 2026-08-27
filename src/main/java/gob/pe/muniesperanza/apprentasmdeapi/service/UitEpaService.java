package gob.pe.muniesperanza.apprentasmdeapi.service;

import gob.pe.muniesperanza.apprentasmdeapi.bean.UitEpaBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ValoresUnitariosBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface UitEpaService {

  public ClsResultDAO insertarUitEpa(UitEpaBean uitEpaBean)  throws Exception;

  public ClsResultDAO actualizarUitEpa(UitEpaBean uitEpaBean)  throws Exception;


  public List<UitEpaBean> listarUitEpa(Integer anio) throws Exception;


}
