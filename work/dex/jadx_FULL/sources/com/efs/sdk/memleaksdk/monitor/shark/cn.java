package com.efs.sdk.memleaksdk.monitor.shark;

import com.acse.ottn.p3;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u0004\u0018\u00018\u00012\b\u0010\u0019\u001a\u0004\u0018\u00018\u0000H\u0086\u0002¢\u0006\u0002\u0010\u001aJ\u001d\u0010\u001b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00028\u0001¢\u0006\u0002\u0010\u001dJ\u0015\u0010\u001e\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0002\u0010\u001aJ\b\u0010\u001f\u001a\u00020 H\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u001e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u0011\u0010\u0014\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\f¨\u0006!"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/LruCache;", "K", "V", "", "maxSize", "", "(I)V", "cache", "Ljava/util/LinkedHashMap;", "<set-?>", "evictionCount", "getEvictionCount", "()I", "hitCount", "getHitCount", "getMaxSize", "missCount", "getMissCount", "putCount", "getPutCount", "size", "getSize", "evictAll", "", p3.f, CachedContentIndex.a.e, "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class cn<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f29837a;
    final int b;
    private final LinkedHashMap<K, V> c;
    private int d;
    private int e;
    private int f;

    public cn(int i) {
        this.b = i;
        boolean z = true;
        if (i > 0) {
            this.c = new LinkedHashMap<K, V>(i, 0.75f, z) { // from class: com.efs.sdk.memleaksdk.monitor.internal.cn.1
                public Set a() {
                    return super.entrySet();
                }

                public Set b() {
                    return super.keySet();
                }

                public Collection c() {
                    return super.values();
                }

                public int d() {
                    return super.size();
                }

                @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final Set<Map.Entry<K, V>> entrySet() {
                    return a();
                }

                @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final Set<K> keySet() {
                    return b();
                }

                @Override // java.util.LinkedHashMap
                public boolean removeEldestEntry(@Nullable Map.Entry<K, V> eldest) {
                    int size = size();
                    cn cnVar = cn.this;
                    if (size <= cnVar.b) {
                        return false;
                    }
                    cnVar.f29837a++;
                    return true;
                }

                @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final int size() {
                    return d();
                }

                @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
                public final Collection<V> values() {
                    return c();
                }
            };
            return;
        }
        throw new IllegalArgumentException(("maxSize=" + i + " <= 0").toString());
    }

    @Nullable
    public final V a(@Nullable K k) {
        V v = this.c.get(k);
        if (v != null) {
            this.e++;
            return v;
        }
        this.f++;
        return null;
    }

    @NotNull
    public String toString() {
        int i = this.e;
        int i2 = this.f + i;
        int i3 = i2 != 0 ? (i * 100) / i2 : 0;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Arrays.copyOf(new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(i3)}, 4));
        Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
        return str;
    }

    @Nullable
    public final V a(K k, V v) {
        this.d++;
        return this.c.put(k, v);
    }
}
