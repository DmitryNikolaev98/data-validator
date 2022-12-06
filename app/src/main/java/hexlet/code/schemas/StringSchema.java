package hexlet.code.schemas;

public final class StringSchema extends BaseScheme {

    // любая непустая строка
    public StringSchema required() {
        addRequirement(str -> str instanceof String
                && !((String) str).isEmpty());
        return this;
    }

    //строка равна или длиннее указанного числа
    public StringSchema minLength(int length) {
        addRequirement(str -> str instanceof String
                && ((String) str).length() >= length);
        return this;
    }

    //строка равна или длиннее указанного числа
    public StringSchema contains(String substring) {
        addRequirement(str -> str instanceof String
                && ((String) str).contains(substring));
        return this;
    }
}
