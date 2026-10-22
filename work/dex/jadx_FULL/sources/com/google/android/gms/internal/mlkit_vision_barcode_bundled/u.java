package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.qjc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qjc f31395a = qjc.f19130a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile zzdb f5827a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile zzfo f5828a;

    public final int a() {
        if (this.f5827a != null) {
            return ((zzcy) this.f5827a).zza.length;
        }
        if (this.f5828a != null) {
            return this.f5828a.l();
        }
        return 0;
    }

    public final zzdb b() {
        if (this.f5827a != null) {
            return this.f5827a;
        }
        synchronized (this) {
            if (this.f5827a != null) {
                return this.f5827a;
            }
            if (this.f5828a == null) {
                this.f5827a = zzdb.zzb;
            } else {
                this.f5827a = this.f5828a.b();
            }
            return this.f5827a;
        }
    }

    public final zzfo c(zzfo zzfoVar) {
        zzfo zzfoVar2 = this.f5828a;
        this.f5827a = null;
        this.f5828a = zzfoVar;
        return zzfoVar2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        zzfo zzfoVar = this.f5828a;
        zzfo zzfoVar2 = uVar.f5828a;
        if (zzfoVar == null && zzfoVar2 == null) {
            return b().equals(uVar.b());
        }
        if (zzfoVar != null && zzfoVar2 != null) {
            return zzfoVar.equals(zzfoVar2);
        }
        if (zzfoVar != null) {
            uVar.zzd(zzfoVar.a());
            return zzfoVar.equals(uVar.f5828a);
        }
        zzd(zzfoVar2.a());
        return this.f5828a.equals(zzfoVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final void zzd(zzfo zzfoVar) {
        if (this.f5828a != null) {
            return;
        }
        synchronized (this) {
            if (this.f5828a == null) {
                try {
                    this.f5828a = zzfoVar;
                    this.f5827a = zzdb.zzb;
                } catch (zzeo unused) {
                    this.f5828a = zzfoVar;
                    this.f5827a = zzdb.zzb;
                }
            }
        }
    }
}
