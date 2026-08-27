package gob.pe.muniesperanza.apprentasmdeapi.service;

import gob.pe.muniesperanza.apprentasmdeapi.bean.CronogramaBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.FraccionamientoBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface FraccionamientoService {

  public ClsResultDAO insertarFraccionamiento(FraccionamientoBean fraccionamientoBean) throws Exception;

  public List<FraccionamientoBean> listarFraccionamiento(Integer codContribuyente) throws Exception;

  public List<CronogramaBean> listarCronograma(Integer anio, Integer codResolucion) throws Exception;

  public List<CronogramaBean> listarCronogramaContri(Integer codContribuyente) throws Exception;
}
