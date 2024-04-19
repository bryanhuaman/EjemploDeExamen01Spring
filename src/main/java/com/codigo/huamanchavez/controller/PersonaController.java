package com.codigo.huamanchavez.controller;

import com.codigo.huamanchavez.entity.PersonaEntity;
import com.codigo.huamanchavez.service.PersonaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/examen/v1/persona")
@AllArgsConstructor
@Tag(
        name = "API DE MANTENIMIENTO PERSONAS",
        description = "Esta api contiene todos los end poins para realizar el mantenimiento de la entidad persona"
)
public class PersonaController {

    private final PersonaService personaService;

    @PostMapping("/crear")
    @Operation(summary = "Crear una nueva Persona")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Persona creada exitosamente",
            content = {@Content(mediaType = "application/json",
            schema = @Schema(implementation = PersonaEntity.class))
            })
    })
    public ResponseEntity<PersonaEntity> crearPersona(@RequestBody PersonaEntity personaEntity){
        return ResponseEntity.ok(personaService.crearPersona(personaEntity));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Persona por Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Persona buscada exitosamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PersonaEntity.class))
                    })
    })
    public ResponseEntity<Optional<PersonaEntity>> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(personaService.buscarPorId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<PersonaEntity>> buscartodos(){
        return ResponseEntity.ok(personaService.buscarTodos());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PersonaEntity> actualizarPersona(@PathVariable Long id,@RequestBody PersonaEntity personaEntity){
        return ResponseEntity.ok(personaService.actualizarPersona(id,personaEntity));
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<PersonaEntity> eliminarPersona(@PathVariable Long id){
        return ResponseEntity.ok(personaService.borrar(id));
    }

}
