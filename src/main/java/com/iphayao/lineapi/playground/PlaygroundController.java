package com.iphayao.lineapi.playground;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@LineMessageHandler
public class PlaygroundController {
    @Autowired
    private LineMessagingClient lineMessagingClient;

    @EventMapping
    public Message handleTextMessage(MessageEvent<TextMessageContent> event) {
        log.info("event: {}", event);
        final String message = event.getMessage().getText();
        return new TextMessage(message);
    }

    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        log.info("event: {}", event);
    }
}
