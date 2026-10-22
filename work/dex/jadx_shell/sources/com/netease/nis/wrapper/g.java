package com.netease.nis.wrapper;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.content.ContentProvider;
import android.content.Intent;
import android.content.pm.ApplicationInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/peek/classes.dex */
@TargetApi(28)
public final class g extends AppComponentFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AppComponentFactory f8a = null;
    private String b = "";
    private String c = "";
    private String d = a.auu.a.c("LQoZSwkGBC0NEQsLGgBgFhwEDxcKIAIrFgIbCiEJ");
    private boolean e = false;

    private synchronized AppComponentFactory a(ClassLoader classLoader) {
        if (this.f8a == null && this.c != null && !"".equals(this.c)) {
            try {
                this.f8a = (AppComponentFactory) classLoader.loadClass(this.c).newInstance();
            } catch (Exception e) {
            }
        }
        return this.f8a;
    }

    private void a(ClassLoader classLoader, ApplicationInfo applicationInfo) {
        if (this.e) {
            return;
        }
        f.a(classLoader, applicationInfo);
        ClassLoader classLoaderCl = MyJni.cl(classLoader, applicationInfo, this.d);
        applicationInfo.className = this.b;
        this.e = true;
        String str = MyApplication.TAG;
        new StringBuilder(a.auu.a.c("HhcbHRgwCiMVGwsEHREIBBcRDgEcbgwaDBVfRS0JFRYSPwovAREXQU5F")).append(classLoaderCl);
    }

    @Override // android.app.AppComponentFactory
    public final Activity instantiateActivity(ClassLoader classLoader, String str, Intent intent) {
        String str2 = MyApplication.TAG;
        AppComponentFactory appComponentFactoryA = a(classLoader);
        return appComponentFactoryA != null ? appComponentFactoryA.instantiateActivity(classLoader, str, intent) : super.instantiateActivity(classLoader, str, intent);
    }

    @Override // android.app.AppComponentFactory
    public final Application instantiateApplication(ClassLoader classLoader, String str) {
        String str2 = MyApplication.TAG;
        a(classLoader, f.a());
        if (str.equals(MyApplication.class.getName())) {
            str = this.b;
        }
        AppComponentFactory appComponentFactoryA = a(classLoader);
        return appComponentFactoryA != null ? appComponentFactoryA.instantiateApplication(classLoader, str) : super.instantiateApplication(classLoader, str);
    }

    @Override // android.app.AppComponentFactory
    @TargetApi(29)
    public final ClassLoader instantiateClassLoader(ClassLoader classLoader, ApplicationInfo applicationInfo) {
        String str = MyApplication.TAG;
        new StringBuilder(a.auu.a.c("JwsHEQAdEScEAAAiHwQ9FjgKABcAPF8=")).append(classLoader.toString());
        a(classLoader, applicationInfo);
        AppComponentFactory appComponentFactoryA = a(classLoader);
        return appComponentFactoryA != null ? appComponentFactoryA.instantiateClassLoader(classLoader, applicationInfo) : super.instantiateClassLoader(classLoader, applicationInfo);
    }

    @Override // android.app.AppComponentFactory
    public final ContentProvider instantiateProvider(ClassLoader classLoader, String str) {
        String str2 = MyApplication.TAG;
        AppComponentFactory appComponentFactoryA = a(classLoader);
        return appComponentFactoryA != null ? appComponentFactoryA.instantiateProvider(classLoader, str) : super.instantiateProvider(classLoader, str);
    }
}
