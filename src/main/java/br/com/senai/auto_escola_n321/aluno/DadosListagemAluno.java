package br.com.senai.auto_escola_n321.aluno;

public record DadosListagemAluno(
        Long id,
        String nome,
        String email,
        String cpf
) {

    public DadosListagemAluno(Aluno instrutor) {
        this(instrutor.getId(), instrutor.getNome(), instrutor.getEmail(), instrutor.getCpf());
    }
}