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
import android.provider.Settings;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.util.HelpShopAppUtil;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.igexin.sdk.PushConsts;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f22883a = "acse_VivoUtils";
    public static TimerTask d;
    public static Long b = 0L;
    public static String c = "0";
    public static AccessibilityNodeInfo e = null;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f22884a;

        public a(AccessibilityService accessibilityService) {
            this.f22884a = accessibilityService;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b5.c.equals("0")) {
                b5.c = "2";
                h2.a(b5.f22883a, "clickType type 返回");
                b5.h(this.f22884a);
            }
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f22887a;

        public d(AccessibilityService accessibilityService) {
            this.f22887a = accessibilityService;
        }

        @Override // java.lang.Runnable
        public void run() {
            b5.a(this.f22887a, Long.valueOf(System.currentTimeMillis()).longValue());
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f22888a;

        public e(AccessibilityService accessibilityService) {
            this.f22888a = accessibilityService;
        }

        @Override // java.lang.Runnable
        public void run() {
            b5.a(this.f22888a, Long.valueOf(System.currentTimeMillis()).longValue());
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f22890a;

        public g(AccessibilityService accessibilityService) {
            this.f22890a = accessibilityService;
        }

        @Override // java.lang.Runnable
        public void run() {
            AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f22890a, "自启动");
            if (accessibilityNodeInfoG == null || accessibilityNodeInfoG.getParent() == null) {
                h2.a(b5.f22883a, "not find auto start");
                return;
            }
            h2.a(b5.f22883a, "自启动 找到");
            if (!b5.b(this.f22890a, accessibilityNodeInfoG.getParent(), true)) {
                b5.b(this.f22890a, accessibilityNodeInfoG.getParent().getParent(), false);
                n3.a().a("vivo_auto_start", Boolean.TRUE);
            }
            l0.b(true);
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f22891a;

        public h(AccessibilityService accessibilityService) {
            this.f22891a = accessibilityService;
        }

        @Override // java.lang.Runnable
        public void run() {
            AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f22891a, "后台弹出界面");
            if (accessibilityNodeInfoG == null || accessibilityNodeInfoG.getParent() == null) {
                h2.a(b5.f22883a, "后台弹出界面 没找到");
                return;
            }
            h2.a(b5.f22883a, "后台弹出界面 找到");
            if (b5.b(this.f22891a, accessibilityNodeInfoG.getParent(), true)) {
                return;
            }
            b5.b(this.f22891a, accessibilityNodeInfoG.getParent().getParent(), false);
            n3.a().a("vivo_service_show_view", Boolean.TRUE);
        }
    }

    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f22892a;

        public i(AccessibilityService accessibilityService) {
            this.f22892a = accessibilityService;
        }

        @Override // java.lang.Runnable
        public void run() {
            AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f22892a, "悬浮窗");
            if (accessibilityNodeInfoG == null || accessibilityNodeInfoG.getParent() == null) {
                return;
            }
            h2.a(b5.f22883a, "悬浮窗");
            if (b5.b(this.f22892a, accessibilityNodeInfoG.getParent(), true)) {
                return;
            }
            b5.b(this.f22892a, accessibilityNodeInfoG.getParent().getParent(), false);
        }
    }

    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22893a;
        public final /* synthetic */ AccessibilityService b;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b5.c.equals("0")) {
                    b5.c = "2";
                    h2.a(b5.f22883a, "clickType type 1 返回");
                    b5.h(j.this.b);
                }
            }
        }

        public j(String str, AccessibilityService accessibilityService) {
            this.f22893a = str;
            this.b = accessibilityService;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n3.a().a("correlation_start") && this.f22893a.equals("2")) {
                h2.a(b5.f22883a, "关联启动 已经打开");
                return;
            }
            AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.b, "关联启动");
            if (accessibilityNodeInfoG == null || accessibilityNodeInfoG.getParent() == null) {
                h2.a(b5.f22883a, "关联启动 没找到");
                return;
            }
            h2.a(b5.f22883a, "关联启动 找到");
            l0.b(true);
            n3.a().a("allow_button", Boolean.TRUE);
            if (!b5.b(this.b, accessibilityNodeInfoG.getParent(), true)) {
                b5.b(this.b, accessibilityNodeInfoG.getParent().getParent(), false);
            }
            new Handler(Looper.getMainLooper()).postDelayed(new a(), 1000L);
        }
    }

    public static void b(Activity activity) {
        if (n3.a() != null) {
            n3.a().a("battery_white", Boolean.TRUE);
        }
        try {
            c = "0";
            Intent intent = new Intent();
            intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
            intent.putExtra("packagename", activity.getPackageName());
            intent.putExtra("tabId", "1");
            activity.startActivityForResult(intent, 10013);
        } catch (Exception unused) {
            Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent2.setData(Uri.fromParts("package", activity.getPackageName(), null));
            activity.startActivityForResult(intent2, 10013);
        }
    }

    @RequiresApi(api = 16)
    public static void c(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(accessibilityService, "允许显示在其他应用的上层");
        if (accessibilityNodeInfoG != null || accessibilityNodeInfoG.getParent() == null) {
            for (int i2 = 0; i2 < accessibilityNodeInfoG.getParent().getChildCount(); i2++) {
                if (accessibilityNodeInfoG.getParent().getChild(i2) != null && "android.widget.Switch".equals(accessibilityNodeInfoG.getParent().getChild(i2).getClassName())) {
                    com.acse.ottn.b.c().g(accessibilityNodeInfoG.getParent().getChild(i2));
                    com.acse.ottn.b.c().e(accessibilityService);
                    return;
                }
            }
        }
    }

    public static void d(AccessibilityService accessibilityService) {
        com.acse.ottn.b.c().a(t0.b().b(200));
        AccessibilityNodeInfo accessibilityNodeInfoJ = com.acse.ottn.b.c().j(accessibilityService, "后台耗电管理");
        AccessibilityNodeInfo accessibilityNodeInfoJ2 = com.acse.ottn.b.c().j(accessibilityService, "后台高耗电");
        if (accessibilityNodeInfoJ != null) {
            h2.a(f22883a, "clickServiceBackgroundHight info is not null");
            if (n3.a() != null) {
                n3.a().a("battery_white", Boolean.TRUE);
            }
            com.acse.ottn.b.c().g(accessibilityNodeInfoJ);
            new Handler(Looper.getMainLooper()).postDelayed(new d(accessibilityService), 1000L);
            return;
        }
        if (accessibilityNodeInfoJ2 != null) {
            h2.a(f22883a, "clickServiceBackgroundHight info2 is not null");
            if (n3.a() != null) {
                h2.a(f22883a, "clickServiceBackgroundHight QuickPreference is not null");
                n3.a().a("battery_white", Boolean.TRUE);
            }
            com.acse.ottn.b.c().g(accessibilityNodeInfoJ2);
            new Handler(Looper.getMainLooper()).postDelayed(new e(accessibilityService), 1000L);
        }
    }

    public static void e(AccessibilityService accessibilityService) {
        String strB = o1.c().b();
        com.acse.ottn.b.c().a(300L);
        if (com.acse.ottn.b.c().h(accessibilityService, strB) == null) {
            h2.a(f22883a, "findAppName 不存在=" + strB);
            return;
        }
        AccessibilityNodeInfo accessibilityNodeInfoJ = com.acse.ottn.b.c().j(accessibilityService, "今日不再提醒");
        if (accessibilityNodeInfoJ != null) {
            com.acse.ottn.b.c().g(accessibilityNodeInfoJ);
        }
        h2.a(f22883a, "findAppName 存在=" + strB);
        AccessibilityNodeInfo accessibilityNodeInfoH = com.acse.ottn.b.c().h(accessibilityService, "始终打开");
        h2.a(f22883a, "findAppName 存在始终打开");
        if (accessibilityNodeInfoH != null) {
            Rect rect = new Rect();
            accessibilityNodeInfoH.getBoundsInScreen(rect);
            int i2 = rect.right;
            int i3 = rect.left;
            int i4 = ((i2 - i3) / 2) + i3;
            int i5 = rect.bottom;
            int i6 = rect.top;
            int i7 = ((i5 - i6) / 2) + i6;
            h2.a(f22883a, "findAppName x=" + i4 + "     y=" + i7);
            com.acse.ottn.b.c().a(accessibilityService, i4, i7);
            return;
        }
        AccessibilityNodeInfo accessibilityNodeInfoH2 = com.acse.ottn.b.c().h(accessibilityService, "30天内允许");
        h2.a(f22883a, "findAppName 存在始终打开");
        if (accessibilityNodeInfoH2 != null) {
            Rect rect2 = new Rect();
            accessibilityNodeInfoH2.getBoundsInScreen(rect2);
            int i8 = rect2.right;
            int i9 = rect2.left;
            int i10 = ((i8 - i9) / 2) + i9;
            int i11 = rect2.bottom;
            int i12 = rect2.top;
            int i13 = ((i11 - i12) / 2) + i12;
            h2.a(f22883a, "findAppName x=" + i10 + "     y=" + i13);
            com.acse.ottn.b.c().a(accessibilityService, i10, i13);
            return;
        }
        AccessibilityNodeInfo accessibilityNodeInfoJ2 = com.acse.ottn.b.c().j(accessibilityService, "始终允许");
        if (accessibilityNodeInfoJ2 != null) {
            h2.a(f22883a, "findAppName 始终允许");
            com.acse.ottn.b.c().g(accessibilityNodeInfoJ2);
            return;
        }
        AccessibilityNodeInfo accessibilityNodeInfoJ3 = com.acse.ottn.b.c().j(accessibilityService, "允许");
        if (accessibilityNodeInfoJ3 != null) {
            h2.a(f22883a, "findAppName 允许");
            com.acse.ottn.b.c().g(accessibilityNodeInfoJ3);
            return;
        }
        AccessibilityNodeInfo accessibilityNodeInfoJ4 = com.acse.ottn.b.c().j(accessibilityService, "始终允许打开");
        if (accessibilityNodeInfoJ4 != null) {
            h2.a(f22883a, "findAppName 始终允许打开");
            com.acse.ottn.b.c().g(accessibilityNodeInfoJ4);
        }
        AccessibilityNodeInfo accessibilityNodeInfoJ5 = com.acse.ottn.b.c().j(accessibilityService, com.ipd.dsp.internal.b1.b.a.p);
        if (accessibilityNodeInfoJ5 != null) {
            h2.a(f22883a, "findAppName 打开");
            com.acse.ottn.b.c().g(accessibilityNodeInfoJ5);
        }
        com.acse.ottn.b.c().i(accessibilityService, "允许");
    }

    @SuppressLint({"NewApi"})
    public static void f(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        }
        a(rootInActiveWindow);
    }

    @SuppressLint({"NewApi"})
    public static void g(AccessibilityService accessibilityService) {
        h2.a(f22883a, "findAppName 开始");
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            h2.a(f22883a, "findAppName null");
            rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        }
        b(rootInActiveWindow);
    }

    public static void h(AccessibilityService accessibilityService) {
        try {
            t0.a(accessibilityService, "vivo_permission");
        } catch (Exception unused) {
        }
        com.acse.ottn.b.c().e(accessibilityService);
    }

    public static void i(AccessibilityService accessibilityService) {
        com.acse.ottn.b.c().g(com.acse.ottn.b.c().a(accessibilityService, "权限", true));
        com.acse.ottn.b.c().a(t0.b().b(500));
        AccessibilityNodeInfo accessibilityNodeInfoA = com.acse.ottn.b.c().a(accessibilityService, "自启动", true);
        if (accessibilityNodeInfoA != null) {
            com.acse.ottn.b.c().g(accessibilityNodeInfoA);
        }
    }

    @RequiresApi(api = 16)
    public static void j(AccessibilityService accessibilityService) {
        String strB = o1.c().b();
        h2.a(f22883a, strB);
        d = n0.a().b(t0.b().b(20000), t0.b().b(100), new b(accessibilityService, strB));
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
        } catch (Exception e2) {
            h2.b(f22883a, Log.getStackTraceString(e2));
            return false;
        }
    }

    public static boolean c(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        int i2;
        for (int i3 = 0; i3 < accessibilityNodeInfo.getChildCount(); i3++) {
            if (accessibilityNodeInfo.getChild(i3) != null && ("android.widget.Switch".equals(accessibilityNodeInfo.getChild(i3).getClassName()) || DefaultTimeBar.f4729f.equals(accessibilityNodeInfo.getChild(i3).getClassName()))) {
                h2.a(f22883a, "find auto Switch");
                if (!accessibilityNodeInfo.getChild(i3).isChecked()) {
                    Rect rect = new Rect();
                    accessibilityNodeInfo.getChild(i3).getBoundsInScreen(rect);
                    h2.a(f22883a, "left=" + rect.left + "   right=" + rect.right);
                    h2.a(f22883a, "top=" + rect.top + "   bottom=" + rect.bottom);
                    int i4 = rect.bottom;
                    int i5 = rect.top;
                    int i6 = ((i4 - i5) / 2) + i5;
                    if (z) {
                        int i7 = rect.right;
                        int i8 = rect.left;
                        i2 = ((i7 - i8) / 2) + i8;
                    } else {
                        i2 = (rect.right - rect.left) - 50;
                    }
                    h2.a(f22883a, "start  click Switch x=" + i2 + "  y=" + i6);
                    com.acse.ottn.b.c().a(accessibilityService, i2, i6);
                    return true;
                }
                h2.a(f22883a, "start is open");
            }
        }
        return false;
    }

    public class b implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f22885a;
        public final /* synthetic */ String b;

        public b(AccessibilityService accessibilityService, String str) {
            this.f22885a = accessibilityService;
            this.b = str;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            b5.f(this.f22885a);
            try {
                if (com.acse.ottn.b.c().g(this.f22885a, this.b) != null) {
                    TimerTask timerTask = b5.d;
                    if (timerTask != null) {
                        timerTask.cancel();
                        b5.d = null;
                    }
                } else if (b5.e != null) {
                    com.acse.ottn.b.c().b(b5.e);
                }
            } catch (Exception e) {
                h2.a(b5.f22883a, "e =" + e.getMessage());
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            b5.d = null;
        }
    }

    public static void a(Activity activity, int i2) {
        try {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity"));
            activity.startActivityForResult(intent, i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void b() {
        TimerTask timerTask = d;
        if (timerTask != null) {
            timerTask.cancel();
            d = null;
        }
    }

    public static void a(Activity activity) {
        try {
            if (n3.a() != null) {
                n3.a().a("battery_white", Boolean.TRUE);
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.iqoo.powersaving", "com.iqoo.powersaving.PowerSavingManagerActivity"));
            activity.startActivityForResult(intent, PushConsts.ACTION_NOTIFICATION_ENABLE);
        } catch (Exception e2) {
            h2.a(f22883a, e2.getMessage());
            l0.c(true);
            n3.a().b("battery_hignt_size", "2");
        }
    }

    public static void b(AccessibilityService accessibilityService) {
        Long lValueOf;
        String strE = n3.a().e("auto_start");
        String strE2 = n3.a().e("relevancy_start");
        String strE3 = n3.a().e("service_show_view");
        boolean zA = n3.a().a("vivo_auto_start");
        boolean zA2 = n3.a().a("vivo_service_show_view");
        Long lValueOf2 = 0L;
        if (!strE.equals("1") && !zA) {
            h2.a(f22883a, "自启动 time =" + lValueOf2);
            new Handler(Looper.getMainLooper()).postDelayed(new g(accessibilityService), lValueOf2.longValue());
            lValueOf2 = Long.valueOf(lValueOf2.longValue() + 350);
        }
        if (!strE3.equals("1") && !zA2) {
            h2.a(f22883a, "后台弹出界面 time =" + lValueOf2);
            new Handler(Looper.getMainLooper()).postDelayed(new h(accessibilityService), lValueOf2.longValue());
            lValueOf2 = Long.valueOf(lValueOf2.longValue() + 350);
        }
        if (!Settings.canDrawOverlays(accessibilityService)) {
            new Handler(Looper.getMainLooper()).postDelayed(new i(accessibilityService), lValueOf2.longValue());
            lValueOf2 = Long.valueOf(lValueOf2.longValue() + 350);
        }
        if (!strE2.equals("1")) {
            h2.a(f22883a, "关联启动 time =" + lValueOf2);
            new Handler(Looper.getMainLooper()).postDelayed(new j(strE2, accessibilityService), lValueOf2.longValue());
        }
        if (!strE2.equals("1")) {
            lValueOf = Long.valueOf(lValueOf2.longValue() + 1000);
        } else {
            lValueOf = Long.valueOf(lValueOf2.longValue() + 200);
        }
        new Handler(Looper.getMainLooper()).postDelayed(new a(accessibilityService), lValueOf.longValue());
    }

    public static void c() {
        if (d != null) {
            h2.a(f22883a, "结束循环");
            d.cancel();
            d = null;
            return;
        }
        h2.a(f22883a, "timer ==null");
    }

    public class c implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f22886a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;

        public c(AccessibilityService accessibilityService, String str, boolean z) {
            this.f22886a = accessibilityService;
            this.b = str;
            this.c = z;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            b5.f(this.f22886a);
            try {
                AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f22886a, this.b);
                if (accessibilityNodeInfoG == null) {
                    if (b5.e != null) {
                        h2.a(b5.f22883a, "clickSoftList 滑动");
                        com.acse.ottn.b.c().a(this.f22886a, p4.c(HelpShopAppUtil.getContext()) / 3, ((p4.b(HelpShopAppUtil.getContext()) * 2) / 3) + 300, (p4.c(HelpShopAppUtil.getContext()) / 3) + 100, p4.b(HelpShopAppUtil.getContext()) / 3, 500);
                        return;
                    }
                    return;
                }
                TimerTask timerTask = b5.d;
                if (timerTask != null) {
                    timerTask.cancel();
                    b5.d = null;
                }
                h2.a(b5.f22883a, "找到了 =" + this.b);
                if (accessibilityNodeInfoG.getParent() != null) {
                    com.acse.ottn.b.c().a(t0.b().b(2000));
                    b5.b(this.f22886a, com.acse.ottn.b.c().g(this.f22886a, this.b).getParent().getParent(), false);
                    if (this.c) {
                        h2.a(b5.f22883a, "电池");
                        l0.b(true);
                    }
                    com.acse.ottn.b.c().a(t0.b().b(500));
                    com.acse.ottn.b.c().e(this.f22886a);
                }
            } catch (Exception e) {
                h2.a(b5.f22883a, "clickSoftList e =" + e.getMessage());
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            h2.a(b5.f22883a, "clickSoftList onFinish");
            b5.d = null;
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i2 = 0; i2 < accessibilityNodeInfo.getChildCount(); i2++) {
                Log.d(f22883a, accessibilityNodeInfo.toString());
                if (accessibilityNodeInfo.getChild(i2) != null && ("android.widget.ListView".equals(accessibilityNodeInfo.getChild(i2).getClassName()) || "androidx.recyclerview.widget.RecyclerView".equals(accessibilityNodeInfo.getChild(i2).getClassName()))) {
                    e = accessibilityNodeInfo.getChild(i2);
                    return;
                } else {
                    if (accessibilityNodeInfo.getChild(i2) != null) {
                        a(accessibilityNodeInfo.getChild(i2));
                    }
                }
            }
        }
    }

    @RequiresApi(api = 16)
    public static void a(AccessibilityService accessibilityService, boolean z) {
        String strB = o1.c().b();
        h2.a(f22883a, "clickSoftList");
        d = n0.a().b(t0.b().b(15000), t0.b().b(500), new c(accessibilityService, strB, z));
    }

    @RequiresApi(api = 16)
    public static void a(AccessibilityService accessibilityService, long j2) {
        n3.a().a("battery_white", Boolean.FALSE);
        if (j2 - b.longValue() < 5000) {
            h2.a(f22883a, "间隔 t=" + j2 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
            h2.a(f22883a, "间隔 time=" + b + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - b.longValue()));
            return;
        }
        h2.a(f22883a, "无间隔 t=" + j2 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
        h2.a(f22883a, "无间隔 time=" + b + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - b.longValue()));
        b = Long.valueOf(j2);
        h2.a(f22883a, "buttery backgroundHightBattery");
        d = n0.a().b(t0.b().b(5000), t0.b().b(150), new f(accessibilityService, o1.c().b()));
    }

    public class f implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f22889a;
        public final /* synthetic */ String b;

        public f(AccessibilityService accessibilityService, String str) {
            this.f22889a = accessibilityService;
            this.b = str;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            b5.f(this.f22889a);
            try {
                AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f22889a, this.b);
                if (accessibilityNodeInfoG == null) {
                    if (b5.e != null) {
                        com.acse.ottn.b.c().b(b5.e);
                        return;
                    }
                    return;
                }
                TimerTask timerTask = b5.d;
                if (timerTask != null) {
                    timerTask.cancel();
                    b5.d = null;
                }
                h2.a(b5.f22883a, "buttery find");
                com.acse.ottn.b.c().g(accessibilityNodeInfoG);
                com.acse.ottn.b.c().a(t0.b().b(200));
                AccessibilityNodeInfo accessibilityNodeInfoG2 = com.acse.ottn.b.c().g(this.f22889a, "允许后台高耗电");
                AccessibilityNodeInfo accessibilityNodeInfoG3 = com.acse.ottn.b.c().g(this.f22889a, "允许后台耗电");
                if (accessibilityNodeInfoG2 != null) {
                    h2.a(b5.f22883a, "buttery info is not null");
                    com.acse.ottn.b.c().g(accessibilityNodeInfoG2);
                    l0.c(true);
                } else if (accessibilityNodeInfoG3 != null) {
                    com.acse.ottn.b.c().g(accessibilityNodeInfoG3);
                    l0.c(true);
                } else {
                    h2.a(b5.f22883a, "buttery info is null");
                    if (accessibilityNodeInfoG.getParent() != null) {
                        h2.a(b5.f22883a, "buttery start");
                        for (int i = 0; i < accessibilityNodeInfoG.getParent().getChildCount(); i++) {
                            if (accessibilityNodeInfoG.getParent().getChild(i) != null && "android.widget.Switch".equals(accessibilityNodeInfoG.getParent().getChild(i).getClassName())) {
                                h2.a(b5.f22883a, "find buttery Switch");
                                if (!accessibilityNodeInfoG.getParent().getChild(i).isChecked()) {
                                    Rect rect = new Rect();
                                    accessibilityNodeInfoG.getParent().getChild(i).getBoundsInScreen(rect);
                                    int i2 = rect.right;
                                    int i3 = rect.left;
                                    int i4 = ((i2 - i3) / 2) + i3;
                                    int i5 = rect.bottom;
                                    int i6 = rect.top;
                                    com.acse.ottn.b.c().a(this.f22889a, i4, ((i5 - i6) / 2) + i6);
                                }
                            }
                        }
                    }
                }
                h2.a(b5.f22883a, "backgroundHightBattery comeBack");
                com.acse.ottn.b.c().a(t0.b().b(300));
                com.acse.ottn.b.c().e(this.f22889a);
                com.acse.ottn.b.c().a(t0.b().b(300));
                com.acse.ottn.b.c().e(this.f22889a);
                com.acse.ottn.b.c().a(t0.b().b(300));
                com.acse.ottn.b.c().e(this.f22889a);
            } catch (Exception e) {
                h2.a(b5.f22883a, "backgroundHightBattery e =" + e.getMessage());
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            b5.d = null;
        }
    }

    @SuppressLint({"NewApi"})
    public static void b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i2 = 0; i2 < accessibilityNodeInfo.getChildCount(); i2++) {
                if (accessibilityNodeInfo.getChild(i2) != null) {
                    h2.a(f22883a, "info.getChild(i)=" + accessibilityNodeInfo.getChild(i2).toString());
                    if (accessibilityNodeInfo.getText() != null) {
                        h2.c("findAppName-->", "找到标题title= in.getClassName()=" + accessibilityNodeInfo.getText().toString().trim());
                    }
                    if (accessibilityNodeInfo.getContentDescription() != null) {
                        h2.c("findAppName-->", "找到标题title= in.getContentDescription()=" + accessibilityNodeInfo.getContentDescription().toString().trim());
                    }
                } else if (accessibilityNodeInfo.getChild(i2) != null) {
                    b(accessibilityNodeInfo.getChild(i2));
                }
            }
        }
    }

    public static boolean b(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        int i2;
        for (int i3 = 0; i3 < accessibilityNodeInfo.getChildCount(); i3++) {
            if (accessibilityNodeInfo.getChild(i3) != null && ("android.widget.Switch".equals(accessibilityNodeInfo.getChild(i3).getClassName()) || DefaultTimeBar.f4729f.equals(accessibilityNodeInfo.getChild(i3).getClassName()))) {
                h2.a(f22883a, "find auto Switch");
                if (!accessibilityNodeInfo.getChild(i3).isChecked()) {
                    Rect rect = new Rect();
                    accessibilityNodeInfo.getChild(i3).getBoundsInScreen(rect);
                    h2.a(f22883a, "left=" + rect.left + "   right=" + rect.right);
                    int iC = p4.c(accessibilityService);
                    int i4 = Build.VERSION.SDK_INT;
                    if (i4 > 34) {
                        int i5 = rect.right;
                        if (i5 > iC) {
                            int i6 = rect.left;
                            i5 = ((i5 - i6) / 2) + i6;
                        } else if (z) {
                            int i7 = rect.left;
                            i2 = ((i5 - i7) / 2) + i7;
                        } else {
                            iC = rect.left / 2;
                        }
                        i2 = i5 - iC;
                    } else if (i4 == 34) {
                        i2 = rect.right - 130;
                    } else {
                        i2 = rect.right - 90;
                    }
                    int i8 = rect.bottom;
                    int i9 = rect.top;
                    int i10 = ((i8 - i9) / 2) + i9;
                    h2.a(f22883a, "start  click Switch x=" + i2 + "  y=" + i10);
                    com.acse.ottn.b.c().a(accessibilityService, i2 + (-30), i10);
                    return true;
                }
                h2.a(f22883a, "start is open");
            }
        }
        return false;
    }
}
