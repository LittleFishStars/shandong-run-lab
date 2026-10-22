package com.easyjson.util;

import com.easyjson.annotation.JSONField;
import com.google.common.net.c;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FieldInfo implements Comparable<FieldInfo> {
    public final Class<?> declaringClass;
    public final Field field;
    public final boolean fieldAccess;
    private final JSONField fieldAnnotation;
    public final Class<?> fieldClass;
    public final boolean fieldTransient;
    public final Type fieldType;
    public final boolean getOnly;
    public final boolean isEnum;
    public final Method method;
    private final JSONField methodAnnotation;
    public final String name;
    public final char[] name_chars;
    private int ordinal;

    public FieldInfo(String str, Class<?> cls, Class<?> cls2, Type type, Field field, int i, int i2) {
        this.name = str;
        this.declaringClass = cls;
        this.fieldClass = cls2;
        this.fieldType = type;
        this.method = null;
        this.field = field;
        this.ordinal = i;
        this.isEnum = cls2.isEnum();
        this.fieldAnnotation = null;
        this.methodAnnotation = null;
        if (field != null) {
            int modifiers = field.getModifiers();
            int i3 = modifiers & 1;
            this.fieldAccess = true;
            this.fieldTransient = Modifier.isTransient(modifiers);
        } else {
            this.fieldAccess = false;
            this.fieldTransient = false;
        }
        this.getOnly = false;
        int length = str.length();
        char[] cArr = new char[length + 3];
        this.name_chars = cArr;
        str.getChars(0, str.length(), cArr, 1);
        cArr[0] = '\"';
        cArr[length + 1] = '\"';
        cArr[length + 2] = c.b;
    }

    public FieldInfo(String str, Method method, Field field, Class<?> cls, Type type, int i, int i2, JSONField jSONField, JSONField jSONField2, boolean z) {
        Type genericType;
        Class<?> returnType;
        Type inheritGenericType;
        this.name = str;
        this.method = method;
        this.field = field;
        this.ordinal = i;
        this.methodAnnotation = jSONField;
        this.fieldAnnotation = jSONField2;
        if (field != null) {
            int modifiers = field.getModifiers();
            this.fieldAccess = method == null || ((modifiers & 1) != 0 && method.getReturnType() == field.getType());
            this.fieldTransient = (modifiers & 128) != 0;
        } else {
            this.fieldAccess = false;
            this.fieldTransient = false;
        }
        int length = str.length();
        char[] cArr = new char[length + 3];
        this.name_chars = cArr;
        str.getChars(0, str.length(), cArr, 1);
        cArr[0] = '\"';
        cArr[length + 1] = '\"';
        cArr[length + 2] = c.b;
        if (method != null) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1) {
                returnType = parameterTypes[0];
                genericType = (returnType == Class.class || returnType == String.class || returnType.isPrimitive() || !z) ? returnType : method.getGenericParameterTypes()[0];
                this.getOnly = false;
            } else {
                returnType = method.getReturnType();
                genericType = (returnType != Class.class && z) ? method.getGenericReturnType() : returnType;
                this.getOnly = true;
            }
            this.declaringClass = method.getDeclaringClass();
        } else {
            Class<?> type2 = field.getType();
            genericType = (type2.isPrimitive() || type2 == String.class || type2.isEnum() || !z) ? type2 : field.getGenericType();
            this.declaringClass = field.getDeclaringClass();
            this.getOnly = Modifier.isFinal(field.getModifiers());
            returnType = type2;
        }
        if (cls != null && returnType == Object.class && (genericType instanceof TypeVariable) && (inheritGenericType = getInheritGenericType(cls, (TypeVariable) genericType)) != null) {
            this.fieldClass = TypeUtils.getClass(inheritGenericType);
            this.fieldType = inheritGenericType;
            this.isEnum = returnType.isEnum();
            return;
        }
        if (!(genericType instanceof Class)) {
            Type fieldType = getFieldType(cls, type == null ? cls : type, genericType);
            if (fieldType != genericType && ((fieldType instanceof ParameterizedType) || (fieldType instanceof Class))) {
                returnType = TypeUtils.getClass(fieldType);
            }
            genericType = fieldType;
        }
        this.fieldType = genericType;
        this.fieldClass = returnType;
        this.isEnum = !returnType.isArray() && returnType.isEnum();
    }

    /* JADX WARN: Code duplicated, block: B:41:0x009d  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:52:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00be A[SYNTHETIC] */
    public static Type getFieldType(Class<?> cls, Type type, Type type2) {
        TypeVariable<Class<?>>[] typeParameters;
        ParameterizedType parameterizedType;
        int i;
        boolean z;
        Type type3;
        TypeVariable typeVariable;
        int i2;
        if (cls != null && type != null) {
            if (type2 instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                Type fieldType = getFieldType(cls, type, genericComponentType);
                return genericComponentType != fieldType ? Array.newInstance(TypeUtils.getClass(fieldType), 0).getClass() : type2;
            }
            if (!TypeUtils.isGenericParamType(type)) {
                return type2;
            }
            if (type2 instanceof TypeVariable) {
                ParameterizedType parameterizedType2 = (ParameterizedType) TypeUtils.getGenericParamType(type);
                Class<?> cls2 = TypeUtils.getClass(parameterizedType2);
                TypeVariable typeVariable2 = (TypeVariable) type2;
                for (int i3 = 0; i3 < cls2.getTypeParameters().length; i3++) {
                    if (cls2.getTypeParameters()[i3].getName().equals(typeVariable2.getName())) {
                        return parameterizedType2.getActualTypeArguments()[i3];
                    }
                }
            }
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType3 = (ParameterizedType) type2;
                Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
                Type[] actualTypeArguments2 = null;
                if (type instanceof ParameterizedType) {
                    parameterizedType = (ParameterizedType) type;
                } else {
                    if (cls.getGenericSuperclass() instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) cls.getGenericSuperclass();
                        cls = cls.getSuperclass();
                    } else {
                        typeParameters = null;
                        parameterizedType = null;
                    }
                    z = false;
                    for (i = 0; i < actualTypeArguments.length && parameterizedType != null; i++) {
                        type3 = actualTypeArguments[i];
                        if (type3 instanceof TypeVariable) {
                            typeVariable = (TypeVariable) type3;
                            for (i2 = 0; i2 < typeParameters.length; i2++) {
                                if (!typeParameters[i2].getName().equals(typeVariable.getName())) {
                                    if (actualTypeArguments2 == null) {
                                        actualTypeArguments2 = parameterizedType.getActualTypeArguments();
                                    }
                                    actualTypeArguments[i] = actualTypeArguments2[i2];
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        return new ParameterizedTypeImpl(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType());
                    }
                }
                typeParameters = cls.getTypeParameters();
                z = false;
                while (i < actualTypeArguments.length) {
                    type3 = actualTypeArguments[i];
                    if (type3 instanceof TypeVariable) {
                        typeVariable = (TypeVariable) type3;
                        while (i2 < typeParameters.length) {
                            if (!typeParameters[i2].getName().equals(typeVariable.getName())) {
                                if (actualTypeArguments2 == null) {
                                    actualTypeArguments2 = parameterizedType.getActualTypeArguments();
                                }
                                actualTypeArguments[i] = actualTypeArguments2[i2];
                                z = true;
                            }
                        }
                    }
                }
                if (z) {
                    return new ParameterizedTypeImpl(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType());
                }
            }
        }
        return type2;
    }

    public static Type getInheritGenericType(Class<?> cls, TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        while (true) {
            Type genericSuperclass = cls.getGenericSuperclass();
            if (genericSuperclass == null) {
                return null;
            }
            if (genericSuperclass instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
                if (parameterizedType.getRawType() == genericDeclaration) {
                    TypeVariable<?>[] typeParameters = genericDeclaration.getTypeParameters();
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    for (int i = 0; i < typeParameters.length; i++) {
                        if (typeParameters[i] == typeVariable) {
                            return actualTypeArguments[i];
                        }
                    }
                    return null;
                }
            }
            cls = TypeUtils.getClass(genericSuperclass);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(FieldInfo fieldInfo) {
        int i = this.ordinal;
        int i2 = fieldInfo.ordinal;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        return this.name.compareTo(fieldInfo.name);
    }

    public boolean equals(FieldInfo fieldInfo) {
        return fieldInfo == this || compareTo(fieldInfo) == 0;
    }

    public Object get(Object obj) {
        return this.fieldAccess ? this.field.get(obj) : this.method.invoke(obj, new Object[0]);
    }

    public JSONField getAnnotation() {
        JSONField jSONField = this.fieldAnnotation;
        return jSONField != null ? jSONField : this.methodAnnotation;
    }

    public void set(Object obj, Object obj2) {
        Method method = this.method;
        if (method != null) {
            method.invoke(obj, obj2);
        } else {
            this.field.set(obj, obj2);
        }
    }

    public String toString() {
        return this.name;
    }
}
