package com.beizi.fusion;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f27134a;

    public interface a {
        void a(String str);
    }

    public c7(a aVar) {
        this.f27134a = aVar;
    }

    private String a() {
        return Build.MANUFACTURER.toUpperCase();
    }

    public static boolean c() {
        if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            return true;
        }
        String str = Build.BRAND;
        return str.equalsIgnoreCase("HUAWEI") || str.equalsIgnoreCase("HONOR");
    }

    public static boolean d() {
        if (Build.MANUFACTURER.equalsIgnoreCase("OPPO")) {
            return true;
        }
        String str = Build.BRAND;
        return str.equalsIgnoreCase("OPPO") || str.equalsIgnoreCase("REALME") || !TextUtils.isEmpty(a(com.blankj.utilcode.util.e.d, ""));
    }

    public void b(Context context) {
        String strA;
        a aVar;
        try {
            om.a("DevicesIDsHelper", "init oaid " + a());
            if ("ASUS".equalsIgnoreCase(a()) || c()) {
                a(context);
            } else if ("LENOVO".equalsIgnoreCase(a()) || "MOTOLORA".equalsIgnoreCase(a())) {
                new ug(context).a(this.f27134a);
            } else {
                if (!"MEIZU".equalsIgnoreCase(a())) {
                    if ("NUBIA".equalsIgnoreCase(a())) {
                        strA = new nj(context).a();
                    } else if (d() || "SAMSUNG".equalsIgnoreCase(a())) {
                        a(context);
                    } else if ("VIVO".equalsIgnoreCase(a())) {
                        strA = new dq(context).a();
                    } else if ("XIAOMI".equalsIgnoreCase(a()) || "BLACKSHARK".equalsIgnoreCase(a())) {
                        strA = new mq(context).a();
                    } else if ("ONEPLUS".equalsIgnoreCase(a()) || "ZTE".equalsIgnoreCase(a()) || "FERRMEOS".equalsIgnoreCase(a()) || b() || "SSUI".equalsIgnoreCase(a()) || e()) {
                        a(context);
                    }
                    aVar = this.f27134a;
                    if (aVar != null || strA == null) {
                    }
                    aVar.a(strA);
                    return;
                }
                new vh(context).a(this.f27134a);
            }
            strA = null;
            aVar = this.f27134a;
            if (aVar != null) {
            }
        } catch (Throwable th) {
            om.a(th);
        }
    }

    public boolean e() {
        String strA = a("ro.ssui.product");
        return (TextUtils.isEmpty(strA) || strA.equalsIgnoreCase("unknown")) ? false : true;
    }

    public static String a(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod(com.acse.ottn.p3.f, String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            om.b("DevicesIDsHelper", "System property invoke error: " + e);
            om.a(e);
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }

    private String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(com.acse.ottn.p3.f, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception unused) {
            return null;
        }
    }

    private void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            if ("ASUS".equalsIgnoreCase(a())) {
                new v0(context).a(this.f27134a);
                return;
            }
            if (c()) {
                new x8(context).a(this.f27134a);
                return;
            }
            if (d()) {
                new ok(context).a(this.f27134a);
                return;
            }
            if ("ONEPLUS".equalsIgnoreCase(a())) {
                new jk(context).a(this.f27134a);
                return;
            }
            if ("ZTE".equalsIgnoreCase(a())) {
                new pq(context).a(this.f27134a);
                return;
            }
            if (!"FERRMEOS".equalsIgnoreCase(a()) && !b()) {
                if (!"SSUI".equalsIgnoreCase(a()) && !e()) {
                    if ("SAMSUNG".equalsIgnoreCase(a())) {
                        new qm(context).a(this.f27134a);
                        return;
                    }
                    return;
                }
                new pq(context).a(this.f27134a);
                return;
            }
            new pq(context).a(this.f27134a);
        } catch (Throwable th) {
            om.b("DevicesIDsHelper", "getIDFromNewThead exception");
            om.a(th);
        }
    }

    public boolean b() {
        String strA = a("ro.build.freeme.label");
        return !TextUtils.isEmpty(strA) && strA.equalsIgnoreCase("FREEMEOS");
    }
}
