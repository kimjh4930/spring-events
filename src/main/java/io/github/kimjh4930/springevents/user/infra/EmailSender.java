package io.github.kimjh4930.springevents.user.infra;

import io.github.kimjh4930.springevents.user.application.MessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EmailSender implements MessageSender {
    private final static Logger logger = LoggerFactory.getLogger(EmailSender.class);

    @Override
    public void sendCongratulation(String name) {
        logger.info("Join Step 3: Send a mail to {}", name);
    }
}
