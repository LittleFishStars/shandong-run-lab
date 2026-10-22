package com.igexin.push.core.i.a;

import android.content.Context;
import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f38057a = "BufferGifDecoder";
    private final Context b;
    private final c d = new c();
    private final j c = new j();

    public a(Context context) {
        this.b = context.getApplicationContext();
    }

    private static int a(i iVar, int i, int i2) {
        int iMin = Math.min(iVar.i / i2, iVar.h / i);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        com.igexin.c.a.c.a.b("BufferGifDecoder", "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + iVar.h + "x" + iVar.i + "]");
        return iMax;
    }

    private f a(ByteBuffer byteBuffer, int i, int i2, j jVar) {
        i iVarB = jVar.b();
        if (iVarB.e <= 0 || iVarB.d != 0) {
            return null;
        }
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        int iMin = Math.min(iVarB.i / i2, iVarB.h / i);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        com.igexin.c.a.c.a.b("BufferGifDecoder", "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + iVarB.h + "x" + iVarB.i + "]");
        n nVar = new n(this.d, iVarB, byteBuffer, iMax);
        nVar.a(config);
        nVar.e();
        Bitmap bitmapN = nVar.n();
        if (bitmapN == null) {
            return null;
        }
        return new f(new e(nVar, bitmapN));
    }

    private f a(byte[] bArr, int i, int i2) {
        return a(ByteBuffer.wrap(bArr), i, i2);
    }

    public final f a(ByteBuffer byteBuffer, int i, int i2) {
        j jVarA = this.c.a(byteBuffer);
        f fVar = null;
        try {
            i iVarB = jVarA.b();
            if (iVarB.e > 0 && iVarB.d == 0) {
                Bitmap.Config config = Bitmap.Config.ARGB_8888;
                int iMin = Math.min(iVarB.i / i2, iVarB.h / i);
                int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
                com.igexin.c.a.c.a.b("BufferGifDecoder", "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + iVarB.h + "x" + iVarB.i + "]");
                n nVar = new n(this.d, iVarB, byteBuffer, iMax);
                nVar.a(config);
                nVar.e();
                Bitmap bitmapN = nVar.n();
                if (bitmapN != null) {
                    fVar = new f(new e(nVar, bitmapN));
                }
            }
            jVarA.a();
            return fVar;
        } catch (Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
                return null;
            } finally {
                jVarA.a();
            }
        }
    }
}
