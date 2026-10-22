package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.service.ShopHelperService;
import com.alibaba.ariver.commonability.device.jsapi.wifi.WifiManagerBridgeExtension;
import com.igexin.assist.util.AssistUtils;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f22992a = "LocationManager";
    public static volatile f2 b;
    public static Long c = 0L;
    public static TimerTask d = null;
    public static AccessibilityNodeInfo e;

    public static f2 c() {
        if (b == null) {
            synchronized (f2.class) {
                if (b == null) {
                    b = new f2();
                }
            }
        }
        return b;
    }

    public static void d(AccessibilityService accessibilityService) {
        h2.a(f22992a, "clickSamsungNeverLocation");
        com.acse.ottn.b.c().a(200L);
        AccessibilityNodeInfo accessibilityNodeInfoH = com.acse.ottn.b.c().h(accessibilityService, "始终允许");
        if (accessibilityNodeInfoH != null) {
            h2.a(f22992a, "找了始终允许");
            com.acse.ottn.b.c().g(accessibilityNodeInfoH);
            b(accessibilityService, 1);
        }
    }

    @RequiresApi(api = 16)
    public static void e(AccessibilityService accessibilityService) {
        TimerTask timerTask = d;
        if (timerTask != null) {
            timerTask.cancel();
            d = null;
        }
        d = n0.a().b(t0.b().b(6000), t0.b().b(100), new a(accessibilityService, n3.a().e("OpenPermissionName")));
    }

    public static void f(AccessibilityService accessibilityService) {
        d = n0.a().b(t0.b().b(8000), t0.b().b(100), new c(accessibilityService, o1.c().b(), p4.b()));
    }

    public static void g(AccessibilityService accessibilityService) {
        h2.a(f22992a, "clickVivoLocation");
        TimerTask timerTask = d;
        if (timerTask != null) {
            timerTask.cancel();
            d = null;
        }
        d = n0.a().b(t0.b().b(WifiManagerBridgeExtension.ERROR_12000), t0.b().b(1000), new e(accessibilityService));
    }

    @RequiresApi(api = 16)
    public static void h(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(accessibilityService, "位置");
        if (accessibilityNodeInfoG == null) {
            TimerTask timerTask = d;
            if (timerTask != null) {
                timerTask.cancel();
                d = null;
            }
            d = n0.a().b(t0.b().b(2000), t0.b().b(300), new d(n3.a().e("OpenPermissionName"), accessibilityService));
            return;
        }
        com.acse.ottn.b.c().g(accessibilityNodeInfoG);
        com.acse.ottn.b.c().a(100L);
        n3 n3VarA = n3.a();
        Boolean bool = Boolean.TRUE;
        n3VarA.a("battery_white", bool);
        n3.a().a("is_pengpai", bool);
        a(accessibilityService, System.currentTimeMillis());
    }

    @SuppressLint({"NewApi"})
    public static void i(AccessibilityService accessibilityService) {
        a(accessibilityService.getRootInActiveWindow());
    }

    @SuppressLint({"NewApi"})
    public static void j(AccessibilityService accessibilityService) {
        h2.a(f22992a, "getPacketw");
        b(accessibilityService.getRootInActiveWindow());
    }

    @RequiresApi(api = 16)
    public static void k(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(accessibilityService, "权限管理");
        AccessibilityNodeInfo accessibilityNodeInfoG2 = com.acse.ottn.b.c().g(accessibilityService, "应用权限");
        AccessibilityNodeInfo accessibilityNodeInfoG3 = com.acse.ottn.b.c().g(accessibilityService, "权限");
        if (accessibilityNodeInfoG != null) {
            h2.a(f22992a, "openOppoLocationManage nodeInfo is not null");
            n3.a().a("battery_white", Boolean.TRUE);
            com.acse.ottn.b.c().g(accessibilityNodeInfoG);
            com.acse.ottn.b.c().a(300L);
            return;
        }
        if (accessibilityNodeInfoG2 != null) {
            h2.a(f22992a, "openOppoLocationManage nodeInfo1 is not null");
            n3.a().a("battery_white", Boolean.TRUE);
            com.acse.ottn.b.c().g(accessibilityNodeInfoG2);
            com.acse.ottn.b.c().a(300L);
            return;
        }
        if (accessibilityNodeInfoG3 != null) {
            h2.a(f22992a, "openOppoLocationManage nodeInfo2 is not null");
            n3.a().a("battery_white", Boolean.TRUE);
            com.acse.ottn.b.c().g(accessibilityNodeInfoG3);
            com.acse.ottn.b.c().a(300L);
        }
    }

    public static void l(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo accessibilityNodeInfoH = com.acse.ottn.b.c().h(accessibilityService, "始终允许");
        if (accessibilityNodeInfoH != null) {
            com.acse.ottn.b.c().a(500L);
            com.acse.ottn.b.c().g(accessibilityNodeInfoH);
            AccessibilityNodeInfo accessibilityNodeInfoH2 = com.acse.ottn.b.c().h(accessibilityService, "确定");
            if (accessibilityNodeInfoH2 != null) {
                com.acse.ottn.b.c().g(accessibilityNodeInfoH2);
            }
            b(accessibilityService, 4);
        }
    }

    public static void m(AccessibilityService accessibilityService) {
        h2.a(f22992a, "startOppoLocation");
        com.acse.ottn.b.c().a(500L);
        AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(accessibilityService, "位置信息");
        String strB = p4.b();
        j(accessibilityService);
        if (accessibilityNodeInfoG == null) {
            h2.a(f22992a, "startOppoLocation start");
            AccessibilityNodeInfo accessibilityNodeInfoJ = com.acse.ottn.b.c().j(accessibilityService, "始终允许");
            AccessibilityNodeInfo accessibilityNodeInfoJ2 = com.acse.ottn.b.c().j(accessibilityService, "允许");
            if (accessibilityNodeInfoJ != null) {
                h2.a(f22992a, "startOppoLocation nodeInfo1 is not null");
                com.acse.ottn.b.c().g(accessibilityNodeInfoJ);
                com.acse.ottn.b.c().a(300L);
                if (!"oneplus".equals(strB)) {
                    b(accessibilityService, 2);
                    return;
                } else {
                    n3.a().a("battery_white", Boolean.FALSE);
                    b(accessibilityService, 3);
                    return;
                }
            }
            if (accessibilityNodeInfoJ2 != null) {
                h2.a(f22992a, "startOppoLocation nodeInfo2 is not null");
                com.acse.ottn.b.c().g(accessibilityNodeInfoJ2);
                com.acse.ottn.b.c().a(300L);
                b(accessibilityService, 2);
                return;
            }
            h2.a(f22992a, "click oppo x y");
            AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
            Rect rect = new Rect();
            rootInActiveWindow.getBoundsInParent(rect);
            int i = rect.right;
            int i2 = rect.bottom;
            int i3 = i / 2;
            int i4 = (i2 / 2) - (i2 / 8);
            h2.a(f22992a, "x=" + i + "   y=" + i2 + "   x1 =" + i3 + "   y1=" + i4);
            com.acse.ottn.b.c().a(accessibilityService, i3, i4);
            b(accessibilityService, 3);
            return;
        }
        h2.a(f22992a, "startOppoLocation nodeInfo is not null");
        com.acse.ottn.b.c().g(accessibilityNodeInfoG);
        com.acse.ottn.b.c().a(500L);
        AccessibilityNodeInfo accessibilityNodeInfoJ3 = com.acse.ottn.b.c().j(ShopHelperService.mService, "始终允许");
        AccessibilityNodeInfo accessibilityNodeInfoJ4 = com.acse.ottn.b.c().j(accessibilityService, "允许");
        if (accessibilityNodeInfoJ3 != null) {
            h2.a(f22992a, "startOppoLocation nodeInfo1 is not null");
            com.acse.ottn.b.c().g(accessibilityNodeInfoJ3);
            com.acse.ottn.b.c().a(300L);
            if ("oneplus".equals(strB)) {
                b(accessibilityService, 3);
            } else {
                b(accessibilityService, 2);
            }
        } else if (accessibilityNodeInfoJ4 != null) {
            h2.a(f22992a, "startOppoLocation nodeInfo2 is not null");
            com.acse.ottn.b.c().g(accessibilityNodeInfoJ4);
            com.acse.ottn.b.c().a(300L);
            b(accessibilityService, 2);
        } else if (Build.VERSION.SDK_INT >= 35) {
            h2.a(f22992a, "current oppo android version 15");
            TimerTask timerTask = d;
            if (timerTask != null) {
                timerTask.cancel();
                d = null;
            }
            com.acse.ottn.b.c().a(500L);
            int iC = p4.c(accessibilityService);
            int iB = p4.b(accessibilityService);
            StringBuilder sb = new StringBuilder();
            sb.append("current x=");
            int i5 = iC / 2;
            sb.append(i5);
            sb.append("   current y=");
            int i6 = iB / 3;
            sb.append(i6);
            h2.a(f22992a, sb.toString());
            com.acse.ottn.b.c().a(accessibilityService, i5, (i6 * 11) / 10);
            b(accessibilityService, 3);
        }
        if (Build.VERSION.SDK_INT != 34) {
            h2.a(f22992a, "open location is faile");
            n3.a().a("battery_white", Boolean.FALSE);
            return;
        }
        h2.a(f22992a, "current oppo android version 14");
        TimerTask timerTask2 = d;
        if (timerTask2 != null) {
            timerTask2.cancel();
            d = null;
        }
        int iC2 = p4.c(accessibilityService);
        int iB2 = p4.b(accessibilityService);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("current x=");
        int i7 = iC2 / 2;
        sb2.append(i7);
        sb2.append("   current y=");
        int i8 = iB2 / 2;
        int i9 = i8 + 100;
        sb2.append(i9);
        h2.a(f22992a, sb2.toString());
        com.acse.ottn.b.c().a(accessibilityService, i7, i8 - (iB2 / 10));
        com.acse.ottn.b.c().a(500L);
        if (!g2.a().a(accessibilityService)) {
            com.acse.ottn.b.c().a(accessibilityService, i7, i9);
        }
        n3.a().a("battery_white", Boolean.FALSE);
        b(accessibilityService, 3);
    }

    @SuppressLint({"NewApi"})
    public static void b(AccessibilityService accessibilityService, boolean z) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        com.acse.ottn.b.c().a(t0.b().b(200));
        if (z) {
            a(accessibilityService, rootInActiveWindow);
        } else {
            f(accessibilityService);
        }
    }

    public static void a(AccessibilityService accessibilityService, boolean z) {
        try {
            b(accessibilityService, z);
        } catch (Throwable unused) {
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            d = n0.a().b(t0.b().b(3000), t0.b().b(300), new b(accessibilityService, null));
        }
    }

    public static void b(AccessibilityService accessibilityService, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            com.acse.ottn.b.c().a(t0.b().b(200));
            n3.a().a("battery_white", Boolean.FALSE);
            com.acse.ottn.b.c().e(accessibilityService);
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
            if (accessibilityNodeInfo.getChild(i) != null) {
                if ("androidx.recyclerview.widget.RecyclerView".equals(accessibilityNodeInfo.getClassName())) {
                    e = accessibilityNodeInfo;
                    return;
                }
                a(accessibilityNodeInfo.getChild(i));
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static AccessibilityNodeInfo c(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return null;
        }
        for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
            if (accessibilityNodeInfo.getChild(i) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i).getClassName()) && accessibilityNodeInfo.getChild(i).isScrollable()) {
                return accessibilityNodeInfo.getChild(i);
            }
            if (accessibilityNodeInfo.getChild(i) != null) {
                c(accessibilityNodeInfo.getChild(i));
            }
        }
        return null;
    }

    public class a implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f22993a;
        public final /* synthetic */ String b;

        public a(AccessibilityService accessibilityService, String str) {
            this.f22993a = accessibilityService;
            this.b = str;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            try {
                AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f22993a, this.b);
                if (accessibilityNodeInfoG != null) {
                    if (f2.d != null) {
                        f2.d.cancel();
                        TimerTask unused = f2.d = null;
                    }
                    com.acse.ottn.b.c().g(accessibilityNodeInfoG);
                    if (n3.a() != null) {
                        n3 n3VarA = n3.a();
                        Boolean bool = Boolean.TRUE;
                        n3VarA.a("battery_white", bool);
                        n3.a().a("location_permission", bool);
                    }
                }
            } catch (Throwable th) {
                h2.a(f2.f22992a, "e =" + th.getMessage());
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            TimerTask unused = f2.d = null;
        }
    }

    public class b implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f22994a;
        public final /* synthetic */ AccessibilityNodeInfo b;

        public b(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
            this.f22994a = accessibilityService;
            this.b = accessibilityNodeInfo;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f22994a, "位置信息");
            if (accessibilityNodeInfoG == null) {
                com.acse.ottn.b.c().b(this.b);
                return;
            }
            if (f2.d != null) {
                f2.d.cancel();
                TimerTask unused = f2.d = null;
            }
            com.acse.ottn.b.c().g(accessibilityNodeInfoG);
            if (n3.a() != null) {
                n3 n3VarA = n3.a();
                Boolean bool = Boolean.TRUE;
                n3VarA.a("battery_white", bool);
                n3.a().a("location_permission", bool);
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            h2.a(f2.f22992a, "结束了");
        }
    }

    public static void b(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo accessibilityNodeInfoA = com.acse.ottn.b.c().a(accessibilityService, "始终允许", true);
        if (accessibilityNodeInfoA != null) {
            com.acse.ottn.b.c().g(accessibilityNodeInfoA);
            b(accessibilityService, 4);
        }
    }

    public class c implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f22995a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public c(AccessibilityService accessibilityService, String str, String str2) {
            this.f22995a = accessibilityService;
            this.b = str;
            this.c = str2;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            AccessibilityNodeInfo accessibilityNodeInfoC = f2.c(this.f22995a.getRootInActiveWindow());
            AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.f22995a, this.b);
            if (accessibilityNodeInfoG == null) {
                if (accessibilityNodeInfoC != null) {
                    com.acse.ottn.b.c().b(accessibilityNodeInfoC);
                    return;
                }
                return;
            }
            if (f2.d != null) {
                f2.d.cancel();
                TimerTask unused = f2.d = null;
            }
            if (AssistUtils.BRAND_HON.equals(this.c) || "tianyi".equals(this.c)) {
                com.acse.ottn.b.c().g(accessibilityNodeInfoG);
                f2.l(this.f22995a);
            } else {
                n3.a().a("battery_white", Boolean.TRUE);
                com.acse.ottn.b.c().g(accessibilityNodeInfoG);
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            h2.a(f2.f22992a, "结束了");
        }
    }

    public static void a(AccessibilityService accessibilityService, long j) {
        if (j - c.longValue() < 1000) {
            h2.a(f22992a, "间隔 t=" + j + "   System.currentTimeMillis() =" + System.currentTimeMillis());
            h2.a(f22992a, "间隔 time=" + c + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - c.longValue()));
            return;
        }
        h2.a(f22992a, "无间隔 t=" + j + "   System.currentTimeMillis() =" + System.currentTimeMillis());
        h2.a(f22992a, "无间隔 time=" + c + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - c.longValue()));
        c = Long.valueOf(j);
        com.acse.ottn.b.c().a(200L);
        AccessibilityNodeInfo accessibilityNodeInfoH = com.acse.ottn.b.c().h(accessibilityService, "始终允许");
        if (accessibilityNodeInfoH != null) {
            com.acse.ottn.b.c().g(accessibilityNodeInfoH);
            b(accessibilityService, 2);
        }
    }

    public static void b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            if (accessibilityNodeInfo != null) {
                for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                    if (accessibilityNodeInfo.getChild(i) != null) {
                        b(accessibilityNodeInfo.getChild(i));
                    }
                }
                return;
            }
            return;
        }
        h2.a(f22992a, "recycle1 =" + accessibilityNodeInfo.toString());
        if (accessibilityNodeInfo.getText() != null) {
            h2.a(f22992a, "recycle2 =" + accessibilityNodeInfo.getText().toString());
        }
        if (accessibilityNodeInfo.getContentDescription() != null) {
            h2.a(f22992a, "getContentDescription=" + accessibilityNodeInfo.getContentDescription().toString().trim());
        }
    }

    public static void c(AccessibilityService accessibilityService) {
        com.acse.ottn.b.c().a(100L);
        AccessibilityNodeInfo accessibilityNodeInfoH = com.acse.ottn.b.c().h(accessibilityService, "仅在使用该应用时允许");
        if (accessibilityNodeInfoH != null) {
            com.acse.ottn.b.c().g(accessibilityNodeInfoH);
        }
    }

    public class d implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22996a;
        public final /* synthetic */ AccessibilityService b;

        public d(String str, AccessibilityService accessibilityService) {
            this.f22996a = str;
            this.b = accessibilityService;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            try {
                if (this.f22996a == null) {
                    return;
                }
                AccessibilityNodeInfo accessibilityNodeInfoG = com.acse.ottn.b.c().g(this.b, this.f22996a);
                if (accessibilityNodeInfoG == null) {
                    f2.i(this.b);
                    if (f2.e != null) {
                        com.acse.ottn.b.c().b(f2.e);
                        return;
                    }
                    return;
                }
                if (f2.d != null) {
                    f2.d.cancel();
                    TimerTask unused = f2.d = null;
                }
                h2.a(f2.f22992a, "找到了定位");
                com.acse.ottn.b.c().g(accessibilityNodeInfoG);
                com.acse.ottn.b.c().a(t0.b().b(200));
                AccessibilityNodeInfo accessibilityNodeInfoG2 = com.acse.ottn.b.c().g(this.b, "始终允许");
                AccessibilityNodeInfo accessibilityNodeInfoA = com.acse.ottn.b.c().a(this.b, "允许", true);
                if (accessibilityNodeInfoG2 != null) {
                    com.acse.ottn.b.c().g(accessibilityNodeInfoG2);
                    f2.b(this.b, 1);
                } else if (accessibilityNodeInfoA != null) {
                    com.acse.ottn.b.c().g(accessibilityNodeInfoA);
                    f2.b(this.b, 1);
                }
            } catch (Throwable th) {
                h2.a(f2.f22992a, "e =" + th.getMessage());
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            TimerTask unused = f2.d = null;
        }
    }

    public class e implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f22997a;

        public e(AccessibilityService accessibilityService) {
            this.f22997a = accessibilityService;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            if (com.acse.ottn.b.c().h(this.f22997a, "定位") == null) {
                h2.a(f2.f22992a, "滑动1 ");
                com.acse.ottn.b bVarC = com.acse.ottn.b.c();
                AccessibilityService accessibilityService = this.f22997a;
                bVarC.a(accessibilityService, p4.c(accessibilityService) / 3, ((p4.b(this.f22997a) * 2) / 3) + 300, (p4.c(this.f22997a) / 3) + 100, p4.b(this.f22997a) / 3, 500);
                return;
            }
            com.acse.ottn.b.c().i(this.f22997a, "定位");
            com.acse.ottn.b.c().a(500L);
            AccessibilityNodeInfo accessibilityNodeInfoH = com.acse.ottn.b.c().h(this.f22997a, "始终允许");
            if (accessibilityNodeInfoH != null) {
                if (f2.d != null) {
                    f2.d.cancel();
                    TimerTask unused = f2.d = null;
                }
                h2.a(f2.f22992a, "clickVivoLocation appNodeInfo is not null");
                com.acse.ottn.b.c().g(accessibilityNodeInfoH);
                if (Build.VERSION.SDK_INT >= 35) {
                    f2.b(this.f22997a, 2);
                    return;
                } else {
                    f2.b(this.f22997a, 1);
                    return;
                }
            }
            if (Build.VERSION.SDK_INT < 35) {
                h2.a(f2.f22992a, "clickVivoLocation appNodeInfo is null");
                h2.a(f2.f22992a, "滑动2");
                com.acse.ottn.b bVarC2 = com.acse.ottn.b.c();
                AccessibilityService accessibilityService2 = this.f22997a;
                bVarC2.a(accessibilityService2, p4.c(accessibilityService2) / 3, ((p4.b(this.f22997a) * 2) / 3) + 300, (p4.c(this.f22997a) / 3) + 100, p4.b(this.f22997a) / 3, 500);
                return;
            }
            if (f2.d != null) {
                f2.d.cancel();
                TimerTask unused2 = f2.d = null;
            }
            com.acse.ottn.b.c().a(500L);
            int iC = p4.c(this.f22997a);
            int iB = p4.b(this.f22997a);
            StringBuilder sb = new StringBuilder();
            sb.append("current x=");
            int i = iC / 2;
            sb.append(i);
            sb.append("   current y=");
            int i2 = ((iB / 3) * 9) / 10;
            sb.append(i2);
            h2.a(f2.f22992a, sb.toString());
            com.acse.ottn.b.c().a(this.f22997a, i, i2);
            f2.b(this.f22997a, 2);
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            TimerTask unused = f2.d = null;
        }
    }
}
