package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {
    public NumberSchema required() {
        addRequirement(number -> number instanceof Integer);
        return this;
    }

    public NumberSchema positive() {
        addRequirement(number -> number == null || number instanceof Integer
                && ((Integer) number) > 0);
        return this;
    }

    public void range(int start, int end) {
        addRequirement(number -> number instanceof Integer
                && (start <= ((Integer) number)
                && end >= ((Integer) number)));
    }
}
