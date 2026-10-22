package com.acse.ottn;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.acse.ottn.util.HelpShopAppUtil;
import com.ali.auth.third.core.model.KernelMessageConstants;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.igexin.assist.util.AssistUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f22947a = "isHuawei";
    public static final String b = "isXiaomi";
    public static final String c = "isOppo";
    public static final String d = "isVivo";
    public static final String e = "isMeizu";
    public static final String f = "isSamsung";
    public static final String g = "isLetv";
    public static final String h = "isSmartisan";
    public static volatile d5 i;

    public static d5 a() {
        if (i == null) {
            synchronized (d5.class) {
                if (i == null) {
                    i = new d5();
                }
            }
        }
        return i;
    }

    public boolean b(String str) {
        if ("".equals(str)) {
            return true;
        }
        String strB = p4.b();
        if ("xiaomi".equals(strB) || "redmi".equals(strB) || "blackshark".equals(strB)) {
            return Build.VERSION.SDK_INT >= 36 ? n3.a().a("open_battery_white") : a(str);
        }
        if ("samsung".equals(strB)) {
            PowerManager powerManager = (PowerManager) HelpShopAppUtil.getContext().getSystemService("power");
            if (powerManager != null) {
                return powerManager.isIgnoringBatteryOptimizations(str);
            }
        } else if ("oppo".equals(strB) || "realme".equals(strB) || "oneplus".equals(strB)) {
            boolean zA = n3.a().a("open_battery_white");
            PowerManager powerManager2 = (PowerManager) HelpShopAppUtil.getContext().getSystemService("power");
            if (powerManager2 != null) {
                return powerManager2.isIgnoringBatteryOptimizations(str) || zA;
            }
        }
        return n3.a().a("open_battery_white");
    }

    @RequiresApi(api = 19)
    public boolean a(String str) {
        AppOpsManager appOpsManager = (AppOpsManager) HelpShopAppUtil.getContext().getSystemService("appops");
        try {
            Class<?> cls = appOpsManager.getClass();
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(KernelMessageConstants.USER_CANCEL), Integer.valueOf(Process.myUid()), str)).intValue() == 0;
        } catch (Exception unused) {
            return true;
        }
    }

    public void a(Activity activity, String str) {
        String strB = p4.b();
        if (n3.a() != null) {
            n3.a().b(ALPParamConstant.PACKAGENAME, str);
            n3 n3VarA = n3.a();
            Boolean bool = Boolean.TRUE;
            n3VarA.a("battery_white", bool);
            n3.a().a("open_battery_white", bool);
        }
        if (o1.c().e()) {
            if (!n3.a().a("open_battery_white_size")) {
                n3.a().a("open_battery_white_size", Boolean.TRUE);
                n3.a().a("open_battery_white", Boolean.FALSE);
            } else {
                q2.b().a("no_find_auto_start");
                n3.a().a("open_battery_white", Boolean.TRUE);
            }
            if (AssistUtils.BRAND_HON.equals(strB) && Build.VERSION.SDK_INT >= 36) {
                s1.b(activity);
                return;
            } else {
                s1.a(activity);
                return;
            }
        }
        if ("vivo".equals(strB)) {
            b5.b(activity);
            return;
        }
        if (!"oppo".equals(strB) && !"realme".equals(strB)) {
            if ("samsung".equals(strB)) {
                try {
                    Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                    intent.setData(Uri.parse("package:" + str));
                    activity.startActivityForResult(intent, 10013);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (!"xiaomi".equals(strB) && !"redmi".equals(strB) && !"blackshark".equals(strB)) {
                if ("oneplus".equals(strB)) {
                    Intent intent2 = new Intent();
                    intent2.addFlags(268435456);
                    intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent2.setData(Uri.fromParts("package", str, null));
                    activity.startActivityForResult(intent2, 10013);
                    return;
                }
                h2.b("WhiteListPermission", "current phone is no open battery white");
                n3.a().a("open_battery_white", Boolean.TRUE);
                return;
            }
            if (n3.a() != null) {
                n3.a().b("OpenPermissionName", "后台弹出界面");
            }
            p2.b(activity);
            return;
        }
        h3.a(activity);
    }

    public boolean b() {
        if (!"vivo".equals(p4.b())) {
            return false;
        }
        PowerManager powerManager = (PowerManager) HelpShopAppUtil.getContext().getSystemService("power");
        boolean zIsIgnoringBatteryOptimizations = powerManager != null ? powerManager.isIgnoringBatteryOptimizations(HelpShopAppUtil.getContext().getPackageName()) : false;
        String strE = n3.a().e("battery_hignt_size");
        Log.d("samon-->", "isIgnoring =" + zIsIgnoringBatteryOptimizations + ",size = " + strE);
        return strE.equals("2") || zIsIgnoringBatteryOptimizations;
    }
}
