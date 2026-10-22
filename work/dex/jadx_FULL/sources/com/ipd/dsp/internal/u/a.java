package com.ipd.dsp.internal.u;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.internal.components.glide.load.ImageHeaderParser;
import com.ipd.dsp.internal.d0.o;
import com.ipd.dsp.internal.f.k;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a implements k<ByteBuffer, c> {
    public static final String f = "BufferGifDecoder";
    public static final C0919a g = new C0919a();
    public static final b h = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f38543a;
    public final List<ImageHeaderParser> b;
    public final b c;
    public final C0919a d;
    public final com.ipd.dsp.internal.u.b e;

    /* JADX INFO: renamed from: com.ipd.dsp.internal.u.a$a, reason: collision with other inner class name */
    @VisibleForTesting
    public static class C0919a {
        public com.ipd.dsp.internal.e.a a(com.ipd.dsp.internal.e.a.InterfaceC0876a interfaceC0876a, com.ipd.dsp.internal.e.c cVar, ByteBuffer byteBuffer, int i) {
            return new com.ipd.dsp.internal.e.e(interfaceC0876a, cVar, byteBuffer, i);
        }
    }

    public a(Context context) {
        this(context, com.ipd.dsp.internal.components.glide.a.a(context).i().a(), com.ipd.dsp.internal.components.glide.a.a(context).e(), com.ipd.dsp.internal.components.glide.a.a(context).d());
    }

    @VisibleForTesting
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue<com.ipd.dsp.internal.e.d> f38544a = o.a(0);

        public synchronized com.ipd.dsp.internal.e.d a(ByteBuffer byteBuffer) {
            com.ipd.dsp.internal.e.d dVarPoll;
            dVarPoll = this.f38544a.poll();
            if (dVarPoll == null) {
                dVarPoll = new com.ipd.dsp.internal.e.d();
            }
            return dVarPoll.a(byteBuffer);
        }

        public synchronized void a(com.ipd.dsp.internal.e.d dVar) {
            dVar.a();
            this.f38544a.offer(dVar);
        }
    }

    @Override // com.ipd.dsp.internal.f.k
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull com.ipd.dsp.internal.f.i iVar) throws IOException {
        return !((Boolean) iVar.a(i.b)).booleanValue() && com.ipd.dsp.internal.components.glide.load.a.a(this.b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    public a(Context context, List<ImageHeaderParser> list, com.ipd.dsp.internal.j.e eVar, com.ipd.dsp.internal.j.b bVar) {
        this(context, list, eVar, bVar, h, g);
    }

    @Override // com.ipd.dsp.internal.f.k
    public e a(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) {
        com.ipd.dsp.internal.e.d dVarA = this.c.a(byteBuffer);
        try {
            return a(byteBuffer, i, i2, dVarA, iVar);
        } finally {
            this.c.a(dVarA);
        }
    }

    @VisibleForTesting
    public a(Context context, List<ImageHeaderParser> list, com.ipd.dsp.internal.j.e eVar, com.ipd.dsp.internal.j.b bVar, b bVar2, C0919a c0919a) {
        this.f38543a = context.getApplicationContext();
        this.b = list;
        this.d = c0919a;
        this.e = new com.ipd.dsp.internal.u.b(eVar, bVar);
        this.c = bVar2;
    }

    @Nullable
    public final e a(ByteBuffer byteBuffer, int i, int i2, com.ipd.dsp.internal.e.d dVar, com.ipd.dsp.internal.f.i iVar) {
        Bitmap.Config config;
        long jA = com.ipd.dsp.internal.d0.i.a();
        try {
            com.ipd.dsp.internal.e.c cVarD = dVar.d();
            if (cVarD.b() > 0 && cVarD.c() == 0) {
                if (iVar.a(i.f38551a) == com.ipd.dsp.internal.f.b.PREFER_RGB_565) {
                    config = Bitmap.Config.RGB_565;
                } else {
                    config = Bitmap.Config.ARGB_8888;
                }
                com.ipd.dsp.internal.e.a aVarA = this.d.a(this.e, cVarD, byteBuffer, a(cVarD, i, i2));
                aVarA.a(config);
                aVarA.c();
                Bitmap bitmapB = aVarA.b();
                if (bitmapB == null) {
                    return null;
                }
                return new e(new c(this.f38543a, aVarA, com.ipd.dsp.internal.p.c.a(), i, i2, bitmapB));
            }
            return null;
        } finally {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.e(f, "Decoded GIF from stream in " + com.ipd.dsp.internal.d0.i.a(jA));
            }
        }
    }

    public static int a(com.ipd.dsp.internal.e.c cVar, int i, int i2) {
        int iMin = Math.min(cVar.a() / i2, cVar.d() / i);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Dsp.isDebugLogEnable() && iMax > 1) {
            com.ipd.dsp.internal.c2.k.e(f, "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + cVar.d() + "x" + cVar.a() + "]");
        }
        return iMax;
    }
}
