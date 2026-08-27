package gob.pe.muniesperanza.apprentasmdeapi.repository;

import gob.pe.muniesperanza.apprentasmdeapi.bean.TransferenciaPredioBean;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;

import java.util.List;

public interface TransferenciaPredioIDAO {

  public ClsResultDAO insertar(TransferenciaPredioBean transferenciaPredioBean) throws Exception;

  public ClsResultDAO actualizar(TransferenciaPredioBean transferenciaPredioBean) throws Exception;

  public List<TransferenciaPredioBean> listaTransferenciaPredio(Integer codTransferencia, String codPredio, Integer anio
          , Integer codContribuyenteVenta, Integer codContribuyenteCompra) throws Exception;
}
