package com.aliyun.svideosdk.a.f;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.params.MeteringRectangle;
import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {
    private static final String e = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f25613a;
    private float b;
    private b c;
    private Rect d = new Rect();

    private int a(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        return i < i2 ? i2 : i;
    }

    private Rect a(RectF rectF) {
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    private RectF a(Rect rect) {
        return new RectF(rect);
    }

    @TargetApi(21)
    private MeteringRectangle a(int i, int i2) {
        if (this.d.width() == 0) {
            Log.e(e, "mPreviewRect invalid");
        }
        int i3 = i / 2;
        int i4 = ((int) this.f25613a) - i3;
        Rect rect = this.d;
        int iA = a(i4, rect.left, rect.right - i);
        int i5 = ((int) this.b) - i3;
        Rect rect2 = this.d;
        int iA2 = a(i5, rect2.top, rect2.bottom - i);
        Rect rectA = a(this.c.b(new RectF(iA, iA2, iA + i, iA2 + i)));
        Log.d(e, "calcTapAreaForCamera2, calculate Focus Area, mFocusRect = {" + rectA.left + ", " + rectA.top + ", " + rectA.right + ", " + rectA.bottom + "}");
        return new MeteringRectangle(rectA, i2);
    }

    public MeteringRectangle a(float f, float f2, boolean z) {
        this.f25613a = f;
        this.b = f2;
        if (this.d.width() == 0) {
            Log.e(e, "mPreviewRect invalid");
        }
        int iWidth = this.d.width();
        return a(z ? iWidth / 5 : iWidth / 4, 1000);
    }

    public void a(int i, int i2, int i3, Rect rect, int i4) {
        Rect rect2 = new Rect(0, 0, i, i2);
        this.d = rect2;
        this.c = new b(i3, rect, i4, a(rect2));
    }
}
