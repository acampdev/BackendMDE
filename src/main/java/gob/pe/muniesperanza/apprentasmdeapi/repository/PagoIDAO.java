package gob.pe.muniesperanza.apprentasmdeapi.repository;

import gob.pe.muniesperanza.apprentasmdeapi.bean.InteresBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.PagoBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface PagoIDAO {

  public ClsResultDAO pagoOrdinario(PagoBean pagoBean) throws Exception;

  public ClsResultDAO pagoCuotaFraccionamiento(PagoBean pagoBean) throws Exception;

  public List<PagoBean> listarPagos(Integer codContribuyente,Integer numeroPago,Integer anio) throws Exception ;

}
