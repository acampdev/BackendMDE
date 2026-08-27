package gob.pe.muniesperanza.apprentasmdeapi.repository;

import gob.pe.muniesperanza.apprentasmdeapi.bean.AsignacionPredioBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface AsignacionPredioIDAO {

  public ClsResultDAO insertarAsignacionPredio(AsignacionPredioBean asignacionPredioBean) throws Exception;

  public ClsResultDAO actualizarAsignacionPredio(AsignacionPredioBean asignacionPredioBean) throws Exception;

  public List<AsignacionPredioBean> listarAsignacionPredio(Integer anio, Integer codContribuyente) throws Exception ;

  public ClsResultDAO desasignarAsignacionPredio(AsignacionPredioBean asignacionPredioBean) throws Exception;

  public ClsResultDAO prevalidarBeneficioPensionista(Integer codContribuyente) throws Exception;

  public ClsResultDAO prevalidarBeneficioAdultoMayor(Integer codContribuyente) throws Exception;

}
