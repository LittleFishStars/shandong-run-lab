package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import java.io.ObjectStreamException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static f3 f22998a = null;
    public static String b = "OpenMobileLocationPermissionUtil";

    public static f3 a() {
        if (f22998a == null) {
            synchronized (f3.class) {
                if (f22998a == null) {
                    f22998a = new f3();
                }
            }
        }
        return f22998a;
    }

    public final Object b() throws ObjectStreamException {
        return f22998a;
    }

    public boolean a(AccessibilityService accessibilityService, String str) {
        h2.a(b, "openPermission");
        if (!str.contains("com.android") || !str.contains(".ui.GrantPermissionsActivity")) {
            return false;
        }
        d.d().e(accessibilityService);
        if (!n3.a().a("battery_white")) {
            return true;
        }
        n3.a().a("battery_white", Boolean.FALSE);
        b.c().a(300L);
        String strE = n3.a().e("location_permission_state");
        if (strE.equals("1")) {
            AccessibilityNodeInfo accessibilityNodeInfoA = b.c().a(accessibilityService, "允许本次使用", true);
            if (accessibilityNodeInfoA != null) {
                b.c().g(accessibilityNodeInfoA);
                return true;
            }
            AccessibilityNodeInfo accessibilityNodeInfoA2 = b.c().a(accessibilityService, "仅在使用中允许", true);
            if (accessibilityNodeInfoA2 != null) {
                b.c().g(accessibilityNodeInfoA2);
                return true;
            }
            AccessibilityNodeInfo accessibilityNodeInfoA3 = b.c().a(accessibilityService, "仅使用期间允许", true);
            if (accessibilityNodeInfoA3 != null) {
                b.c().g(accessibilityNodeInfoA3);
                return true;
            }
            AccessibilityNodeInfo accessibilityNodeInfoA4 = b.c().a(accessibilityService, "本次使用允许", true);
            if (accessibilityNodeInfoA4 != null) {
                b.c().g(accessibilityNodeInfoA4);
                return true;
            }
            AccessibilityNodeInfo accessibilityNodeInfoA5 = b.c().a(accessibilityService, "本次运行允许", true);
            if (accessibilityNodeInfoA5 != null) {
                b.c().g(accessibilityNodeInfoA5);
                return true;
            }
            AccessibilityNodeInfo accessibilityNodeInfoA6 = b.c().a(accessibilityService, "本次使用时允许", true);
            if (accessibilityNodeInfoA6 != null) {
                b.c().g(accessibilityNodeInfoA6);
                return true;
            }
            AccessibilityNodeInfo accessibilityNodeInfoA7 = b.c().a(accessibilityService, "仅本次使用时允许", true);
            if (accessibilityNodeInfoA7 != null) {
                b.c().g(accessibilityNodeInfoA7);
                return true;
            }
            AccessibilityNodeInfo accessibilityNodeInfoA8 = b.c().a(accessibilityService, "允许", true);
            if (accessibilityNodeInfoA8 != null) {
                b.c().g(accessibilityNodeInfoA8);
                return true;
            }
        } else if (strE.equals("2")) {
            AccessibilityNodeInfo accessibilityNodeInfoH = b.c().h(accessibilityService, "权限管理");
            if (accessibilityNodeInfoH != null) {
                Rect rect = new Rect();
                accessibilityNodeInfoH.getBoundsInScreen(rect);
                int i = (rect.left + rect.right) / 2;
                h2.a(b, "x=" + i);
                int i2 = rect.bottom;
                int i3 = rect.top;
                int i4 = ((i2 - i3) / 2) + i3;
                n3.a().a("battery_white", Boolean.TRUE);
                try {
                    b.c().a(accessibilityService, i, i4);
                } catch (Throwable unused) {
                }
                h2.a(b, "点击了");
                return true;
            }
            AccessibilityNodeInfo accessibilityNodeInfoH2 = b.c().h(accessibilityService, "始终允许");
            if (accessibilityNodeInfoH2 != null && accessibilityNodeInfoH2.getText() != null) {
                h2.a(b, accessibilityNodeInfoH2.toString());
                if (accessibilityNodeInfoH2.getText().equals("始终允许")) {
                    b.c().g(accessibilityNodeInfoH2);
                    return true;
                }
                if (accessibilityNodeInfoH2.getText().toString().equals("若同意，您可以去设置为始终允许。")) {
                    Rect rect2 = new Rect();
                    accessibilityNodeInfoH2.getBoundsInScreen(rect2);
                    int i5 = rect2.right - rect2.left;
                    h2.a(b, "x=" + i5);
                    int i6 = rect2.bottom;
                    int i7 = rect2.top;
                    int i8 = ((i6 - i7) / 2) + i7;
                    if (b.c().a(accessibilityService, i5, i8)) {
                        b.c().a(1000L);
                        b.c().a(accessibilityService, i5, i8);
                    }
                    h2.a(b, "点击了");
                    n3.a().a("battery_white", Boolean.TRUE);
                    return true;
                }
            }
            AccessibilityNodeInfo accessibilityNodeInfoH3 = b.c().h(accessibilityService, "在“设置”中允许");
            if (accessibilityNodeInfoH3 != null) {
                h2.a(b, "在“设置”中允许");
                Rect rect3 = new Rect();
                accessibilityNodeInfoH3.getBoundsInScreen(rect3);
                int i9 = (rect3.left + rect3.right) / 2;
                h2.a(b, "x=" + i9);
                b.c().a(accessibilityService, i9, rect3.bottom + (-30));
                h2.a(b, "点击了");
                n3.a().a("battery_white", Boolean.TRUE);
                return true;
            }
            AccessibilityNodeInfo accessibilityNodeInfoH4 = b.c().h(accessibilityService, "去设为始终允许");
            if (accessibilityNodeInfoH4 != null) {
                Rect rect4 = new Rect();
                accessibilityNodeInfoH4.getBoundsInScreen(rect4);
                int i10 = (rect4.left + rect4.right) / 2;
                h2.a(b, "x=" + i10);
                b.c().a(accessibilityService, i10, rect4.bottom + (-30));
                h2.a(b, "点击了");
                n3.a().a("battery_white", Boolean.TRUE);
                return true;
            }
            AccessibilityNodeInfo accessibilityNodeInfoA9 = b.c().a(accessibilityService, "允许", true);
            if (accessibilityNodeInfoA9 != null) {
                b.c().g(accessibilityNodeInfoA9);
            }
        }
        return true;
    }
}
