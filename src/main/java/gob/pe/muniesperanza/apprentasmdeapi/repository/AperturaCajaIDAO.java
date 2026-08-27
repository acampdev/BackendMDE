package gob.pe.muniesperanza.apprentasmdeapi.repository;

import gob.pe.muniesperanza.apprentasmdeapi.bean.AperturaCajaBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface AperturaCajaIDAO {

  public ClsResultDAO apertura(AperturaCajaBean aperturaCajaBean) throws Exception;

  public ClsResultDAO cierre(AperturaCajaBean aperturaCajaBean) throws Exception;

  public List<AperturaCajaBean> listar(Integer codUsuario) throws Exception;
}
