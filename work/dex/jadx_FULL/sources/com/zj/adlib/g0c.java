package com.zj.adlib;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.images.b;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class g0c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f41794a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final ParcelFileDescriptor f16672a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ImageManager f16673a;

    public g0c(ImageManager imageManager, @Nullable Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
        this.f16673a = imageManager;
        this.f41794a = uri;
        this.f16672a = parcelFileDescriptor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        tb0.b("LoadBitmapFromDiskRunnable can't be executed in the main thread");
        ParcelFileDescriptor parcelFileDescriptor = this.f16672a;
        Bitmap bitmapDecodeFileDescriptor = null;
        boolean z = false;
        if (parcelFileDescriptor != null) {
            try {
                bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
            } catch (OutOfMemoryError e) {
                Log.e("ImageManager", "OOM while loading bitmap for uri: ".concat(String.valueOf(this.f41794a)), e);
                z = true;
            }
            try {
                this.f16672a.close();
            } catch (IOException e2) {
                Log.e("ImageManager", "closed failed", e2);
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ImageManager imageManager = this.f16673a;
        imageManager.f5643a.post(new b(imageManager, this.f41794a, bitmapDecodeFileDescriptor, z, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            Log.w("ImageManager", "Latch interrupted while posting ".concat(String.valueOf(this.f41794a)));
        }
    }
}
