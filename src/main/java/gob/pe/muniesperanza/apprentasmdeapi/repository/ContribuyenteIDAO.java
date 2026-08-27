package gob.pe.muniesperanza.apprentasmdeapi.repository;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ContribuyenteBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface ContribuyenteIDAO {

  public ClsResultDAO insertarContribuyente(ContribuyenteBean contribuyenteBean) throws Exception;

  public ClsResultDAO actualizarContribuyente(ContribuyenteBean contribuyenteBean) throws Exception;

  public ClsResultDAO asignarConyugeRepresentante(ContribuyenteBean contribuyenteBean) throws Exception;

  public ClsResultDAO quitarConyugeRepresentante(ContribuyenteBean contribuyenteBean) throws Exception;

  public List<ContribuyenteBean> listarContribuyente(Integer codigoContribuyente, Integer codigoPersona) throws Exception;

  public List<ContribuyenteBean> listarGeneral(String parametroBusqueda, Integer codigoContribuyente,String codTipoContribuyente,
           Boolean esExonerado,Boolean esPensionista) throws Exception;

}
