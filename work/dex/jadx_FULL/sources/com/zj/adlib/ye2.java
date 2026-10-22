package com.zj.adlib;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ye2 implements CacheKeyFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ye2 f46012a;

    public static synchronized ye2 d() {
        if (f46012a == null) {
            f46012a = new ye2();
        }
        return f46012a;
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey a(ImageRequest imageRequest) {
        return new jw0(getCacheKeySourceUri(imageRequest.o()).toString(), imageRequest.m(), imageRequest.c(), imageRequest.d(), null, null);
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey b(ImageRequest imageRequest) {
        return new jg8(getCacheKeySourceUri(imageRequest.o()).toString());
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey c(ImageRequest imageRequest) {
        CacheKey cacheKey;
        String name;
        Postprocessor postprocessorH = imageRequest.h();
        if (postprocessorH != null) {
            CacheKey cacheKeyB = postprocessorH.b();
            name = postprocessorH.getClass().getName();
            cacheKey = cacheKeyB;
        } else {
            cacheKey = null;
            name = null;
        }
        return new jw0(getCacheKeySourceUri(imageRequest.o()).toString(), imageRequest.m(), imageRequest.c(), imageRequest.d(), cacheKey, name);
    }

    public Uri getCacheKeySourceUri(Uri uri) {
        return uri;
    }
}
