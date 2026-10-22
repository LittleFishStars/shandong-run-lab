package com.zj.adlib;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class twa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f45017a = new File("/system/framework/amap.jar").exists();

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static AssetManager b(Context context) {
        if (context == null) {
            return null;
        }
        AssetManager assets = context.getAssets();
        if (f45017a) {
            try {
                assets.getClass().getDeclaredMethod("addAssetPath", String.class).invoke(assets, "/system/framework/amap.jar");
            } catch (Throwable th) {
                a7b.m(th, "ResourcesUtil", "getSelfAssets");
            }
        }
        return assets;
    }
}
