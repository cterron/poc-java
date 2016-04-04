package org.ctb.serializegson;


public interface Key {
    String getName();
    InternalType getType();
    boolean isList();

}
