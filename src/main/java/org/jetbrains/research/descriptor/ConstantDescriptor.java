package org.jetbrains.research.descriptor;

import java.util.Map;

public class ConstantDescriptor extends Descriptor {
    private final String value;
    private final String type;

    public ConstantDescriptor(String value, String type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public String getName() {
        return value;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    protected String print(Map<Descriptor, String> visited) {
        return "";
    }
}
