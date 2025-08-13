package br.com.javapet.api.controller;

import br.com.javapet.api.domain.Abrigo;
import br.com.javapet.api.domain.Pet;
import br.com.javapet.api.dto.AbrigoRequest;
import br.com.javapet.api.dto.AbrigoResponse;
import br.com.javapet.api.service.AbrigoService;
import br.com.javapet.api.service.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abrigos")
public class AbrigoController {

    @Autowired
    private AbrigoService abrigoService;

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<List<AbrigoResponse>> listar(){
        List<AbrigoResponse> abrigosResponse = abrigoService.listar();
        return ResponseEntity.ok(abrigosResponse);
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody @Valid AbrigoRequest abrigoRequest){
            abrigoService.cadastrar(abrigoRequest);
            return ResponseEntity.ok("Abrigo cadastrado com sucesso!");
    }

    @GetMapping("/{abrigoId}/pets")
    public ResponseEntity<List<Pet>> listarPetsPorAbrigo(@PathVariable Long abrigoId){
            List<Pet> pets = petService.listarPorAbrigo(abrigoId);
            return ResponseEntity.ok(pets);

    }
}
