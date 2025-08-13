package br.com.javapet.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AbrigoRequest(
        @NotBlank(message = "O nome do abrigo é obrigatório.")
        String nome,
        @NotBlank(message = "O telefone é obrigatório.")
        @Pattern(regexp = "\\d{10,11}", message = "O número do telefone deve conter entre 10 e 11 dígitos.")
        String telefone,
        @NotBlank(message = "O e-mail é obrigatório.")
        @Email(message = "Formato do e-mail inválido.")
        String email

) {
}
