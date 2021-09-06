package org.jetbrains.research.descriptor;

import java.util.Map;

public class NullDescriptor extends Descriptor {
    private String name;
    
    public NullDescriptor(String name) {
        this.name = name;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "null";
    }

    @Override
    protected String print(Map<Descriptor, String> visited) {
        return "";
    }
}
