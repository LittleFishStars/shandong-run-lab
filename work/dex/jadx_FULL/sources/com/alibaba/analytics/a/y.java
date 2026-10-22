package com.alibaba.analytics.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.core.model.UTMCLogFields;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.ut.device.UTDevice;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class y {
    private static Map<String, String> z;

    private static String A() {
        String str = v.get("ro.aliyun.clouduuid");
        if (u.isEmpty(str)) {
            str = v.get("ro.sys.aliyun.clouduuid");
        }
        return u.isEmpty(str) ? B() : str;
    }

    private static String B() {
        try {
            return (String) Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String C() {
        try {
            Field declaredField = Build.class.getDeclaredField("YUNOS_BUILD_VERSION");
            if (declaredField == null) {
                return null;
            }
            declaredField.setAccessible(true);
            return (String) declaredField.get(new String());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void a(Context context, Map<String, String> map) {
        if (context == null || map == null) {
            return;
        }
        j.d("UTMCDevice", "updateDeviceNetworkStatus");
        try {
            String[] strArrM131a = com.alibaba.analytics.core.e.b.m131a(context);
            map.put(LogField.ACCESS.toString(), strArrM131a[0]);
            if (strArrM131a[0].equals(NetworkUtil.MOBILE_NETWORK)) {
                map.put(LogField.ACCESS_SUBTYPE.toString(), strArrM131a[1]);
            } else if (strArrM131a[1].equals("5G")) {
                map.put(LogField.ACCESS_SUBTYPE.toString(), "5G");
            } else {
                map.put(LogField.ACCESS_SUBTYPE.toString(), "Unknown");
            }
        } catch (Exception unused) {
            map.put(LogField.ACCESS.toString(), "Unknown");
            map.put(LogField.ACCESS_SUBTYPE.toString(), "Unknown");
        }
        map.put(LogField.CARRIER.toString(), com.alibaba.analytics.core.e.a.u());
    }

    public static synchronized Map<String, String> b(Context context) {
        Map<String, String> map = z;
        if (map != null) {
            return map;
        }
        if (context == null) {
            return null;
        }
        HashMap map2 = new HashMap();
        try {
            try {
                map2.put(LogField.UTDID.toString(), UTDevice.getUtdid(context));
            } catch (Exception unused) {
                Log.e("", "utdid4all jar doesn't exist");
            }
            map2.put(LogField.IMEI.toString(), o.getImei(context));
            map2.put(LogField.IMSI.toString(), o.getImsi(context));
            map2.put(LogField.DEVICE_MODEL.toString(), Build.MODEL);
            map2.put(LogField.BRAND.toString(), Build.BRAND);
            map2.put(LogField.OSVERSION.toString(), Build.VERSION.RELEASE);
            map2.put(LogField.OS.toString(), "a");
            try {
                map2.put(LogField.APPVERSION.toString(), context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName);
            } catch (PackageManager.NameNotFoundException unused2) {
                map2.put(LogField.APPVERSION.toString(), "Unknown");
            }
            if (r()) {
                map2.put(LogField.OS.toString(), "y");
                String strA = A();
                if (!u.isEmpty(strA)) {
                    map2.put(UTMCLogFields.DEVICE_ID.toString(), strA);
                }
                String property = System.getProperty("ro.yunos.version");
                if (!u.isEmpty(property)) {
                    map2.put(LogField.OSVERSION.toString(), property);
                }
                String strC = C();
                if (!u.isEmpty(strC)) {
                    map2.put(LogField.OSVERSION.toString(), strC);
                }
            }
            if (isYunOSTvSystem()) {
                map2.put(LogField.OS.toString(), "a");
            }
            try {
                Configuration configuration = new Configuration();
                Settings.System.getConfiguration(context.getContentResolver(), configuration);
                if (configuration.locale != null) {
                    map2.put(LogField.LANGUAGE.toString(), configuration.locale.toString());
                } else {
                    map2.put(LogField.LANGUAGE.toString(), "Unknown");
                }
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                int i = displayMetrics.widthPixels;
                int i2 = displayMetrics.heightPixels;
                if (i2 > i) {
                    map2.put(LogField.RESOLUTION.toString(), i2 + "*" + i);
                } else {
                    map2.put(LogField.RESOLUTION.toString(), i + "*" + i2);
                }
            } catch (Exception unused3) {
                map2.put(LogField.RESOLUTION.toString(), "Unknown");
            }
            a(context, map2);
            z = map2;
            return map2;
        } catch (Exception unused4) {
            return null;
        }
    }

    public static boolean d(Context context) {
        if (context == null) {
            return false;
        }
        return f(context) || e(context);
    }

    private static boolean e(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean f(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getPhoneType() == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean isYunOSTvSystem() {
        return (TextUtils.isEmpty(v.get("ro.yunos.product.chip")) && TextUtils.isEmpty(v.get("ro.yunos.hardware"))) ? false : true;
    }

    public static synchronized void k(Context context) {
        a(context, z);
    }

    private static boolean r() {
        if ((System.getProperty("java.vm.name") == null || !System.getProperty("java.vm.name").toLowerCase().contains("lemur")) && TextUtils.isEmpty(System.getProperty("ro.yunos.version")) && TextUtils.isEmpty(v.get("ro.yunos.build.version"))) {
            return isYunOSTvSystem();
        }
        return true;
    }
}
