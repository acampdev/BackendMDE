package gob.pe.muniesperanza.apprentasmdeapi.controller;


//import org.apache.commons.lang3.StringUtils;



import gob.pe.muniesperanza.apprentasmdeapi.bean.ResponseVO;
//import gob.pe.muniesperanza.apprentasmdeapi.util.Constantes;
import gob.pe.muniesperanza.apprentasmdeapi.util.Constantes;
import io.micrometer.common.util.StringUtils;


public abstract class AbstractRestController {


  public  ResponseVO buildResponse(boolean estado, Object data, String message, Exception e) {

    ResponseVO response = new ResponseVO();
    response.setData(data);
    response.setMessage("");

    if(estado) {
      if(StringUtils.isBlank(message)){
        response.setMessage(Constantes.MESSAGE_SUCCESS);
  //      response.setMessage("Operation Success!");
      }else{
        response.setMessage(message.toString());
      }

      response.setSuccess(true);
    }else {
      if(e == null) {
        response.setMessage(message.toString());
      }else {
        response.setMessage(Constantes.MESSAGE_ERROR.concat(e.getMessage()));
       // response.setMessage("Operation Failed!".concat(e.getMessage()));
      }

      response.setSuccess(false);
    }

    return response;
  }
}

