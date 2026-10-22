package com.google.android.gms.internal.mlkit_vision_barcode;

import com.zj.adlib.gkc;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class zzcy extends zzcq implements Set {

    @CheckForNull
    private transient zzcv zza;

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        return gkc.b(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return gkc.a(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcq, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zzd */
    public abstract zzdx iterator();

    public final zzcv zzf() {
        zzcv zzcvVar = this.zza;
        if (zzcvVar != null) {
            return zzcvVar;
        }
        zzcv zzcvVarZzg = zzg();
        this.zza = zzcvVarZzg;
        return zzcvVarZzg;
    }

    public zzcv zzg() {
        Object[] array = toArray();
        int i = zzcv.zzd;
        return zzcv.zzg(array, array.length);
    }
}
