package com.alibaba.triver.preload;

import android.content.Context;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.Triver;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import com.alibaba.triver.kit.api.preload.tsr.TSRPreloadJob;
import com.alibaba.triver.point.OnPreloadPoint;
import com.alibaba.triver.preload.b.a.b;
import com.alibaba.triver.preload.b.e.d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f25122a = false;

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Context context) {
        if (f25122a) {
            return;
        }
        PreloadScheduler preloadScheduler = PreloadScheduler.getInstance();
        PreloadScheduler.PointType pointType = PreloadScheduler.PointType.PROCESS_CREATE;
        preloadScheduler.registerPreLoadJob(pointType, b.class);
        PreloadScheduler preloadScheduler2 = PreloadScheduler.getInstance();
        PreloadScheduler.PointType pointType2 = PreloadScheduler.PointType.CREATE_APP;
        preloadScheduler2.registerPreLoadJob(pointType2, d.class);
        PreloadScheduler preloadScheduler3 = PreloadScheduler.getInstance();
        PreloadScheduler.PointType pointType3 = PreloadScheduler.PointType.CLOSE_APP;
        preloadScheduler3.registerPreLoadJob(pointType3, d.class);
        PreloadScheduler.getInstance().registerPreLoadJob(pointType, com.alibaba.triver.preload.b.e.b.class);
        PreloadScheduler.getInstance().registerPreLoadJob(pointType3, com.alibaba.triver.preload.b.e.b.class);
        PreloadScheduler preloadScheduler4 = PreloadScheduler.getInstance();
        PreloadScheduler.PointType pointType4 = PreloadScheduler.PointType.AFTER_PAGE_LOADED;
        preloadScheduler4.registerPreLoadJob(pointType4, com.alibaba.triver.preload.b.e.b.class);
        PreloadScheduler.getInstance().registerPreLoadJob(pointType2, com.alibaba.triver.preload.b.e.a.class);
        PreloadScheduler.getInstance().registerPreLoadJob(PreloadScheduler.PointType.PROCESS_DIED, com.alibaba.triver.preload.b.b.a.class);
        PreloadScheduler.getInstance().registerPreLoadJob(pointType, com.alibaba.triver.preload.b.c.b.class);
        PreloadScheduler.getInstance().registerPreLoadJob(pointType3, com.alibaba.triver.preload.b.c.b.class);
        PreloadScheduler.getInstance().registerPreLoadJob(pointType4, com.alibaba.triver.preload.b.c.b.class);
        PreloadScheduler.getInstance().registerPreLoadJob(pointType, com.alibaba.triver.preload.b.e.b.class);
        PreloadScheduler.getInstance().registerPreLoadJob(pointType3, com.alibaba.triver.preload.b.e.b.class);
        PreloadScheduler.getInstance().registerPreLoadJob(PreloadScheduler.PointType.PRELOAD_RESOURCE, com.alibaba.triver.preload.b.c.a.class);
        PreloadScheduler.getInstance().registerPreLoadJob(pointType3, com.alibaba.triver.preload.b.c.a.class);
        PreloadScheduler.getInstance().registerPreLoadJob(pointType, com.alibaba.triver.preload.b.d.a.class);
        try {
            PreloadScheduler.getInstance().registerPreLoadJob(pointType, Class.forName("com.alibaba.triver.triver_shop.preload.ShopRenderPreloadJob"));
            PreloadScheduler.getInstance().registerPreLoadJob(pointType3, Class.forName("com.alibaba.triver.triver_shop.preload.ShopRenderPreloadJob"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            PreloadScheduler.getInstance().registerPreLoadJob(PreloadScheduler.PointType.PROCESS_CREATE, Class.forName("com.alibaba.triver.triver_shop.preload.ShopWorkerPreloadJob"));
            PreloadScheduler.getInstance().registerPreLoadJob(PreloadScheduler.PointType.CLOSE_APP, Class.forName("com.alibaba.triver.triver_shop.preload.ShopWorkerPreloadJob"));
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        try {
            PreloadScheduler.getInstance().registerPreLoadJob(PreloadScheduler.PointType.DATA_PREFETCH, Class.forName("com.alibaba.triver.kit.alibaba.prefetch.dataprefetch.TriverDataPrefetchJob"));
        } catch (ClassNotFoundException e3) {
            RVLogger.e("preload cloud", e3.getMessage());
        }
        try {
            PreloadScheduler.getInstance().registerPreLoadJob(PreloadScheduler.PointType.CREATE_ACTIVITY, Class.forName("com.alibaba.triver.triver_shop.preload.ShopWeexViewPreloadJob"));
        } catch (ClassNotFoundException e4) {
            RVLogger.e("preload", e4.getMessage());
        }
        try {
            PreloadScheduler.getInstance().registerPreLoadJob(PreloadScheduler.PointType.PROCESS_CREATE, Class.forName("com.alibaba.triver.triver_shop.preload.ComponentJsPreLoadJob"));
        } catch (ClassNotFoundException e5) {
            RVLogger.e("preload", e5.getMessage());
        }
        try {
            PreloadScheduler.getInstance().registerPreLoadJob(PreloadScheduler.PointType.PROCESS_CREATE, Class.forName("com.alibaba.triver.cannal_engine.preload.CanalResourcePreloadJob"));
        } catch (ClassNotFoundException e6) {
            RVLogger.e("preload", e6.getMessage());
        }
        PreloadScheduler.getInstance().registerPreLoadJob(PreloadScheduler.PointType.CREATE_ACTIVITY, TSRPreloadJob.class);
        if (Triver.isMainProcess(context)) {
            ((OnPreloadPoint) ExtensionPoint.as(OnPreloadPoint.class).create()).processCreatedPointPreload();
            ((OnPreloadPoint) ExtensionPoint.as(OnPreloadPoint.class).create()).resourcePointPreload();
        }
        f25122a = true;
    }
}
