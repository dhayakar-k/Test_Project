package designpatterns.builder_pattern.builders;

public class BuilderPattern {

    static class Coffee {
        private String type;
        private boolean sugar;
        private boolean milk;
        private String size;
        private Coffee(final Builder builder) {
                this.type = builder.type;
                this.sugar = builder.sugar;
                this.milk = builder.milk;
                this.size = builder.size;
        }
        public static class Builder {
            private String type;
            private boolean sugar;
            private boolean milk;
            private String size;

            public Builder(final String type) {
                    this.type = type;
            }

            public Builder sugar(final boolean sugar) {
                this.sugar = sugar;
                return this;
            }

            public Builder milk(final boolean milk) {
                this.milk = milk;
                return this;
            }

            public Builder size(final String size) {
                this.size = size;
                return this;
            }

            public Coffee build() {
                return new Coffee(this);
            }
        }

        @Override
        public String toString() {
            return "{" +
                    "\"type\":" + type +","+
                    "\"sugar\":" + sugar + ","+
                    "\"milk\":" + milk + ","+
                    "\"size\":" + size +
                    "}";
        }
    }

    public static void main(String[] args) {
        final Coffee coffee = new BuilderPattern.Coffee.Builder("Mocha").milk(true).sugar(true).size("Large").build();
        System.out.println("Prepared Coffee is "+coffee);
    }

}
