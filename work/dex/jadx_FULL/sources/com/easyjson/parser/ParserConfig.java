package com.easyjson.parser;

import com.easyjson.annotation.JSONType;
import com.easyjson.parser.deserializer.FieldDeserializer;
import com.easyjson.parser.deserializer.ObjectDeserializer;
import com.easyjson.serializer.ArrayCodec;
import com.easyjson.serializer.BigDecimalCodec;
import com.easyjson.serializer.BooleanCodec;
import com.easyjson.serializer.CollectionCodec;
import com.easyjson.serializer.DateCodec;
import com.easyjson.serializer.IntegerCodec;
import com.easyjson.serializer.MiscCodec;
import com.easyjson.serializer.NumberCodec;
import com.easyjson.serializer.StringCodec;
import com.easyjson.util.FieldInfo;
import com.easyjson.util.IdentityHashMap;
import com.zj.adlib.dhb;
import com.zj.adlib.mva;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ParserConfig {
    public static ParserConfig global = new ParserConfig();
    public ClassLoader defaultClassLoader;
    private final IdentityHashMap<ObjectDeserializer> derializers;
    public final SymbolTable symbolTable;

    public ParserConfig() {
        IdentityHashMap<ObjectDeserializer> identityHashMap = new IdentityHashMap<>(1024);
        this.derializers = identityHashMap;
        this.symbolTable = new SymbolTable(16384);
        MiscCodec miscCodec = MiscCodec.instance;
        identityHashMap.put(SimpleDateFormat.class, miscCodec);
        DateCodec dateCodec = DateCodec.instance;
        identityHashMap.put(Date.class, dateCodec);
        identityHashMap.put(Calendar.class, dateCodec);
        identityHashMap.put(Map.class, a.f29555a);
        identityHashMap.put(HashMap.class, a.f29555a);
        identityHashMap.put(LinkedHashMap.class, a.f29555a);
        identityHashMap.put(TreeMap.class, a.f29555a);
        identityHashMap.put(ConcurrentMap.class, a.f29555a);
        identityHashMap.put(ConcurrentHashMap.class, a.f29555a);
        CollectionCodec collectionCodec = CollectionCodec.instance;
        identityHashMap.put(Collection.class, collectionCodec);
        identityHashMap.put(List.class, collectionCodec);
        identityHashMap.put(ArrayList.class, collectionCodec);
        mva mvaVar = mva.f43397a;
        identityHashMap.put(Object.class, mvaVar);
        identityHashMap.put(String.class, StringCodec.instance);
        identityHashMap.put(Character.TYPE, miscCodec);
        identityHashMap.put(Character.class, miscCodec);
        Class cls = Byte.TYPE;
        NumberCodec numberCodec = NumberCodec.instance;
        identityHashMap.put(cls, numberCodec);
        identityHashMap.put(Byte.class, numberCodec);
        identityHashMap.put(Short.TYPE, numberCodec);
        identityHashMap.put(Short.class, numberCodec);
        identityHashMap.put(Integer.TYPE, IntegerCodec.instance);
        identityHashMap.put(Integer.class, IntegerCodec.instance);
        identityHashMap.put(Long.TYPE, IntegerCodec.instance);
        identityHashMap.put(Long.class, IntegerCodec.instance);
        BigDecimalCodec bigDecimalCodec = BigDecimalCodec.instance;
        identityHashMap.put(BigInteger.class, bigDecimalCodec);
        identityHashMap.put(BigDecimal.class, bigDecimalCodec);
        identityHashMap.put(Float.TYPE, numberCodec);
        identityHashMap.put(Float.class, numberCodec);
        identityHashMap.put(Double.TYPE, numberCodec);
        identityHashMap.put(Double.class, numberCodec);
        Class cls2 = Boolean.TYPE;
        BooleanCodec booleanCodec = BooleanCodec.instance;
        identityHashMap.put(cls2, booleanCodec);
        identityHashMap.put(Boolean.class, booleanCodec);
        identityHashMap.put(Class.class, miscCodec);
        ArrayCodec arrayCodec = ArrayCodec.instance;
        identityHashMap.put(char[].class, arrayCodec);
        identityHashMap.put(Object[].class, arrayCodec);
        identityHashMap.put(UUID.class, miscCodec);
        identityHashMap.put(TimeZone.class, miscCodec);
        identityHashMap.put(Locale.class, miscCodec);
        identityHashMap.put(Currency.class, miscCodec);
        identityHashMap.put(URI.class, miscCodec);
        identityHashMap.put(URL.class, miscCodec);
        identityHashMap.put(Pattern.class, miscCodec);
        identityHashMap.put(Charset.class, miscCodec);
        identityHashMap.put(Number.class, numberCodec);
        identityHashMap.put(StackTraceElement.class, miscCodec);
        identityHashMap.put(Serializable.class, mvaVar);
        identityHashMap.put(Cloneable.class, mvaVar);
        identityHashMap.put(Comparable.class, mvaVar);
        identityHashMap.put(Closeable.class, mvaVar);
    }

    public static ParserConfig getGlobalInstance() {
        return global;
    }

    public static boolean isPrimitive(Class<?> cls) {
        return cls.isPrimitive() || cls == Boolean.class || cls == Character.class || cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == String.class || cls == Date.class || cls == java.sql.Date.class || cls == Time.class || cls == Timestamp.class;
    }

    public FieldDeserializer createFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        Class<?> cls2 = fieldInfo.fieldClass;
        return (cls2 == List.class || cls2 == ArrayList.class || (cls2.isArray() && !cls2.getComponentType().isPrimitive())) ? new b(parserConfig, cls, fieldInfo) : new DefaultFieldDeserializer(parserConfig, cls, fieldInfo);
    }

    public ObjectDeserializer getDeserializer(Class<?> cls, Type type) {
        ObjectDeserializer throwableDeserializer;
        JSONType jSONType;
        Class<?> clsMappingTo;
        ObjectDeserializer objectDeserializer = this.derializers.get(type);
        if (objectDeserializer != null) {
            return objectDeserializer;
        }
        if (type == null) {
            type = cls;
        }
        ObjectDeserializer objectDeserializer2 = this.derializers.get(type);
        if (objectDeserializer2 != null) {
            return objectDeserializer2;
        }
        if (!isPrimitive(cls) && (jSONType = (JSONType) cls.getAnnotation(JSONType.class)) != null && (clsMappingTo = jSONType.mappingTo()) != Void.class) {
            return getDeserializer(clsMappingTo, clsMappingTo);
        }
        if ((type instanceof WildcardType) || (type instanceof TypeVariable) || (type instanceof ParameterizedType)) {
            objectDeserializer2 = this.derializers.get(cls);
        }
        if (objectDeserializer2 != null) {
            return objectDeserializer2;
        }
        ObjectDeserializer objectDeserializer3 = this.derializers.get(type);
        if (objectDeserializer3 != null) {
            return objectDeserializer3;
        }
        if (cls.isEnum()) {
            throwableDeserializer = new EnumDeserializer(cls);
        } else if (cls.isArray()) {
            throwableDeserializer = ArrayCodec.instance;
        } else if (cls == Set.class || cls == HashSet.class || cls == Collection.class || cls == List.class || cls == ArrayList.class || Collection.class.isAssignableFrom(cls)) {
            throwableDeserializer = CollectionCodec.instance;
        } else if (Map.class.isAssignableFrom(cls)) {
            throwableDeserializer = a.f29555a;
        } else {
            throwableDeserializer = Throwable.class.isAssignableFrom(cls) ? new ThrowableDeserializer(this, cls) : new JavaBeanDeserializer(this, cls, type);
        }
        putDeserializer(type, throwableDeserializer);
        return throwableDeserializer;
    }

    public ObjectDeserializer getDeserializer(Type type) {
        Class<?> cls;
        ObjectDeserializer objectDeserializer = this.derializers.get(type);
        if (objectDeserializer != null) {
            return objectDeserializer;
        }
        if (type instanceof Class) {
            cls = (Class) type;
        } else {
            if (!(type instanceof ParameterizedType)) {
                return mva.f43397a;
            }
            Type rawType = ((ParameterizedType) type).getRawType();
            if (!(rawType instanceof Class)) {
                return getDeserializer(rawType);
            }
            cls = (Class) rawType;
        }
        return getDeserializer(cls, type);
    }

    public void putDeserializer(Type type, ObjectDeserializer objectDeserializer) {
        this.derializers.put(type, objectDeserializer);
    }

    public ObjectDeserializer registerIfNotExists(Class<?> cls) {
        return registerIfNotExists(cls, cls.getModifiers(), false, true, true, true);
    }

    public ObjectDeserializer registerIfNotExists(Class<?> cls, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        ObjectDeserializer objectDeserializer = this.derializers.get(cls);
        if (objectDeserializer != null) {
            return objectDeserializer;
        }
        JavaBeanDeserializer javaBeanDeserializer = new JavaBeanDeserializer(this, cls, cls, dhb.a(cls, i, cls, z, z2, z3, z4));
        putDeserializer(cls, javaBeanDeserializer);
        return javaBeanDeserializer;
    }
}
