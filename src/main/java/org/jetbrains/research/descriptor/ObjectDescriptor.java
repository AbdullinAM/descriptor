package org.jetbrains.research.descriptor;

import java.util.HashMap;
import java.util.Map;

public class ObjectDescriptor extends Descriptor {
    private final String klass;
    private final String name;
    private final Map<DescField, Descriptor> fields;

    public ObjectDescriptor(String klass, String name) {
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

    public Map<DescField, Descriptor> getFields() {
        return fields;
    }

    public void addField(DescField field, Descriptor value) {
        fields.put(field, value);
    }

    @Override
    protected String print(Map<Descriptor, String> visited) {
        if (visited.containsKey(this)) return visited.get(this);
        visited.put(this, name);
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" = ").append(klass).append(" {\n");
        for (Map.Entry<DescField, Descriptor> entry : fields.entrySet()) {
            sb.append("  ").append(entry.getKey()).append(" = ").append(entry.getValue().getName()).append("\n");
        }
        sb.append("}\n");
        for (Map.Entry<DescField, Descriptor> entry : fields.entrySet()) {
            sb.append(entry.getValue().print(visited));
        }
        return sb.toString();
    }
}
