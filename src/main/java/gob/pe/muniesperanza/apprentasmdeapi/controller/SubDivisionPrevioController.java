package gob.pe.muniesperanza.apprentasmdeapi.controller;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ResponseVO;
import gob.pe.muniesperanza.apprentasmdeapi.bean.SubDivisionPrevioBean;
import gob.pe.muniesperanza.apprentasmdeapi.service.SubDivisionPrevioService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import gob.pe.muniesperanza.apprentasmdeapi.util.Constantes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/subDivisionPrevio")
@RequiredArgsConstructor
public class SubDivisionPrevioController extends AbstractRestController {

    @Autowired
    private SubDivisionPrevioService subDivisionPrevioService;

    @PostMapping
    public ResponseEntity<ResponseVO> subDivisionPrevio(@RequestBody SubDivisionPrevioBean subDivisionPrevioBean) throws Exception {
        ResponseVO result = null;
        String mensaje = "";
        try {
            ClsResultDAO clsResultDAO = subDivisionPrevioService.subDivisionPrevio(subDivisionPrevioBean);
            BigDecimal codigoResp = new BigDecimal(String.valueOf(clsResultDAO.get(ClsResultDAO.CODIGO_RESPUESTA)));
            if (codigoResp.intValue() == 1) {
                // String codigoVia = (String) clsResultDAO.get("INSERTADO");
                mensaje = (String) clsResultDAO.get(ClsResultDAO.MENSAJE_RESPUESTA);
                result = buildResponse(Boolean.TRUE, mensaje, null, null);
            } else {
                mensaje = (String) clsResultDAO.get(ClsResultDAO.MENSAJE_RESPUESTA);
                result = buildResponse(Constantes.STATUS_ERROR, mensaje, Constantes.MESSAGE_ERROR, null);
            }

        } catch (Exception e) {
            // logger.error(e.getMessage(), e);
            result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
