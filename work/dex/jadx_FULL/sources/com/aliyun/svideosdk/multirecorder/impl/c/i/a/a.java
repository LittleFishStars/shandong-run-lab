package com.aliyun.svideosdk.multirecorder.impl.c.i.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements c<Bitmap> {
    @Override // com.aliyun.svideosdk.multirecorder.impl.c.i.a.c
    public String a() {
        return "DrawCanvas";
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.i.a.c
    public void a(View view, c.a<Bitmap> aVar) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        view.computeScroll();
        canvas.translate(view.getScrollX() * (-1), view.getScrollY() * (-1));
        view.draw(canvas);
        aVar.a(bitmapCreateBitmap);
    }
}
