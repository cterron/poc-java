package org.ctb.serializegson;

import java.util.concurrent.ConcurrentHashMap;


public class PojoTest {
    ConcurrentHashMap <String,String> message;
    PojoTest(){
        this.message = new ConcurrentHashMap<String,String>();
    }
    public void put(DefaultKey key, String value){
        message.put(key.getName(),value);
    }
    public String get(DefaultKey key)
    {
        return message.get(key.getName());
    }

}
