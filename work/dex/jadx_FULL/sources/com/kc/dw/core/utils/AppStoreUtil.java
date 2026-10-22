package com.kc.dw.core.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.kc.dw.core.safe.SafeBroadcastReceiver;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class AppStoreUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f39335a = "";
    public static String[] b;
    public static String[] c;
    public static String[] d;

    @Keep
    public static class InstallReceiver extends SafeBroadcastReceiver {
        @Override // com.kc.dw.core.safe.SafeBroadcastReceiver
        public void a(Context context, Intent intent) {
            try {
                context.getPackageManager();
                if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
                    String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                    LogUtil.d("AppStoreUtil", "onReceive:  app_added  " + schemeSpecificPart);
                    int intExtra = intent.getIntExtra("android.content.pm.extra.STATUS", 0);
                    String str = AppStoreUtil.f39335a;
                    if (str == null || !TextUtils.equals(schemeSpecificPart, str)) {
                        return;
                    }
                    try {
                        String[] strArr = AppStoreUtil.b;
                        if (strArr != null) {
                            LogUtil.d("AppStoreUtil", "Report send dn_succ");
                            for (String str2 : strArr) {
                                if (!TextUtils.isEmpty(str2)) {
                                    z.a((Context) null, str2, new j());
                                }
                            }
                        }
                        LogUtil.d("AppStoreUtil", "onDownloaded: 下载完成");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        String[] strArr2 = AppStoreUtil.c;
                        if (strArr2 != null) {
                            LogUtil.d("AppStoreUtil", "Report send dn_inst_start");
                            for (String str3 : strArr2) {
                                if (!TextUtils.isEmpty(str3)) {
                                    z.a((Context) null, str3, new j());
                                }
                            }
                        }
                        LogUtil.d("AppStoreUtil", "onInstallStart: 开始安装");
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (intExtra == 1) {
                        LogUtil.d("AppStoreUtil", "install fail ");
                    } else {
                        LogUtil.d("AppStoreUtil", "install success ");
                        try {
                            String[] strArr3 = AppStoreUtil.d;
                            if (strArr3 != null) {
                                LogUtil.d("AppStoreUtil", "Report send dn_inst_succ");
                                for (String str4 : strArr3) {
                                    if (!TextUtils.isEmpty(str4)) {
                                        z.a((Context) null, str4, new j());
                                    }
                                }
                            }
                            LogUtil.d("AppStoreUtil", "onInstallStart: 安装成功");
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    AppStoreUtil.f39335a = null;
                    AppStoreUtil.b = null;
                    AppStoreUtil.c = null;
                    AppStoreUtil.d = null;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }
}
