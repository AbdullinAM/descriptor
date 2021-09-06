package org.jetbrains.research.descriptor;

import java.util.HashMap;
import java.util.Map;

public abstract class Descriptor {
    abstract public String getName();
    abstract public String getType();

    abstract protected String print(Map<Descriptor, String> visited);
    public String print() {
        return print(new HashMap<>());
    }

    @Override
    public String toString() {
        return print();
    }
}
