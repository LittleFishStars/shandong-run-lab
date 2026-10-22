package com.kwad.sdk.core.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class RoundCornerNewLayout extends FrameLayout {

    @Nullable
    private Path baS;
    private int baT;
    private int baU;
    private int baV;
    private int baW;
    private boolean baX;

    public RoundCornerNewLayout(@NonNull Context context) {
        this(context, null);
    }

    @RequiresApi(api = 21)
    private void Pt() {
        if (this.baX) {
            int iMax = Math.max(this.baT, this.baU);
            int iMax2 = Math.max(this.baV, this.baW);
            setOutlineProvider(new a(Math.max(iMax, iMax2), 0, iMax == iMax2 ? 0 : -iMax2, getWidth(), iMax == iMax2 ? getHeight() : getHeight() + iMax));
            setClipToOutline(true);
        } else {
            setOutlineProvider(new a(this.baT, 0, 0, getWidth(), getHeight() + this.baT));
        }
        setClipToOutline(true);
    }

    private static Path a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Path path = new Path();
        path.moveTo(0.0f, i5);
        if (i5 >= 0) {
            float f = i5 * 2;
            path.arcTo(new RectF(0.0f, 0.0f, f, f), -180.0f, 90.0f);
        }
        path.lineTo(i3 - i6, 0.0f);
        if (i6 >= 0) {
            int i9 = i6 * 2;
            path.arcTo(new RectF(i3 - i9, 0.0f, i3, i9), -90.0f, 90.0f);
        }
        float f2 = i3;
        path.lineTo(f2, i4 - i7);
        if (i7 != 0) {
            int i10 = i7 * 2;
            path.arcTo(new RectF(i3 - i10, i4 - i10, f2, i4), 0.0f, 90.0f);
        }
        float f3 = i4;
        path.lineTo(i8, f3);
        if (i8 != 0) {
            int i11 = i8 * 2;
            path.arcTo(new RectF(0.0f, i4 - i11, i11, f3), 90.0f, 90.0f);
        }
        path.close();
        path.offset(0.0f, 0.0f);
        return path;
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"ObsoleteSdkInt"})
    public void dispatchDraw(Canvas canvas) {
        Pt();
        Path path = this.baS;
        if (path != null) {
            canvas.clipPath(path);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    @SuppressLint({"ObsoleteSdkInt"})
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Pt();
    }

    public void setCalculateRadius(boolean z) {
        this.baX = z;
    }

    public void setTopRadius(int i) {
        this.baT = i;
        this.baU = i;
        invalidate();
    }

    public RoundCornerNewLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundCornerNewLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.baX = false;
    }
}
