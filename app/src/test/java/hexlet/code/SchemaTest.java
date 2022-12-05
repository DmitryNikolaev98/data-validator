package hexlet.code;

import hexlet.code.schemas.BaseScheme;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class SchemaTest {
    @Test
    void stringSchemaTest() {
        StringSchema schema = new Validator().string();
        Assertions.assertTrue(schema.isValid(""));
        Assertions.assertTrue(schema.isValid(null));
        schema.required();
        Assertions.assertTrue(schema.isValid("what does the fox say"));
        Assertions.assertTrue(schema.isValid("hello"));
        Assertions.assertFalse(schema.isValid(null));
        Assertions.assertFalse(schema.isValid(""));
        Assertions.assertFalse(schema.minLength(6).isValid("hello"));
        Assertions.assertTrue(schema.contains("what").isValid("what does the fox say"));
        Assertions.assertFalse(schema.contains("whatthe").isValid("what does the fox say"));
    }

    @Test
    void numberSchemaTest() {
        NumberSchema schema = new Validator().number();
        Assertions.assertTrue(schema.isValid(null));
        schema.required();
        Assertions.assertFalse(schema.isValid(null));
        Assertions.assertTrue(schema.isValid(6));
        Assertions.assertFalse(schema.isValid("5"));
        Assertions.assertTrue(schema.positive().isValid(10));
        Assertions.assertFalse(schema.isValid(-6));
        schema.range(5, 10);
        Assertions.assertTrue(schema.isValid(10));
        Assertions.assertTrue(schema.isValid(5));
        Assertions.assertFalse(schema.isValid(11));
        Assertions.assertFalse(schema.isValid(4));
    }

    @Test
    void mapSchemaTest() {
        MapSchema schema = new Validator().map();
        Assertions.assertTrue(schema.isValid(null));
        schema.required();
        Assertions.assertFalse(schema.isValid(null));
        Assertions.assertTrue(schema.isValid(new HashMap<>()));
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        Assertions.assertTrue(schema.isValid(data));
        schema.sizeof(2);
        Assertions.assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        Assertions.assertTrue(schema.isValid(data));
    }

    @Test
    void shapeTest() {
        Validator v = new Validator();
        MapSchema schema = new Validator().map();
        Map<String, BaseScheme> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        Assertions.assertTrue(schema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        Assertions.assertTrue(schema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        Assertions.assertTrue(schema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        Assertions.assertTrue(schema.isValid(human4));
    }
}
