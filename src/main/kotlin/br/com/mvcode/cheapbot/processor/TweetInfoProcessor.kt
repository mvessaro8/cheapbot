package br.com.mvcode.cheapbot.processor

import br.com.mvcode.cheapbot.model.TweetInfo
import org.apache.camel.Exchange
import org.apache.camel.Processor
import twitter4j.Status

class TweetInfoProcessor : Processor {
    override fun process(exchange: Exchange) {
        val tweet = exchange.getIn().body as Status
        val tweetEntity = TweetInfo(tweet.id, tweet.text, tweet.createdAt)
        exchange.getIn().body = tweetEntity
    }
}