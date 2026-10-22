package com.alibaba.fastjson.parser.deserializer;

import androidx.camera.video.AudioStats;
import com.acse.ottn.p3;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONValidator;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class JavaBeanDeserializer implements ObjectDeserializer {
    private final Map<String, FieldDeserializer> alterNameFieldDeserializers;
    private final ParserConfig.AutoTypeCheckHandler autoTypeCheckHandler;
    public final JavaBeanInfo beanInfo;
    protected final Class<?> clazz;
    private ConcurrentMap<String, Object> extraFieldDeserializers;
    private Map<String, FieldDeserializer> fieldDeserializerMap;
    private final FieldDeserializer[] fieldDeserializers;
    private transient long[] hashArray;
    private transient short[] hashArrayMapping;
    private transient long[] smartMatchHashArray;
    private transient short[] smartMatchHashArrayMapping;
    protected final FieldDeserializer[] sortedFieldDeserializers;

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls) {
        this(parserConfig, cls, cls);
    }

    private Object createFactoryInstance(ParserConfig parserConfig, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return this.beanInfo.factoryMethod.invoke(null, obj);
    }

    public static JavaBeanDeserializer getSeeAlso(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, String str) {
        JSONType jSONType = javaBeanInfo.jsonType;
        if (jSONType == null) {
            return null;
        }
        for (Class<?> cls : jSONType.seeAlso()) {
            ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
            if (deserializer instanceof JavaBeanDeserializer) {
                JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
                JavaBeanInfo javaBeanInfo2 = javaBeanDeserializer.beanInfo;
                if (javaBeanInfo2.typeName.equals(str)) {
                    return javaBeanDeserializer;
                }
                JavaBeanDeserializer seeAlso = getSeeAlso(parserConfig, javaBeanInfo2, str);
                if (seeAlso != null) {
                    return seeAlso;
                }
            }
        }
        return null;
    }

    public static boolean isSetFlag(int i, int[] iArr) {
        int i2;
        if (iArr != null && (i2 = i / 32) < iArr.length) {
            return ((1 << (i % 32)) & iArr[i2]) != 0;
        }
        return false;
    }

    public static void parseArray(Collection collection, ObjectDeserializer objectDeserializer, DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
        int i = jSONLexerBase.token();
        if (i == 8) {
            jSONLexerBase.nextToken(16);
            jSONLexerBase.token();
            return;
        }
        if (i != 14) {
            defaultJSONParser.throwException(i);
        }
        if (jSONLexerBase.getCurrent() == '[') {
            jSONLexerBase.next();
            jSONLexerBase.setToken(14);
        } else {
            jSONLexerBase.nextToken(14);
        }
        if (jSONLexerBase.token() == 15) {
            jSONLexerBase.nextToken();
            return;
        }
        int i2 = 0;
        while (true) {
            collection.add(objectDeserializer.deserialze(defaultJSONParser, type, Integer.valueOf(i2)));
            i2++;
            if (jSONLexerBase.token() != 16) {
                break;
            }
            if (jSONLexerBase.getCurrent() == '[') {
                jSONLexerBase.next();
                jSONLexerBase.setToken(14);
            } else {
                jSONLexerBase.nextToken(14);
            }
        }
        int i3 = jSONLexerBase.token();
        if (i3 != 15) {
            defaultJSONParser.throwException(i3);
        }
        if (jSONLexerBase.getCurrent() != ',') {
            jSONLexerBase.nextToken(16);
        } else {
            jSONLexerBase.next();
            jSONLexerBase.setToken(16);
        }
    }

    public void check(JSONLexer jSONLexer, int i) {
        if (jSONLexer.token() != i) {
            throw new JSONException("syntax error");
        }
    }

    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) {
        Object objNewInstance;
        if ((type instanceof Class) && this.clazz.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject());
        }
        JavaBeanInfo javaBeanInfo = this.beanInfo;
        Constructor<?> constructor = javaBeanInfo.defaultConstructor;
        Object obj = null;
        if (constructor == null && javaBeanInfo.factoryMethod == null) {
            return null;
        }
        Method method = javaBeanInfo.factoryMethod;
        if (method != null && javaBeanInfo.defaultConstructorParameterSize > 0) {
            return null;
        }
        try {
            if (javaBeanInfo.defaultConstructorParameterSize == 0) {
                objNewInstance = constructor != null ? constructor.newInstance(new Object[0]) : method.invoke(null, new Object[0]);
            } else {
                ParseContext context = defaultJSONParser.getContext();
                if (context == null || context.object == null) {
                    throw new JSONException("can't create non-static inner class instance.");
                }
                if (!(type instanceof Class)) {
                    throw new JSONException("can't create non-static inner class instance.");
                }
                String name = ((Class) type).getName();
                String strSubstring = name.substring(0, name.lastIndexOf(36));
                Object obj2 = context.object;
                String name2 = obj2.getClass().getName();
                if (!name2.equals(strSubstring)) {
                    ParseContext parseContext = context.parent;
                    if (parseContext == null || parseContext.object == null || !("java.util.ArrayList".equals(name2) || "java.util.List".equals(name2) || "java.util.Collection".equals(name2) || "java.util.Map".equals(name2) || "java.util.HashMap".equals(name2))) {
                        obj = obj2;
                    } else if (parseContext.object.getClass().getName().equals(strSubstring)) {
                        obj = parseContext.object;
                    }
                    obj2 = obj;
                }
                if (obj2 == null || ((obj2 instanceof Collection) && ((Collection) obj2).isEmpty())) {
                    throw new JSONException("can't create non-static inner class instance.");
                }
                objNewInstance = constructor.newInstance(obj2);
            }
            if (defaultJSONParser != null && defaultJSONParser.lexer.isEnabled(Feature.InitStringFieldAsEmpty)) {
                for (FieldInfo fieldInfo : this.beanInfo.fields) {
                    if (fieldInfo.fieldClass == String.class) {
                        try {
                            fieldInfo.set(objNewInstance, "");
                        } catch (Exception e) {
                            throw new JSONException("create instance error, class " + this.clazz.getName(), e);
                        }
                    }
                }
            }
            return objNewInstance;
        } catch (JSONException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new JSONException("create instance error, class " + this.clazz.getName(), e3);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, 0);
    }

    public <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        Enum<?> enumScanEnum;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() != 14) {
            throw new JSONException("error");
        }
        String strScanTypeName = jSONLexer.scanTypeName(defaultJSONParser.symbolTable);
        if (strScanTypeName != null) {
            ObjectDeserializer seeAlso = getSeeAlso(defaultJSONParser.getConfig(), this.beanInfo, strScanTypeName);
            if (seeAlso == null) {
                seeAlso = defaultJSONParser.getConfig().getDeserializer(defaultJSONParser.getConfig().checkAutoType(strScanTypeName, TypeUtils.getClass(type), jSONLexer.getFeatures()));
            }
            if (seeAlso instanceof JavaBeanDeserializer) {
                return (T) ((JavaBeanDeserializer) seeAlso).deserialzeArrayMapping(defaultJSONParser, type, obj, obj2);
            }
        }
        T t = (T) createInstance(defaultJSONParser, type);
        int length = this.sortedFieldDeserializers.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            char c = i == length + (-1) ? ']' : ',';
            FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i];
            Class<?> cls = fieldDeserializer.fieldInfo.fieldClass;
            if (cls == Integer.TYPE) {
                fieldDeserializer.setValue((Object) t, jSONLexer.scanInt(c));
            } else if (cls == String.class) {
                fieldDeserializer.setValue((Object) t, jSONLexer.scanString(c));
            } else if (cls == Long.TYPE) {
                fieldDeserializer.setValue(t, jSONLexer.scanLong(c));
            } else if (cls.isEnum()) {
                char current = jSONLexer.getCurrent();
                if (current == '\"' || current == 'n') {
                    enumScanEnum = jSONLexer.scanEnum(cls, defaultJSONParser.getSymbolTable(), c);
                } else if (current < '0' || current > '9') {
                    enumScanEnum = scanEnum(jSONLexer, c);
                } else {
                    enumScanEnum = ((EnumDeserializer) ((DefaultFieldDeserializer) fieldDeserializer).getFieldValueDeserilizer(defaultJSONParser.getConfig())).valueOf(jSONLexer.scanInt(c));
                }
                fieldDeserializer.setValue(t, enumScanEnum);
            } else if (cls == Boolean.TYPE) {
                fieldDeserializer.setValue(t, jSONLexer.scanBoolean(c));
            } else if (cls == Float.TYPE) {
                fieldDeserializer.setValue(t, Float.valueOf(jSONLexer.scanFloat(c)));
            } else if (cls == Double.TYPE) {
                fieldDeserializer.setValue(t, Double.valueOf(jSONLexer.scanDouble(c)));
            } else if (cls == Date.class && jSONLexer.getCurrent() == '1') {
                fieldDeserializer.setValue(t, new Date(jSONLexer.scanLong(c)));
            } else if (cls == BigDecimal.class) {
                fieldDeserializer.setValue(t, jSONLexer.scanDecimal(c));
            } else {
                jSONLexer.nextToken(14);
                FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                fieldDeserializer.setValue(t, defaultJSONParser.parseObject(fieldInfo.fieldType, fieldInfo.name));
                if (jSONLexer.token() == 15) {
                    break;
                }
                check(jSONLexer, c == ']' ? 15 : 16);
            }
            i++;
        }
        jSONLexer.nextToken(16);
        return t;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    public FieldDeserializer getFieldDeserializer(String str) {
        return getFieldDeserializer(str, null);
    }

    public Type getFieldType(int i) {
        return this.sortedFieldDeserializers[i].fieldInfo.fieldType;
    }

    public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        return parseField(defaultJSONParser, str, obj, type, map, null);
    }

    public Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i) {
        return parseRest(defaultJSONParser, type, obj, obj2, i, new int[0]);
    }

    public Enum<?> scanEnum(JSONLexer jSONLexer, char c) {
        throw new JSONException("illegal enum. " + jSONLexer.info());
    }

    public FieldDeserializer smartMatch(String str) {
        return smartMatch(str, null);
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, JavaBeanInfo.build(cls, type, parserConfig.propertyNamingStrategy, parserConfig.fieldBased, parserConfig.compatibleWithJavaBean, parserConfig.isJacksonCompatible()));
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, int i) {
        return (T) deserialze(defaultJSONParser, type, obj, null, i, null);
    }

    public FieldDeserializer getFieldDeserializer(String str, int[] iArr) {
        FieldDeserializer fieldDeserializer;
        if (str == null) {
            return null;
        }
        Map<String, FieldDeserializer> map = this.fieldDeserializerMap;
        if (map != null && (fieldDeserializer = map.get(str)) != null) {
            return fieldDeserializer;
        }
        int length = this.sortedFieldDeserializers.length - 1;
        int i = 0;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int iCompareTo = this.sortedFieldDeserializers[i2].fieldInfo.name.compareTo(str);
            if (iCompareTo < 0) {
                i = i2 + 1;
            } else {
                if (iCompareTo <= 0) {
                    if (isSetFlag(i2, iArr)) {
                        return null;
                    }
                    return this.sortedFieldDeserializers[i2];
                }
                length = i2 - 1;
            }
        }
        Map<String, FieldDeserializer> map2 = this.alterNameFieldDeserializers;
        if (map2 != null) {
            return map2.get(str);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x01df  */
    /* JADX WARN: Code duplicated, block: B:106:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:108:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:110:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:112:0x0218  */
    /* JADX WARN: Code duplicated, block: B:115:0x0222  */
    /* JADX WARN: Code duplicated, block: B:118:0x0227 A[LOOP:3: B:113:0x021d->B:118:0x0227, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:130:0x024d  */
    /* JADX WARN: Code duplicated, block: B:143:0x01dd A[EDGE_INSN: B:143:0x01dd->B:103:0x01dd BREAK  A[LOOP:2: B:63:0x0135->B:102:0x01d9], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:150:0x022a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:151:0x022b A[EDGE_INSN: B:151:0x022b->B:120:0x022b BREAK  A[LOOP:3: B:113:0x021d->B:118:0x0227], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:60:0x012a  */
    /* JADX WARN: Code duplicated, block: B:62:0x0132  */
    /* JADX WARN: Code duplicated, block: B:65:0x013a  */
    /* JADX WARN: Instruction removed from duplicated block: B:110:0x01f3, please report this as an issue */
    /* JADX WARN: Type inference failed for: r17v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r17v6 */
    /* JADX WARN: Type inference failed for: r17v7 */
    public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map, int[] iArr) {
        FieldDeserializer fieldDeserializer;
        boolean z;
        FieldDeserializer defaultFieldDeserializer;
        ?? r17;
        int i;
        FieldDeserializer[] fieldDeserializerArr;
        int i2;
        int i3;
        FieldDeserializer[] fieldDeserializerArr2;
        FieldInfo fieldInfo;
        Field[] fieldArr;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i4 = Feature.DisableFieldSmartMatch.mask;
        int i5 = Feature.InitStringFieldAsEmpty.mask;
        FieldDeserializer fieldDeserializer2 = (jSONLexer.isEnabled(i4) || (i4 & this.beanInfo.parserFeatures) != 0) ? getFieldDeserializer(str) : (jSONLexer.isEnabled(i5) || (this.beanInfo.parserFeatures & i5) != 0) ? smartMatch(str) : smartMatch(str, iArr);
        int i6 = Feature.SupportNonPublicField.mask;
        if (fieldDeserializer2 == null && (jSONLexer.isEnabled(i6) || (i6 & this.beanInfo.parserFeatures) != 0)) {
            if (this.extraFieldDeserializers == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(1, 0.75f, 1);
                for (Class<?> superclass = this.clazz; superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
                    Field[] declaredFields = superclass.getDeclaredFields();
                    int length = declaredFields.length;
                    int i7 = 0;
                    while (i7 < length) {
                        Field field = declaredFields[i7];
                        String name = field.getName();
                        if (getFieldDeserializer(name) != null) {
                            fieldArr = declaredFields;
                        } else {
                            int modifiers = field.getModifiers();
                            if ((modifiers & 16) == 0 && (modifiers & 8) == 0) {
                                JSONField jSONField = (JSONField) TypeUtils.getAnnotation(field, JSONField.class);
                                if (jSONField != null) {
                                    String strName = jSONField.name();
                                    fieldArr = declaredFields;
                                    if (!"".equals(strName)) {
                                        name = strName;
                                    }
                                } else {
                                    fieldArr = declaredFields;
                                }
                                concurrentHashMap.put(name, field);
                            } else {
                                fieldArr = declaredFields;
                            }
                        }
                        i7++;
                        fieldDeserializer2 = fieldDeserializer2;
                        declaredFields = fieldArr;
                    }
                }
                fieldDeserializer = fieldDeserializer2;
                this.extraFieldDeserializers = concurrentHashMap;
            } else {
                fieldDeserializer = fieldDeserializer2;
            }
            Object obj2 = this.extraFieldDeserializers.get(str);
            if (obj2 == null) {
                z = true;
            } else if (obj2 instanceof FieldDeserializer) {
                defaultFieldDeserializer = (FieldDeserializer) obj2;
                jSONLexer = jSONLexer;
                r17 = 1;
            } else {
                Field field2 = (Field) obj2;
                field2.setAccessible(true);
                r17 = 1;
                jSONLexer = jSONLexer;
                defaultFieldDeserializer = new DefaultFieldDeserializer(defaultJSONParser.getConfig(), this.clazz, new FieldInfo(str, field2.getDeclaringClass(), field2.getType(), field2.getGenericType(), field2, 0, 0, 0));
                this.extraFieldDeserializers.put(str, defaultFieldDeserializer);
            }
            if (defaultFieldDeserializer == null) {
                JSONLexer jSONLexer2 = jSONLexer;
                i = 0;
                while (true) {
                    fieldDeserializerArr = this.sortedFieldDeserializers;
                    if (i < fieldDeserializerArr.length) {
                        i = -1;
                        break;
                    }
                    if (fieldDeserializerArr[i] == defaultFieldDeserializer) {
                        break;
                    }
                    i++;
                }
                if (i == -1 && iArr != null && str.startsWith(LoginConstants.UNDER_LINE) && isSetFlag(i, iArr)) {
                    defaultJSONParser.parseExtra(obj, str);
                    return false;
                }
                jSONLexer2.nextTokenWithColon(defaultFieldDeserializer.getFastMatchToken());
                defaultFieldDeserializer.parseField(defaultJSONParser, obj, type, map);
                if (iArr != null) {
                    int i8 = i / 32;
                    iArr[i8] = iArr[i8] | (r17 << (i % 32));
                }
                return r17;
            }
            if (jSONLexer.isEnabled(Feature.IgnoreNotMatch)) {
                throw new JSONException("setter not found, class " + this.clazz.getName() + ", property " + str);
            }
            i2 = -1;
            i3 = 0;
            while (true) {
                fieldDeserializerArr2 = this.sortedFieldDeserializers;
                if (i3 < fieldDeserializerArr2.length) {
                    break;
                }
                FieldDeserializer fieldDeserializer3 = fieldDeserializerArr2[i3];
                fieldInfo = fieldDeserializer3.fieldInfo;
                if (!fieldInfo.unwrapped && (fieldDeserializer3 instanceof DefaultFieldDeserializer)) {
                    if (fieldInfo.field != null) {
                        DefaultFieldDeserializer defaultFieldDeserializer2 = (DefaultFieldDeserializer) fieldDeserializer3;
                        ObjectDeserializer fieldValueDeserilizer = defaultFieldDeserializer2.getFieldValueDeserilizer(defaultJSONParser.getConfig());
                        if (fieldValueDeserilizer instanceof JavaBeanDeserializer) {
                            FieldDeserializer fieldDeserializer4 = ((JavaBeanDeserializer) fieldValueDeserilizer).getFieldDeserializer(str);
                            if (fieldDeserializer4 != null) {
                                try {
                                    Object objCreateInstance = fieldInfo.field.get(obj);
                                    if (objCreateInstance == null) {
                                        objCreateInstance = ((JavaBeanDeserializer) fieldValueDeserilizer).createInstance(defaultJSONParser, fieldInfo.fieldType);
                                        fieldDeserializer3.setValue(obj, objCreateInstance);
                                    }
                                    jSONLexer.nextTokenWithColon(defaultFieldDeserializer2.getFastMatchToken());
                                    fieldDeserializer4.parseField(defaultJSONParser, objCreateInstance, type, map);
                                    i2 = i3;
                                } catch (Exception e) {
                                    throw new JSONException("parse unwrapped field error.", e);
                                }
                            } else {
                                continue;
                            }
                        } else if (fieldValueDeserilizer instanceof MapDeserializer) {
                            MapDeserializer mapDeserializer = (MapDeserializer) fieldValueDeserilizer;
                            try {
                                Map<Object, Object> mapCreateMap = (Map) fieldInfo.field.get(obj);
                                if (mapCreateMap == null) {
                                    mapCreateMap = mapDeserializer.createMap(fieldInfo.fieldType);
                                    fieldDeserializer3.setValue(obj, mapCreateMap);
                                }
                                jSONLexer.nextTokenWithColon();
                                mapCreateMap.put(str, defaultJSONParser.parse(str));
                                i2 = i3;
                            } catch (Exception e2) {
                                throw new JSONException("parse unwrapped field error.", e2);
                            }
                        } else {
                            continue;
                        }
                    } else if (fieldInfo.method.getParameterTypes().length == 2) {
                        jSONLexer.nextTokenWithColon();
                        Object obj3 = defaultJSONParser.parse(str);
                        try {
                            Method method = fieldInfo.method;
                            Object[] objArr = new Object[2];
                            objArr[0] = str;
                            objArr[r17] = obj3;
                            method.invoke(obj, objArr);
                            i2 = i3;
                        } catch (Exception e3) {
                            throw new JSONException("parse unwrapped field error.", e3);
                        }
                    } else {
                        continue;
                    }
                }
                i3++;
            }
            if (i2 != -1) {
                defaultJSONParser.parseExtra(obj, str);
                return false;
            }
            if (iArr != null) {
                int i9 = i2 / 32;
                iArr[i9] = iArr[i9] | (r17 << (i2 % 32));
            }
            return r17;
        }
        fieldDeserializer = fieldDeserializer2;
        z = true;
        defaultFieldDeserializer = fieldDeserializer;
        r17 = z;
        if (defaultFieldDeserializer == null) {
            JSONLexer jSONLexer3 = jSONLexer;
            i = 0;
            while (true) {
                fieldDeserializerArr = this.sortedFieldDeserializers;
                if (i < fieldDeserializerArr.length) {
                    i = -1;
                    break;
                }
                if (fieldDeserializerArr[i] == defaultFieldDeserializer) {
                    break;
                    break;
                }
                i++;
            }
            if (i == -1) {
            }
            jSONLexer3.nextTokenWithColon(defaultFieldDeserializer.getFastMatchToken());
            defaultFieldDeserializer.parseField(defaultJSONParser, obj, type, map);
            if (iArr != null) {
                int i10 = i / 32;
                iArr[i10] = iArr[i10] | (r17 << (i % 32));
            }
            return r17;
        }
        if (jSONLexer.isEnabled(Feature.IgnoreNotMatch)) {
            throw new JSONException("setter not found, class " + this.clazz.getName() + ", property " + str);
        }
        i2 = -1;
        i3 = 0;
        while (true) {
            fieldDeserializerArr2 = this.sortedFieldDeserializers;
            if (i3 < fieldDeserializerArr2.length) {
                break;
                break;
            }
            FieldDeserializer fieldDeserializer5 = fieldDeserializerArr2[i3];
            fieldInfo = fieldDeserializer5.fieldInfo;
            if (!fieldInfo.unwrapped) {
            }
            i3++;
        }
        if (i2 != -1) {
            defaultJSONParser.parseExtra(obj, str);
            return false;
        }
        if (iArr != null) {
            int i11 = i2 / 32;
            iArr[i11] = iArr[i11] | (r17 << (i2 % 32));
        }
        return r17;
    }

    public Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i, int[] iArr) {
        return deserialze(defaultJSONParser, type, obj, obj2, i, iArr);
    }

    public Enum scanEnum(JSONLexerBase jSONLexerBase, char[] cArr, ObjectDeserializer objectDeserializer) {
        EnumDeserializer enumDeserializer = objectDeserializer instanceof EnumDeserializer ? (EnumDeserializer) objectDeserializer : null;
        if (enumDeserializer == null) {
            jSONLexerBase.matchStat = -1;
            return null;
        }
        long jScanEnumSymbol = jSONLexerBase.scanEnumSymbol(cArr);
        if (jSONLexerBase.matchStat <= 0) {
            return null;
        }
        Enum enumByHashCode = enumDeserializer.getEnumByHashCode(jScanEnumSymbol);
        if (enumByHashCode == null) {
            if (jScanEnumSymbol == TypeUtils.fnv1a_64_magic_hashcode) {
                return null;
            }
            if (jSONLexerBase.isEnabled(Feature.ErrorOnEnumNotMatch)) {
                throw new JSONException("not match enum value, " + enumDeserializer.enumClass);
            }
        }
        return enumByHashCode;
    }

    public FieldDeserializer smartMatch(String str, int[] iArr) {
        boolean zStartsWith;
        if (str == null) {
            return null;
        }
        FieldDeserializer fieldDeserializer = getFieldDeserializer(str, iArr);
        if (fieldDeserializer == null) {
            int i = 0;
            if (this.smartMatchHashArray == null) {
                long[] jArr = new long[this.sortedFieldDeserializers.length];
                int i2 = 0;
                while (true) {
                    FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                    if (i2 >= fieldDeserializerArr.length) {
                        break;
                    }
                    jArr[i2] = fieldDeserializerArr[i2].fieldInfo.nameHashCode;
                    i2++;
                }
                Arrays.sort(jArr);
                this.smartMatchHashArray = jArr;
            }
            int iBinarySearch = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_lower(str));
            if (iBinarySearch < 0) {
                iBinarySearch = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_extract(str));
            }
            if (iBinarySearch < 0) {
                zStartsWith = str.startsWith(p3.g);
                if (zStartsWith) {
                    iBinarySearch = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_extract(str.substring(2)));
                }
            } else {
                zStartsWith = false;
            }
            if (iBinarySearch >= 0) {
                if (this.smartMatchHashArrayMapping == null) {
                    short[] sArr = new short[this.smartMatchHashArray.length];
                    Arrays.fill(sArr, (short) -1);
                    while (true) {
                        FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                        if (i >= fieldDeserializerArr2.length) {
                            break;
                        }
                        int iBinarySearch2 = Arrays.binarySearch(this.smartMatchHashArray, fieldDeserializerArr2[i].fieldInfo.nameHashCode);
                        if (iBinarySearch2 >= 0) {
                            sArr[iBinarySearch2] = (short) i;
                        }
                        i++;
                    }
                    this.smartMatchHashArrayMapping = sArr;
                }
                short s = this.smartMatchHashArrayMapping[iBinarySearch];
                if (s != -1 && !isSetFlag(s, iArr)) {
                    fieldDeserializer = this.sortedFieldDeserializers[s];
                }
            }
            if (fieldDeserializer != null) {
                FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                if ((fieldInfo.parserFeatures & Feature.DisableFieldSmartMatch.mask) != 0) {
                    return null;
                }
                Class<?> cls = fieldInfo.fieldClass;
                if (zStartsWith && cls != Boolean.TYPE && cls != Boolean.class) {
                    return null;
                }
            }
        }
        return fieldDeserializer;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 24561. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r34, java.lang.reflect.Type r35, java.lang.Object r36, java.lang.Object r37, int r38, int[] r39) {
        /*
            Method dump skipped, instruction units count: 2456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object, int, int[]):java.lang.Object");
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo) {
        ParserConfig.AutoTypeCheckHandler autoTypeCheckHandlerNewInstance;
        this.clazz = javaBeanInfo.clazz;
        this.beanInfo = javaBeanInfo;
        JSONType jSONType = javaBeanInfo.jsonType;
        HashMap map = null;
        if (jSONType == null || jSONType.autoTypeCheckHandler() == ParserConfig.AutoTypeCheckHandler.class) {
            autoTypeCheckHandlerNewInstance = null;
        } else {
            try {
                autoTypeCheckHandlerNewInstance = javaBeanInfo.jsonType.autoTypeCheckHandler().newInstance();
            } catch (Exception unused) {
                autoTypeCheckHandlerNewInstance = null;
            }
        }
        this.autoTypeCheckHandler = autoTypeCheckHandlerNewInstance;
        FieldInfo[] fieldInfoArr = javaBeanInfo.sortedFields;
        this.sortedFieldDeserializers = new FieldDeserializer[fieldInfoArr.length];
        int length = fieldInfoArr.length;
        for (int i = 0; i < length; i++) {
            FieldInfo fieldInfo = javaBeanInfo.sortedFields[i];
            FieldDeserializer fieldDeserializerCreateFieldDeserializer = parserConfig.createFieldDeserializer(parserConfig, javaBeanInfo, fieldInfo);
            this.sortedFieldDeserializers[i] = fieldDeserializerCreateFieldDeserializer;
            if (length > 128) {
                if (this.fieldDeserializerMap == null) {
                    this.fieldDeserializerMap = new HashMap();
                }
                this.fieldDeserializerMap.put(fieldInfo.name, fieldDeserializerCreateFieldDeserializer);
            }
            for (String str : fieldInfo.alternateNames) {
                if (map == null) {
                    map = new HashMap();
                }
                map.put(str, fieldDeserializerCreateFieldDeserializer);
            }
        }
        this.alterNameFieldDeserializers = map;
        FieldInfo[] fieldInfoArr2 = javaBeanInfo.fields;
        this.fieldDeserializers = new FieldDeserializer[fieldInfoArr2.length];
        int length2 = fieldInfoArr2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            this.fieldDeserializers[i2] = getFieldDeserializer(javaBeanInfo.fields[i2].name);
        }
    }

    public FieldDeserializer getFieldDeserializer(long j) {
        int i = 0;
        if (this.hashArray == null) {
            long[] jArr = new long[this.sortedFieldDeserializers.length];
            int i2 = 0;
            while (true) {
                FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                if (i2 >= fieldDeserializerArr.length) {
                    break;
                }
                jArr[i2] = TypeUtils.fnv1a_64(fieldDeserializerArr[i2].fieldInfo.name);
                i2++;
            }
            Arrays.sort(jArr);
            this.hashArray = jArr;
        }
        int iBinarySearch = Arrays.binarySearch(this.hashArray, j);
        if (iBinarySearch < 0) {
            return null;
        }
        if (this.hashArrayMapping == null) {
            short[] sArr = new short[this.hashArray.length];
            Arrays.fill(sArr, (short) -1);
            while (true) {
                FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                if (i >= fieldDeserializerArr2.length) {
                    break;
                }
                int iBinarySearch2 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(fieldDeserializerArr2[i].fieldInfo.name));
                if (iBinarySearch2 >= 0) {
                    sArr[iBinarySearch2] = (short) i;
                }
                i++;
            }
            this.hashArrayMapping = sArr;
        }
        short s = this.hashArrayMapping[iBinarySearch];
        if (s != -1) {
            return this.sortedFieldDeserializers[s];
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006a  */
    public Object createInstance(Map<String, Object> map, ParserConfig parserConfig) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean z;
        Constructor<?> constructor;
        FieldInfo[] fieldInfoArr;
        Integer num;
        Object objCast;
        float f;
        double d;
        String jSONString;
        JavaBeanInfo javaBeanInfo = this.beanInfo;
        if (javaBeanInfo.creatorConstructor == null && javaBeanInfo.factoryMethod == null) {
            Object objCreateInstance = createInstance((DefaultJSONParser) null, this.clazz);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                FieldDeserializer fieldDeserializerSmartMatch = smartMatch(key);
                if (fieldDeserializerSmartMatch != null) {
                    FieldInfo fieldInfo = fieldDeserializerSmartMatch.fieldInfo;
                    Field field = fieldInfo.field;
                    Type type = fieldInfo.fieldType;
                    Class<?> cls = fieldInfo.fieldClass;
                    JSONField annotation = fieldInfo.getAnnotation();
                    if (fieldInfo.declaringClass != null && (!cls.isInstance(value) || (annotation != null && annotation.deserializeUsing() != Void.class))) {
                        if (value instanceof String) {
                            jSONString = (String) value;
                            if (!JSONValidator.from(jSONString).validate()) {
                                jSONString = JSON.toJSONString(value);
                            }
                        } else {
                            jSONString = JSON.toJSONString(value);
                        }
                        fieldDeserializerSmartMatch.parseField(new DefaultJSONParser(jSONString), objCreateInstance, type, null);
                    } else {
                        if (field != null && fieldInfo.method == null) {
                            Class<?> type2 = field.getType();
                            if (type2 == Boolean.TYPE) {
                                if (value == Boolean.FALSE) {
                                    field.setBoolean(objCreateInstance, false);
                                } else if (value == Boolean.TRUE) {
                                    field.setBoolean(objCreateInstance, true);
                                }
                            } else if (type2 == Integer.TYPE) {
                                if (value instanceof Number) {
                                    field.setInt(objCreateInstance, ((Number) value).intValue());
                                }
                            } else if (type2 == Long.TYPE) {
                                if (value instanceof Number) {
                                    field.setLong(objCreateInstance, ((Number) value).longValue());
                                }
                            } else if (type2 == Float.TYPE) {
                                if (value instanceof Number) {
                                    field.setFloat(objCreateInstance, ((Number) value).floatValue());
                                } else if (value instanceof String) {
                                    String str = (String) value;
                                    if (str.length() <= 10) {
                                        f = TypeUtils.parseFloat(str);
                                    } else {
                                        f = Float.parseFloat(str);
                                    }
                                    field.setFloat(objCreateInstance, f);
                                }
                            } else if (type2 == Double.TYPE) {
                                if (value instanceof Number) {
                                    field.setDouble(objCreateInstance, ((Number) value).doubleValue());
                                } else if (value instanceof String) {
                                    String str2 = (String) value;
                                    if (str2.length() <= 10) {
                                        d = TypeUtils.parseDouble(str2);
                                    } else {
                                        d = Double.parseDouble(str2);
                                    }
                                    field.setDouble(objCreateInstance, d);
                                }
                            } else if (value != null && type == value.getClass()) {
                                field.set(objCreateInstance, value);
                            }
                        }
                        String str3 = fieldInfo.format;
                        if (str3 != null && type == Date.class) {
                            objCast = TypeUtils.castToDate(value, str3);
                        } else if (str3 != null && (type instanceof Class) && ((Class) type).getName().equals("java.time.LocalDateTime")) {
                            objCast = Jdk8DateCodec.castToLocalDateTime(value, str3);
                        } else if (type instanceof ParameterizedType) {
                            objCast = TypeUtils.cast(value, (ParameterizedType) type, parserConfig);
                        } else {
                            objCast = TypeUtils.cast(value, type, parserConfig);
                        }
                        fieldDeserializerSmartMatch.setValue(objCreateInstance, objCast);
                    }
                }
            }
            Method method = this.beanInfo.buildMethod;
            if (method == null) {
                return objCreateInstance;
            }
            try {
                return method.invoke(objCreateInstance, new Object[0]);
            } catch (Exception e) {
                throw new JSONException("build object error", e);
            }
        }
        FieldInfo[] fieldInfoArr2 = javaBeanInfo.fields;
        int length = fieldInfoArr2.length;
        Object[] objArr = new Object[length];
        HashMap map2 = null;
        for (int i = 0; i < length; i++) {
            FieldInfo fieldInfo2 = fieldInfoArr2[i];
            Object objValueOf = map.get(fieldInfo2.name);
            if (objValueOf == null) {
                Class<?> cls2 = fieldInfo2.fieldClass;
                if (cls2 == Integer.TYPE) {
                    objValueOf = 0;
                } else if (cls2 == Long.TYPE) {
                    objValueOf = 0L;
                } else if (cls2 == Short.TYPE) {
                    objValueOf = (short) 0;
                } else if (cls2 == Byte.TYPE) {
                    objValueOf = (byte) 0;
                } else if (cls2 == Float.TYPE) {
                    objValueOf = Float.valueOf(0.0f);
                } else if (cls2 == Double.TYPE) {
                    objValueOf = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
                } else if (cls2 == Character.TYPE) {
                    objValueOf = '0';
                } else if (cls2 == Boolean.TYPE) {
                    objValueOf = Boolean.FALSE;
                }
                if (map2 == null) {
                    map2 = new HashMap();
                }
                map2.put(fieldInfo2.name, Integer.valueOf(i));
            }
            objArr[i] = objValueOf;
        }
        if (map2 != null) {
            for (Map.Entry<String, Object> entry2 : map.entrySet()) {
                String key2 = entry2.getKey();
                Object value2 = entry2.getValue();
                FieldDeserializer fieldDeserializerSmartMatch2 = smartMatch(key2);
                if (fieldDeserializerSmartMatch2 != null && (num = (Integer) map2.get(fieldDeserializerSmartMatch2.fieldInfo.name)) != null) {
                    objArr[num.intValue()] = value2;
                }
            }
        }
        JavaBeanInfo javaBeanInfo2 = this.beanInfo;
        if (javaBeanInfo2.creatorConstructor != null) {
            if (javaBeanInfo2.kotlin) {
                z = false;
                for (int i2 = 0; i2 < length; i2++) {
                    Object obj = objArr[i2];
                    if (obj == null) {
                        FieldInfo[] fieldInfoArr3 = this.beanInfo.fields;
                        if (fieldInfoArr3 != null && i2 < fieldInfoArr3.length && fieldInfoArr3[i2].fieldClass == String.class) {
                            z = true;
                        }
                    } else {
                        Class<?> cls3 = obj.getClass();
                        Class<?> cls4 = this.beanInfo.fields[i2].fieldClass;
                        if (cls3 != cls4) {
                            objArr[i2] = TypeUtils.cast(obj, (Class) cls4, parserConfig);
                        }
                    }
                }
            } else {
                z = false;
            }
            if (z && (constructor = this.beanInfo.kotlinDefaultConstructor) != null) {
                try {
                    Object objNewInstance = constructor.newInstance(new Object[0]);
                    for (int i3 = 0; i3 < length; i3++) {
                        Object obj2 = objArr[i3];
                        if (obj2 != null && (fieldInfoArr = this.beanInfo.fields) != null && i3 < fieldInfoArr.length) {
                            fieldInfoArr[i3].set(objNewInstance, obj2);
                        }
                    }
                    return objNewInstance;
                } catch (Exception e2) {
                    throw new JSONException("create instance error, " + this.beanInfo.creatorConstructor.toGenericString(), e2);
                }
            }
            try {
                return this.beanInfo.creatorConstructor.newInstance(objArr);
            } catch (Exception e3) {
                throw new JSONException("create instance error, " + this.beanInfo.creatorConstructor.toGenericString(), e3);
            }
        }
        Method method2 = javaBeanInfo2.factoryMethod;
        if (method2 == null) {
            return null;
        }
        try {
            return method2.invoke(null, objArr);
        } catch (Exception e4) {
            throw new JSONException("create factory method error, " + this.beanInfo.factoryMethod.toString(), e4);
        }
    }
}
