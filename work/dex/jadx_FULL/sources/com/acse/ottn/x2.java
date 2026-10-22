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
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.service.ShopHelperService;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class x2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f23292a = "NubiaUtils";
    public static TimerTask b;
    public static AccessibilityNodeInfo c;

    public static void c(ShopHelperService shopHelperService) {
        b = n0.a().b(1000, 100, new d(shopHelperService));
    }

    @RequiresApi(api = 16)
    public static void d(ShopHelperService shopHelperService) {
        AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(shopHelperService, "耗电管理");
        AccessibilityNodeInfo accessibilityNodeInfoG2 = com.acse.ottn.b.c().g(shopHelperService, "耗电保护");
        if (accessibilityNodeInfoG == null && accessibilityNodeInfoG2 == null) {
            return;
        }
        if (n3.a() != null) {
            n3.a().a("battery_white", Boolean.TRUE);
        }
        if (accessibilityNodeInfoG != null) {
            com.acse.ottn.b.c().g(accessibilityNodeInfoG);
        } else {
            com.acse.ottn.b.c().g(accessibilityNodeInfoG2);
        }
        b = n0.a().b(1500, 200, new c(shopHelperService));
    }

    @RequiresApi(api = 16)
    public static void e(ShopHelperService shopHelperService) {
        if (com.acse.ottn.b.c().a()) {
            h2.a(f23292a, "悬浮窗权限已开启");
            return;
        }
        AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(shopHelperService, "允许显示在其他应用的上层");
        if (accessibilityNodeInfoG == null) {
            return;
        }
        com.acse.ottn.b.c().g(accessibilityNodeInfoG);
        com.acse.ottn.b.c().e(shopHelperService);
        if (Build.VERSION.SDK_INT >= 30) {
            com.acse.ottn.b.c().e(shopHelperService);
        }
    }

    @SuppressLint({"NewApi"})
    public static void f(ShopHelperService shopHelperService) {
        a(shopHelperService.getRootInActiveWindow());
    }

    public static void g(ShopHelperService shopHelperService) {
        if (com.acse.ottn.b.c().a()) {
            h2.a(f23292a, "悬浮窗权限已开启");
        } else {
            b = n0.a().b(20000, 100, new b(shopHelperService, o1.c().b()));
        }
    }

    @RequiresApi(api = 16)
    public static void h(ShopHelperService shopHelperService) {
        if (com.acse.ottn.b.c().a()) {
            h2.a(f23292a, "悬浮窗权限已开启");
        } else {
            b = n0.a().b(20000, 100, new a(shopHelperService, o1.c().b()));
        }
    }

    public static boolean a(Context context) {
        return a(context, 24);
    }

    @TargetApi(19)
    public static boolean a(Context context, int i) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        try {
            Class cls = Integer.TYPE;
            return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
        } catch (Exception e) {
            h2.b(f23292a, Log.getStackTraceString(e));
            return false;
        }
    }

    public class d implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShopHelperService f23296a;

        public d(ShopHelperService shopHelperService) {
            this.f23296a = shopHelperService;
        }

        @Override // com.acse.ottn.n0.d
        @RequiresApi(api = 16)
        public void a(long j) {
            AccessibilityNodeInfo accessibilityNodeInfoA = com.acse.ottn.b.c().a((AccessibilityService) this.f23296a, "允许", true);
            if (accessibilityNodeInfoA != null) {
                TimerTask timerTask = x2.b;
                if (timerTask != null) {
                    timerTask.cancel();
                    x2.b = null;
                }
                com.acse.ottn.b.c().g(accessibilityNodeInfoA);
                l0.b(true);
                com.acse.ottn.b.c().e(this.f23296a);
                com.acse.ottn.b.c().e(this.f23296a);
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            TimerTask timerTask = x2.b;
            if (timerTask != null) {
                timerTask.cancel();
                x2.b = null;
            }
            l0.b(true);
            com.acse.ottn.b.c().e(this.f23296a);
            com.acse.ottn.b.c().e(this.f23296a);
        }
    }

    public static void a(Activity activity, int i) {
        try {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity"));
            activity.startActivityForResult(intent, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class a implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShopHelperService f23293a;
        public final /* synthetic */ String b;

        public a(ShopHelperService shopHelperService, String str) {
            this.f23293a = shopHelperService;
            this.b = str;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            try {
                AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f23293a, this.b);
                if (accessibilityNodeInfoG == null) {
                    x2.f(this.f23293a);
                    if (x2.c == null) {
                        return;
                    }
                    com.acse.ottn.b.c().b(x2.c);
                    return;
                }
                TimerTask timerTask = x2.b;
                if (timerTask != null) {
                    timerTask.cancel();
                    x2.b = null;
                }
                h2.a(x2.f23292a, "找到了");
                com.acse.ottn.b.c().g(accessibilityNodeInfoG);
                com.acse.ottn.b.c().e(this.f23293a);
            } catch (Exception e) {
                h2.a(x2.f23292a, "e =" + e.getMessage());
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            x2.b = null;
            h2.a(x2.f23292a, "结束了");
        }
    }

    public class b implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShopHelperService f23294a;
        public final /* synthetic */ String b;

        public b(ShopHelperService shopHelperService, String str) {
            this.f23294a = shopHelperService;
            this.b = str;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            try {
                AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f23294a, this.b);
                if (accessibilityNodeInfoG == null) {
                    x2.f(this.f23294a);
                    if (x2.c == null) {
                        return;
                    }
                    com.acse.ottn.b.c().b(x2.c);
                    return;
                }
                TimerTask timerTask = x2.b;
                if (timerTask != null) {
                    timerTask.cancel();
                    x2.b = null;
                }
                h2.a(x2.f23292a, "找到了");
                com.acse.ottn.b.c().g(accessibilityNodeInfoG);
                com.acse.ottn.b.c().e(this.f23294a);
            } catch (Exception e) {
                h2.a(x2.f23292a, "e =" + e.getMessage());
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            x2.b = null;
            h2.a(x2.f23292a, "结束了");
        }
    }

    public static void a(Activity activity) {
        Intent intent = new Intent();
        try {
            try {
                intent.setFlags(268435456);
                intent.putExtra(ALPParamConstant.PACKAGENAME, activity.getPackageName());
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                activity.startActivityForResult(intent, 10013);
            } catch (Exception unused) {
                Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.setData(Uri.fromParts("package", activity.getPackageName(), null));
                activity.startActivityForResult(intent2, 10013);
            }
        } catch (Exception unused2) {
            intent.setFlags(268435456);
            intent.putExtra("pkg_name", activity.getPackageName());
            intent.putExtra("app_name", o1.c().b());
            intent.putExtra("class_name", "com.welab.notificationdemo.MainActivity");
            intent.setComponent(new ComponentName("com.coloros.notificationmanager", "com.coloros.notificationmanager.AppDetailPreferenceActivity"));
            activity.startActivityForResult(intent, 10013);
        }
    }

    public class c implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShopHelperService f23295a;

        public c(ShopHelperService shopHelperService) {
            this.f23295a = shopHelperService;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f23295a, "允许完全后台行为");
            AccessibilityNodeInfo accessibilityNodeInfoG2 = com.acse.ottn.b.c().g(this.f23295a, "允许后台运行");
            AccessibilityNodeInfo accessibilityNodeInfoG3 = com.acse.ottn.b.c().g(this.f23295a, "允许应用自启动");
            if (accessibilityNodeInfoG3 != null && accessibilityNodeInfoG3.getParent() != null) {
                TimerTask timerTask = x2.b;
                if (timerTask != null) {
                    timerTask.cancel();
                    x2.b = null;
                }
                for (int i = 0; i < accessibilityNodeInfoG3.getParent().getChildCount(); i++) {
                    if (accessibilityNodeInfoG3.getParent().getChild(i) != null && "android.widget.Switch".equals(accessibilityNodeInfoG3.getParent().getChild(i).getClassName()) && !accessibilityNodeInfoG3.getParent().getChild(i).isChecked()) {
                        com.acse.ottn.b.c().g(accessibilityNodeInfoG3);
                    }
                }
            }
            if (accessibilityNodeInfoG == null || accessibilityNodeInfoG.getParent() == null) {
                if (accessibilityNodeInfoG2 != null) {
                    TimerTask timerTask2 = x2.b;
                    if (timerTask2 != null) {
                        timerTask2.cancel();
                        x2.b = null;
                    }
                    com.acse.ottn.b.c().g(accessibilityNodeInfoG2);
                    x2.c(this.f23295a);
                    return;
                }
                return;
            }
            TimerTask timerTask3 = x2.b;
            if (timerTask3 != null) {
                timerTask3.cancel();
                x2.b = null;
            }
            for (int i2 = 0; i2 < accessibilityNodeInfoG.getParent().getChildCount(); i2++) {
                if ("android.widget.Switch".equals(accessibilityNodeInfoG.getParent().getChild(i2).getClassName()) && !accessibilityNodeInfoG.getParent().getChild(i2).isChecked()) {
                    com.acse.ottn.b.c().g(accessibilityNodeInfoG);
                }
            }
            x2.c(this.f23295a);
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            TimerTask timerTask = x2.b;
            if (timerTask != null) {
                timerTask.cancel();
                x2.b = null;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                if ("android.support.v7.widget.RecyclerView".equals(accessibilityNodeInfo.getChild(i).getClassName())) {
                    c = accessibilityNodeInfo.getChild(i);
                    return;
                } else {
                    if (accessibilityNodeInfo.getChild(i) != null) {
                        a(accessibilityNodeInfo.getChild(i));
                    }
                }
            }
        }
    }
}
