package designpatterns.builder_pattern.student;

public class Student {
    private final int id;
    private final String name;
    private final String address;

    public Student(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
    }

    public static class Builder {
        private int id;
        private String name;
        private String address;

        public static Builder getInstance() {
            return new Builder();
        }
        private Builder() {}

        public Builder setId(final int id) {
            this.id = id;
            return this;
        }

        public Builder setName(final String name) {
            this.name = name;
            return this;
        }

        public Builder setAddress(final String address) {
            this.address = address;
            return this;
        }
        public Student build() {
            return new Student(this);
        }
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", name:" + name +
                ", address:" + address +
                "}";
    }
}
