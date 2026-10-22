package com.kc.dw.core.view.gif;

import android.graphics.Bitmap;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
final class SimpleBitmapProvider implements GifDecoder.BitmapProvider {
    @Override // com.kc.dw.core.view.gif.GifDecoder.BitmapProvider
    public Bitmap obtain(int i, int i2, Bitmap.Config config) {
        try {
            return Bitmap.createBitmap(i, i2, config);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.kc.dw.core.view.gif.GifDecoder.BitmapProvider
    public byte[] obtainByteArray(int i) {
        return new byte[i];
    }

    @Override // com.kc.dw.core.view.gif.GifDecoder.BitmapProvider
    public int[] obtainIntArray(int i) {
        return new int[i];
    }

    @Override // com.kc.dw.core.view.gif.GifDecoder.BitmapProvider
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.kc.dw.core.view.gif.GifDecoder.BitmapProvider
    public void release(byte[] bArr) {
    }

    @Override // com.kc.dw.core.view.gif.GifDecoder.BitmapProvider
    public void release(int[] iArr) {
    }
}
