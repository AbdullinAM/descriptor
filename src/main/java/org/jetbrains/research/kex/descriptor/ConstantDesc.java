package org.jetbrains.research.kex.descriptor;

import java.util.Map;

public class ConstantDesc extends Desc {
    private final String value;
    private final String type;

    public ConstantDesc(String value, String type) {
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
    protected String print(Map<Desc, String> visited) {
        return "";
    }
}
