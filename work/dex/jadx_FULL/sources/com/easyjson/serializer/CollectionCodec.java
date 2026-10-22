package com.easyjson.serializer;

import com.easyjson.JSONArray;
import com.easyjson.JSONException;
import com.easyjson.parser.DefaultJSONParser;
import com.easyjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class CollectionCodec implements ObjectSerializer, ObjectDeserializer {
    public static final CollectionCodec instance = new CollectionCodec();

    private CollectionCodec() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v10, types: [T, com.easyjson.JSONArray, java.util.Collection] */
    @Override // com.easyjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Collection collection;
        Type type2 = null;
        if (defaultJSONParser.lexer.token() == 8) {
            defaultJSONParser.lexer.nextToken(16);
            return null;
        }
        if (type == JSONArray.class) {
            ?? r8 = (T) new JSONArray();
            defaultJSONParser.parseArray((Collection) r8);
            return r8;
        }
        Type rawType = type;
        while (!(rawType instanceof Class)) {
            if (!(rawType instanceof ParameterizedType)) {
                throw new JSONException("TODO");
            }
            rawType = ((ParameterizedType) rawType).getRawType();
        }
        Class cls = (Class) rawType;
        Type type3 = Object.class;
        if (cls == AbstractCollection.class || cls == Collection.class) {
            collection = (T) new ArrayList();
        } else if (cls.isAssignableFrom(HashSet.class)) {
            collection = (T) new HashSet();
        } else if (cls.isAssignableFrom(LinkedHashSet.class)) {
            collection = (T) new LinkedHashSet();
        } else if (cls.isAssignableFrom(TreeSet.class)) {
            collection = (T) new TreeSet();
        } else if (cls.isAssignableFrom(ArrayList.class)) {
            collection = (T) new ArrayList();
        } else if (cls.isAssignableFrom(EnumSet.class)) {
            collection = (T) EnumSet.noneOf((Class) (type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : type3));
        } else {
            try {
                collection = (T) ((Collection) cls.newInstance());
            } catch (Exception unused) {
                throw new JSONException("create instane error, class " + cls.getName());
            }
        }
        if (type instanceof ParameterizedType) {
            type3 = ((ParameterizedType) type).getActualTypeArguments()[0];
        } else {
            if (type instanceof Class) {
                Class cls2 = (Class) type;
                if (!cls2.getName().startsWith("java.")) {
                    Type genericSuperclass = cls2.getGenericSuperclass();
                    if (genericSuperclass instanceof ParameterizedType) {
                        type2 = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
                    }
                }
            }
            if (type2 != null) {
                type3 = type2;
            }
        }
        defaultJSONParser.parseArray(type3, collection, obj);
        return (T) collection;
    }

    @Override // com.easyjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) {
        String str;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            if ((serializeWriter.features & SerializerFeature.WriteNullListAsEmpty.mask) != 0) {
                serializeWriter.write("[]");
                return;
            } else {
                serializeWriter.writeNull();
                return;
            }
        }
        int i = serializeWriter.features;
        SerializerFeature serializerFeature = SerializerFeature.WriteClassName;
        int i2 = 0;
        Type type2 = ((i & serializerFeature.mask) == 0 || !(type instanceof ParameterizedType)) ? null : ((ParameterizedType) type).getActualTypeArguments()[0];
        Collection collection = (Collection) obj;
        SerialContext serialContext = jSONSerializer.context;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        if ((serializeWriter.features & serializerFeature.mask) != 0) {
            if (HashSet.class != collection.getClass()) {
                str = TreeSet.class == collection.getClass() ? "TreeSet" : "Set";
            }
            serializeWriter.append((CharSequence) str);
        }
        try {
            serializeWriter.write(91);
            for (Object obj3 : collection) {
                int i3 = i2 + 1;
                if (i2 != 0) {
                    serializeWriter.write(44);
                }
                if (obj3 == null) {
                    serializeWriter.writeNull();
                } else {
                    Class<?> cls = obj3.getClass();
                    if (cls == Integer.class) {
                        serializeWriter.writeInt(((Integer) obj3).intValue());
                    } else if (cls == Long.class) {
                        serializeWriter.writeLong(((Long) obj3).longValue());
                        if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
                            serializeWriter.write(76);
                        }
                    } else {
                        jSONSerializer.config.get(cls).write(jSONSerializer, obj3, Integer.valueOf(i3 - 1), type2);
                    }
                }
                i2 = i3;
            }
            serializeWriter.write(93);
        } finally {
            jSONSerializer.context = serialContext;
        }
    }
}
