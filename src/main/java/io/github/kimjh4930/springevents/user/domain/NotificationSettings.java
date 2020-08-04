package io.github.kimjh4930.springevents.user.domain;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class NotificationSettings {
    private boolean receiving;

    protected NotificationSettings () { }

    public NotificationSettings(final boolean receiving) {
        this.receiving = receiving;
    }

    public boolean isReceiving() {
        return receiving;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationSettings that = (NotificationSettings) o;
        return receiving == that.receiving;
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiving);
    }
}
