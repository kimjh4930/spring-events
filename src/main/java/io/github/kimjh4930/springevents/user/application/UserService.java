package io.github.kimjh4930.springevents.user.application;

import io.github.kimjh4930.springevents.user.domain.SignedUpEvent;
import io.github.kimjh4930.springevents.user.domain.User;
import io.github.kimjh4930.springevents.user.domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final static Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private ApplicationEventPublisher publisher;

    public UserService(final UserRepository userRepository, final ApplicationEventPublisher publisher) {
        this.userRepository = userRepository;
        this.publisher = publisher;
    }

    public void join(final long id, final String name){
        logger.info("Join Step 1: Beginning");
        final User user = new User(id, name);

        logger.info("Join Step 2: Persistence");
        System.out.println("userRepository : " + userRepository);
        userRepository.save(user);

        publisher.publishEvent(new SignedUpEvent((user.getName())));

        logger.info("Join Step 5: Completed");
    }

    public List<String> lookup(){
        return userRepository.findAll()
            .stream()
            .map(User::getName)
            .collect(Collectors.toList());
    }

}
