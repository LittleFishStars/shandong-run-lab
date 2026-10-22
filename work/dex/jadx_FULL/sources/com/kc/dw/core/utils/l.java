package com.kc.dw.core.utils;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.google.gson.Gson;
import com.igexin.assist.control.xiaomi.XmSystemUtils;
import com.igexin.assist.util.AssistUtils;
import com.kc.dw.core.AdSdk;
import com.kc.openset.constant.DeviceIdType;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f39380a = null;
    public static volatile boolean b = false;
    public static int c = 675;

    @Keep
    public class a extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f39381a;

        public a(Context context) {
            this.f39381a = context;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            try {
                boolean unused = l.b = true;
                Context context = this.f39381a;
                try {
                    String string = com.kc.dw.base.a.getSharedPreferences().getString("user_agent", null);
                    if (string == null) {
                        string = WebSettings.getDefaultUserAgent(context);
                    }
                    if (string != null) {
                        com.kc.dw.base.a.getSharedPreferences().edit().putString("user_agent", string).apply();
                        c.f39354a = string;
                    }
                } catch (Throwable unused2) {
                }
                try {
                    w0.l = w0.g();
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (Throwable unused3) {
                }
                if (com.kc.dw.base.a.adConfig() == null || !com.kc.dw.base.a.adConfig().enableOaid()) {
                    l.f39380a = "unknown";
                } else {
                    Context context2 = this.f39381a;
                    if (Build.VERSION.SDK_INT >= 28) {
                        try {
                            new MiitHelper().prepare(context2, new m());
                        } catch (ClassNotFoundException unused4) {
                        } catch (Throwable th) {
                            Integer num = com.kc.dw.core.exception.b.f39252a;
                            AdSdk.setOaid_errno(1000012);
                            LogUtil.e("DeviceUtil", "oaid sdk init error");
                            th.printStackTrace();
                        }
                    }
                    l.a(this.f39381a);
                }
                p0.a(this.f39381a);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static void a(int i) {
        c = i | c;
    }

    /* JADX WARN: Code duplicated, block: B:117:0x0189  */
    /* JADX WARN: Code duplicated, block: B:142:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:144:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:145:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:153:0x0219 A[PHI: r0
      0x0219: PHI (r0v5 com.kc.dw.core.oaid.b) = (r0v3 com.kc.dw.core.oaid.b), (r0v4 com.kc.dw.core.oaid.b) binds: [B:152:0x0217, B:155:0x0224] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:21:0x003e  */
    /* JADX WARN: Code duplicated, block: B:60:0x00bc  */
    public static void a(Context context) {
        boolean z;
        com.kc.dw.core.oaid.b hVar;
        boolean z2;
        boolean z3;
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        n nVar = new n(context);
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        com.kc.dw.core.oaid.b dVar = com.kc.dw.core.oaid.impl.l.f39289a;
        if (dVar == null) {
            String str = Build.MANUFACTURER;
            boolean z4 = false;
            if (str.equalsIgnoreCase("LENOVO")) {
                z = true;
            } else {
                String str2 = Build.BRAND;
                if (str2.equalsIgnoreCase("LENOVO") || str2.equalsIgnoreCase("ZUK")) {
                    z = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                hVar = new com.kc.dw.core.oaid.impl.h(context);
            } else {
                if (str.equalsIgnoreCase("MOTOLORA") || Build.BRAND.equalsIgnoreCase("MOTOLORA")) {
                    hVar = new com.kc.dw.core.oaid.impl.h(context);
                } else {
                    if (str.equalsIgnoreCase("MEIZU") || Build.BRAND.equalsIgnoreCase("MEIZU") || Build.DISPLAY.toUpperCase().contains("FLYME")) {
                        hVar = new com.kc.dw.core.oaid.impl.i(context);
                    } else {
                        if (str.equalsIgnoreCase("NUBIA") || Build.BRAND.equalsIgnoreCase("NUBIA")) {
                            hVar = new com.kc.dw.core.oaid.impl.k(context);
                        } else {
                            if (str.equalsIgnoreCase("XIAOMI")) {
                                z2 = true;
                            } else {
                                String str3 = Build.BRAND;
                                if (str3.equalsIgnoreCase("XIAOMI") || str3.equalsIgnoreCase("REDMI")) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                            }
                            if (z2 || (!TextUtils.isEmpty(com.kc.dw.core.oaid.c.a(XmSystemUtils.KEY_VERSION_MIUI, "")))) {
                                hVar = new com.kc.dw.core.oaid.impl.q(context);
                            } else {
                                if (str.equalsIgnoreCase("BLACKSHARK") || Build.BRAND.equalsIgnoreCase("BLACKSHARK")) {
                                    hVar = new com.kc.dw.core.oaid.impl.q(context);
                                } else {
                                    if (str.equalsIgnoreCase("SAMSUNG") || Build.BRAND.equalsIgnoreCase("SAMSUNG")) {
                                        hVar = new com.kc.dw.core.oaid.impl.o(context);
                                    } else {
                                        if (str.equalsIgnoreCase("VIVO") || Build.BRAND.equalsIgnoreCase("VIVO") || !TextUtils.isEmpty(com.kc.dw.core.oaid.c.a("ro.vivo.os.version", ""))) {
                                            hVar = new com.kc.dw.core.oaid.impl.p(context);
                                        } else {
                                            if (str.equalsIgnoreCase("ASUS") || Build.BRAND.equalsIgnoreCase("ASUS")) {
                                                hVar = new com.kc.dw.core.oaid.impl.a(context);
                                            } else if (com.kc.dw.core.oaid.c.a() || (!TextUtils.isEmpty(com.kc.dw.core.oaid.c.a("ro.build.version.emui", "")))) {
                                                hVar = new com.kc.dw.core.oaid.impl.g(context);
                                            } else {
                                                if (str.equalsIgnoreCase("OPPO")) {
                                                    z3 = true;
                                                } else {
                                                    String str4 = Build.BRAND;
                                                    if (str4.equalsIgnoreCase("OPPO") || str4.equalsIgnoreCase("REALME") || !TextUtils.isEmpty(com.kc.dw.core.oaid.c.a(com.blankj.utilcode.util.e.d, ""))) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = false;
                                                    }
                                                }
                                                if (z3) {
                                                    hVar = new com.kc.dw.core.oaid.impl.n(context);
                                                } else {
                                                    if (str.equalsIgnoreCase("ONEPLUS") || Build.BRAND.equalsIgnoreCase("ONEPLUS")) {
                                                        hVar = new com.kc.dw.core.oaid.impl.n(context);
                                                    } else {
                                                        try {
                                                            if (str.equalsIgnoreCase("Coolpad") || Build.BRAND.equalsIgnoreCase("Coolpad")) {
                                                                z4 = true;
                                                            }
                                                        } catch (Exception unused) {
                                                        }
                                                        if (z4) {
                                                            hVar = new com.kc.dw.core.oaid.impl.b(context);
                                                        } else if (com.kc.dw.core.oaid.c.a("ro.odm.manufacturer", "").equalsIgnoreCase("PRIZE")) {
                                                            hVar = new com.kc.dw.core.oaid.impl.c(context);
                                                        } else {
                                                            hVar = TextUtils.isEmpty(com.kc.dw.core.oaid.c.a("ro.build.freeme.label", "")) ^ true ? new com.kc.dw.core.oaid.impl.e(context) : null;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            com.kc.dw.core.oaid.impl.l.f39289a = hVar;
            if (hVar == null || !hVar.a()) {
                com.kc.dw.core.oaid.b jVar = new com.kc.dw.core.oaid.impl.j(context);
                if (jVar.a()) {
                    dVar = jVar;
                } else {
                    jVar = new com.kc.dw.core.oaid.impl.f(context);
                    if (jVar.a()) {
                        dVar = jVar;
                    } else {
                        dVar = new com.kc.dw.core.oaid.impl.d();
                    }
                }
                com.kc.dw.core.oaid.impl.l.f39289a = dVar;
            } else {
                com.kc.dw.core.oaid.impl.l.f39289a.getClass();
                dVar = com.kc.dw.core.oaid.impl.l.f39289a;
            }
        }
        dVar.a(nVar);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00c3 A[Catch: all -> 0x014a, TryCatch #4 {all -> 0x014a, blocks: (B:11:0x001d, B:13:0x0023, B:15:0x002d, B:17:0x0037, B:19:0x0045, B:23:0x0050, B:25:0x0058, B:27:0x0062, B:28:0x006a, B:29:0x006d, B:30:0x0076, B:32:0x007e, B:34:0x0088, B:22:0x004d, B:35:0x0094, B:37:0x00c3, B:38:0x00cd, B:40:0x00dc, B:60:0x0146, B:50:0x0116, B:39:0x00d1, B:51:0x0119, B:53:0x0123, B:55:0x0134, B:57:0x013a, B:54:0x012c, B:41:0x00e9, B:43:0x00f3, B:45:0x0104, B:47:0x010a, B:44:0x00fc), top: B:74:0x001d, inners: #0, #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00d1 A[Catch: all -> 0x014a, TryCatch #4 {all -> 0x014a, blocks: (B:11:0x001d, B:13:0x0023, B:15:0x002d, B:17:0x0037, B:19:0x0045, B:23:0x0050, B:25:0x0058, B:27:0x0062, B:28:0x006a, B:29:0x006d, B:30:0x0076, B:32:0x007e, B:34:0x0088, B:22:0x004d, B:35:0x0094, B:37:0x00c3, B:38:0x00cd, B:40:0x00dc, B:60:0x0146, B:50:0x0116, B:39:0x00d1, B:51:0x0119, B:53:0x0123, B:55:0x0134, B:57:0x013a, B:54:0x012c, B:41:0x00e9, B:43:0x00f3, B:45:0x0104, B:47:0x010a, B:44:0x00fc), top: B:74:0x001d, inners: #0, #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00f3 A[Catch: all -> 0x0115, TryCatch #2 {all -> 0x0115, blocks: (B:41:0x00e9, B:43:0x00f3, B:45:0x0104, B:47:0x010a, B:44:0x00fc), top: B:70:0x00e9, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00fc A[Catch: all -> 0x0115, TryCatch #2 {all -> 0x0115, blocks: (B:41:0x00e9, B:43:0x00f3, B:45:0x0104, B:47:0x010a, B:44:0x00fc), top: B:70:0x00e9, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x010a A[Catch: all -> 0x0115, TRY_LEAVE, TryCatch #2 {all -> 0x0115, blocks: (B:41:0x00e9, B:43:0x00f3, B:45:0x0104, B:47:0x010a, B:44:0x00fc), top: B:70:0x00e9, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x0123 A[Catch: all -> 0x0145, TryCatch #1 {all -> 0x0145, blocks: (B:51:0x0119, B:53:0x0123, B:55:0x0134, B:57:0x013a, B:54:0x012c), top: B:68:0x0119, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x012c A[Catch: all -> 0x0145, TryCatch #1 {all -> 0x0145, blocks: (B:51:0x0119, B:53:0x0123, B:55:0x0134, B:57:0x013a, B:54:0x012c), top: B:68:0x0119, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x013a A[Catch: all -> 0x0145, TRY_LEAVE, TryCatch #1 {all -> 0x0145, blocks: (B:51:0x0119, B:53:0x0123, B:55:0x0134, B:57:0x013a, B:54:0x012c), top: B:68:0x0119, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static void b(Context context) {
        int i;
        int iA;
        Gson gson;
        String string;
        String string2;
        if (b || context == null) {
            return;
        }
        try {
            throw null;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (com.kc.dw.base.a.adConfig() == null || !com.kc.dw.base.a.adConfig().enableOaid()) {
                    LogUtil.d("DeviceUtil", "Read oaid from cache, oaid=" + f39380a);
                    p0.n = r.a().a("useHttps", 3);
                    if (r.a().a("shake_act_type")) {
                        i = c;
                        iA = r.a().a("shake_act_type", 0);
                    } else {
                        i = c;
                        iA = com.kc.dw.base.a.getSharedPreferences().getInt("shake_act_type", 0);
                    }
                    c = i | iA;
                    c = h.a(c);
                    gson = new Gson();
                    try {
                        if (r.a().a("pck_id_bean")) {
                            string2 = r.a().a("pck_id_bean", "");
                        } else {
                            string2 = com.kc.dw.base.a.getSharedPreferences().getString("pck_id_bean", "");
                        }
                        if (TextUtils.isEmpty(string2)) {
                            if (r.a().a("dclk")) {
                                string = r.a().a("dclk", "");
                            } else {
                                string = com.kc.dw.base.a.getSharedPreferences().getString("dclk", "");
                            }
                            if (!TextUtils.isEmpty(string)) {
                                p0.g = (PackageBean.DClick) gson.fromJson(string, PackageBean.DClick.class);
                            }
                        } else {
                            p0.e = (PckIdBean) gson.fromJson(string2, PckIdBean.class);
                            try {
                                if (r.a().a("dclk")) {
                                    string = r.a().a("dclk", "");
                                } else {
                                    string = com.kc.dw.base.a.getSharedPreferences().getString("dclk", "");
                                }
                                if (!TextUtils.isEmpty(string)) {
                                    p0.g = (PackageBean.DClick) gson.fromJson(string, PackageBean.DClick.class);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                } else {
                    try {
                        if (r.a().a("oaid_e")) {
                            String strA = r.a().a("oaid_e", (String) null);
                            if (!TextUtils.isEmpty(strA)) {
                                f39380a = d1.a(strA);
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (TextUtils.isEmpty(f39380a)) {
                        f39380a = r.a().a(DeviceIdType.OAID) ? r.a().a(DeviceIdType.OAID, (String) null) : com.kc.dw.base.a.getSharedPreferences().getString(DeviceIdType.OAID, null);
                    }
                    if (TextUtils.isEmpty(f39380a) && Build.MANUFACTURER.equalsIgnoreCase(AssistUtils.BRAND_HON)) {
                        f39380a = r.a().a("honor_oaid", (String) null);
                    }
                    LogUtil.d("DeviceUtil", "Read oaid from cache, oaid=" + f39380a);
                    p0.n = r.a().a("useHttps", 3);
                    if (r.a().a("shake_act_type")) {
                        i = c;
                        iA = r.a().a("shake_act_type", 0);
                    } else {
                        i = c;
                        iA = com.kc.dw.base.a.getSharedPreferences().getInt("shake_act_type", 0);
                    }
                    c = i | iA;
                    c = h.a(c);
                    gson = new Gson();
                    if (r.a().a("pck_id_bean")) {
                        string2 = r.a().a("pck_id_bean", "");
                    } else {
                        string2 = com.kc.dw.base.a.getSharedPreferences().getString("pck_id_bean", "");
                    }
                    if (TextUtils.isEmpty(string2)) {
                        p0.e = (PckIdBean) gson.fromJson(string2, PckIdBean.class);
                        if (r.a().a("dclk")) {
                            string = r.a().a("dclk", "");
                        } else {
                            string = com.kc.dw.base.a.getSharedPreferences().getString("dclk", "");
                        }
                        if (!TextUtils.isEmpty(string)) {
                            p0.g = (PackageBean.DClick) gson.fromJson(string, PackageBean.DClick.class);
                        }
                    } else {
                        if (r.a().a("dclk")) {
                            string = r.a().a("dclk", "");
                        } else {
                            string = com.kc.dw.base.a.getSharedPreferences().getString("dclk", "");
                        }
                        if (!TextUtils.isEmpty(string)) {
                            p0.g = (PackageBean.DClick) gson.fromJson(string, PackageBean.DClick.class);
                        }
                    }
                }
            } catch (Throwable th3) {
                LogUtil.d("DeviceUtil", "Read oaid from cache failed");
                th3.printStackTrace();
                ExecutorService executorService = f0.f39362a;
                f0.b.f39363a.a(new a(context));
            }
            ExecutorService executorService2 = f0.f39362a;
            f0.b.f39363a.a(new a(context));
        }
    }
}
