package com.byazt.or;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.nr.m;
import com.byazt.nr.t;
import com.byazt.oq.GifView;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 579, 34})
public class a {
    public static final byte[] c = c("VP8X");

    private static byte[] c(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new byte[1];
        }
    }

    public static void tt(ImageView imageView, byte[] bArr, int i, int i2) {
        try {
            if (imageView instanceof GifView) {
                ((GifView) imageView).c(bArr, false);
                return;
            }
            if (TextUtils.equals("png", t.c(Arrays.copyOfRange(bArr, 0, t.c())))) {
                ve(imageView, bArr, i, i2);
            } else if (c(bArr, 0)) {
                c(imageView, bArr, i, i2);
            } else {
                uj(imageView, bArr, i, i2);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private static void uj(final ImageView imageView, byte[] bArr, int i, int i2) {
        final Bitmap bitmapC = new com.byazt.ib.c(i, i2, imageView.getScaleType(), Bitmap.Config.RGB_565, i, i2).c(bArr);
        if (bitmapC != null) {
            com.byazt.nr.da.tt().post(new Runnable() { // from class: com.byazt.or.a.2
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageBitmap(bitmapC);
                }
            });
        }
    }

    private static void ve(final ImageView imageView, byte[] bArr, int i, int i2) {
        if (!c(bArr)) {
            uj(imageView, bArr, i, i2);
        } else {
            final com.byazt.wx.c cVarC = com.byazt.wx.c.c(ByteBuffer.wrap(bArr));
            com.byazt.nr.da.tt().post(new Runnable() { // from class: com.byazt.or.a.1
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageDrawable(cVarC);
                }
            });
        }
    }

    public static boolean c(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return false;
        }
        return c.c(bArr);
    }

    public static void c(final ImageView imageView, byte[] bArr, int i, int i2) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                final Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(byteBufferWrap));
                com.byazt.nr.da.tt().post(new Runnable() { // from class: com.byazt.or.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Drawable drawable = drawableDecodeDrawable;
                        if (drawable instanceof AnimatedImageDrawable) {
                            ((AnimatedImageDrawable) drawable).start();
                        }
                        imageView.setImageDrawable(drawableDecodeDrawable);
                    }
                });
                return;
            } catch (IOException e) {
                m.c(e);
                return;
            }
        }
        uj(imageView, bArr, i, i2);
    }

    public static boolean c(byte[] bArr, int i) {
        try {
            boolean zC = c(bArr, i + 12, c);
            int i2 = i + 20;
            if (bArr.length <= i2) {
                return false;
            }
            return zC && ((bArr[i2] & 2) == 2);
        } catch (Throwable th) {
            m.c(th);
            return false;
        }
    }

    private static boolean c(byte[] bArr, int i, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2 + i] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
