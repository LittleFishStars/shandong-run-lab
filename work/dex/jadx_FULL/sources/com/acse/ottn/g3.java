package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import com.igexin.assist.util.AssistUtils;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import java.io.ObjectStreamException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static g3 f23014a = null;
    public static String b = "OpenMobilePermissionUtil";

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f23015a;

        public a(AccessibilityService accessibilityService) {
            this.f23015a = accessibilityService;
        }

        @Override // java.lang.Runnable
        public void run() {
            h2.a(b5.f22883a, "悬浮窗 开始操作");
            b5.b(this.f23015a);
        }
    }

    public static g3 a() {
        if (f23014a == null) {
            synchronized (g3.class) {
                if (f23014a == null) {
                    f23014a = new g3();
                }
            }
        }
        return f23014a;
    }

    public boolean b() {
        String strB = p4.b();
        return AssistUtils.BRAND_HW.equals(strB) || AssistUtils.BRAND_HON.equals(strB) || "tdtech".equals(strB) || "tyh612m".equals(strB);
    }

    public boolean c() {
        String strB = p4.b();
        return AssistUtils.BRAND_HW.equals(strB) || AssistUtils.BRAND_HON.equals(strB) || "oppo".equals(strB) || "vivo".equals(strB) || "xiaomi".equals(strB) || "redmi".equals(strB) || "realme".equals(strB) || "oneplus".equals(strB) || "google".equals(strB) || "blackshark".equals(strB) || "samsung".equals(strB);
    }

    public boolean d() {
        return e() || c();
    }

    public boolean e() {
        return "tyh612m".equals(p4.p());
    }

    public final Object f() throws ObjectStreamException {
        return f23014a;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public boolean a(AccessibilityService accessibilityService, String str) {
        if (n3.a() == null) {
            return false;
        }
        str.hashCode();
        byte b2 = -1;
        switch (str.hashCode()) {
            case -1837416467:
                if (str.equals("com.iqoo.powersaving.fuelgauge.PowerRankActivity")) {
                    b2 = 0;
                }
                break;
            case -1818146895:
                if (str.equals("com.huawei.systemmanager.power.ui.DetailOfSoftConsumptionActivity")) {
                    b2 = 1;
                }
                break;
            case -1736638048:
                if (str.equals("com.oplusos.securitypermission.permission.PermissionGroupsActivity")) {
                    b2 = 2;
                }
                break;
            case -1711619133:
                if (str.equals("com.originui.widget.dialog.f")) {
                    b2 = 3;
                }
                break;
            case -1711619131:
                if (str.equals("com.originui.widget.dialog.h")) {
                    b2 = 4;
                }
                break;
            case -1697916220:
                if (str.equals("com.android.packageinstaller.permission.ui.AppPermissionActivity")) {
                    b2 = 5;
                }
                break;
            case -1510049100:
                if (str.equals("android.app.Dialog")) {
                    b2 = 6;
                }
                break;
            case -1508581269:
                if (str.equals("com.huawei.securitycenter.permission.ui.activity.PermissionSettingActivity")) {
                    b2 = 7;
                }
                break;
            case -1504769691:
                if (str.equals("com.iqoo.powersaving.PowerSavingManagerActivity")) {
                    b2 = 8;
                }
                break;
            case -1473395485:
                if (str.equals("com.miui.permcenter.autostart.AutoStartDetailManagementActivity")) {
                    b2 = 9;
                }
                break;
            case -1213771616:
                if (str.equals("com.huawei.security.permission.ui.activity.PermissionSettingActivity")) {
                    b2 = 10;
                }
                break;
            case -1180184559:
                if (str.equals("com.android.settings.HWSettings")) {
                    b2 = 11;
                }
                break;
            case -1150447007:
                if (str.equals("com.oplus.powermanager.fuelgaue.PowerControlActivity")) {
                    b2 = 12;
                }
                break;
            case -1138471325:
                if (str.equals("com.coloros.powermanager.fuelgaue.PowerControlActivity")) {
                    b2 = 13;
                }
                break;
            case -888547196:
                if (str.equals("com.android.settings.SubSettings")) {
                    b2 = com.google.common.base.a.p;
                }
                break;
            case -801027931:
                if (str.equals("com.hihonor.securitycenter.permission.ui.activity.MainActivity")) {
                    b2 = com.google.common.base.a.q;
                }
                break;
            case -694209271:
                if (str.equals("com.hihonor.systemmanager.power.ui.DetailOfSoftConsumptionActivity")) {
                    b2 = com.google.common.base.a.r;
                }
                break;
            case -687867595:
                if (str.equals("com.acse.ottn.activity.AccessibiltyVivoPermissionGreenActivity")) {
                    b2 = 17;
                }
                break;
            case -671860274:
                if (str.equals("com.android.settings.Settings$PasswordGuideActivity")) {
                    b2 = com.google.common.base.a.u;
                }
                break;
            case -638199557:
                if (str.equals("com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity")) {
                    b2 = 19;
                }
                break;
            case -590540374:
                if (str.equals("com.oplus.securepay.SecurePayMainActivity")) {
                    b2 = com.google.common.base.a.x;
                }
                break;
            case -520510470:
                if (str.equals("com.oplus.settings.feature.homepage.OplusSettingsHomepageActivity")) {
                    b2 = com.google.common.base.a.y;
                }
                break;
            case -347181517:
                if (str.equals("com.vivo.permissionmanager.activity.SoftPermissionDetailActivity")) {
                    b2 = com.google.common.base.a.z;
                }
                break;
            case -102088186:
                if (str.equals("com.coloros.securitypermission.permission.PermissionGroupsActivity")) {
                    b2 = com.google.common.base.a.A;
                }
                break;
            case -3605999:
                if (str.equals("com.huawei.systemmanager.appcontrol.activity.StartupAppControlActivity")) {
                    b2 = com.google.common.base.a.B;
                }
                break;
            case 335974848:
                if (str.equals("com.android.settings.Settings$AppAndNotificationDashboardActivity")) {
                    b2 = com.google.common.base.a.C;
                }
                break;
            case 362914745:
                if (str.equals("com.hihonor.systemmanager.appcontrol.activity.StartupAppControlActivity")) {
                    b2 = com.google.common.base.a.D;
                }
                break;
            case 366917116:
                if (str.equals("com.android.permissioncontroller.permission.ui.ManagePermissionsActivity")) {
                    b2 = com.google.common.base.a.E;
                }
                break;
            case 408505592:
                if (str.equals("com.huawei.security.permission.ui.activity.MainActivity")) {
                    b2 = com.google.common.base.a.F;
                }
                break;
            case 453087498:
                if (str.equals("com.android.settings.spa.SpaActivity")) {
                    b2 = com.google.common.base.a.G;
                }
                break;
            case 626548678:
                if (str.equals("com.android.settings.applications.InstalledAppDetailsTop")) {
                    b2 = com.google.common.base.a.H;
                }
                break;
            case 688371313:
                if (str.equals("com.oplus.settings.OplusSettingsActivity$AppSettingsActivity")) {
                    b2 = 31;
                }
                break;
            case 695606089:
                if (str.equals("com.android.permissioncontroller.permission.ui.GrantPermissionsActivity")) {
                    b2 = 32;
                }
                break;
            case 844891404:
                if (str.equals("com.miui.permcenter.permissions.PermissionAppsModifyActivity")) {
                    b2 = com.google.android.exoplayer2.text.cea.a.e;
                }
                break;
            case 1064378975:
                if (str.equals("com.vivo.applicationbehaviorengine.ui.ExcessivePowerManagerActivity")) {
                    b2 = 34;
                }
                break;
            case 1157708154:
                if (str.equals("com.oplusos.floatwindow.sysfloatwindow.FloatWindowListActivity")) {
                    b2 = 35;
                }
                break;
            case 1356567262:
                if (str.equals("com.vivo.permissionmanager.activity.BgStartUpManagerActivity")) {
                    b2 = 36;
                }
                break;
            case 1388125120:
                if (str.equals("com.android.settings.Settings$OverlaySettingsActivity")) {
                    b2 = com.google.android.exoplayer2.text.cea.a.g;
                }
                break;
            case 1535820958:
                if (str.equals("com.miui.permcenter.permissions.PermissionsEditorActivity")) {
                    b2 = com.google.android.exoplayer2.text.cea.a.h;
                }
                break;
            case 1570829571:
                if (str.equals("com.iqoo.powersaving.activity.ExcessivePowerManagerActivity")) {
                    b2 = com.google.android.exoplayer2.text.cea.a.i;
                }
                break;
            case 1577225874:
                if (str.equals("com.oplusos.securitypermission.permission.ui.handheld.PermissionAppsActivityNew")) {
                    b2 = MaterialProgressDrawable.c;
                }
                break;
            case 1647376138:
                if (str.equals("com.vivo.permissionmanager.activity.FloatWindowManagerActivity")) {
                    b2 = com.google.android.exoplayer2.text.cea.a.j;
                }
                break;
            case 1664890045:
                if (str.equals("com.miui.appmanager.ApplicationsDetailsActivity")) {
                    b2 = 42;
                }
                break;
            case 1722840595:
                if (str.equals("com.hihonor.securitycenter.permission.ui.activity.PermissionSettingActivity")) {
                    b2 = com.google.android.exoplayer2.text.cea.a.l;
                }
                break;
            case 1784217206:
                if (str.equals("com.miui.permcenter.settings.OtherPermissionsActivity")) {
                    b2 = com.google.android.exoplayer2.text.cea.a.m;
                }
                break;
            case 1799810893:
                if (str.equals("com.huawei.securitycenter.permission.ui.activity.MainActivity")) {
                    b2 = com.google.android.exoplayer2.text.cea.a.n;
                }
                break;
            case 1916443872:
                if (str.equals("com.coloros.floatwindow.sysfloatwindow.FloatWindowListActivity")) {
                    b2 = com.google.android.exoplayer2.text.cea.a.o;
                }
                break;
            case 2095881023:
                if (str.equals("com.android.settings.Settings$AppDrawOverlaySettingsActivity")) {
                    b2 = 47;
                }
                break;
            case 2141154850:
                if (str.equals("com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity")) {
                    b2 = com.alibaba.ariver.resource.parser.a.e.i;
                }
                break;
        }
        switch (b2) {
            case 0:
            case 8:
                b5.b();
                if (!n3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                n3.a().a("battery_white", Boolean.FALSE);
                b5.d(accessibilityService);
                return true;
            case 1:
            case 16:
                String strA = s0.d().a();
                String strE = n3.a().e("notification_data");
                String strA2 = n3.a().a("notification_data", "0");
                if (!strA.equals(strE) && strA2.equals("0")) {
                    n3.a().b("notification_data", strA);
                    s1.g(accessibilityService);
                }
                return true;
            case 2:
            case 23:
            case 27:
                String strB = p4.b();
                if ("samsung".equals(strB)) {
                    if (!n3.a().a("battery_white_samsung")) {
                        return true;
                    }
                } else if (!n3.a().a("battery_white")) {
                    return true;
                }
                h2.a(b, "oppo location");
                d.d().e(accessibilityService);
                n3 n3VarA = n3.a();
                Boolean bool = Boolean.FALSE;
                n3VarA.a("battery_white", bool);
                n3.a().a("battery_white_samsung", bool);
                if (!"realme".equals(strB) && !"oppo".equals(strB) && !"oneplus".equals(strB)) {
                    if (!AssistUtils.BRAND_HW.equals(strB) && !AssistUtils.BRAND_HON.equals(strB)) {
                        if ("samsung".equals(strB)) {
                            h2.a(b, "samsungoppo location");
                            d.d().e(accessibilityService);
                            n3.a().a("battery_white", bool);
                            f2.d(accessibilityService);
                        }
                    } else {
                        b.c().a(200L);
                        f2.b(accessibilityService);
                    }
                } else {
                    b.c().a(200L);
                    f2.m(accessibilityService);
                }
                return true;
            case 3:
            case 4:
                if (!n3.a().a("allow_button")) {
                    return true;
                }
                b5.c = "1";
                n3.a().a("allow_button", Boolean.FALSE);
                b.c().a(t0.b().b(100));
                AccessibilityNodeInfo accessibilityNodeInfoG = b.c().g(accessibilityService, "允许");
                if (accessibilityNodeInfoG != null) {
                    h2.a(b, "找到允许");
                    n3.a().a("correlation_start", Boolean.TRUE);
                    b.c().g(accessibilityNodeInfoG);
                    b.c().a(t0.b().b(300));
                    b5.h(accessibilityService);
                } else {
                    h2.a(b, "info1 is null");
                }
                return true;
            case 5:
                if (!n3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                n3.a().a("battery_white", Boolean.FALSE);
                f2.l(accessibilityService);
                return true;
            case 6:
                if (n3.a().a("battery_white") && "samsung".equals(p4.b())) {
                    d.d().e(accessibilityService);
                    n3.a().a("battery_white", Boolean.FALSE);
                    b.c().a(100L);
                    AccessibilityNodeInfo accessibilityNodeInfoH = b.c().h(accessibilityService, "允许");
                    if (accessibilityNodeInfoH != null) {
                        b.c().g(accessibilityNodeInfoH);
                    }
                }
                return true;
            case 7:
            case 10:
            case 43:
                if (!n3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                n3 n3VarA2 = n3.a();
                Boolean bool2 = Boolean.FALSE;
                n3VarA2.a("battery_white", bool2);
                if (n3.a().a("location_permission")) {
                    n3.a().a("location_permission", bool2);
                    f2.a(accessibilityService, false);
                } else {
                    s1.c(accessibilityService, false);
                }
                return true;
            case 9:
                if (!n3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                n3.a().a("battery_white", Boolean.FALSE);
                p2.i(accessibilityService);
                return true;
            case 11:
                if (!n3.a().a("battery_white")) {
                    return true;
                }
                n3.a().a("battery_white", Boolean.FALSE);
                s1.k(accessibilityService);
                return false;
            case 12:
            case 13:
                if (!n3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                n3.a().a("battery_white", Boolean.FALSE);
                h3.a(accessibilityService, System.currentTimeMillis());
                return true;
            case 14:
                String strB2 = p4.b();
                if (n3.a().a("pay_secure")) {
                    n3.a().a("pay_secure", Boolean.FALSE);
                    b.c().a(500L);
                    if (n3.a().e("sys_text").equals("系统安全") && Build.VERSION.SDK_INT == 35) {
                        n3.a().b("sys_text", "");
                        h3.p(accessibilityService);
                    } else {
                        h3.l(accessibilityService);
                    }
                } else if (n3.a().a("battery_white")) {
                    d.d().e(accessibilityService);
                    n3.a().a("battery_white", Boolean.FALSE);
                    if (("redmi".equals(strB2) || "xiaomi".equals(strB2)) && Build.VERSION.SDK_INT >= 30) {
                        p2.e(accessibilityService);
                    } else if ("oneplus".equals(strB2) || "oppo".equals(strB2) || "realme".equals(strB2)) {
                        if (!b.c().a()) {
                            e3.c(accessibilityService);
                        } else if (Build.VERSION.SDK_INT >= 35) {
                            h3.f(accessibilityService);
                        }
                    }
                }
                return true;
            case 15:
            case 28:
            case 45:
                if (!n3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                n3 n3VarA3 = n3.a();
                Boolean bool3 = Boolean.FALSE;
                n3VarA3.a("battery_white", bool3);
                if (n3.a().a("location_permission")) {
                    b.c().a(100L);
                    n3.a().a("location_permission", bool3);
                    f2.a(accessibilityService, true);
                } else {
                    s1.c(accessibilityService, true);
                }
                return true;
            case 17:
                b5.c();
                return true;
            case 18:
                if (!n3.a().a("pay_secure")) {
                    return true;
                }
                n3.a().b("sys_text", "");
                n3.a().a("pay_secure", Boolean.FALSE);
                b.c().a(300L);
                h3.p(accessibilityService);
                return true;
            case 19:
            case 24:
            case 26:
                h2.a(s1.f23181a, "find");
                if (!n3.a().a("battery_white")) {
                    h2.a(s1.f23181a, "battery_white is false");
                    return true;
                }
                d.d().e(accessibilityService);
                n3.a().a("battery_white", Boolean.FALSE);
                if (b()) {
                    h2.a(s1.f23181a, "ok");
                    s1.b(accessibilityService, true);
                }
                return true;
            case 20:
                if (!n3.a().a("pay_secure")) {
                    return true;
                }
                n3.a().a("pay_secure", Boolean.FALSE);
                b.c().a(300L);
                h3.m(accessibilityService);
                return true;
            case 21:
                if (n3.a().a("pay_secure")) {
                    n3.a().a("pay_secure", Boolean.FALSE);
                    h3.o(accessibilityService);
                } else if (n3.a().a("battery_white")) {
                    n3.a().a("battery_white", Boolean.FALSE);
                    h3.k(accessibilityService);
                }
                return true;
            case 22:
                if (!n3.a().a("battery_white")) {
                    h2.a(b5.f22883a, "悬浮窗 battery_white =false");
                    return true;
                }
                b5.c();
                d.d().e(accessibilityService);
                n3 n3VarA4 = n3.a();
                Boolean bool4 = Boolean.FALSE;
                n3VarA4.a("battery_white", bool4);
                h2.a(b5.f22883a, "悬浮窗 battery_white =true");
                if (n3.a().a("location_permission")) {
                    n3.a().a("location_permission", bool4);
                    b.c().a(200L);
                    f2.g(accessibilityService);
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(new a(accessibilityService), 500L);
                }
                return true;
            case 25:
                if (!n3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                n3 n3VarA5 = n3.a();
                Boolean bool5 = Boolean.FALSE;
                n3VarA5.a("battery_white", bool5);
                if (b()) {
                    if (n3.a().a("location_permission")) {
                        n3.a().a("location_permission", bool5);
                        f2.e(accessibilityService);
                    } else {
                        s1.c(accessibilityService);
                    }
                }
                return true;
            case 29:
            case 41:
                if (!n3.a().a("battery_white")) {
                    h2.a(b5.f22883a, "FloatWindowManagerActivity  battery_white= false");
                    return true;
                }
                h2.a(b5.f22883a, "FloatWindowManagerActivity  battery_white= true");
                d.d().e(accessibilityService);
                n3.a().a("battery_white", Boolean.FALSE);
                b5.a(accessibilityService, false);
                return true;
            case 30:
                if (!n3.a().a("battery_white")) {
                    return true;
                }
                String strB3 = p4.b();
                d.d().e(accessibilityService);
                n3 n3VarA6 = n3.a();
                Boolean bool6 = Boolean.FALSE;
                n3VarA6.a("battery_white", bool6);
                if ("oppo".equals(strB3) || "realme".equals(strB3) || "oneplus".equals(strB3)) {
                    if (n3.a().a("location_permission")) {
                        n3.a().a("location_permission", bool6);
                        b.c().a(300L);
                        f2.k(accessibilityService);
                    } else {
                        h3.d(accessibilityService);
                    }
                }
                return true;
            case 31:
                if (!n3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                n3.a().a("battery_white", Boolean.FALSE);
                if (Build.VERSION.SDK_INT >= 35) {
                    h3.f(accessibilityService);
                }
                break;
                break;
            case 32:
                if (!TextUtils.isEmpty(n3.a().e("sys_dialog_text"))) {
                    h3.n(accessibilityService);
                } else if (n3.a().a("pay_secure")) {
                    n3.a().a("pay_secure", Boolean.FALSE);
                    b.c().a(300L);
                    h3.q(accessibilityService);
                } else if (n3.a().a("click_state")) {
                    d.d().e(accessibilityService);
                    n3.a().a("battery_white", Boolean.FALSE);
                    f2.c(accessibilityService);
                }
                return true;
            case 33:
                if (!n3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                n3.a().a("battery_white", Boolean.FALSE);
                f2.a(accessibilityService, System.currentTimeMillis());
                return true;
            case 34:
            case 39:
                if (!n3.a().a("battery_white")) {
                    return true;
                }
                h2.a(b, "clickServiceBackgroundHight init");
                n3.a().a("battery_white", Boolean.FALSE);
                d.d().e(accessibilityService);
                b.c().a(200L);
                b5.a(accessibilityService, System.currentTimeMillis());
                return true;
            case 35:
            case 46:
                if (!n3.a().a("battery_white")) {
                    return true;
                }
                String strB4 = p4.b();
                d.d().e(accessibilityService);
                n3.a().a("battery_white", Boolean.FALSE);
                if ((!"realme".equals(strB4) && !"oppo".equals(strB4) && !"oneplus".equals(strB4)) || b.c().f()) {
                    return true;
                }
                h3.i(accessibilityService);
                return true;
            case 36:
                if (!n3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                n3.a().a("battery_white", Boolean.FALSE);
                b5.a(accessibilityService, true);
                return true;
            case 37:
                if (!n3.a().a("battery_white")) {
                    h2.a(b, "settings.Settings$OverlaySettingsActivity is fasle");
                    return true;
                }
                String strB5 = p4.b();
                h2.a(b, "settings.Settings$OverlaySettingsActivity is fasle");
                d.d().e(accessibilityService);
                n3.a().a("battery_white", Boolean.FALSE);
                if (!"redmi".equals(strB5) && !"xiaomi".equals(strB5) && !"blackshark".equals(strB5)) {
                    if ("oneplus".equals(strB5)) {
                        h2.a(b, "settings.Settings$OverlaySettingsActivity is oneplus");
                        b.c().a(true);
                        e3.f(accessibilityService);
                        return true;
                    }
                    if ("samsung".equals(strB5)) {
                        h2.a(b, "settings.Settings$OverlaySettingsActivity is samsung");
                        b.c().a(true);
                        y3.e(accessibilityService);
                        return true;
                    }
                    if (!"oppo".equals(strB5) && !"realme".equals(strB5)) {
                        if (b()) {
                            h2.a(b, "settings.Settings$OverlaySettingsActivity is huawei");
                            b.c().a(true);
                            s1.h(accessibilityService);
                        }
                    } else if (Build.VERSION.SDK_INT >= 33) {
                        h2.a(b, "settings.Settings$OverlaySettingsActivity is oppo");
                        b.c().a(true);
                        e3.f(accessibilityService);
                    }
                    return true;
                }
                h2.a(b, "settings.Settings$OverlaySettingsActivity is xiaomi");
                n3.a().a("battery_white", Boolean.TRUE);
                b.c().a(true);
                p2.j(accessibilityService);
                return true;
            case 38:
                if (!n3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                n3 n3VarA7 = n3.a();
                Boolean bool7 = Boolean.FALSE;
                n3VarA7.a("battery_white", bool7);
                h2.a(b, "clickHouTaiShowPage倒计时 =3" + n3.a().a("location_permission"));
                if (n3.a().a("location_permission")) {
                    n3.a().a("location_permission", bool7);
                    f2.h(accessibilityService);
                } else {
                    h2.a(b, "clickHouTaiShowPage倒计时 =1");
                    p2.d(accessibilityService);
                }
                return true;
            case 40:
                if (!n3.a().a("battery_white")) {
                    return true;
                }
                String strB6 = p4.b();
                d.d().e(accessibilityService);
                n3.a().a("battery_white", Boolean.FALSE);
                if ((!"realme".equals(strB6) && !"oppo".equals(strB6) && !"oneplus".equals(strB6)) || b.c().f()) {
                    return true;
                }
                h3.h(accessibilityService);
                return true;
            case 42:
                if (!n3.a().a("battery_white")) {
                    return true;
                }
                b.c().a(300L);
                d.d().e(accessibilityService);
                n3.a().a("battery_white", Boolean.FALSE);
                p2.b("自启动", accessibilityService);
                return true;
            case 44:
                if (!n3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                n3.a().a("battery_white", Boolean.FALSE);
                h2.a(b, "clickHouTaiShowPage倒计时 =2");
                p2.d(accessibilityService);
                return true;
            case 47:
                break;
            case 48:
                if (!n3.a().a("battery_white")) {
                    return true;
                }
                String strB7 = p4.b();
                d.d().e(accessibilityService);
                n3.a().a("battery_white", Boolean.FALSE);
                if ((!"oppo".equals(strB7) && !"realme".equals(strB7)) || b.c().f()) {
                    return true;
                }
                h3.j(accessibilityService);
                return true;
            default:
                return false;
        }
        String strB8 = p4.b();
        h2.a(b, "current phone is " + strB8);
        if (!n3.a().a("battery_white")) {
            return true;
        }
        d.d().e(accessibilityService);
        n3.a().a("battery_white", Boolean.FALSE);
        if (b()) {
            s1.a(accessibilityService, System.currentTimeMillis(), false);
        } else if ("vivo".equals(strB8)) {
            b5.c(accessibilityService);
        } else if (!"redmi".equals(strB8) && !"xiaomi".equals(strB8) && !"blackshark".equals(strB8)) {
            if ("oneplus".equals(strB8)) {
                e3.c(accessibilityService);
            }
        } else {
            p2.e(accessibilityService);
        }
        return true;
    }
}
