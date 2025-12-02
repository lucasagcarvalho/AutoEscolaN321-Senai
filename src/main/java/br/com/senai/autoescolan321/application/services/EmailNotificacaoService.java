package br.com.senai.autoescolan321.application.services;

import br.com.senai.autoescolan321.adapters.out.rabbitmq.events.EmailOcorrenciaEvent;
import br.com.senai.autoescolan321.application.core.domain.model.Instrucao;
import br.com.senai.autoescolan321.application.ports.out.EmailEventPublisher;

import java.util.List;

public class EmailNotificacaoService {

    private final EmailEventPublisher emailEventPublisher;

    public EmailNotificacaoService(EmailEventPublisher emailEventPublisher) {
        this.emailEventPublisher = emailEventPublisher;
    }

    public void enviarNotificacao(Instrucao instrucao, String acao) {
        List<String> emails = List.of(
                "teste@teste.com",
                instrucao.getAluno().getEmail(),
                instrucao.getInstrutor().getEmail()
        );
        String assunto = "Instrução" + acao.toUpperCase();

        String mensagem = "A instrução do aluno" + instrucao.getAluno().getNome() + "foi " + acao;
        EmailOcorrenciaEvent event = new EmailOcorrenciaEvent(
                instrucao.getId(),
                emails,
                assunto,
                mensagem
        );
        emailEventPublisher.publicar(event);
    }
}