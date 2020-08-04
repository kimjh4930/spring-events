package io.github.kimjh4930.springevents.user.infra;

import io.github.kimjh4930.springevents.user.application.MessageSender;
import io.github.kimjh4930.springevents.user.domain.SignedUpEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmailSenderTest {

    private static final String TEST_NAME = "Junha";

    @Autowired
    private MessageSender emailSender;

    @Test
    @DisplayName("이메일 발송")
    void sendEmail (){
        //given
        //when
        //then
        emailSender.sendCongratulation(new SignedUpEvent(TEST_NAME));
    }

}