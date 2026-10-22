package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.mlkit_vision_common.zzai;
import com.google.android.gms.internal.mlkit_vision_common.zziv;
import com.google.firebase.encoders.annotations.Encodable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Encodable
public final class i3d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zziv f42271a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final cbd f17136a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final f2d f17137a;

    public /* synthetic */ i3d(a3d a3dVar, e3d e3dVar) {
        this.f17136a = a3dVar.f15149a;
        this.f42271a = a3dVar.f40447a;
        this.f17137a = a3dVar.f15150a;
    }

    @Nullable
    @zzai(zza = 50)
    public final f2d a() {
        return this.f17137a;
    }

    @Nullable
    @zzai(zza = 2)
    public final zziv b() {
        return this.f42271a;
    }

    @Nullable
    @zzai(zza = 1)
    public final cbd c() {
        return this.f17136a;
    }
}
