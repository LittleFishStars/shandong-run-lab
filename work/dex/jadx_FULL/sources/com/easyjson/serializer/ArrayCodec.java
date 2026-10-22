package com.easyjson.serializer;

import com.easyjson.JSON;
import com.easyjson.JSONArray;
import com.easyjson.parser.DefaultJSONParser;
import com.easyjson.parser.JSONLexer;
import com.easyjson.parser.deserializer.ObjectDeserializer;
import com.easyjson.util.TypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.IdentityHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ArrayCodec implements ObjectSerializer, ObjectDeserializer {
    public static final ArrayCodec instance = new ArrayCodec();

    private ArrayCodec() {
    }

    private <T> T toObjectArray(DefaultJSONParser defaultJSONParser, Class<?> cls, JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int size = jSONArray.size();
        T t = (T) Array.newInstance(cls, size);
        for (int i = 0; i < size; i++) {
            Object objCast = jSONArray.get(i);
            if (objCast == jSONArray) {
                Array.set(t, i, t);
            } else {
                if (!cls.isArray()) {
                    objCast = TypeUtils.cast(objCast, (Class<Object>) cls, defaultJSONParser.config);
                } else if (!cls.isInstance(objCast)) {
                    objCast = toObjectArray(defaultJSONParser, cls, (JSONArray) objCast);
                }
                Array.set(t, i, objCast);
            }
        }
        jSONArray.setRelatedArray(t);
        jSONArray.setComponentType(cls);
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.easyjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        if (type != char[].class) {
            if (i == 4) {
                T t = (T) jSONLexer.bytesValue();
                jSONLexer.nextToken(16);
                return t;
            }
            Class<?> componentType = ((Class) type).getComponentType();
            JSONArray jSONArray = new JSONArray();
            defaultJSONParser.parseArray(componentType, jSONArray, obj);
            return (T) toObjectArray(defaultJSONParser, componentType, jSONArray);
        }
        if (i == 4) {
            String strStringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            return (T) strStringVal.toCharArray();
        }
        if (i != 2) {
            return (T) JSON.toJSONString(defaultJSONParser.parse()).toCharArray();
        }
        Number numberIntegerValue = jSONLexer.integerValue();
        jSONLexer.nextToken(16);
        return (T) numberIntegerValue.toString().toCharArray();
    }

    @Override // com.easyjson.serializer.ObjectSerializer
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) {
        SerializeWriter serializeWriter = jSONSerializer.out;
        Object[] objArr = (Object[]) obj;
        if (obj == null) {
            if ((serializeWriter.features & SerializerFeature.WriteNullListAsEmpty.mask) != 0) {
                serializeWriter.write("[]");
                return;
            } else {
                serializeWriter.writeNull();
                return;
            }
        }
        int length = objArr.length;
        int i = length - 1;
        if (i == -1) {
            serializeWriter.append((CharSequence) "[]");
            return;
        }
        SerialContext serialContext = jSONSerializer.context;
        int i2 = 0;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        try {
            serializeWriter.write(91);
            if ((serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                jSONSerializer.incrementIndent();
                jSONSerializer.println();
                while (i2 < length) {
                    if (i2 != 0) {
                        serializeWriter.write(44);
                        jSONSerializer.println();
                    }
                    jSONSerializer.write(objArr[i2]);
                    i2++;
                }
                jSONSerializer.decrementIdent();
                jSONSerializer.println();
                serializeWriter.write(93);
                return;
            }
            Class<?> cls = null;
            ObjectSerializer objectSerializer = null;
            while (i2 < i) {
                Object obj3 = objArr[i2];
                if (obj3 == null) {
                    serializeWriter.append((CharSequence) "null,");
                } else {
                    IdentityHashMap<Object, SerialContext> identityHashMap = jSONSerializer.references;
                    if (identityHashMap == null || !identityHashMap.containsKey(obj3)) {
                        Class<?> cls2 = obj3.getClass();
                        if (cls2 == cls) {
                            objectSerializer.write(jSONSerializer, obj3, null, null);
                        } else {
                            ObjectSerializer objectSerializer2 = jSONSerializer.config.get(cls2);
                            objectSerializer2.write(jSONSerializer, obj3, null, null);
                            objectSerializer = objectSerializer2;
                            cls = cls2;
                        }
                    } else {
                        jSONSerializer.writeReference(obj3);
                    }
                    serializeWriter.write(44);
                }
                i2++;
            }
            Object obj4 = objArr[i];
            if (obj4 == null) {
                serializeWriter.append((CharSequence) "null]");
            } else {
                IdentityHashMap<Object, SerialContext> identityHashMap2 = jSONSerializer.references;
                if (identityHashMap2 == null || !identityHashMap2.containsKey(obj4)) {
                    jSONSerializer.writeWithFieldName(obj4, Integer.valueOf(i));
                } else {
                    jSONSerializer.writeReference(obj4);
                }
                serializeWriter.write(93);
            }
        } finally {
            jSONSerializer.context = serialContext;
        }
    }
}
