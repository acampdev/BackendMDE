package gob.pe.muniesperanza.apprentasmdeapi.service;

import gob.pe.muniesperanza.apprentasmdeapi.bean.PisoBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.Date;
import java.util.List;

public interface PisoService {

  public ClsResultDAO insertarPiso(PisoBean pisoBean) throws Exception;

  public ClsResultDAO actualizarPiso(PisoBean pisoBean) throws Exception;


  public ClsResultDAO eliminarPiso(PisoBean pisoBean) throws Exception;

  public List<PisoBean> listarPiso(Integer anio, String codPredioBase) throws Exception ;

  public List<PisoBean> listarPisoAll(String codPredioBase, Integer anio, Integer numeroPiso) throws Exception  ;


}
