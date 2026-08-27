package gob.pe.muniesperanza.apprentasmdeapi.service;

import gob.pe.muniesperanza.apprentasmdeapi.bean.*;

import java.util.List;

public interface ConstanteService {

  public List<ConstanteBean> listarConstantePadre(String codConstante) throws Exception ;

  public List<ConstanteBean> listarConstanteHijo(String codConstante) throws Exception ;

  public List<GrupoUsoBean> listarGrupoUso();

  public List<RutaBean> listarRuta();

  public List<UbicacionAreaVerde> listarUbicacionAreaVerde() ;

  public List<UsoPredio> listarUsoPredio() ;

  public List<ZonaBean> listarZona() ;
}
