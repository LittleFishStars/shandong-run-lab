package com.zj.adlib;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.internal.PaintDrawable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class jb0 extends PaintDrawable {
    public int K = 0;
    public int L = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Path f42546a = new Path();

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        if (this.K != iWidth || this.L != iHeight) {
            this.f42546a.reset();
            float f = (iWidth * 30) / 225;
            float f2 = f * 0.70710677f;
            float f3 = f / 0.70710677f;
            float f4 = iWidth;
            float f5 = f4 / 2.0f;
            float f6 = iHeight;
            this.f42546a.moveTo(f5, f6);
            float f7 = f6 / 2.0f;
            this.f42546a.lineTo(0.0f, f7);
            float f8 = f7 - f2;
            this.f42546a.lineTo(f2, f8);
            float f9 = f / 2.0f;
            float f10 = f5 - f9;
            float f11 = (f6 - f3) - f9;
            this.f42546a.lineTo(f10, f11);
            this.f42546a.lineTo(f10, 0.0f);
            float f12 = f5 + f9;
            this.f42546a.lineTo(f12, 0.0f);
            this.f42546a.lineTo(f12, f11);
            this.f42546a.lineTo(f4 - f2, f8);
            this.f42546a.lineTo(f4, f7);
            this.f42546a.close();
            this.K = iWidth;
            this.L = iHeight;
        }
        canvas.drawPath(this.f42546a, super.f40422a);
    }
}
