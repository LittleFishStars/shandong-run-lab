package com.bumptech.glide.integration.webp.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class WebpDrawableTransformation implements Transformation<WebpDrawable> {
    private final Transformation<Bitmap> wrapped;

    public WebpDrawableTransformation(Transformation<Bitmap> transformation) {
        this.wrapped = (Transformation) Preconditions.checkNotNull(transformation);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof WebpDrawableTransformation) {
            return this.wrapped.equals(((WebpDrawableTransformation) obj).wrapped);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource<WebpDrawable> transform(Context context, Resource<WebpDrawable> resource, int i, int i2) {
        WebpDrawable webpDrawable = resource.get();
        Resource<Bitmap> bitmapResource = new BitmapResource(webpDrawable.getFirstFrame(), Glide.get(context).getBitmapPool());
        Resource<Bitmap> resourceTransform = this.wrapped.transform(context, bitmapResource, i, i2);
        if (!bitmapResource.equals(resourceTransform)) {
            bitmapResource.recycle();
        }
        webpDrawable.setFrameTransformation(this.wrapped, resourceTransform.get());
        return resource;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.wrapped.updateDiskCacheKey(messageDigest);
    }
}
