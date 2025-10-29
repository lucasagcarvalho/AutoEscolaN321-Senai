package br.com.senai.auto_escola_n321.controller;

import br.com.senai.auto_escola_n321.instrutor.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {

    @Autowired
    private InstrutorRepository instrutorRepository;

    @PostMapping
    @Transactional
    public void cadastrarInstrutor(@RequestBody @Valid DadosCadastroInstrutor dados) {

        instrutorRepository.save(new Instrutor(dados));
    }

    @GetMapping
    public Page<DadosListagemInstrutor> listarInstrutores(@PageableDefault(size = 10, sort = {"nome"}) Pageable page, Sort sort) {
        return instrutorRepository.findAll(page).map(DadosListagemInstrutor::new);
    }

    @PutMapping
    @Transactional
    public void AtualizarInstrutor(@RequestBody @Valid DadosAtualizacaoInstrutor dados) {
        Instrutor instrutor = instrutorRepository.getReferenceById(dados.id());

        instrutor.atualizarInformacoes (dados);
    }
}