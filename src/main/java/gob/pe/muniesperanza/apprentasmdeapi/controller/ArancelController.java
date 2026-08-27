package gob.pe.muniesperanza.apprentasmdeapi.controller;

import gob.pe.muniesperanza.apprentasmdeapi.bean.ArancelBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ContribuyenteBean;
import gob.pe.muniesperanza.apprentasmdeapi.bean.ResponseVO;
import gob.pe.muniesperanza.apprentasmdeapi.model.Via;
import gob.pe.muniesperanza.apprentasmdeapi.service.ArancelService;
import gob.pe.muniesperanza.apprentasmdeapi.service.ViaService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import gob.pe.muniesperanza.apprentasmdeapi.util.Constantes;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/arancel")
@RequiredArgsConstructor
public class ArancelController   extends AbstractRestController {
    @Autowired
    private ArancelService arancelService;
    @PostMapping
    public ResponseEntity<ResponseVO> insertarArancel(@RequestBody ArancelBean arancelBean) throws Exception {
        ResponseVO result = null;
        String mensaje = "";
        try {
            ClsResultDAO clsResultDAO =arancelService.insertarArancel(arancelBean);
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

    @PutMapping
    public ResponseEntity<ResponseVO> actualizarArancel(@RequestBody ArancelBean arancelBean) throws Exception {

        ResponseVO result = null;
        String mensaje = StringUtils.EMPTY;

        try {

            ClsResultDAO clsResultDAO =arancelService.actualizarArancel(arancelBean);

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
            //log.error(e.getMessage(), e);

            result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        result = buildResponse(Constantes.STATUS_SUCCESS, null, mensaje, null);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ResponseVO> listarArancel(@RequestParam("anio") String anio,
                                                    @RequestParam("parametroBusqueda")  String parametroBusqueda) throws Exception {

        ResponseVO result = null;
        List<ArancelBean> arancelBeanList = new ArrayList<ArancelBean>();
        try {
           Integer anioTmp=null;
           String parametroBusquedaTmp=null;
            if(anio !=null && !anio.isEmpty())
                anioTmp=Integer.parseInt(anio);
            if(parametroBusqueda !=null && !parametroBusqueda.isEmpty())
                parametroBusquedaTmp=parametroBusqueda;

            arancelBeanList = arancelService.listarArancel(anioTmp,parametroBusquedaTmp);

        } catch (Exception e) {
            //   log.error(e.getMessage(), e);

            result = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        result = buildResponse(Constantes.STATUS_SUCCESS, arancelBeanList, null, null);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
