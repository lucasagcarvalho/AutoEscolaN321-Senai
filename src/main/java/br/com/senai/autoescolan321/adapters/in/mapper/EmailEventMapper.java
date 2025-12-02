package br.com.senai.autoescolan321.adapters.in.mapper;

import br.com.senai.autoescolan321.adapters.in.rabbitmq.message.EmailEventMensagem;
import br.com.senai.autoescolan321.adapters.out.rabbitmq.events.EmailOcorrenciaEvent;
import org.springframework.stereotype.Component;

@Component
public class EmailEventMapper {
    public static EmailOcorrenciaEvent toDomain(EmailEventMensagem msg) {
        return new EmailOcorrenciaEvent(
                msg.idAgenda(),
                msg.emails(),
                msg.assunto(),
                msg.mensagem()
        );
    }
}
