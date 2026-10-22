package com.easyjson.serializer;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a implements ObjectSerializer {
    @Override // com.easyjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) {
        SerializeWriter serializeWriter = jSONSerializer.out;
        Enum r2 = (Enum) obj;
        if ((serializeWriter.features & SerializerFeature.WriteEnumUsingToString.mask) == 0) {
            serializeWriter.writeInt(r2.ordinal());
            return;
        }
        String string = r2.toString();
        if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
            serializeWriter.writeStringWithSingleQuote(string);
        } else {
            serializeWriter.writeStringWithDoubleQuote(string, (char) 0, false);
        }
    }
}
