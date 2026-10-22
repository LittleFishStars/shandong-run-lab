package com.zj.adlib;

import android.graphics.Bitmap;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.QualityInfo;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ThreadSafe
public class sm1 extends CloseableBitmap {
    public final int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Bitmap f44716a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final QualityInfo f19607a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("this")
    public rm1<Bitmap> f19608a;

    public sm1(Bitmap bitmap, ResourceReleaser<Bitmap> resourceReleaser, QualityInfo qualityInfo, int i) {
        this.f44716a = (Bitmap) ax6.i(bitmap);
        this.f19608a = rm1.J(this.f44716a, (ResourceReleaser) ax6.i(resourceReleaser));
        this.f19607a = qualityInfo;
        this.K = i;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        rm1<Bitmap> rm1VarP = p();
        if (rm1VarP != null) {
            rm1VarP.close();
        }
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public QualityInfo g() {
        return this.f19607a;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getHeight() {
        Bitmap bitmap = this.f44716a;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getWidth() {
        Bitmap bitmap = this.f44716a;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public int h() {
        return qw0.e(this.f44716a);
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public synchronized boolean isClosed() {
        return this.f19608a == null;
    }

    @Override // com.facebook.imagepipeline.image.CloseableBitmap
    public Bitmap k() {
        return this.f44716a;
    }

    public synchronized rm1<Bitmap> l() {
        ax6.j(this.f19608a, "Cannot convert a closed static bitmap");
        return p();
    }

    public final synchronized rm1<Bitmap> p() {
        rm1<Bitmap> rm1Var;
        rm1Var = this.f19608a;
        this.f19608a = null;
        this.f44716a = null;
        return rm1Var;
    }

    public int q() {
        return this.K;
    }

    public sm1(rm1<Bitmap> rm1Var, QualityInfo qualityInfo, int i) {
        rm1<Bitmap> rm1Var2 = (rm1) ax6.i(rm1Var.k());
        this.f19608a = rm1Var2;
        this.f44716a = rm1Var2.s();
        this.f19607a = qualityInfo;
        this.K = i;
    }
}
