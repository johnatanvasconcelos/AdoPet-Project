package br.com.javapet.api.service;

import br.com.javapet.api.domain.Pet;
import br.com.javapet.api.repository.AbrigoRepository;
import br.com.javapet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private AbrigoRepository abrigoRepository;

    public List<Pet> listarTodos(){
        return petRepository.findAll();
    }

    public List<Pet> listarPorAbrigo(Long abrigoId){
        abrigoRepository.findById(abrigoId)
                .orElseThrow(() -> new RuntimeException("Abrigo não encontrado"));
        return petRepository.findByAbrigoId(abrigoId);
    }
}
