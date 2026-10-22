package com.google.android.odml.image;

import android.media.Image;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@RequiresApi(19)
public final class g implements zzg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Image f31546a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImageProperties f5922a;

    public g(Image image) {
        this.f31546a = image;
        d dVar = new d();
        dVar.b(3);
        int format = image.getFormat();
        dVar.a(format == 42 ? 1 : format == 41 ? 2 : format != 35 ? format != 256 ? 0 : 9 : 7);
        this.f5922a = dVar.c();
    }

    @Override // com.google.android.odml.image.zzg
    public final ImageProperties a() {
        return this.f5922a;
    }

    public final Image b() {
        return this.f31546a;
    }

    @Override // com.google.android.odml.image.zzg
    public final void zzc() {
        this.f31546a.close();
    }
}
