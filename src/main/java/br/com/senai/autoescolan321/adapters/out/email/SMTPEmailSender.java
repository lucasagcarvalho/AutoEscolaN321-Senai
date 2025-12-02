package br.com.senai.autoescolan321.adapters.out.email;

import br.com.senai.autoescolan321.application.ports.out.EmailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SMTPEmailSender implements EmailSender {

    private final JavaMailSender mailSender;

    public SMTPEmailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void enviar(String destinatario, String assunto, String conteudo) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(destinatario);
            message.setSubject(assunto);
            message.setText(conteudo);
            mailSender.send(message);
            System.out.println("Email enviado com sucesso para: " + destinatario);
        } catch (Exception e) {
            System.err.println("Erro ao enviar email para: " + destinatario);
            e.printStackTrace();
        }
    }
}