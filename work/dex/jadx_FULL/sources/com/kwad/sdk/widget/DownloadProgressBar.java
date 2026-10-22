package com.kwad.sdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class DownloadProgressBar extends View {
    Paint bsV;
    Paint bsW;
    Paint bsX;
    private String bsY;
    private float bsZ;
    private Rect bta;
    private LinearGradient btb;
    private LinearGradient btc;
    private LinearGradient btd;
    private Runnable bte;
    private Matrix mMatrix;
    private Path mPath;
    private RectF mRectF;
    private long mStartTime;

    public DownloadProgressBar(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.bte);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.clipPath(this.mPath);
        this.bsV.setShader(this.btb);
        canvas.drawRect(this.mRectF, this.bsV);
        this.bsV.setShader(this.btc);
        canvas.drawRect(0.0f, 0.0f, (getWidth() * this.bsZ) / 100.0f, getHeight(), this.bsV);
        float f = this.bsZ;
        float f2 = 0.0f;
        if (f > 0.0f && f < 100.0f) {
            long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.mStartTime) % com.ipd.dsp.internal.v1.b.C0923b.f;
            float f3 = jElapsedRealtime >= com.igexin.push.config.c.j ? 0.0f : jElapsedRealtime / 1500.0f;
            this.mMatrix.reset();
            this.mMatrix.setScale(1.0f, f3);
            this.btd.setLocalMatrix(this.mMatrix);
            this.bsW.setShader(this.btd);
            canvas.drawRect(0.0f, 0.0f, ((getWidth() * this.bsZ) / 100.0f) * f3, getHeight(), this.bsW);
            if (jElapsedRealtime > 500 && jElapsedRealtime <= com.igexin.push.config.c.j) {
                f2 = (jElapsedRealtime - 500) / 1000.0f;
            }
            float width = ((getWidth() * this.bsZ) / 100.0f) * f2;
            this.mMatrix.reset();
            this.mMatrix.setScale(1.0f, f3);
            this.btd.setLocalMatrix(this.mMatrix);
            this.bsW.setShader(this.btd);
            canvas.drawRect(0.0f, 0.0f, width, getHeight(), this.bsW);
        }
        String str = this.bsY;
        if (str != null) {
            this.bsX.getTextBounds(str, 0, str.length(), this.bta);
            Rect rect = this.bta;
            canvas.drawText(this.bsY, getWidth() / 2.0f, (getHeight() / 2.0f) - ((rect.top + rect.bottom) / 2.0f), this.bsX);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.btb = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{1291525714, 1291569420}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.btc = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{-319918, -276212}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.bsV.setShader(this.btb);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{16501004, -276212}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.btd = linearGradient;
        this.bsW.setShader(linearGradient);
        float f = i;
        this.mRectF.set(0.0f, 0.0f, f, i2);
        this.mPath.reset();
        float f2 = f / 2.0f;
        this.mPath.addRoundRect(this.mRectF, f2, f2, Path.Direction.CW);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0) {
            removeCallbacks(this.bte);
            return;
        }
        float f = this.bsZ;
        if (f <= 0.0f || f >= 100.0f) {
            return;
        }
        this.mStartTime = SystemClock.elapsedRealtime();
        post(this.bte);
    }

    public void setProgress(float f) {
        this.bsZ = f;
        invalidate();
        if (f == 0.0f || f == 100.0f) {
            removeCallbacks(this.bte);
        } else if (getWindowVisibility() == 0 && this.mStartTime == 0) {
            post(this.bte);
        }
    }

    public void setText(String str) {
        this.bsY = str;
        invalidate();
    }

    public DownloadProgressBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bte = new Runnable() { // from class: com.kwad.sdk.widget.DownloadProgressBar.1
            @Override // java.lang.Runnable
            public final void run() {
                DownloadProgressBar.this.invalidate();
                if (DownloadProgressBar.this.getWindowVisibility() == 0) {
                    DownloadProgressBar.this.postDelayed(this, 34L);
                }
            }
        };
        this.bsV = new Paint(1);
        this.bsW = new Paint(1);
        this.mRectF = new RectF();
        Paint paint = new Paint(1);
        this.bsX = paint;
        paint.setTextSize(com.kwad.sdk.c.a.a.a(context, 16.0f));
        this.bsX.setColor(-1);
        this.bsX.setTextAlign(Paint.Align.CENTER);
        this.bta = new Rect();
        this.mMatrix = new Matrix();
        this.mPath = new Path();
    }
}
