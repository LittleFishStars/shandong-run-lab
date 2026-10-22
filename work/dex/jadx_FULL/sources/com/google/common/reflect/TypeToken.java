package com.google.common.reflect;

import com.alibaba.android.arouter.utils.Consts;
import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Predicate;
import com.google.common.base.i;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
public abstract class TypeToken<T> extends TypeCapture<T> implements Serializable {
    private static final long serialVersionUID = 3637540370352322684L;

    @CheckForNull
    private transient com.google.common.reflect.d covariantTypeResolver;

    @CheckForNull
    private transient com.google.common.reflect.d invariantTypeResolver;
    private final Type runtimeType;

    public final class ClassSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;

        @CheckForNull
        private transient ImmutableSet<TypeToken<? super T>> classes;

        private ClassSet() {
            super();
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().classes();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) TypeCollector.b.a().c(TypeToken.this.getRawTypes()));
        }

        public /* synthetic */ ClassSet(TypeToken typeToken, a aVar) {
            this();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.classes;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> immutableSetO = FluentIterable.x(TypeCollector.f32255a.a().d(TypeToken.this)).o(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).O();
            this.classes = immutableSetO;
            return immutableSetO;
        }
    }

    public static final class SimpleTypeToken<T> extends TypeToken<T> {
        private static final long serialVersionUID = 0;

        public SimpleTypeToken(Type type) {
            super(type, null);
        }
    }

    public static abstract class TypeCollector<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final TypeCollector<TypeToken<?>> f32255a = new a();
        public static final TypeCollector<Class<?>> b = new b();

        public class a extends TypeCollector<TypeToken<?>> {
            public a() {
                super(null);
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public Iterable<? extends TypeToken<?>> e(TypeToken<?> typeToken) {
                return typeToken.getGenericInterfaces();
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public Class<?> f(TypeToken<?> typeToken) {
                return typeToken.getRawType();
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            @CheckForNull
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public TypeToken<?> g(TypeToken<?> typeToken) {
                return typeToken.getGenericSuperclass();
            }
        }

        public class b extends TypeCollector<Class<?>> {
            public b() {
                super(null);
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public Iterable<? extends Class<?>> e(Class<?> cls) {
                return Arrays.asList(cls.getInterfaces());
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public Class<?> f(Class<?> cls) {
                return cls;
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            @CheckForNull
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public Class<?> g(Class<?> cls) {
                return cls.getSuperclass();
            }
        }

        public class c extends e<K> {
            public c(TypeCollector typeCollector, TypeCollector typeCollector2) {
                super(typeCollector2);
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            public ImmutableList<K> c(Iterable<? extends K> iterable) {
                ImmutableList.a aVarBuilder = ImmutableList.builder();
                for (K k : iterable) {
                    if (!f(k).isInterface()) {
                        aVarBuilder.a(k);
                    }
                }
                return super.c(aVarBuilder.e());
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector.e, com.google.common.reflect.TypeToken.TypeCollector
            public Iterable<? extends K> e(K k) {
                return ImmutableSet.of();
            }
        }

        public class d extends Ordering<K> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Comparator f32256a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Map f6440a;

            public d(Comparator comparator, Map map) {
                this.f32256a = comparator;
                this.f6440a = map;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Ordering, java.util.Comparator
            public int compare(K k, K k2) {
                Comparator comparator = this.f32256a;
                Object obj = this.f6440a.get(k);
                Objects.requireNonNull(obj);
                Object obj2 = this.f6440a.get(k2);
                Objects.requireNonNull(obj2);
                return comparator.compare(obj, obj2);
            }
        }

        public static class e<K> extends TypeCollector<K> {
            public final TypeCollector<K> c;

            public e(TypeCollector<K> typeCollector) {
                super(null);
                this.c = typeCollector;
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            public Iterable<? extends K> e(K k) {
                return this.c.e(k);
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            public Class<?> f(K k) {
                return this.c.f(k);
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            @CheckForNull
            public K g(K k) {
                return this.c.g(k);
            }
        }

        public TypeCollector() {
        }

        public static <K, V> ImmutableList<K> h(Map<K, V> map, Comparator<? super V> comparator) {
            return (ImmutableList<K>) new d(comparator, map).immutableSortedCopy(map.keySet());
        }

        public final TypeCollector<K> a() {
            return new c(this, this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public final int b(K k, Map<? super K, Integer> map) {
            Integer num = map.get(k);
            if (num != null) {
                return num.intValue();
            }
            boolean zIsInterface = f(k).isInterface();
            Iterator<? extends K> it = e(k).iterator();
            int iMax = zIsInterface;
            while (it.hasNext()) {
                iMax = Math.max(iMax, b(it.next(), map));
            }
            K kG = g(k);
            int iMax2 = iMax;
            if (kG != null) {
                iMax2 = Math.max(iMax, b(kG, map));
            }
            int i = iMax2 + 1;
            map.put(k, Integer.valueOf(i));
            return i;
        }

        public ImmutableList<K> c(Iterable<? extends K> iterable) {
            HashMap mapY = Maps.Y();
            Iterator<? extends K> it = iterable.iterator();
            while (it.hasNext()) {
                b(it.next(), mapY);
            }
            return h(mapY, Ordering.natural().reverse());
        }

        public final ImmutableList<K> d(K k) {
            return c(ImmutableList.of(k));
        }

        public abstract Iterable<? extends K> e(K k);

        public abstract Class<?> f(K k);

        @CheckForNull
        public abstract K g(K k);

        public /* synthetic */ TypeCollector(a aVar) {
            this();
        }
    }

    public enum TypeFilter implements Predicate<TypeToken<?>> {
        IGNORE_TYPE_VARIABLE_OR_WILDCARD { // from class: com.google.common.reflect.TypeToken.TypeFilter.1
            @Override // com.google.common.base.Predicate
            public boolean apply(TypeToken<?> typeToken) {
                return ((((TypeToken) typeToken).runtimeType instanceof TypeVariable) || (((TypeToken) typeToken).runtimeType instanceof WildcardType)) ? false : true;
            }
        },
        INTERFACE_ONLY { // from class: com.google.common.reflect.TypeToken.TypeFilter.2
            @Override // com.google.common.base.Predicate
            public boolean apply(TypeToken<?> typeToken) {
                return typeToken.getRawType().isInterface();
            }
        };

        /* synthetic */ TypeFilter(a aVar) {
            this();
        }
    }

    public class a extends Invokable.b<T> {
        public a(Method method) {
            super(method);
        }

        @Override // com.google.common.reflect.Invokable.b, com.google.common.reflect.Invokable
        public Type[] e() {
            return TypeToken.this.getCovariantTypeResolver().l(super.e());
        }

        @Override // com.google.common.reflect.Invokable.b, com.google.common.reflect.Invokable
        public Type[] h0() {
            return TypeToken.this.getInvariantTypeResolver().l(super.h0());
        }

        @Override // com.google.common.reflect.Invokable.b, com.google.common.reflect.Invokable
        public Type i0() {
            return TypeToken.this.getCovariantTypeResolver().j(super.i0());
        }

        @Override // com.google.common.reflect.Invokable
        public TypeToken<T> j0() {
            return TypeToken.this;
        }

        @Override // com.google.common.reflect.Invokable
        public String toString() {
            String strValueOf = String.valueOf(j0());
            String string = super.toString();
            StringBuilder sb = new StringBuilder(strValueOf.length() + 1 + String.valueOf(string).length());
            sb.append(strValueOf);
            sb.append(Consts.DOT);
            sb.append(string);
            return sb.toString();
        }
    }

    public class b extends Invokable.a<T> {
        public b(Constructor constructor) {
            super(constructor);
        }

        @Override // com.google.common.reflect.Invokable.a, com.google.common.reflect.Invokable
        public Type[] e() {
            return TypeToken.this.getCovariantTypeResolver().l(super.e());
        }

        @Override // com.google.common.reflect.Invokable.a, com.google.common.reflect.Invokable
        public Type[] h0() {
            return TypeToken.this.getInvariantTypeResolver().l(super.h0());
        }

        @Override // com.google.common.reflect.Invokable.a, com.google.common.reflect.Invokable
        public Type i0() {
            return TypeToken.this.getCovariantTypeResolver().j(super.i0());
        }

        @Override // com.google.common.reflect.Invokable
        public TypeToken<T> j0() {
            return TypeToken.this;
        }

        @Override // com.google.common.reflect.Invokable
        public String toString() {
            String strValueOf = String.valueOf(j0());
            String strN = com.google.common.base.d.p(", ").n(h0());
            StringBuilder sb = new StringBuilder(strValueOf.length() + 2 + String.valueOf(strN).length());
            sb.append(strValueOf);
            sb.append("(");
            sb.append(strN);
            sb.append(")");
            return sb.toString();
        }
    }

    public class c extends TypeVisitor {
        public c() {
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void c(GenericArrayType genericArrayType) {
            a(genericArrayType.getGenericComponentType());
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void d(ParameterizedType parameterizedType) {
            a(parameterizedType.getActualTypeArguments());
            a(parameterizedType.getOwnerType());
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void e(TypeVariable<?> typeVariable) {
            String strValueOf = String.valueOf(TypeToken.this.runtimeType);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 58);
            sb.append(strValueOf);
            sb.append("contains a type variable and is not safe for the operation");
            throw new IllegalArgumentException(sb.toString());
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void f(WildcardType wildcardType) {
            a(wildcardType.getLowerBounds());
            a(wildcardType.getUpperBounds());
        }
    }

    public class d extends TypeVisitor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImmutableSet.a f32260a;

        public d(TypeToken typeToken, ImmutableSet.a aVar) {
            this.f32260a = aVar;
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void b(Class<?> cls) {
            this.f32260a.g(cls);
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void c(GenericArrayType genericArrayType) {
            this.f32260a.g(Types.i(TypeToken.of(genericArrayType.getGenericComponentType()).getRawType()));
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void d(ParameterizedType parameterizedType) {
            this.f32260a.g((Class) parameterizedType.getRawType());
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void e(TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // com.google.common.reflect.TypeVisitor
        public void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f32261a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Type[] f6441a;

        public e(Type[] typeArr, boolean z) {
            this.f6441a = typeArr;
            this.f32261a = z;
        }

        public boolean a(Type type) {
            for (Type type2 : this.f6441a) {
                boolean zIsSubtypeOf = TypeToken.of(type2).isSubtypeOf(type);
                boolean z = this.f32261a;
                if (zIsSubtypeOf == z) {
                    return z;
                }
            }
            return !this.f32261a;
        }

        public boolean b(Type type) {
            TypeToken<?> typeTokenOf = TypeToken.of(type);
            for (Type type2 : this.f6441a) {
                boolean zIsSubtypeOf = typeTokenOf.isSubtypeOf(type2);
                boolean z = this.f32261a;
                if (zIsSubtypeOf == z) {
                    return z;
                }
            }
            return !this.f32261a;
        }
    }

    public /* synthetic */ TypeToken(Type type, a aVar) {
        this(type);
    }

    private static e any(Type[] typeArr) {
        return new e(typeArr, true);
    }

    @CheckForNull
    private TypeToken<? super T> boundAsSuperclass(Type type) {
        TypeToken<? super T> typeToken = (TypeToken<? super T>) of(type);
        if (typeToken.getRawType().isInterface()) {
            return null;
        }
        return typeToken;
    }

    private ImmutableList<TypeToken<? super T>> boundsAsInterfaces(Type[] typeArr) {
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        for (Type type : typeArr) {
            TypeToken<?> typeTokenOf = of(type);
            if (typeTokenOf.getRawType().isInterface()) {
                aVarBuilder.a(typeTokenOf);
            }
        }
        return aVarBuilder.e();
    }

    private static Type canonicalizeTypeArg(TypeVariable<?> typeVariable, Type type) {
        return type instanceof WildcardType ? canonicalizeWildcardType(typeVariable, (WildcardType) type) : canonicalizeWildcardsInType(type);
    }

    private static WildcardType canonicalizeWildcardType(TypeVariable<?> typeVariable, WildcardType wildcardType) {
        Type[] bounds = typeVariable.getBounds();
        ArrayList arrayList = new ArrayList();
        for (Type type : wildcardType.getUpperBounds()) {
            if (!any(bounds).a(type)) {
                arrayList.add(canonicalizeWildcardsInType(type));
            }
        }
        return new Types.WildcardTypeImpl(wildcardType.getLowerBounds(), (Type[]) arrayList.toArray(new Type[0]));
    }

    private static ParameterizedType canonicalizeWildcardsInParameterizedType(ParameterizedType parameterizedType) {
        Class cls = (Class) parameterizedType.getRawType();
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i = 0; i < actualTypeArguments.length; i++) {
            actualTypeArguments[i] = canonicalizeTypeArg(typeParameters[i], actualTypeArguments[i]);
        }
        return Types.n(parameterizedType.getOwnerType(), cls, actualTypeArguments);
    }

    private static Type canonicalizeWildcardsInType(Type type) {
        if (type instanceof ParameterizedType) {
            return canonicalizeWildcardsInParameterizedType((ParameterizedType) type);
        }
        return type instanceof GenericArrayType ? Types.k(canonicalizeWildcardsInType(((GenericArrayType) type).getGenericComponentType())) : type;
    }

    private static e every(Type[] typeArr) {
        return new e(typeArr, false);
    }

    private TypeToken<? extends T> getArraySubtype(Class<?> cls) {
        Class<?> componentType = cls.getComponentType();
        if (componentType != null) {
            TypeToken<?> componentType2 = getComponentType();
            Objects.requireNonNull(componentType2);
            return (TypeToken<? extends T>) of(newArrayClassOrGenericArrayType(componentType2.getSubtype(componentType).runtimeType));
        }
        String strValueOf = String.valueOf(cls);
        String strValueOf2 = String.valueOf(this);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 36 + strValueOf2.length());
        sb.append(strValueOf);
        sb.append(" does not appear to be a subtype of ");
        sb.append(strValueOf2);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TypeToken<? super T> getArraySupertype(Class<? super T> cls) {
        TypeToken<?> componentType = getComponentType();
        if (componentType != 0) {
            Class<?> componentType2 = cls.getComponentType();
            Objects.requireNonNull(componentType2);
            return (TypeToken<? super T>) of(newArrayClassOrGenericArrayType(componentType.getSupertype(componentType2).runtimeType));
        }
        String strValueOf = String.valueOf(cls);
        String strValueOf2 = String.valueOf(this);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 23 + strValueOf2.length());
        sb.append(strValueOf);
        sb.append(" isn't a super type of ");
        sb.append(strValueOf2);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.common.reflect.d getCovariantTypeResolver() {
        com.google.common.reflect.d dVar = this.covariantTypeResolver;
        if (dVar != null) {
            return dVar;
        }
        com.google.common.reflect.d dVarD = com.google.common.reflect.d.d(this.runtimeType);
        this.covariantTypeResolver = dVarD;
        return dVarD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.common.reflect.d getInvariantTypeResolver() {
        com.google.common.reflect.d dVar = this.invariantTypeResolver;
        if (dVar != null) {
            return dVar;
        }
        com.google.common.reflect.d dVarF = com.google.common.reflect.d.f(this.runtimeType);
        this.invariantTypeResolver = dVarF;
        return dVarF;
    }

    @CheckForNull
    private Type getOwnerTypeIfPresent() {
        Type type = this.runtimeType;
        if (type instanceof ParameterizedType) {
            return ((ParameterizedType) type).getOwnerType();
        }
        if (type instanceof Class) {
            return ((Class) type).getEnclosingClass();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImmutableSet<Class<? super T>> getRawTypes() {
        ImmutableSet.a aVarBuilder = ImmutableSet.builder();
        new d(this, aVarBuilder).a(this.runtimeType);
        return aVarBuilder.e();
    }

    private TypeToken<? extends T> getSubtypeFromLowerBounds(Class<?> cls, Type[] typeArr) {
        if (typeArr.length > 0) {
            return (TypeToken<? extends T>) of(typeArr[0]).getSubtype(cls);
        }
        String strValueOf = String.valueOf(cls);
        String strValueOf2 = String.valueOf(this);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 21 + strValueOf2.length());
        sb.append(strValueOf);
        sb.append(" isn't a subclass of ");
        sb.append(strValueOf2);
        throw new IllegalArgumentException(sb.toString());
    }

    private TypeToken<? super T> getSupertypeFromUpperBounds(Class<? super T> cls, Type[] typeArr) {
        for (Type type : typeArr) {
            TypeToken<?> typeTokenOf = of(type);
            if (typeTokenOf.isSubtypeOf(cls)) {
                return (TypeToken<? super T>) typeTokenOf.getSupertype(cls);
            }
        }
        String strValueOf = String.valueOf(cls);
        String strValueOf2 = String.valueOf(this);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 23 + strValueOf2.length());
        sb.append(strValueOf);
        sb.append(" isn't a super type of ");
        sb.append(strValueOf2);
        throw new IllegalArgumentException(sb.toString());
    }

    private boolean is(Type type, TypeVariable<?> typeVariable) {
        if (this.runtimeType.equals(type)) {
            return true;
        }
        if (!(type instanceof WildcardType)) {
            return canonicalizeWildcardsInType(this.runtimeType).equals(canonicalizeWildcardsInType(type));
        }
        WildcardType wildcardTypeCanonicalizeWildcardType = canonicalizeWildcardType(typeVariable, (WildcardType) type);
        return every(wildcardTypeCanonicalizeWildcardType.getUpperBounds()).b(this.runtimeType) && every(wildcardTypeCanonicalizeWildcardType.getLowerBounds()).a(this.runtimeType);
    }

    private boolean isOwnedBySubtypeOf(Type type) {
        Iterator<TypeToken<? super T>> it = getTypes().iterator();
        while (it.hasNext()) {
            Type ownerTypeIfPresent = it.next().getOwnerTypeIfPresent();
            if (ownerTypeIfPresent != null && of(ownerTypeIfPresent).isSubtypeOf(type)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSubtypeOfArrayType(GenericArrayType genericArrayType) {
        Type type = this.runtimeType;
        if (!(type instanceof Class)) {
            if (type instanceof GenericArrayType) {
                return of(((GenericArrayType) type).getGenericComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
            }
            return false;
        }
        Class cls = (Class) type;
        if (cls.isArray()) {
            return of((Class) cls.getComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
        }
        return false;
    }

    private boolean isSubtypeOfParameterizedType(ParameterizedType parameterizedType) {
        Class<? super Object> rawType = of(parameterizedType).getRawType();
        if (!someRawTypeIsSubclassOf(rawType)) {
            return false;
        }
        TypeVariable<Class<? super Object>>[] typeParameters = rawType.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i = 0; i < typeParameters.length; i++) {
            if (!of(getCovariantTypeResolver().j(typeParameters[i])).is(actualTypeArguments[i], typeParameters[i])) {
                return false;
            }
        }
        return Modifier.isStatic(((Class) parameterizedType.getRawType()).getModifiers()) || parameterizedType.getOwnerType() == null || isOwnedBySubtypeOf(parameterizedType.getOwnerType());
    }

    private boolean isSupertypeOfArray(GenericArrayType genericArrayType) {
        Type type = this.runtimeType;
        if (type instanceof Class) {
            Class cls = (Class) type;
            return !cls.isArray() ? cls.isAssignableFrom(Object[].class) : of(genericArrayType.getGenericComponentType()).isSubtypeOf(cls.getComponentType());
        }
        if (type instanceof GenericArrayType) {
            return of(genericArrayType.getGenericComponentType()).isSubtypeOf(((GenericArrayType) this.runtimeType).getGenericComponentType());
        }
        return false;
    }

    private boolean isWrapper() {
        return com.google.common.primitives.c.c().contains(this.runtimeType);
    }

    private static Type newArrayClassOrGenericArrayType(Type type) {
        return Types.JavaVersion.JAVA7.newArrayType(type);
    }

    public static <T> TypeToken<T> of(Class<T> cls) {
        return new SimpleTypeToken(cls);
    }

    private TypeToken<?> resolveSupertype(Type type) {
        TypeToken<?> typeTokenOf = of(getCovariantTypeResolver().j(type));
        typeTokenOf.covariantTypeResolver = this.covariantTypeResolver;
        typeTokenOf.invariantTypeResolver = this.invariantTypeResolver;
        return typeTokenOf;
    }

    private Type resolveTypeArgsForSubclass(Class<?> cls) {
        if ((this.runtimeType instanceof Class) && (cls.getTypeParameters().length == 0 || getRawType().getTypeParameters().length != 0)) {
            return cls;
        }
        TypeToken genericType = toGenericType(cls);
        return new com.google.common.reflect.d().n(genericType.getSupertype(getRawType()).runtimeType, this.runtimeType).j(genericType.runtimeType);
    }

    private boolean someRawTypeIsSubclassOf(Class<?> cls) {
        UnmodifiableIterator<Class<? super T>> it = getRawTypes().iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom(it.next())) {
                return true;
            }
        }
        return false;
    }

    @VisibleForTesting
    public static <T> TypeToken<? extends T> toGenericType(Class<T> cls) {
        if (cls.isArray()) {
            return (TypeToken<? extends T>) of(Types.k(toGenericType(cls.getComponentType()).runtimeType));
        }
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type type = (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) ? null : toGenericType(cls.getEnclosingClass()).runtimeType;
        return (typeParameters.length > 0 || !(type == null || type == cls.getEnclosingClass())) ? (TypeToken<? extends T>) of(Types.n(type, cls, typeParameters)) : of((Class) cls);
    }

    public final Invokable<T, T> constructor(Constructor<?> constructor) {
        i.y(constructor.getDeclaringClass() == getRawType(), "%s not declared by %s", constructor, getRawType());
        return new b(constructor);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj instanceof TypeToken) {
            return this.runtimeType.equals(((TypeToken) obj).runtimeType);
        }
        return false;
    }

    @CheckForNull
    public final TypeToken<?> getComponentType() {
        Type typeJ = Types.j(this.runtimeType);
        if (typeJ == null) {
            return null;
        }
        return of(typeJ);
    }

    public final ImmutableList<TypeToken<? super T>> getGenericInterfaces() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return boundsAsInterfaces(((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return boundsAsInterfaces(((WildcardType) type).getUpperBounds());
        }
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        for (Type type2 : getRawType().getGenericInterfaces()) {
            aVarBuilder.a(resolveSupertype(type2));
        }
        return aVarBuilder.e();
    }

    @CheckForNull
    public final TypeToken<? super T> getGenericSuperclass() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return boundAsSuperclass(((TypeVariable) type).getBounds()[0]);
        }
        if (type instanceof WildcardType) {
            return boundAsSuperclass(((WildcardType) type).getUpperBounds()[0]);
        }
        Type genericSuperclass = getRawType().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        return (TypeToken<? super T>) resolveSupertype(genericSuperclass);
    }

    public final Class<? super T> getRawType() {
        return getRawTypes().iterator().next();
    }

    public final TypeToken<? extends T> getSubtype(Class<?> cls) {
        i.u(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        Type type = this.runtimeType;
        if (type instanceof WildcardType) {
            return getSubtypeFromLowerBounds(cls, ((WildcardType) type).getLowerBounds());
        }
        if (isArray()) {
            return getArraySubtype(cls);
        }
        i.y(getRawType().isAssignableFrom(cls), "%s isn't a subclass of %s", cls, this);
        TypeToken<? extends T> typeToken = (TypeToken<? extends T>) of(resolveTypeArgsForSubclass(cls));
        i.y(typeToken.isSubtypeOf((TypeToken<?>) this), "%s does not appear to be a subtype of %s", typeToken, this);
        return typeToken;
    }

    public final TypeToken<? super T> getSupertype(Class<? super T> cls) {
        i.y(someRawTypeIsSubclassOf(cls), "%s is not a super class of %s", cls, this);
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return getSupertypeFromUpperBounds(cls, ((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return getSupertypeFromUpperBounds(cls, ((WildcardType) type).getUpperBounds());
        }
        return cls.isArray() ? getArraySupertype(cls) : (TypeToken<? super T>) resolveSupertype(toGenericType(cls).runtimeType);
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final TypeToken<T>.TypeSet getTypes() {
        return new TypeSet();
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public final boolean isArray() {
        return getComponentType() != null;
    }

    public final boolean isPrimitive() {
        Type type = this.runtimeType;
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }

    public final boolean isSubtypeOf(TypeToken<?> typeToken) {
        return isSubtypeOf(typeToken.getType());
    }

    public final boolean isSupertypeOf(TypeToken<?> typeToken) {
        return typeToken.isSubtypeOf(getType());
    }

    public final Invokable<T, Object> method(Method method) {
        i.y(someRawTypeIsSubclassOf(method.getDeclaringClass()), "%s not declared by %s", method, this);
        return new a(method);
    }

    @CanIgnoreReturnValue
    public final TypeToken<T> rejectTypeVariables() {
        new c().a(this.runtimeType);
        return this;
    }

    public final TypeToken<?> resolveType(Type type) {
        i.E(type);
        return of(getInvariantTypeResolver().j(type));
    }

    public String toString() {
        return Types.t(this.runtimeType);
    }

    public final TypeToken<T> unwrap() {
        return isWrapper() ? of(com.google.common.primitives.c.e((Class) this.runtimeType)) : this;
    }

    public final <X> TypeToken<T> where(TypeParameter<X> typeParameter, TypeToken<X> typeToken) {
        return new SimpleTypeToken(new com.google.common.reflect.d().o(ImmutableMap.of(new com.google.common.reflect.d.C0755d(typeParameter.f32254a), typeToken.runtimeType)).j(this.runtimeType));
    }

    public final TypeToken<T> wrap() {
        return isPrimitive() ? of(com.google.common.primitives.c.f((Class) this.runtimeType)) : this;
    }

    public Object writeReplace() {
        return of(new com.google.common.reflect.d().j(this.runtimeType));
    }

    public final class InterfaceSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;
        private final transient TypeToken<T>.TypeSet allTypes;

        @CheckForNull
        private transient ImmutableSet<TypeToken<? super T>> interfaces;

        public class a implements Predicate<Class<?>> {
            public a(InterfaceSet interfaceSet) {
            }

            @Override // com.google.common.base.Predicate
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean apply(Class<?> cls) {
                return cls.isInterface();
            }
        }

        public InterfaceSet(TypeToken<T>.TypeSet typeSet) {
            super();
            this.allTypes = typeSet;
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().interfaces();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return FluentIterable.x(TypeCollector.b.c(TypeToken.this.getRawTypes())).o(new a(this)).O();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.interfaces;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> immutableSetO = FluentIterable.x(this.allTypes).o(TypeFilter.INTERFACE_ONLY).O();
            this.interfaces = immutableSetO;
            return immutableSetO;
        }
    }

    public class TypeSet extends ForwardingSet<TypeToken<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;

        @CheckForNull
        private transient ImmutableSet<TypeToken<? super T>> types;

        public TypeSet() {
        }

        public TypeToken<T>.TypeSet classes() {
            return new ClassSet(TypeToken.this, null);
        }

        public TypeToken<T>.TypeSet interfaces() {
            return new InterfaceSet(this);
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) TypeCollector.b.c(TypeToken.this.getRawTypes()));
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.types;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> immutableSetO = FluentIterable.x(TypeCollector.f32255a.d(TypeToken.this)).o(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).O();
            this.types = immutableSetO;
            return immutableSetO;
        }
    }

    public TypeToken() {
        Type typeCapture = capture();
        this.runtimeType = typeCapture;
        i.x0(!(typeCapture instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", typeCapture);
    }

    public static TypeToken<?> of(Type type) {
        return new SimpleTypeToken(type);
    }

    public final boolean isSubtypeOf(Type type) {
        i.E(type);
        if (type instanceof WildcardType) {
            return any(((WildcardType) type).getLowerBounds()).b(this.runtimeType);
        }
        Type type2 = this.runtimeType;
        if (type2 instanceof WildcardType) {
            return any(((WildcardType) type2).getUpperBounds()).a(type);
        }
        if (type2 instanceof TypeVariable) {
            return type2.equals(type) || any(((TypeVariable) this.runtimeType).getBounds()).a(type);
        }
        if (type2 instanceof GenericArrayType) {
            return of(type).isSupertypeOfArray((GenericArrayType) this.runtimeType);
        }
        if (type instanceof Class) {
            return someRawTypeIsSubclassOf((Class) type);
        }
        if (type instanceof ParameterizedType) {
            return isSubtypeOfParameterizedType((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return isSubtypeOfArrayType((GenericArrayType) type);
        }
        return false;
    }

    public final boolean isSupertypeOf(Type type) {
        return of(type).isSubtypeOf(getType());
    }

    public TypeToken(Class<?> cls) {
        Type typeCapture = super.capture();
        if (typeCapture instanceof Class) {
            this.runtimeType = typeCapture;
        } else {
            this.runtimeType = com.google.common.reflect.d.d(cls).j(typeCapture);
        }
    }

    public final <X> TypeToken<T> where(TypeParameter<X> typeParameter, Class<X> cls) {
        return where(typeParameter, of((Class) cls));
    }

    private TypeToken(Type type) {
        this.runtimeType = (Type) i.E(type);
    }
}
