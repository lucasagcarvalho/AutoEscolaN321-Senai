package br.com.senai.autoescolan321.application.ports.out;

import br.com.senai.autoescolan321.adapters.out.rabbitmq.events.EmailOcorrenciaEvent;

public interface EmailEventPublisher {
    void publicar(EmailOcorrenciaEvent event);
}
