package io.github.kimjh4930.springevents.user.infra;

import io.github.kimjh4930.springevents.user.application.MessageSender;
import io.github.kimjh4930.springevents.user.domain.SignedUpEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SmsSenderTest {

    private static final String TEST_NAME = "Junha";

    @Autowired
    private MessageSender smsSender;

    @Test
    @DisplayName("SMS 발송")
    void sendSMS (){
        //given
        //when
        //then
        smsSender.sendCongratulation(new SignedUpEvent(TEST_NAME));
    }

}