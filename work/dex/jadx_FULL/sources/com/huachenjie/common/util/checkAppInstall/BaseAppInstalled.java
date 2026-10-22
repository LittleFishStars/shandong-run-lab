package com.huachenjie.common.util.checkAppInstall;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class BaseAppInstalled {
    public boolean a(Context context) {
        try {
            String packageName = getPackageName();
            return context.getPackageManager().getPackageInfo(packageName, 64) != null && b(context, packageName);
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            return false;
        }
    }

    public final boolean b(Context context, String packageName) {
        Signature[] signatureArr = new Signature[0];
        try {
            signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        for (Signature signature : signatureArr) {
            if (signature.toCharsString().toLowerCase().equals(getSignature())) {
                return true;
            }
        }
        return false;
    }

    public abstract String getPackageName();

    public abstract String getSignature();
}
