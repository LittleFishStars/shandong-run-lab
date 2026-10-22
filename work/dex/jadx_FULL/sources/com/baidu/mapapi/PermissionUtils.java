package com.baidu.mapapi;

import com.baidu.mapsdkplatform.comapi.util.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class PermissionUtils {

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final PermissionUtils f26482a = new PermissionUtils();
    }

    public static PermissionUtils getInstance() {
        return b.f26482a;
    }

    public boolean isBWNaviInfoAuthorized() {
        return c.a().b();
    }

    public boolean isBWNaviMultiMapAuthorized() {
        return c.a().c();
    }

    public boolean isBWNaviTrafficLightAuthorized() {
        return c.a().d();
    }

    public boolean isEnglishMapAuthorized() {
        return c.a().e();
    }

    public boolean isEnglishWalkBikeNaviAuthorized() {
        return c.a().f();
    }

    public boolean isIndoorNaviAuthorized() {
        return c.a().g();
    }

    public boolean isIntegralRoutePlanAuthorized() {
        return c.a().h();
    }

    public boolean isWalkARNaviAuthorized() {
        return c.a().i();
    }

    private PermissionUtils() {
    }
}
