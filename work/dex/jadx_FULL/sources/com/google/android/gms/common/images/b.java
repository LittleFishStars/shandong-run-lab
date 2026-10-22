package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.zj.adlib.tb0;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Bitmap f31282a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Uri f5648a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ImageManager f5649a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CountDownLatch f5650a;

    public b(ImageManager imageManager, @Nullable Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
        this.f5649a = imageManager;
        this.f5648a = uri;
        this.f31282a = bitmap;
        this.f5650a = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        tb0.a("OnBitmapLoadedRunnable must be executed in the main thread");
        Bitmap bitmap = this.f31282a;
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) this.f5649a.b.remove(this.f5648a);
        if (imageReceiver != null) {
            ArrayList arrayList = imageReceiver.zac;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zag zagVar = (zag) arrayList.get(i);
                Bitmap bitmap2 = this.f31282a;
                if (bitmap2 == null || bitmap == null) {
                    this.f5649a.c.put(this.f5648a, Long.valueOf(SystemClock.elapsedRealtime()));
                    ImageManager imageManager = this.f5649a;
                    zagVar.a(imageManager.f5642a, imageManager.f5644a, false);
                } else {
                    zagVar.b(this.f5649a.f5642a, bitmap2, false);
                }
                if (!(zagVar instanceof c)) {
                    this.f5649a.f5645a.remove(zagVar);
                }
            }
        }
        this.f5650a.countDown();
        synchronized (ImageManager.f5640a) {
            ImageManager.f5641a.remove(this.f5648a);
        }
    }
}
