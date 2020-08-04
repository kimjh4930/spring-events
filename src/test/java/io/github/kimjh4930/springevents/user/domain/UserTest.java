package io.github.kimjh4930.springevents.user.domain;

import org.junit.jupiter.api.Test;

class UserTest {
    private static final long TEST_ID = 1L;
    private static final String TEST_NAME = "Junha";

    @Test
    void join (){
        //given

        //when
        final User user = new User(TEST_ID, TEST_NAME);

        //then

    }

}