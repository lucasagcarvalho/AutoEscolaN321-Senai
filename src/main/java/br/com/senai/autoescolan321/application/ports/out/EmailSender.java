package br.com.senai.autoescolan321.application.ports.out;

public interface EmailSender {

    void enviar (String destinatario, String assunto, String conteudo);

}
