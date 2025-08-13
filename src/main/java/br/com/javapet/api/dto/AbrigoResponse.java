package br.com.javapet.api.dto;

public record AbrigoResponse(
        Long id,
        String nome,
        String telefone,
        String email
) {
}
