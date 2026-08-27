package gob.pe.muniesperanza.apprentasmdeapi.service;

import gob.pe.muniesperanza.apprentasmdeapi.bean.CajaBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface CajaService {


  public ClsResultDAO insertar(CajaBean cajaBean) throws Exception;

  public ClsResultDAO actualizar(CajaBean cajaBean) throws Exception;

  public ClsResultDAO eliminar(CajaBean cajaBean) throws Exception;

  public List<CajaBean> listar(String descripcion, Integer codUsuario) throws Exception ;

}
