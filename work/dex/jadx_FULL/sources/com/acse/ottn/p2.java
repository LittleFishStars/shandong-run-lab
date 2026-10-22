package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.util.HelpShopAppUtil;
import com.igexin.assist.control.xiaomi.XmSystemUtils;
import com.igexin.sdk.PushConsts;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class p2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f23126a = "acse_MiuiUtils";
    public static boolean b = false;
    public static TimerTask c;
    public static AccessibilityNodeInfo d;

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f23129a;

        public c(AccessibilityService accessibilityService) {
            this.f23129a = accessibilityService;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.acse.ottn.b.c().e(this.f23129a);
        }
    }

    public static int b() throws Throwable {
        String strA = r3.a(XmSystemUtils.KEY_VERSION_MIUI);
        if (strA == null) {
            return -1;
        }
        try {
            return Integer.parseInt(strA.substring(1));
        } catch (Exception e2) {
            h2.b(f23126a, "get miui version code error, version : " + strA);
            h2.b(f23126a, Log.getStackTraceString(e2));
            return -1;
        }
    }

    public static void c(Activity activity, int i) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", activity.getPackageName());
        intent.setFlags(268435456);
        if (a(intent, activity)) {
            activity.startActivityForResult(intent, i);
        } else {
            h2.b(f23126a, "Intent is not available!");
        }
    }

    public static void d(Activity activity, int i) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", activity.getPackageName());
        intent.setFlags(268435456);
        if (a(intent, activity)) {
            activity.startActivityForResult(intent, i);
        } else {
            h2.b(f23126a, "Intent is not available!");
        }
    }

    public static void e(Activity activity, int i) {
        n3.a().a("battery_white", Boolean.TRUE);
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        intent.putExtra("extra_pkgname", activity.getPackageName());
        intent.setFlags(268435456);
        if (a(intent, activity)) {
            try {
                activity.startActivityForResult(intent, i);
                return;
            } catch (Exception unused) {
                l0.b(true);
                return;
            }
        }
        Intent intent2 = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent2.setPackage("com.miui.securitycenter");
        intent2.putExtra("extra_pkgname", activity.getPackageName());
        intent2.setFlags(268435456);
        if (!a(intent2, activity)) {
            h2.b(f23126a, "Intent is not available!");
            return;
        }
        try {
            activity.startActivityForResult(intent2, i);
        } catch (Exception unused2) {
            l0.b(true);
        }
    }

    @SuppressLint({"NewApi"})
    public static void f(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        }
        a(rootInActiveWindow, "str");
    }

    public static void g(AccessibilityService accessibilityService) {
        d = null;
        com.acse.ottn.b.c().a(500L);
        AccessibilityNodeInfo accessibilityNodeInfoJ = com.acse.ottn.b.c().j(accessibilityService, "安全");
        if (accessibilityNodeInfoJ != null) {
            com.acse.ottn.b.c().g(accessibilityNodeInfoJ);
        }
        c = n0.a().b(t0.b().b(3000), t0.b().b(500), new e(accessibilityService));
    }

    @SuppressLint({"NewApi"})
    public static void h(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        }
        a(rootInActiveWindow);
    }

    @RequiresApi(api = 16)
    public static void i(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(accessibilityService, "允许系统唤醒");
        AccessibilityNodeInfo accessibilityNodeInfoG2 = com.acse.ottn.b.c().g(accessibilityService, "允许被其他应用唤醒");
        if (accessibilityNodeInfoG != null && accessibilityNodeInfoG.getParent() != null) {
            for (int i = 0; i < accessibilityNodeInfoG.getParent().getChildCount(); i++) {
                if (accessibilityNodeInfoG.getParent().getChild(i) != null && "android.widget.CheckBox".equals(accessibilityNodeInfoG.getParent().getChild(i).getClassName())) {
                    if (!accessibilityNodeInfoG.getParent().getChild(i).isChecked()) {
                        com.acse.ottn.b.c().g(accessibilityNodeInfoG);
                        break;
                    }
                    break;
                }
            }
        }
        if (accessibilityNodeInfoG2 != null && accessibilityNodeInfoG2.getParent() != null) {
            for (int i2 = 0; i2 < accessibilityNodeInfoG2.getParent().getChildCount(); i2++) {
                if (accessibilityNodeInfoG2.getParent().getChild(i2) != null && "android.widget.CheckBox".equals(accessibilityNodeInfoG2.getParent().getChild(i2).getClassName())) {
                    if (!accessibilityNodeInfoG2.getParent().getChild(i2).isChecked()) {
                        com.acse.ottn.b.c().g(accessibilityNodeInfoG2);
                        break;
                    }
                    break;
                }
            }
        }
        com.acse.ottn.b.c().e(accessibilityService);
        com.acse.ottn.b.c().a(t0.b().b(200));
        com.acse.ottn.b.c().e(accessibilityService);
        l0.c(true);
    }

    @RequiresApi(api = 16)
    public static void j(AccessibilityService accessibilityService) {
        String strB = o1.c().b();
        h2.a(f23126a, strB);
        d = null;
        com.acse.ottn.b.c().a(t0.b().b(200));
        c = n0.a().b(t0.b().b(20000), t0.b().b(1000), new a(accessibilityService, strB));
    }

    public static void k(AccessibilityService accessibilityService) {
        h(accessibilityService);
    }

    public static void l(AccessibilityService accessibilityService) {
        com.acse.ottn.b.c().a(500L);
        AccessibilityNodeInfo accessibilityNodeInfoJ = com.acse.ottn.b.c().j(accessibilityService, "个性化广告推荐");
        if (accessibilityNodeInfoJ != null) {
            com.acse.ottn.b.c().g(accessibilityNodeInfoJ);
        }
        com.acse.ottn.b.c().e(accessibilityService);
        com.acse.ottn.b.c().a(200L);
        com.acse.ottn.b.c().e(accessibilityService);
        com.acse.ottn.b.c().a(200L);
        com.acse.ottn.b.c().e(accessibilityService);
        com.acse.ottn.b.c().a(200L);
        com.acse.ottn.b.c().e(accessibilityService);
    }

    public static void m(AccessibilityService accessibilityService) {
        d = null;
        c = n0.a().b(t0.b().b(3000), t0.b().b(500), new d(accessibilityService));
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
        } catch (Exception e2) {
            h2.b(f23126a, Log.getStackTraceString(e2));
            return false;
        }
    }

    public static void b(Activity activity, int i) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
        intent.setFlags(268435456);
        if (a(intent, activity)) {
            activity.startActivityForResult(intent, i);
        } else {
            h2.b(f23126a, "intent is not available!");
        }
    }

    public static void c(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo accessibilityNodeInfoJ = com.acse.ottn.b.c().j(accessibilityService, "确定");
        if (accessibilityNodeInfoJ == null) {
            accessibilityNodeInfoJ = com.acse.ottn.b.c().j(accessibilityService, "知道了");
        }
        if (accessibilityNodeInfoJ != null) {
            n3.a().a("auto_start_button", Boolean.TRUE);
            com.acse.ottn.b.c().a(t0.b().b(200));
            com.acse.ottn.b.c().g(accessibilityNodeInfoJ);
            com.acse.ottn.b.c().a(t0.b().b(500));
            com.acse.ottn.b.c().e(accessibilityService);
        }
        l0.c(true);
    }

    @RequiresApi(api = 16)
    public static void d(AccessibilityService accessibilityService) {
        d = null;
        com.acse.ottn.b.c().a(500L);
        AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(accessibilityService, "其他权限");
        if (accessibilityNodeInfoG != null) {
            h2.a("samonp-->", "appNodeInfo is not null=");
            com.acse.ottn.b.c().g(accessibilityNodeInfoG);
            n3 n3VarA = n3.a();
            Boolean bool = Boolean.TRUE;
            n3VarA.a("battery_white", bool);
            n3.a().a("is_pengpai", bool);
            return;
        }
        TimerTask timerTask = c;
        if (timerTask != null) {
            timerTask.cancel();
            c = null;
        }
        String strE = n3.a().e("OpenPermissionName");
        h2.a("samonp-->", "找到了悬浮窗=" + strE);
        if (strE.equals("定位")) {
            return;
        }
        c = n0.a().b(t0.b().b(6000), t0.b().b(500), new b(strE, accessibilityService));
    }

    public static void a(Activity activity, int i) {
        int iB = b();
        if (iB == 5) {
            b(activity, i);
            return;
        }
        if (iB == 6) {
            c(activity, i);
            return;
        }
        if (iB == 7) {
            d(activity, i);
            return;
        }
        if (iB == 8) {
            e(activity, i);
            return;
        }
        h2.b(f23126a, "this is a special MIUI rom version, its version code " + iB);
    }

    public static void b(Activity activity) {
        try {
            Intent intent = new Intent();
            ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
            intent.putExtra("extra_pkgname", activity.getPackageName());
            intent.setComponent(componentName);
            intent.addFlags(268435456);
            n3.a().a("battery_white", Boolean.TRUE);
            activity.startActivityForResult(intent, 10013);
        } catch (Exception unused) {
            l0.b(true);
        }
    }

    public class d implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f23130a;

        public d(AccessibilityService accessibilityService) {
            this.f23130a = accessibilityService;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            AccessibilityNodeInfo accessibilityNodeInfoJ = com.acse.ottn.b.c().j(this.f23130a, "隐私与安全");
            if (accessibilityNodeInfoJ == null) {
                com.acse.ottn.b.c().a(this.f23130a, p4.c(HelpShopAppUtil.getContext()) / 3, ((p4.b(HelpShopAppUtil.getContext()) * 2) / 3) + 300, (p4.c(HelpShopAppUtil.getContext()) / 3) + 100, p4.b(HelpShopAppUtil.getContext()) / 3, 300);
                return;
            }
            h2.a("samon-->111=", "333");
            com.acse.ottn.b.c().g(accessibilityNodeInfoJ);
            n3.a().a("oaid_permission", Boolean.TRUE);
            TimerTask timerTask = p2.c;
            if (timerTask != null) {
                timerTask.cancel();
                p2.c = null;
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            p2.c = null;
        }
    }

    public static boolean a(Intent intent, Activity activity) {
        return (intent == null || activity == null || activity.getPackageManager().queryIntentActivities(intent, 65536).size() <= 0) ? false : true;
    }

    public class a implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f23127a;
        public final /* synthetic */ String b;

        public a(AccessibilityService accessibilityService, String str) {
            this.f23127a = accessibilityService;
            this.b = str;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            try {
                AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f23127a, this.b);
                if (accessibilityNodeInfoG == null) {
                    if (HelpShopAppUtil.getContext() == null) {
                        return;
                    }
                    h2.a("samonp-->", "开始滑动");
                    if (p2.d == null) {
                        p2.h(this.f23127a);
                        return;
                    } else {
                        com.acse.ottn.b.c().b(p2.d);
                        return;
                    }
                }
                TimerTask timerTask = p2.c;
                if (timerTask != null) {
                    timerTask.cancel();
                    p2.c = null;
                }
                h2.a(p2.f23126a, "找到了");
                n3.a().a("battery_white", Boolean.TRUE);
                com.acse.ottn.b.c().g(accessibilityNodeInfoG);
                if ("samsung".equals(p4.b())) {
                    com.acse.ottn.b.c().a(t0.b().b(100));
                    com.acse.ottn.b.c().e(this.f23127a);
                }
            } catch (Exception e) {
                h2.a(p2.f23126a, "e =" + e.getMessage());
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            p2.c = null;
        }
    }

    public class e implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f23131a;

        public e(AccessibilityService accessibilityService) {
            this.f23131a = accessibilityService;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            AccessibilityNodeInfo accessibilityNodeInfoJ = com.acse.ottn.b.c().j(this.f23131a, "更多安全设置");
            if (accessibilityNodeInfoJ == null) {
                com.acse.ottn.b.c().a(this.f23131a, p4.c(HelpShopAppUtil.getContext()) / 3, ((p4.b(HelpShopAppUtil.getContext()) * 2) / 3) + 300, (p4.c(HelpShopAppUtil.getContext()) / 3) + 100, p4.b(HelpShopAppUtil.getContext()) / 3, 300);
                return;
            }
            h2.a("samon-->111=", "333");
            com.acse.ottn.b.c().g(accessibilityNodeInfoJ);
            com.acse.ottn.b.c().a(500L);
            AccessibilityNodeInfo accessibilityNodeInfoJ2 = com.acse.ottn.b.c().j(this.f23131a, "广告服务");
            if (accessibilityNodeInfoJ2 != null) {
                com.acse.ottn.b.c().g(accessibilityNodeInfoJ2);
                n3.a().a("oaid_permission", Boolean.TRUE);
                TimerTask timerTask = p2.c;
                if (timerTask != null) {
                    timerTask.cancel();
                    p2.c = null;
                }
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            p2.c = null;
        }
    }

    @RequiresApi(api = 16)
    public static void a(String str, AccessibilityService accessibilityService) {
        AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(accessibilityService, str);
        if (accessibilityNodeInfoG == null || accessibilityNodeInfoG.getParent() == null) {
            return;
        }
        for (int i = 0; i < accessibilityNodeInfoG.getParent().getChildCount(); i++) {
            if (accessibilityNodeInfoG.getParent().getChild(i) != null && "android.widget.CheckBox".equals(accessibilityNodeInfoG.getParent().getChild(i).getClassName())) {
                if (!accessibilityNodeInfoG.getParent().getChild(i).isChecked()) {
                    com.acse.ottn.b.c().g(accessibilityNodeInfoG.getParent().getChild(i));
                }
                l0.b(true);
                return;
            }
        }
    }

    public static void c(Activity activity) {
        a(activity);
    }

    @RequiresApi(api = 16)
    public static void e(AccessibilityService accessibilityService) {
        TimerTask timerTask = c;
        if (timerTask != null) {
            timerTask.cancel();
            c = null;
        }
        com.acse.ottn.b.c().a(500L);
        AccessibilityNodeInfo accessibilityNodeInfoH = com.acse.ottn.b.c().h(accessibilityService, "允许显示在其他应用的上层");
        h2.a("samonp-->", "---------------------");
        h(accessibilityService);
        if (accessibilityNodeInfoH == null) {
            h2.a("samonp-->", "没有找到了=允许显示在其他应用的上层");
            AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(accessibilityService, "显示在其他应用的上层");
            AccessibilityNodeInfo accessibilityNodeInfoG2 = com.acse.ottn.b.c().g(accessibilityService, "允许此应用显示在您当前使用的其他应用的上层。此应用将能得知您点按的位置或更改屏幕上显示的内容。");
            if (accessibilityNodeInfoG2 == null || accessibilityNodeInfoG == null) {
                return;
            }
            Rect rect = new Rect();
            accessibilityNodeInfoG.getBoundsInScreen(rect);
            Rect rect2 = new Rect();
            accessibilityNodeInfoG2.getBoundsInScreen(rect2);
            int i = rect.right / 2;
            int i2 = rect2.top;
            int i3 = rect.bottom;
            int i4 = ((i2 - i3) / 2) + i3;
            h2.a("samonp-->", "x= " + i + "   y = " + i4);
            com.acse.ottn.b.c().a(accessibilityService, i, i4);
            h2.a(f23126a, "点击了");
        } else {
            h2.a("samonp-->", "找到了=允许显示在其他应用的上层");
            com.acse.ottn.b.c().g(accessibilityNodeInfoH);
        }
        com.acse.ottn.b.c().a(300L);
        com.acse.ottn.b.c().e(accessibilityService);
        if (Build.VERSION.SDK_INT >= 30) {
            com.acse.ottn.b.c().e(accessibilityService);
        }
    }

    @RequiresApi(api = 16)
    public static void b(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(accessibilityService, "自启动");
        if (accessibilityNodeInfoG == null) {
            return;
        }
        com.acse.ottn.b.c().g(accessibilityNodeInfoG);
        com.acse.ottn.b.c().a(t0.b().b(300));
        a("允许系统唤醒", accessibilityService);
        com.acse.ottn.b.c().e(accessibilityService);
        n3.a().a("battery_white", Boolean.FALSE);
        com.acse.ottn.b.c().e(accessibilityService);
    }

    public static void a(Activity activity) {
        n3 n3VarA = n3.a();
        Boolean bool = Boolean.TRUE;
        n3VarA.a("battery_white", bool);
        n3.a().a("background_battery_hignt", bool);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
        try {
            activity.startActivityForResult(intent, PushConsts.ACTION_POPUP_SHOW);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @RequiresApi(api = 16)
    public static void b(String str, AccessibilityService accessibilityService) {
        AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(accessibilityService, str);
        if (accessibilityNodeInfoG == null || accessibilityNodeInfoG.getParent() == null) {
            return;
        }
        for (int i = 0; i < accessibilityNodeInfoG.getParent().getChildCount(); i++) {
            if (accessibilityNodeInfoG.getParent().getChild(i) != null && "android.widget.CheckBox".equals(accessibilityNodeInfoG.getParent().getChild(i).getClassName())) {
                if (accessibilityNodeInfoG.getParent().getChild(i).isChecked()) {
                    break;
                }
                com.acse.ottn.b.c().g(accessibilityNodeInfoG.getParent().getChild(i));
                com.acse.ottn.b.c().a(t0.b().b(100));
                c(accessibilityService);
                return;
            }
        }
        if (!n3.a().a("auto_start_button")) {
            com.acse.ottn.b.c().g(accessibilityNodeInfoG);
            c(accessibilityService);
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new c(accessibilityService), 500L);
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                h2.a("samonp-->", accessibilityNodeInfo.getChild(i).toString());
                if (accessibilityNodeInfo.getChild(i) != null && ("android.widget.ListView".equals(accessibilityNodeInfo.getChild(i).getClassName()) || "androidx.recyclerview.widget.RecyclerView".equals(accessibilityNodeInfo.getChild(i).getClassName()))) {
                    d = accessibilityNodeInfo.getChild(i);
                    return;
                } else {
                    if (accessibilityNodeInfo.getChild(i) != null) {
                        a(accessibilityNodeInfo.getChild(i));
                    }
                }
            }
        }
    }

    public class b implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f23128a;
        public final /* synthetic */ AccessibilityService b;

        public b(String str, AccessibilityService accessibilityService) {
            this.f23128a = str;
            this.b = accessibilityService;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            h2.a("samon-->", "clickHouTaiShowPage倒计时 =" + this.f23128a);
            try {
                if (this.f23128a == null) {
                    return;
                }
                AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.b, this.f23128a);
                if (accessibilityNodeInfoG == null) {
                    h2.a("samonp-->", "appNodeInfo is null");
                    if (HelpShopAppUtil.getContext() == null) {
                        return;
                    }
                    h2.a("samonp-->", "开始滑动");
                    p2.h(this.b);
                    if (p2.d != null) {
                        com.acse.ottn.b.c().b(p2.d);
                        return;
                    }
                    return;
                }
                h2.a("samonp-->", "appNodeInfo is not null");
                TimerTask timerTask = p2.c;
                if (timerTask != null) {
                    timerTask.cancel();
                    p2.c = null;
                }
                h2.a(p2.f23126a, "找到了");
                com.acse.ottn.b.c().g(accessibilityNodeInfoG);
                n3.a().a("battery_white", Boolean.FALSE);
                com.acse.ottn.b.c().a(t0.b().b(500));
                AccessibilityNodeInfo accessibilityNodeInfoJ = com.acse.ottn.b.c().j(this.b, "始终允许");
                AccessibilityNodeInfo accessibilityNodeInfoJ2 = com.acse.ottn.b.c().j(this.b, "允许");
                if (accessibilityNodeInfoJ != null) {
                    h2.a("samonp-->", "appinfo is not null");
                    com.acse.ottn.b.c().g(accessibilityNodeInfoJ);
                    com.acse.ottn.b.c().a(t0.b().b(200));
                    com.acse.ottn.b.c().e(this.b);
                } else if (accessibilityNodeInfoJ2 != null) {
                    com.acse.ottn.b.c().g(accessibilityNodeInfoJ2);
                    com.acse.ottn.b.c().a(t0.b().b(200));
                    com.acse.ottn.b.c().e(this.b);
                    h2.a("samonp-->", "appinfo1 is not null");
                }
                if (n3.a().a("is_pengpai")) {
                    com.acse.ottn.b.c().e(this.b);
                    com.acse.ottn.b.c().a(t0.b().b(100));
                    com.acse.ottn.b.c().e(this.b);
                }
            } catch (Exception e) {
                h2.a(p2.f23126a, "e =" + e.getMessage());
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            p2.c = null;
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) {
            if (accessibilityNodeInfo != null) {
                for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                    try {
                        if (accessibilityNodeInfo.getChild(i) != null) {
                            a(accessibilityNodeInfo.getChild(i), str);
                        }
                    } catch (Throwable th) {
                        h2.a(f23126a, th.getMessage());
                    }
                }
                return;
            }
            return;
        }
        h2.a("samon-->", accessibilityNodeInfo.toString());
        if (!TextUtils.isEmpty(accessibilityNodeInfo.getText())) {
            String strTrim = accessibilityNodeInfo.getText().toString().trim();
            h2.a("samon-->content=", strTrim);
            if (strTrim.equals(str)) {
                d = accessibilityNodeInfo;
                h2.a("samon-->111=", "1111");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(accessibilityNodeInfo.getContentDescription())) {
            return;
        }
        String string = accessibilityNodeInfo.getContentDescription().toString();
        h2.a("samon-->ContentDescription=", string);
        if (string.equals(str)) {
            d = accessibilityNodeInfo;
            h2.a("samon-->111=", "2222");
        }
    }
}
