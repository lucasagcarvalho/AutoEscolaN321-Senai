package br.com.senai.auto_escola_n321.instrutor;

import br.com.senai.auto_escola_n321.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoInstrutor(

        @NotNull
        Long id,
        String nome,
        String telefone,
        Especialidade especialidade,
        DadosEndereco endereco
) {
}
