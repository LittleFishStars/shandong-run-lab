package com.igexin.push.g;

import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.text.TextUtils;
import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.GetuiPushException;
import com.igexin.sdk.PushService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f38140a = "CheckUtils";
    private static Integer b = null;
    private static final String c = "checkOpNoThrow";
    private static final String d = "OP_POST_NOTIFICATION";
    private static final ServiceConnection e = new ServiceConnection() { // from class: com.igexin.push.g.c.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public static void a(Context context, Intent intent) {
        try {
            if (g()) {
                c(intent, context);
            } else {
                context.getApplicationContext().startService(intent);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a("CheckUtils|startPService err：" + th.toString(), new Object[0]);
            if (th instanceof IllegalStateException) {
                c(intent, context);
            }
        }
    }

    private static void a(Map<String, com.igexin.push.core.b.f> map, String str) {
        com.igexin.push.core.b.f fVar = map.get(str);
        map.remove(str);
        for (String str2 : fVar.b) {
            com.igexin.push.core.b.f fVar2 = map.get(str2);
            if (fVar2 != null) {
                int i = fVar2.c - 1;
                fVar2.c = i;
                if (i == 0) {
                    a(map, str2);
                }
            }
        }
    }

    public static boolean a() {
        return System.currentTimeMillis() > com.igexin.push.config.d.d;
    }

    public static boolean a(long j) {
        if (com.igexin.push.config.d.c == 0) {
            return false;
        }
        Date date = new Date(j);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(11);
        int i2 = com.igexin.push.config.d.b + com.igexin.push.config.d.c;
        if (i2 >= 24) {
            i2 -= 24;
        }
        int i3 = com.igexin.push.config.d.b;
        if (i3 < i2) {
            if (i >= i3 && i < i2) {
                return true;
            }
        } else if (i3 > i2) {
            if (i >= 0 && i < i2) {
                return true;
            }
            if (i >= i3 && i < 24) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(Context context) {
        if (b == null) {
            b = (context.getApplicationInfo().flags & 2) == 0 ? -1 : 1;
        }
        return b.intValue() > 0;
    }

    public static boolean a(Intent intent, Context context) {
        if (context == null) {
            return false;
        }
        try {
            ServiceInfo[] serviceInfoArr = context.getApplicationContext().getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 4).services;
            if (serviceInfoArr != null && serviceInfoArr.length != 0) {
                for (ServiceInfo serviceInfo : serviceInfoArr) {
                    if (intent.getComponent() != null && serviceInfo.name.equals(intent.getComponent().getClassName())) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static boolean a(String str) {
        try {
            return com.igexin.push.core.e.l.getPackageManager().getLaunchIntentForPackage(str) != null;
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return false;
        }
    }

    public static boolean a(JSONObject jSONObject) {
        String string;
        try {
            HashMap map = new HashMap();
            JSONArray jSONArray = jSONObject.getJSONArray("action_chains");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                com.igexin.push.core.b.f fVar = new com.igexin.push.core.b.f();
                if (jSONObject2.has("actionid")) {
                    if (map.containsKey(fVar.f37956a)) {
                        return true;
                    }
                    fVar.f37956a = jSONObject2.getString("actionid");
                    ArrayList arrayList = new ArrayList();
                    if (jSONObject2.has("type")) {
                        String string2 = jSONObject2.getString("type");
                        if (com.igexin.push.core.b.q.equals(string2)) {
                            if (jSONObject2.has("noinstall_action")) {
                                arrayList.add(jSONObject2.getString("noinstall_action"));
                            }
                            if (jSONObject2.has("do")) {
                                string = jSONObject2.getString("do");
                                arrayList.add(string);
                            }
                        } else if (com.igexin.push.core.b.v.equals(string2)) {
                            if (jSONObject2.has("do_installed")) {
                                arrayList.add(jSONObject2.getString("do_installed"));
                            }
                            if (jSONObject2.has("do_uninstalled")) {
                                string = jSONObject2.getString("do_uninstalled");
                                arrayList.add(string);
                            }
                        } else if (!"null".equals(string2) && jSONObject2.has("do")) {
                            string = jSONObject2.getString("do");
                            arrayList.add(string);
                        }
                        fVar.b = arrayList;
                        map.put(fVar.f37956a, fVar);
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList(map.values());
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                List<String> list = ((com.igexin.push.core.b.f) ((Map.Entry) it.next()).getValue()).b;
                if (list != null) {
                    Iterator<String> it2 = list.iterator();
                    while (it2.hasNext()) {
                        com.igexin.push.core.b.f fVar2 = (com.igexin.push.core.b.f) map.get(it2.next());
                        if (fVar2 != null) {
                            fVar2.c++;
                            if (arrayList2.contains(fVar2)) {
                                arrayList2.remove(fVar2);
                            }
                        }
                    }
                }
            }
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                a(map, ((com.igexin.push.core.b.f) it3.next()).f37956a);
            }
            if (map.size() > 0) {
                com.igexin.c.a.c.a.a("CheckUtils|action_chains have loop nodeMap not empty", new Object[0]);
                return true;
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a("CheckUtils|isHaveLoop exception :" + th.toString(), new Object[0]);
        }
        return false;
    }

    public static boolean b() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) com.igexin.push.core.e.l.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static boolean b(Context context) {
        try {
            return ((Boolean) NotificationManager.class.getDeclaredMethod("areNotificationsEnabled", new Class[0]).invoke((NotificationManager) context.getSystemService("notification"), new Object[0])).booleanValue();
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return true;
        }
    }

    public static boolean b(Intent intent, Context context) {
        if (intent != null && context != null) {
            try {
                ActivityInfo[] activityInfoArr = context.getApplicationContext().getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 1).activities;
                if (activityInfoArr != null && activityInfoArr.length != 0) {
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        if (intent.getComponent() != null && activityInfo.name.equals(intent.getComponent().getClassName())) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
        return false;
    }

    public static boolean b(String str) {
        try {
            if (!TextUtils.isEmpty(com.igexin.push.config.d.C) && !"none".equals(com.igexin.push.config.d.C)) {
                List listAsList = Arrays.asList(com.igexin.push.config.d.C.split(","));
                if (listAsList.isEmpty()) {
                    return false;
                }
                Iterator it = listAsList.iterator();
                while (it.hasNext()) {
                    if (str.startsWith((String) it.next())) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static void c() {
        NetworkInfo.State state = ((ConnectivityManager) com.igexin.push.core.e.l.getSystemService("connectivity")).getNetworkInfo(1).getState();
        if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
            com.igexin.push.core.e.x = 1;
        } else {
            com.igexin.push.core.e.x = 0;
        }
    }

    public static void c(Context context) throws GetuiPushException {
        if (context == null) {
            throw new GetuiPushException("传入的context为空");
        }
        Context applicationContext = context.getApplicationContext();
        if (a(applicationContext)) {
            ServiceInfo serviceInfo = (ServiceInfo) d.a(applicationContext, PushService.class).first;
            if (serviceInfo == null) {
                throw new GetuiPushException("未找到继承 com.igexin.sdk.PushService 的子类");
            }
            if (!TextUtils.isEmpty(serviceInfo.permission)) {
                throw new GetuiPushException("自定义推送服务(Service)不能配置android:permission");
            }
            if (((ServiceInfo) d.a(applicationContext, GTIntentService.class).first) == null) {
                throw new GetuiPushException("未找到继承 com.igexin.sdk.GTIntentService 的子类");
            }
            try {
                PackageInfo packageInfo = applicationContext.getApplicationContext().getPackageManager().getPackageInfo(applicationContext.getApplicationContext().getPackageName(), 4229);
                if (packageInfo == null) {
                    return;
                }
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if (applicationInfo == null) {
                    throw new GetuiPushException("ApplicationInfo 应用异常");
                }
                if (applicationInfo.metaData != null) {
                    String strA = d.a(applicationInfo);
                    if (TextUtils.isEmpty(strA)) {
                        strA = applicationInfo.metaData.getString(com.igexin.push.core.b.b);
                    }
                    if (TextUtils.isEmpty(strA) && TextUtils.isEmpty(applicationInfo.metaData.getString("GETUI_APPID"))) {
                        throw new GetuiPushException("未配置个推APPID");
                    }
                } else if (TextUtils.isEmpty(d.a(applicationInfo))) {
                    throw new GetuiPushException("未配置META-DATA");
                }
                String[] strArr = packageInfo.requestedPermissions;
                if (strArr == null || strArr.length == 0) {
                    throw new GetuiPushException("Manifest中无权限配置");
                }
                List listAsList = Arrays.asList(strArr);
                if (!listAsList.contains(com.kuaishou.weapon.p0.g.f40125a)) {
                    throw new GetuiPushException("未在Manifest中配置所需权限：android.permission.INTERNET");
                }
                if (!listAsList.contains("android.permission.READ_PHONE_STATE")) {
                    throw new GetuiPushException("未在Manifest中配置所需权限：android.permission.READ_PHONE_STATE");
                }
                if (!listAsList.contains("android.permission.ACCESS_NETWORK_STATE")) {
                    throw new GetuiPushException("未在Manifest中配置所需权限：android.permission.ACCESS_NETWORK_STATE");
                }
                if (!listAsList.contains(com.kuaishou.weapon.p0.g.d)) {
                    throw new GetuiPushException("未在Manifest中配置所需权限：android.permission.ACCESS_WIFI_STATE");
                }
                if (!listAsList.contains("android.permission.VIBRATE")) {
                    throw new GetuiPushException("未在Manifest中配置所需权限：android.permission.VIBRATE");
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
    }

    private static void c(Intent intent, Context context) {
        com.igexin.c.a.c.a.a("CheckUtils|startPService by bind", new Object[0]);
        intent.setType("PB-" + System.nanoTime());
        context.getApplicationContext().bindService(intent, e, 1);
    }

    public static boolean c(String str) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(com.igexin.push.config.d.F) && !"none".equals(com.igexin.push.config.d.F)) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(Arrays.asList(com.igexin.push.config.d.F.split(",")));
                if (arrayList.isEmpty()) {
                    return false;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (str.contains((String) it.next())) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static void d() {
        com.igexin.push.core.e.y = ((PowerManager) com.igexin.push.core.e.l.getSystemService("power")).isScreenOn() ? 1 : 0;
    }

    private static boolean d(Context context) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfoB = n.b(context);
            return (applicationInfoB == null || (bundle = applicationInfoB.metaData) == null || TextUtils.isEmpty(bundle.getString("GETUI_APPID"))) ? false : true;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static boolean d(String str) {
        try {
            if (Build.VERSION.SDK_INT >= 28 && a(com.igexin.push.core.e.l)) {
                return false;
            }
            k.a(str, 0);
            com.igexin.c.a.c.a.b(f38140a, "checkApp by GtPm");
            return true;
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(f38140a, e2.toString());
            com.igexin.c.a.c.a.b(f38140a, "checkApp by GtPm");
            return false;
        }
    }

    public static boolean e() {
        String str;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) com.igexin.push.core.e.l.getSystemService("connectivity");
            if (connectivityManager == null) {
                com.igexin.c.a.c.a.a("CheckUtils|ConnectivityManager is null", new Object[0]);
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            com.igexin.c.a.c.a.a("CheckUtils|activeNetworkInfo = ".concat(String.valueOf(activeNetworkInfo)), new Object[0]);
            if (activeNetworkInfo == null || activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED) {
                com.igexin.c.a.c.a.a("CheckUtils|network available = false", new Object[0]);
                return false;
            }
            if (activeNetworkInfo.getType() == 0) {
                str = "mobile";
            } else {
                str = activeNetworkInfo.getType() == 1 ? "wifi" : "none";
            }
            com.igexin.c.a.c.a.a(f38140a + str + "|connected", new Object[0]);
            return true;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.b(f38140a, "network available ex =" + th.toString());
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static boolean f() {
        return System.currentTimeMillis() >= 1182566108138L;
    }

    public static boolean g() {
        int i;
        String str = com.igexin.push.config.d.P;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            for (String str2 : str.split(",")) {
                if (str2.contains("|") && str2.contains("~")) {
                    String strSubstring = str2.substring(0, str2.indexOf("|"));
                    String[] strArrSplit = str2.substring(str2.indexOf("|") + 1).split("~");
                    if (strArrSplit.length == 2) {
                        int i2 = Integer.parseInt(strArrSplit[0]);
                        int i3 = Integer.parseInt(strArrSplit[1]);
                        if (Build.BRAND.equalsIgnoreCase(strSubstring) && (i = Build.VERSION.SDK_INT) >= i2 && i <= i3) {
                            return true;
                        }
                    } else {
                        continue;
                    }
                }
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return false;
    }

    private static String h() {
        return null;
    }
}
