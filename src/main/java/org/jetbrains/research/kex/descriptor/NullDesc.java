package org.jetbrains.research.kex.descriptor;

import java.util.Map;

public class NullDesc extends Desc {
    @Override
    public String getName() {
        return "null";
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
