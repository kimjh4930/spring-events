package io.github.kimjh4930.springevents.user.infra;

import io.github.kimjh4930.springevents.user.application.MessageSender;
import io.github.kimjh4930.springevents.user.domain.SignedUpEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class SmsSender implements MessageSender {
    private final static Logger logger = LoggerFactory.getLogger(SmsSender.class);

    @EventListener(condition = "#event.notificationSettings.receiving")
    @Order(value = 2)
    @Override
    public void sendCongratulation(SignedUpEvent event) {
        logger.info("Join Step 4: Send a SMS to {}", event.getName());
    }
}
