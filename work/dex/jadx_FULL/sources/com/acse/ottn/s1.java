package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.util.HelpShopAppUtil;
import com.igexin.assist.util.AssistUtils;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f23181a = "acse_HuaweiUtils";
    public static boolean b = true;
    public static TimerTask d;
    public static TimerTask h;
    public static Long c = 0L;
    public static AccessibilityNodeInfo e = null;
    public static AccessibilityNodeInfo f = null;
    public static final String g = o1.c().b();

    @SuppressLint({"NewApi"})
    public static void d(AccessibilityService accessibilityService, boolean z) {
        f = null;
        f(accessibilityService, z);
    }

    @SuppressLint({"NewApi"})
    public static void e(AccessibilityService accessibilityService) {
        g(accessibilityService.getRootInActiveWindow());
    }

    @SuppressLint({"NewApi"})
    public static void f(AccessibilityService accessibilityService) {
        i(accessibilityService.getRootInActiveWindow());
    }

    @SuppressLint({"NewApi"})
    public static void g(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i2 = 0; i2 < accessibilityNodeInfo.getChildCount(); i2++) {
                if (accessibilityNodeInfo.getChild(i2) != null) {
                    h2.a(f23181a, accessibilityNodeInfo.getChild(i2).toString());
                }
                if (accessibilityNodeInfo.getChild(i2) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i2).getClassName())) {
                    e = accessibilityNodeInfo.getChild(i2);
                    return;
                } else {
                    if (accessibilityNodeInfo.getChild(i2) != null) {
                        g(accessibilityNodeInfo.getChild(i2));
                    }
                }
            }
        }
    }

    @RequiresApi(api = 16)
    public static void h(AccessibilityService accessibilityService) {
        h2.a(f23181a, "openHonorFlowWindowPermission");
        d = n0.a().b(t0.b().b(10000), t0.b().b(400), new e(accessibilityService, o1.c().b()));
    }

    @SuppressLint({"NewApi"})
    public static void i(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) {
            if (accessibilityNodeInfo != null) {
                for (int i2 = 0; i2 < accessibilityNodeInfo.getChildCount(); i2++) {
                    if (accessibilityNodeInfo.getChild(i2) != null) {
                        i(accessibilityNodeInfo.getChild(i2));
                    }
                }
                return;
            }
            return;
        }
        String string = accessibilityNodeInfo.getClassName().toString();
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        int iC = p4.c(HelpShopAppUtil.getContext());
        if (accessibilityNodeInfo.getText() != null) {
            h2.a(f23181a, accessibilityNodeInfo.getText().toString() + "      info.getBoundsInScreen=" + rect.toString());
            return;
        }
        if (accessibilityNodeInfo.getClassName() != null) {
            h2.a(f23181a, "--------------------");
            h2.a(f23181a, "width=" + iC);
            h2.a(f23181a, string + "info.getBoundsInScreen=" + rect.toString());
        }
    }

    public static void j(AccessibilityService accessibilityService) {
        e = null;
        d = n0.a().b(t0.b().b(2000), t0.b().b(500), new b(accessibilityService));
    }

    public static void k(AccessibilityService accessibilityService) {
        e = null;
        d = n0.a().b(t0.b().b(3000), t0.b().b(500), new k(accessibilityService));
    }

    public class j implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f23192a;

        public j(AccessibilityService accessibilityService) {
            this.f23192a = accessibilityService;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            try {
                s1.a(this.f23192a.getRootInActiveWindow(), this.f23192a);
            } catch (Exception unused) {
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            h2.a(s1.f23181a, "结束了");
            TimerTask timerTask = s1.h;
            if (timerTask != null) {
                timerTask.cancel();
                s1.h = null;
            }
        }
    }

    @RequiresApi(api = 16)
    public static void c(AccessibilityService accessibilityService) {
        TimerTask timerTask = d;
        if (timerTask != null) {
            timerTask.cancel();
            d = null;
        }
        d = n0.a().b(t0.b().b(8000), t0.b().b(100), new d(accessibilityService, n3.a().e("OpenPermissionName")));
    }

    public static void d(AccessibilityService accessibilityService) {
        d = n0.a().b(t0.b().b(15000), t0.b().b(100), new i(accessibilityService, o1.c().b()));
    }

    public static void e(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        for (int i2 = 0; i2 < accessibilityNodeInfo.getChildCount(); i2++) {
            try {
                if (accessibilityNodeInfo.getChild(i2) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i2).getClassName())) {
                    h2.a(f23181a, "android.widget.ListView = " + accessibilityNodeInfo.getChild(i2).getChildCount());
                    if (accessibilityNodeInfo.getChild(i2).getChildCount() > 0) {
                        f = accessibilityNodeInfo.getChild(i2);
                    }
                }
                if (accessibilityNodeInfo.getChild(i2) != null) {
                    e(accessibilityNodeInfo.getChild(i2));
                }
            } catch (Exception unused) {
                return;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void f(AccessibilityService accessibilityService, boolean z) {
        h2.a(f23181a, "recycle 开始");
        d = n0.a().b(t0.b().b(6000), t0.b().b(100), new f(accessibilityService, o1.c().b(), z));
    }

    @RequiresApi(api = 16)
    public static void b(AccessibilityService accessibilityService, boolean z) {
        com.acse.ottn.b.c().a(t0.b().b(200));
        if (com.acse.ottn.b.c().h(accessibilityService, "应用启动管理") == null) {
            h2.a(f23181a, "clickOpenBatteryManage");
            return;
        }
        h2.a(f23181a, "找到");
        try {
            d(accessibilityService, z);
        } catch (Throwable unused) {
        }
    }

    @SuppressLint({"NewApi"})
    public static AccessibilityNodeInfo h(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return null;
        }
        for (int i2 = 0; i2 < accessibilityNodeInfo.getChildCount(); i2++) {
            if (accessibilityNodeInfo.getChild(i2) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i2).getClassName()) && accessibilityNodeInfo.getChild(i2).isScrollable()) {
                return accessibilityNodeInfo.getChild(i2);
            }
            if (accessibilityNodeInfo.getChild(i2) != null) {
                h(accessibilityNodeInfo.getChild(i2));
            }
        }
        return null;
    }

    public static boolean a(Context context) {
        return a(context, 24);
    }

    public static void d(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getParent() == null) {
            return;
        }
        AccessibilityNodeInfo accessibilityNodeInfoA = com.acse.ottn.b.c().a(accessibilityNodeInfo.getParent(), "com.huawei.hms.ads:id/app_track_switch");
        h2.a("samon-->", accessibilityNodeInfoA.toString());
        if (accessibilityNodeInfoA.isChecked()) {
            return;
        }
        com.acse.ottn.b.c().g(accessibilityNodeInfoA);
    }

    public static void a(Activity activity, int i2) {
        try {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity"));
            if (r3.f() == 3.1d) {
                activity.startActivityForResult(intent, i2);
            } else {
                intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity"));
                activity.startActivity(intent);
            }
        } catch (ActivityNotFoundException e2) {
            Intent intent2 = new Intent();
            intent2.setFlags(268435456);
            intent2.setComponent(new ComponentName("com.Android.settings", "com.android.settings.permission.TabItem"));
            activity.startActivityForResult(intent2, i2);
            e2.printStackTrace();
            h2.b(f23181a, Log.getStackTraceString(e2));
        } catch (SecurityException e3) {
            Intent intent3 = new Intent();
            intent3.setFlags(268435456);
            intent3.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            activity.startActivityForResult(intent3, i2);
            h2.b(f23181a, Log.getStackTraceString(e3));
        } catch (Exception e4) {
            h2.b(f23181a, Log.getStackTraceString(e4));
        }
    }

    @RequiresApi(api = 16)
    public static void f(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getParent() == null) {
            return;
        }
        for (int i2 = 0; i2 < accessibilityNodeInfo.getParent().getChildCount(); i2++) {
            if (accessibilityNodeInfo.getParent().getChild(i2) != null && "android.widget.Switch".equals(accessibilityNodeInfo.getParent().getChild(i2).getClassName())) {
                if (accessibilityNodeInfo.getParent().getChild(i2).isChecked()) {
                    com.acse.ottn.b.c().g(accessibilityNodeInfo.getParent().getChild(i2));
                    return;
                }
                return;
            }
        }
    }

    public static void c(AccessibilityService accessibilityService, boolean z) {
        e(accessibilityService, z);
    }

    public class h implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f23190a;
        public final /* synthetic */ AccessibilityNodeInfo b;

        public h(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
            this.f23190a = accessibilityService;
            this.b = accessibilityNodeInfo;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f23190a, "后台弹窗");
            if (accessibilityNodeInfoG == null) {
                com.acse.ottn.b.c().b(this.b);
                return;
            }
            TimerTask timerTask = s1.d;
            if (timerTask != null) {
                timerTask.cancel();
                s1.d = null;
            }
            com.acse.ottn.b.c().g(accessibilityNodeInfoG);
            if (n3.a() != null) {
                n3.a().a("battery_white", Boolean.TRUE);
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            h2.a(s1.f23181a, "结束了");
        }
    }

    @SuppressLint({"NewApi"})
    public static void g(AccessibilityService accessibilityService) {
        h = n0.a().b(8000, 500, new j(accessibilityService));
    }

    public class d implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f23186a;
        public final /* synthetic */ String b;

        public d(AccessibilityService accessibilityService, String str) {
            this.f23186a = accessibilityService;
            this.b = str;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            try {
                AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f23186a, this.b);
                if (accessibilityNodeInfoG != null) {
                    TimerTask timerTask = s1.d;
                    if (timerTask != null) {
                        timerTask.cancel();
                        s1.d = null;
                    }
                    com.acse.ottn.b.c().g(accessibilityNodeInfoG);
                    if (n3.a() != null) {
                        h2.a(s1.f23181a, "set battery_white is true");
                        n3.a().a("battery_white", Boolean.TRUE);
                    }
                }
            } catch (Throwable th) {
                h2.a(s1.f23181a, "e =" + th.getMessage());
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            s1.d = null;
        }
    }

    @RequiresApi(api = 16)
    public static void b(String str, AccessibilityService accessibilityService) {
        AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(accessibilityService, str);
        if (accessibilityNodeInfoG == null || accessibilityNodeInfoG.getParent() == null) {
            return;
        }
        for (int i2 = 0; i2 < accessibilityNodeInfoG.getParent().getChildCount(); i2++) {
            h2.a("samon-->", accessibilityNodeInfoG.getParent().getClassName().toString());
            if (accessibilityNodeInfoG.getParent().getChild(i2) != null && "android.widget.Switch".equals(accessibilityNodeInfoG.getParent().getChild(i2).getClassName())) {
                if (accessibilityNodeInfoG.getParent().getChild(i2).isChecked()) {
                    return;
                }
                com.acse.ottn.b.c().g(accessibilityNodeInfoG.getParent().getChild(i2));
                return;
            }
        }
    }

    public class f implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f23188a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;

        public f(AccessibilityService accessibilityService, String str, boolean z) {
            this.f23188a = accessibilityService;
            this.b = str;
            this.c = z;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            s1.e(this.f23188a.getRootInActiveWindow());
            if (s1.f != null) {
                AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f23188a, this.b);
                if (accessibilityNodeInfoG == null) {
                    com.acse.ottn.b.c().b(s1.f);
                    return;
                }
                TimerTask timerTask = s1.d;
                if (timerTask != null) {
                    timerTask.cancel();
                    s1.d = null;
                }
                s1.f(accessibilityNodeInfoG);
                s1.a(this.f23188a, this.c);
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            h2.a(s1.f23181a, "结束了");
        }
    }

    @SuppressLint({"NewApi"})
    public static void e(AccessibilityService accessibilityService, boolean z) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        com.acse.ottn.b.c().a(t0.b().b(1000));
        if (z) {
            a(accessibilityService, rootInActiveWindow);
        } else {
            d(accessibilityService);
        }
    }

    public class i implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f23191a;
        public final /* synthetic */ String b;

        public i(AccessibilityService accessibilityService, String str) {
            this.f23191a = accessibilityService;
            this.b = str;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            AccessibilityNodeInfo accessibilityNodeInfoH = s1.h(this.f23191a.getRootInActiveWindow());
            if (com.acse.ottn.b.c().g(this.f23191a, this.b) == null) {
                if (accessibilityNodeInfoH != null) {
                    com.acse.ottn.b.c().b(accessibilityNodeInfoH);
                    return;
                }
                return;
            }
            TimerTask timerTask = s1.d;
            if (timerTask != null) {
                timerTask.cancel();
                s1.d = null;
            }
            s1.b(this.b, this.f23191a);
            l0.c(true);
            com.acse.ottn.b.c().e(this.f23191a);
            com.acse.ottn.b.c().e(this.f23191a);
            com.acse.ottn.b.c().e(this.f23191a);
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            h2.a(s1.f23181a, "结束了");
        }
    }

    public class b implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f23184a;

        public b(AccessibilityService accessibilityService) {
            this.f23184a = accessibilityService;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            AccessibilityNodeInfo accessibilityNodeInfoJ = com.acse.ottn.b.c().j(this.f23184a, "跟踪管理");
            if (accessibilityNodeInfoJ == null) {
                com.acse.ottn.b.c().a(this.f23184a, p4.c(HelpShopAppUtil.getContext()) / 3, ((p4.b(HelpShopAppUtil.getContext()) * 2) / 3) + 300, (p4.c(HelpShopAppUtil.getContext()) / 3) + 100, p4.b(HelpShopAppUtil.getContext()) / 3, 300);
                return;
            }
            h2.a("samon-->111=", "333");
            com.acse.ottn.b.c().g(accessibilityNodeInfoJ);
            n3.a().a("oaid_permission", Boolean.TRUE);
            TimerTask timerTask = s1.d;
            if (timerTask != null) {
                timerTask.cancel();
                s1.d = null;
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            s1.d = null;
        }
    }

    public class k implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f23193a;

        public k(AccessibilityService accessibilityService) {
            this.f23193a = accessibilityService;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            AccessibilityNodeInfo accessibilityNodeInfoJ = com.acse.ottn.b.c().j(this.f23193a, "应用");
            if (accessibilityNodeInfoJ == null) {
                com.acse.ottn.b.c().a(this.f23193a, p4.c(HelpShopAppUtil.getContext()) / 3, ((p4.b(HelpShopAppUtil.getContext()) * 2) / 3) + 300, (p4.c(HelpShopAppUtil.getContext()) / 3) + 100, p4.b(HelpShopAppUtil.getContext()) / 3, 300);
                return;
            }
            h2.a("samon-->111=", "333");
            n3.a().a("battery_white", Boolean.TRUE);
            com.acse.ottn.b.c().g(accessibilityNodeInfoJ);
            TimerTask timerTask = s1.d;
            if (timerTask != null) {
                timerTask.cancel();
                s1.d = null;
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            s1.d = null;
        }
    }

    public class e implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f23187a;
        public final /* synthetic */ String b;

        public e(AccessibilityService accessibilityService, String str) {
            this.f23187a = accessibilityService;
            this.b = str;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            h2.a(s1.f23181a, "openHonorFlowWindowPermission start");
            s1.e(this.f23187a);
            try {
                AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f23187a, this.b);
                if (accessibilityNodeInfoG != null) {
                    TimerTask timerTask = s1.d;
                    if (timerTask != null) {
                        timerTask.cancel();
                        s1.d = null;
                        h2.a(s1.f23181a, "openHonorFlowWindowPermission find name");
                        com.acse.ottn.b.c().g(accessibilityNodeInfoG);
                        com.acse.ottn.b.c().a(200L);
                        s1.a(this.f23187a, System.currentTimeMillis(), true);
                    }
                } else if (s1.e != null) {
                    h2.a(s1.f23181a, "openHonorFlowWindowPermission ScrollForward");
                    com.acse.ottn.b.c().b(s1.e);
                }
            } catch (Throwable th) {
                h2.a(s1.f23181a, "e =" + th.getMessage());
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            s1.d = null;
        }
    }

    public class g implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f23189a;

        public g(AccessibilityService accessibilityService) {
            this.f23189a = accessibilityService;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            if (com.acse.ottn.b.c().g(this.f23189a, "手动管理") != null) {
                TimerTask timerTask = s1.d;
                if (timerTask != null) {
                    timerTask.cancel();
                    s1.d = null;
                }
                s1.b("允许自启动", this.f23189a);
                s1.b("允许后台活动", this.f23189a);
                l0.b(true);
                com.acse.ottn.b.c().e(this.f23189a);
                com.acse.ottn.b.c().e(this.f23189a);
                com.acse.ottn.b.c().e(this.f23189a);
                if (AssistUtils.BRAND_HON.equals(p4.b()) && Build.VERSION.SDK_INT >= 36) {
                    com.acse.ottn.b.c().e(this.f23189a);
                }
                if (n3.a() != null) {
                    n3.a().a("battery_white", Boolean.FALSE);
                }
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            h2.a(s1.f23181a, "结束了");
            s1.d = null;
        }
    }

    public static void b(Activity activity) {
        Intent intent = new Intent();
        try {
            intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.HWSettings"));
            activity.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public static void i(AccessibilityService accessibilityService) {
        String strB = o1.c().b();
        com.acse.ottn.b.c().a(1000L);
        d = n0.a().b(t0.b().b(20000), t0.b().b(500), new c(accessibilityService, strB));
    }

    public class c implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f23185a;
        public final /* synthetic */ String b;

        public c(AccessibilityService accessibilityService, String str) {
            this.f23185a = accessibilityService;
            this.b = str;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            AccessibilityNodeInfo accessibilityNodeInfoJ = com.acse.ottn.b.c().j(this.f23185a, this.b);
            if (accessibilityNodeInfoJ == null) {
                com.acse.ottn.b.c().a(this.f23185a, p4.c(HelpShopAppUtil.getContext()) / 3, ((p4.b(HelpShopAppUtil.getContext()) * 2) / 3) + 300, (p4.c(HelpShopAppUtil.getContext()) / 3) + 100, p4.b(HelpShopAppUtil.getContext()) / 3, 300);
                return;
            }
            h2.a("samon-->111=", "333");
            s1.d(accessibilityNodeInfoJ);
            TimerTask timerTask = s1.d;
            if (timerTask != null) {
                timerTask.cancel();
                s1.d = null;
            }
            com.acse.ottn.b.c().e(this.f23185a);
            com.acse.ottn.b.c().a(200L);
            com.acse.ottn.b.c().e(this.f23185a);
            com.acse.ottn.b.c().a(200L);
            com.acse.ottn.b.c().e(this.f23185a);
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            s1.d = null;
        }
    }

    public class a implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f23182a;
        public final /* synthetic */ boolean b;

        /* JADX INFO: renamed from: com.acse.ottn.s1$a$a, reason: collision with other inner class name */
        public class RunnableC0112a implements Runnable {
            public RunnableC0112a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (Settings.canDrawOverlays(a.this.f23182a)) {
                    com.acse.ottn.b.c().e(a.this.f23182a);
                    if (a.this.b) {
                        com.acse.ottn.b.c().e(a.this.f23182a);
                    }
                }
            }
        }

        public a(AccessibilityService accessibilityService, boolean z) {
            this.f23182a = accessibilityService;
            this.b = z;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            try {
                AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f23182a, "在其他应用上层显示");
                if (accessibilityNodeInfoG != null || p4.t()) {
                    if (accessibilityNodeInfoG == null || accessibilityNodeInfoG.getParent() == null) {
                        return;
                    }
                    TimerTask timerTask = s1.d;
                    if (timerTask != null) {
                        timerTask.cancel();
                        s1.d = null;
                    }
                    for (int i = 0; i < accessibilityNodeInfoG.getParent().getChildCount(); i++) {
                        if (accessibilityNodeInfoG.getParent().getChild(i) != null && "android.widget.Switch".equals(accessibilityNodeInfoG.getParent().getChild(i).getClassName())) {
                            com.acse.ottn.b.c().g(accessibilityNodeInfoG.getParent().getChild(i));
                            com.acse.ottn.b.c().e(this.f23182a);
                            if (this.b) {
                                com.acse.ottn.b.c().e(this.f23182a);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                h2.a(s1.f23181a, "找到  在其他应用上层显示");
                if (accessibilityNodeInfoG == null) {
                    accessibilityNodeInfoG = com.acse.ottn.b.c().f(this.f23182a, "android:id/summary");
                }
                if (accessibilityNodeInfoG == null || accessibilityNodeInfoG.getParent().getParent() == null) {
                    return;
                }
                TimerTask timerTask2 = s1.d;
                if (timerTask2 != null) {
                    timerTask2.cancel();
                    s1.d = null;
                }
                Rect rect = new Rect();
                accessibilityNodeInfoG.getBoundsInScreen(rect);
                Rect rect2 = new Rect();
                accessibilityNodeInfoG.getBoundsInParent(rect2);
                s1.f(this.f23182a);
                int iC = p4.c(HelpShopAppUtil.getContext());
                com.acse.ottn.b.c().a(this.f23182a, iC - 80, (rect.top - (rect2.bottom / 2)) - 30);
                new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0112a(), 300L);
            } catch (Throwable th) {
                h2.a(s1.f23181a, "e =" + th.getMessage());
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            s1.d = null;
        }
    }

    @TargetApi(19)
    public static boolean a(Context context, int i2) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        try {
            Class cls = Integer.TYPE;
            return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i2), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
        } catch (Exception e2) {
            h2.b(f23181a, Log.getStackTraceString(e2));
            return false;
        }
    }

    @RequiresApi(api = 16)
    public static void a(AccessibilityService accessibilityService, long j2, boolean z) {
        if (j2 - c.longValue() < 1000) {
            h2.a(f23181a, "间隔 t=" + j2 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
            h2.a(f23181a, "间隔 time=" + c + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - c.longValue()));
            return;
        }
        h2.a(f23181a, "无间隔 t=" + j2 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
        h2.a(f23181a, "无间隔 time=" + c + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - c.longValue()));
        TimerTask timerTask = d;
        if (timerTask != null) {
            timerTask.cancel();
            d = null;
        }
        c = Long.valueOf(j2);
        d = n0.a().b(t0.b().b(2000), t0.b().b(400), new a(accessibilityService, z));
    }

    @RequiresApi(api = 16)
    public static void a(AccessibilityService accessibilityService, boolean z) {
        d = n0.a().b(t0.b().b(6000), t0.b().b(100), new g(accessibilityService));
    }

    public static void a(Activity activity) {
        ComponentName componentNameUnflattenFromString;
        if (n3.a().e("OpenPermissionName").equals("权限管理")) {
            n3.a().a("background_battery_hignt", Boolean.TRUE);
        }
        int i2 = Build.VERSION.SDK_INT;
        Intent intent = new Intent();
        try {
            if (i2 >= 35) {
                componentNameUnflattenFromString = new ComponentName("com.android.settings", "com.android.settings.HWSettings");
            } else if (i2 >= 28) {
                componentNameUnflattenFromString = ComponentName.unflattenFromString("com.huawei.systemmanager/.startupmgr.ui.StartupNormalAppListActivity");
            } else {
                componentNameUnflattenFromString = ComponentName.unflattenFromString("com.huawei.systemmanager/.appcontrol.activity.StartupAppControlActivity");
            }
            intent.setComponent(componentNameUnflattenFromString);
            activity.startActivity(intent);
        } catch (Exception e2) {
            try {
                intent.setComponent(ComponentName.unflattenFromString("com.android.settings/.Settings$AppAndNotificationDashboardActivity"));
                activity.startActivity(intent);
            } catch (Exception unused) {
                h2.b(f23181a, e2.getMessage().toString());
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityNodeInfo child;
        if (accessibilityNodeInfo != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= accessibilityNodeInfo.getChildCount()) {
                    child = null;
                    break;
                }
                if (accessibilityNodeInfo.getChild(i2) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i2).getClassName()) && accessibilityNodeInfo.getChild(i2).getChildCount() > 0) {
                    child = accessibilityNodeInfo.getChild(i2);
                    break;
                } else {
                    if (accessibilityNodeInfo.getChild(i2) != null) {
                        a(accessibilityService, accessibilityNodeInfo.getChild(i2));
                    }
                    i2++;
                }
            }
            if (child == null) {
                return;
            }
            d = n0.a().b(t0.b().b(3000), t0.b().b(100), new h(accessibilityService, child));
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityService accessibilityService) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) {
            if (accessibilityNodeInfo != null) {
                for (int i2 = 0; i2 < accessibilityNodeInfo.getChildCount(); i2++) {
                    try {
                        if (accessibilityNodeInfo.getChild(i2) != null) {
                            a(accessibilityNodeInfo.getChild(i2), accessibilityService);
                        }
                    } catch (Throwable th) {
                        h2.a(f23181a, th.getMessage());
                    }
                }
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(accessibilityNodeInfo.getText())) {
            return;
        }
        String strTrim = accessibilityNodeInfo.getText().toString().trim();
        if (g.equals(strTrim)) {
            TimerTask timerTask = h;
            if (timerTask != null) {
                timerTask.cancel();
                h = null;
            }
            com.acse.ottn.b.c().e(accessibilityService);
            return;
        }
        h2.c("samon-->12", "getText = " + strTrim);
    }
}
