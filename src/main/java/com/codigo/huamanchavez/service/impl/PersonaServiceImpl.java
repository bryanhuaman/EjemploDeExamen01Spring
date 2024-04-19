package com.codigo.huamanchavez.service.impl;

import com.codigo.huamanchavez.dao.PersonaRepository;
import com.codigo.huamanchavez.entity.PersonaEntity;
import com.codigo.huamanchavez.service.PersonaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;

    @Override
    public PersonaEntity crearPersona(PersonaEntity personaEntity) {
        return personaRepository.save(personaEntity);
    }

    @Override
    public Optional<PersonaEntity> buscarPorId(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public List<PersonaEntity> buscarTodos() {
        return personaRepository.findAll();
    }

    @Override
    public PersonaEntity actualizarPersona(Long id, PersonaEntity personaEntity) {
        Optional<PersonaEntity> personaRecuperada = personaRepository.findById(id);

        if(personaRecuperada.isPresent()){
            return personaRepository.save(getUpdate(personaRecuperada.get(),personaEntity));
        }

        return null;
    }

    //Metodo de apoyo
    private PersonaEntity getUpdate(PersonaEntity personaRecuperada, PersonaEntity personaController){
        personaRecuperada.setNombres(personaController.getNombres());
        personaRecuperada.setApellidos(personaController.getApellidos());
        personaRecuperada.setTipoDoc(personaController.getTipoDoc());
        personaRecuperada.setNumDoc(personaController.getNumDoc());
        personaRecuperada.setEstado(personaController.getEstado());
        return personaRecuperada;
    }


    @Override
    public PersonaEntity borrar(Long id) {
        Optional<PersonaEntity> personaRecuperada = personaRepository.findById(id);

        if(personaRecuperada.isPresent()){
            personaRecuperada.get().setEstado(0);
            return personaRepository.save(personaRecuperada.get());
        }

        return null;
    }
}
