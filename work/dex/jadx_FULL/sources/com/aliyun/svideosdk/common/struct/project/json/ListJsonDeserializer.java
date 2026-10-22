package com.aliyun.svideosdk.common.struct.project.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ListJsonDeserializer implements JsonDeserializer<List<?>> {
    @Override // com.google.gson.JsonDeserializer
    public List<?> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        ArrayList arrayList = new ArrayList();
        JsonArray asJsonArray = jsonElement.getAsJsonArray();
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        Iterator<JsonElement> it = asJsonArray.iterator();
        while (it.hasNext()) {
            Object objDeserialize = jsonDeserializationContext.deserialize(it.next(), type2);
            if (objDeserialize != null) {
                arrayList.add(objDeserialize);
            }
        }
        return arrayList;
    }
}
