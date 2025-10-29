package br.com.senai.auto_escola_n321.controller;

import br.com.senai.auto_escola_n321.aluno.*;
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
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    @Transactional
    public void cadastrarAluno(@RequestBody @Valid DadosCadastroAluno dados) {

        alunoRepository.save(new Aluno(dados));
    }

    @GetMapping
    public Page<DadosListagemAluno> listarAlunos(@PageableDefault(size = 10, sort = {"nome"}) Pageable page, Sort sort) {
        return alunoRepository.findAll(page).map(DadosListagemAluno::new);
    }

    @PutMapping
    @Transactional
    public void AtualizarInstrutor(@RequestBody @Valid DadosAtualizacaoAluno dados) {
        Aluno aluno = alunoRepository.getReferenceById(dados.id());

        aluno.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void ExcluirInstrutor(@PathVariable Long id) {
        Aluno aluno = alunoRepository.getReferenceById(id);
        aluno.excluir();
    }
}