package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.cache.ContentMetadata;
import com.google.common.base.b;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ef2 implements ContentMetadata {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ef2 f41422a = new ef2(Collections.emptyMap());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f16303a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<String, byte[]> f16304a;

    public ef2() {
        this(Collections.emptyMap());
    }

    public static void c(HashMap<String, byte[]> map, Map<String, Object> map2) {
        for (Map.Entry<String, Object> entry : map2.entrySet()) {
            map.put(entry.getKey(), g(entry.getValue()));
        }
    }

    public static Map<String, byte[]> d(Map<String, byte[]> map, wu1 wu1Var) {
        HashMap map2 = new HashMap(map);
        i(map2, wu1Var.c());
        c(map2, wu1Var.b());
        return map2;
    }

    public static byte[] g(Object obj) {
        if (obj instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes(b.c);
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new IllegalArgumentException();
    }

    public static boolean h(Map<String, byte[]> map, Map<String, byte[]> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            if (!Arrays.equals(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public static void i(HashMap<String, byte[]> map, List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            map.remove(list.get(i));
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.ContentMetadata
    public final boolean contains(String str) {
        return this.f16304a.containsKey(str);
    }

    public ef2 e(wu1 wu1Var) {
        Map<String, byte[]> mapD = d(this.f16304a, wu1Var);
        return h(this.f16304a, mapD) ? this : new ef2(mapD);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ef2.class != obj.getClass()) {
            return false;
        }
        return h(this.f16304a, ((ef2) obj).f16304a);
    }

    public Set<Map.Entry<String, byte[]>> f() {
        return this.f16304a.entrySet();
    }

    @Override // com.google.android.exoplayer2.upstream.cache.ContentMetadata
    @Nullable
    public final byte[] get(String str, @Nullable byte[] bArr) {
        byte[] bArr2 = this.f16304a.get(str);
        return bArr2 != null ? Arrays.copyOf(bArr2, bArr2.length) : bArr;
    }

    public int hashCode() {
        if (this.f16303a == 0) {
            int iHashCode = 0;
            for (Map.Entry<String, byte[]> entry : this.f16304a.entrySet()) {
                iHashCode += Arrays.hashCode(entry.getValue()) ^ entry.getKey().hashCode();
            }
            this.f16303a = iHashCode;
        }
        return this.f16303a;
    }

    public ef2(Map<String, byte[]> map) {
        this.f16304a = Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.ContentMetadata
    @Nullable
    public final String get(String str, @Nullable String str2) {
        byte[] bArr = this.f16304a.get(str);
        return bArr != null ? new String(bArr, b.c) : str2;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.ContentMetadata
    public final long get(String str, long j) {
        byte[] bArr = this.f16304a.get(str);
        return bArr != null ? ByteBuffer.wrap(bArr).getLong() : j;
    }
}
