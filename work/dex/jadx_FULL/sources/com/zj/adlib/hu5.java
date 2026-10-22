package com.zj.adlib;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.i;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToInstanceMap;
import com.google.common.reflect.TypeToken;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
public final class hu5<B> extends ForwardingMap<TypeToken<? extends B>, B> implements TypeToInstanceMap<B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<TypeToken<? extends B>, B> f42206a = Maps.Y();

    public static final class b<K, V> extends ForwardingMapEntry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map.Entry<K, V> f42207a;

        public class a extends ForwardingSet<Map.Entry<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Set f42208a;

            public a(Set set) {
                this.f42208a = set;
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return b.d(super.iterator());
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
            public Object[] toArray() {
                return standardToArray();
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
            public <T> T[] toArray(T[] tArr) {
                return (T[]) standardToArray(tArr);
            }

            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
            public Set<Map.Entry<K, V>> delegate() {
                return this.f42208a;
            }
        }

        /* JADX INFO: renamed from: com.zj.adlib.hu5$b$b, reason: collision with other inner class name */
        public class C1329b implements Function<Map.Entry<K, V>, Map.Entry<K, V>> {
            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> apply(Map.Entry<K, V> entry) {
                return new b(entry);
            }
        }

        public static <K, V> Iterator<Map.Entry<K, V>> d(Iterator<Map.Entry<K, V>> it) {
            return Iterators.c0(it, new C1329b());
        }

        public static <K, V> Set<Map.Entry<K, V>> e(Set<Map.Entry<K, V>> set) {
            return new a(set);
        }

        @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException();
        }

        public b(Map.Entry<K, V> entry) {
            this.f42207a = (Map.Entry) i.E(entry);
        }

        @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
        public Map.Entry<K, V> delegate() {
            return this.f42207a;
        }
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @NullableDecl
    public <T extends B> T a(TypeToken<T> typeToken) {
        return (T) d(typeToken.rejectTypeVariables());
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public B put(TypeToken<? extends B> typeToken, B b2) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @NullableDecl
    public final <T extends B> T d(TypeToken<T> typeToken) {
        return this.f42206a.get(typeToken);
    }

    @NullableDecl
    public final <T extends B> T e(TypeToken<T> typeToken, @NullableDecl T t) {
        return this.f42206a.put(typeToken, t);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set<Map.Entry<TypeToken<? extends B>, B>> entrySet() {
        return b.e(super.entrySet());
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @NullableDecl
    public <T extends B> T getInstance(Class<T> cls) {
        return (T) d(TypeToken.of((Class) cls));
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @CanIgnoreReturnValue
    @NullableDecl
    public <T extends B> T k0(TypeToken<T> typeToken, @NullableDecl T t) {
        return (T) e(typeToken.rejectTypeVariables(), t);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> map) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @CanIgnoreReturnValue
    @NullableDecl
    public <T extends B> T putInstance(Class<T> cls, @NullableDecl T t) {
        return (T) e(TypeToken.of((Class) cls), t);
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<TypeToken<? extends B>, B> delegate() {
        return this.f42206a;
    }
}
