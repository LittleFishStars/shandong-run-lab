package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import java.util.List;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f23022a = "OppoUtils";
    public static TimerTask c;
    public static Long b = 0L;
    public static AccessibilityNodeInfo d = null;

    public class f implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f23029a;

        public f(AccessibilityService accessibilityService) {
            this.f23029a = accessibilityService;
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
        }

        @Override // com.acse.ottn.n0.d
        @RequiresApi(api = 16)
        public void a(long j) {
            try {
                AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f23029a, "应用");
                if (accessibilityNodeInfoG == null) {
                    h3.g(this.f23029a);
                    if (h3.d != null) {
                        com.acse.ottn.b.c().b(h3.d);
                        return;
                    }
                    return;
                }
                TimerTask timerTask = h3.c;
                if (timerTask != null) {
                    timerTask.cancel();
                    h3.c = null;
                }
                h2.a(h3.f23022a, "找到了");
                n3.a().a("battery_white", Boolean.TRUE);
                com.acse.ottn.b.c().g(accessibilityNodeInfoG);
            } catch (Throwable th) {
                h2.a(h3.f23022a, "e =" + th.getMessage());
            }
        }
    }

    public class g implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f23030a;

        public g(AccessibilityService accessibilityService) {
            this.f23030a = accessibilityService;
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
        }

        @Override // com.acse.ottn.n0.d
        @RequiresApi(api = 16)
        public void a(long j) {
            try {
                AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f23030a, "密码与安全");
                if (accessibilityNodeInfoG == null) {
                    h3.g(this.f23030a);
                    if (h3.d != null) {
                        com.acse.ottn.b.c().b(h3.d);
                        return;
                    }
                    return;
                }
                TimerTask timerTask = h3.c;
                if (timerTask != null) {
                    timerTask.cancel();
                    h3.c = null;
                }
                h2.a(h3.f23022a, "找到了");
                n3.a().a("pay_secure", Boolean.TRUE);
                if (Build.VERSION.SDK_INT == 35) {
                    n3.a().b("sys_text", "系统安全");
                }
                com.acse.ottn.b.c().g(accessibilityNodeInfoG);
            } catch (Throwable th) {
                h2.a(h3.f23022a, "e =" + th.getMessage());
            }
        }
    }

    public class i implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f23032a;
        public final /* synthetic */ String b;

        public i(AccessibilityService accessibilityService, String str) {
            this.f23032a = accessibilityService;
            this.b = str;
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
        }

        @Override // com.acse.ottn.n0.d
        @RequiresApi(api = 16)
        public void a(long j) {
            try {
                AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f23032a, this.b);
                if (accessibilityNodeInfoG == null) {
                    h3.g(this.f23032a);
                    if (h3.d != null) {
                        com.acse.ottn.b.c().b(h3.d);
                        return;
                    }
                    return;
                }
                TimerTask timerTask = h3.c;
                if (timerTask != null) {
                    timerTask.cancel();
                    h3.c = null;
                }
                h2.a(h3.f23022a, "找到了");
                com.acse.ottn.b.c().g(accessibilityNodeInfoG);
                com.acse.ottn.b.c().a(200L);
                try {
                    t0.a(this.f23032a, "oppo_permission");
                } catch (Exception unused) {
                }
                n3.a().a("oppo_35_autostart", Boolean.TRUE);
                com.acse.ottn.b.c().a(100L);
                com.acse.ottn.b.c().e(this.f23032a);
                com.acse.ottn.b.c().a(100L);
                com.acse.ottn.b.c().e(this.f23032a);
                com.acse.ottn.b.c().a(100L);
                com.acse.ottn.b.c().e(this.f23032a);
            } catch (Throwable th) {
                h2.a(h3.f23022a, "e =" + th.getMessage());
            }
        }
    }

    public static void c(AccessibilityService accessibilityService) {
        c = n0.a().b(t0.b().b(400), t0.b().b(200), new e(accessibilityService));
    }

    @RequiresApi(api = 16)
    public static void d(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(accessibilityService, "耗电管理");
        AccessibilityNodeInfo accessibilityNodeInfoG2 = com.acse.ottn.b.c().g(accessibilityService, "耗电保护");
        if (accessibilityNodeInfoG == null && accessibilityNodeInfoG2 == null) {
            e3.a(accessibilityService);
            return;
        }
        if (accessibilityNodeInfoG != null) {
            h2.a(f23022a, "nodeInfo is null");
            com.acse.ottn.b.c().g(accessibilityNodeInfoG);
        } else {
            com.acse.ottn.b.c().g(accessibilityNodeInfoG2);
        }
        n3.a().a("battery_white", Boolean.TRUE);
        com.acse.ottn.b.c().a(500L);
        a(accessibilityService, System.currentTimeMillis());
        n3.a().a("battery_white");
    }

    public static void e(AccessibilityService accessibilityService) {
        if (com.acse.ottn.b.c().h(accessibilityService, o1.c().b()) != null) {
            AccessibilityNodeInfo accessibilityNodeInfoJ = com.acse.ottn.b.c().j(accessibilityService, "始终允许打开");
            if (accessibilityNodeInfoJ != null) {
                com.acse.ottn.b.c().g(accessibilityNodeInfoJ);
                return;
            }
            AccessibilityNodeInfo accessibilityNodeInfoJ2 = com.acse.ottn.b.c().j(accessibilityService, com.ipd.dsp.internal.b1.b.a.p);
            if (accessibilityNodeInfoJ2 != null) {
                com.acse.ottn.b.c().g(accessibilityNodeInfoJ2);
            }
        }
    }

    public static void f(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(accessibilityService, "自启动");
        if (accessibilityNodeInfoG != null) {
            com.acse.ottn.b.c().g(accessibilityNodeInfoG);
            com.acse.ottn.b.c().a(300L);
            c = n0.a().b(t0.b().b(10000), t0.b().b(400), new i(accessibilityService, o1.c().b()));
        }
    }

    @SuppressLint({"NewApi"})
    public static void g(AccessibilityService accessibilityService) {
        a(accessibilityService.getRootInActiveWindow());
    }

    public static void h(AccessibilityService accessibilityService) {
        c = n0.a().b(t0.b().b(20000), t0.b().b(100), new c(accessibilityService, o1.c().b()));
    }

    public static void i(AccessibilityService accessibilityService) {
        c = n0.a().b(t0.b().b(20000), t0.b().b(100), new b(accessibilityService, o1.c().b()));
    }

    @RequiresApi(api = 16)
    public static void j(AccessibilityService accessibilityService) {
        c = n0.a().b(t0.b().b(20000), t0.b().b(100), new a(accessibilityService, o1.c().b()));
    }

    public static void k(AccessibilityService accessibilityService) {
        c = n0.a().b(t0.b().b(3000), t0.b().b(500), new f(accessibilityService));
    }

    public static void l(AccessibilityService accessibilityService) {
        try {
            AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(accessibilityService, "支付保护");
            if (accessibilityNodeInfoG != null) {
                h2.a(f23022a, "找到了");
                n3.a().a("pay_secure", Boolean.TRUE);
                com.acse.ottn.b.c().g(accessibilityNodeInfoG);
            }
        } catch (Throwable th) {
            h2.a(f23022a, "e =" + th.getMessage());
        }
    }

    public static void m(AccessibilityService accessibilityService) {
        String strB = o1.c().b();
        n3.a().b("sys_dialog_text", "\"支付保护\"");
        c = n0.a().b(t0.b().b(10000), t0.b().b(500), new h(accessibilityService, strB));
    }

    public static void n(AccessibilityService accessibilityService) {
        try {
            AccessibilityNodeInfo accessibilityNodeInfoJ = com.acse.ottn.b.c().j(accessibilityService, "允许");
            if (accessibilityNodeInfoJ != null) {
                h2.a(f23022a, "找到了 确定");
                com.acse.ottn.b.c().g(accessibilityNodeInfoJ);
            }
        } catch (Throwable th) {
            h2.a(f23022a, "e =" + th.getMessage());
        }
    }

    public static void o(AccessibilityService accessibilityService) {
        c = n0.a().b(t0.b().b(2000), t0.b().b(500), new g(accessibilityService));
    }

    public static void p(AccessibilityService accessibilityService) {
        try {
            AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(accessibilityService, "系统安全");
            if (accessibilityNodeInfoG != null) {
                h2.a(f23022a, "找到了");
                n3.a().a("pay_secure", Boolean.TRUE);
                com.acse.ottn.b.c().g(accessibilityNodeInfoG);
            }
        } catch (Throwable th) {
            h2.a(f23022a, "e =" + th.getMessage());
        }
    }

    public static void q(AccessibilityService accessibilityService) {
        try {
            AccessibilityNodeInfo accessibilityNodeInfoJ = com.acse.ottn.b.c().j(accessibilityService, "确定");
            if (accessibilityNodeInfoJ != null) {
                h2.a(f23022a, "找到了 确定");
                com.acse.ottn.b.c().g(accessibilityNodeInfoJ);
                r1.c("1");
                n3.a().b("oppo_pay_secure_click_state", "1");
                com.acse.ottn.b.c().a(100L);
                com.acse.ottn.b.c().e(accessibilityService);
                com.acse.ottn.b.c().a(100L);
                com.acse.ottn.b.c().e(accessibilityService);
                com.acse.ottn.b.c().a(100L);
                com.acse.ottn.b.c().e(accessibilityService);
                com.acse.ottn.b.c().a(100L);
                com.acse.ottn.b.c().e(accessibilityService);
            }
        } catch (Throwable th) {
            h2.a(f23022a, "e =" + th.getMessage());
        }
    }

    public static boolean a(Context context) {
        return a(context, 24);
    }

    @TargetApi(19)
    public static boolean a(Context context, int i2) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        try {
            Class cls = Integer.TYPE;
            return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i2), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
        } catch (Throwable th) {
            h2.b(f23022a, Log.getStackTraceString(th));
            return false;
        }
    }

    public class e implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f23027a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.acse.ottn.b.c().e(e.this.f23027a);
            }
        }

        public e(AccessibilityService accessibilityService) {
            this.f23027a = accessibilityService;
        }

        @Override // com.acse.ottn.n0.d
        @RequiresApi(api = 16)
        public void a(long j) {
            h2.a("samon-->", "backClick  倒计时");
            AccessibilityNodeInfo accessibilityNodeInfoA = com.acse.ottn.b.c().a(this.f23027a, "允许", true);
            AccessibilityNodeInfo accessibilityNodeInfoA2 = com.acse.ottn.b.c().a(this.f23027a, "通知管理", true);
            if (accessibilityNodeInfoA == null || accessibilityNodeInfoA2 != null) {
                return;
            }
            TimerTask timerTask = h3.c;
            if (timerTask != null) {
                timerTask.cancel();
                h3.c = null;
            }
            com.acse.ottn.b.c().g(accessibilityNodeInfoA);
            l0.b(true);
            com.acse.ottn.b.c().e(this.f23027a);
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            TimerTask timerTask = h3.c;
            if (timerTask != null) {
                timerTask.cancel();
                h3.c = null;
            }
            h2.a("samon-->", "backClick  onFinish");
            l0.b(true);
            com.acse.ottn.b.c().e(this.f23027a);
            new Handler(Looper.getMainLooper()).postDelayed(new a(), 200L);
        }
    }

    public static void a(Activity activity, int i2) {
        try {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity"));
            activity.startActivityForResult(intent, i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public class a implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f23023a;
        public final /* synthetic */ String b;

        public a(AccessibilityService accessibilityService, String str) {
            this.f23023a = accessibilityService;
            this.b = str;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            try {
                AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f23023a, this.b);
                if (accessibilityNodeInfoG == null) {
                    h3.g(this.f23023a);
                    if (h3.d != null) {
                        com.acse.ottn.b.c().b(h3.d);
                        return;
                    }
                    return;
                }
                TimerTask timerTask = h3.c;
                if (timerTask != null) {
                    timerTask.cancel();
                    h3.c = null;
                }
                h2.a(h3.f23022a, "找到了");
                com.acse.ottn.b.c().g(accessibilityNodeInfoG);
                com.acse.ottn.b.c().e(this.f23023a);
            } catch (Throwable th) {
                h2.a(h3.f23022a, "e =" + th.getMessage());
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            h3.c = null;
            h2.a(h3.f23022a, "结束了");
        }
    }

    public class b implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f23024a;
        public final /* synthetic */ String b;

        public b(AccessibilityService accessibilityService, String str) {
            this.f23024a = accessibilityService;
            this.b = str;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            h2.a("samon-->", "openAndroidElevenOppoFlowWindowPermission  倒计时");
            try {
                AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f23024a, this.b);
                if (accessibilityNodeInfoG == null) {
                    h3.g(this.f23024a);
                    if (h3.d != null) {
                        com.acse.ottn.b.c().b(h3.d);
                        return;
                    }
                    return;
                }
                TimerTask timerTask = h3.c;
                if (timerTask != null) {
                    timerTask.cancel();
                    h3.c = null;
                }
                h2.a(h3.f23022a, "找到了");
                com.acse.ottn.b.c().g(accessibilityNodeInfoG);
                com.acse.ottn.b.c().e(this.f23024a);
            } catch (Throwable th) {
                h2.a(h3.f23022a, "e =" + th.getMessage());
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            h3.c = null;
            h2.a(h3.f23022a, "结束了");
        }
    }

    public static void a(AccessibilityService accessibilityService, long j) {
        n3.a().a("battery_white", Boolean.FALSE);
        if (j - b.longValue() < 1000) {
            h2.a(f23022a, "间隔 t=" + j + "   System.currentTimeMillis() =" + System.currentTimeMillis());
            h2.a(f23022a, "间隔 time=" + b + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - b.longValue()));
            return;
        }
        h2.a(f23022a, "无间隔 t=" + j + "   System.currentTimeMillis() =" + System.currentTimeMillis());
        h2.a(f23022a, "无间隔 time=" + b + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - b.longValue()));
        b = Long.valueOf(j);
        c = n0.a().b(t0.b().b(1500), t0.b().b(500), new d(accessibilityService));
    }

    public class c implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f23025a;
        public final /* synthetic */ String b;

        public c(AccessibilityService accessibilityService, String str) {
            this.f23025a = accessibilityService;
            this.b = str;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            h2.a("samon-->", "openAndroid12OppoFlowWindowPermission  倒计时");
            try {
                AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f23025a, this.b);
                if (accessibilityNodeInfoG == null) {
                    h3.g(this.f23025a);
                    if (h3.d != null) {
                        com.acse.ottn.b.c().b(h3.d);
                        return;
                    }
                    return;
                }
                TimerTask timerTask = h3.c;
                if (timerTask != null) {
                    timerTask.cancel();
                    h3.c = null;
                    h2.a(h3.f23022a, "取消倒计时");
                }
                h2.a(h3.f23022a, "找到了");
                com.acse.ottn.b.c().g(accessibilityNodeInfoG);
                com.acse.ottn.b.c().a(t0.b().b(500));
                h2.a(h3.f23022a, "点击1=" + System.currentTimeMillis());
                AccessibilityNodeInfo accessibilityNodeInfoG2 = com.acse.ottn.b.c().g(this.f23025a, "允许");
                if (accessibilityNodeInfoG2 != null) {
                    h2.a(h3.f23022a, "点击2=" + System.currentTimeMillis());
                    com.acse.ottn.b.c().g(accessibilityNodeInfoG2);
                    com.acse.ottn.b.c().e(this.f23025a);
                    com.acse.ottn.b.c().e(this.f23025a);
                }
            } catch (Throwable th) {
                h2.a(h3.f23022a, "e =" + th.getMessage());
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            h3.c = null;
            h2.a(h3.f23022a, "结束了");
        }
    }

    public static void a(Activity activity) {
        n3.a().a("open_battery_white", Boolean.TRUE);
        Intent intent = new Intent();
        try {
            try {
                intent.setFlags(268435456);
                intent.putExtra(ALPParamConstant.PACKAGENAME, activity.getPackageName());
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                activity.startActivity(intent);
            } catch (Exception unused) {
                Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.setData(Uri.fromParts("package", activity.getPackageName(), null));
                activity.startActivity(intent2);
            }
        } catch (Exception unused2) {
            intent.setFlags(268435456);
            intent.putExtra("pkg_name", activity.getPackageName());
            intent.putExtra("app_name", o1.c().b());
            intent.putExtra("class_name", "com.welab.notificationdemo.MainActivity");
            intent.setComponent(new ComponentName("com.coloros.notificationmanager", "com.coloros.notificationmanager.AppDetailPreferenceActivity"));
            activity.startActivity(intent);
        }
    }

    public class h implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f23031a;
        public final /* synthetic */ String b;

        public h(AccessibilityService accessibilityService, String str) {
            this.f23031a = accessibilityService;
            this.b = str;
        }

        @Override // com.acse.ottn.n0.d
        @RequiresApi(api = 16)
        public void a(long j) {
            try {
                AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f23031a, this.b);
                if (com.acse.ottn.b.c().g(this.f23031a, "无应用正在通过无障碍服务控制设备") != null) {
                    TimerTask timerTask = h3.c;
                    if (timerTask != null) {
                        timerTask.cancel();
                        h3.c = null;
                    }
                    h2.a(h3.f23022a, "找到了 =无应用正在通过无障碍服务控制设备");
                    r1.c("2");
                    n3.a().b("oppo_pay_secure_click_state", "2");
                    com.acse.ottn.b.c().a(100L);
                    com.acse.ottn.b.c().e(this.f23031a);
                    com.acse.ottn.b.c().a(100L);
                    com.acse.ottn.b.c().e(this.f23031a);
                    com.acse.ottn.b.c().a(100L);
                    com.acse.ottn.b.c().e(this.f23031a);
                    com.acse.ottn.b.c().a(100L);
                    com.acse.ottn.b.c().e(this.f23031a);
                    return;
                }
                if (accessibilityNodeInfoG != null) {
                    TimerTask timerTask2 = h3.c;
                    if (timerTask2 != null) {
                        timerTask2.cancel();
                        h3.c = null;
                    }
                    h2.a(h3.f23022a, "找到了 =" + this.b);
                    com.acse.ottn.b.c().a(500L);
                    List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText = accessibilityNodeInfoG.getParent().findAccessibilityNodeInfosByText("信任此应用");
                    List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText2 = accessibilityNodeInfoG.getParent().getParent().findAccessibilityNodeInfosByText("信任此应用");
                    if (listFindAccessibilityNodeInfosByText2 != null && !listFindAccessibilityNodeInfosByText2.isEmpty()) {
                        for (AccessibilityNodeInfo accessibilityNodeInfo : listFindAccessibilityNodeInfosByText2) {
                            if (accessibilityNodeInfo != null && accessibilityNodeInfo.getText() != null && "信任此应用".equals(accessibilityNodeInfo.getText().toString().trim())) {
                                h2.a(h3.f23022a, "找到了 =信任此应用");
                                n3.a().a("pay_secure", Boolean.TRUE);
                                com.acse.ottn.b.c().g(accessibilityNodeInfo);
                            }
                        }
                        return;
                    }
                    if (listFindAccessibilityNodeInfosByText == null || listFindAccessibilityNodeInfosByText.isEmpty()) {
                        return;
                    }
                    for (AccessibilityNodeInfo accessibilityNodeInfo2 : listFindAccessibilityNodeInfosByText) {
                        if (accessibilityNodeInfo2 != null && accessibilityNodeInfo2.getText() != null && "信任此应用".equals(accessibilityNodeInfo2.getText().toString().trim())) {
                            h2.a(h3.f23022a, "找到了 =信任此应用");
                            n3.a().a("pay_secure", Boolean.TRUE);
                            com.acse.ottn.b.c().g(accessibilityNodeInfo2);
                        }
                    }
                }
            } catch (Throwable th) {
                h2.a(h3.f23022a, "e =" + th.getMessage());
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            TimerTask timerTask = h3.c;
            if (timerTask != null) {
                timerTask.cancel();
                h3.c = null;
            }
            r1.c("3");
            n3.a().b("oppo_pay_secure_click_state", "3");
            com.acse.ottn.b.c().a(100L);
            com.acse.ottn.b.c().e(this.f23031a);
            com.acse.ottn.b.c().a(100L);
            com.acse.ottn.b.c().e(this.f23031a);
            com.acse.ottn.b.c().a(100L);
            com.acse.ottn.b.c().e(this.f23031a);
            com.acse.ottn.b.c().a(100L);
            com.acse.ottn.b.c().e(this.f23031a);
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i2 = 0; i2 < accessibilityNodeInfo.getChildCount(); i2++) {
                if (accessibilityNodeInfo.getChild(i2) != null && "androidx.recyclerview.widget.RecyclerView".equals(accessibilityNodeInfo.getChild(i2).getClassName())) {
                    d = accessibilityNodeInfo.getChild(i2);
                    return;
                } else {
                    if (accessibilityNodeInfo.getChild(i2) != null) {
                        a(accessibilityNodeInfo.getChild(i2));
                    }
                }
            }
        }
    }

    public static void a(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(accessibilityService, str);
        if (accessibilityNodeInfoG != null) {
            com.acse.ottn.b.c().g(accessibilityNodeInfoG);
        }
    }

    public class d implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f23026a;

        public d(AccessibilityService accessibilityService) {
            this.f23026a = accessibilityService;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            h2.a(h3.f23022a, "openOppenBatteryButton  倒计时");
            AccessibilityNodeInfo accessibilityNodeInfoJ = com.acse.ottn.b.c().j(this.f23026a, "允许应用后台行为");
            AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f23026a, "允许应用自启动");
            AccessibilityNodeInfo accessibilityNodeInfoG2 = com.acse.ottn.b.c().g(this.f23026a, "允许完全后台行为");
            AccessibilityNodeInfo accessibilityNodeInfoG3 = com.acse.ottn.b.c().g(this.f23026a, "允许后台运行");
            AccessibilityNodeInfo accessibilityNodeInfoG4 = com.acse.ottn.b.c().g(this.f23026a, "完全允许后台行为");
            if (accessibilityNodeInfoJ != null) {
                com.acse.ottn.b.c().g(accessibilityNodeInfoJ);
                com.acse.ottn.b.c().a(100L);
                h3.c(this.f23026a);
                com.acse.ottn.b.c().a(100L);
                com.acse.ottn.b.c().e(this.f23026a);
                h2.a(h3.f23022a, "openOppenBatteryButton  1111");
                return;
            }
            int i = 0;
            if (accessibilityNodeInfoG != null && accessibilityNodeInfoG.getParent() != null) {
                h2.a(h3.f23022a, "openOppenBatteryButton  6666");
                h2.a(h3.f23022a, "infochild is not null");
                com.acse.ottn.b.c().a(200L);
                for (int i2 = 0; i2 < accessibilityNodeInfoG.getParent().getChildCount(); i2++) {
                    if (accessibilityNodeInfoG.getParent().getChild(i2) != null && "android.widget.Switch".equals(accessibilityNodeInfoG.getParent().getChild(i2).getClassName())) {
                        h2.a(h3.f23022a, "infochild android.widget.Switch");
                        if (!accessibilityNodeInfoG.getParent().getChild(i2).isChecked()) {
                            h2.a(h3.f23022a, "点击infochild");
                            com.acse.ottn.b.c().g(accessibilityNodeInfoG);
                        }
                    }
                }
            }
            if (accessibilityNodeInfoG2 != null && accessibilityNodeInfoG2.getParent() != null) {
                h2.a(h3.f23022a, "openOppenBatteryButton  2222");
                h2.a(h3.f23022a, "nodeInfochild is not null");
                com.acse.ottn.b.c().a(100L);
                while (i < accessibilityNodeInfoG2.getParent().getChildCount()) {
                    if (accessibilityNodeInfoG2.getParent().getChild(i) != null && "android.widget.Switch".equals(accessibilityNodeInfoG2.getParent().getChild(i).getClassName())) {
                        h2.a(h3.f23022a, "nodeInfochild android.widget.Switch");
                        if (!accessibilityNodeInfoG2.getParent().getChild(i).isChecked()) {
                            h2.a(h3.f23022a, "点击nodeInfochild = ");
                            com.acse.ottn.b.c().g(accessibilityNodeInfoG2);
                        }
                    }
                    i++;
                }
                TimerTask timerTask = h3.c;
                if (timerTask != null) {
                    timerTask.cancel();
                    h3.c = null;
                }
                h3.c(this.f23026a);
                com.acse.ottn.b.c().a(100L);
                com.acse.ottn.b.c().e(this.f23026a);
                return;
            }
            if (accessibilityNodeInfoG3 == null || accessibilityNodeInfoG3.getParent() == null) {
                if (accessibilityNodeInfoG4 != null) {
                    com.acse.ottn.b.c().g(accessibilityNodeInfoG4);
                    h3.c(this.f23026a);
                    com.acse.ottn.b.c().a(300L);
                    com.acse.ottn.b.c().e(this.f23026a);
                    return;
                }
                return;
            }
            h2.a(h3.f23022a, "openOppenBatteryButton  3333");
            TimerTask timerTask2 = h3.c;
            if (timerTask2 != null) {
                timerTask2.cancel();
                h3.c = null;
            }
            h2.a(h3.f23022a, "nodeInfochild1 is not null");
            com.acse.ottn.b.c().a(100L);
            boolean z = false;
            while (i < accessibilityNodeInfoG3.getParent().getChildCount()) {
                if (accessibilityNodeInfoG3.getParent().getChild(i) != null && "android.widget.Switch".equals(accessibilityNodeInfoG3.getParent().getChild(i).getClassName())) {
                    h2.a(h3.f23022a, "nodeInfochild1 android.widget.Switch");
                    if (!accessibilityNodeInfoG3.getParent().getChild(i).isChecked()) {
                        h2.a(h3.f23022a, "点击nodeInfochild1");
                        com.acse.ottn.b.c().g(accessibilityNodeInfoG3);
                    }
                    z = true;
                }
                i++;
            }
            h2.a(h3.f23022a, "openOppenBatteryButton  4444");
            if (!z) {
                com.acse.ottn.b.c().g(accessibilityNodeInfoG3);
            }
            h3.c(this.f23026a);
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            h2.a(h3.f23022a, "openOppenBatteryButton  5555");
            TimerTask timerTask = h3.c;
            if (timerTask != null) {
                timerTask.cancel();
                h3.c = null;
            }
        }
    }
}
