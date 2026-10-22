package com.zj.adlib;

import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.core.ExecutorSupplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class o60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AnimatedFactory f43675a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f18567a;

    public static AnimatedFactory a(PlatformBitmapFactory platformBitmapFactory, ExecutorSupplier executorSupplier) {
        if (!f18567a) {
            try {
                f43675a = (AnimatedFactory) Class.forName("com.facebook.imagepipeline.animated.factory.AnimatedFactoryImplSupport").getConstructor(PlatformBitmapFactory.class, ExecutorSupplier.class).newInstance(platformBitmapFactory, executorSupplier);
            } catch (Throwable unused) {
            }
            AnimatedFactory animatedFactory = f43675a;
            if (animatedFactory != null) {
                f18567a = true;
                return animatedFactory;
            }
            try {
                f43675a = (AnimatedFactory) Class.forName("com.facebook.imagepipeline.animated.factory.AnimatedFactoryImpl").getConstructor(PlatformBitmapFactory.class, ExecutorSupplier.class).newInstance(platformBitmapFactory, executorSupplier);
            } catch (Throwable unused2) {
            }
            f18567a = true;
        }
        return f43675a;
    }
}
