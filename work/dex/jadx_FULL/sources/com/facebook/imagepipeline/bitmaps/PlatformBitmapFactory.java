package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.zj.adlib.rm1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class PlatformBitmapFactory {
    public rm1<Bitmap> a(int i, int i2) {
        return b(i, i2, Bitmap.Config.ARGB_8888);
    }

    public abstract rm1<Bitmap> b(int i, int i2, Bitmap.Config config);
}
