package com.alibaba.fastjson.serializer;

import java.util.IdentityHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class AfterFilter implements SerializeFilter {
    private static final ThreadLocal<JSONSerializer> serializerLocal = new ThreadLocal<>();
    private static final ThreadLocal<Character> seperatorLocal = new ThreadLocal<>();
    private static final Character COMMA = ',';

    public final char writeAfter(JSONSerializer jSONSerializer, Object obj, char c) {
        ThreadLocal<JSONSerializer> threadLocal = serializerLocal;
        JSONSerializer jSONSerializer2 = threadLocal.get();
        threadLocal.set(jSONSerializer);
        ThreadLocal<Character> threadLocal2 = seperatorLocal;
        threadLocal2.set(Character.valueOf(c));
        writeAfter(obj);
        threadLocal.set(jSONSerializer2);
        return threadLocal2.get().charValue();
    }

    public abstract void writeAfter(Object obj);

    public final void writeKeyValue(String str, Object obj) {
        IdentityHashMap<Object, SerialContext> identityHashMap;
        JSONSerializer jSONSerializer = serializerLocal.get();
        ThreadLocal<Character> threadLocal = seperatorLocal;
        char cCharValue = threadLocal.get().charValue();
        boolean zContainsReference = jSONSerializer.containsReference(obj);
        jSONSerializer.writeKeyValue(cCharValue, str, obj);
        if (!zContainsReference && (identityHashMap = jSONSerializer.references) != null) {
            identityHashMap.remove(obj);
        }
        if (cCharValue != ',') {
            threadLocal.set(COMMA);
        }
    }
}
