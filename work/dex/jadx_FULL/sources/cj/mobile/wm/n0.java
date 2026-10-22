package cj.mobile.wm;

import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class n0 implements Comparable<n0> {
    public final String dexa;
    public final Method dexb;
    public final Field dexc;
    public final boolean dexd;
    public final boolean dexe;
    public int dexf;
    public final Class<?> dexg;
    public final Type dexh;
    public final Class<?> dexi;
    public final boolean dexj;
    public final dex08 dexk;
    public final dex08 dexl;
    public final boolean dexm;
    public final String dexn;
    public final long dexo;
    public final String[] dexp;
    public final int dexq;

    public n0(String str, Class<?> cls, Class<?> cls2, Type type, Field field, int i, int i2) {
        this.dexf = 0;
        i = i < 0 ? 0 : i;
        this.dexa = str;
        this.dexi = cls;
        this.dexg = cls2;
        this.dexh = type;
        this.dexb = null;
        this.dexc = field;
        this.dexf = i;
        this.dexq = i2;
        this.dexm = cls2.isEnum() && !dex05.class.isAssignableFrom(cls2);
        this.dexk = null;
        this.dexl = null;
        if (field != null) {
            int modifiers = field.getModifiers();
            this.dexd = true;
            this.dexe = Modifier.isTransient(modifiers);
        } else {
            this.dexd = false;
            this.dexe = false;
        }
        this.dexj = false;
        long jCharAt = TypeUtils.fnv1a_64_magic_hashcode;
        for (int i3 = 0; i3 < str.length(); i3++) {
            jCharAt = (jCharAt ^ ((long) str.charAt(i3))) * TypeUtils.fnv1a_64_magic_prime;
        }
        this.dexo = jCharAt;
        this.dexn = null;
        this.dexp = new String[0];
    }

    public n0(String str, Method method, Field field, Class<?> cls, Type type, int i, int i2, dex08 dex08Var, dex08 dex08Var2, boolean z) {
        String str2;
        Type genericType;
        Class<?> clsDexa;
        boolean z2 = false;
        this.dexf = 0;
        i = i < 0 ? 0 : i;
        this.dexa = str;
        this.dexb = method;
        this.dexc = field;
        this.dexf = i;
        this.dexl = dex08Var;
        this.dexk = dex08Var2;
        this.dexq = i2;
        dex08 dex08VarDexa = dexa();
        Type type2 = null;
        if (dex08VarDexa != null) {
            str2 = dex08VarDexa.format();
            str2 = str2.trim().length() == 0 ? null : str2;
            this.dexp = dex08VarDexa.alternateNames();
        } else {
            this.dexp = new String[0];
            str2 = null;
        }
        this.dexn = str2;
        if (field != null) {
            int modifiers = field.getModifiers();
            this.dexd = method == null || ((modifiers & 1) != 0 && method.getReturnType() == field.getType());
            this.dexe = (modifiers & 128) != 0;
        } else {
            this.dexd = false;
            this.dexe = false;
        }
        long jCharAt = TypeUtils.fnv1a_64_magic_hashcode;
        for (int i3 = 0; i3 < str.length(); i3++) {
            jCharAt = (jCharAt ^ ((long) str.charAt(i3))) * TypeUtils.fnv1a_64_magic_prime;
        }
        this.dexo = jCharAt;
        if (method != null) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1) {
                clsDexa = parameterTypes[0];
                genericType = (clsDexa == Class.class || clsDexa == String.class || clsDexa.isPrimitive() || !z) ? clsDexa : method.getGenericParameterTypes()[0];
                this.dexj = false;
            } else {
                clsDexa = method.getReturnType();
                genericType = (clsDexa != Class.class && z) ? method.getGenericReturnType() : clsDexa;
                this.dexj = true;
            }
            this.dexi = method.getDeclaringClass();
        } else {
            Class<?> type3 = field.getType();
            genericType = (type3.isPrimitive() || type3 == String.class || type3.isEnum() || !z) ? type3 : field.getGenericType();
            this.dexi = field.getDeclaringClass();
            this.dexj = Modifier.isFinal(field.getModifiers());
            clsDexa = type3;
        }
        if (cls != null && clsDexa == Object.class && (genericType instanceof TypeVariable)) {
            TypeVariable typeVariable = (TypeVariable) genericType;
            Type[] actualTypeArguments = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments() : null;
            for (Class<?> superclass = cls; superclass != null && superclass != Object.class && superclass != this.dexi; superclass = superclass.getSuperclass()) {
                Type genericSuperclass = superclass.getGenericSuperclass();
                if (genericSuperclass instanceof ParameterizedType) {
                    Type[] actualTypeArguments2 = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                    q0.dexa(actualTypeArguments2, superclass.getTypeParameters(), actualTypeArguments);
                    actualTypeArguments = actualTypeArguments2;
                }
            }
            if (actualTypeArguments != null) {
                TypeVariable<Class<?>>[] typeParameters = this.dexi.getTypeParameters();
                for (int i4 = 0; i4 < typeParameters.length; i4++) {
                    if (typeVariable.equals(typeParameters[i4])) {
                        type2 = actualTypeArguments[i4];
                        break;
                    }
                }
            }
            if (type2 != null) {
                this.dexg = q0.dexa(type2);
                this.dexh = type2;
                if (clsDexa.isEnum() && !dex05.class.isAssignableFrom(clsDexa)) {
                    z2 = true;
                }
                this.dexm = z2;
                return;
            }
        }
        if (!(genericType instanceof Class)) {
            Type typeDexa = dexa(cls, type == null ? cls : type, genericType);
            if (typeDexa != genericType && ((typeDexa instanceof ParameterizedType) || (typeDexa instanceof Class))) {
                clsDexa = q0.dexa(typeDexa);
            }
            genericType = typeDexa;
        }
        this.dexh = genericType;
        this.dexg = clsDexa;
        if (!clsDexa.isArray() && clsDexa.isEnum() && !dex05.class.isAssignableFrom(clsDexa)) {
            z2 = true;
        }
        this.dexm = z2;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x009d  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:52:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00be A[SYNTHETIC] */
    public static Type dexa(Class<?> cls, Type type, Type type2) {
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
                Type typeDexa = dexa(cls, type, genericComponentType);
                return genericComponentType != typeDexa ? Array.newInstance(q0.dexa(typeDexa), 0).getClass() : type2;
            }
            if (!q0.dexd(type)) {
                return type2;
            }
            if (type2 instanceof TypeVariable) {
                ParameterizedType parameterizedType2 = (ParameterizedType) q0.dexc(type);
                Class<?> clsDexa = q0.dexa((Type) parameterizedType2);
                TypeVariable typeVariable2 = (TypeVariable) type2;
                for (int i3 = 0; i3 < clsDexa.getTypeParameters().length; i3++) {
                    if (clsDexa.getTypeParameters()[i3].getName().equals(typeVariable2.getName())) {
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
                        return new p0(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType());
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
                    return new p0(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType());
                }
            }
        }
        return type2;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: dexa, reason: merged with bridge method [inline-methods] */
    public int compareTo(n0 n0Var) {
        int i = this.dexf;
        int i2 = n0Var.dexf;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        return this.dexa.compareTo(n0Var.dexa);
    }

    public dex08 dexa() {
        dex08 dex08Var = this.dexk;
        return dex08Var != null ? dex08Var : this.dexl;
    }

    public Object dexa(Object obj) {
        return this.dexd ? this.dexc.get(obj) : this.dexb.invoke(obj, new Object[0]);
    }

    public void dexa(Object obj, Object obj2) {
        Method method = this.dexb;
        if (method != null) {
            method.invoke(obj, obj2);
        } else {
            this.dexc.set(obj, obj2);
        }
    }

    public boolean dexb(n0 n0Var) {
        return n0Var == this || compareTo(n0Var) == 0;
    }

    public String toString() {
        return this.dexa;
    }
}
