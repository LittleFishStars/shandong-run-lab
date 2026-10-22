package com.kuaishou.weapon.p0;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.LocaleList;
import android.provider.Settings;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.acse.ottn.p3;
import com.zj.adlib.c49;
import com.zj.adlib.xh9;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class bf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f40057a;
    private static String b;

    public static String a() {
        return null;
    }

    public static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(p3.f, String.class).invoke(cls, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(Context context) {
        try {
            return c(com.kwad.sdk.e.b.QY().getIMEI());
        } catch (Throwable unused) {
            return bg.d;
        }
    }

    public static String c(Context context) {
        try {
            return c(com.kwad.sdk.e.b.QY().getIMEI());
        } catch (Throwable unused) {
            return bg.d;
        }
    }

    public static String d(Context context) {
        try {
            return c(com.kwad.sdk.e.b.QY().QR());
        } catch (Throwable unused) {
            return bg.d;
        }
    }

    public static String e(Context context) {
        try {
            return c(com.kwad.sdk.e.b.QY().getIccId());
        } catch (Throwable unused) {
            return bg.d;
        }
    }

    public static String f(Context context) {
        try {
            return c(com.kwad.sdk.e.b.QY().QO());
        } catch (Throwable unused) {
            return bg.d;
        }
    }

    public static boolean g(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean h(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String i() {
        try {
            Locale locale = Locale.getDefault();
            return locale.getLanguage() + c49.f40900a + locale.getCountry();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String i(Context context) {
        return bg.d;
    }

    public static String j() {
        Locale locale = LocaleList.getDefault().get(0);
        return locale.getLanguage() + c49.f40900a + locale.getCountry();
    }

    public static String j(Context context) {
        return "";
    }

    public static String k(Context context) {
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled", 0) != 1) {
                return bg.e;
            }
            String string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
            return TextUtils.isEmpty(string) ? bg.c : string;
        } catch (Throwable unused) {
            return bg.d;
        }
    }

    public static String l(Context context) {
        StringBuilder sb;
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager == null) {
            return null;
        }
        try {
            List<AccessibilityServiceInfo> installedAccessibilityServiceList = accessibilityManager.getInstalledAccessibilityServiceList();
            if (installedAccessibilityServiceList == null || installedAccessibilityServiceList.size() <= 0) {
                sb = null;
            } else {
                sb = new StringBuilder();
                try {
                    Iterator<AccessibilityServiceInfo> it = installedAccessibilityServiceList.iterator();
                    while (it.hasNext()) {
                        String strA = a(it.next());
                        if (sb.indexOf(strA) == -1) {
                            sb.append(strA);
                            sb.append("|");
                        }
                    }
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
        }
        if (sb == null) {
            return null;
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private static String m() {
        return "ANDROID_PHONE";
    }

    public static String m(Context context) {
        StringBuilder sb;
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        StringBuilder sb2 = null;
        if (accessibilityManager == null) {
            return null;
        }
        try {
            if (!accessibilityManager.isEnabled() || (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(-1)) == null || enabledAccessibilityServiceList.size() <= 0) {
                sb = null;
            } else {
                sb = new StringBuilder();
                try {
                    Iterator<AccessibilityServiceInfo> it = enabledAccessibilityServiceList.iterator();
                    while (it.hasNext()) {
                        String strA = a(it.next());
                        if (sb.indexOf(strA) == -1) {
                            sb.append(strA);
                            sb.append("|");
                        }
                    }
                } catch (Exception unused) {
                    sb2 = sb;
                    sb = sb2;
                }
            }
            if (sb == null) {
                return null;
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '|') {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (Exception unused2) {
        }
    }

    public static String n(Context context) {
        return bg.d;
    }

    public static String o(Context context) {
        return bg.c;
    }

    public static String p(Context context) {
        return bg.f40059a;
    }

    public static String q(Context context) {
        try {
            if (TextUtils.isEmpty(f40057a)) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                b = (String) packageInfo.applicationInfo.loadLabel(context.getPackageManager());
                f40057a = packageInfo.versionName;
            }
        } catch (Throwable unused) {
        }
        return f40057a;
    }

    public static String r(Context context) {
        return b;
    }

    public static String s(Context context) {
        try {
            return context.getPackageName();
        } catch (Throwable unused) {
            return "";
        }
    }

    @TargetApi(23)
    public static int t(Context context) {
        try {
            String strC = c(com.kwad.sdk.e.b.QY().QS());
            if (!TextUtils.isEmpty(strC) && !strC.startsWith("RISK")) {
                return Integer.parseInt(strC);
            }
            return -1;
        } catch (Throwable unused) {
            return -2;
        }
    }

    @TargetApi(22)
    public static int u(Context context) {
        try {
            String strC = c(com.kwad.sdk.e.b.QY().QT());
            if (!TextUtils.isEmpty(strC) && !strC.startsWith("RISK")) {
                return Integer.parseInt(strC);
            }
            return -1;
        } catch (Throwable unused) {
            return -2;
        }
    }

    public static String v(Context context) {
        return bg.c;
    }

    public static String w(Context context) {
        try {
            return c(com.kwad.sdk.e.b.QY().getOaid());
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String x(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            PackageManager packageManager = context.getPackageManager();
            String[] strArr = {"android.hardware.camera", "android.hardware.camera.autofocus", "android.hardware.camera.flash", "android.hardware.location", "android.hardware.location.gps", "android.hardware.location.network", "android.hardware.microphone", "android.hardware.sensor.compass", "android.hardware.sensor.accelerometer", "android.hardware.sensor.light", "android.hardware.sensor.proximity", "android.hardware.telephony", "android.hardware.telephony.cdma", "android.hardware.telephony.gsm", "android.hardware.touchscreen", "android.hardware.touchscreen.multitouch", "android.hardware.touchscreen.multitouch.distinct", "android.hardware.camera.front", "android.hardware.wifi", "android.hardware.bluetooth", "android.hardware.nfc", "android.hardware.fingerprint", "android.hardware.biometrics.face", "android.hardware.screen.portrait", "android.hardware.screen.landscape", "android.hardware.faketouch", "android.hardware.audio.output"};
            for (int i = 0; i < 27; i++) {
                if (packageManager.hasSystemFeature(strArr[i])) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    public static String y(Context context) {
        Iterator<String> itKeys;
        try {
            StringBuilder sb = new StringBuilder();
            JSONObject jSONObjectZ = z(context);
            if (jSONObjectZ != null && (itKeys = jSONObjectZ.keys()) != null) {
                String str = "";
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String string = jSONObjectZ.getString(next);
                    sb.append(str);
                    str = com.alipay.sdk.m.y.l.b;
                    sb.append(next);
                    sb.append("=");
                    sb.append(string);
                }
                return sb.toString();
            }
        } catch (Exception unused) {
        }
        return "";
    }

    private static JSONObject z(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            String str = WeaponHI.sUserId;
            String strM = m();
            String str2 = WeaponHI.sChannel;
            String strL = l();
            String strK = k();
            String strEncode = "";
            jSONObject.put("userId", TextUtils.isEmpty(str) ? "" : URLEncoder.encode(str, "UTF-8"));
            jSONObject.put("platform", TextUtils.isEmpty(strM) ? "" : URLEncoder.encode(strM, "UTF-8"));
            jSONObject.put(xh9.WEBSITE_PARAMS_CHANNEL, TextUtils.isEmpty(str2) ? "" : URLEncoder.encode(str2, "UTF-8"));
            try {
                if (h.a(context, "re_po_rt").e("a1_p_s_p_s")) {
                    jSONObject.put("mod", TextUtils.isEmpty(strL) ? "" : URLEncoder.encode(strL, "UTF-8"));
                    if (!TextUtils.isEmpty(strK)) {
                        strEncode = URLEncoder.encode(strK, "UTF-8");
                    }
                    jSONObject.put("sysver", strEncode);
                } else {
                    jSONObject.put("mod", "");
                    jSONObject.put("sysver", "");
                }
            } catch (Exception unused) {
            }
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static String b(Context context, int i) {
        try {
            return i == 1 ? c(com.kwad.sdk.e.b.QY().QP()) : c(com.kwad.sdk.e.b.QY().getIMEI());
        } catch (Throwable unused) {
            return bg.d;
        }
    }

    public static double c() {
        try {
            String strC = c(com.kwad.sdk.e.b.QY().getLocation());
            if (!TextUtils.isEmpty(strC) && !strC.startsWith("RISK")) {
                return new JSONObject(strC).getDouble("longitude");
            }
            return -1.0d;
        } catch (Throwable unused) {
            return -1.0d;
        }
    }

    public static String d() {
        try {
            String strC = c(com.kwad.sdk.e.b.QY().QU());
            if (!TextUtils.isEmpty(strC) && !strC.startsWith("RISK")) {
                JSONObject jSONObject = new JSONObject(strC);
                return jSONObject.getString("cellId") + ", " + jSONObject.getString("lac");
            }
            return strC;
        } catch (Throwable unused) {
            return bg.d;
        }
    }

    public static String e() {
        try {
            String strC = c(com.kwad.sdk.e.b.QY().QW());
            if (!TextUtils.isEmpty(strC)) {
                strC.startsWith("RISK");
            }
            return strC;
        } catch (Throwable unused) {
            return bg.d;
        }
    }

    public static JSONArray f() {
        try {
            String strC = c(com.kwad.sdk.e.b.QY().QV());
            if (!TextUtils.isEmpty(strC) && !strC.startsWith("RISK")) {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray(strC);
                for (int i = 0; i < jSONArray2.length(); i++) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("1", jSONArray2.getJSONObject(i).getString("ssid"));
                    jSONObject.put("2", jSONArray2.getJSONObject(i).getString("bssid"));
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String g() {
        try {
            return c(com.kwad.sdk.e.b.QY().getIp());
        } catch (Throwable unused) {
            return bg.c;
        }
    }

    public static String h() {
        try {
            return c(com.kwad.sdk.e.b.QY().getMac());
        } catch (Throwable unused) {
            return bg.c;
        }
    }

    public static String a(Context context) {
        try {
            return c(com.kwad.sdk.e.b.QY().getIMEI());
        } catch (Throwable unused) {
            return bg.d;
        }
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        try {
            Method method = cls.getMethod(str, clsArr);
            if (method != null) {
                return method;
            }
        } catch (Throwable unused) {
        }
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException unused2) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException();
    }

    public static String k() {
        return "ANDROID_" + Build.VERSION.RELEASE;
    }

    public static String a(Context context, int i) {
        try {
            if (i == 1) {
                return c(com.kwad.sdk.e.b.QY().QP());
            }
            return c(com.kwad.sdk.e.b.QY().getIMEI());
        } catch (Throwable unused) {
            return bg.d;
        }
    }

    public static String c(String str) {
        String string = "";
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("errorCode");
            if (i == 0) {
                string = jSONObject.getString("value");
                return string;
            }
            if (i == 3) {
                return bg.c;
            }
            return i == 1 ? bg.f40059a : bg.d;
        } catch (Throwable unused) {
            return string;
        }
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method methodB = b(cls, str, clsArr);
            try {
                methodB.setAccessible(true);
                return methodB;
            } catch (Throwable unused) {
                return methodB;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static String a(AccessibilityServiceInfo accessibilityServiceInfo) {
        String id = accessibilityServiceInfo.getId();
        int iLastIndexOf = id.lastIndexOf(WVNativeCallbackUtil.SEPERATER);
        return iLastIndexOf > 0 ? id.substring(0, iLastIndexOf) : id;
    }

    public static double b() {
        try {
            String strC = c(com.kwad.sdk.e.b.QY().getLocation());
            if (!TextUtils.isEmpty(strC) && !strC.startsWith("RISK")) {
                return new JSONObject(strC).getDouble("latitude");
            }
            return -1.0d;
        } catch (Throwable unused) {
            return -1.0d;
        }
    }

    public static void a(final Context context, String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || h.a(context, "re_po_rt").c(dd.br, 1) == 0) {
            return;
        }
        try {
            JSONObject jSONObjectA = new ck(str, ci.j).a(context);
            if (map != null && map.size() > 0) {
                jSONObjectA.put("module_section", new JSONObject(map));
            } else {
                jSONObjectA.put("module_section", new JSONObject());
            }
            final String string = jSONObjectA.toString();
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.bf.1
                @Override // java.lang.Runnable
                public final void run() {
                    cn.a(context, string);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static int b(String str) {
        try {
            return (!TextUtils.isEmpty(str) && new JSONObject(str).getBoolean("userSet")) ? 1 : 0;
        } catch (Throwable unused) {
            return -2;
        }
    }

    public static String l() {
        return Build.MANUFACTURER + "(" + Build.MODEL + ")";
    }

    public static boolean a(Context context, String str) {
        try {
            context.getPackageManager().getApplicationInfo(str, 0);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
