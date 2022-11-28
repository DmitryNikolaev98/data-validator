package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringSchemaTest {

    @Test
    void stringSchemaTest() {
        StringSchema schema = new Validator().string();

        Assertions.assertTrue(schema.isValid(""));
        Assertions.assertTrue(schema.isValid(null));

        schema.required();

        Assertions.assertTrue(schema.isValid("what does the fox say")); // true
        Assertions.assertTrue(schema.isValid("hexlet")); // true
        Assertions.assertFalse(schema.isValid(null)); // false
        Assertions.assertFalse(schema.isValid("")); // false

        Assertions.assertTrue(schema.contains("what").isValid("what does the fox say")); // true
        Assertions.assertFalse(schema.contains("whatthe").isValid("what does the fox say")); // false

    }
}
