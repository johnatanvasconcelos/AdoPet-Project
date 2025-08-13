package br.com.javapet.api.mapper;

import br.com.javapet.api.domain.Abrigo;
import br.com.javapet.api.dto.AbrigoRequest;
import br.com.javapet.api.dto.AbrigoResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AbrigoMapper {

    public Abrigo toEntity(AbrigoRequest request){
        return new Abrigo(request.nome(), request.telefone(), request.email());
    }

    public AbrigoResponse toResponse(Abrigo abrigo){
        return new AbrigoResponse(abrigo.getId(), abrigo.getNome(), abrigo.getTelefone(), abrigo.getEmail());
    }

    public List<AbrigoResponse> toResponseList(List<Abrigo> abrigos){
        return abrigos.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
