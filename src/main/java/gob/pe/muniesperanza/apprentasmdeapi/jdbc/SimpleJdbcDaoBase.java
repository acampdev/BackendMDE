package gob.pe.muniesperanza.apprentasmdeapi.jdbc;

import gob.pe.muniesperanza.apprentasmdeapi.bean.AsignacionPredioBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Clase base abstracta para DAOs que proporciona acceso simplificado a la base de datos
 * utilizando {@link JdbcTemplate} y {@link NamedParameterJdbcTemplate}.
 *
 * <p>Esta clase se debe extender para implementar DAOs específicos que necesiten
 * interactuar con la base de datos. Inyecta un {@link DataSource} configurado en el contexto
 * de Spring para inicializar los componentes JDBC.</p>
 *
 */
public abstract class SimpleJdbcDaoBase {

  /**
   * Utilidad principal de acceso a base de datos basada en consultas SQL estándar.
   */
  protected final JdbcTemplate jdbcTemplate;

  /**
   * Variante de {@link JdbcTemplate} que permite el uso de parámetros con nombre en consultas SQL.
   */
  protected final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  /**
   * Fuente de datos (conexión a base de datos) inyectada por Spring.
   */
  protected final DataSource dataSource;

  /**
   * Constructor que inicializa los componentes JDBC con el {@link DataSource} proporcionado.
   *
   * @param dataSource el origen de datos configurado, usualmente proporcionado por Spring
   */
  public SimpleJdbcDaoBase(@Qualifier("dataSource") DataSource dataSource) {
    this.dataSource = dataSource;
    this.jdbcTemplate = new JdbcTemplate(dataSource);
    this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
  }

}
