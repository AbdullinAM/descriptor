package org.jetbrains.research.kex.descriptor;

import java.util.HashMap;
import java.util.Map;

public abstract class Desc {
    abstract public String getName();
    abstract public String getType();

    abstract protected String print(Map<Desc, String> visited);
    public String print() {
        return print(new HashMap<>());
    }

    @Override
    public String toString() {
        return print();
    }
}
