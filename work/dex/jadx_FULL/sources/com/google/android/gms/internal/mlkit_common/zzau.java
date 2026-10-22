package com.google.android.gms.internal.mlkit_common;

import com.aliyun.vod.common.utils.FileUtils;
import com.zj.adlib.b9c;
import com.zj.adlib.ccc;
import com.zj.adlib.kd6;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class zzau implements Map, Serializable {

    @CheckForNull
    private transient zzav zza;

    @CheckForNull
    private transient zzav zzb;

    @CheckForNull
    private transient zzan zzc;

    public static zzau zzc(Object obj, Object obj2) {
        b9c.a("optional-module-barcode", kd6.f17644b);
        return zzbc.zzg(1, new Object[]{"optional-module-barcode", kd6.f17644b}, null);
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
        return ccc.a(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        zzav zzavVar = this.zzb;
        if (zzavVar != null) {
            return zzavVar;
        }
        zzav zzavVarZze = zze();
        this.zzb = zzavVarZze;
        return zzavVarZze;
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

    public abstract zzan zza();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzan values() {
        zzan zzanVar = this.zzc;
        if (zzanVar != null) {
            return zzanVar;
        }
        zzan zzanVarZza = zza();
        this.zzc = zzanVarZza;
        return zzanVarZza;
    }

    public abstract zzav zzd();

    public abstract zzav zze();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzav entrySet() {
        zzav zzavVar = this.zza;
        if (zzavVar != null) {
            return zzavVar;
        }
        zzav zzavVarZzd = zzd();
        this.zza = zzavVarZzd;
        return zzavVarZzd;
    }
}
