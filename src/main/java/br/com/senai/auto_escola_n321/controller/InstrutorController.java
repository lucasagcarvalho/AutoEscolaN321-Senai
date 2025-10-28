package br.com.senai.auto_escola_n321.controller;

import br.com.senai.auto_escola_n321.instrutor.DadosCadastroInstrutor;
import br.com.senai.auto_escola_n321.instrutor.Instrutor;
import br.com.senai.auto_escola_n321.instrutor.InstrutorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {

    @Autowired
    private InstrutorRepository instrutorRepository;

    @PostMapping
    public void cadastrarInstrutor(@RequestBody @Valid DadosCadastroInstrutor dados){

        instrutorRepository.save(new Instrutor(dados));
    }
}
