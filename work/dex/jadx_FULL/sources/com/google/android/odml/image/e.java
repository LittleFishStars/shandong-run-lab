package com.google.android.odml.image;

import android.graphics.Bitmap;
import com.zj.adlib.yhc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class e implements zzg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f31544a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImageProperties f5920a;

    public e(Bitmap bitmap) {
        this.f31544a = bitmap;
        d dVar = new d();
        int i = yhc.f46033a[bitmap.getConfig().ordinal()];
        dVar.a(i != 1 ? i != 2 ? 0 : 1 : 8);
        dVar.b(1);
        this.f5920a = dVar.c();
    }

    @Override // com.google.android.odml.image.zzg
    public final ImageProperties a() {
        return this.f5920a;
    }

    public final Bitmap b() {
        return this.f31544a;
    }

    @Override // com.google.android.odml.image.zzg
    public final void zzc() {
        this.f31544a.recycle();
    }
}
