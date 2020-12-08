package org.jetbrains.research.kex.descriptor;

import java.util.HashMap;
import java.util.Map;

public class ArrayDesc extends Desc {
    private final String name;
    private final String type;
    private final String elementType;
    private int length = -1;
    private final Map<Integer, Desc> elements;

    public ArrayDesc(String name, String type, String elementType) {
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

    public Map<Integer, Desc> getElements() {
        return elements;
    }

    public void addElement(int index, Desc value) {
        elements.put(index, value);
    }

    @Override
    protected String print(Map<Desc, String> visited) {
        if (visited.containsKey(this)) return visited.get(this);
        visited.put(this, name);
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" = ").append(type).append(" {\n");
        for (Map.Entry<Integer, Desc> entry : elements.entrySet()) {
            sb.append("  ").append(entry.getKey()).append(" = ").append(entry.getValue().getName()).append("\n");
        }
        sb.append("}\n");
        for (Map.Entry<Integer, Desc> entry : elements.entrySet()) {
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
