package io.github.kimjh4930.springevents.user.domain;

import java.util.Objects;

public class SignedUpEvent {
    private final String name;

    public SignedUpEvent(String name) {
        this.name = name;
    }

    public String getName (){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SignedUpEvent that = (SignedUpEvent) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
