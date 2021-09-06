package org.jetbrains.research.descriptor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ObjectDescriptor extends Descriptor {
    private final String klass;
    private final String name;
    private final Map<Field, Descriptor> fields;

    static public class Field {
        private final String name;
        private final String type;

        public Field(String name, String type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Field that = (Field) o;
            return Objects.equals(name, that.name) &&
                    Objects.equals(type, that.type);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, type);
        }

        @Override
        public String toString() {
            return "<" + name + ", " + type + ">";
        }
    }

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

    public Map<Field, Descriptor> getFields() {
        return fields;
    }

    public void addField(Field field, Descriptor value) {
        fields.put(field, value);
    }

    public void addField(String name, String type, Descriptor value) {
        addField(new Field(name, type), value);
    }

    @Override
    protected String print(Map<Descriptor, String> visited) {
        if (visited.containsKey(this)) return visited.get(this);
        visited.put(this, name);
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" = ").append(klass).append(" {\n");
        for (Map.Entry<Field, Descriptor> entry : fields.entrySet()) {
            sb.append("  ").append(entry.getKey()).append(" = ").append(entry.getValue().getName()).append("\n");
        }
        sb.append("}\n");
        for (Map.Entry<Field, Descriptor> entry : fields.entrySet()) {
            sb.append(entry.getValue().print(visited));
        }
        return sb.toString();
    }
}
