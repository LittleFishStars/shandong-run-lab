package com.facebook.imagepipeline.request;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.zj.adlib.rm1;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface Postprocessor {
    rm1<Bitmap> a(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory);

    @Nullable
    CacheKey b();

    String getName();
}
