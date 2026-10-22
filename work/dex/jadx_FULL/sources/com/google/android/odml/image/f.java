package com.google.android.odml.image;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class f implements zzg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageProperties f31545a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ByteBuffer f5921a;

    public f(ByteBuffer byteBuffer, int i) {
        this.f5921a = byteBuffer;
        d dVar = new d();
        dVar.b(2);
        dVar.a(i);
        this.f31545a = dVar.c();
    }

    @Override // com.google.android.odml.image.zzg
    public final ImageProperties a() {
        return this.f31545a;
    }

    public final ByteBuffer b() {
        return this.f5921a;
    }

    @Override // com.google.android.odml.image.zzg
    public final void zzc() {
    }
}
