package gob.pe.muniesperanza.apprentasmdeapi.repository;


import gob.pe.muniesperanza.apprentasmdeapi.bean.CajaBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface CajaIDAO {
// MODULO DE CAJA
  public ClsResultDAO insertar(CajaBean cajaBean) throws Exception;

  public ClsResultDAO actualizar(CajaBean cajaBean) throws Exception;

  public ClsResultDAO eliminar(CajaBean cajaBean) throws Exception;

  public List<CajaBean> listar(String descripcion, Integer codUsuario) throws Exception ;

}
