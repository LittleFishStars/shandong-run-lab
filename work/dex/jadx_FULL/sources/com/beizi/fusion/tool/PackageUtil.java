package com.beizi.fusion.tool;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class PackageUtil {
    private static PackageUtil instance;
    private volatile PackageInfo mPackageInfo;

    public static synchronized PackageUtil getInstance() {
        if (instance == null) {
            synchronized (PackageUtil.class) {
                instance = new PackageUtil();
            }
        }
        return instance;
    }

    public PackageInfo getPackageInfo(Context context) {
        if (this.mPackageInfo == null) {
            synchronized (PackageUtil.class) {
                if (this.mPackageInfo == null) {
                    try {
                        this.mPackageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                    } catch (PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                        this.mPackageInfo = null;
                    }
                }
            }
        }
        return this.mPackageInfo;
    }
}
