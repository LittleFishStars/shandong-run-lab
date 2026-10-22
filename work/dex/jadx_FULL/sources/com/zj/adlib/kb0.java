package com.zj.adlib;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ThreadSafe
@TargetApi(21)
public class kb0 extends PlatformBitmapFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nw0 f42777a;

    public kb0(nw0 nw0Var) {
        this.f42777a = nw0Var;
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    public rm1<Bitmap> b(int i, int i2, Bitmap.Config config) throws Throwable {
        Bitmap bitmap = this.f42777a.get(qw0.d(i, i2, config));
        Bitmaps.d(bitmap, i, i2, config);
        return rm1.J(bitmap, this.f42777a);
    }
}
