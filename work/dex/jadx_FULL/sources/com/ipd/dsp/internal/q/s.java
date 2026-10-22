package com.ipd.dsp.internal.q;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import com.ipd.dsp.Dsp;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38514a = "DrawableToBitmap";
    public static final com.ipd.dsp.internal.j.e b = new a();

    public class a extends com.ipd.dsp.internal.j.f {
        @Override // com.ipd.dsp.internal.j.f, com.ipd.dsp.internal.j.e
        public void a(Bitmap bitmap) {
        }
    }

    @Nullable
    public static com.ipd.dsp.internal.i.v<Bitmap> a(com.ipd.dsp.internal.j.e eVar, Drawable drawable, int i, int i2) {
        Bitmap bitmapB;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmapB = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmapB = null;
        } else {
            bitmapB = b(eVar, current, i, i2);
            z = true;
        }
        if (!z) {
            eVar = b;
        }
        return g.a(bitmapB, eVar);
    }

    @Nullable
    public static Bitmap b(com.ipd.dsp.internal.j.e eVar, Drawable drawable, int i, int i2) {
        if (i == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.f(f38514a, "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        }
        if (i2 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.f(f38514a, "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        }
        if (drawable.getIntrinsicWidth() > 0) {
            i = drawable.getIntrinsicWidth();
        }
        if (drawable.getIntrinsicHeight() > 0) {
            i2 = drawable.getIntrinsicHeight();
        }
        Lock lockA = j0.a();
        lockA.lock();
        Bitmap bitmapA = eVar.a(i, i2, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(bitmapA);
            drawable.setBounds(0, 0, i, i2);
            drawable.draw(canvas);
            canvas.setBitmap(null);
            return bitmapA;
        } finally {
            lockA.unlock();
        }
    }
}
