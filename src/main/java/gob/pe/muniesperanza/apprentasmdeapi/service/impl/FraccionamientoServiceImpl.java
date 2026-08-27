package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.CronogramaBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.FraccionamientoBean;
import gob.pe.muniesperanza.apprentasmdeapi.repository.FraccionamientoIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.FraccionamientoService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FraccionamientoServiceImpl implements FraccionamientoService {

  private final FraccionamientoIDAO fraccionamientoIDAO;

  public FraccionamientoServiceImpl(FraccionamientoIDAO fraccionamientoIDAO) {
    this.fraccionamientoIDAO = fraccionamientoIDAO;
  }



  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  @Override
  public ClsResultDAO insertarFraccionamiento(FraccionamientoBean fraccionamientoBean)  throws Exception {

    // TODO Auto-generated method stub
    ClsResultDAO objResultDAO = new ClsResultDAO();
    try {
      objResultDAO =  fraccionamientoIDAO.insertarFraccionamiento(fraccionamientoBean);
      if (objResultDAO.get(objResultDAO.CODIGO_RESPUESTA).equals(objResultDAO.ERROR_THROW)) {
        return objResultDAO;
      }
    } catch (Exception e) {
      // TODO: handle exception
      //log.error(e.getMessage(), e);
      throw new Exception(e.getMessage(), e);
    }
    return objResultDAO;
  }

  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  @Override
  public List<FraccionamientoBean> listarFraccionamiento(Integer codContribuyente)  throws Exception {

    return fraccionamientoIDAO.listarFraccionamiento(codContribuyente);

  }

  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  @Override
  public List<CronogramaBean> listarCronograma(Integer anio, Integer codResolucion)  throws Exception {

    return fraccionamientoIDAO.listarCronograma(anio, codResolucion);
  }

  @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
  @Override
  public List<CronogramaBean> listarCronogramaContri( Integer codContribuyente)  throws Exception {

    return fraccionamientoIDAO.listarCronogramaContri(codContribuyente);
  }
}
