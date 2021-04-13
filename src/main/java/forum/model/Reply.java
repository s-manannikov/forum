package forum.model;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Objects;

public class Reply {
    private int id;
    private String desc;
    private LocalDateTime created;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reply reply = (Reply) o;
        return id == reply.id && Objects.equals(desc, reply.desc) && Objects.equals(created, reply.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, desc, created);
    }
}
