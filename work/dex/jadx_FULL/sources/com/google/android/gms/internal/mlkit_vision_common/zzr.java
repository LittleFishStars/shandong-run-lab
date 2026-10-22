package com.google.android.gms.internal.mlkit_vision_common;

import com.aliyun.vod.common.utils.FileUtils;
import com.zj.adlib.kd6;
import com.zj.adlib.o7c;
import com.zj.adlib.rzc;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class zzr implements Map, Serializable {

    @CheckForNull
    private transient zzs zza;

    @CheckForNull
    private transient zzs zzb;

    @CheckForNull
    private transient zzl zzc;

    public static zzr zzc(Object obj, Object obj2) {
        rzc.a("optional-module-barcode", kd6.f17644b);
        return zzz.zzg(1, new Object[]{"optional-module-barcode", kd6.f17644b}, null);
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(@CheckForNull Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public final boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    @CheckForNull
    public abstract Object get(@CheckForNull Object obj);

    @Override // java.util.Map
    @CheckForNull
    public final Object getOrDefault(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return o7c.a(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        zzs zzsVar = this.zzb;
        if (zzsVar != null) {
            return zzsVar;
        }
        zzs zzsVarZze = zze();
        this.zzb = zzsVarZze;
        return zzsVarZze;
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final Object remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        if (size < 0) {
            throw new IllegalArgumentException("size cannot be negative but was: " + size);
        }
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, FileUtils.ONE_GB));
        sb.append('{');
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append(com.alipay.sdk.m.p.a.h);
            sb.append(entry.getValue());
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }

    public abstract zzl zza();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzl values() {
        zzl zzlVar = this.zzc;
        if (zzlVar != null) {
            return zzlVar;
        }
        zzl zzlVarZza = zza();
        this.zzc = zzlVarZza;
        return zzlVarZza;
    }

    public abstract zzs zzd();

    public abstract zzs zze();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzs entrySet() {
        zzs zzsVar = this.zza;
        if (zzsVar != null) {
            return zzsVar;
        }
        zzs zzsVarZzd = zzd();
        this.zza = zzsVarZzd;
        return zzsVarZzd;
    }
}
