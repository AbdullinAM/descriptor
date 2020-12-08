package org.jetbrains.research.kex.descriptor;

import java.util.Map;

public class NullDesc extends Desc {
    private String name;
    
    public NullDesc(String name) {
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
    protected String print(Map<Desc, String> visited) {
        return "";
    }
}
