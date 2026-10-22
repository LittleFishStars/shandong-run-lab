package com.huawei.hms.framework.common.check;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class ProviderCheckUtil {
    private static final String TAG = "ProviderCheckUtil";

    private static boolean checkSignaturesMatch(PackageManager packageManager, String str) {
        if (packageManager.checkSignatures("com.huawei.hwid", str) == 0) {
            Logger.v(TAG, "Valid Provider");
            return true;
        }
        if (packageManager.checkSignatures("com.huawei.hwid.tv", str) != 0) {
            return false;
        }
        Logger.v(TAG, "Valid Provider in tv");
        return true;
    }

    public static boolean isValid(Uri uri) {
        ApplicationInfo applicationInfo;
        if (uri == null) {
            return false;
        }
        PackageManager packageManager = ContextHolder.getAppContext().getPackageManager();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(uri.getAuthority(), 0);
        if (providerInfoResolveContentProvider == null || (applicationInfo = providerInfoResolveContentProvider.applicationInfo) == null) {
            Logger.w(TAG, "Invalid param");
            return false;
        }
        String str = applicationInfo.packageName;
        Logger.v(TAG, "Target provider service's package name is : " + str);
        if (str != null) {
            return checkSignaturesMatch(packageManager, str);
        }
        Logger.w(TAG, "Invalid packageName");
        return false;
    }
}
