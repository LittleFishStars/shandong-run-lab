package com.byazt.hu;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.byazt.bv.BaseConstants;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1381, 20})
public class c {

    /* JADX INFO: renamed from: com.byazt.hu.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 1381, 44})
    public static class C0428c implements InvocationHandler {
        public Object c;

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if (PerfId.startActivity.contains(method.getName())) {
                    c.c(objArr);
                }
            } catch (Throwable unused) {
            }
            return method.invoke(this.c, objArr);
        }

        private C0428c(Object obj) {
            this.c = obj;
        }
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.byazt.v.ve.c(new File(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ve() {
        try {
            Field declaredField = Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 == null) {
                return;
            }
            Class<?> cls = Class.forName("android.app.IActivityManager");
            declaredField2.set(obj, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, new C0428c(obj2)));
        } catch (Throwable unused) {
        }
    }

    public static String tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = com.byazt.gq.t.getContext().getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return applicationInfo.sourceDir;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static int c(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return 5;
        }
        return com.byazt.v.ve.c(str, new File(str2));
    }

    public static void c() {
        if (com.byazt.gq.t.i().optInt("hook", 0) != 1) {
            return;
        }
        com.byazt.di.n.c().c(new Runnable() { // from class: com.byazt.hu.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.i.n.x();
                c.ve();
            }
        }, 10000L);
    }

    public static void c(Object[] objArr) {
        if (com.byazt.gq.t.i().optInt("hook", 0) == 1 && (objArr[1] instanceof String)) {
            Object obj = objArr[2];
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                if ("android.intent.action.VIEW".equals(intent.getAction()) && com.byazt.ev.n.c.equals(intent.getType())) {
                    if (com.byazt.i.n.uj()) {
                        String strOptString = com.byazt.gq.t.i().optString("hook_vivo_arg", "com.android.settings");
                        if ("null".equals(strOptString)) {
                            return;
                        }
                        objArr[1] = strOptString;
                        return;
                    }
                    if (com.byazt.i.n.n()) {
                        String strOptString2 = com.byazt.gq.t.i().optString("hook_kllk_arg1", "com." + com.byazt.ev.n.ve + ".market");
                        if (!"null".equals(strOptString2)) {
                            objArr[1] = strOptString2;
                        }
                        String strOptString3 = com.byazt.gq.t.i().optString("hook_kllk_arg2", BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO);
                        String strOptString4 = com.byazt.gq.t.i().optString("hook_kllk_arg3", "m.store." + com.byazt.ev.n.ve + "mobile.com");
                        intent.putExtra(com.byazt.ev.n.ve + "_extra_pkg_name", strOptString3);
                        intent.putExtra("refererHost", strOptString4);
                        if (com.byazt.gq.t.i().optInt("hook_kllk_arg4", 0) == 1) {
                            Intent intent2 = new Intent();
                            intent2.putExtra(com.byazt.ev.n.ve + "_extra_pkg_name", strOptString3);
                            intent2.putExtra("refererHost", strOptString4);
                            intent.putExtra("android.intent.extra.INTENT", intent2);
                            return;
                        }
                        return;
                    }
                    if (com.byazt.i.n.c()) {
                        String strOptString5 = com.byazt.gq.t.i().optString("hook_huawei_arg1", "com.huawei.appmarket");
                        if (!"null".equals(strOptString5)) {
                            objArr[1] = strOptString5;
                        }
                        intent.putExtra("caller_package", com.byazt.gq.t.i().optString("hook_huawei_arg2", "com.huawei.appmarket"));
                    }
                }
            }
        }
    }
}
