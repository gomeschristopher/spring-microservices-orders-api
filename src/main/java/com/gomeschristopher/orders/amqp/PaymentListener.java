package com.gomeschristopher.orders.amqp;

import com.gomeschristopher.orders.dto.PaymentDTO;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentListener {

    @RabbitListener(queues = "pagamentos.detalhes-pedido")
    public void receiveMessage(PaymentDTO payment) {
        if(payment.name().equals("ErrorPayment")) {
            throw new RuntimeException("Pagamento com erro");
        }

        String message = "Pagamento recebido: " + payment.id() +
                ", Pedido ID: " + payment.orderId() +
                ", Status: " + payment.status() +
                ", Valor: " + payment.value();
        System.out.println("Mensagem recebida: " + message);
    }
}
