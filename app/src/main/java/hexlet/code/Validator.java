package hexlet.code;

import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;

public final class Validator {

    public StringSchema string() {
        return new StringSchema();
    }
    public NumberSchema number() {
        return new NumberSchema();
    }
}