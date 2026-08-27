package gob.pe.muniesperanza.apprentasmdeapi.util;

import java.io.Serializable;


/**
 * @Nombre: ClsConstantes
 * @NombreTabla: --
 * @author
 * @FechaCreación: 01/06/2025 18:00H
 * @Descripcion: Clase que permite el manejo de las constantes en el aplicativo.
 */
public class Constantes implements Serializable {


  private static final long serialVersionUID = 1L;

  public static final Character ESTADO_ACTIVO = '0';
  public static final Character ESTADO_INACTIVO = '1';

  public static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W]).{8,20})";

  public static final String MESSAGE_SUCCESS = "Operation Success!";
  public static final String MESSAGE_ERROR = "Operation Failed!";

  public final static boolean STATUS_SUCCESS = Boolean.TRUE;
  public final static boolean STATUS_ERROR = Boolean.FALSE;

  public final static String MESSAGE_ERROR_500 = "Estamos teniendo problemas. Por favor comunniquese con el administrador del sistema.";



 }

