package com.easyjson.serializer;

import com.easyjson.JSON;
import com.easyjson.JSONObject;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class MapSerializer implements ObjectSerializer {
    @Override // com.easyjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) {
        boolean z;
        Object objProcessKey;
        Object objProcessValue;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        Map treeMap = (Map) obj;
        Class<?> cls = treeMap.getClass();
        boolean z2 = (cls == JSONObject.class || cls == HashMap.class || cls == LinkedHashMap.class) && treeMap.containsKey(JSON.DEFAULT_TYPE_KEY);
        if ((serializeWriter.features & SerializerFeature.SortField.mask) != 0 && !(treeMap instanceof SortedMap) && !(treeMap instanceof LinkedHashMap)) {
            try {
                treeMap = new TreeMap(treeMap);
            } catch (Exception unused) {
            }
        }
        IdentityHashMap<Object, SerialContext> identityHashMap = jSONSerializer.references;
        if (identityHashMap != null && identityHashMap.containsKey(obj)) {
            jSONSerializer.writeReference(obj);
            return;
        }
        SerialContext serialContext = jSONSerializer.context;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        try {
            serializeWriter.write(123);
            jSONSerializer.incrementIndent();
            if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) == 0 || z2) {
                z = true;
            } else {
                serializeWriter.writeFieldName(jSONSerializer.config.typeKey, false);
                serializeWriter.writeString(obj.getClass().getName());
                z = false;
            }
            Class<?> cls2 = null;
            ObjectSerializer objectSerializer = null;
            for (Map.Entry entry : treeMap.entrySet()) {
                Object value = entry.getValue();
                Object key = entry.getKey();
                if (jSONSerializer.applyName(obj, key) && jSONSerializer.apply(obj, key, value) && ((objProcessValue = JSONSerializer.processValue(jSONSerializer, obj, (objProcessKey = jSONSerializer.processKey(obj, key, value)), value)) != null || (serializeWriter.features & SerializerFeature.WriteMapNullValue.mask) != 0)) {
                    if (objProcessKey instanceof String) {
                        String str = (String) objProcessKey;
                        if (!z) {
                            serializeWriter.write(44);
                        }
                        if ((serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                            jSONSerializer.println();
                        }
                        serializeWriter.writeFieldName(str, true);
                    } else {
                        if (!z) {
                            serializeWriter.write(44);
                        }
                        int i = serializeWriter.features;
                        if ((SerializerFeature.BrowserCompatible.mask & i) == 0 && (i & SerializerFeature.WriteNonStringKeyAsString.mask) == 0) {
                            jSONSerializer.write(objProcessKey);
                        } else {
                            jSONSerializer.write(JSON.toJSONString(objProcessKey));
                        }
                        serializeWriter.write(58);
                    }
                    if (objProcessValue == null) {
                        serializeWriter.writeNull();
                    } else {
                        Class<?> cls3 = objProcessValue.getClass();
                        if (cls3 == cls2) {
                            objectSerializer.write(jSONSerializer, objProcessValue, objProcessKey, null);
                        } else {
                            ObjectSerializer objectSerializer2 = jSONSerializer.config.get(cls3);
                            objectSerializer2.write(jSONSerializer, objProcessValue, objProcessKey, null);
                            objectSerializer = objectSerializer2;
                            cls2 = cls3;
                        }
                    }
                    z = false;
                }
            }
            jSONSerializer.context = serialContext;
            jSONSerializer.decrementIdent();
            if ((serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0 && treeMap.size() > 0) {
                jSONSerializer.println();
            }
            serializeWriter.write(125);
        } catch (Throwable th) {
            jSONSerializer.context = serialContext;
            throw th;
        }
    }
}
