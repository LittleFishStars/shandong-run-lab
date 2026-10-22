package com.zj.adlib;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.imagepipeline.animated.factory.AnimatedDrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ur6 extends AbstractDraweeController<rm1<CloseableImage>, ImageInfo> {
    public static final Class<?> b = ur6.class;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f45217a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Supplier<DataSource<rm1<CloseableImage>>> f20130a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AnimatedDrawableFactory f20131a;

    public ur6(Resources resources, DeferredReleaser deferredReleaser, AnimatedDrawableFactory animatedDrawableFactory, Executor executor, Supplier<DataSource<rm1<CloseableImage>>> supplier, String str, Object obj) {
        super(deferredReleaser, executor, str, obj);
        this.f45217a = resources;
        this.f20131a = animatedDrawableFactory;
        v(supplier);
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public DataSource<rm1<CloseableImage>> getDataSource() {
        if (ad3.R(2)) {
            ad3.V(b, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
        }
        return this.f20130a.get();
    }

    public Resources getResources() {
        return this.f45217a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public void releaseDrawable(@Nullable Drawable drawable) {
        if (drawable instanceof DrawableWithCaches) {
            ((DrawableWithCaches) drawable).a();
        }
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public String toString() {
        return h76.f(this).f("super", super.toString()).f("dataSourceSupplier", this.f20130a).toString();
    }

    public final void v(Supplier<DataSource<rm1<CloseableImage>>> supplier) {
        this.f20130a = supplier;
    }

    public void w(Supplier<DataSource<rm1<CloseableImage>>> supplier, String str, Object obj) {
        super.initialize(str, obj);
        v(supplier);
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public Drawable createDrawable(rm1<CloseableImage> rm1Var) {
        ax6.o(rm1.F(rm1Var));
        CloseableImage closeableImageS = rm1Var.s();
        if (closeableImageS instanceof sm1) {
            sm1 sm1Var = (sm1) closeableImageS;
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f45217a, sm1Var.k());
            return (sm1Var.q() == 0 || sm1Var.q() == -1) ? bitmapDrawable : new ef6(bitmapDrawable, sm1Var.q());
        }
        AnimatedDrawableFactory animatedDrawableFactory = this.f20131a;
        if (animatedDrawableFactory != null) {
            return animatedDrawableFactory.a(closeableImageS);
        }
        throw new UnsupportedOperationException("Unrecognized image class: " + closeableImageS);
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public int getImageHash(@Nullable rm1<CloseableImage> rm1Var) {
        if (rm1Var != null) {
            return rm1Var.y();
        }
        return 0;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public ImageInfo getImageInfo(rm1<CloseableImage> rm1Var) {
        ax6.o(rm1.F(rm1Var));
        return rm1Var.s();
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public void releaseImage(@Nullable rm1<CloseableImage> rm1Var) {
        rm1.p(rm1Var);
    }
}
