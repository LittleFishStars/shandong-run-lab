package com.zj.adlib;

import android.content.res.Resources;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.imagepipeline.animated.factory.AnimatedDrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class xr6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Resources f45884a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DeferredReleaser f20711a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AnimatedDrawableFactory f20712a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Executor f20713a;

    public xr6(Resources resources, DeferredReleaser deferredReleaser, AnimatedDrawableFactory animatedDrawableFactory, Executor executor) {
        this.f45884a = resources;
        this.f20711a = deferredReleaser;
        this.f20712a = animatedDrawableFactory;
        this.f20713a = executor;
    }

    public ur6 a(Supplier<DataSource<rm1<CloseableImage>>> supplier, String str, Object obj) {
        return new ur6(this.f45884a, this.f20711a, this.f20712a, this.f20713a, supplier, str, obj);
    }
}
