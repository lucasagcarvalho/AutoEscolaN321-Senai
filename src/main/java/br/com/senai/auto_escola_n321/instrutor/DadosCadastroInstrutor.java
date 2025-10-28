package br.com.senai.auto_escola_n321.instrutor;

import br.com.senai.auto_escola_n321.endereco.DadosEndereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroInstrutor(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{10,11}")
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{9,11}")
        String cnh,
        @NotNull
        Especialidade especialidade,
        @NotNull
        DadosEndereco endereco
) {
}
