package com.alibaba.fastjson.util;

import com.acse.ottn.p3;
import com.alibaba.alibclinkpartner.smartlink.constants.ALPUserTrackConstant;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONPOJOBuilder;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zj.adlib.y6b;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class JavaBeanInfo {
    public final Method buildMethod;
    public final Class<?> builderClass;
    public final Class<?> clazz;
    public final Constructor<?> creatorConstructor;
    public Type[] creatorConstructorParameterTypes;
    public String[] creatorConstructorParameters;
    public final Constructor<?> defaultConstructor;
    public final int defaultConstructorParameterSize;
    public final Method factoryMethod;
    public final FieldInfo[] fields;
    public final JSONType jsonType;
    public boolean kotlin;
    public Constructor<?> kotlinDefaultConstructor;
    public String[] orders;
    public final int parserFeatures;
    public final FieldInfo[] sortedFields;
    public final String typeKey;
    public final String typeName;

    public JavaBeanInfo(Class<?> cls, Class<?> cls2, Constructor<?> constructor, Constructor<?> constructor2, Method method, Method method2, JSONType jSONType, List<FieldInfo> list) {
        JSONField jSONField;
        this.clazz = cls;
        this.builderClass = cls2;
        this.defaultConstructor = constructor;
        this.creatorConstructor = constructor2;
        this.factoryMethod = method;
        this.parserFeatures = TypeUtils.getParserFeatures(cls);
        this.buildMethod = method2;
        this.jsonType = jSONType;
        if (jSONType != null) {
            String strTypeName = jSONType.typeName();
            String strTypeKey = jSONType.typeKey();
            this.typeKey = strTypeKey.length() <= 0 ? null : strTypeKey;
            if (strTypeName.length() != 0) {
                this.typeName = strTypeName;
            } else {
                this.typeName = cls.getName();
            }
            String[] strArrOrders = jSONType.orders();
            this.orders = strArrOrders.length == 0 ? null : strArrOrders;
        } else {
            this.typeName = cls.getName();
            this.typeKey = null;
            this.orders = null;
        }
        FieldInfo[] fieldInfoArr = new FieldInfo[list.size()];
        this.fields = fieldInfoArr;
        list.toArray(fieldInfoArr);
        FieldInfo[] fieldInfoArr2 = new FieldInfo[fieldInfoArr.length];
        boolean z = false;
        if (this.orders != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
            for (FieldInfo fieldInfo : fieldInfoArr) {
                linkedHashMap.put(fieldInfo.name, fieldInfo);
            }
            int i = 0;
            for (String str : this.orders) {
                FieldInfo fieldInfo2 = (FieldInfo) linkedHashMap.get(str);
                if (fieldInfo2 != null) {
                    fieldInfoArr2[i] = fieldInfo2;
                    linkedHashMap.remove(str);
                    i++;
                }
            }
            Iterator it = linkedHashMap.values().iterator();
            while (it.hasNext()) {
                fieldInfoArr2[i] = (FieldInfo) it.next();
                i++;
            }
        } else {
            System.arraycopy(fieldInfoArr, 0, fieldInfoArr2, 0, fieldInfoArr.length);
            Arrays.sort(fieldInfoArr2);
        }
        this.sortedFields = Arrays.equals(this.fields, fieldInfoArr2) ? this.fields : fieldInfoArr2;
        if (constructor != null) {
            this.defaultConstructorParameterSize = constructor.getParameterTypes().length;
        } else if (method != null) {
            this.defaultConstructorParameterSize = method.getParameterTypes().length;
        } else {
            this.defaultConstructorParameterSize = 0;
        }
        if (constructor2 != null) {
            this.creatorConstructorParameterTypes = constructor2.getParameterTypes();
            boolean zIsKotlin = TypeUtils.isKotlin(cls);
            this.kotlin = zIsKotlin;
            if (!zIsKotlin) {
                if (this.creatorConstructorParameterTypes.length == this.fields.length) {
                    int i2 = 0;
                    while (true) {
                        Type[] typeArr = this.creatorConstructorParameterTypes;
                        if (i2 >= typeArr.length) {
                            z = true;
                            break;
                        } else if (typeArr[i2] != this.fields[i2].fieldClass) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                if (z) {
                    return;
                }
                this.creatorConstructorParameters = ASMUtils.lookupParameterNames(constructor2);
                return;
            }
            this.creatorConstructorParameters = TypeUtils.getKoltinConstructorParameters(cls);
            try {
                this.kotlinDefaultConstructor = cls.getConstructor(new Class[0]);
            } catch (Throwable unused) {
            }
            Annotation[][] parameterAnnotations = TypeUtils.getParameterAnnotations(constructor2);
            for (int i3 = 0; i3 < this.creatorConstructorParameters.length && i3 < parameterAnnotations.length; i3++) {
                Annotation[] annotationArr = parameterAnnotations[i3];
                int length = annotationArr.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        jSONField = null;
                        break;
                    }
                    Annotation annotation = annotationArr[i4];
                    if (annotation instanceof JSONField) {
                        jSONField = (JSONField) annotation;
                        break;
                    }
                    i4++;
                }
                if (jSONField != null) {
                    String strName = jSONField.name();
                    if (strName.length() > 0) {
                        this.creatorConstructorParameters[i3] = strName;
                    }
                }
            }
        }
    }

    public static boolean add(List<FieldInfo> list, FieldInfo fieldInfo) {
        for (int size = list.size() - 1; size >= 0; size--) {
            FieldInfo fieldInfo2 = list.get(size);
            if (fieldInfo2.name.equals(fieldInfo.name) && (!fieldInfo2.getOnly || fieldInfo.getOnly)) {
                if (fieldInfo2.fieldClass.isAssignableFrom(fieldInfo.fieldClass)) {
                    list.set(size, fieldInfo);
                    return true;
                }
                if (fieldInfo2.compareTo(fieldInfo) >= 0) {
                    return false;
                }
                list.set(size, fieldInfo);
                return true;
            }
        }
        list.add(fieldInfo);
        return true;
    }

    public static JavaBeanInfo build(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy) {
        return build(cls, type, propertyNamingStrategy, false, TypeUtils.compatibleWithJavaBean, false);
    }

    private static Map<TypeVariable, Type> buildGenericInfo(Class<?> cls) {
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap map = null;
        if (superclass == null) {
            return null;
        }
        while (true) {
            Class<? super Object> cls2 = superclass;
            Class<?> cls3 = cls;
            cls = cls2;
            if (cls == null || cls == Object.class) {
                break;
            }
            if (cls3.getGenericSuperclass() instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) cls3.getGenericSuperclass()).getActualTypeArguments();
                TypeVariable<Class<?>>[] typeParameters = cls.getTypeParameters();
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    if (map.containsKey(actualTypeArguments[i])) {
                        map.put(typeParameters[i], map.get(actualTypeArguments[i]));
                    } else {
                        map.put(typeParameters[i], actualTypeArguments[i]);
                    }
                }
            }
            superclass = cls.getSuperclass();
        }
        return map;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0064  */
    /* JADX WARN: Code duplicated, block: B:33:0x007c  */
    /* JADX WARN: Code duplicated, block: B:35:0x008b  */
    /* JADX WARN: Code duplicated, block: B:38:0x0092  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:44:0x00be  */
    /* JADX WARN: Code duplicated, block: B:51:0x0077 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:6:0x0019  */
    private static void computeFields(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy, List<FieldInfo> list, Field[] fieldArr) {
        Iterator<FieldInfo> it;
        String name;
        JSONField jSONField;
        int i;
        int i2;
        int i3;
        Map<TypeVariable, Type> mapBuildGenericInfo = buildGenericInfo(cls);
        int i4 = 0;
        for (int length = fieldArr.length; i4 < length; length = length) {
            Field field = fieldArr[i4];
            int modifiers = field.getModifiers();
            if ((modifiers & 8) == 0) {
                boolean z = true;
                if ((modifiers & 16) != 0) {
                    Class<?> type2 = field.getType();
                    if (Map.class.isAssignableFrom(type2) || Collection.class.isAssignableFrom(type2) || AtomicLong.class.equals(type2) || AtomicInteger.class.equals(type2) || AtomicBoolean.class.equals(type2)) {
                        it = list.iterator();
                        do {
                            if (it.hasNext()) {
                                z = false;
                                break;
                            }
                        } while (!it.next().name.equals(field.getName()));
                        if (z) {
                            name = field.getName();
                            jSONField = (JSONField) TypeUtils.getAnnotation(field, JSONField.class);
                            if (jSONField != null) {
                                i = 0;
                                i2 = 0;
                                i3 = 0;
                            } else if (!jSONField.deserialize()) {
                                int iOrdinal = jSONField.ordinal();
                                int iOf = SerializerFeature.of(jSONField.serialzeFeatures());
                                int iOf2 = Feature.of(jSONField.parseFeatures());
                                if (jSONField.name().length() != 0) {
                                    name = jSONField.name();
                                }
                                i = iOrdinal;
                                i2 = iOf;
                                i3 = iOf2;
                            }
                            if (propertyNamingStrategy != null) {
                                name = propertyNamingStrategy.translate(name);
                            }
                            add(list, new FieldInfo(name, null, field, cls, type, i, i2, i3, null, jSONField, null, mapBuildGenericInfo));
                        }
                    }
                } else {
                    it = list.iterator();
                    do {
                        if (it.hasNext()) {
                            z = false;
                            break;
                        }
                    } while (!it.next().name.equals(field.getName()));
                    if (z) {
                        name = field.getName();
                        jSONField = (JSONField) TypeUtils.getAnnotation(field, JSONField.class);
                        if (jSONField != null) {
                            i = 0;
                            i2 = 0;
                            i3 = 0;
                        } else if (!jSONField.deserialize()) {
                            int iOrdinal2 = jSONField.ordinal();
                            int iOf3 = SerializerFeature.of(jSONField.serialzeFeatures());
                            int iOf4 = Feature.of(jSONField.parseFeatures());
                            if (jSONField.name().length() != 0) {
                                name = jSONField.name();
                            }
                            i = iOrdinal2;
                            i2 = iOf3;
                            i3 = iOf4;
                        }
                        if (propertyNamingStrategy != null) {
                            name = propertyNamingStrategy.translate(name);
                        }
                        add(list, new FieldInfo(name, null, field, cls, type, i, i2, i3, null, jSONField, null, mapBuildGenericInfo));
                    }
                }
            }
            i4++;
        }
    }

    public static Class<?> getBuilderClass(JSONType jSONType) {
        return getBuilderClass(null, jSONType);
    }

    public static Constructor<?> getCreatorConstructor(Constructor[] constructorArr) {
        boolean z;
        Constructor constructor = null;
        for (Constructor constructor2 : constructorArr) {
            if (((JSONCreator) constructor2.getAnnotation(JSONCreator.class)) != null) {
                if (constructor != null) {
                    throw new JSONException("multi-JSONCreator");
                }
                constructor = constructor2;
            }
        }
        if (constructor != null) {
            return constructor;
        }
        for (Constructor constructor3 : constructorArr) {
            Annotation[][] parameterAnnotations = TypeUtils.getParameterAnnotations(constructor3);
            if (parameterAnnotations.length != 0) {
                int length = parameterAnnotations.length;
                int i = 0;
                while (true) {
                    z = true;
                    if (i >= length) {
                        break;
                    }
                    Annotation[] annotationArr = parameterAnnotations[i];
                    int length2 = annotationArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            z = false;
                            break;
                        }
                        if (annotationArr[i2] instanceof JSONField) {
                            break;
                        }
                        i2++;
                    }
                    if (!z) {
                        z = false;
                        break;
                    }
                    i++;
                }
                if (!z) {
                    continue;
                } else {
                    if (constructor != null) {
                        throw new JSONException("multi-JSONCreator");
                    }
                    constructor = constructor3;
                }
            }
        }
        return constructor;
    }

    public static Constructor<?> getDefaultConstructor(Class<?> cls, Constructor<?>[] constructorArr) {
        Constructor<?> constructor = null;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        for (Constructor<?> constructor2 : constructorArr) {
            if (constructor2.getParameterTypes().length == 0) {
                constructor = constructor2;
                break;
            }
        }
        if (constructor != null || !cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
            return constructor;
        }
        for (Constructor<?> constructor3 : constructorArr) {
            Class<?>[] parameterTypes = constructor3.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0].equals(cls.getDeclaringClass())) {
                return constructor3;
            }
        }
        return constructor;
    }

    private static Method getFactoryMethod(Class<?> cls, Method[] methodArr, boolean z) {
        Method method = null;
        for (Method method2 : methodArr) {
            if (Modifier.isStatic(method2.getModifiers()) && cls.isAssignableFrom(method2.getReturnType()) && ((JSONCreator) TypeUtils.getAnnotation(method2, JSONCreator.class)) != null) {
                if (method != null) {
                    throw new JSONException("multi-JSONCreator");
                }
                method = method2;
            }
        }
        if (method != null || !z) {
            return method;
        }
        for (Method method3 : methodArr) {
            if (TypeUtils.isJacksonCreator(method3)) {
                return method3;
            }
        }
        return method;
    }

    private static FieldInfo getField(List<FieldInfo> list, String str) {
        for (FieldInfo fieldInfo : list) {
            if (fieldInfo.name.equals(str)) {
                return fieldInfo;
            }
            Field field = fieldInfo.field;
            if (field != null && fieldInfo.getAnnotation() != null && field.getName().equals(str)) {
                return fieldInfo;
            }
        }
        return null;
    }

    public static JavaBeanInfo build(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy, boolean z, boolean z2) {
        return build(cls, type, propertyNamingStrategy, z, z2, false);
    }

    public static Class<?> getBuilderClass(Class<?> cls, JSONType jSONType) {
        Class<?> clsBuilder;
        if (cls != null && cls.getName().equals("org.springframework.security.web.savedrequest.DefaultSavedRequest")) {
            return TypeUtils.loadClass("org.springframework.security.web.savedrequest.DefaultSavedRequest$Builder");
        }
        if (jSONType == null || (clsBuilder = jSONType.builder()) == Void.class) {
            return null;
        }
        return clsBuilder;
    }

    /* JADX WARN: Code duplicated, block: B:188:0x038f  */
    /* JADX WARN: Code duplicated, block: B:189:0x0395  */
    /* JADX WARN: Code duplicated, block: B:244:0x04e6  */
    /* JADX WARN: Code duplicated, block: B:307:0x06e3  */
    /* JADX WARN: Code duplicated, block: B:346:0x07f3  */
    /* JADX WARN: Code duplicated, block: B:354:0x0854 A[PHI: r6 r22 r23
      0x0854: PHI (r6v7 int) = (r6v6 int), (r6v11 int) binds: [B:347:0x0803, B:352:0x0828] A[DONT_GENERATE, DONT_INLINE]
      0x0854: PHI (r22v15 int) = (r22v14 int), (r22v20 int) binds: [B:347:0x0803, B:352:0x0828] A[DONT_GENERATE, DONT_INLINE]
      0x0854: PHI (r23v14 int) = (r23v13 int), (r23v17 int) binds: [B:347:0x0803, B:352:0x0828] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:366:0x0879  */
    /* JADX WARN: Code duplicated, block: B:369:0x0884  */
    /* JADX WARN: Code duplicated, block: B:371:0x0890  */
    /* JADX WARN: Code duplicated, block: B:373:0x089c  */
    /* JADX WARN: Code duplicated, block: B:376:0x08aa  */
    /* JADX WARN: Code duplicated, block: B:406:0x0951  */
    /* JADX WARN: Code duplicated, block: B:408:0x0957  */
    /* JADX WARN: Code duplicated, block: B:410:0x0972  */
    /* JADX WARN: Code duplicated, block: B:412:0x0976  */
    /* JADX WARN: Code duplicated, block: B:413:0x0980  */
    /* JADX WARN: Code duplicated, block: B:415:0x0987  */
    /* JADX WARN: Code duplicated, block: B:417:0x098d  */
    /* JADX WARN: Code duplicated, block: B:419:0x0994  */
    /* JADX WARN: Code duplicated, block: B:420:0x09b9  */
    /* JADX WARN: Code duplicated, block: B:421:0x09bb  */
    /* JADX WARN: Code duplicated, block: B:424:0x09c0  */
    /* JADX WARN: Code duplicated, block: B:426:0x09cc  */
    /* JADX WARN: Code duplicated, block: B:428:0x09d2  */
    /* JADX WARN: Code duplicated, block: B:430:0x09e4  */
    /* JADX WARN: Code duplicated, block: B:432:0x0a02  */
    /* JADX WARN: Code duplicated, block: B:434:0x0a47  */
    /* JADX WARN: Code duplicated, block: B:437:0x0a5c  */
    /* JADX WARN: Code duplicated, block: B:490:0x0bb3  */
    /* JADX WARN: Code duplicated, block: B:542:0x0899 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:408:0x0957, please report this as an issue */
    public static JavaBeanInfo build(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy, boolean z, boolean z2, boolean z3) {
        Constructor<?> defaultConstructor;
        Constructor<?> constructor;
        Class<String> cls2;
        Class<Collection> cls3;
        ArrayList arrayList;
        Method[] methodArr;
        Field[] fieldArr;
        int i;
        int i2;
        Class cls4;
        Constructor<?> constructor2;
        PropertyNamingStrategy propertyNamingStrategy2;
        String str;
        Class<?> cls5;
        Field[] fieldArr2;
        JSONType jSONType;
        ArrayList arrayList2;
        int i3;
        Class cls6;
        String str2;
        int i4;
        Class<Collection> cls7;
        Field[] fieldArr3;
        Class cls8;
        String propertyNameByMethodName;
        Field[] fieldArr4;
        Field field;
        Method[] methodArr2;
        Class<String> cls9;
        int i5;
        Class cls10;
        char cCharAt;
        Method[] methodArr3;
        ArrayList arrayList3;
        Class<?> cls11;
        Field[] fieldArr5;
        String propertyNameByMethodName2;
        Field field2;
        boolean z4;
        int i6;
        Field field3;
        Class cls12;
        JSONField jSONField;
        int i7;
        int i8;
        PropertyNamingStrategy propertyNamingStrategy3;
        JSONField jSONField2;
        Field[] fieldArr6;
        int i9;
        int i10;
        int i11;
        int i12;
        String str3;
        StringBuilder sb;
        String str4;
        String str5;
        char cCharAt2;
        Constructor<?> creatorConstructor;
        Class<String> cls13;
        Class<?> cls14;
        Class<String> cls15;
        Class<?> cls16;
        Class<Collection> cls17;
        String[] strArr;
        Constructor<?>[] constructorArr;
        String[] strArrLookupParameterNames;
        String[] strArrLookupParameterNames2;
        Class<?>[] parameterTypes;
        Class<Collection> cls18;
        JSONField jSONField3;
        Class cls19;
        int iOrdinal;
        int iOf;
        int iOf2;
        JSONField jSONField4;
        String strName;
        int i13;
        int i14;
        int iOf3;
        Class<String> cls20;
        JSONField jSONField5;
        Field field4;
        String strName2;
        int iOrdinal2;
        int iOf4;
        int iOf5;
        Field field5;
        String[] strArr2;
        Constructor<?> creatorConstructor2;
        PropertyNamingStrategy propertyNamingStrategyNaming;
        Class<?> cls21 = cls;
        boolean z5 = z3;
        JSONType jSONType2 = (JSONType) TypeUtils.getAnnotation(cls21, JSONType.class);
        PropertyNamingStrategy propertyNamingStrategy4 = (jSONType2 == null || (propertyNamingStrategyNaming = jSONType2.naming()) == null || propertyNamingStrategyNaming == PropertyNamingStrategy.CamelCase) ? propertyNamingStrategy : propertyNamingStrategyNaming;
        Class<?> builderClass = getBuilderClass(cls21, jSONType2);
        Field[] declaredFields = cls.getDeclaredFields();
        Method[] methods = cls.getMethods();
        Map<TypeVariable, Type> mapBuildGenericInfo = buildGenericInfo(cls);
        boolean zIsKotlin = TypeUtils.isKotlin(cls);
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (!zIsKotlin || declaredConstructors.length == 1) {
            if (builderClass == null) {
                defaultConstructor = getDefaultConstructor(cls21, declaredConstructors);
            } else {
                defaultConstructor = getDefaultConstructor(builderClass, builderClass.getDeclaredConstructors());
            }
            constructor = defaultConstructor;
        } else {
            constructor = null;
        }
        Method method = null;
        Method factoryMethod = null;
        ArrayList arrayList4 = new ArrayList();
        if (z) {
            for (Class<?> superclass = cls21; superclass != null; superclass = superclass.getSuperclass()) {
                computeFields(cls21, type, propertyNamingStrategy4, arrayList4, superclass.getDeclaredFields());
            }
            if (constructor != null) {
                TypeUtils.setAccessible(constructor);
            }
            return new JavaBeanInfo(cls, builderClass, constructor, null, null, null, jSONType2, arrayList4);
        }
        boolean z6 = cls.isInterface() || Modifier.isAbstract(cls.getModifiers());
        Class<Collection> cls22 = Collection.class;
        Class<String> cls23 = String.class;
        Class<?> cls24 = Object.class;
        PropertyNamingStrategy propertyNamingStrategy5 = propertyNamingStrategy4;
        Class cls25 = JSONField.class;
        if ((constructor == null && builderClass == null) || z6) {
            Type mixInAnnotations = JSON.getMixInAnnotations(cls);
            if (!(mixInAnnotations instanceof Class) || (creatorConstructor2 = getCreatorConstructor(((Class) mixInAnnotations).getConstructors())) == null) {
                creatorConstructor = null;
            } else {
                try {
                    creatorConstructor = cls21.getConstructor(creatorConstructor2.getParameterTypes());
                } catch (NoSuchMethodException unused) {
                    creatorConstructor = null;
                }
            }
            if (creatorConstructor == null) {
                creatorConstructor = getCreatorConstructor(declaredConstructors);
            }
            constructor2 = creatorConstructor;
            if (constructor2 != null && !z6) {
                TypeUtils.setAccessible(constructor2);
                Class<?>[] parameterTypes2 = constructor2.getParameterTypes();
                if (parameterTypes2.length > 0) {
                    Annotation[][] parameterAnnotations = TypeUtils.getParameterAnnotations(constructor2);
                    String[] strArrLookupParameterNames3 = null;
                    int i15 = 0;
                    while (i15 < parameterTypes2.length && i15 < parameterAnnotations.length) {
                        Annotation[] annotationArr = parameterAnnotations[i15];
                        int length = annotationArr.length;
                        int i16 = 0;
                        while (true) {
                            cls20 = cls23;
                            if (i16 >= length) {
                                jSONField5 = null;
                                break;
                            }
                            Annotation annotation = annotationArr[i16];
                            Annotation[] annotationArr2 = annotationArr;
                            if (annotation instanceof JSONField) {
                                jSONField5 = (JSONField) annotation;
                                break;
                            }
                            i16++;
                            annotationArr = annotationArr2;
                            cls23 = cls20;
                        }
                        Class<?> cls26 = parameterTypes2[i15];
                        Type type2 = constructor2.getGenericParameterTypes()[i15];
                        if (jSONField5 != null) {
                            field4 = TypeUtils.getField(cls21, jSONField5.name(), declaredFields);
                            iOrdinal2 = jSONField5.ordinal();
                            iOf4 = SerializerFeature.of(jSONField5.serialzeFeatures());
                            iOf5 = Feature.of(jSONField5.parseFeatures());
                            strName2 = jSONField5.name();
                        } else {
                            field4 = null;
                            strName2 = null;
                            iOrdinal2 = 0;
                            iOf4 = 0;
                            iOf5 = 0;
                        }
                        if (strName2 == null || strName2.length() == 0) {
                            if (strArrLookupParameterNames3 == null) {
                                strArrLookupParameterNames3 = ASMUtils.lookupParameterNames(constructor2);
                            }
                            strName2 = strArrLookupParameterNames3[i15];
                        }
                        if (field4 == null) {
                            if (strArrLookupParameterNames3 == null) {
                                if (zIsKotlin) {
                                    strArrLookupParameterNames3 = TypeUtils.getKoltinConstructorParameters(cls);
                                } else {
                                    strArrLookupParameterNames3 = ASMUtils.lookupParameterNames(constructor2);
                                }
                            }
                            if (strArrLookupParameterNames3.length > i15) {
                                strArr2 = strArrLookupParameterNames3;
                                field5 = TypeUtils.getField(cls21, strArrLookupParameterNames3[i15], declaredFields);
                            }
                            ArrayList arrayList5 = arrayList4;
                            add(arrayList5, new FieldInfo(strName2, cls, cls26, type2, field5, iOrdinal2, iOf4, iOf5));
                            i15++;
                            parameterTypes2 = parameterTypes2;
                            arrayList4 = arrayList5;
                            methods = methods;
                            parameterAnnotations = parameterAnnotations;
                            cls23 = cls20;
                            strArrLookupParameterNames3 = strArr2;
                            cls24 = cls24;
                            cls22 = cls22;
                        }
                        field5 = field4;
                        strArr2 = strArrLookupParameterNames3;
                        ArrayList arrayList6 = arrayList4;
                        add(arrayList6, new FieldInfo(strName2, cls, cls26, type2, field5, iOrdinal2, iOf4, iOf5));
                        i15++;
                        parameterTypes2 = parameterTypes2;
                        arrayList4 = arrayList6;
                        methods = methods;
                        parameterAnnotations = parameterAnnotations;
                        cls23 = cls20;
                        strArrLookupParameterNames3 = strArr2;
                        cls24 = cls24;
                        cls22 = cls22;
                    }
                }
                cls13 = cls23;
                cls3 = cls22;
                arrayList = arrayList4;
                cls14 = cls24;
                methodArr = methods;
            } else {
                cls13 = cls23;
                cls3 = cls22;
                arrayList = arrayList4;
                cls14 = cls24;
                methodArr = methods;
                factoryMethod = getFactoryMethod(cls21, methodArr, z5);
                if (factoryMethod != null) {
                    TypeUtils.setAccessible(factoryMethod);
                    Class<?>[] parameterTypes3 = factoryMethod.getParameterTypes();
                    if (parameterTypes3.length > 0) {
                        Annotation[][] parameterAnnotations2 = TypeUtils.getParameterAnnotations(factoryMethod);
                        String[] strArrLookupParameterNames4 = null;
                        int i17 = 0;
                        while (i17 < parameterTypes3.length) {
                            Annotation[] annotationArr3 = parameterAnnotations2[i17];
                            int length2 = annotationArr3.length;
                            int i18 = 0;
                            while (true) {
                                if (i18 >= length2) {
                                    jSONField4 = null;
                                    break;
                                }
                                Annotation annotation2 = annotationArr3[i18];
                                if (annotation2 instanceof JSONField) {
                                    jSONField4 = (JSONField) annotation2;
                                    break;
                                }
                                i18++;
                            }
                            if (jSONField4 == null && (!z5 || !TypeUtils.isJacksonCreator(factoryMethod))) {
                                throw new JSONException("illegal json creator");
                            }
                            if (jSONField4 != null) {
                                strName = jSONField4.name();
                                int iOrdinal3 = jSONField4.ordinal();
                                int iOf6 = SerializerFeature.of(jSONField4.serialzeFeatures());
                                i13 = iOrdinal3;
                                iOf3 = Feature.of(jSONField4.parseFeatures());
                                i14 = iOf6;
                            } else {
                                strName = null;
                                i13 = 0;
                                i14 = 0;
                                iOf3 = 0;
                            }
                            if (strName == null || strName.length() == 0) {
                                if (strArrLookupParameterNames4 == null) {
                                    strArrLookupParameterNames4 = ASMUtils.lookupParameterNames(factoryMethod);
                                }
                                strName = strArrLookupParameterNames4[i17];
                            }
                            String[] strArr3 = strArrLookupParameterNames4;
                            add(arrayList, new FieldInfo(strName, cls, parameterTypes3[i17], factoryMethod.getGenericParameterTypes()[i17], TypeUtils.getField(cls21, strName, declaredFields), i13, i14, iOf3));
                            i17++;
                            z5 = z3;
                            parameterTypes3 = parameterTypes3;
                            strArrLookupParameterNames4 = strArr3;
                        }
                        return new JavaBeanInfo(cls, builderClass, null, null, factoryMethod, null, jSONType2, arrayList);
                    }
                } else if (!z6) {
                    String name = cls.getName();
                    if (zIsKotlin && declaredConstructors.length > 0) {
                        strArrLookupParameterNames2 = TypeUtils.getKoltinConstructorParameters(cls);
                        Constructor<?> kotlinConstructor = TypeUtils.getKotlinConstructor(declaredConstructors, strArrLookupParameterNames2);
                        TypeUtils.setAccessible(kotlinConstructor);
                        constructor2 = kotlinConstructor;
                        methodArr = methodArr;
                        cls15 = cls13;
                    } else {
                        int length3 = declaredConstructors.length;
                        String[] strArr4 = null;
                        int i19 = 0;
                        while (true) {
                            if (i19 < length3) {
                                Constructor<?> constructor3 = declaredConstructors[i19];
                                Class<?>[] parameterTypes4 = constructor3.getParameterTypes();
                                if (name.equals("org.springframework.security.web.authentication.WebAuthenticationDetails")) {
                                    if (parameterTypes4.length == 2) {
                                        cls15 = cls13;
                                        if (parameterTypes4[0] == cls15 && parameterTypes4[1] == cls15) {
                                            constructor3.setAccessible(true);
                                            strArrLookupParameterNames2 = ASMUtils.lookupParameterNames(constructor3);
                                            constructor2 = constructor3;
                                            methodArr = methodArr;
                                        }
                                    } else {
                                        cls15 = cls13;
                                    }
                                    constructorArr = declaredConstructors;
                                    cls16 = cls14;
                                    cls17 = cls3;
                                } else {
                                    cls15 = cls13;
                                    if (name.equals("org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken")) {
                                        if (parameterTypes4.length == 3) {
                                            cls16 = cls14;
                                            constructorArr = declaredConstructors;
                                            if (parameterTypes4[0] == cls16 && parameterTypes4[1] == cls16) {
                                                cls17 = cls3;
                                                if (parameterTypes4[2] == cls17) {
                                                    constructor3.setAccessible(true);
                                                    strArrLookupParameterNames2 = new String[]{"principal", "credentials", "authorities"};
                                                    constructor2 = constructor3;
                                                    methodArr = methodArr;
                                                    i = 0;
                                                    strArr = strArrLookupParameterNames2;
                                                }
                                            }
                                        } else {
                                            constructorArr = declaredConstructors;
                                            cls16 = cls14;
                                        }
                                        cls17 = cls3;
                                    } else {
                                        constructorArr = declaredConstructors;
                                        cls16 = cls14;
                                        cls17 = cls3;
                                        if (name.equals("org.springframework.security.core.authority.SimpleGrantedAuthority")) {
                                            methodArr = methodArr;
                                            i = 0;
                                            if (parameterTypes4.length == 1 && parameterTypes4[0] == cls15) {
                                                strArr = new String[]{"authority"};
                                                constructor2 = constructor3;
                                            }
                                        } else {
                                            methodArr = methodArr;
                                            if (((constructor3.getModifiers() & 1) != 0) && (strArrLookupParameterNames = ASMUtils.lookupParameterNames(constructor3)) != null && strArrLookupParameterNames.length != 0 && (constructor2 == null || strArr4 == null || strArrLookupParameterNames.length > strArr4.length)) {
                                                constructor2 = constructor3;
                                                strArr4 = strArrLookupParameterNames;
                                            }
                                        }
                                        i19++;
                                        cls3 = cls17;
                                        cls14 = cls16;
                                        cls13 = cls15;
                                        declaredConstructors = constructorArr;
                                        methodArr = methodArr;
                                    }
                                }
                                i19++;
                                cls3 = cls17;
                                cls14 = cls16;
                                cls13 = cls15;
                                declaredConstructors = constructorArr;
                                methodArr = methodArr;
                            } else {
                                methodArr = methodArr;
                                cls15 = cls13;
                                cls16 = cls14;
                                cls17 = cls3;
                                i = 0;
                                strArr = strArr4;
                            }
                            if (strArr != null) {
                                parameterTypes = constructor2.getParameterTypes();
                            } else {
                                parameterTypes = null;
                            }
                            if (strArr == null && parameterTypes.length == strArr.length) {
                                Annotation[][] parameterAnnotations3 = TypeUtils.getParameterAnnotations(constructor2);
                                int i20 = i;
                                while (i20 < parameterTypes.length) {
                                    Annotation[] annotationArr4 = parameterAnnotations3[i20];
                                    String str6 = strArr[i20];
                                    int length4 = annotationArr4.length;
                                    int i21 = i;
                                    while (true) {
                                        cls18 = cls17;
                                        if (i21 >= length4) {
                                            jSONField3 = null;
                                            break;
                                        }
                                        Annotation annotation3 = annotationArr4[i21];
                                        Annotation[] annotationArr5 = annotationArr4;
                                        if (annotation3 instanceof JSONField) {
                                            jSONField3 = (JSONField) annotation3;
                                            break;
                                        }
                                        i21++;
                                        annotationArr4 = annotationArr5;
                                        cls17 = cls18;
                                    }
                                    Class<?> cls27 = parameterTypes[i20];
                                    Type type3 = constructor2.getGenericParameterTypes()[i20];
                                    Field field6 = TypeUtils.getField(cls21, str6, declaredFields);
                                    if (field6 == null || jSONField3 != null) {
                                        cls19 = cls25;
                                    } else {
                                        cls19 = cls25;
                                        jSONField3 = (JSONField) TypeUtils.getAnnotation(field6, cls19);
                                    }
                                    if (jSONField3 == null) {
                                        if ("org.springframework.security.core.userdetails.User".equals(name) && "password".equals(str6)) {
                                            iOf2 = Feature.InitStringFieldAsEmpty.mask;
                                            iOrdinal = i;
                                            iOf = iOrdinal;
                                        } else {
                                            iOrdinal = i;
                                            iOf = iOrdinal;
                                            iOf2 = iOf;
                                        }
                                    } else {
                                        String strName3 = jSONField3.name();
                                        if (strName3.length() != 0) {
                                            str6 = strName3;
                                        }
                                        iOrdinal = jSONField3.ordinal();
                                        iOf = SerializerFeature.of(jSONField3.serialzeFeatures());
                                        iOf2 = Feature.of(jSONField3.parseFeatures());
                                    }
                                    add(arrayList, new FieldInfo(str6, cls, cls27, type3, field6, iOrdinal, iOf, iOf2));
                                    i20++;
                                    cls25 = cls19;
                                    cls16 = cls16;
                                    parameterTypes = parameterTypes;
                                    declaredFields = declaredFields;
                                    cls17 = cls18;
                                    cls15 = cls15;
                                    strArr = strArr;
                                }
                                cls3 = cls17;
                                cls24 = cls16;
                                cls2 = cls15;
                                fieldArr = declaredFields;
                                i2 = 3;
                                cls4 = cls25;
                                if (!zIsKotlin && !cls.getName().equals("javax.servlet.http.Cookie")) {
                                    return new JavaBeanInfo(cls, builderClass, null, constructor2, null, null, jSONType2, arrayList);
                                }
                            } else {
                                throw new JSONException("default constructor not found. " + cls21);
                            }
                        }
                    }
                    cls16 = cls14;
                    cls17 = cls3;
                    i = 0;
                    strArr = strArrLookupParameterNames2;
                    if (strArr != null) {
                        parameterTypes = constructor2.getParameterTypes();
                    } else {
                        parameterTypes = null;
                    }
                    if (strArr == null) {
                    }
                    throw new JSONException("default constructor not found. " + cls21);
                }
            }
            fieldArr = declaredFields;
            methodArr = methodArr;
            cls2 = cls13;
            cls24 = cls14;
            i = 0;
            i2 = 3;
            cls4 = cls25;
        } else {
            cls2 = cls23;
            cls3 = cls22;
            arrayList = arrayList4;
            methodArr = methods;
            fieldArr = declaredFields;
            i = 0;
            i2 = 3;
            cls4 = cls25;
            constructor2 = null;
        }
        if (constructor != null) {
            TypeUtils.setAccessible(constructor);
        }
        String str7 = p3.h;
        if (builderClass != null) {
            Class<JSONPOJOBuilder> cls28 = JSONPOJOBuilder.class;
            JSONPOJOBuilder jSONPOJOBuilder = (JSONPOJOBuilder) TypeUtils.getAnnotation(builderClass, cls28);
            String strWithPrefix = jSONPOJOBuilder != null ? jSONPOJOBuilder.withPrefix() : null;
            if (strWithPrefix == null) {
                strWithPrefix = "with";
            }
            String str8 = strWithPrefix;
            Method[] methods2 = builderClass.getMethods();
            int length5 = methods2.length;
            int i22 = i;
            while (i22 < length5) {
                Method method2 = methods2[i22];
                if (!Modifier.isStatic(method2.getModifiers()) && method2.getReturnType().equals(builderClass)) {
                    JSONField superMethodAnnotation = (JSONField) TypeUtils.getAnnotation(method2, cls4);
                    if (superMethodAnnotation == null) {
                        superMethodAnnotation = TypeUtils.getSuperMethodAnnotation(cls21, method2);
                    }
                    JSONField jSONField6 = superMethodAnnotation;
                    if (jSONField6 == null) {
                        i10 = 0;
                        i11 = 0;
                        i12 = 0;
                    } else if (jSONField6.deserialize()) {
                        int iOrdinal4 = jSONField6.ordinal();
                        int iOf7 = SerializerFeature.of(jSONField6.serialzeFeatures());
                        int iOf8 = Feature.of(jSONField6.parseFeatures());
                        if (jSONField6.name().length() != 0) {
                            i22 = i22;
                            length5 = length5;
                            methods2 = methods2;
                            cls28 = cls28;
                            fieldArr = fieldArr;
                            builderClass = builderClass;
                            propertyNamingStrategy5 = propertyNamingStrategy5;
                            jSONType2 = jSONType2;
                            cls4 = cls4;
                            arrayList = arrayList;
                            add(arrayList, new FieldInfo(jSONField6.name(), method2, null, cls, type, iOrdinal4, iOf7, iOf8, jSONField6, null, null, mapBuildGenericInfo));
                            str4 = str8;
                            str5 = str7;
                        } else {
                            i10 = iOrdinal4;
                            i11 = iOf7;
                            i12 = iOf8;
                        }
                    } else {
                        propertyNamingStrategy5 = propertyNamingStrategy5;
                        i22 = i22;
                        length5 = length5;
                        methods2 = methods2;
                        str4 = str8;
                        cls28 = cls28;
                        str5 = str7;
                        cls4 = cls4;
                        builderClass = builderClass;
                        fieldArr = fieldArr;
                        jSONType2 = jSONType2;
                        arrayList = arrayList;
                    }
                    String name2 = method2.getName();
                    String str9 = str7;
                    if (name2.startsWith(str9) && name2.length() > i2) {
                        sb = new StringBuilder(name2.substring(i2));
                    } else {
                        if (str8.length() == 0) {
                            sb = new StringBuilder(name2);
                        } else {
                            str3 = str8;
                            if (name2.startsWith(str3) && name2.length() > str3.length()) {
                                sb = new StringBuilder(name2.substring(str3.length()));
                                cCharAt2 = sb.charAt(0);
                                if (str3.length() != 0 || Character.isUpperCase(cCharAt2)) {
                                    sb.setCharAt(0, Character.toLowerCase(cCharAt2));
                                    str4 = str3;
                                    str5 = str9;
                                    add(arrayList, new FieldInfo(sb.toString(), method2, null, cls, type, i10, i11, i12, jSONField6, null, null, mapBuildGenericInfo));
                                }
                            }
                        }
                        str4 = str3;
                        str5 = str9;
                    }
                    str3 = str8;
                    cCharAt2 = sb.charAt(0);
                    if (str3.length() != 0) {
                    }
                    sb.setCharAt(0, Character.toLowerCase(cCharAt2));
                    str4 = str3;
                    str5 = str9;
                    add(arrayList, new FieldInfo(sb.toString(), method2, null, cls, type, i10, i11, i12, jSONField6, null, null, mapBuildGenericInfo));
                } else {
                    propertyNamingStrategy5 = propertyNamingStrategy5;
                    i22 = i22;
                    length5 = length5;
                    methods2 = methods2;
                    str4 = str8;
                    cls28 = cls28;
                    str5 = str7;
                    cls4 = cls4;
                    builderClass = builderClass;
                    fieldArr = fieldArr;
                    jSONType2 = jSONType2;
                    arrayList = arrayList;
                }
                i22++;
                cls21 = cls;
                arrayList = arrayList;
                str8 = str4;
                cls4 = cls4;
                jSONType2 = jSONType2;
                length5 = length5;
                methods2 = methods2;
                cls28 = cls28;
                fieldArr = fieldArr;
                builderClass = builderClass;
                propertyNamingStrategy5 = propertyNamingStrategy5;
                str7 = str5;
                i2 = 3;
            }
            propertyNamingStrategy2 = propertyNamingStrategy5;
            str = str7;
            cls6 = cls4;
            fieldArr2 = fieldArr;
            jSONType = jSONType2;
            arrayList2 = arrayList;
            cls5 = builderClass;
            JSONPOJOBuilder jSONPOJOBuilder2 = (JSONPOJOBuilder) TypeUtils.getAnnotation(cls5, cls28);
            String strBuildMethod = jSONPOJOBuilder2 != null ? jSONPOJOBuilder2.buildMethod() : null;
            if (strBuildMethod == null || strBuildMethod.length() == 0) {
                strBuildMethod = ALPUserTrackConstant.METHOD_BUILD;
            }
            i3 = 0;
            try {
                method = cls5.getMethod(strBuildMethod, new Class[0]);
            } catch (NoSuchMethodException | SecurityException unused2) {
            }
            if (method == null) {
                try {
                    method = cls5.getMethod("create", new Class[0]);
                } catch (NoSuchMethodException | SecurityException unused3) {
                }
            }
            if (method != null) {
                TypeUtils.setAccessible(method);
            } else {
                throw new JSONException("buildMethod not found.");
            }
        } else {
            propertyNamingStrategy2 = propertyNamingStrategy5;
            str = p3.h;
            cls5 = builderClass;
            fieldArr2 = fieldArr;
            jSONType = jSONType2;
            arrayList2 = arrayList;
            i3 = i;
            cls6 = cls4;
        }
        Method[] methodArr4 = methodArr;
        int length6 = methodArr4.length;
        int i23 = i3;
        while (true) {
            str2 = p3.f;
            i4 = 4;
            if (i23 >= length6) {
                break;
            }
            Method method3 = methodArr4[i23];
            int iOrdinal5 = 0;
            int iOf9 = 0;
            int iOf10 = 0;
            String name3 = method3.getName();
            if (Modifier.isStatic(method3.getModifiers())) {
                i23 = i23;
                length6 = length6;
                methodArr3 = methodArr4;
                i6 = i3;
                cls5 = cls5;
                cls24 = cls24;
                cls12 = cls6;
                cls9 = cls2;
                propertyNamingStrategy2 = propertyNamingStrategy2;
                str = str;
            } else {
                Class<?> returnType = method3.getReturnType();
                if ((returnType.equals(Void.TYPE) || returnType.equals(method3.getDeclaringClass())) && method3.getDeclaringClass() != cls24) {
                    Class<?>[] parameterTypes5 = method3.getParameterTypes();
                    if (parameterTypes5.length == 0) {
                        i23 = i23;
                        length6 = length6;
                        methodArr3 = methodArr4;
                        i6 = i3;
                        cls5 = cls5;
                        cls24 = cls24;
                        cls12 = cls6;
                        cls9 = cls2;
                        propertyNamingStrategy2 = propertyNamingStrategy2;
                        str = str;
                    } else if (parameterTypes5.length > 2) {
                        i23 = i23;
                        length6 = length6;
                        methodArr3 = methodArr4;
                        i6 = i3;
                        cls5 = cls5;
                        cls24 = cls24;
                        cls12 = cls6;
                        cls9 = cls2;
                        propertyNamingStrategy2 = propertyNamingStrategy2;
                        str = str;
                    } else {
                        Class cls29 = cls6;
                        JSONField jSONField7 = (JSONField) TypeUtils.getAnnotation(method3, cls29);
                        if (jSONField7 == null || parameterTypes5.length != 2) {
                            cls29 = cls29;
                            i23 = i23;
                            length6 = length6;
                            methodArr2 = methodArr4;
                            cls24 = cls24;
                            cls9 = cls2;
                        } else {
                            methodArr2 = methodArr4;
                            Class<String> cls30 = cls2;
                            if (parameterTypes5[i3] == cls30 && parameterTypes5[1] == cls24) {
                                i23 = i23;
                                length6 = length6;
                                cls9 = cls30;
                                cls24 = cls24;
                                i5 = i3;
                                add(arrayList2, new FieldInfo("", method3, null, cls, type, 0, 0, 0, jSONField7, null, null, mapBuildGenericInfo));
                                cls12 = cls29;
                                methodArr3 = methodArr2;
                            } else {
                                cls9 = cls30;
                            }
                            i6 = i5;
                        }
                        i5 = i3;
                        if (parameterTypes5.length != 1) {
                            cls12 = cls29;
                            methodArr3 = methodArr2;
                            i6 = i5;
                        } else {
                            Class cls31 = cls29;
                            JSONField superMethodAnnotation2 = jSONField7 == null ? TypeUtils.getSuperMethodAnnotation(cls, method3) : jSONField7;
                            if (superMethodAnnotation2 == null && name3.length() < 4) {
                                cls12 = cls31;
                                cls5 = cls5;
                                i6 = i5;
                                propertyNamingStrategy2 = propertyNamingStrategy2;
                                str = str;
                                methodArr3 = methodArr2;
                            } else if (superMethodAnnotation2 != null) {
                                if (superMethodAnnotation2.deserialize()) {
                                    iOrdinal5 = superMethodAnnotation2.ordinal();
                                    iOf9 = SerializerFeature.of(superMethodAnnotation2.serialzeFeatures());
                                    iOf10 = Feature.of(superMethodAnnotation2.parseFeatures());
                                    if (superMethodAnnotation2.name().length() != 0) {
                                        cls10 = cls31;
                                        add(arrayList2, new FieldInfo(superMethodAnnotation2.name(), method3, null, cls, type, iOrdinal5, iOf9, iOf10, superMethodAnnotation2, null, null, mapBuildGenericInfo));
                                        str = str;
                                    } else {
                                        cls10 = cls31;
                                        str = str;
                                        if (superMethodAnnotation2 == null) {
                                            cCharAt = name3.charAt(3);
                                            if (zIsKotlin) {
                                                arrayList3 = new ArrayList();
                                                methodArr3 = methodArr2;
                                                for (i9 = 0; i9 < methodArr3.length; i9++) {
                                                    if (methodArr3[i9].getName().startsWith(p3.f)) {
                                                        arrayList3.add(methodArr3[i9].getName());
                                                    }
                                                }
                                            } else {
                                                methodArr3 = methodArr2;
                                                arrayList3 = null;
                                            }
                                            if (Character.isUpperCase(cCharAt)) {
                                                cls11 = cls;
                                                fieldArr5 = fieldArr2;
                                                if (zIsKotlin) {
                                                    propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(y6b.f + name3.substring(1));
                                                } else if (TypeUtils.compatibleWithJavaBean) {
                                                    propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                                } else {
                                                    propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name3);
                                                }
                                                field2 = null;
                                            } else {
                                                cls11 = cls;
                                                fieldArr5 = fieldArr2;
                                                if (zIsKotlin) {
                                                    propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(y6b.f + name3.substring(1));
                                                } else if (TypeUtils.compatibleWithJavaBean) {
                                                    propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                                } else {
                                                    propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name3);
                                                }
                                                field2 = null;
                                            }
                                            if (field2 == null) {
                                                field2 = TypeUtils.getField(cls11, propertyNameByMethodName2, fieldArr5);
                                            }
                                            if (field2 == null) {
                                                i6 = 0;
                                                if (parameterTypes5[0] == Boolean.TYPE) {
                                                    StringBuilder sb2 = new StringBuilder();
                                                    sb2.append(p3.g);
                                                    sb2.append(Character.toUpperCase(propertyNameByMethodName2.charAt(0)));
                                                    z4 = true;
                                                    sb2.append(propertyNameByMethodName2.substring(1));
                                                    field3 = TypeUtils.getField(cls11, sb2.toString(), fieldArr5);
                                                } else {
                                                    z4 = true;
                                                }
                                                if (field3 != null) {
                                                    cls12 = cls10;
                                                    jSONField2 = (JSONField) TypeUtils.getAnnotation(field3, cls12);
                                                    if (jSONField2 != null) {
                                                        if (jSONField2.deserialize()) {
                                                            iOrdinal5 = jSONField2.ordinal();
                                                            iOf9 = SerializerFeature.of(jSONField2.serialzeFeatures());
                                                            iOf10 = Feature.of(jSONField2.parseFeatures());
                                                            if (jSONField2.name().length() != 0) {
                                                                add(arrayList2, new FieldInfo(jSONField2.name(), method3, field3, cls, type, iOrdinal5, iOf9, iOf10, superMethodAnnotation2, jSONField2, null, mapBuildGenericInfo));
                                                                fieldArr2 = fieldArr5;
                                                            }
                                                        } else {
                                                            fieldArr2 = fieldArr5;
                                                        }
                                                        propertyNamingStrategy2 = propertyNamingStrategy2;
                                                    }
                                                    cls12 = cls12;
                                                    i7 = iOf9;
                                                    i8 = iOf10;
                                                    jSONField = jSONField2;
                                                } else {
                                                    cls12 = cls10;
                                                    jSONField = null;
                                                    i7 = iOf9;
                                                    i8 = iOf10;
                                                }
                                                propertyNamingStrategy3 = propertyNamingStrategy2;
                                                if (propertyNamingStrategy3 != null) {
                                                    propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                                }
                                                fieldArr2 = fieldArr5;
                                                cls5 = cls5;
                                                propertyNamingStrategy2 = propertyNamingStrategy3;
                                                add(arrayList2, new FieldInfo(propertyNameByMethodName2, method3, field3, cls, type, iOrdinal5, i7, i8, superMethodAnnotation2, jSONField, null, mapBuildGenericInfo));
                                            } else {
                                                z4 = true;
                                                i6 = 0;
                                            }
                                            field3 = field2;
                                            if (field3 != null) {
                                                cls12 = cls10;
                                                jSONField2 = (JSONField) TypeUtils.getAnnotation(field3, cls12);
                                                if (jSONField2 != null) {
                                                    if (jSONField2.deserialize()) {
                                                        fieldArr2 = fieldArr5;
                                                    } else {
                                                        iOrdinal5 = jSONField2.ordinal();
                                                        iOf9 = SerializerFeature.of(jSONField2.serialzeFeatures());
                                                        iOf10 = Feature.of(jSONField2.parseFeatures());
                                                        if (jSONField2.name().length() != 0) {
                                                            add(arrayList2, new FieldInfo(jSONField2.name(), method3, field3, cls, type, iOrdinal5, iOf9, iOf10, superMethodAnnotation2, jSONField2, null, mapBuildGenericInfo));
                                                            fieldArr2 = fieldArr5;
                                                        }
                                                    }
                                                    propertyNamingStrategy2 = propertyNamingStrategy2;
                                                }
                                                cls12 = cls12;
                                                i7 = iOf9;
                                                i8 = iOf10;
                                                jSONField = jSONField2;
                                            } else {
                                                cls12 = cls10;
                                                jSONField = null;
                                                i7 = iOf9;
                                                i8 = iOf10;
                                            }
                                            propertyNamingStrategy3 = propertyNamingStrategy2;
                                            if (propertyNamingStrategy3 != null) {
                                                propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                            }
                                            fieldArr2 = fieldArr5;
                                            cls5 = cls5;
                                            propertyNamingStrategy2 = propertyNamingStrategy3;
                                            add(arrayList2, new FieldInfo(propertyNameByMethodName2, method3, field3, cls, type, iOrdinal5, i7, i8, superMethodAnnotation2, jSONField, null, mapBuildGenericInfo));
                                        } else {
                                            cCharAt = name3.charAt(3);
                                            if (zIsKotlin) {
                                                arrayList3 = new ArrayList();
                                                methodArr3 = methodArr2;
                                                while (i9 < methodArr3.length) {
                                                    if (methodArr3[i9].getName().startsWith(p3.f)) {
                                                        arrayList3.add(methodArr3[i9].getName());
                                                    }
                                                }
                                            } else {
                                                methodArr3 = methodArr2;
                                                arrayList3 = null;
                                            }
                                            if (Character.isUpperCase(cCharAt)) {
                                                cls11 = cls;
                                                fieldArr5 = fieldArr2;
                                                if (zIsKotlin) {
                                                    propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(y6b.f + name3.substring(1));
                                                } else if (TypeUtils.compatibleWithJavaBean) {
                                                    propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                                } else {
                                                    propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name3);
                                                }
                                                field2 = null;
                                            } else {
                                                cls11 = cls;
                                                fieldArr5 = fieldArr2;
                                                if (zIsKotlin) {
                                                    propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(y6b.f + name3.substring(1));
                                                } else if (TypeUtils.compatibleWithJavaBean) {
                                                    propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                                } else {
                                                    propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name3);
                                                }
                                                field2 = null;
                                            }
                                            if (field2 == null) {
                                                field2 = TypeUtils.getField(cls11, propertyNameByMethodName2, fieldArr5);
                                            }
                                            if (field2 == null) {
                                                i6 = 0;
                                                if (parameterTypes5[0] == Boolean.TYPE) {
                                                    StringBuilder sb3 = new StringBuilder();
                                                    sb3.append(p3.g);
                                                    sb3.append(Character.toUpperCase(propertyNameByMethodName2.charAt(0)));
                                                    z4 = true;
                                                    sb3.append(propertyNameByMethodName2.substring(1));
                                                    field3 = TypeUtils.getField(cls11, sb3.toString(), fieldArr5);
                                                } else {
                                                    z4 = true;
                                                }
                                                if (field3 != null) {
                                                    cls12 = cls10;
                                                    jSONField2 = (JSONField) TypeUtils.getAnnotation(field3, cls12);
                                                    if (jSONField2 != null) {
                                                        if (jSONField2.deserialize()) {
                                                            fieldArr2 = fieldArr5;
                                                        } else {
                                                            iOrdinal5 = jSONField2.ordinal();
                                                            iOf9 = SerializerFeature.of(jSONField2.serialzeFeatures());
                                                            iOf10 = Feature.of(jSONField2.parseFeatures());
                                                            if (jSONField2.name().length() != 0) {
                                                                add(arrayList2, new FieldInfo(jSONField2.name(), method3, field3, cls, type, iOrdinal5, iOf9, iOf10, superMethodAnnotation2, jSONField2, null, mapBuildGenericInfo));
                                                                fieldArr2 = fieldArr5;
                                                            }
                                                        }
                                                        propertyNamingStrategy2 = propertyNamingStrategy2;
                                                    }
                                                    cls12 = cls12;
                                                    i7 = iOf9;
                                                    i8 = iOf10;
                                                    jSONField = jSONField2;
                                                } else {
                                                    cls12 = cls10;
                                                    jSONField = null;
                                                    i7 = iOf9;
                                                    i8 = iOf10;
                                                }
                                                propertyNamingStrategy3 = propertyNamingStrategy2;
                                                if (propertyNamingStrategy3 != null) {
                                                    propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                                }
                                                fieldArr2 = fieldArr5;
                                                cls5 = cls5;
                                                propertyNamingStrategy2 = propertyNamingStrategy3;
                                                add(arrayList2, new FieldInfo(propertyNameByMethodName2, method3, field3, cls, type, iOrdinal5, i7, i8, superMethodAnnotation2, jSONField, null, mapBuildGenericInfo));
                                            } else {
                                                z4 = true;
                                                i6 = 0;
                                            }
                                            field3 = field2;
                                            if (field3 != null) {
                                                cls12 = cls10;
                                                jSONField2 = (JSONField) TypeUtils.getAnnotation(field3, cls12);
                                                if (jSONField2 != null) {
                                                    if (jSONField2.deserialize()) {
                                                        fieldArr2 = fieldArr5;
                                                    } else {
                                                        iOrdinal5 = jSONField2.ordinal();
                                                        iOf9 = SerializerFeature.of(jSONField2.serialzeFeatures());
                                                        iOf10 = Feature.of(jSONField2.parseFeatures());
                                                        if (jSONField2.name().length() != 0) {
                                                            add(arrayList2, new FieldInfo(jSONField2.name(), method3, field3, cls, type, iOrdinal5, iOf9, iOf10, superMethodAnnotation2, jSONField2, null, mapBuildGenericInfo));
                                                            fieldArr2 = fieldArr5;
                                                        }
                                                    }
                                                    propertyNamingStrategy2 = propertyNamingStrategy2;
                                                }
                                                cls12 = cls12;
                                                i7 = iOf9;
                                                i8 = iOf10;
                                                jSONField = jSONField2;
                                            } else {
                                                cls12 = cls10;
                                                jSONField = null;
                                                i7 = iOf9;
                                                i8 = iOf10;
                                            }
                                            propertyNamingStrategy3 = propertyNamingStrategy2;
                                            if (propertyNamingStrategy3 != null) {
                                                propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                            }
                                            fieldArr2 = fieldArr5;
                                            cls5 = cls5;
                                            propertyNamingStrategy2 = propertyNamingStrategy3;
                                            add(arrayList2, new FieldInfo(propertyNameByMethodName2, method3, field3, cls, type, iOrdinal5, i7, i8, superMethodAnnotation2, jSONField, null, mapBuildGenericInfo));
                                        }
                                    }
                                    methodArr3 = methodArr2;
                                    cls12 = cls10;
                                    i6 = 0;
                                } else {
                                    cls12 = cls31;
                                    cls5 = cls5;
                                    i6 = i5;
                                    propertyNamingStrategy2 = propertyNamingStrategy2;
                                    str = str;
                                    methodArr3 = methodArr2;
                                }
                            } else {
                                cls10 = cls31;
                                str = str;
                                if ((superMethodAnnotation2 == null || name3.startsWith(str)) && cls5 == null) {
                                    cCharAt = name3.charAt(3);
                                    if (zIsKotlin) {
                                        arrayList3 = new ArrayList();
                                        methodArr3 = methodArr2;
                                        while (i9 < methodArr3.length) {
                                            if (methodArr3[i9].getName().startsWith(p3.f)) {
                                                arrayList3.add(methodArr3[i9].getName());
                                            }
                                        }
                                    } else {
                                        methodArr3 = methodArr2;
                                        arrayList3 = null;
                                    }
                                    if (Character.isUpperCase(cCharAt) || cCharAt > 512) {
                                        cls11 = cls;
                                        fieldArr5 = fieldArr2;
                                        if (zIsKotlin) {
                                            propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(y6b.f + name3.substring(1));
                                        } else if (TypeUtils.compatibleWithJavaBean) {
                                            propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                        } else {
                                            propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name3);
                                        }
                                    } else {
                                        if (cCharAt != '_') {
                                            cls11 = cls;
                                            fieldArr6 = fieldArr2;
                                            if (cCharAt == 'f') {
                                                propertyNameByMethodName2 = name3.substring(3);
                                            } else if (name3.length() >= 5 && Character.isUpperCase(name3.charAt(4))) {
                                                propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                            } else {
                                                propertyNameByMethodName2 = name3.substring(3);
                                                field2 = TypeUtils.getField(cls11, propertyNameByMethodName2, fieldArr6);
                                                if (field2 == null) {
                                                    fieldArr2 = fieldArr6;
                                                    methodArr3 = methodArr3;
                                                    cls5 = cls5;
                                                    str = str;
                                                    propertyNamingStrategy2 = propertyNamingStrategy2;
                                                    cls12 = cls10;
                                                    i6 = 0;
                                                }
                                            }
                                            fieldArr5 = fieldArr6;
                                        } else if (zIsKotlin) {
                                            propertyNameByMethodName2 = arrayList3.contains(y6b.f + name3.substring(1)) ? name3.substring(3) : p3.g + name3.substring(3);
                                            cls11 = cls;
                                            fieldArr6 = fieldArr2;
                                            field2 = TypeUtils.getField(cls11, propertyNameByMethodName2, fieldArr6);
                                        } else {
                                            cls11 = cls;
                                            fieldArr6 = fieldArr2;
                                            String strSubstring = name3.substring(4);
                                            Field field7 = TypeUtils.getField(cls11, strSubstring, fieldArr6);
                                            if (field7 != null || (field7 = TypeUtils.getField(cls11, (propertyNameByMethodName2 = name3.substring(3)), fieldArr6)) == null) {
                                                propertyNameByMethodName2 = strSubstring;
                                            }
                                            field2 = field7;
                                        }
                                        fieldArr5 = fieldArr6;
                                        if (field2 == null) {
                                            field2 = TypeUtils.getField(cls11, propertyNameByMethodName2, fieldArr5);
                                        }
                                        if (field2 == null) {
                                            i6 = 0;
                                            if (parameterTypes5[0] == Boolean.TYPE) {
                                                StringBuilder sb4 = new StringBuilder();
                                                sb4.append(p3.g);
                                                sb4.append(Character.toUpperCase(propertyNameByMethodName2.charAt(0)));
                                                z4 = true;
                                                sb4.append(propertyNameByMethodName2.substring(1));
                                                field3 = TypeUtils.getField(cls11, sb4.toString(), fieldArr5);
                                            } else {
                                                z4 = true;
                                            }
                                            if (field3 != null) {
                                                cls12 = cls10;
                                                jSONField2 = (JSONField) TypeUtils.getAnnotation(field3, cls12);
                                                if (jSONField2 != null) {
                                                    if (jSONField2.deserialize()) {
                                                        fieldArr2 = fieldArr5;
                                                    } else {
                                                        iOrdinal5 = jSONField2.ordinal();
                                                        iOf9 = SerializerFeature.of(jSONField2.serialzeFeatures());
                                                        iOf10 = Feature.of(jSONField2.parseFeatures());
                                                        if (jSONField2.name().length() != 0) {
                                                            add(arrayList2, new FieldInfo(jSONField2.name(), method3, field3, cls, type, iOrdinal5, iOf9, iOf10, superMethodAnnotation2, jSONField2, null, mapBuildGenericInfo));
                                                            fieldArr2 = fieldArr5;
                                                        }
                                                    }
                                                    propertyNamingStrategy2 = propertyNamingStrategy2;
                                                }
                                                cls12 = cls12;
                                                i7 = iOf9;
                                                i8 = iOf10;
                                                jSONField = jSONField2;
                                            } else {
                                                cls12 = cls10;
                                                jSONField = null;
                                                i7 = iOf9;
                                                i8 = iOf10;
                                            }
                                            propertyNamingStrategy3 = propertyNamingStrategy2;
                                            if (propertyNamingStrategy3 != null) {
                                                propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                            }
                                            fieldArr2 = fieldArr5;
                                            cls5 = cls5;
                                            propertyNamingStrategy2 = propertyNamingStrategy3;
                                            add(arrayList2, new FieldInfo(propertyNameByMethodName2, method3, field3, cls, type, iOrdinal5, i7, i8, superMethodAnnotation2, jSONField, null, mapBuildGenericInfo));
                                        } else {
                                            z4 = true;
                                            i6 = 0;
                                        }
                                        field3 = field2;
                                        if (field3 != null) {
                                            cls12 = cls10;
                                            jSONField2 = (JSONField) TypeUtils.getAnnotation(field3, cls12);
                                            if (jSONField2 != null) {
                                                if (jSONField2.deserialize()) {
                                                    fieldArr2 = fieldArr5;
                                                } else {
                                                    iOrdinal5 = jSONField2.ordinal();
                                                    iOf9 = SerializerFeature.of(jSONField2.serialzeFeatures());
                                                    iOf10 = Feature.of(jSONField2.parseFeatures());
                                                    if (jSONField2.name().length() != 0) {
                                                        add(arrayList2, new FieldInfo(jSONField2.name(), method3, field3, cls, type, iOrdinal5, iOf9, iOf10, superMethodAnnotation2, jSONField2, null, mapBuildGenericInfo));
                                                        fieldArr2 = fieldArr5;
                                                    }
                                                }
                                                propertyNamingStrategy2 = propertyNamingStrategy2;
                                            }
                                            cls12 = cls12;
                                            i7 = iOf9;
                                            i8 = iOf10;
                                            jSONField = jSONField2;
                                        } else {
                                            cls12 = cls10;
                                            jSONField = null;
                                            i7 = iOf9;
                                            i8 = iOf10;
                                        }
                                        propertyNamingStrategy3 = propertyNamingStrategy2;
                                        if (propertyNamingStrategy3 != null) {
                                            propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                        }
                                        fieldArr2 = fieldArr5;
                                        cls5 = cls5;
                                        propertyNamingStrategy2 = propertyNamingStrategy3;
                                        add(arrayList2, new FieldInfo(propertyNameByMethodName2, method3, field3, cls, type, iOrdinal5, i7, i8, superMethodAnnotation2, jSONField, null, mapBuildGenericInfo));
                                    }
                                    field2 = null;
                                    if (field2 == null) {
                                        field2 = TypeUtils.getField(cls11, propertyNameByMethodName2, fieldArr5);
                                    }
                                    if (field2 == null) {
                                        i6 = 0;
                                        if (parameterTypes5[0] == Boolean.TYPE) {
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append(p3.g);
                                            sb5.append(Character.toUpperCase(propertyNameByMethodName2.charAt(0)));
                                            z4 = true;
                                            sb5.append(propertyNameByMethodName2.substring(1));
                                            field3 = TypeUtils.getField(cls11, sb5.toString(), fieldArr5);
                                        } else {
                                            z4 = true;
                                        }
                                        if (field3 != null) {
                                            cls12 = cls10;
                                            jSONField2 = (JSONField) TypeUtils.getAnnotation(field3, cls12);
                                            if (jSONField2 != null) {
                                                if (jSONField2.deserialize()) {
                                                    fieldArr2 = fieldArr5;
                                                } else {
                                                    iOrdinal5 = jSONField2.ordinal();
                                                    iOf9 = SerializerFeature.of(jSONField2.serialzeFeatures());
                                                    iOf10 = Feature.of(jSONField2.parseFeatures());
                                                    if (jSONField2.name().length() != 0) {
                                                        add(arrayList2, new FieldInfo(jSONField2.name(), method3, field3, cls, type, iOrdinal5, iOf9, iOf10, superMethodAnnotation2, jSONField2, null, mapBuildGenericInfo));
                                                        fieldArr2 = fieldArr5;
                                                    }
                                                }
                                                propertyNamingStrategy2 = propertyNamingStrategy2;
                                            }
                                            cls12 = cls12;
                                            i7 = iOf9;
                                            i8 = iOf10;
                                            jSONField = jSONField2;
                                        } else {
                                            cls12 = cls10;
                                            jSONField = null;
                                            i7 = iOf9;
                                            i8 = iOf10;
                                        }
                                        propertyNamingStrategy3 = propertyNamingStrategy2;
                                        if (propertyNamingStrategy3 != null) {
                                            propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                        }
                                        fieldArr2 = fieldArr5;
                                        cls5 = cls5;
                                        propertyNamingStrategy2 = propertyNamingStrategy3;
                                        add(arrayList2, new FieldInfo(propertyNameByMethodName2, method3, field3, cls, type, iOrdinal5, i7, i8, superMethodAnnotation2, jSONField, null, mapBuildGenericInfo));
                                    } else {
                                        z4 = true;
                                        i6 = 0;
                                    }
                                    field3 = field2;
                                    if (field3 != null) {
                                        cls12 = cls10;
                                        jSONField2 = (JSONField) TypeUtils.getAnnotation(field3, cls12);
                                        if (jSONField2 != null) {
                                            if (jSONField2.deserialize()) {
                                                fieldArr2 = fieldArr5;
                                            } else {
                                                iOrdinal5 = jSONField2.ordinal();
                                                iOf9 = SerializerFeature.of(jSONField2.serialzeFeatures());
                                                iOf10 = Feature.of(jSONField2.parseFeatures());
                                                if (jSONField2.name().length() != 0) {
                                                    add(arrayList2, new FieldInfo(jSONField2.name(), method3, field3, cls, type, iOrdinal5, iOf9, iOf10, superMethodAnnotation2, jSONField2, null, mapBuildGenericInfo));
                                                    fieldArr2 = fieldArr5;
                                                }
                                            }
                                            propertyNamingStrategy2 = propertyNamingStrategy2;
                                        }
                                        cls12 = cls12;
                                        i7 = iOf9;
                                        i8 = iOf10;
                                        jSONField = jSONField2;
                                    } else {
                                        cls12 = cls10;
                                        jSONField = null;
                                        i7 = iOf9;
                                        i8 = iOf10;
                                    }
                                    propertyNamingStrategy3 = propertyNamingStrategy2;
                                    if (propertyNamingStrategy3 != null) {
                                        propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                    }
                                    fieldArr2 = fieldArr5;
                                    cls5 = cls5;
                                    propertyNamingStrategy2 = propertyNamingStrategy3;
                                    add(arrayList2, new FieldInfo(propertyNameByMethodName2, method3, field3, cls, type, iOrdinal5, i7, i8, superMethodAnnotation2, jSONField, null, mapBuildGenericInfo));
                                } else {
                                    str = str;
                                    methodArr3 = methodArr2;
                                    cls12 = cls10;
                                    i6 = 0;
                                }
                            }
                        }
                    }
                } else {
                    i23 = i23;
                    length6 = length6;
                    methodArr3 = methodArr4;
                    i6 = i3;
                    cls5 = cls5;
                    cls24 = cls24;
                    cls12 = cls6;
                    cls9 = cls2;
                    propertyNamingStrategy2 = propertyNamingStrategy2;
                    str = str;
                }
            }
            i23++;
            propertyNamingStrategy2 = propertyNamingStrategy2;
            cls2 = cls9;
            cls24 = cls24;
            methodArr4 = methodArr3;
            i3 = i6;
            length6 = length6;
            str = str;
            cls5 = cls5;
            cls6 = cls12;
        }
        Class<?> cls32 = cls5;
        Class cls33 = cls6;
        PropertyNamingStrategy propertyNamingStrategy6 = propertyNamingStrategy2;
        computeFields(cls, type, propertyNamingStrategy6, arrayList2, cls.getFields());
        Method[] methods3 = cls.getMethods();
        int length7 = methods3.length;
        int i24 = i3;
        while (i24 < length7) {
            Method method4 = methods3[i24];
            String name4 = method4.getName();
            if (name4.length() >= i4 && !Modifier.isStatic(method4.getModifiers()) && cls32 == null && name4.startsWith(str2)) {
                if (Character.isUpperCase(name4.charAt(3)) && method4.getParameterTypes().length == 0) {
                    Class<Collection> cls34 = cls3;
                    if (cls34.isAssignableFrom(method4.getReturnType()) || Map.class.isAssignableFrom(method4.getReturnType()) || AtomicBoolean.class == method4.getReturnType() || AtomicInteger.class == method4.getReturnType() || AtomicLong.class == method4.getReturnType()) {
                        Class cls35 = cls33;
                        JSONField jSONField8 = (JSONField) TypeUtils.getAnnotation(method4, cls35);
                        if (jSONField8 == null || !jSONField8.deserialize()) {
                            if (jSONField8 != null && jSONField8.name().length() > 0) {
                                propertyNameByMethodName = jSONField8.name();
                                field = null;
                                fieldArr4 = fieldArr2;
                            } else {
                                propertyNameByMethodName = TypeUtils.getPropertyNameByMethodName(name4);
                                fieldArr4 = fieldArr2;
                                Field field8 = TypeUtils.getField(cls, propertyNameByMethodName, fieldArr4);
                                if (field8 == null) {
                                    field = null;
                                } else {
                                    JSONField jSONField9 = (JSONField) TypeUtils.getAnnotation(field8, cls35);
                                    if (jSONField9 != null && !jSONField9.deserialize()) {
                                        fieldArr3 = fieldArr4;
                                        cls8 = cls35;
                                        cls7 = cls34;
                                        i4 = i4;
                                    } else if (cls34.isAssignableFrom(method4.getReturnType()) || Map.class.isAssignableFrom(method4.getReturnType())) {
                                        field = field8;
                                    } else {
                                        field = null;
                                    }
                                }
                            }
                            if (propertyNamingStrategy6 != null) {
                                propertyNameByMethodName = propertyNamingStrategy6.translate(propertyNameByMethodName);
                            }
                            String str10 = propertyNameByMethodName;
                            if (getField(arrayList2, str10) != null) {
                                fieldArr3 = fieldArr4;
                                cls8 = cls35;
                                cls7 = cls34;
                                i4 = 4;
                            } else {
                                fieldArr3 = fieldArr4;
                                cls8 = cls35;
                                cls7 = cls34;
                                i4 = 4;
                                str2 = str2;
                                i24 = i24;
                                length7 = length7;
                                methods3 = methods3;
                                add(arrayList2, new FieldInfo(str10, method4, field, cls, type, 0, 0, 0, jSONField8, null, null, mapBuildGenericInfo));
                            }
                        } else {
                            cls8 = cls35;
                            cls7 = cls34;
                            i4 = i4;
                            str2 = str2;
                            i24 = i24;
                            length7 = length7;
                            methods3 = methods3;
                            fieldArr3 = fieldArr2;
                        }
                    } else {
                        cls7 = cls34;
                    }
                    i24++;
                    length7 = length7;
                    i4 = i4;
                    str2 = str2;
                    methods3 = methods3;
                    cls33 = cls8;
                    cls3 = cls7;
                    fieldArr2 = fieldArr3;
                } else {
                    cls7 = cls3;
                }
                fieldArr3 = fieldArr2;
                cls8 = cls33;
                i24++;
                length7 = length7;
                i4 = i4;
                str2 = str2;
                methods3 = methods3;
                cls33 = cls8;
                cls3 = cls7;
                fieldArr2 = fieldArr3;
            } else {
                i4 = i4;
                cls7 = cls3;
                fieldArr3 = fieldArr2;
                cls8 = cls33;
            }
            i24++;
            length7 = length7;
            i4 = i4;
            str2 = str2;
            methods3 = methods3;
            cls33 = cls8;
            cls3 = cls7;
            fieldArr2 = fieldArr3;
        }
        Field[] fieldArr7 = fieldArr2;
        if (arrayList2.size() == 0) {
            if (TypeUtils.isXmlField(cls) ? true : z) {
                for (Class<?> superclass2 = cls; superclass2 != null; superclass2 = superclass2.getSuperclass()) {
                    computeFields(cls, type, propertyNamingStrategy6, arrayList2, fieldArr7);
                }
            }
        }
        return new JavaBeanInfo(cls, cls32, constructor, constructor2, factoryMethod, method, jSONType, arrayList2);
    }
}
