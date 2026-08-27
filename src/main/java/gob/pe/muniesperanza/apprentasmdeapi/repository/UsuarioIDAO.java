package gob.pe.muniesperanza.apprentasmdeapi.repository;

import gob.pe.muniesperanza.apprentasmdeapi.bean.UitEpaBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.UsuarioBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface UsuarioIDAO  {

  public ClsResultDAO insertar(UsuarioBean usuarioBean) throws Exception;

  public ClsResultDAO actualizar(UsuarioBean usuarioBean) throws Exception;

  public ClsResultDAO darBaja(UsuarioBean usuarioBean) throws Exception;

  public ClsResultDAO activar(UsuarioBean usuarioBean) throws Exception;

  public ClsResultDAO cambiarClave(UsuarioBean usuarioBean) throws Exception;

  public List<UsuarioBean> listar(String parametroBusqueda) throws Exception;

  public ClsResultDAO verificarSupervisorCajero(UsuarioBean usuarioBean) throws Exception;
}
