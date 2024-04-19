package com.codigo.huamanchavez.dao;

import com.codigo.huamanchavez.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {
}
