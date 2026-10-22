package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.g;
import com.google.common.base.i;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.zj.adlib.dv9;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f32272a;

    public class a extends TypeVisitor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Type f32273a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Map f6454a;

        public a(Map map, Type type) {
            this.f6454a = map;
            this.f32273a = type;
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void b(Class<?> cls) {
            if (this.f32273a instanceof WildcardType) {
                return;
            }
            String strValueOf = String.valueOf(cls);
            String strValueOf2 = String.valueOf(this.f32273a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 25 + strValueOf2.length());
            sb.append("No type mapping from ");
            sb.append(strValueOf);
            sb.append(" to ");
            sb.append(strValueOf2);
            throw new IllegalArgumentException(sb.toString());
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void c(GenericArrayType genericArrayType) {
            Type type = this.f32273a;
            if (type instanceof WildcardType) {
                return;
            }
            Type typeJ = Types.j(type);
            i.u(typeJ != null, "%s is not an array type.", this.f32273a);
            d.g(this.f6454a, genericArrayType.getGenericComponentType(), typeJ);
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void d(ParameterizedType parameterizedType) {
            Type type = this.f32273a;
            if (type instanceof WildcardType) {
                return;
            }
            ParameterizedType parameterizedType2 = (ParameterizedType) d.e(ParameterizedType.class, type);
            if (parameterizedType.getOwnerType() != null && parameterizedType2.getOwnerType() != null) {
                d.g(this.f6454a, parameterizedType.getOwnerType(), parameterizedType2.getOwnerType());
            }
            i.y(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", parameterizedType, this.f32273a);
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
            i.y(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", parameterizedType, parameterizedType2);
            for (int i = 0; i < actualTypeArguments.length; i++) {
                d.g(this.f6454a, actualTypeArguments[i], actualTypeArguments2[i]);
            }
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void e(TypeVariable<?> typeVariable) {
            this.f6454a.put(new C0755d(typeVariable), this.f32273a);
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void f(WildcardType wildcardType) {
            Type type = this.f32273a;
            if (type instanceof WildcardType) {
                WildcardType wildcardType2 = (WildcardType) type;
                Type[] upperBounds = wildcardType.getUpperBounds();
                Type[] upperBounds2 = wildcardType2.getUpperBounds();
                Type[] lowerBounds = wildcardType.getLowerBounds();
                Type[] lowerBounds2 = wildcardType2.getLowerBounds();
                i.y(upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length, "Incompatible type: %s vs. %s", wildcardType, this.f32273a);
                for (int i = 0; i < upperBounds.length; i++) {
                    d.g(this.f6454a, upperBounds[i], upperBounds2[i]);
                }
                for (int i2 = 0; i2 < lowerBounds.length; i2++) {
                    d.g(this.f6454a, lowerBounds[i2], lowerBounds2[i2]);
                }
            }
        }
    }

    public static final class b extends TypeVisitor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<C0755d, Type> f32274a = Maps.Y();

        public static ImmutableMap<C0755d, Type> g(Type type) {
            i.E(type);
            b bVar = new b();
            bVar.a(type);
            return ImmutableMap.copyOf((Map) bVar.f32274a);
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void b(Class<?> cls) {
            a(cls.getGenericSuperclass());
            a(cls.getGenericInterfaces());
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void d(ParameterizedType parameterizedType) {
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            i.g0(typeParameters.length == actualTypeArguments.length);
            for (int i = 0; i < typeParameters.length; i++) {
                h(new C0755d(typeParameters[i]), actualTypeArguments[i]);
            }
            a(cls);
            a(parameterizedType.getOwnerType());
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void e(TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }

        public final void h(C0755d c0755d, Type type) {
            if (this.f32274a.containsKey(c0755d)) {
                return;
            }
            Type type2 = type;
            while (type2 != null) {
                if (c0755d.a(type2)) {
                    while (type != null) {
                        type = this.f32274a.remove(C0755d.c(type));
                    }
                    return;
                }
                type2 = this.f32274a.get(C0755d.c(type2));
            }
            this.f32274a.put(c0755d, type);
        }
    }

    /* JADX INFO: renamed from: com.google.common.reflect.d$d, reason: collision with other inner class name */
    public static final class C0755d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TypeVariable<?> f32277a;

        public C0755d(TypeVariable<?> typeVariable) {
            this.f32277a = (TypeVariable) i.E(typeVariable);
        }

        @CheckForNull
        public static C0755d c(Type type) {
            if (type instanceof TypeVariable) {
                return new C0755d((TypeVariable) type);
            }
            return null;
        }

        public boolean a(Type type) {
            if (type instanceof TypeVariable) {
                return b((TypeVariable) type);
            }
            return false;
        }

        public final boolean b(TypeVariable<?> typeVariable) {
            return this.f32277a.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.f32277a.getName().equals(typeVariable.getName());
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof C0755d) {
                return b(((C0755d) obj).f32277a);
            }
            return false;
        }

        public int hashCode() {
            return g.b(this.f32277a.getGenericDeclaration(), this.f32277a.getName());
        }

        public String toString() {
            return this.f32277a.toString();
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f32278a = new e();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final AtomicInteger f6456a;

        public class a extends e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TypeVariable f32279a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(e eVar, AtomicInteger atomicInteger, TypeVariable typeVariable) {
                super(atomicInteger, null);
                this.f32279a = typeVariable;
            }

            @Override // com.google.common.reflect.d.e
            public TypeVariable<?> b(Type[] typeArr) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(typeArr));
                linkedHashSet.addAll(Arrays.asList(this.f32279a.getBounds()));
                if (linkedHashSet.size() > 1) {
                    linkedHashSet.remove(Object.class);
                }
                return super.b((Type[]) linkedHashSet.toArray(new Type[0]));
            }
        }

        public /* synthetic */ e(AtomicInteger atomicInteger, a aVar) {
            this(atomicInteger);
        }

        public final Type a(Type type) {
            i.E(type);
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return Types.k(e().a(((GenericArrayType) type).getGenericComponentType()));
            }
            if (!(type instanceof ParameterizedType)) {
                if (!(type instanceof WildcardType)) {
                    throw new AssertionError("must have been one of the known types");
                }
                WildcardType wildcardType = (WildcardType) type;
                return wildcardType.getLowerBounds().length == 0 ? b(wildcardType.getUpperBounds()) : type;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable<?>[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (int i = 0; i < actualTypeArguments.length; i++) {
                actualTypeArguments[i] = d(typeParameters[i]).a(actualTypeArguments[i]);
            }
            return Types.n(e().c(parameterizedType.getOwnerType()), cls, actualTypeArguments);
        }

        public TypeVariable<?> b(Type[] typeArr) {
            int iIncrementAndGet = this.f6456a.incrementAndGet();
            String strN = com.google.common.base.d.o(dv9.d).n(typeArr);
            StringBuilder sb = new StringBuilder(String.valueOf(strN).length() + 33);
            sb.append("capture#");
            sb.append(iIncrementAndGet);
            sb.append("-of ? extends ");
            sb.append(strN);
            return Types.l(e.class, sb.toString(), typeArr);
        }

        @CheckForNull
        public final Type c(@CheckForNull Type type) {
            if (type == null) {
                return null;
            }
            return a(type);
        }

        public final e d(TypeVariable<?> typeVariable) {
            return new a(this, this.f6456a, typeVariable);
        }

        public final e e() {
            return new e(this.f6456a);
        }

        public e() {
            this(new AtomicInteger());
        }

        public e(AtomicInteger atomicInteger) {
            this.f6456a = atomicInteger;
        }
    }

    public /* synthetic */ d(c cVar, a aVar) {
        this(cVar);
    }

    public static d d(Type type) {
        return new d().o(b.g(type));
    }

    public static <T> T e(Class<T> cls, Object obj) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            String strValueOf = String.valueOf(obj);
            String simpleName = cls.getSimpleName();
            StringBuilder sb = new StringBuilder(strValueOf.length() + 10 + simpleName.length());
            sb.append(strValueOf);
            sb.append(" is not a ");
            sb.append(simpleName);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static d f(Type type) {
        return new d().o(b.g(e.f32278a.a(type)));
    }

    public static void g(Map<C0755d, Type> map, Type type, Type type2) {
        if (type.equals(type2)) {
            return;
        }
        new a(map, type2).a(type);
    }

    public final Type h(GenericArrayType genericArrayType) {
        return Types.k(j(genericArrayType.getGenericComponentType()));
    }

    public final ParameterizedType i(ParameterizedType parameterizedType) {
        Type ownerType = parameterizedType.getOwnerType();
        return Types.n(ownerType == null ? null : j(ownerType), (Class) j(parameterizedType.getRawType()), k(parameterizedType.getActualTypeArguments()));
    }

    public Type j(Type type) {
        i.E(type);
        if (type instanceof TypeVariable) {
            return this.f32272a.a((TypeVariable) type);
        }
        if (type instanceof ParameterizedType) {
            return i((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return h((GenericArrayType) type);
        }
        return type instanceof WildcardType ? m((WildcardType) type) : type;
    }

    public final Type[] k(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            typeArr2[i] = j(typeArr[i]);
        }
        return typeArr2;
    }

    public Type[] l(Type[] typeArr) {
        for (int i = 0; i < typeArr.length; i++) {
            typeArr[i] = j(typeArr[i]);
        }
        return typeArr;
    }

    public final WildcardType m(WildcardType wildcardType) {
        return new Types.WildcardTypeImpl(k(wildcardType.getLowerBounds()), k(wildcardType.getUpperBounds()));
    }

    public d n(Type type, Type type2) {
        HashMap mapY = Maps.Y();
        g(mapY, (Type) i.E(type), (Type) i.E(type2));
        return o(mapY);
    }

    public d o(Map<C0755d, ? extends Type> map) {
        return new d(this.f32272a.c(map));
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableMap<C0755d, Type> f32275a;

        public class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f32276a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ TypeVariable f6455a;

            public a(c cVar, TypeVariable typeVariable, c cVar2) {
                this.f6455a = typeVariable;
                this.f32276a = cVar2;
            }

            @Override // com.google.common.reflect.d.c
            public Type b(TypeVariable<?> typeVariable, c cVar) {
                return typeVariable.getGenericDeclaration().equals(this.f6455a.getGenericDeclaration()) ? typeVariable : this.f32276a.b(typeVariable, cVar);
            }
        }

        public c() {
            this.f32275a = ImmutableMap.of();
        }

        public final Type a(TypeVariable<?> typeVariable) {
            return b(typeVariable, new a(this, typeVariable, this));
        }

        public Type b(TypeVariable<?> typeVariable, c cVar) {
            Type type = this.f32275a.get(new C0755d(typeVariable));
            a aVar = null;
            if (type != null) {
                return new d(cVar, aVar).j(type);
            }
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length == 0) {
                return typeVariable;
            }
            Type[] typeArrK = new d(cVar, aVar).k(bounds);
            return (Types.c.f32265a && Arrays.equals(bounds, typeArrK)) ? typeVariable : Types.l(typeVariable.getGenericDeclaration(), typeVariable.getName(), typeArrK);
        }

        public final c c(Map<C0755d, ? extends Type> map) {
            ImmutableMap.b bVarBuilder = ImmutableMap.builder();
            bVarBuilder.i(this.f32275a);
            for (Map.Entry<C0755d, ? extends Type> entry : map.entrySet()) {
                C0755d key = entry.getKey();
                Type value = entry.getValue();
                i.u(!key.a(value), "Type variable %s bound to itself", key);
                bVarBuilder.f(key, value);
            }
            return new c(bVarBuilder.a());
        }

        public c(ImmutableMap<C0755d, Type> immutableMap) {
            this.f32275a = immutableMap;
        }
    }

    public d() {
        this.f32272a = new c();
    }

    public d(c cVar) {
        this.f32272a = cVar;
    }
}
