package cn.hzjizhun.admin.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import cn.hzjizhun.admin.JZAdSdk;
import com.igexin.assist.util.AssistUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppStoreInfoUtils {
    private static final String STORE_PKG_HM = "com.huawei.hwid";
    private static final String STORE_PKG_HW = "com.huawei.appmarket";
    private static final String STORE_PKG_OPPO = "com.oppo.market";
    private static final String STORE_PKG_OPPO_NEW = "com.heytap.market";
    private static final String STORE_PKG_VIVO = "com.bbk.appstore";
    private static final String STORE_PKG_XM = "com.xiaomi.market";
    private static String mHmCoreVersion = "";
    private static int mHmCoreVersionCode;
    private static String mStoreVersion;
    private static int mStoreVersionCode;

    public static void getHarmonyVersion() {
        if (isHarmonyOs()) {
            try {
                PackageInfo packageInfo = JZAdSdk.getInstance().getContext().getPackageManager().getPackageInfo("com.huawei.hwid", 0);
                if (packageInfo != null) {
                    mHmCoreVersionCode = packageInfo.versionCode;
                    mHmCoreVersion = packageInfo.versionName;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static String getHmCoreVersion() {
        return mHmCoreVersion;
    }

    public static int getHmCoreVersionCode() {
        return mHmCoreVersionCode;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004c  */
    /* JADX WARN: Code duplicated, block: B:18:0x004d A[Catch: all -> 0x005e, TRY_LEAVE, TryCatch #0 {all -> 0x005e, blocks: (B:2:0x0000, B:15:0x0046, B:18:0x004d, B:6:0x0018, B:9:0x0027, B:12:0x0037), top: B:21:0x0000 }] */
    public static void getStoreInfo(Context context) {
        String str;
        try {
            getHarmonyVersion();
            String str2 = Build.BRAND;
            String str3 = "";
            if (str2.toLowerCase().contains("vivo")) {
                str = STORE_PKG_VIVO;
            } else if (str2.toLowerCase().contains("oppo")) {
                str = STORE_PKG_OPPO_NEW;
            } else {
                if (!str2.toLowerCase().contains("xiaomi")) {
                    if (str2.toLowerCase().contains(AssistUtils.BRAND_HW)) {
                        str = STORE_PKG_HW;
                    }
                    if (TextUtils.isEmpty(str3)) {
                        return;
                    }
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str3, 0);
                    mStoreVersion = packageInfo.versionName;
                    mStoreVersionCode = packageInfo.versionCode;
                }
                str = STORE_PKG_XM;
            }
            str3 = str;
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(str3, 0);
            mStoreVersion = packageInfo2.versionName;
            mStoreVersionCode = packageInfo2.versionCode;
        } catch (Throwable unused) {
        }
    }

    public static String getStoreVersion() {
        return mStoreVersion;
    }

    public static int getStoreVersionCode() {
        return mStoreVersionCode;
    }

    public static boolean isHarmonyOs() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return "Harmony".equalsIgnoreCase(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]).toString());
        } catch (Throwable unused) {
            return false;
        }
    }
}
