package com.zj.adlib;

import com.acse.ottn.p3;
import com.easyjson.JSONException;
import com.easyjson.annotation.JSONCreator;
import com.easyjson.annotation.JSONField;
import com.easyjson.annotation.JSONType;
import com.easyjson.parser.Feature;
import com.easyjson.serializer.SerializerFeature;
import com.easyjson.util.FieldInfo;
import com.easyjson.util.TypeUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class dhb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f41184a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final JSONType f15991a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f15992a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Constructor<?> f15993a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Method f15994a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15995a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final FieldInfo[] f15996a;
    public final Constructor<?> b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f15997b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final FieldInfo[] f15998b;

    /* JADX WARN: Code duplicated, block: B:7:0x001f  */
    public dhb(Class<?> cls, Constructor<?> constructor, Constructor<?> constructor2, Method method, FieldInfo[] fieldInfoArr, FieldInfo[] fieldInfoArr2, JSONType jSONType) {
        boolean z;
        this.f15993a = constructor;
        this.b = constructor2;
        this.f15994a = method;
        this.f15996a = fieldInfoArr;
        this.f15991a = jSONType;
        if (jSONType != null) {
            String strTypeName = jSONType.typeName();
            if (strTypeName.length() != 0) {
                this.f15992a = strTypeName;
            } else {
                this.f15992a = cls.getName();
            }
        } else {
            this.f15992a = cls.getName();
        }
        if (jSONType != null) {
            Feature[] features = jSONType.parseFeatures();
            z = false;
            for (Feature feature : features) {
                if (feature == Feature.SupportArrayToBean) {
                    z = true;
                }
            }
        } else {
            z = false;
        }
        this.f15997b = z;
        FieldInfo[] fieldInfoArrC = c(fieldInfoArr, fieldInfoArr2);
        this.f15998b = Arrays.equals(fieldInfoArr, fieldInfoArrC) ? fieldInfoArr : fieldInfoArrC;
        this.f41184a = constructor != null ? constructor.getParameterTypes().length : 0;
    }

    /* JADX WARN: Code duplicated, block: B:111:0x0224  */
    /* JADX WARN: Code duplicated, block: B:114:0x022e  */
    /* JADX WARN: Code duplicated, block: B:116:0x0232  */
    /* JADX WARN: Code duplicated, block: B:148:0x0304 A[PHI: r21 r22 r26 r27 r28 r29 r30
      0x0304: PHI (r21v8 java.lang.reflect.Method[]) = 
      (r8v7 java.lang.reflect.Method[])
      (r8v7 java.lang.reflect.Method[])
      (r8v7 java.lang.reflect.Method[])
      (r21v10 java.lang.reflect.Method[])
     binds: [B:147:0x0302, B:163:0x0352, B:165:0x035c, B:143:0x029c] A[DONT_GENERATE, DONT_INLINE]
      0x0304: PHI (r22v5 java.lang.reflect.Constructor<?>) = 
      (r9v10 java.lang.reflect.Constructor<?>)
      (r9v10 java.lang.reflect.Constructor<?>)
      (r9v10 java.lang.reflect.Constructor<?>)
      (r22v8 java.lang.reflect.Constructor<?>)
     binds: [B:147:0x0302, B:163:0x0352, B:165:0x035c, B:143:0x029c] A[DONT_GENERATE, DONT_INLINE]
      0x0304: PHI (r26v4 int) = (r1v40 int), (r1v40 int), (r1v40 int), (r26v6 int) binds: [B:147:0x0302, B:163:0x0352, B:165:0x035c, B:143:0x029c] A[DONT_GENERATE, DONT_INLINE]
      0x0304: PHI (r27v4 int) = (r2v28 int), (r2v28 int), (r2v28 int), (r27v6 int) binds: [B:147:0x0302, B:163:0x0352, B:165:0x035c, B:143:0x029c] A[DONT_GENERATE, DONT_INLINE]
      0x0304: PHI (r28v2 java.lang.Class<com.easyjson.annotation.JSONField>) = 
      (r5v9 java.lang.Class<com.easyjson.annotation.JSONField>)
      (r5v9 java.lang.Class<com.easyjson.annotation.JSONField>)
      (r5v9 java.lang.Class<com.easyjson.annotation.JSONField>)
      (r28v4 java.lang.Class<com.easyjson.annotation.JSONField>)
     binds: [B:147:0x0302, B:163:0x0352, B:165:0x035c, B:143:0x029c] A[DONT_GENERATE, DONT_INLINE]
      0x0304: PHI (r29v7 java.lang.Class<? super ?>) = 
      (r6v18 java.lang.Class<? super ?>)
      (r6v18 java.lang.Class<? super ?>)
      (r6v18 java.lang.Class<? super ?>)
      (r29v9 java.lang.Class<? super ?>)
     binds: [B:147:0x0302, B:163:0x0352, B:165:0x035c, B:143:0x029c] A[DONT_GENERATE, DONT_INLINE]
      0x0304: PHI (r30v5 java.lang.Class<com.easyjson.annotation.JSONType>) = 
      (r10v18 java.lang.Class<com.easyjson.annotation.JSONType>)
      (r10v18 java.lang.Class<com.easyjson.annotation.JSONType>)
      (r10v18 java.lang.Class<com.easyjson.annotation.JSONType>)
      (r30v7 java.lang.Class<com.easyjson.annotation.JSONType>)
     binds: [B:147:0x0302, B:163:0x0352, B:165:0x035c, B:143:0x029c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:166:0x035e  */
    /* JADX WARN: Code duplicated, block: B:186:0x0412  */
    /* JADX WARN: Code duplicated, block: B:190:0x044d  */
    /* JADX WARN: Code duplicated, block: B:199:0x046c  */
    /* JADX WARN: Code duplicated, block: B:201:0x0470  */
    /* JADX WARN: Code duplicated, block: B:203:0x0478  */
    /* JADX WARN: Code duplicated, block: B:214:0x04a5  */
    /* JADX WARN: Code duplicated, block: B:216:0x04b8  */
    /* JADX WARN: Code duplicated, block: B:218:0x04c6  */
    /* JADX WARN: Code duplicated, block: B:224:0x04d1  */
    /* JADX WARN: Code duplicated, block: B:225:0x04d9  */
    /* JADX WARN: Code duplicated, block: B:227:0x04dd  */
    /* JADX WARN: Code duplicated, block: B:229:0x04f3  */
    /* JADX WARN: Code duplicated, block: B:231:0x04fb  */
    /* JADX WARN: Code duplicated, block: B:235:0x0521  */
    /* JADX WARN: Code duplicated, block: B:237:0x0529  */
    /* JADX WARN: Code duplicated, block: B:239:0x0536  */
    /* JADX WARN: Code duplicated, block: B:23:0x004f  */
    /* JADX WARN: Code duplicated, block: B:24:0x0052  */
    /* JADX WARN: Code duplicated, block: B:254:0x0574  */
    /* JADX WARN: Code duplicated, block: B:255:0x057d  */
    /* JADX WARN: Code duplicated, block: B:257:0x0581  */
    /* JADX WARN: Code duplicated, block: B:259:0x058b  */
    /* JADX WARN: Code duplicated, block: B:260:0x058d  */
    /* JADX WARN: Code duplicated, block: B:263:0x05e7  */
    /* JADX WARN: Code duplicated, block: B:264:0x05f3  */
    /* JADX WARN: Code duplicated, block: B:269:0x061b  */
    /* JADX WARN: Code duplicated, block: B:270:0x0625  */
    /* JADX WARN: Code duplicated, block: B:302:0x049a A[EDGE_INSN: B:302:0x049a->B:211:0x049a BREAK  A[LOOP:8: B:198:0x046a->B:210:0x0492], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:308:0x04cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:310:0x049f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:314:0x04c7 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:201:0x0470, please report this as an issue */
    public static dhb a(Class<?> cls, int i, Type type, boolean z, boolean z2, boolean z3, boolean z4) {
        Constructor<?> declaredConstructor;
        Constructor<?> constructor;
        Method[] methods;
        Field[] declaredFields;
        Class<JSONType> cls2;
        Field[] fieldArr;
        Class<JSONType> cls3;
        Class<? super Object> cls4;
        Class<JSONField> cls5;
        int i2;
        Class<JSONField> cls6;
        Class<? super Object> cls7;
        Class<JSONType> cls8;
        Field[] fieldArr2;
        ArrayList<Field> arrayList;
        int i3;
        Class<? super Object> superclass;
        boolean z5;
        Class<JSONField> cls9;
        JSONType jSONType;
        Method[] methods2;
        int length;
        int i4;
        Method method;
        String name;
        Class<?> returnType;
        JSONField jSONField;
        char c;
        String string;
        String name2;
        int size;
        boolean z6;
        int i5;
        Class<JSONField> cls10;
        JSONField jSONField2;
        String str;
        int i6;
        int i7;
        Class<? super Object> cls11;
        int i8;
        int length2;
        int i9;
        String name3;
        Class<JSONField> cls12;
        Field[] fieldArr3;
        Class<?> returnType2;
        int iOrdinal;
        int iOf;
        String strSubstring;
        boolean z7;
        Constructor<?> constructor2;
        Method method2;
        JSONField jSONField3;
        JSONField jSONField4;
        Class<?> cls13 = cls;
        int i10 = i;
        ArrayList arrayList2 = new ArrayList();
        int i11 = i10 & 1024;
        int i12 = 1;
        int i13 = 0;
        if (i11 == 0) {
            try {
                declaredConstructor = cls13.getDeclaredConstructor(new Class[0]);
            } catch (Exception unused) {
                declaredConstructor = null;
            }
            if (declaredConstructor == null && cls.isMemberClass() && (i10 & 8) == 0) {
                Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
                int length3 = declaredConstructors.length;
                int i14 = 0;
                while (true) {
                    if (i14 < length3) {
                        Constructor<?> constructor3 = declaredConstructors[i14];
                        Class<?>[] parameterTypes = constructor3.getParameterTypes();
                        if (parameterTypes.length == 1 && parameterTypes[0].equals(cls.getDeclaringClass())) {
                            constructor = constructor3;
                            break;
                        }
                        i14++;
                    }
                }
            }
            if (z) {
                methods = null;
            } else {
                methods = cls.getMethods();
            }
            declaredFields = cls.getDeclaredFields();
            cls2 = JSONType.class;
            if (constructor != null && !cls.isInterface() && i11 == 0) {
                Constructor<?>[] declaredConstructors2 = cls.getDeclaredConstructors();
                int length4 = declaredConstructors2.length;
                int i15 = 0;
                while (true) {
                    if (i15 >= length4) {
                        constructor2 = null;
                        break;
                    }
                    Constructor<?> constructor4 = declaredConstructors2[i15];
                    if (((JSONCreator) constructor4.getAnnotation(JSONCreator.class)) != null) {
                        constructor2 = constructor4;
                        break;
                    }
                    i15++;
                }
                if (constructor2 != null) {
                    TypeUtils.setAccessible(cls13, constructor2, i10);
                    Class<?>[] parameterTypes2 = constructor2.getParameterTypes();
                    Type[] genericParameterTypes = z4 ? constructor2.getGenericParameterTypes() : parameterTypes2;
                    int i16 = 0;
                    while (i16 < parameterTypes2.length) {
                        Annotation[] annotationArr = constructor2.getParameterAnnotations()[i16];
                        int length5 = annotationArr.length;
                        int i17 = i13;
                        while (true) {
                            if (i17 >= length5) {
                                jSONField4 = null;
                                break;
                            }
                            Annotation annotation = annotationArr[i17];
                            if (annotation instanceof JSONField) {
                                jSONField4 = (JSONField) annotation;
                                break;
                            }
                            i17++;
                        }
                        if (jSONField4 == null) {
                            throw new JSONException("illegal json creator");
                        }
                        Class<?> cls14 = parameterTypes2[i16];
                        Type type2 = genericParameterTypes[i16];
                        Field field = TypeUtils.getField(cls13, jSONField4.name(), declaredFields);
                        if (field != null) {
                            TypeUtils.setAccessible(cls13, field, i10);
                        }
                        b(arrayList2, new FieldInfo(jSONField4.name(), cls, cls14, type2, field, jSONField4.ordinal(), SerializerFeature.of(jSONField4.serialzeFeatures())), z);
                        i16++;
                        cls2 = cls2;
                        declaredFields = declaredFields;
                        i13 = 0;
                        i10 = i;
                    }
                    Class<JSONType> cls15 = cls2;
                    int size2 = arrayList2.size();
                    FieldInfo[] fieldInfoArr = new FieldInfo[size2];
                    arrayList2.toArray(fieldInfoArr);
                    FieldInfo[] fieldInfoArr2 = new FieldInfo[size2];
                    System.arraycopy(fieldInfoArr, 0, fieldInfoArr2, 0, size2);
                    Arrays.sort(fieldInfoArr2);
                    return new dhb(cls, null, constructor2, null, fieldInfoArr, fieldInfoArr2, z2 ? (JSONType) cls13.getAnnotation(cls15) : null);
                }
                Field[] fieldArr4 = declaredFields;
                int length6 = methods.length;
                int i18 = 0;
                while (true) {
                    if (i18 >= length6) {
                        method2 = null;
                        break;
                    }
                    Method method3 = methods[i18];
                    if (Modifier.isStatic(method3.getModifiers()) && cls13.isAssignableFrom(method3.getReturnType()) && ((JSONCreator) method3.getAnnotation(JSONCreator.class)) != null) {
                        method2 = method3;
                        break;
                    }
                    i18++;
                }
                if (method2 == null) {
                    throw new JSONException("default constructor not found. " + cls13);
                }
                TypeUtils.setAccessible(cls13, method2, i);
                Class<?>[] parameterTypes3 = method2.getParameterTypes();
                Type[] genericParameterTypes2 = z4 ? method2.getGenericParameterTypes() : parameterTypes3;
                int i19 = 0;
                while (i19 < parameterTypes3.length) {
                    Annotation[] annotationArr2 = method2.getParameterAnnotations()[i19];
                    int length7 = annotationArr2.length;
                    int i20 = 0;
                    while (true) {
                        if (i20 >= length7) {
                            jSONField3 = null;
                            break;
                        }
                        Annotation annotation2 = annotationArr2[i20];
                        if (annotation2 instanceof JSONField) {
                            jSONField3 = (JSONField) annotation2;
                            break;
                        }
                        i20++;
                    }
                    if (jSONField3 == null) {
                        throw new JSONException("illegal json creator");
                    }
                    Field[] fieldArr5 = fieldArr4;
                    b(arrayList2, new FieldInfo(jSONField3.name(), cls, parameterTypes3[i19], genericParameterTypes2[i19], TypeUtils.getField(cls13, jSONField3.name(), fieldArr5), jSONField3.ordinal(), SerializerFeature.of(jSONField3.serialzeFeatures())), z);
                    i19++;
                    parameterTypes3 = parameterTypes3;
                    fieldArr4 = fieldArr5;
                }
                int size3 = arrayList2.size();
                FieldInfo[] fieldInfoArr3 = new FieldInfo[size3];
                arrayList2.toArray(fieldInfoArr3);
                FieldInfo[] fieldInfoArr4 = new FieldInfo[size3];
                System.arraycopy(fieldInfoArr3, 0, fieldInfoArr4, 0, size3);
                Arrays.sort(fieldInfoArr4);
                return new dhb(cls, null, null, method2, fieldInfoArr3, Arrays.equals(fieldInfoArr3, fieldInfoArr4) ? fieldInfoArr3 : fieldInfoArr4, z2 ? (JSONType) cls13.getAnnotation(cls2) : null);
            }
            fieldArr = declaredFields;
            cls3 = cls2;
            if (constructor != null) {
                TypeUtils.setAccessible(cls13, constructor, i10);
            }
            cls4 = Object.class;
            cls5 = JSONField.class;
            i2 = 4;
            if (!z) {
                length2 = methods.length;
                i9 = 0;
                while (i9 < length2) {
                    Method method4 = methods[i9];
                    name3 = method4.getName();
                    if (name3.length() >= i2 || Modifier.isStatic(method4.getModifiers()) || !(((returnType2 = method4.getReturnType()) == Void.TYPE || returnType2 == method4.getDeclaringClass()) && method4.getParameterTypes().length == i12 && method4.getDeclaringClass() != cls4)) {
                        i9 = i9;
                        length2 = length2;
                        cls12 = cls5;
                        cls4 = cls4;
                        methods = methods;
                        constructor = constructor;
                        cls3 = cls3;
                        fieldArr3 = fieldArr;
                    } else {
                        JSONField supperMethodAnnotation = z3 ? (JSONField) method4.getAnnotation(cls5) : null;
                        if (supperMethodAnnotation == null && z3) {
                            supperMethodAnnotation = TypeUtils.getSupperMethodAnnotation(cls13, method4);
                        }
                        JSONField jSONField5 = supperMethodAnnotation;
                        if (jSONField5 == null) {
                            iOrdinal = 0;
                            iOf = 0;
                        } else if (jSONField5.deserialize()) {
                            int iOrdinal2 = jSONField5.ordinal();
                            iOf = SerializerFeature.of(jSONField5.serialzeFeatures());
                            if (jSONField5.name().length() != 0) {
                                i9 = i9;
                                length2 = length2;
                                cls5 = cls5;
                                cls4 = cls4;
                                methods = methods;
                                constructor = constructor;
                                cls3 = cls3;
                                b(arrayList2, new FieldInfo(jSONField5.name(), method4, null, cls, type, iOrdinal2, iOf, jSONField5, null, z4), z);
                                TypeUtils.setAccessible(cls13, method4, i10);
                            } else {
                                iOrdinal = iOrdinal2;
                            }
                            fieldArr3 = fieldArr;
                            cls12 = cls5;
                        } else {
                            i9 = i9;
                            length2 = length2;
                            cls12 = cls5;
                            cls4 = cls4;
                            methods = methods;
                            constructor = constructor;
                            cls3 = cls3;
                            fieldArr3 = fieldArr;
                        }
                        if (name3.startsWith(p3.h)) {
                            char cCharAt = name3.charAt(3);
                            if (Character.isUpperCase(cCharAt)) {
                                if (TypeUtils.compatibleWithJavaBean) {
                                    strSubstring = TypeUtils.decapitalize(name3.substring(3));
                                } else {
                                    strSubstring = Character.toLowerCase(name3.charAt(3)) + name3.substring(4);
                                }
                            } else if (cCharAt == '_') {
                                strSubstring = name3.substring(4);
                            } else if (cCharAt == 'f') {
                                strSubstring = name3.substring(3);
                            } else if (name3.length() < 5 || !Character.isUpperCase(name3.charAt(4))) {
                                fieldArr3 = fieldArr;
                                cls12 = cls5;
                            } else {
                                strSubstring = TypeUtils.decapitalize(name3.substring(3));
                            }
                            String str2 = strSubstring;
                            fieldArr3 = fieldArr;
                            Field field2 = TypeUtils.getField(cls13, str2, fieldArr3);
                            if (field2 == null) {
                                z7 = false;
                                if (method4.getParameterTypes()[0] == Boolean.TYPE) {
                                    field2 = TypeUtils.getField(cls13, p3.g + Character.toUpperCase(str2.charAt(0)) + str2.substring(1), fieldArr3);
                                }
                            } else {
                                z7 = false;
                            }
                            Field field3 = field2;
                            if (field3 != null) {
                                Class<JSONField> cls16 = cls5;
                                JSONField jSONField6 = z3 ? (JSONField) field3.getAnnotation(cls16) : null;
                                if (jSONField6 != null) {
                                    iOrdinal = jSONField6.ordinal();
                                    iOf = SerializerFeature.of(jSONField6.serialzeFeatures());
                                    if (jSONField6.name().length() != 0) {
                                        cls12 = cls16;
                                        fieldArr3 = fieldArr3;
                                        b(arrayList2, new FieldInfo(jSONField6.name(), method4, field3, cls, type, iOrdinal, iOf, jSONField5, jSONField6, z4), z);
                                    }
                                }
                                cls12 = cls16;
                            } else {
                                cls12 = cls5;
                            }
                            b(arrayList2, new FieldInfo(str2, method4, null, cls, type, iOrdinal, iOf, jSONField5, null, z4), z);
                            cls13 = cls;
                            TypeUtils.setAccessible(cls13, method4, i10);
                        } else {
                            fieldArr3 = fieldArr;
                            cls12 = cls5;
                        }
                    }
                    i9++;
                    methods = methods;
                    constructor = constructor;
                    length2 = length2;
                    cls4 = cls4;
                    cls3 = cls3;
                    cls5 = cls12;
                    fieldArr = fieldArr3;
                    i2 = 4;
                    i12 = 1;
                }
            }
            cls6 = cls5;
            cls7 = cls4;
            Constructor<?> constructor5 = constructor;
            cls8 = cls3;
            fieldArr2 = fieldArr;
            arrayList = new ArrayList(fieldArr2.length);
            for (Field field4 : fieldArr2) {
                if ((field4.getModifiers() & 8) == 0 && (field4.getModifiers() & 1) != 0) {
                    arrayList.add(field4);
                }
            }
            superclass = cls.getSuperclass();
            while (superclass != null) {
                cls11 = cls7;
                if (superclass != cls11) {
                    break;
                }
                for (Field field5 : superclass.getDeclaredFields()) {
                    if ((field5.getModifiers() & 8) == 0 && (field5.getModifiers() & 1) != 0) {
                        arrayList.add(field5);
                    }
                }
                superclass = superclass.getSuperclass();
                cls7 = cls11;
            }
            z5 = true;
            for (Field field6 : arrayList) {
                name2 = field6.getName();
                size = arrayList2.size();
                z6 = false;
                for (i5 = 0; i5 < size; i5++) {
                    if (((FieldInfo) arrayList2.get(i5)).name.equals(name2)) {
                        z6 = z5;
                    }
                }
                if (z6) {
                    cls10 = cls6;
                    if (z3) {
                        jSONField2 = (JSONField) field6.getAnnotation(cls10);
                    } else {
                        jSONField2 = null;
                    }
                    if (jSONField2 != null) {
                        int iOrdinal3 = jSONField2.ordinal();
                        int iOf2 = SerializerFeature.of(jSONField2.serialzeFeatures());
                        if (jSONField2.name().length() != 0) {
                            name2 = jSONField2.name();
                        }
                        i6 = iOrdinal3;
                        i7 = iOf2;
                        str = name2;
                    } else {
                        str = name2;
                        i6 = 0;
                        i7 = 0;
                    }
                    TypeUtils.setAccessible(cls13, field6, i10);
                    b(arrayList2, new FieldInfo(str, null, field6, cls, type, i6, i7, null, jSONField2, z4), z);
                    z5 = true;
                    cls6 = cls10;
                    cls13 = cls;
                }
            }
            cls9 = cls6;
            if (!z) {
                methods2 = cls.getMethods();
                i4 = 0;
                for (length = methods2.length; i4 < length; length = length) {
                    method = methods2[i4];
                    name = method.getName();
                    if (name.length() < 4) {
                        if (!Modifier.isStatic(method.getModifiers()) && name.startsWith(p3.f)) {
                            if (Character.isUpperCase(name.charAt(3)) && method.getParameterTypes().length == 0) {
                                returnType = method.getReturnType();
                                if (!Collection.class.isAssignableFrom(returnType) || Map.class.isAssignableFrom(returnType)) {
                                    if (z3) {
                                        jSONField = (JSONField) method.getAnnotation(cls9);
                                    } else {
                                        jSONField = null;
                                    }
                                    if (jSONField != null) {
                                        string = jSONField.name();
                                        if (string.length() > 0) {
                                            c = 4;
                                        } else {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append(Character.toLowerCase(name.charAt(3)));
                                            c = 4;
                                            sb.append(name.substring(4));
                                            string = sb.toString();
                                        }
                                    } else {
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append(Character.toLowerCase(name.charAt(3)));
                                        c = 4;
                                        sb2.append(name.substring(4));
                                        string = sb2.toString();
                                    }
                                    b(arrayList2, new FieldInfo(string, method, null, cls, type, 0, 0, jSONField, null, z4), z);
                                    TypeUtils.setAccessible(cls, method, i10);
                                }
                            }
                        }
                        i4++;
                        cls9 = cls9;
                    }
                    i4++;
                    cls9 = cls9;
                }
            }
            int size4 = arrayList2.size();
            FieldInfo[] fieldInfoArr5 = new FieldInfo[size4];
            arrayList2.toArray(fieldInfoArr5);
            FieldInfo[] fieldInfoArr6 = new FieldInfo[size4];
            System.arraycopy(fieldInfoArr5, 0, fieldInfoArr6, 0, size4);
            Arrays.sort(fieldInfoArr6);
            if (z2) {
                jSONType = (JSONType) cls.getAnnotation(cls8);
            } else {
                jSONType = null;
            }
            return new dhb(cls, constructor5, null, null, fieldInfoArr5, fieldInfoArr6, jSONType);
        }
        declaredConstructor = null;
        constructor = declaredConstructor;
        if (z) {
            methods = null;
        } else {
            methods = cls.getMethods();
        }
        declaredFields = cls.getDeclaredFields();
        cls2 = JSONType.class;
        if (constructor != null) {
        }
        fieldArr = declaredFields;
        cls3 = cls2;
        if (constructor != null) {
            TypeUtils.setAccessible(cls13, constructor, i10);
        }
        cls4 = Object.class;
        cls5 = JSONField.class;
        i2 = 4;
        if (!z) {
            length2 = methods.length;
            i9 = 0;
            while (i9 < length2) {
                Method method5 = methods[i9];
                name3 = method5.getName();
                if (name3.length() >= i2) {
                    i9 = i9;
                    length2 = length2;
                    cls12 = cls5;
                    cls4 = cls4;
                    methods = methods;
                    constructor = constructor;
                    cls3 = cls3;
                    fieldArr3 = fieldArr;
                } else {
                    i9 = i9;
                    length2 = length2;
                    cls12 = cls5;
                    cls4 = cls4;
                    methods = methods;
                    constructor = constructor;
                    cls3 = cls3;
                    fieldArr3 = fieldArr;
                }
                i9++;
                methods = methods;
                constructor = constructor;
                length2 = length2;
                cls4 = cls4;
                cls3 = cls3;
                cls5 = cls12;
                fieldArr = fieldArr3;
                i2 = 4;
                i12 = 1;
            }
        }
        cls6 = cls5;
        cls7 = cls4;
        Constructor<?> constructor6 = constructor;
        cls8 = cls3;
        fieldArr2 = fieldArr;
        arrayList = new ArrayList(fieldArr2.length);
        while (i3 < r2) {
            if ((field4.getModifiers() & 8) == 0) {
                arrayList.add(field4);
            }
        }
        superclass = cls.getSuperclass();
        while (superclass != null) {
            cls11 = cls7;
            if (superclass != cls11) {
                break;
                break;
            }
            while (i8 < r4) {
                if ((field5.getModifiers() & 8) == 0) {
                    arrayList.add(field5);
                }
            }
            superclass = superclass.getSuperclass();
            cls7 = cls11;
        }
        z5 = true;
        while (r17.hasNext()) {
            name2 = field6.getName();
            size = arrayList2.size();
            z6 = false;
            while (i5 < size) {
                if (((FieldInfo) arrayList2.get(i5)).name.equals(name2)) {
                    z6 = z5;
                }
            }
            if (z6) {
                cls10 = cls6;
                if (z3) {
                    jSONField2 = (JSONField) field6.getAnnotation(cls10);
                } else {
                    jSONField2 = null;
                }
                if (jSONField2 != null) {
                    int iOrdinal4 = jSONField2.ordinal();
                    int iOf3 = SerializerFeature.of(jSONField2.serialzeFeatures());
                    if (jSONField2.name().length() != 0) {
                        name2 = jSONField2.name();
                    }
                    i6 = iOrdinal4;
                    i7 = iOf3;
                    str = name2;
                } else {
                    str = name2;
                    i6 = 0;
                    i7 = 0;
                }
                TypeUtils.setAccessible(cls13, field6, i10);
                b(arrayList2, new FieldInfo(str, null, field6, cls, type, i6, i7, null, jSONField2, z4), z);
                z5 = true;
                cls6 = cls10;
                cls13 = cls;
            }
        }
        cls9 = cls6;
        if (!z) {
            methods2 = cls.getMethods();
            i4 = 0;
            while (i4 < length) {
                method = methods2[i4];
                name = method.getName();
                if (name.length() < 4) {
                    if (!Modifier.isStatic(method.getModifiers())) {
                        if (Character.isUpperCase(name.charAt(3))) {
                            returnType = method.getReturnType();
                            if (!Collection.class.isAssignableFrom(returnType)) {
                            }
                            if (z3) {
                                jSONField = (JSONField) method.getAnnotation(cls9);
                            } else {
                                jSONField = null;
                            }
                            if (jSONField != null) {
                                string = jSONField.name();
                                if (string.length() > 0) {
                                    c = 4;
                                } else {
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append(Character.toLowerCase(name.charAt(3)));
                                    c = 4;
                                    sb3.append(name.substring(4));
                                    string = sb3.toString();
                                }
                            } else {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append(Character.toLowerCase(name.charAt(3)));
                                c = 4;
                                sb4.append(name.substring(4));
                                string = sb4.toString();
                            }
                            b(arrayList2, new FieldInfo(string, method, null, cls, type, 0, 0, jSONField, null, z4), z);
                            TypeUtils.setAccessible(cls, method, i10);
                        }
                    }
                    i4++;
                    cls9 = cls9;
                }
                i4++;
                cls9 = cls9;
            }
        }
        int size5 = arrayList2.size();
        FieldInfo[] fieldInfoArr7 = new FieldInfo[size5];
        arrayList2.toArray(fieldInfoArr7);
        FieldInfo[] fieldInfoArr8 = new FieldInfo[size5];
        System.arraycopy(fieldInfoArr7, 0, fieldInfoArr8, 0, size5);
        Arrays.sort(fieldInfoArr8);
        if (z2) {
            jSONType = (JSONType) cls.getAnnotation(cls8);
        } else {
            jSONType = null;
        }
        return new dhb(cls, constructor6, null, null, fieldInfoArr7, fieldInfoArr8, jSONType);
    }

    public static boolean b(List<FieldInfo> list, FieldInfo fieldInfo, boolean z) {
        if (!z) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                FieldInfo fieldInfo2 = list.get(i);
                if (fieldInfo2.name.equals(fieldInfo.name) && (!fieldInfo2.getOnly || fieldInfo.getOnly)) {
                    return false;
                }
            }
        }
        list.add(fieldInfo);
        return true;
    }

    public final FieldInfo[] c(FieldInfo[] fieldInfoArr, FieldInfo[] fieldInfoArr2) {
        String[] strArrOrders;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        JSONType jSONType = this.f15991a;
        if (jSONType != null && (strArrOrders = jSONType.orders()) != null && strArrOrders.length != 0) {
            int i = 0;
            while (true) {
                if (i >= strArrOrders.length) {
                    z = true;
                    break;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= fieldInfoArr2.length) {
                        z4 = false;
                        break;
                    }
                    if (fieldInfoArr2[i2].name.equals(strArrOrders[i])) {
                        z4 = true;
                        break;
                    }
                    i2++;
                }
                if (!z4) {
                    z = false;
                    break;
                }
                i++;
            }
            if (!z) {
                return fieldInfoArr2;
            }
            if (strArrOrders.length == fieldInfoArr.length) {
                int i3 = 0;
                while (true) {
                    if (i3 >= strArrOrders.length) {
                        z3 = true;
                        break;
                    }
                    if (!fieldInfoArr2[i3].name.equals(strArrOrders[i3])) {
                        z3 = false;
                        break;
                    }
                    i3++;
                }
                if (z3) {
                    return fieldInfoArr2;
                }
                FieldInfo[] fieldInfoArr3 = new FieldInfo[fieldInfoArr2.length];
                for (int i4 = 0; i4 < strArrOrders.length; i4++) {
                    for (int i5 = 0; i5 < fieldInfoArr2.length; i5++) {
                        if (fieldInfoArr2[i5].name.equals(strArrOrders[i4])) {
                            fieldInfoArr3[i4] = fieldInfoArr2[i5];
                            break;
                        }
                    }
                }
                this.f15995a = true;
                return fieldInfoArr3;
            }
            int length = fieldInfoArr2.length;
            FieldInfo[] fieldInfoArr4 = new FieldInfo[length];
            for (int i6 = 0; i6 < strArrOrders.length; i6++) {
                for (int i7 = 0; i7 < fieldInfoArr2.length; i7++) {
                    if (fieldInfoArr2[i7].name.equals(strArrOrders[i6])) {
                        fieldInfoArr4[i6] = fieldInfoArr2[i7];
                        break;
                    }
                }
            }
            int length2 = strArrOrders.length;
            for (int i8 = 0; i8 < fieldInfoArr2.length; i8++) {
                int i9 = 0;
                while (true) {
                    if (i9 >= length || i9 >= length2) {
                        z2 = false;
                        break;
                    }
                    if (fieldInfoArr4[i8].equals(fieldInfoArr2[i9])) {
                        z2 = true;
                        break;
                    }
                    i9++;
                }
                if (!z2) {
                    fieldInfoArr4[length2] = fieldInfoArr2[i8];
                    length2++;
                }
            }
            this.f15995a = true;
        }
        return fieldInfoArr2;
    }
}
