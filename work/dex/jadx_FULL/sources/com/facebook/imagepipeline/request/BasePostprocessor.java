package com.facebook.imagepipeline.request;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import com.zj.adlib.rm1;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BasePostprocessor implements Postprocessor {
    @Override // com.facebook.imagepipeline.request.Postprocessor
    public rm1<Bitmap> a(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
        rm1<Bitmap> rm1VarB = platformBitmapFactory.b(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        try {
            e(rm1VarB.s(), bitmap);
            return rm1.l(rm1VarB);
        } finally {
            rm1.p(rm1VarB);
        }
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    @Nullable
    public CacheKey b() {
        return null;
    }

    public void d(Bitmap bitmap) {
    }

    public void e(Bitmap bitmap, Bitmap bitmap2) {
        Bitmaps.a(bitmap, bitmap2);
        d(bitmap);
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public String getName() {
        return "Unknown postprocessor";
    }
}
