package io.github.kimjh4930.springevents.user.domain;

import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User {

    @Id
    private Long id;
    private String name;

    protected User (){ }

    public User(Long id, String name) {
        verifyUserName(name);

        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
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
