package strings;

import java.util.Objects;

public class ComponentId {
    private int id;
    private String lastUpdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComponentId that = (ComponentId) o;
        return id == that.id && Objects.equals(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastUpdate);
    }

    @Override
    public String toString() {
        return "ComponentId{" +
                "id=" + id +
                ", lastUpdate='" + lastUpdate + '\'' +
                '}';
    }
}
