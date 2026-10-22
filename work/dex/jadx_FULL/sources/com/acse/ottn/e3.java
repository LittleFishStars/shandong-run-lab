package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.util.HelpShopAppUtil;
import com.igexin.assist.control.xiaomi.XmSystemUtils;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f22979a = "OnePlusUtils";
    public static boolean b = false;
    public static TimerTask c;
    public static AccessibilityNodeInfo d;

    public static int a() throws Throwable {
        String strA = r3.a(XmSystemUtils.KEY_VERSION_MIUI);
        if (strA == null) {
            return -1;
        }
        try {
            return Integer.parseInt(strA.substring(1));
        } catch (Exception e) {
            h2.b(f22979a, "get miui version code error, version : " + strA);
            h2.b(f22979a, Log.getStackTraceString(e));
            return -1;
        }
    }

    public static void b(Activity activity, int i) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", activity.getPackageName());
        intent.setFlags(268435456);
        if (a(intent, activity)) {
            activity.startActivityForResult(intent, i);
        } else {
            h2.b(f22979a, "Intent is not available!");
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
            h2.b(f22979a, "Intent is not available!");
        }
    }

    @SuppressLint({"NewApi"})
    public static void d(AccessibilityService accessibilityService) {
        b(accessibilityService.getRootInActiveWindow());
    }

    @SuppressLint({"NewApi"})
    public static void e(AccessibilityService accessibilityService) {
        h2.a("samon-->", "getdataPacket");
        a(accessibilityService.getRootInActiveWindow());
    }

    @RequiresApi(api = 16)
    public static void f(AccessibilityService accessibilityService) {
        String strB = o1.c().b();
        h2.a(f22979a, strB);
        c = n0.a().b(t0.b().b(20000), t0.b().b(500), new a(accessibilityService, strB));
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
            h2.b(f22979a, Log.getStackTraceString(e));
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public static void b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                if (accessibilityNodeInfo.getChild(i) != null && "androidx.recyclerview.widget.RecyclerView".equals(accessibilityNodeInfo.getChild(i).getClassName())) {
                    d = accessibilityNodeInfo.getChild(i);
                    return;
                } else {
                    if (accessibilityNodeInfo.getChild(i) != null) {
                        b(accessibilityNodeInfo.getChild(i));
                    }
                }
            }
        }
    }

    @RequiresApi(api = 16)
    public static void c(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(accessibilityService, "允许显示在其他应用的上层");
        AccessibilityNodeInfo accessibilityNodeInfoG2 = com.acse.ottn.b.c().g(accessibilityService, "授予悬浮窗权限");
        if (accessibilityNodeInfoG != null) {
            com.acse.ottn.b.c().g(accessibilityNodeInfoG);
            com.acse.ottn.b.c().e(accessibilityService);
        } else if (accessibilityNodeInfoG2 != null) {
            com.acse.ottn.b.c().g(accessibilityNodeInfoG2);
            com.acse.ottn.b.c().e(accessibilityService);
        } else {
            AccessibilityNodeInfo accessibilityNodeInfoG3 = com.acse.ottn.b.c().g(accessibilityService, "此权限允许应用在其他应用上层显示，可能会影响其他应用的显示");
            AccessibilityNodeInfo accessibilityNodeInfoG4 = com.acse.ottn.b.c().g(accessibilityService, o1.c().b());
            if (accessibilityNodeInfoG3 == null || accessibilityNodeInfoG4 == null) {
                return;
            }
            Rect rect = new Rect();
            accessibilityNodeInfoG3.getBoundsInScreen(rect);
            Rect rect2 = new Rect();
            accessibilityNodeInfoG4.getBoundsInScreen(rect2);
            int i = rect.right / 2;
            int i2 = rect2.top;
            int i3 = rect.bottom;
            int i4 = ((i2 - i3) / 2) + i3;
            h2.a("samonp-->", "x= " + i + "   y = " + i4);
            com.acse.ottn.b.c().a(accessibilityService, i, i4);
            h2.a(f22979a, "点击了");
            com.acse.ottn.b.c().a(500L);
            com.acse.ottn.b.c().e(accessibilityService);
        }
        if (Build.VERSION.SDK_INT >= 30) {
            com.acse.ottn.b.c().a(200L);
            com.acse.ottn.b.c().e(accessibilityService);
        }
    }

    public static boolean a(Intent intent, Activity activity) {
        return (intent == null || activity == null || activity.getPackageManager().queryIntentActivities(intent, 65536).size() <= 0) ? false : true;
    }

    public static void a(Activity activity, int i) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
        intent.setFlags(268435456);
        if (a(intent, activity)) {
            activity.startActivityForResult(intent, i);
        } else {
            h2.b(f22979a, "intent is not available!");
        }
    }

    @RequiresApi(api = 16)
    public static void b(AccessibilityService accessibilityService) {
        c = n0.a().b(t0.b().b(10000), t0.b().b(100), new b(accessibilityService, o1.c().b()));
    }

    public class a implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f22980a;
        public final /* synthetic */ String b;

        public a(AccessibilityService accessibilityService, String str) {
            this.f22980a = accessibilityService;
            this.b = str;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            try {
                AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f22980a, this.b);
                if (accessibilityNodeInfoG == null) {
                    if (HelpShopAppUtil.getContext() == null) {
                        return;
                    }
                    com.acse.ottn.b.c().a(this.f22980a, p4.c(HelpShopAppUtil.getContext()) / 3, ((p4.b(HelpShopAppUtil.getContext()) * 2) / 3) + 300, (p4.c(HelpShopAppUtil.getContext()) / 3) + 100, p4.b(HelpShopAppUtil.getContext()) / 3, 200);
                    return;
                }
                TimerTask timerTask = e3.c;
                if (timerTask != null) {
                    timerTask.cancel();
                    e3.c = null;
                }
                h2.a(e3.f22979a, "找到了");
                if (n3.a() != null) {
                    n3.a().a("battery_white", Boolean.TRUE);
                }
                com.acse.ottn.b.c().g(accessibilityNodeInfoG);
            } catch (Exception e) {
                h2.a(e3.f22979a, "e =" + e.getMessage());
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            e3.c = null;
        }
    }

    @RequiresApi(api = 16)
    public static void a(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(accessibilityService, "高级");
        if (accessibilityNodeInfoG == null) {
            return;
        }
        com.acse.ottn.b.c().g(accessibilityNodeInfoG);
        com.acse.ottn.b.c().a(t0.b().b(200));
        AccessibilityNodeInfo accessibilityNodeInfoG2 = com.acse.ottn.b.c().g(accessibilityService, "电池");
        if (accessibilityNodeInfoG2 == null) {
            return;
        }
        l0.b(true);
        com.acse.ottn.b.c().g(accessibilityNodeInfoG2);
        com.acse.ottn.b.c().a(t0.b().b(500));
        AccessibilityNodeInfo accessibilityNodeInfoG3 = com.acse.ottn.b.c().g(accessibilityService, "不优化");
        if (accessibilityNodeInfoG3 == null) {
            return;
        }
        com.acse.ottn.b.c().g(accessibilityNodeInfoG3);
        com.acse.ottn.b.c().e(accessibilityService);
        com.acse.ottn.b.c().a(t0.b().b(100));
        com.acse.ottn.b.c().e(accessibilityService);
    }

    public class b implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f22981a;
        public final /* synthetic */ String b;

        public b(AccessibilityService accessibilityService, String str) {
            this.f22981a = accessibilityService;
            this.b = str;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            try {
                AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f22981a, "后台弹出界面");
                AccessibilityNodeInfo child = null;
                if (accessibilityNodeInfoG == null) {
                    AccessibilityNodeInfo accessibilityNodeInfoG2 = com.acse.ottn.b.c().g(this.f22981a, this.b);
                    if (accessibilityNodeInfoG2 == null || accessibilityNodeInfoG2.getParent() == null || accessibilityNodeInfoG2.getParent().getParent() == null || accessibilityNodeInfoG2.getParent().getParent().getParent() == null) {
                        return;
                    }
                    for (int i = 0; i < accessibilityNodeInfoG2.getParent().getParent().getParent().getChildCount(); i++) {
                        if (accessibilityNodeInfoG2.getParent().getParent().getParent().getChild(i) != null && "androidx.recyclerview.widget.RecyclerView".equals(accessibilityNodeInfoG2.getParent().getParent().getParent().getChild(i).getClassName())) {
                            child = accessibilityNodeInfoG2.getParent().getParent().getParent().getChild(i);
                        }
                    }
                    com.acse.ottn.b.c().b(child);
                    return;
                }
                TimerTask timerTask = e3.c;
                if (timerTask != null) {
                    timerTask.cancel();
                    e3.c = null;
                }
                com.acse.ottn.b.c().g(accessibilityNodeInfoG);
                com.acse.ottn.b.c().a(t0.b().b(500));
                AccessibilityNodeInfo accessibilityNodeInfoG3 = com.acse.ottn.b.c().g(this.f22981a, "始终允许");
                AccessibilityNodeInfo accessibilityNodeInfoA = com.acse.ottn.b.c().a(this.f22981a, "允许", true);
                if (accessibilityNodeInfoG3 != null) {
                    com.acse.ottn.b.c().g(accessibilityNodeInfoG3);
                    com.acse.ottn.b.c().a(t0.b().b(100));
                    com.acse.ottn.b.c().e(this.f22981a);
                } else if (accessibilityNodeInfoA != null) {
                    com.acse.ottn.b.c().g(accessibilityNodeInfoA);
                    com.acse.ottn.b.c().a(t0.b().b(100));
                    com.acse.ottn.b.c().e(this.f22981a);
                }
            } catch (Exception e) {
                h2.a(e3.f22979a, "e =" + e.getMessage());
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            e3.c = null;
        }
    }

    @RequiresApi(api = 16)
    public static void a(String str, AccessibilityService accessibilityService) {
        AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(accessibilityService, str);
        if (accessibilityNodeInfoG != null) {
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
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null && accessibilityNodeInfo.getChildCount() == 0) {
            h2.a("samon-->", accessibilityNodeInfo.toString());
            if ("android.widget.LinearLayout".equals(accessibilityNodeInfo.getClassName())) {
                com.acse.ottn.b.c().g(accessibilityNodeInfo);
                return;
            }
            return;
        }
        if (accessibilityNodeInfo != null) {
            for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                a(accessibilityNodeInfo.getChild(i));
            }
        }
    }
}
