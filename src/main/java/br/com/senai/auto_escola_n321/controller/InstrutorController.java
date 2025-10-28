package br.com.senai.auto_escola_n321.controller;

import br.com.senai.auto_escola_n321.instrutor.DadosCadastroInstrutor;
import br.com.senai.auto_escola_n321.instrutor.Instrutor;
import br.com.senai.auto_escola_n321.instrutor.InstrutorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {

    @Autowired
    private InstrutorRepository instrutorRepository;

    @PostMapping
    public void cadastrarInstrutor(@RequestBody @Valid DadosCadastroInstrutor dados){

        instrutorRepository.save(new Instrutor(dados));
    }

    @GetMapping
    public List<Instrutor> listarInstrutores(){
        return instrutorRepository.findAll();
    }
}