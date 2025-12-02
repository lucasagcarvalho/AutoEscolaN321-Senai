package br.com.senai.autoescolan321.adapters.out.rabbitmq;

import br.com.senai.autoescolan321.adapters.out.rabbitmq.events.EmailOcorrenciaEvent;
import br.com.senai.autoescolan321.application.ports.out.EmailEventPublisher;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQEmailEventPublisher implements EmailEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQEmailEventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void publicar(EmailOcorrenciaEvent event) {
        rabbitTemplate.convertAndSend("email.ocorrencia", event);
    }
}
