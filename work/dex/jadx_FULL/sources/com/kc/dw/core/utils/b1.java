package com.kc.dw.core.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.kc.dw.core.ad.BaseAdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static BaseAdSlot f39353a;

    public static boolean a(Context context) {
        BaseAdSlot baseAdSlot = f39353a;
        boolean z = false;
        if (baseAdSlot == null) {
            return false;
        }
        String packageName = baseAdSlot.getPackageName();
        try {
            if (TextUtils.isEmpty(packageName) || packageName.contains("://")) {
                Intent uri = Intent.parseUri(f39353a.getDeep_link(), 0);
                uri.addCategory("android.intent.category.BROWSABLE");
                uri.setComponent(null);
                uri.setSelector(null);
                if (uri.resolveActivity(com.kc.dw.base.a.getContext().getPackageManager()) != null) {
                    z = true;
                }
            } else if (context.getPackageManager().getPackageInfo(packageName, 256) != null) {
                z = true;
            }
        } catch (Exception unused) {
        }
        return z;
    }

    public static boolean b(Context context) {
        if (!TextUtils.isEmpty(f39353a.getWx_username()) && !TextUtils.isEmpty(f39353a.getWx_appid())) {
            try {
                if (context.getPackageManager().getPackageInfo("com.tencent.mm", 256) != null) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
