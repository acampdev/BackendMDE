package gob.pe.muniesperanza.apprentasmdeapi.service;

import gob.pe.muniesperanza.apprentasmdeapi.model.Barrio;

import java.util.List;

public interface BarrioService {
  List<Barrio> listarBarrio();

  Barrio insertarBarrio(Barrio barrio);

  Barrio actualizarBarrio(Barrio barrio);
}
