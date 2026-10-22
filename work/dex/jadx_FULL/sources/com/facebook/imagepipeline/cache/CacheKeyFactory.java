package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface CacheKeyFactory {
    CacheKey a(ImageRequest imageRequest);

    CacheKey b(ImageRequest imageRequest);

    CacheKey c(ImageRequest imageRequest);
}
