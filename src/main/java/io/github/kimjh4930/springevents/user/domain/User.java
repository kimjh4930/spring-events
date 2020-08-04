package io.github.kimjh4930.springevents.user.domain;

import org.springframework.util.StringUtils;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User {

    @Id
    private Long id;
    private String name;

    @Embedded
    private NotificationSettings notificationSettings;

    protected User (){ }

    public User(final Long id, final String name, final NotificationSettings notificationSettings) {
        verifyUserName(name);

        this.id = id;
        this.name = name;
        this.notificationSettings = notificationSettings;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public NotificationSettings getNotificationSettings (){
        return notificationSettings;
    }

    private void verifyUserName (String name){
        if(StringUtils.isEmpty(name)){
            throw new UserNameException("이름을 입력해주세요.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
            Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
