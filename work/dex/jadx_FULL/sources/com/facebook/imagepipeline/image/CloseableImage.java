package com.facebook.imagepipeline.image;

import com.zj.adlib.ad3;
import com.zj.adlib.p84;
import java.io.Closeable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class CloseableImage implements Closeable, ImageInfo {
    public static final String f = "CloseableImage";

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public void finalize() throws Throwable {
        if (isClosed()) {
            return;
        }
        ad3.q0(f, "finalize: %s %x still open.", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public QualityInfo g() {
        return p84.f43926a;
    }

    public abstract int h();

    public abstract boolean isClosed();

    public boolean j() {
        return false;
    }
}
