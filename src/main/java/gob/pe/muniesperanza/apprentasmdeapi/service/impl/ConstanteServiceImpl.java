package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.*;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ArancelIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.repository.ConstanteIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.ConstanteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConstanteServiceImpl implements ConstanteService {


    private final ConstanteIDAO constanteIDAO;

  public ConstanteServiceImpl(ConstanteIDAO constanteIDAO) {
      this.constanteIDAO = constanteIDAO;
    }

  @Transactional(readOnly = true)
  @Override
  public List<ConstanteBean> listarConstantePadre(String codConstante) throws Exception {
    return constanteIDAO.listarConstantePadre(codConstante);
  }

  @Transactional(readOnly = true)
  @Override
  public List<ConstanteBean> listarConstanteHijo(String codConstante) throws Exception {
    return constanteIDAO.listarConstanteHijo(codConstante);
  }

  public List<GrupoUsoBean> listarGrupoUso(){
    return constanteIDAO.listarGrupoUso();
  }

  public List<RutaBean> listarRuta(){
    return constanteIDAO.listarRuta();
  }

  public List<UbicacionAreaVerde> listarUbicacionAreaVerde() {
    return constanteIDAO.listarUbicacionAreaVerde();
  }

  public List<UsoPredio> listarUsoPredio() {
    return constanteIDAO.listarUsoPredio();
  }

  public List<ZonaBean> listarZona() {
    return constanteIDAO.listarZona();
  }

}
