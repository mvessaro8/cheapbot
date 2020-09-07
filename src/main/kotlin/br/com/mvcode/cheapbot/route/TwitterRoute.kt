package br.com.mvcode.cheapbot.route

import org.apache.camel.builder.RouteBuilder
import br.com.mvcode.cheapbot.processor.TweetInfoProcessor
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class TwitterRoute : RouteBuilder() {

    @Value("\${app.twitter.delay}")
    protected var delay = 0

    @Value("\${app.twitter.user}")
    protected var user: String? = null

    override fun configure() {
        fromF("twitter-timeline:USER?user=%s&delay=%s", user, delay)
                .id("TwitterRoute")
                .log("Received Status")
                .process(TweetInfoProcessor())
                .log("Status transformed into TweetEntity - \${body}")
    }
}