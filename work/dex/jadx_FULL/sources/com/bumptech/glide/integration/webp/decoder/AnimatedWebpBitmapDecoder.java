package com.bumptech.glide.integration.webp.decoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.integration.webp.WebpHeaderParser;
import com.bumptech.glide.integration.webp.WebpImage;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.gif.GifBitmapProvider;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AnimatedWebpBitmapDecoder {
    public static final Option<Boolean> DISABLE_BITMAP = Option.memory("com.bumptech.glide.integration.webp.decoder.AnimatedWebpBitmapDecoder.DisableBitmap", Boolean.FALSE);
    private final ArrayPool mArrayPool;
    private final BitmapPool mBitmapPool;
    private final GifBitmapProvider mProvider;

    public AnimatedWebpBitmapDecoder(ArrayPool arrayPool, BitmapPool bitmapPool) {
        this.mArrayPool = arrayPool;
        this.mBitmapPool = bitmapPool;
        this.mProvider = new GifBitmapProvider(bitmapPool, arrayPool);
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, Options options) throws IOException {
        byte[] bArrInputStreamToBytes = Utils.inputStreamToBytes(inputStream);
        if (bArrInputStreamToBytes == null) {
            return null;
        }
        return decode(ByteBuffer.wrap(bArrInputStreamToBytes), i, i2, options);
    }

    public boolean handles(InputStream inputStream, @NonNull Options options) throws IOException {
        if (((Boolean) options.get(DISABLE_BITMAP)).booleanValue()) {
            return false;
        }
        return WebpHeaderParser.isAnimatedWebpType(WebpHeaderParser.getType(inputStream, this.mArrayPool));
    }

    public Resource<Bitmap> decode(ByteBuffer byteBuffer, int i, int i2, Options options) throws IOException {
        int iRemaining = byteBuffer.remaining();
        byte[] bArr = new byte[iRemaining];
        byteBuffer.get(bArr, 0, iRemaining);
        WebpImage webpImageCreate = WebpImage.create(bArr);
        WebpDecoder webpDecoder = new WebpDecoder(this.mProvider, webpImageCreate, byteBuffer, Utils.getSampleSize(webpImageCreate.getWidth(), webpImageCreate.getHeight(), i, i2));
        try {
            webpDecoder.advance();
            return BitmapResource.obtain(webpDecoder.getNextFrame(), this.mBitmapPool);
        } finally {
            webpDecoder.clear();
        }
    }

    public boolean handles(ByteBuffer byteBuffer, @NonNull Options options) throws IOException {
        if (((Boolean) options.get(DISABLE_BITMAP)).booleanValue()) {
            return false;
        }
        return WebpHeaderParser.isAnimatedWebpType(WebpHeaderParser.getType(byteBuffer));
    }
}
