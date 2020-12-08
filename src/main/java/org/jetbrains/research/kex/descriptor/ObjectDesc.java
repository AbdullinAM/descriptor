package org.jetbrains.research.kex.descriptor;

import java.util.HashMap;
import java.util.Map;

public class ObjectDesc extends Desc {
    private final String klass;
    private final String name;
    private final Map<DescField, Desc> fields;

    public ObjectDesc(String klass, String name) {
        this.klass = klass;
        this.name = name;
        this.fields = new HashMap<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return klass;
    }

    public Map<DescField, Desc> getFields() {
        return fields;
    }

    public void addField(DescField field, Desc value) {
        fields.put(field, value);
    }

    @Override
    protected String print(Map<Desc, String> visited) {
        if (visited.containsKey(this)) return visited.get(this);
        visited.put(this, name);
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" = ").append(klass).append(" {\n");
        for (Map.Entry<DescField, Desc> entry : fields.entrySet()) {
            sb.append("  ").append(entry.getKey()).append(" = ").append(entry.getValue().getName()).append("\n");
        }
        sb.append("}\n");
        for (Map.Entry<DescField, Desc> entry : fields.entrySet()) {
            sb.append(entry.getValue().print(visited));
        }
        return sb.toString();
    }
}
