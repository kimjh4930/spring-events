package io.github.kimjh4930.springevents.user.application;

import io.github.kimjh4930.springevents.user.domain.SignedUpEvent;
import io.github.kimjh4930.springevents.user.domain.User;
import io.github.kimjh4930.springevents.user.domain.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    private static final long TEST_ID = 1L;
    private static final String TEST_NAME = "Junha";

    @Mock private UserRepository userRepository;
    @Mock private ApplicationEventPublisher publisher;
    @Captor private ArgumentCaptor<Object> publishEventCaptor;

    private UserService userService;

    @BeforeEach
    void setup (){
        this.userService = new UserService(userRepository, publisher);
    }

    @DisplayName("회원가입")
    @Test
    void join(){
        //given
        //when
        userService.join(TEST_ID, TEST_NAME);

        //then
        verify(userRepository).save(any(User.class));
        verifyPublishedEvents(new SignedUpEvent((TEST_NAME)));
    }

    @DisplayName("회원조회")
    @Test
    void findAll(){
        //given
        given(userRepository.findAll())
            .willReturn(Arrays.asList(new User(TEST_ID, TEST_NAME)));

        //when
        final List<String> userNames = userService.lookup();

        //then
        assertThat(userNames).containsExactly(TEST_NAME);
    }

    private void verifyPublishedEvents (final Object... events){
        verify(publisher, times(events.length)).publishEvent(publishEventCaptor.capture());
        assertThat(publishEventCaptor.getAllValues()).contains(events);
    }
}