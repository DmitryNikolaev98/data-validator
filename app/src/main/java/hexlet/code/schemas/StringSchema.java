package hexlet.code.schemas;

public class StringSchema {
        private boolean required;
        private Integer minLength;
        private String contains;

        public boolean isValid(String str) {
                if (required && (str == null || str.isEmpty())) {
                        return false;
                }
                if (minLength != null && str.length() < minLength) {
                        return false;
                }
                if (contains != null && !str.contains(contains)) {
                        return false;
                }
                return true;
        }

        public void required() {
                required = !required;
        }

        public StringSchema minLength(int length) {
                minLength = length;
                return this;
        }

        public StringSchema contains(String substring) {
                contains = substring;
                return this;
        }

}
