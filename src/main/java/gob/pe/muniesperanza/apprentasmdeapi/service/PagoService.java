package gob.pe.muniesperanza.apprentasmdeapi.service;

import gob.pe.muniesperanza.apprentasmdeapi.bean.PagoBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface PagoService {

  public ClsResultDAO pagoOrdinario(PagoBean pagoBean) throws Exception;

  public ClsResultDAO pagoCuotaFraccionamiento(PagoBean pagoBean) throws Exception;

  public List<PagoBean> listarPagos(Integer codContribuyente, Integer numeroPago, Integer anio) throws Exception ;

}
