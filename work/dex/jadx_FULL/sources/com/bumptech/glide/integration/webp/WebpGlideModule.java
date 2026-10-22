package com.bumptech.glide.integration.webp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.integration.webp.decoder.AnimatedWebpBitmapDecoder;
import com.bumptech.glide.integration.webp.decoder.ByteBufferAnimatedBitmapDecoder;
import com.bumptech.glide.integration.webp.decoder.ByteBufferBitmapWebpDecoder;
import com.bumptech.glide.integration.webp.decoder.ByteBufferWebpDecoder;
import com.bumptech.glide.integration.webp.decoder.StreamAnimatedBitmapDecoder;
import com.bumptech.glide.integration.webp.decoder.StreamBitmapWebpDecoder;
import com.bumptech.glide.integration.webp.decoder.StreamWebpDecoder;
import com.bumptech.glide.integration.webp.decoder.WebpDownsampler;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.integration.webp.decoder.WebpDrawableEncoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.module.GlideModule;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@Deprecated
public class WebpGlideModule implements GlideModule {
    @Override // com.bumptech.glide.module.GlideModule, com.bumptech.glide.module.AppliesOptions
    public void applyOptions(Context context, GlideBuilder glideBuilder) {
    }

    @Override // com.bumptech.glide.module.GlideModule, com.bumptech.glide.module.RegistersComponents
    public void registerComponents(Context context, Glide glide, Registry registry) {
        Resources resources = context.getResources();
        BitmapPool bitmapPool = glide.getBitmapPool();
        ArrayPool arrayPool = glide.getArrayPool();
        WebpDownsampler webpDownsampler = new WebpDownsampler(registry.getImageHeaderParsers(), resources.getDisplayMetrics(), bitmapPool, arrayPool);
        AnimatedWebpBitmapDecoder animatedWebpBitmapDecoder = new AnimatedWebpBitmapDecoder(arrayPool, bitmapPool);
        ByteBufferBitmapWebpDecoder byteBufferBitmapWebpDecoder = new ByteBufferBitmapWebpDecoder(webpDownsampler);
        StreamBitmapWebpDecoder streamBitmapWebpDecoder = new StreamBitmapWebpDecoder(webpDownsampler, arrayPool);
        ByteBufferWebpDecoder byteBufferWebpDecoder = new ByteBufferWebpDecoder(context, arrayPool, bitmapPool);
        registry.prepend("Bitmap", ByteBuffer.class, Bitmap.class, byteBufferBitmapWebpDecoder).prepend("Bitmap", InputStream.class, Bitmap.class, streamBitmapWebpDecoder).prepend("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, byteBufferBitmapWebpDecoder)).prepend("BitmapDrawable", InputStream.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, streamBitmapWebpDecoder)).prepend("Bitmap", ByteBuffer.class, Bitmap.class, new ByteBufferAnimatedBitmapDecoder(animatedWebpBitmapDecoder)).prepend("Bitmap", InputStream.class, Bitmap.class, new StreamAnimatedBitmapDecoder(animatedWebpBitmapDecoder)).prepend(ByteBuffer.class, WebpDrawable.class, byteBufferWebpDecoder).prepend(InputStream.class, WebpDrawable.class, new StreamWebpDecoder(byteBufferWebpDecoder, arrayPool)).prepend(WebpDrawable.class, (ResourceEncoder) new WebpDrawableEncoder());
    }
}
