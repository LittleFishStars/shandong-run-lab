package com.zj.adlib;

import android.app.Activity;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.bean.VersionUpgrade;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.dialog.VersionUpgradeDialog;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class eh9 {
    public static boolean a() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(2, -1);
        long time = calendar.getTime().getTime();
        i4a.c(s72.c(time, "yyyy/MM/dd HH:mm:ss SSS"));
        i4a.c(s72.c(r90.l().longValue(), "yyyy/MM/dd HH:mm:ss SSS"));
        return time - r90.l().longValue() > 0;
    }

    public static boolean b() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(5, -7);
        long time = calendar.getTime().getTime();
        i4a.c(s72.c(time, "yyyy/MM/dd HH:mm:ss SSS"));
        i4a.c(s72.c(r90.l().longValue(), "yyyy/MM/dd HH:mm:ss SSS"));
        return time - r90.l().longValue() > 0;
    }

    public static boolean c(VersionUpgrade versionUpgrade) {
        if (versionUpgrade == null) {
            return false;
        }
        i4a.a("newVersion:" + versionUpgrade.getNewVersion());
        i4a.a("appVersionName:8.7.7");
        i4a.a("appShowedVersion:" + r90.C());
        if ("8.7.7".equals(versionUpgrade.getNewVersion())) {
            return false;
        }
        if (versionUpgrade.isForceUpdate()) {
            return true;
        }
        int tipFrequency = versionUpgrade.getTipFrequency();
        if (tipFrequency == 1) {
            return !versionUpgrade.getNewVersion().equals(r90.C());
        }
        if (tipFrequency == 2) {
            return true;
        }
        if (tipFrequency == 3) {
            return b();
        }
        if (tipFrequency != 4) {
            return false;
        }
        return a();
    }

    public static void d(Activity activity, int code, VersionUpgrade versionUpgrade) {
        if (c(versionUpgrade)) {
            ARouter.getInstance().build(RoutePathConstants.Common.d).withParcelable(VersionUpgradeDialog.x, versionUpgrade).navigation(activity, code);
        }
    }

    public static void e(VersionUpgrade versionUpgrade) {
        if (c(versionUpgrade)) {
            ARouter.getInstance().build(RoutePathConstants.Common.d).withParcelable(VersionUpgradeDialog.x, versionUpgrade).navigation();
        }
    }
}
