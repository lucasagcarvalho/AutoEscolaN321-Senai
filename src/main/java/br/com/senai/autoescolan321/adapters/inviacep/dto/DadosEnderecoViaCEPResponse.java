package br.com.senai.autoescolan321.adapters.inviacep.dto;

public record DadosEnderecoViaCEPResponse(
        String logradouro,
        String bairro,
        String cidade,
        String uf) {
}