package com.zj.adlib;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class gu3 extends PlatformBitmapFactory {
    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    public rm1<Bitmap> b(int i, int i2, Bitmap.Config config) {
        return rm1.J(Bitmap.createBitmap(i, i2, config), gg8.b());
    }
}
