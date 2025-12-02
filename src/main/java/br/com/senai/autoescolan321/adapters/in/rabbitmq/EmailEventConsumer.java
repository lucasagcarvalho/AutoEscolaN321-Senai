    package br.com.senai.autoescolan321.adapters.in.rabbitmq;

    import br.com.senai.autoescolan321.adapters.in.mapper.EmailEventMapper;
    import br.com.senai.autoescolan321.adapters.in.rabbitmq.message.EmailEventMensagem;
    import br.com.senai.autoescolan321.adapters.out.rabbitmq.events.EmailOcorrenciaEvent;
    import br.com.senai.autoescolan321.application.ports.out.EmailSender;
    import org.springframework.amqp.rabbit.annotation.RabbitListener;
    import org.springframework.stereotype.Component;

    @Component
    public class EmailEventConsumer {

        private final EmailSender emailSender;

        private final EmailEventMapper emailEventMapper;

        public EmailEventConsumer(EmailEventMapper emailEventMapper,  EmailSender emailSender) {
            this.emailEventMapper = emailEventMapper;
            this.emailSender = emailSender;
        }

        @RabbitListener(queues = "email.ocorrencia")
        public void ReceberMensagem(EmailEventMensagem mensagem) {
            EmailOcorrenciaEvent event = EmailEventMapper.toDomain(mensagem);
            System.out.println("Consumindo event: " + event);

            for (String email : event.emails()){
            emailSender.enviar(email, event.assunto(), event.mensagem());
        }}
    }