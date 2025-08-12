package br.com.javapet.api.controller;

import br.com.javapet.api.domain.Pet;
import br.com.javapet.api.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<List<Pet>> listarTodos(){
        List<Pet> todosOsPets = petService.listarTodos();
        return ResponseEntity.ok(todosOsPets);

    }
}
