package com.zj.adlib;

import com.android.internal.util.Predicate;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.cache.ValueDescriptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ThreadSafe
public class gw1<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ValueDescriptor<V> f16890a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("this")
    public final LinkedHashMap<K, V> f16891a = new LinkedHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    public int f42000a = 0;

    public gw1(ValueDescriptor<V> valueDescriptor) {
        this.f16890a = valueDescriptor;
    }

    public synchronized ArrayList<V> a() {
        ArrayList<V> arrayList;
        arrayList = new ArrayList<>((Collection<? extends V>) this.f16891a.values());
        this.f16891a.clear();
        this.f42000a = 0;
        return arrayList;
    }

    public synchronized boolean b(K k) {
        return this.f16891a.containsKey(k);
    }

    @Nullable
    public synchronized V c(K k) {
        return this.f16891a.get(k);
    }

    public synchronized int d() {
        return this.f16891a.size();
    }

    @Nullable
    public synchronized K e() {
        return this.f16891a.isEmpty() ? null : this.f16891a.keySet().iterator().next();
    }

    @VisibleForTesting
    public synchronized ArrayList<K> f() {
        return new ArrayList<>(this.f16891a.keySet());
    }

    public synchronized ArrayList<Map.Entry<K, V>> g(@Nullable Predicate<K> predicate) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>();
        for (Map.Entry<K, V> entry : this.f16891a.entrySet()) {
            if (predicate == null || predicate.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized int h() {
        return this.f42000a;
    }

    public final int i(V v) {
        if (v == null) {
            return 0;
        }
        return this.f16890a.a(v);
    }

    @VisibleForTesting
    public synchronized ArrayList<V> j() {
        return new ArrayList<>(this.f16891a.values());
    }

    @Nullable
    public synchronized V k(K k, V v) {
        V vRemove;
        vRemove = this.f16891a.remove(k);
        this.f42000a -= i(vRemove);
        this.f16891a.put(k, v);
        this.f42000a += i(v);
        return vRemove;
    }

    @Nullable
    public synchronized V l(K k) {
        V vRemove;
        vRemove = this.f16891a.remove(k);
        this.f42000a -= i(vRemove);
        return vRemove;
    }

    public synchronized ArrayList<V> m(@Nullable Predicate<K> predicate) {
        ArrayList<V> arrayList;
        arrayList = new ArrayList<>();
        Iterator<Map.Entry<K, V>> it = this.f16891a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (predicate == null || predicate.apply(next.getKey())) {
                arrayList.add(next.getValue());
                this.f42000a -= i(next.getValue());
                it.remove();
            }
        }
        return arrayList;
    }
}
