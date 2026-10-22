package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements ListMultimap<K, V> {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    @RetainedWith
    @CheckForNull
    @LazyInit
    private transient ImmutableListMultimap<V, K> inverse;

    public static final class a<K, V> extends ImmutableMultimap.c<K, V> {
        @Override // com.google.common.collect.ImmutableMultimap.c
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public ImmutableListMultimap<K, V> a() {
            return (ImmutableListMultimap) super.a();
        }

        @Override // com.google.common.collect.ImmutableMultimap.c
        @CanIgnoreReturnValue
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public a<K, V> b(ImmutableMultimap.c<K, V> cVar) {
            super.b(cVar);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.c
        @CanIgnoreReturnValue
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public a<K, V> d(Comparator<? super K> comparator) {
            super.d(comparator);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.c
        @CanIgnoreReturnValue
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public a<K, V> e(Comparator<? super V> comparator) {
            super.e(comparator);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.c
        @CanIgnoreReturnValue
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public a<K, V> f(K k, V v) {
            super.f(k, v);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.c
        @CanIgnoreReturnValue
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public a<K, V> g(Map.Entry<? extends K, ? extends V> entry) {
            super.g(entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.c
        @CanIgnoreReturnValue
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public a<K, V> h(Multimap<? extends K, ? extends V> multimap) {
            super.h(multimap);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.c
        @CanIgnoreReturnValue
        @Beta
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public a<K, V> i(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.i(iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.c
        @CanIgnoreReturnValue
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public a<K, V> j(K k, Iterable<? extends V> iterable) {
            super.j(k, iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.c
        @CanIgnoreReturnValue
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public a<K, V> k(K k, V... vArr) {
            super.k(k, vArr);
            return this;
        }
    }

    public ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> immutableMap, int i) {
        super(immutableMap, i);
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap) {
        if (multimap.isEmpty()) {
            return of();
        }
        if (multimap instanceof ImmutableListMultimap) {
            ImmutableListMultimap<K, V> immutableListMultimap = (ImmutableListMultimap) multimap;
            if (!immutableListMultimap.isPartialView()) {
                return immutableListMultimap;
            }
        }
        return fromMapEntries(multimap.asMap().entrySet(), null);
    }

    public static <K, V> ImmutableListMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, Comparator<? super V> comparator) {
        if (collection.isEmpty()) {
            return of();
        }
        ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
        int size = 0;
        for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : collection) {
            K key = entry.getKey();
            Collection<? extends V> value = entry.getValue();
            ImmutableList immutableListCopyOf = comparator == null ? ImmutableList.copyOf((Collection) value) : ImmutableList.sortedCopyOf(comparator, value);
            if (!immutableListCopyOf.isEmpty()) {
                bVar.f(key, immutableListCopyOf);
                size += immutableListCopyOf.size();
            }
        }
        return new ImmutableListMultimap<>(bVar.a(), size);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableListMultimap<V, K> invert() {
        a aVarBuilder = builder();
        UnmodifiableIterator it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            aVarBuilder.f(entry.getValue(), entry.getKey());
        }
        ImmutableListMultimap<V, K> immutableListMultimapA = aVarBuilder.a();
        immutableListMultimapA.inverse = this;
        return immutableListMultimapA;
    }

    public static <K, V> ImmutableListMultimap<K, V> of() {
        return EmptyImmutableListMultimap.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = objectInputStream.readInt();
        if (i < 0) {
            StringBuilder sb = new StringBuilder(29);
            sb.append("Invalid key count ");
            sb.append(i);
            throw new InvalidObjectException(sb.toString());
        }
        ImmutableMap.b bVarBuilder = ImmutableMap.builder();
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object object = objectInputStream.readObject();
            int i4 = objectInputStream.readInt();
            if (i4 <= 0) {
                StringBuilder sb2 = new StringBuilder(31);
                sb2.append("Invalid value count ");
                sb2.append(i4);
                throw new InvalidObjectException(sb2.toString());
            }
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            for (int i5 = 0; i5 < i4; i5++) {
                aVarBuilder.a(objectInputStream.readObject());
            }
            bVarBuilder.f(object, aVarBuilder.e());
            i2 += i4;
        }
        try {
            ImmutableMultimap.d.f31732a.b(this, bVarBuilder.a());
            ImmutableMultimap.d.b.a(this, i2);
        } catch (IllegalArgumentException e) {
            throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
        }
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        w.j(this, objectOutputStream);
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v) {
        a aVarBuilder = builder();
        aVarBuilder.f(k, v);
        return aVarBuilder.a();
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableListMultimap<V, K> inverse() {
        ImmutableListMultimap<V, K> immutableListMultimap = this.inverse;
        if (immutableListMultimap != null) {
            return immutableListMultimap;
        }
        ImmutableListMultimap<V, K> immutableListMultimapInvert = invert();
        this.inverse = immutableListMultimapInvert;
        return immutableListMultimapInvert;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public ImmutableList<V> get(K k) {
        ImmutableList<V> immutableList = (ImmutableList) this.map.get(k);
        return immutableList == null ? ImmutableList.of() : immutableList;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final ImmutableList<V> removeAll(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final ImmutableList<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2) {
        a aVarBuilder = builder();
        aVarBuilder.f(k, v);
        aVarBuilder.f(k2, v2);
        return aVarBuilder.a();
    }

    @Beta
    public static <K, V> ImmutableListMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new a().i(iterable).a();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        a aVarBuilder = builder();
        aVarBuilder.f(k, v);
        aVarBuilder.f(k2, v2);
        aVarBuilder.f(k3, v3);
        return aVarBuilder.a();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        a aVarBuilder = builder();
        aVarBuilder.f(k, v);
        aVarBuilder.f(k2, v2);
        aVarBuilder.f(k3, v3);
        aVarBuilder.f(k4, v4);
        return aVarBuilder.a();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        a aVarBuilder = builder();
        aVarBuilder.f(k, v);
        aVarBuilder.f(k2, v2);
        aVarBuilder.f(k3, v3);
        aVarBuilder.f(k4, v4);
        aVarBuilder.f(k5, v5);
        return aVarBuilder.a();
    }
}
