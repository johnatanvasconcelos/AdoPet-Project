package br.com.javapet.api.repository;

import br.com.javapet.api.domain.Abrigo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbrigoRepository extends JpaRepository<Abrigo, Long> {
}
