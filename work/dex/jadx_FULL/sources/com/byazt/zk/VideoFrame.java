package com.byazt.zk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.SystemClock;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.TextureView;
import android.view.View;
import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 909, 2067})
public class VideoFrame extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f29243a;
    public final TextureView c;
    public ScriptIntrinsicBlur n;
    public Bitmap sp;
    public final Matrix tt;
    public RenderScript uj;
    public final com.byazt.ga.i.c.C0410c ve;
    public int x;

    public VideoFrame(Context context, TextureView textureView, com.byazt.ga.i.c.C0410c c0410c) {
        super(context);
        this.f29243a = -1L;
        this.sp = null;
        this.x = 0;
        this.c = textureView;
        this.tt = new Matrix();
        this.ve = c0410c;
    }

    public Bitmap c(Bitmap bitmap, float f) {
        Bitmap bitmapCreateBitmap;
        try {
            RenderScript renderScript = this.uj;
            if (renderScript != null && this.n != null) {
                Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScript, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
                Allocation allocationCreateTyped = Allocation.createTyped(this.uj, allocationCreateFromBitmap.getType());
                this.n.setRadius(f);
                this.n.setInput(allocationCreateFromBitmap);
                this.n.forEach(allocationCreateTyped);
                bitmapCreateBitmap = Bitmap.createBitmap(bitmap);
                try {
                    allocationCreateTyped.copyTo(bitmapCreateBitmap);
                    allocationCreateTyped.destroy();
                    allocationCreateFromBitmap.destroy();
                    return bitmapCreateBitmap;
                } catch (Throwable th) {
                    th = th;
                    m.c(th);
                    if (bitmapCreateBitmap != null) {
                        bitmapCreateBitmap.recycle();
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            bitmapCreateBitmap = null;
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        RenderScript renderScript = this.uj;
        if (renderScript != null) {
            renderScript.destroy();
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.n;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
        }
        RenderScript renderScriptCreate = RenderScript.create(getContext());
        this.uj = renderScriptCreate;
        this.n = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.sp;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.sp.recycle();
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.n;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
            this.n = null;
        }
        RenderScript renderScript = this.uj;
        if (renderScript != null) {
            renderScript.destroy();
            this.uj = null;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        super.onDraw(canvas);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.f29243a >= 40) {
            this.f29243a = jElapsedRealtime;
            TextureView textureView = this.c;
            if (textureView != null && textureView.isAvailable()) {
                float width = this.c.getWidth() / 160.0f;
                if (width > 0.0f) {
                    this.x = (int) (this.c.getHeight() / width);
                }
                int i = this.x;
                if (i > 0 && (bitmap2 = this.c.getBitmap(160, i)) != null) {
                    Bitmap bitmap3 = this.sp;
                    if (bitmap3 != null && !bitmap3.isRecycled()) {
                        this.sp.recycle();
                    }
                    this.sp = c(bitmap2, this.ve.c);
                    bitmap2.recycle();
                }
            }
        }
        if (this.x <= 0 || (bitmap = this.sp) == null || bitmap.isRecycled()) {
            return;
        }
        canvas.save();
        this.tt.reset();
        this.tt.setScale(getWidth() / 160.0f, getHeight() / this.x);
        canvas.concat(this.tt);
        canvas.drawBitmap(this.sp, 0.0f, 0.0f, (Paint) null);
        canvas.restore();
    }
}
