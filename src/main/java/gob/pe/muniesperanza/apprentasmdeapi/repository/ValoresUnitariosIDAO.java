package gob.pe.muniesperanza.apprentasmdeapi.repository;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ValoresUnitariosBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface ValoresUnitariosIDAO {

  public ClsResultDAO insertarValoresUnitarios(ValoresUnitariosBean valoresUnitariosBean) throws Exception;

  public ClsResultDAO actualizarValoresUnitarios(ValoresUnitariosBean valoresUnitariosBean) throws Exception;

  public List<ValoresUnitariosBean> listarValoresUnitarios(Integer anio) throws Exception ;

}
