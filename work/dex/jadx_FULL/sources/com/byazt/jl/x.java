package com.byazt.jl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.byazt.on.a;
import com.byazt.on.sp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 157, 71})
public abstract class x<R extends com.byazt.on.a, W extends com.byazt.on.sp> {
    public int da;
    public int i;
    public int sl;
    public final R sp;
    public int t;
    public int x;
    public final Rect u = new Rect();
    public final Rect yp = new Rect();

    public x(R r) {
        this.sp = r;
    }

    public abstract Bitmap c(Canvas canvas, Paint paint, int i, Bitmap bitmap, W w);
}
