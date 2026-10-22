package com.beizi.fusion;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f27095a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f27096a;

        public a(Context context) {
            this.f27096a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f27096a == null) {
                return;
            }
            try {
                if ("ASUS".equals(b7.this.a().toUpperCase())) {
                    new w0(this.f27096a).a(b7.this.f27095a);
                    return;
                }
                if (b7.c()) {
                    new y8(this.f27096a).a(b7.this.f27095a);
                    return;
                }
                if (b7.d()) {
                    new pk(this.f27096a).a(b7.this.f27095a);
                    return;
                }
                if ("ONEPLUS".equals(b7.this.a().toUpperCase())) {
                    new kk(this.f27096a).a(b7.this.f27095a);
                    return;
                }
                if ("ZTE".equals(b7.this.a().toUpperCase())) {
                    new qq(this.f27096a).a(b7.this.f27095a);
                    return;
                }
                if (!"FERRMEOS".equals(b7.this.a().toUpperCase()) && !b7.this.b()) {
                    if (!"SSUI".equals(b7.this.a().toUpperCase()) && !b7.this.e()) {
                        if ("SAMSUNG".equals(b7.this.a().toUpperCase())) {
                            new rm(this.f27096a).a(b7.this.f27095a);
                            return;
                        }
                        return;
                    }
                    new qq(this.f27096a).a(b7.this.f27095a);
                    return;
                }
                new qq(this.f27096a).a(b7.this.f27095a);
            } catch (Throwable unused) {
                jh.b("BeiZis", "getIDFromNewThead exception");
            }
        }
    }

    public interface b {
        void a(String str);
    }

    public b7(b bVar) {
        this.f27095a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a() {
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
        b bVar;
        try {
            jh.b("BeiZis", "init oaid " + a());
            if ("ASUS".equals(a().toUpperCase()) || c()) {
                a(context);
            } else if ("LENOVO".equals(a().toUpperCase()) || "MOTOLORA".equals(a().toUpperCase())) {
                new vg(context).a(this.f27095a);
            } else {
                if (!"MEIZU".equals(a().toUpperCase())) {
                    if ("NUBIA".equals(a().toUpperCase())) {
                        strA = new mj(context).a();
                    } else if (d() || "SAMSUNG".equals(a().toUpperCase())) {
                        a(context);
                    } else if ("VIVO".equals(a().toUpperCase())) {
                        strA = new cq(context).a();
                    } else if ("XIAOMI".equals(a().toUpperCase()) || "BLACKSHARK".equals(a().toUpperCase())) {
                        strA = new lq(context).a();
                    } else if ("ONEPLUS".equals(a().toUpperCase()) || "ZTE".equals(a().toUpperCase()) || "FERRMEOS".equals(a().toUpperCase()) || b() || "SSUI".equals(a().toUpperCase()) || e()) {
                        a(context);
                    }
                    bVar = this.f27095a;
                    if (bVar != null || strA == null) {
                    }
                    bVar.a(strA);
                    return;
                }
                new uh(context).a(this.f27095a);
            }
            strA = null;
            bVar = this.f27095a;
            if (bVar != null) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
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
            jh.b("BeiZis", "System property invoke error: " + e);
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
        new Thread(new a(context)).start();
    }

    public boolean b() {
        String strA = a("ro.build.freeme.label");
        return !TextUtils.isEmpty(strA) && strA.equalsIgnoreCase("FREEMEOS");
    }
}
