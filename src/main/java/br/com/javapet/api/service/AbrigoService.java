package br.com.javapet.api.service;

import br.com.javapet.api.domain.Abrigo;
import br.com.javapet.api.repository.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository abrigoRepository;

    public List<Abrigo> listar() {
        return abrigoRepository.findAll();
    }

    public void cadastrar(Abrigo abrigo) {
        abrigoRepository.save(abrigo);
    }
}
