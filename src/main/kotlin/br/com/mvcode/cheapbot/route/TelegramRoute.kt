package br.com.mvcode.cheapbot.route

import br.com.mvcode.cheapbot.processor.TelegramProcessor
import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component

@Component
class TelegramRoute : RouteBuilder() {
    override fun configure() {
        from("telegram:bots")
                .id("TelegramRoute")
                .bean(TelegramProcessor())
                .log("\${body}")
                .to("telegram:bots")
    }
}