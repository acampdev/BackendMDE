package gob.pe.muniesperanza.apprentasmdeapi.repository;

import gob.pe.muniesperanza.apprentasmdeapi.bean.TurnoBean;
import gob.pe.muniesperanza.apprentasmdeapi.model.SectorVia;

import java.util.List;

public interface TurnoIDAO {

  List<TurnoBean> listar()  throws Exception ;
}
