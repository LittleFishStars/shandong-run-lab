package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.i;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
public abstract class Invokable<T, R> implements AnnotatedElement, Member {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccessibleObject f32251a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Member f6439a;

    public static class a<T> extends Invokable<T, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Constructor<?> f32252a;

        public a(Constructor<?> constructor) {
            super(constructor);
            this.f32252a = constructor;
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean B0() {
            return this.f32252a.isVarArgs();
        }

        public final boolean H0() {
            Class<?> declaringClass = this.f32252a.getDeclaringClass();
            if (declaringClass.getEnclosingConstructor() != null) {
                return true;
            }
            Method enclosingMethod = declaringClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                return !Modifier.isStatic(enclosingMethod.getModifiers());
            }
            return (declaringClass.getEnclosingClass() == null || Modifier.isStatic(declaringClass.getModifiers())) ? false : true;
        }

        @Override // com.google.common.reflect.Invokable
        public Type[] e() {
            return this.f32252a.getGenericExceptionTypes();
        }

        @Override // com.google.common.reflect.Invokable
        public final TypeVariable<?>[] getTypeParameters() {
            TypeVariable<Class<? super T>>[] typeParameters = getDeclaringClass().getTypeParameters();
            TypeVariable<Constructor<?>>[] typeParameters2 = this.f32252a.getTypeParameters();
            TypeVariable<?>[] typeVariableArr = new TypeVariable[typeParameters.length + typeParameters2.length];
            System.arraycopy(typeParameters, 0, typeVariableArr, 0, typeParameters.length);
            System.arraycopy(typeParameters2, 0, typeVariableArr, typeParameters.length, typeParameters2.length);
            return typeVariableArr;
        }

