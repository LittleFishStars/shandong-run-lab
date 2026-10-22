package com.byazt.wx;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.byazt.jl.i;
import com.byazt.nr.m;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 525, 54})
public abstract class ve<Decoder extends i<?, ?>> extends Drawable implements i.c, tt {
    public static final String c = "ve";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<Object> f29168a;
    public boolean da;
    public final Runnable i;
    public final Matrix n;
    public final Set<WeakReference<Drawable.Callback>> sl;
    public Bitmap sp;
    public boolean t;
    public final Paint tt;
    public final DrawFilter uj;
    public final Decoder ve;
    public final Handler x;

    public ve(com.byazt.zt.tt ttVar) {
        Paint paint = new Paint();
        this.tt = paint;
        this.uj = new PaintFlagsDrawFilter(0, 3);
        this.n = new Matrix();
        this.f29168a = new HashSet();
        this.x = new Handler(Looper.getMainLooper()) { // from class: com.byazt.wx.ve.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    Iterator it = new ArrayList(ve.this.f29168a).iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                } else {
                    if (i != 2) {
                        return;
                    }
                    Iterator it2 = new ArrayList(ve.this.f29168a).iterator();
                    while (it2.hasNext()) {
                        it2.next();
                    }
                }
            }
        };
        this.i = new Runnable() { // from class: com.byazt.wx.ve.2
            @Override // java.lang.Runnable
            public void run() {
                ve.this.invalidateSelf();
            }
        };
        this.da = true;
        this.sl = new HashSet();
        this.t = false;
        paint.setAntiAlias(true);
        this.ve = (Decoder) tt(ttVar, this);
    }

    private void n() {
        ArrayList arrayList = new ArrayList();
        Drawable.Callback callback = getCallback();
        boolean z = false;
        for (WeakReference weakReference : new HashSet(this.sl)) {
            Drawable.Callback callback2 = (Drawable.Callback) weakReference.get();
            if (callback2 == null) {
                arrayList.add(weakReference);
            } else if (callback2 == callback) {
                z = true;
            } else {
                callback2.invalidateDrawable(this);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.sl.remove((WeakReference) it.next());
        }
        if (z) {
            return;
        }
        this.sl.add(new WeakReference<>(callback));
    }

    private void uj() {
        this.ve.tt(this);
        if (this.da) {
            this.ve.i();
        } else {
            this.ve.n();
        }
    }

    private void ve() {
        this.ve.c(this);
        if (this.da) {
            this.ve.x();
        } else {
            if (this.ve.da()) {
                return;
            }
            this.ve.x();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.sp;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.setDrawFilter(this.uj);
        canvas.drawBitmap(this.sp, this.n, this.tt);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        return super.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.t) {
            return -1;
        }
        try {
            return this.ve.a().height();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.t) {
            return -1;
        }
        try {
            return this.ve.a().width();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        Iterator it = new HashSet(this.sl).iterator();
        while (it.hasNext()) {
            Drawable.Callback callback = (Drawable.Callback) ((WeakReference) it.next()).get();
            if (callback != null && callback != getCallback()) {
                callback.invalidateDrawable(this);
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.ve.da();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.tt.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        boolean zTt = this.ve.tt(getBounds().width(), getBounds().height());
        this.n.setScale(((getBounds().width() * 1.0f) * this.ve.t()) / this.ve.a().width(), ((getBounds().height() * 1.0f) * this.ve.t()) / this.ve.a().height());
        if (zTt) {
            this.sp = Bitmap.createBitmap(this.ve.a().width() / this.ve.t(), this.ve.a().height() / this.ve.t(), Bitmap.Config.ARGB_4444);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.tt.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        n();
        if (this.da) {
            if (z) {
                if (!isRunning()) {
                    ve();
                }
            } else if (isRunning()) {
                uj();
            }
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.ve.da()) {
            this.ve.i();
        }
        this.ve.sl();
        ve();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        uj();
    }

    public abstract Decoder tt(com.byazt.zt.tt ttVar, i.c cVar);

    @Override // com.byazt.jl.i.c
    public void tt(ByteBuffer byteBuffer) {
        if (isRunning()) {
            Bitmap bitmap = this.sp;
            if (bitmap == null || bitmap.isRecycled()) {
                this.sp = Bitmap.createBitmap(this.ve.a().width() / this.ve.t(), this.ve.a().height() / this.ve.t(), Bitmap.Config.ARGB_4444);
            }
            byteBuffer.rewind();
            if (byteBuffer.remaining() < this.sp.getByteCount()) {
                m.uj(c, "onRender:Buffer not large enough for pixels");
            } else {
                this.sp.copyPixelsFromBuffer(byteBuffer);
                this.x.post(this.i);
            }
        }
    }

    @Override // com.byazt.jl.i.c
    public void c() {
        Message.obtain(this.x, 1).sendToTarget();
    }

    @Override // com.byazt.jl.i.c
    public void tt() {
        Message.obtain(this.x, 2).sendToTarget();
    }
}
