package com.google.android.gms.internal.mlkit_common;

import com.zj.adlib.ccc;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class zzav extends zzan implements Set {

    @CheckForNull
    private transient zzar zza;

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size() && containsAll(set)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return ccc.a(this);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzan, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zzd */
    public abstract zzbe iterator();

    public final zzar zzf() {
        zzar zzarVar = this.zza;
        if (zzarVar != null) {
            return zzarVar;
        }
        zzar zzarVarZzg = zzg();
        this.zza = zzarVarZzg;
        return zzarVarZzg;
    }

    public zzar zzg() {
        Object[] array = toArray();
        int i = zzar.zzd;
        return zzar.zzg(array, array.length);
    }
}
