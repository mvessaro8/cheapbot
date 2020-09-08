package br.com.mvcode.cheapbot.processor

import org.apache.camel.Exchange
import org.apache.camel.Processor
import org.apache.camel.component.telegram.model.IncomingMessage

class TelegramProcessor : Processor {
    override fun process(exchange: Exchange) {
        val incomingMessage = exchange.getIn().body as IncomingMessage
        val responseMessage = "You typed: ${incomingMessage.text}"
        exchange.getIn().body = responseMessage
    }
}