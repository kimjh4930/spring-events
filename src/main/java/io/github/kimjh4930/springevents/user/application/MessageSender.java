package io.github.kimjh4930.springevents.user.application;

import io.github.kimjh4930.springevents.user.domain.SignedUpEvent;

public interface MessageSender {
    void sendCongratulation(SignedUpEvent event);
}
