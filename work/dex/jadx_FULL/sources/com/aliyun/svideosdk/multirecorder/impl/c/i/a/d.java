package com.aliyun.svideosdk.multirecorder.impl.c.i.a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d implements com.aliyun.svideosdk.multirecorder.impl.c.i.a.c<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f25810a = new Handler(Looper.getMainLooper());

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.aliyun.svideosdk.multirecorder.impl.c.i.a.c.a f25811a;

        public a(d dVar, com.aliyun.svideosdk.multirecorder.impl.c.i.a.c.a aVar) {
            this.f25811a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f25811a.a(null);
        }
    }

    public class b implements PixelCopy.OnPixelCopyFinishedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.aliyun.svideosdk.multirecorder.impl.c.i.a.c.a f25812a;
        final /* synthetic */ Bitmap b;

        public b(com.aliyun.svideosdk.multirecorder.impl.c.i.a.c.a aVar, Bitmap bitmap) {
            this.f25812a = aVar;
            this.b = bitmap;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public void onPixelCopyFinished(int i) {
            d.this.a(i, this.f25812a, this.b);
        }
    }

    public class c implements PixelCopy.OnPixelCopyFinishedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.aliyun.svideosdk.multirecorder.impl.c.i.a.c.a f25813a;
        final /* synthetic */ Bitmap b;

        public c(com.aliyun.svideosdk.multirecorder.impl.c.i.a.c.a aVar, Bitmap bitmap) {
            this.f25813a = aVar;
            this.b = bitmap;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public void onPixelCopyFinished(int i) {
            d.this.a(i, this.f25813a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.aliyun.svideosdk.multirecorder.impl.c.i.a.c.a<Bitmap> aVar, Bitmap bitmap) {
        if (i == 0) {
            aVar.a(bitmap);
        } else {
            aVar.a(null);
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.i.a.c
    public String a() {
        return "PixelCopy";
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.i.a.c
    public void a(View view, com.aliyun.svideosdk.multirecorder.impl.c.i.a.c.a<Bitmap> aVar) {
        if (!view.isAttachedToWindow()) {
            f25810a.post(new a(this, aVar));
            return;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        if (view instanceof SurfaceView) {
            PixelCopy.request((SurfaceView) view, (Rect) null, bitmapCreateBitmap, new b(aVar, bitmapCreateBitmap), f25810a);
            return;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        Window window = ((Activity) view.getContext()).getWindow();
        int i = iArr[0];
        PixelCopy.request(window, new Rect(i, iArr[1], view.getWidth() + i, iArr[1] + view.getHeight()), bitmapCreateBitmap, new c(aVar, bitmapCreateBitmap), f25810a);
    }
}
