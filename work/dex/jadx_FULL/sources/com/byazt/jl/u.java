package com.byazt.jl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.byazt.nr.m;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 157, 67})
public class u extends x<com.byazt.on.c, com.byazt.on.tt> {
    public static final /* synthetic */ boolean c = true;

    public u(com.byazt.on.c cVar) {
        super(cVar);
    }

    @Override // com.byazt.jl.x
    public Bitmap c(Canvas canvas, Paint paint, int i, Bitmap bitmap, com.byazt.on.tt ttVar) {
        Bitmap bitmapDecodeStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = i;
        options.inMutable = true;
        options.inBitmap = bitmap;
        Bitmap bitmap2 = null;
        try {
            ((com.byazt.on.c) this.sp).d_();
            try {
                bitmapDecodeStream = BitmapFactory.decodeStream(((com.byazt.on.c) this.sp).n(), null, options);
            } catch (IllegalArgumentException unused) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = i;
                options2.inMutable = true;
                bitmapDecodeStream = BitmapFactory.decodeStream(((com.byazt.on.c) this.sp).n(), null, options2);
            }
            try {
                if (!c && bitmapDecodeStream == null) {
                    throw new AssertionError();
                }
                paint.setXfermode(null);
                canvas.drawBitmap(bitmapDecodeStream, 0.0f, 0.0f, paint);
                return bitmapDecodeStream;
            } catch (IOException e) {
                e = e;
                bitmap2 = bitmapDecodeStream;
                m.c(e);
                return bitmap2;
            }
        } catch (IOException e2) {
            e = e2;
            m.c(e);
            return bitmap2;
        }
    }
}
