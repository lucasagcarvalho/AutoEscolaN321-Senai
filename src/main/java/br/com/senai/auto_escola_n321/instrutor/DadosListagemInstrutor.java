package br.com.senai.auto_escola_n321.instrutor;

public record DadosListagemInstrutor(
        Long id,
        String nome,
        String email,
        String cnh,
        Especialidade especialidade
) {

    public DadosListagemInstrutor(Instrutor instrutor) {
        this(instrutor.getId(), instrutor.getNome(), instrutor.getEmail(), instrutor.getCnh(), instrutor.getEspecialidade());
    }
}