package gob.pe.muniesperanza.apprentasmdeapi.repository;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ValoresUnitariosBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.VencimientoBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface VencimientoIDAO {

  public ClsResultDAO generar(VencimientoBean vencimientoBean) throws Exception;

  public List<VencimientoBean> listar(Integer anio) throws Exception ;

}
