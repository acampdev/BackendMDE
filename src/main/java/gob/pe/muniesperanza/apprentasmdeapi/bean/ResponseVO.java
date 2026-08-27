package gob.pe.muniesperanza.apprentasmdeapi.bean;


import java.io.Serializable;


/**
 * @autor: Henry paredes, jhonathan, boris
 * @modificado:
 * @descripción: {Clase bean para Responder}
 *
 **/
public class ResponseVO implements Serializable{

  private static final long serialVersionUID = 1L;

  private boolean success;
  private String message;
  private Object data;

  private Integer pagina;
  private Integer limite;

  private Integer totalPaginas;
  private Long totalRegistros;

  public ResponseVO() {
    super();
    // TODO Auto-generated constructor stub
  }

  public ResponseVO(boolean success, String message, Object data){
    this.success = success;
    this.message = message;
    this.data = data;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public Integer getPagina() {
    return pagina;
  }

  public void setPagina(Integer pagina) {
    this.pagina = pagina;
  }

  public Integer getLimite() {
    return limite;
  }

  public void setLimite(Integer limite) {
    this.limite = limite;
  }

  public Integer getTotalPaginas() {
    return totalPaginas;
  }

  public void setTotalPaginas(Integer totalPaginas) {
    this.totalPaginas = totalPaginas;
  }

  public Long getTotalRegistros() {
    return totalRegistros;
  }

  public void setTotalRegistros(Long totalRegistros) {
    this.totalRegistros = totalRegistros;
  }

}

