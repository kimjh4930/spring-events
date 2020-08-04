package io.github.kimjh4930.springevents.user.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {
    private static final long TEST_ID = 1L;
    private static final String TEST_NAME = "Junha";
    private static final NotificationSettings TEST_NOTIFICATION_SETTINGS = new NotificationSettings(true);

    @Test
    void join (){
        //given

        //when
        final User user = new User(TEST_ID, TEST_NAME, TEST_NOTIFICATION_SETTINGS);

        //then
        assertThat(user.getId()).isEqualTo(TEST_ID);
        assertThat(user.getName()).isEqualTo(TEST_NAME);
        assertThat(user.getNotificationSettings()).isEqualTo(TEST_NOTIFICATION_SETTINGS);
    }

}