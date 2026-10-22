package com.beizi.fusion;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.kc.openset.constant.DeviceIdType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class wj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27978a;
    private String b;
    private volatile boolean c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f27979a;

        public a(Context context) {
            this.f27979a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            wj.this.b(this.f27979a);
            wj wjVar = wj.this;
            wjVar.a(this.f27979a, new d());
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static wj f27981a = new wj();
    }

    public class d {

        public class a implements c7.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Context f27983a;

            public a(Context context) {
                this.f27983a = context;
            }

            @Override // com.beizi.fusion.c7.a
            public void a(String str) {
                try {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    wj.this.a(this.f27983a, str, "CN");
                } catch (Throwable th) {
                    om.a(th);
                }
            }
        }

        private d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context) {
            b(context);
        }

        private void b(Context context) {
            try {
                new c7(new a(context)).b(context);
            } catch (Throwable th) {
                om.a(th);
            }
        }
    }

    private wj() {
        this.c = false;
        if (c.f27981a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    public static wj a() {
        return c.f27981a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        if (Build.BRAND.equals("HONOR")) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "oaid_limit_state");
                if (TextUtils.isEmpty(string) || Boolean.parseBoolean(string)) {
                    return;
                }
                String string2 = Settings.Global.getString(context.getContentResolver(), DeviceIdType.OAID);
                if (TextUtils.isEmpty(string2)) {
                    return;
                }
                a(context, string2);
            } catch (Throwable unused) {
            }
        }
    }

    public String c(Context context) {
        if (TextUtils.isEmpty(this.f27978a)) {
            this.f27978a = f3.b(r5.a(context, r5.a(), "OAID_CIP", ""));
        }
        return this.f27978a;
    }

    public synchronized void d(Context context) {
        if (this.c) {
            return;
        }
        this.c = true;
        ((fb) cn.a().b(context)).a(new a(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, d dVar) {
        try {
            t6.a((Application) context.getApplicationContext());
            if (r6.a(context)) {
                r6.a(context, new b(context, dVar));
            }
        } catch (Throwable th) {
            om.a(th);
        }
    }

    public class b implements kc {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f27980a;
        final /* synthetic */ d b;

        public b(Context context, d dVar) {
            this.f27980a = context;
            this.b = dVar;
        }

        @Override // com.beizi.fusion.kc
        public void a(String str) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    wj.this.a(this.f27980a, str, "SM");
                    return;
                }
            } catch (Throwable th) {
                om.a(th);
            }
            d dVar = this.b;
            if (dVar != null) {
                dVar.a(this.f27980a);
            }
        }

        @Override // com.beizi.fusion.kc
        public void a(Exception exc) {
            d dVar = this.b;
            if (dVar != null) {
                dVar.a(this.f27980a);
            }
        }
    }

    private void a(Context context, String str) {
        om.a("OAIDHelper", "保存Honor OAID: " + str);
        this.b = str;
        r5.b(context, r5.a(), "HONOR_OAID_CIP", f3.c(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, String str2) {
        om.a("OAIDHelper", str2 + "保存 OAID: " + str);
        StringBuilder sb = new StringBuilder();
        sb.append("OAID => ");
        sb.append(str);
        Log.d("OAID", sb.toString());
        this.f27978a = str;
        r5.b(context, r5.a(), "OAID_CIP", f3.c(str));
    }

    public String a(Context context) {
        if (TextUtils.isEmpty(this.b)) {
            this.b = f3.b(r5.a(context, r5.a(), "HONOR_OAID_CIP", ""));
        }
        return this.b;
    }
}
