package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseScheme {
    public MapSchema required() {
        addRequirement(map -> map instanceof Map<?,?>);
        return this;
    }

    public void sizeof(int size) {
        addRequirement(map -> map instanceof Map<?,?>
                && ((Map<?, ?>) map).size() == size);
    }

    public void shape(Map<String, BaseScheme> size) {
        addRequirement(map -> map instanceof Map<?,?>);
    }
}
