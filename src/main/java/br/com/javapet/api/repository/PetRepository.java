package br.com.javapet.api.repository;

import br.com.javapet.api.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByAbrigoId(Long abrigoId);
}
