package hexlet.code.schemas;

public final class NumberSchema extends BaseScheme{
    public NumberSchema required() {
        addRequirement(number -> number instanceof Integer);
        return this;
    }

    public NumberSchema positive() {
        addRequirement(number -> number instanceof Integer && ((Integer) number) > 0);
        return this;
    }

    public NumberSchema range(int start, int end) {
        addRequirement(number -> number instanceof Integer && (start <= ((Integer) number) && end >= ((Integer) number)));
        return this;
    }
}
