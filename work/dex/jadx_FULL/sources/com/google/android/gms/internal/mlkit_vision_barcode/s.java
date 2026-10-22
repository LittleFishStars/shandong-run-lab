package com.google.android.gms.internal.mlkit_vision_barcode;

import com.zj.adlib.wac;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class s extends zzbv {
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcl f31357a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f5774a;

    public s(zzcl zzclVar, int i) {
        this.f31357a = zzclVar;
        Object[] objArr = zzclVar.zzb;
        objArr.getClass();
        this.f5774a = objArr[i];
        this.K = i;
    }

    public final void a() {
        int i = this.K;
        if (i != -1 && i < this.f31357a.size()) {
            Object obj = this.f5774a;
            zzcl zzclVar = this.f31357a;
            int i2 = this.K;
            Object[] objArr = zzclVar.zzb;
            objArr.getClass();
            if (wac.a(obj, objArr[i2])) {
                return;
            }
        }
        this.K = this.f31357a.zzq(this.f5774a);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzbv, java.util.Map.Entry
    public final Object getKey() {
        return this.f5774a;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzbv, java.util.Map.Entry
    public final Object getValue() {
        Map mapZzj = this.f31357a.zzj();
        if (mapZzj != null) {
            return mapZzj.get(this.f5774a);
        }
        a();
        int i = this.K;
        if (i == -1) {
            return null;
        }
        Object[] objArr = this.f31357a.zzc;
        objArr.getClass();
        return objArr[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzbv, java.util.Map.Entry
    public final Object setValue(Object obj) {
        Map mapZzj = this.f31357a.zzj();
        if (mapZzj != null) {
            return mapZzj.put(this.f5774a, obj);
        }
        a();
        int i = this.K;
        if (i == -1) {
            this.f31357a.put(this.f5774a, obj);
            return null;
        }
        Object[] objArr = this.f31357a.zzc;
        objArr.getClass();
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }
}
