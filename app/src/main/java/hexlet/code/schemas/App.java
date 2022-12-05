package hexlet.code.schemas;
import hexlet.code.Validator;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {


        Validator v = new Validator();

        StringSchema schema = v.string();

        System.out.println(schema.isValid("")); // true
// Пока на вызван метод required(), null считается валидным
        System.out.println(schema.isValid(null)); // true

        schema.required();

        System.out.println(schema.isValid("what does the fox say"));// true
        System.out.println(schema.isValid("hexlet")); // true
        System.out.println(schema.isValid(null)); // false
        System.out.println(schema.isValid(5)); // false
        System.out.println(schema.isValid("")); // false

        System.out.println(schema.contains("wh").isValid("what does the fox say")); // true
        System.out.println(schema.contains("what").isValid("what does the fox say")); // true
        System.out.println(schema.contains("whatthe").isValid("what does the fox say")); // false

        System.out.println(schema.isValid("what does the fox say")); // false
        System.out.println("------"); // false
// уже false, так как добавлена ещё одна проверка contains("whatthe")

        NumberSchema schema2 = v.number();

// Пока не вызван метод required(), null считается валидным
        System.out.println(schema2.isValid(null)); // true
        System.out.println(schema2.isValid(null)); // true

        schema2.required();
        schema2.positive();

        System.out.println(schema2.isValid(null)); // false
        System.out.println(schema2.isValid(10)); // true
        System.out.println(schema2.isValid("5")); // false
        System.out.println(schema2.isValid(-10)); // false
//  Ноль - не положительное число
        System.out.println(schema2.isValid(0)); // false

        schema2.range(5, 10);

        System.out.println(schema2.isValid(5)); // true
        System.out.println(schema2.isValid(10)); // true
        System.out.println(schema2.isValid(4)); // false
        System.out.println(schema2.isValid(11)); // false
        System.out.println("------"); // false


        MapSchema schema3 = v.map();

        System.out.println(schema3.isValid(null)); // true

        schema3.required();

        System.out.println(schema3.isValid(null)); // false
        System.out.println(schema3.isValid(new HashMap()) );// true
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        System.out.println(schema3.isValid(data)); // true

        schema3.sizeof(2);

        System.out.println(schema3.isValid(data));  // false
        data.put("key2", "value2");
        System.out.println(schema3.isValid(data)); // true
    }

}
