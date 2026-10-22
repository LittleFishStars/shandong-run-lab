package com.google.android.gms.internal.mlkit_vision_barcode;

import com.zj.adlib.ulc;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d0 extends zzec.zza {
    public d0() {
        super(null);
    }

    public /* synthetic */ d0(ulc ulcVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
    public final a0 a(zzec zzecVar, a0 a0Var) {
        a0 a0Var2;
        synchronized (zzecVar) {
            a0Var2 = zzecVar.f5785a;
            if (a0Var2 != a0Var) {
                zzecVar.f5785a = a0Var;
            }
        }
        return a0Var2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
    public final f0 b(zzec zzecVar, f0 f0Var) {
        f0 f0Var2;
        synchronized (zzecVar) {
            f0Var2 = zzecVar.f5786a;
            if (f0Var2 != f0Var) {
                zzecVar.f5786a = f0Var;
            }
        }
        return f0Var2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
    public final void c(f0 f0Var, @CheckForNull f0 f0Var2) {
        f0Var.f31347a = f0Var2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
    public final void d(f0 f0Var, Thread thread) {
        f0Var.f5750a = thread;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
    public final boolean e(zzec zzecVar, @CheckForNull a0 a0Var, a0 a0Var2) {
        synchronized (zzecVar) {
            if (zzecVar.f5785a != a0Var) {
                return false;
            }
            zzecVar.f5785a = a0Var2;
            return true;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
    public final boolean f(zzec zzecVar, @CheckForNull Object obj, Object obj2) {
        synchronized (zzecVar) {
            if (zzecVar.f5787a != obj) {
                return false;
            }
            zzecVar.f5787a = obj2;
            return true;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
    public final boolean g(zzec zzecVar, @CheckForNull f0 f0Var, @CheckForNull f0 f0Var2) {
        synchronized (zzecVar) {
            if (zzecVar.f5786a != f0Var) {
                return false;
            }
            zzecVar.f5786a = f0Var2;
            return true;
        }
    }
}
