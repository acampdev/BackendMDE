package gob.pe.muniesperanza.apprentasmdeapi.service.impl;

import gob.pe.muniesperanza.apprentasmdeapi.bean.CuadranteBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.TransferenciaPredioBean;
import gob.pe.muniesperanza.apprentasmdeapi.model.Sector;
import gob.pe.muniesperanza.apprentasmdeapi.repository.SectorIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.repository.SectorViaIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.repository.TransferenciaPredioIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.SectorViaService;
import gob.pe.muniesperanza.apprentasmdeapi.service.TransferenciaPredioService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class TransferenciaPredioServiceImpl  implements TransferenciaPredioService {

  private final TransferenciaPredioIDAO transferenciaPredioIDAO;

  public TransferenciaPredioServiceImpl(TransferenciaPredioIDAO transferenciaPredioIDAO) {
    this.transferenciaPredioIDAO = transferenciaPredioIDAO;
  }


  @Transactional(readOnly = false)
  @Override
  public ClsResultDAO insertar(TransferenciaPredioBean transferenciaPredioBean) throws Exception {
    return transferenciaPredioIDAO.insertar(transferenciaPredioBean);
  }

  @Transactional
  @Override
  public ClsResultDAO actualizar(TransferenciaPredioBean transferenciaPredioBean) throws Exception {
    return transferenciaPredioIDAO.actualizar(transferenciaPredioBean);
  }

  @Transactional(readOnly = true)
  @Override
  public List<TransferenciaPredioBean> listaTransferenciaPredio(Integer codTransferencia, String codPredio, Integer anio
          , Integer codContribuyenteVenta, Integer codContribuyenteCompra) throws Exception {
    return transferenciaPredioIDAO.listaTransferenciaPredio( codTransferencia, codPredio, anio, codContribuyenteVenta, codContribuyenteCompra);
  }

}
