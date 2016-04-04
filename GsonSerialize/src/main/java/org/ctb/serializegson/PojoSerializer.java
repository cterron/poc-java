package org.ctb.serializegson;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;


public class PojoSerializer  implements JsonSerializer<PojoTest> {
    public JsonElement serialize(final  PojoTest pojo, final Type typeOfSrc, final JsonSerializationContext context){
        Gson gson = new Gson();
        JsonElement pojoOrig = gson.toJsonTree(pojo);
        /* Now, modify the tree */
        JsonObject obj = pojoOrig.getAsJsonObject();
        /* Check the serialize keys againts DefaultKey and check is properties */
        JsonObject message = obj.getAsJsonObject("message");

        Set<Map.Entry<String,JsonElement>>  entries = message.entrySet();

        /* I hope that this not becaome O(scary). In these case, I need
        a map implementation */
        /* Get the message if exists */

        for (Map.Entry<String,JsonElement> entry: entries)
        {
            String key = entry.getKey();
            /* Check the key */
            JsonElement innerObj = entry.getValue();
            DefaultKey enumKey = DefaultKey.contains(key);
            if (enumKey != null && enumKey.isList()) {
                String value = entry.getValue().getAsString();
                String[] splitData = value.split(",");
                JsonArray array = new JsonArray();
                for (int i = 0; i < splitData.length;i++)
                {
                    array.add(splitData[i]);
                }
                message.remove(key);
                message.add(key, array);
            }

        }
        return pojoOrig;
    }
}
