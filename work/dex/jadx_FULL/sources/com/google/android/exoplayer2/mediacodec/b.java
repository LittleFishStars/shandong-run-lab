package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.bp5;
import com.zj.adlib.gj9;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b implements MediaCodecAdapter.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30770a = "DMCodecAdapterFactory";
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f3460a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3461a;

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter.Factory
    public MediaCodecAdapter a(MediaCodecAdapter.a aVar) throws IOException {
        int i;
        int i2 = gj9.f41922a;
        if (i2 < 23 || ((i = this.f3460a) != 1 && (i != 0 || i2 < 31))) {
            return new h.b().a(aVar);
        }
        int iL = bp5.l(aVar.f3408a.k);
        Log.h(f30770a, "Creating an asynchronous MediaCodec adapter for track type " + gj9.x0(iL));
        return new a.b(iL, this.f3461a).a(aVar);
    }

    public void b(boolean z) {
        this.f3461a = z;
    }

    public b c() {
        this.f3460a = 2;
        return this;
    }

    public b d() {
        this.f3460a = 1;
        return this;
    }
}
