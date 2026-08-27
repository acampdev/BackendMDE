package gob.pe.muniesperanza.apprentasmdeapi.repository;

import gob.pe.muniesperanza.apprentasmdeapi.model.Barrio;

import java.util.List;

public interface BarrioIDAO {
  List<Barrio> listarBarrio();

  Barrio insertarBarrio(Barrio barrio);

  Barrio actualizarBarrio(Barrio barrio);
}
