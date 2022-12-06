package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseScheme {
    public final MapSchema required() {
        addRequirement(map -> map instanceof Map<?, ?>);
        return this;
    }

    public final void sizeof(int size) {
        addRequirement(map -> map instanceof Map<?, ?>
                && ((Map<?, ?>) map).size() == size);
    }

    public final void shape(Map<String, BaseScheme> schemas) {
        addRequirement(map -> map instanceof Map
                && schemas.entrySet().stream()
                .allMatch(s -> s.getValue().isValid(((Map<?, ?>) map).get(s.getKey()))));
    }
}
