package gob.pe.muniesperanza.apprentasmdeapi.service;

import gob.pe.muniesperanza.apprentasmdeapi.bean.AlcabalaBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AlcabalaService {


  public ClsResultDAO insertar(AlcabalaBean alcabalaBean) throws Exception;

  public ClsResultDAO actualizar(AlcabalaBean alcabalaBean) throws Exception;

  public List<AlcabalaBean> listar(Integer anio) throws Exception ;
}
