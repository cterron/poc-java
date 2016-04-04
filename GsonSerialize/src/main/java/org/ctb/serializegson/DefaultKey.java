package org.ctb.serializegson;


public enum DefaultKey implements Key {
    IP_SOURCE("ipSource", InternalType.STRING),
    IP_DESTINATION("ipDestination", InternalType.STRING),
    PORT_SOURCE("portSource", InternalType.INTEGER, true),
    PORT_DESTINATION("portDestination", InternalType.INTEGER, true)
    ;
    private final String name;
    private final InternalType type;
    private final boolean isList;


    public String getName(){
        return this.name;
    }
    public boolean isList(){
        return this.isList;
    }
    public InternalType getType(){
        return this.type;
    }

    DefaultKey(String name, InternalType type){
        this(name, type, false);
    }

    DefaultKey(String name, InternalType type, boolean isList){
        this.name = name;
        this.type = type;
        this.isList = isList;
    }
    public static DefaultKey  contains(String name){
        for (DefaultKey value: DefaultKey.values())
        {
            if (value.getName().equals(name))
                return value;

        }
        return null;
    }

}
