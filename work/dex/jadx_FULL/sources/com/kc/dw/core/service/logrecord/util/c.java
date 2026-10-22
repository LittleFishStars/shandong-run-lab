package com.kc.dw.core.service.logrecord.util;

import com.kc.dw.core.router.log.bean.TypeMsg;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.platform.BasePlatformLoader;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f39323a = 0;

    public static BasePlatformLoader a(com.kc.dw.core.loader.b bVar) {
        if (bVar instanceof BasePlatformLoader) {
            return (BasePlatformLoader) bVar;
        }
        return null;
    }

    public static void b(com.kc.dw.core.loader.b bVar) {
        if (bVar != null) {
            try {
                if (a(bVar) == null || com.kc.dw.core.service.logrecord.b.a(bVar, "e5")) {
                    return;
                }
                int i = (!a(bVar).isMSPlatform() || a(bVar).isAutoRender()) ? 1 : 2;
                LogUtil.dev("c", "add e5");
                com.kc.dw.core.service.logrecord.a.a(5, "e5", bVar, new TypeMsg().setData(i));
            } catch (Exception unused) {
            }
        }
    }

    public static void c(com.kc.dw.core.loader.b bVar) {
        if (bVar != null) {
            try {
                if (a(bVar) == null || com.kc.dw.core.service.logrecord.b.a(bVar, "e6")) {
                    return;
                }
                LogUtil.dev("c", "add e6");
                com.kc.dw.core.service.logrecord.a.a(5, "e6", bVar);
            } catch (Exception unused) {
            }
        }
    }

    public static void d(com.kc.dw.core.loader.b bVar) {
        if (bVar != null) {
            try {
                if (a(bVar) == null || com.kc.dw.core.service.logrecord.b.a(bVar, "e7")) {
                    return;
                }
                LogUtil.dev("c", "add e7");
                com.kc.dw.core.service.logrecord.a.a(5, "e7", bVar);
            } catch (Exception unused) {
            }
        }
    }
}
