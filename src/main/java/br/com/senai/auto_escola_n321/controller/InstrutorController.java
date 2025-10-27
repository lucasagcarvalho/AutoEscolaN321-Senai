package br.com.senai.auto_escola_n321.controller;

import br.com.senai.auto_escola_n321.instrutor.DadosCadastroInstrutor;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {

    @PostMapping
    public void cadastrarInstrutor(@RequestBody @Valid DadosCadastroInstrutor dados){

        System.out.println(dados);
    }
}
