package br.com.senai.autoescolan321.adapters.in.rabbitmq.message;

import java.util.List;

public record EmailEventMensagem(Long idAgenda, List<String> emails, String assunto, String mensagem) {

}