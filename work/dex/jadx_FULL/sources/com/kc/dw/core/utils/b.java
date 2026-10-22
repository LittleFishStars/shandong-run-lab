package com.kc.dw.core.utils;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap<String, Integer> f39349a;
    public static PackageBean.AdBean b;
    public static int c;

    public static PackageBean.AdBean a() {
        PackageBean packageBean = o0.a().b;
        if (packageBean != null) {
            return packageBean.getAd();
        }
        return null;
    }

    public static PackageBean.LogBean b() {
        PackageBean packageBean = o0.a().b;
        if (packageBean != null) {
            return packageBean.getLog();
        }
        return null;
    }

    public static int c() {
        try {
            PackageBean.AdBean adBeanA = a();
            b = adBeanA;
            if (adBeanA == null || adBeanA.getSplash() == null) {
                return 0;
            }
            return b.getSplash().getVideoCacheTime();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int d() {
        try {
            PackageBean.AdBean adBeanA = a();
            b = adBeanA;
            if (adBeanA == null || adBeanA.getSplash() == null) {
                return 0;
            }
            return b.getSplash().getRs();
        } catch (Exception unused) {
            return 0;
        }
    }
}
