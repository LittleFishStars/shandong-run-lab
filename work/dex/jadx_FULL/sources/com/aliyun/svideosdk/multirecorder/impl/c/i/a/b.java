package com.aliyun.svideosdk.multirecorder.impl.c.i.a;

import android.graphics.Bitmap;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements c<Bitmap> {
    @Override // com.aliyun.svideosdk.multirecorder.impl.c.i.a.c
    public String a() {
        return "DrawingCache";
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.i.a.c
    public void a(View view, c.a<Bitmap> aVar) {
        boolean zIsDrawingCacheEnabled = view.isDrawingCacheEnabled();
        if (zIsDrawingCacheEnabled) {
            view.destroyDrawingCache();
        } else {
            view.setDrawingCacheEnabled(true);
        }
        Bitmap drawingCache = view.getDrawingCache(true);
        Bitmap bitmapCreateBitmap = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
        view.setDrawingCacheEnabled(zIsDrawingCacheEnabled);
        aVar.a(bitmapCreateBitmap);
    }
}
