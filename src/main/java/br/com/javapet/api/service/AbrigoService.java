package br.com.javapet.api.service;

import br.com.javapet.api.domain.Abrigo;
import br.com.javapet.api.dto.AbrigoRequest;
import br.com.javapet.api.dto.AbrigoResponse;
import br.com.javapet.api.mapper.AbrigoMapper;
import br.com.javapet.api.repository.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository abrigoRepository;

    @Autowired
    private AbrigoMapper abrigoMapper;

    public List<AbrigoResponse> listar() {
        List<Abrigo> abrigos = abrigoRepository.findAll();
        return abrigoMapper.toResponseList(abrigos);
    }

    public void cadastrar(AbrigoRequest abrigoRequest) {
        Abrigo abrigo = abrigoMapper.toEntity(abrigoRequest);
        abrigoRepository.save(abrigo);
    }
}
