package br.com.senai.auto_escola_n321.aluno;

import br.com.senai.auto_escola_n321.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAluno(

        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}