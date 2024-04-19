package com.codigo.huamanchavez.service;

import com.codigo.huamanchavez.entity.PersonaEntity;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    PersonaEntity crearPersona (PersonaEntity personaEntity);
    Optional<PersonaEntity> buscarPorId(Long id);
    List<PersonaEntity> buscarTodos();
    PersonaEntity actualizarPersona(Long id, PersonaEntity personaEntity);
    PersonaEntity borrar(Long id);
}
