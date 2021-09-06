package org.jetbrains.research.descriptor;

import java.util.HashMap;
import java.util.Map;

public class ArrayDescriptor extends Descriptor {
    private final String name;
    private final String type;
    private final String elementType;
    private int length = -1;
    private final Map<Integer, Descriptor> elements;

    public ArrayDescriptor(String name, String type, String elementType) {
        this.name = name;
        this.type = type;
        this.elementType = elementType;
        this.elements = new HashMap<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getElementType() {
        return elementType;
    }

    public Map<Integer, Descriptor> getElements() {
        return elements;
    }

    public void addElement(int index, Descriptor value) {
        elements.put(index, value);
    }

    @Override
    protected String print(Map<Descriptor, String> visited) {
        if (visited.containsKey(this)) return visited.get(this);
        visited.put(this, name);
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" = ").append(type).append(" {\n");
        for (Map.Entry<Integer, Descriptor> entry : elements.entrySet()) {
            sb.append("  ").append(entry.getKey()).append(" = ").append(entry.getValue().getName()).append("\n");
        }
        sb.append("}\n");
        for (Map.Entry<Integer, Descriptor> entry : elements.entrySet()) {
            sb.append(entry.getValue().print(visited));
        }
        return sb.toString();
    }

    public int getLength() {
        return length >= 0 ? length : elements.keySet().stream().max(Integer::compareTo).orElse(0);
    }

    public void setLength(int length) {
        this.length = length;
    }
}
