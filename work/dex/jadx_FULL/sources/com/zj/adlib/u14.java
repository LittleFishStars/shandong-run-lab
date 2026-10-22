package com.zj.adlib;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ThreadSafe
@TargetApi(11)
public class u14 extends PlatformBitmapFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PlatformDecoder f45045a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final h13 f19939a;

    public u14(h13 h13Var, PlatformDecoder platformDecoder) {
        this.f19939a = h13Var;
        this.f45045a = platformDecoder;
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    public rm1<Bitmap> b(int i, int i2, Bitmap.Config config) throws Throwable {
        rm1<PooledByteBuffer> rm1VarA = this.f19939a.a((short) i, (short) i2);
        try {
            q13 q13Var = new q13(rm1VarA);
            q13Var.M(ImageFormat.JPEG);
            try {
                rm1<Bitmap> rm1VarA2 = this.f45045a.a(q13Var, config, rm1VarA.s().size());
                rm1VarA2.s().eraseColor(0);
                q13.j(q13Var);
                rm1VarA.close();
                return rm1VarA2;
            } catch (Throwable th) {
                q13.j(q13Var);
                throw th;
            }
        } catch (Throwable th2) {
            rm1VarA.close();
            throw th2;
        }
    }
}
