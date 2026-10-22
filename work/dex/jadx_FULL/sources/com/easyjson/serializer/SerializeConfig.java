package com.easyjson.serializer;

import com.easyjson.JSON;
import com.easyjson.JSONAware;
import com.easyjson.JSONStreamAware;
import com.easyjson.util.IdentityHashMap;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SerializeConfig {
    public static final SerializeConfig globalInstance = new SerializeConfig();
    private final IdentityHashMap<ObjectSerializer> serializers;
    protected String typeKey = JSON.DEFAULT_TYPE_KEY;

    public SerializeConfig() {
        IdentityHashMap<ObjectSerializer> identityHashMap = new IdentityHashMap<>(1024);
        this.serializers = identityHashMap;
        identityHashMap.put(Boolean.class, BooleanCodec.instance);
        MiscCodec miscCodec = MiscCodec.instance;
        identityHashMap.put(Character.class, miscCodec);
        identityHashMap.put(Byte.class, IntegerCodec.instance);
        identityHashMap.put(Short.class, IntegerCodec.instance);
        identityHashMap.put(Integer.class, IntegerCodec.instance);
        identityHashMap.put(Long.class, IntegerCodec.instance);
        NumberCodec numberCodec = NumberCodec.instance;
        identityHashMap.put(Float.class, numberCodec);
        identityHashMap.put(Double.class, numberCodec);
        identityHashMap.put(Number.class, numberCodec);
        BigDecimalCodec bigDecimalCodec = BigDecimalCodec.instance;
        identityHashMap.put(BigDecimal.class, bigDecimalCodec);
        identityHashMap.put(BigInteger.class, bigDecimalCodec);
        identityHashMap.put(String.class, StringCodec.instance);
        identityHashMap.put(Object[].class, ArrayCodec.instance);
        identityHashMap.put(Class.class, miscCodec);
        identityHashMap.put(SimpleDateFormat.class, miscCodec);
        identityHashMap.put(Locale.class, miscCodec);
        identityHashMap.put(Currency.class, miscCodec);
        identityHashMap.put(TimeZone.class, miscCodec);
        identityHashMap.put(UUID.class, miscCodec);
        identityHashMap.put(URI.class, miscCodec);
        identityHashMap.put(URL.class, miscCodec);
        identityHashMap.put(Pattern.class, miscCodec);
        identityHashMap.put(Charset.class, miscCodec);
    }

    public static final SerializeConfig getGlobalInstance() {
        return globalInstance;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d9  */
    public ObjectSerializer get(Class<?> cls) {
        IdentityHashMap<ObjectSerializer> identityHashMap;
        ObjectSerializer aVar;
        Class<? super Object> superclass;
        boolean z;
        ObjectSerializer objectSerializer = this.serializers.get(cls);
        if (objectSerializer != null) {
            return objectSerializer;
        }
        if (Map.class.isAssignableFrom(cls)) {
            identityHashMap = this.serializers;
            aVar = new MapSerializer();
        } else if (List.class.isAssignableFrom(cls)) {
            identityHashMap = this.serializers;
            aVar = new ListSerializer();
        } else {
            if (!Collection.class.isAssignableFrom(cls)) {
                if (Date.class.isAssignableFrom(cls)) {
                    identityHashMap = this.serializers;
                    aVar = DateCodec.instance;
                } else if (JSONAware.class.isAssignableFrom(cls) || JSONSerializable.class.isAssignableFrom(cls) || JSONStreamAware.class.isAssignableFrom(cls)) {
                    identityHashMap = this.serializers;
                    aVar = MiscCodec.instance;
                } else if (cls.isEnum() || !((superclass = cls.getSuperclass()) == null || superclass == Object.class || !superclass.isEnum())) {
                    identityHashMap = this.serializers;
                    aVar = new a();
                } else if (cls.isArray()) {
                    Class<?> componentType = cls.getComponentType();
                    this.serializers.put(cls, new b(componentType, get(componentType)));
                } else if (Throwable.class.isAssignableFrom(cls)) {
                    JavaBeanSerializer javaBeanSerializer = new JavaBeanSerializer(cls);
                    javaBeanSerializer.features |= SerializerFeature.WriteClassName.mask;
                    this.serializers.put(cls, javaBeanSerializer);
                } else if (TimeZone.class.isAssignableFrom(cls) || Charset.class.isAssignableFrom(cls) || Enumeration.class.isAssignableFrom(cls)) {
                    identityHashMap = this.serializers;
                    aVar = MiscCodec.instance;
                } else if (Calendar.class.isAssignableFrom(cls)) {
                    identityHashMap = this.serializers;
                    aVar = DateCodec.instance;
                } else {
                    Class<?>[] interfaces = cls.getInterfaces();
                    int length = interfaces.length;
                    boolean z2 = false;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            z = false;
                            break;
                        }
                        Class<?> cls2 = interfaces[i];
                        z = true;
                        if (cls2.getName().equals("net.sf.cglib.proxy.Factory") || cls2.getName().equals("org.springframework.cglib.proxy.Factory")) {
                            z = false;
                            z2 = true;
                            break;
                        }
                        if (cls2.getName().equals("javassist.util.proxy.ProxyObject")) {
                            break;
                        }
                        i++;
                    }
                    if (z2 || z) {
                        ObjectSerializer objectSerializer2 = get(cls.getSuperclass());
                        this.serializers.put(cls, objectSerializer2);
                        return objectSerializer2;
                    }
                    identityHashMap = this.serializers;
                    aVar = new JavaBeanSerializer(cls);
                }
                return this.serializers.get(cls);
            }
            identityHashMap = this.serializers;
            aVar = CollectionCodec.instance;
        }
        identityHashMap.put(cls, aVar);
        return this.serializers.get(cls);
    }

    public String getTypeKey() {
        return this.typeKey;
    }

    public boolean put(Type type, ObjectSerializer objectSerializer) {
        return this.serializers.put(type, objectSerializer);
    }

    public ObjectSerializer registerIfNotExists(Class<?> cls) {
        return registerIfNotExists(cls, cls.getModifiers(), false, true, true, true);
    }

    public ObjectSerializer registerIfNotExists(Class<?> cls, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        ObjectSerializer objectSerializer = this.serializers.get(cls);
        if (objectSerializer != null) {
            return objectSerializer;
        }
        JavaBeanSerializer javaBeanSerializer = new JavaBeanSerializer(cls, i, null, z, z2, z3, z4);
        this.serializers.put(cls, javaBeanSerializer);
        return javaBeanSerializer;
    }

    public void setTypeKey(String str) {
        this.typeKey = str;
    }
}