        @Override // com.google.common.reflect.Invokable
        public Type[] h0() {
            Type[] genericParameterTypes = this.f32252a.getGenericParameterTypes();
            if (genericParameterTypes.length <= 0 || !H0()) {
                return genericParameterTypes;
            }
            Class<?>[] parameterTypes = this.f32252a.getParameterTypes();
            return (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == getDeclaringClass().getEnclosingClass()) ? (Type[]) Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length) : genericParameterTypes;
        }

        @Override // com.google.common.reflect.Invokable
        public Type i0() {
            Class<? super T> declaringClass = getDeclaringClass();
            TypeVariable<Class<? super T>>[] typeParameters = declaringClass.getTypeParameters();
            return typeParameters.length > 0 ? Types.m(declaringClass, typeParameters) : declaringClass;
        }

        @Override // com.google.common.reflect.Invokable
        public final Annotation[][] k0() {
            return this.f32252a.getParameterAnnotations();
        }

        @Override // com.google.common.reflect.Invokable
        public final Object o0(@CheckForNull Object obj, Object[] objArr) throws IllegalAccessException, InvocationTargetException {
            try {
                return this.f32252a.newInstance(objArr);
            } catch (InstantiationException e) {
                String strValueOf = String.valueOf(this.f32252a);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 8);
                sb.append(strValueOf);
                sb.append(" failed.");
                throw new RuntimeException(sb.toString(), e);
            }
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean t0() {
            return false;
        }
    }

    public static class b<T> extends Invokable<T, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f32253a;

        public b(Method method) {
            super(method);
            this.f32253a = method;
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean B0() {
            return this.f32253a.isVarArgs();
        }

        @Override // com.google.common.reflect.Invokable
        public Type[] e() {
            return this.f32253a.getGenericExceptionTypes();
        }

        @Override // com.google.common.reflect.Invokable
        public final TypeVariable<?>[] getTypeParameters() {
            return this.f32253a.getTypeParameters();
        }

        @Override // com.google.common.reflect.Invokable
        public Type[] h0() {
            return this.f32253a.getGenericParameterTypes();
        }

        @Override // com.google.common.reflect.Invokable
        public Type i0() {
            return this.f32253a.getGenericReturnType();
        }

        @Override // com.google.common.reflect.Invokable
        public final Annotation[][] k0() {
            return this.f32253a.getParameterAnnotations();
        }

        @Override // com.google.common.reflect.Invokable
        @CheckForNull
        public final Object o0(@CheckForNull Object obj, Object[] objArr) throws IllegalAccessException, InvocationTargetException {
            return this.f32253a.invoke(obj, objArr);
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean t0() {
            return (r0() || v0() || y0() || Modifier.isFinal(getDeclaringClass().getModifiers())) ? false : true;
        }
    }

    public <M extends AccessibleObject & Member> Invokable(M m) {
        i.E(m);
        this.f32251a = m;
        this.f6439a = m;
    }

    public static <T> Invokable<T, T> b(Constructor<T> constructor) {
        return new a(constructor);
    }

    public static Invokable<?, Object> c(Method method) {
        return new b(method);
    }

    public final boolean A0() {
        return Modifier.isTransient(getModifiers());
    }

    public abstract boolean B0();

    public final boolean C0() {
        return Modifier.isVolatile(getModifiers());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R1 extends R> Invokable<T, R1> D0(TypeToken<R1> typeToken) {
        if (typeToken.isSupertypeOf(m0())) {
            return this;
        }
        String strValueOf = String.valueOf(m0());
        String strValueOf2 = String.valueOf(typeToken);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 35 + strValueOf2.length());
        sb.append("Invokable is known to return ");
        sb.append(strValueOf);
        sb.append(", not ");
        sb.append(strValueOf2);
        throw new IllegalArgumentException(sb.toString());
    }

    public final <R1 extends R> Invokable<T, R1> E0(Class<R1> cls) {
        return D0(TypeToken.of((Class) cls));
    }

    public final void F0(boolean z) {
        this.f32251a.setAccessible(z);
    }

    public final boolean G0() {
        try {
            this.f32251a.setAccessible(true);
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    public final ImmutableList<TypeToken<? extends Throwable>> d() {
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        for (Type type : e()) {
            aVarBuilder.a(TypeToken.of(type));
        }
        return aVarBuilder.e();
    }

    public abstract Type[] e();

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Invokable)) {
            return false;
        }
        Invokable invokable = (Invokable) obj;
        return j0().equals(invokable.j0()) && this.f6439a.equals(invokable.f6439a);
    }

    @Override // java.lang.reflect.AnnotatedElement
    @CheckForNull
    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        return (A) this.f32251a.getAnnotation(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getAnnotations() {
        return this.f32251a.getAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getDeclaredAnnotations() {
        return this.f32251a.getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.Member
    public final Class<? super T> getDeclaringClass() {
        return (Class<? super T>) this.f6439a.getDeclaringClass();
    }

    @Override // java.lang.reflect.Member
    public final int getModifiers() {
        return this.f6439a.getModifiers();
    }

    @Override // java.lang.reflect.Member
    public final String getName() {
        return this.f6439a.getName();
    }

    public abstract TypeVariable<?>[] getTypeParameters();

    public abstract Type[] h0();

    public int hashCode() {
        return this.f6439a.hashCode();
    }

    public abstract Type i0();

    @Override // java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return this.f32251a.isAnnotationPresent(cls);
    }

    @Override // java.lang.reflect.Member
    public final boolean isSynthetic() {
        return this.f6439a.isSynthetic();
    }

    public TypeToken<T> j0() {
        return TypeToken.of((Class) getDeclaringClass());
    }

    public abstract Annotation[][] k0();

    public final ImmutableList<com.google.common.reflect.b> l0() {
        Type[] typeArrH0 = h0();
        Annotation[][] annotationArrK0 = k0();
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        for (int i = 0; i < typeArrH0.length; i++) {
            aVarBuilder.a(new com.google.common.reflect.b(this, i, TypeToken.of(typeArrH0[i]), annotationArrK0[i]));
        }
        return aVarBuilder.e();
    }

    public final TypeToken<? extends R> m0() {
        return (TypeToken<? extends R>) TypeToken.of(i0());
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public final R n0(@CheckForNull T t, Object... objArr) throws IllegalAccessException, InvocationTargetException {
        return (R) o0(t, (Object[]) i.E(objArr));
    }

    @CheckForNull
    public abstract Object o0(@CheckForNull Object obj, Object[] objArr) throws IllegalAccessException, InvocationTargetException;

    public final boolean p0() {
        return Modifier.isAbstract(getModifiers());
    }

    public final boolean q0() {
        return this.f32251a.isAccessible();
    }

    public final boolean r0() {
        return Modifier.isFinal(getModifiers());
    }

    public final boolean s0() {
        return Modifier.isNative(getModifiers());
    }

    public abstract boolean t0();

    public String toString() {
        return this.f6439a.toString();
    }

    public final boolean u0() {
        return (v0() || x0() || w0()) ? false : true;
    }

    public final boolean v0() {
        return Modifier.isPrivate(getModifiers());
    }

    public final boolean w0() {
        return Modifier.isProtected(getModifiers());
    }

    public final boolean x0() {
        return Modifier.isPublic(getModifiers());
    }

    public final boolean y0() {
        return Modifier.isStatic(getModifiers());
    }

    public final boolean z0() {
        return Modifier.isSynchronized(getModifiers());
    }
}
