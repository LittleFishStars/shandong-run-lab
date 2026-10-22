package com.igexin.assist.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.heytap.msp.push.HeytapPushManager;
import com.igexin.assist.control.AbstractPushManager;
import com.igexin.assist.util.AssistUtils;
import com.igexin.c.a.c.a.d;
import com.igexin.push.core.e;
import com.igexin.push.core.e.f;
import com.igexin.push.g.n;
import com.meizu.cloud.pushsdk.PushManager;
import com.zj.adlib.u15;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f37789a = "AssistMangerFactory";
    private static final String c = "com.igexin.assist.control.fcm.ManufacturePushManager";
    private static a d;
    private static final String[] e = {"com.igexin.assist.control.xiaomi.MiuiPushManager", "com.igexin.assist.control.meizu.FlymePushManager", "com.igexin.assist.control.huawei.HmsPushManager", "com.igexin.assist.control.oppo.OppoPushManager", "com.igexin.assist.control.vivo.VivoPushManager", "com.igexin.assist.control.st.SmartisanPushManager", "com.igexin.assist.control.fcm.FcmPushManager"};
    public AbstractPushManager b;

    public static a a() {
        if (d == null) {
            synchronized (AbstractPushManager.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    private void b(Context context) {
        AbstractPushManager abstractPushManager = this.b;
        if (abstractPushManager != null && abstractPushManager.isSupport()) {
            if (this.b.getBrandCode().equals("3")) {
                try {
                    Class.forName("com.xiaomi.mipush.sdk.MiPushClient").getDeclaredMethod("clearNotification", Context.class).invoke(null, context);
                } catch (Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                    com.igexin.c.a.c.a.a("AssistMangerFactory | cancelAllAssistNotification() err " + th.toString(), new Object[0]);
                }
                com.igexin.c.a.c.a.b(f37789a, " cancelAllAssistNotification() XM ");
                return;
            }
            if (this.b.getBrandCode().equals("4")) {
                try {
                    PushManager.class.getDeclaredMethod("clearNotification", Context.class).invoke(null, context);
                } catch (Throwable th2) {
                    com.igexin.c.a.c.a.a(th2);
                    com.igexin.c.a.c.a.a("AssistMangerFactory | cancelAllAssistNotification() err " + th2.toString(), new Object[0]);
                }
                com.igexin.c.a.c.a.b(f37789a, " cancelAllAssistNotification() MZ ");
            }
        }
    }

    private static void c(Context context) {
        try {
            Class.forName("com.xiaomi.mipush.sdk.MiPushClient").getDeclaredMethod("clearNotification", Context.class).invoke(null, context);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a("AssistMangerFactory | cancelAllAssistNotification() err " + th.toString(), new Object[0]);
        }
        com.igexin.c.a.c.a.b(f37789a, " cancelAllAssistNotification() XM ");
    }

    private static void d() {
        for (String str : e) {
            try {
                Class.forName(str);
                d.a().a("UnSupport plugin [" + str + "]. Please change plugin to 3.0.");
                return;
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    private static void d(Context context) {
        try {
            PushManager.class.getDeclaredMethod("clearNotification", Context.class).invoke(null, context);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a("AssistMangerFactory | cancelAllAssistNotification() err " + th.toString(), new Object[0]);
        }
        com.igexin.c.a.c.a.b(f37789a, " cancelAllAssistNotification() MZ ");
    }

    private String e() {
        AbstractPushManager abstractPushManager = this.b;
        return abstractPushManager == null ? "" : abstractPushManager.getBrandCode();
    }

    private String f() {
        Object objInvoke;
        AbstractPushManager abstractPushManager = this.b;
        String str = "";
        if (abstractPushManager == null) {
            return "";
        }
        String name = abstractPushManager.getClass().getName();
        try {
            if (!name.contains("fcm")) {
                if (name.contains("xiaomi")) {
                    Field declaredField = this.b.getClass().getDeclaredField("XIAOMI_VERSION");
                    boolean zIsAccessible = declaredField.isAccessible();
                    declaredField.setAccessible(true);
                    String str2 = (String) declaredField.get(this.b.getClass());
                    try {
                        declaredField.setAccessible(zIsAccessible);
                        return str2;
                    } catch (Throwable th) {
                        th = th;
                        str = str2;
                        com.igexin.c.a.c.a.a(th);
                        return str;
                    }
                }
                if (name.contains(AssistUtils.BRAND_HW)) {
                    return ((String) n.b(e.l).metaData.get("com.huawei.hms.client.service.name:push")).split(u15.f19942b)[1];
                }
                if (name.contains("oppo")) {
                    objInvoke = HeytapPushManager.class.getDeclaredMethod("getSDKVersionName", new Class[0]).invoke(HeytapPushManager.class, new Object[0]);
                } else if (name.contains("stp")) {
                    Class<?> cls = Class.forName("com.gtups.sdk.PushManager");
                    objInvoke = cls.getDeclaredMethod("getVersion", Context.class).invoke(cls.getDeclaredMethod("getInstance", new Class[0]).invoke(cls, new Object[0]), e.l);
                } else {
                    if (name.contains("vivo")) {
                        ApplicationInfo applicationInfoB = n.b(e.l);
                        StringBuilder sb = new StringBuilder();
                        sb.append(applicationInfoB.metaData.getInt("sdk_version_vivo"));
                        return sb.toString();
                    }
                    if (name.contains(AssistUtils.BRAND_MZ)) {
                        for (Field field : PushManager.class.getDeclaredFields()) {
                            if (Modifier.isFinal(field.getModifiers()) && "TAG".equals(field.getName())) {
                                str = (String) field.get(null);
                            }
                        }
                    }
                }
                return (String) objInvoke;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return str;
    }

    public final AbstractPushManager a(Context context) {
        String lowerCase = AssistUtils.getDeviceBrand().toLowerCase();
        if (com.igexin.push.config.d.M.contains(lowerCase)) {
            com.igexin.c.a.c.a.a("AssistMangerFactory|getPushManager = null, setToken = false", new Object[0]);
            f.a().b(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
            return null;
        }
        try {
            this.b = (AbstractPushManager) Class.forName("com.igexin.assist.control." + lowerCase + ".ManufacturePushManager").getConstructor(Context.class).newInstance(context);
        } catch (Throwable th) {
            d.a().a(lowerCase + " PushManager = null " + th.toString());
        }
        if (this.b == null) {
            try {
                com.igexin.c.a.c.a.a("AssistMangerFactory|try init fcm push", new Object[0]);
                AbstractPushManager abstractPushManager = (AbstractPushManager) Class.forName(c).getConstructor(Context.class).newInstance(context);
                this.b = abstractPushManager;
                if (!abstractPushManager.isSupport()) {
                    this.b = null;
                }
            } catch (Throwable th2) {
                d.a().a(lowerCase + " Fcm PushManager = null");
                StringBuilder sb = new StringBuilder("|Fcm ManufacturePushManager = null ");
                sb.append(th2.toString());
                com.igexin.c.a.c.a.b(f37789a, sb.toString());
                if (!e.b().booleanValue()) {
                    f.a().b(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
                }
                if (th2 instanceof ClassNotFoundException) {
                    d();
                }
            }
        }
        if (this.b == null && !e.b().booleanValue()) {
            f.a().b(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        }
        StringBuilder sb2 = new StringBuilder("AssistMangerFactory|ManufacturePushManager is null = ");
        sb2.append(this.b == null);
        com.igexin.c.a.c.a.a(sb2.toString(), new Object[0]);
        return this.b;
    }

    public final String[] b() {
        String str;
        String strF;
        AbstractPushManager abstractPushManager = this.b;
        String str2 = "";
        if (abstractPushManager == null) {
            return new String[]{"", ""};
        }
        try {
            Field declaredField = abstractPushManager.getClass().getDeclaredField("PLUGIN_VERSION");
            boolean zIsAccessible = declaredField.isAccessible();
            declaredField.setAccessible(true);
            str = (String) declaredField.get(this.b.getClass());
            try {
                declaredField.setAccessible(zIsAccessible);
            } catch (Throwable th) {
                th = th;
                str2 = str;
                com.igexin.c.a.c.a.a(th);
                str = str2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            strF = (String) this.b.getClass().getDeclaredMethod("getBrandSdkVersion", new Class[0]).invoke(this.b, new Object[0]);
        } catch (Throwable th3) {
            com.igexin.c.a.c.a.a(f37789a, th3.getMessage());
            strF = f();
        }
        return new String[]{str, strF};
    }

    public final boolean c() {
        AbstractPushManager abstractPushManager;
        if (com.igexin.push.config.d.M.contains(AssistUtils.getDeviceBrand().toLowerCase()) || (abstractPushManager = this.b) == null) {
            return false;
        }
        return abstractPushManager.isSupport();
    }
}
