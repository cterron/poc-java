package org.ctb.serializegson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PojoTest pojo = new PojoTest();
        pojo.put(DefaultKey.IP_DESTINATION,"192.168.120.3");
        pojo.put(DefaultKey.IP_SOURCE, "192.168.120.5");
        pojo.put(DefaultKey.PORT_DESTINATION,"10,20,30");
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PojoTest.class, new PojoSerializer());
        Gson gson = gsonBuilder.create();
        System.out.println(gson.toJson(pojo));
    }
}
