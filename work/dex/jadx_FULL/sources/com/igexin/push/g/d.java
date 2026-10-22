package com.igexin.push.g;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Pair;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.byazt.hv.TTDownloadField;
import com.getui.gtc.BuildConfig;
import com.igexin.assist.util.AssistUtils;
import com.zj.adlib.u15;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static long f38141a = 0;
    static HashMap<String, Object> b = new HashMap<>();
    private static final String c = "ro.miui.ui.version.name";
    private static final String d = "ro.miui.ui.version.code";
    private static final String e = "GT";
    private static volatile Boolean f;
    private static String g;
    private static PackageInfo h;

    public static Intent a(String str) throws URISyntaxException {
        String string;
        String strSubstring;
        StringBuilder sb;
        int i;
        int i2 = 0;
        try {
            boolean zStartsWith = str.startsWith("android-app:");
            int iLastIndexOf = str.lastIndexOf("#");
            try {
                if (iLastIndexOf == -1) {
                    if (!zStartsWith) {
                        return new Intent("android.intent.action.VIEW", Uri.parse(str));
                    }
                } else if (!str.startsWith("#Intent;", iLastIndexOf)) {
                    if (!zStartsWith) {
                        return d(str);
                    }
                    iLastIndexOf = -1;
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                if (iLastIndexOf >= 0) {
                    string = str.substring(0, iLastIndexOf);
                    iLastIndexOf += 8;
                } else {
                    string = str;
                }
                if (intent.getExtras() == null) {
                    intent.putExtras(new Bundle());
                }
                Bundle extras = intent.getExtras();
                boolean z = false;
                boolean z2 = false;
                Intent intent2 = intent;
                String strSubstring2 = null;
                while (true) {
                    if (iLastIndexOf < 0 || str.startsWith("end", iLastIndexOf)) {
                        break;
                    }
                    int iIndexOf = str.indexOf(61, iLastIndexOf);
                    if (iIndexOf < 0) {
                        iIndexOf = iLastIndexOf - 1;
                    }
                    int iIndexOf2 = str.indexOf(59, iLastIndexOf);
                    String strDecode = iIndexOf < iIndexOf2 ? Uri.decode(str.substring(iIndexOf + 1, iIndexOf2)) : "";
                    if (str.startsWith("action=", iLastIndexOf)) {
                        intent2.setAction(strDecode);
                        if (!z) {
                            z2 = true;
                        }
                    } else if (str.startsWith("category=", iLastIndexOf)) {
                        intent2.addCategory(strDecode);
                    } else if (str.startsWith("type=", iLastIndexOf)) {
                        intent2.setType(strDecode);
                    } else if (str.startsWith("launchFlags=", iLastIndexOf)) {
                        intent2.setFlags(Integer.decode(strDecode).intValue());
                        intent2.setFlags((~(67 | 128)) & intent2.getFlags());
                    } else if (str.startsWith("package=", iLastIndexOf)) {
                        intent2.setPackage(strDecode);
                    } else if (str.startsWith("component=", iLastIndexOf)) {
                        intent2.setComponent(ComponentName.unflattenFromString(strDecode));
                    } else if (str.startsWith("scheme=", iLastIndexOf)) {
                        if (z) {
                            intent2.setData(Uri.parse(strDecode + u15.f19942b));
                        } else {
                            strSubstring2 = strDecode;
                        }
                    } else if (str.startsWith("sourceBounds=", iLastIndexOf)) {
                        intent2.setSourceBounds(Rect.unflattenFromString(strDecode));
                    } else if (iIndexOf2 == iLastIndexOf + 3 && str.startsWith("SEL", iLastIndexOf)) {
                        intent2 = new Intent();
                        z = true;
                    } else {
                        String strDecode2 = Uri.decode(str.substring(iLastIndexOf + 2, iIndexOf));
                        if (str.startsWith("S.", iLastIndexOf)) {
                            extras.putString(strDecode2, strDecode);
                        } else if (str.startsWith("B.", iLastIndexOf)) {
                            extras.putBoolean(strDecode2, Boolean.parseBoolean(strDecode));
                        } else if (str.startsWith("b.", iLastIndexOf)) {
                            extras.putByte(strDecode2, Byte.parseByte(strDecode));
                        } else if (str.startsWith("c.", iLastIndexOf)) {
                            extras.putChar(strDecode2, strDecode.charAt(0));
                        } else if (str.startsWith("d.", iLastIndexOf)) {
                            extras.putDouble(strDecode2, Double.parseDouble(strDecode));
                        } else if (str.startsWith("f.", iLastIndexOf)) {
                            extras.putFloat(strDecode2, Float.parseFloat(strDecode));
                        } else if (str.startsWith("i.", iLastIndexOf)) {
                            extras.putInt(strDecode2, Integer.parseInt(strDecode));
                        } else if (str.startsWith("l.", iLastIndexOf)) {
                            extras.putLong(strDecode2, Long.parseLong(strDecode));
                        } else {
                            if (!str.startsWith("s.", iLastIndexOf)) {
                                throw new URISyntaxException(str, "unknown EXTRA type", iLastIndexOf);
                            }
                            extras.putShort(strDecode2, Short.parseShort(strDecode));
                        }
                    }
                    iLastIndexOf = iIndexOf2 + 1;
                }
                intent2.putExtras(extras);
                if (!z) {
                    intent = intent2;
                } else if (intent.getPackage() == null) {
                    intent.setSelector(intent2);
                }
                if (string != null) {
                    if (string.startsWith("intent:")) {
                        string = string.substring(7);
                        if (strSubstring2 != null) {
                            sb = new StringBuilder();
                            sb.append(strSubstring2);
                            sb.append(com.google.common.net.c.b);
                            sb.append(string);
                            string = sb.toString();
                        }
                    } else if (string.startsWith("android-app:")) {
                        if (string.charAt(12) == '/' && string.charAt(13) == '/') {
                            int iIndexOf3 = string.indexOf(47, 14);
                            if (iIndexOf3 < 0) {
                                intent.setPackage(string.substring(14));
                                if (!z2) {
                                    intent.setAction("android.intent.action.MAIN");
                                }
                                string = "";
                            } else {
                                intent.setPackage(string.substring(14, iIndexOf3));
                                int i3 = iIndexOf3 + 1;
                                if (i3 >= string.length()) {
                                    strSubstring = null;
                                } else {
                                    int iIndexOf4 = string.indexOf(47, i3);
                                    if (iIndexOf4 >= 0) {
                                        strSubstring2 = string.substring(i3, iIndexOf4);
                                        if (iIndexOf4 >= string.length() || (iIndexOf3 = string.indexOf(47, (i = iIndexOf4 + 1))) < 0) {
                                            iIndexOf3 = iIndexOf4;
                                        } else {
                                            strSubstring = string.substring(i, iIndexOf3);
                                        }
                                    } else {
                                        strSubstring2 = string.substring(i3);
                                    }
                                    strSubstring = null;
                                }
                                if (strSubstring2 == null) {
                                    if (!z2) {
                                        intent.setAction("android.intent.action.MAIN");
                                    }
                                    string = "";
                                } else if (strSubstring == null) {
                                    sb = new StringBuilder();
                                    sb.append(strSubstring2);
                                    sb.append(u15.f19942b);
                                    string = sb.toString();
                                } else {
                                    string = strSubstring2 + "://" + strSubstring + string.substring(iIndexOf3);
                                }
                            }
                        } else {
                            string = "";
                        }
                    }
                    if (string.length() > 0) {
                        try {
                            intent.setData(Uri.parse(string));
                        } catch (IllegalArgumentException e2) {
                            throw new URISyntaxException(str, e2.getMessage());
                        }
                    }
                }
                return intent;
            } catch (IndexOutOfBoundsException unused) {
                i2 = iLastIndexOf;
                throw new URISyntaxException(str, "illegal Intent URI format", i2);
            }
        } catch (IndexOutOfBoundsException unused2) {
        }
    }

    public static Pair<ServiceInfo, Class> a(Context context, Class cls) {
        try {
            if (h == null) {
                h = context.getPackageManager().getPackageInfo(context.getPackageName(), 516);
            }
            ServiceInfo[] serviceInfoArr = h.services;
            if (serviceInfoArr != null && serviceInfoArr.length > 0) {
                int length = serviceInfoArr.length;
                for (int i = 0; i < length; i++) {
                    ServiceInfo serviceInfo = serviceInfoArr[i];
                    try {
                        Class<?> cls2 = Class.forName(serviceInfo.name);
                        if (cls2 != cls && cls.isAssignableFrom(cls2)) {
                            com.igexin.c.a.c.a.b("GT", cls.getSimpleName() + " child is " + cls2.getSimpleName());
                            return Pair.create(serviceInfo, cls2);
                        }
                    } catch (Throwable th) {
                        com.igexin.c.a.c.a.a(th);
                    }
                }
            }
        } catch (Throwable th2) {
            com.igexin.c.a.c.a.a(th2);
            com.igexin.c.a.c.a.c.a().a(" findGtImplClassInManifest error = " + th2.toString());
        }
        return Pair.create(null, null);
    }

    private static String a(Context context) {
        try {
            Intent launchIntentForPackage = context.getApplicationContext().getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            return (launchIntentForPackage == null || launchIntentForPackage.getComponent() == null) ? "" : launchIntentForPackage.getComponent().getClassName();
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return "";
        }
    }

    public static String a(ApplicationInfo applicationInfo) {
        try {
            String string = applicationInfo.metaData.getString(com.igexin.push.core.b.f37950a);
            if (TextUtils.isEmpty(string)) {
                string = applicationInfo.packageName;
            }
            Class<?> cls = Class.forName(string + ".BuildConfig");
            return (String) cls.getField("GETUI_APPID").get(cls);
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a("get cf error|" + e2.toString(), new Object[0]);
            return "";
        }
    }

    public static HashMap<String, Object> a() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - f38141a < 2000) {
                return b;
            }
            HashMap<String, Object> map = b;
            Boolean bool = Boolean.FALSE;
            map.put("isPause", bool);
            b.put("isTranslucent", bool);
            f38141a = jCurrentTimeMillis;
            Class<?> cls = Class.forName(ProcessUtils.ACTIVITY_THREAD);
            Activity activity = null;
            Object objInvoke = cls.getMethod(ProcessUtils.CURRENT_ACTIVITY_THREAD, new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(objInvoke);
            if (arrayMap.size() <= 0) {
                return b;
            }
            Boolean boolValueOf = null;
            for (Object obj : arrayMap.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
                declaredField2.setAccessible(true);
                Activity activity2 = (Activity) declaredField2.get(obj);
                Field declaredField3 = cls2.getDeclaredField("paused");
                declaredField3.setAccessible(true);
                boolean z = declaredField3.getBoolean(obj);
                boolValueOf = Boolean.valueOf(boolValueOf == null ? z : boolValueOf.booleanValue() && z);
                if (!z) {
                    activity = activity2;
                }
            }
            boolean z2 = activity != null ? activity.getTheme().obtainStyledAttributes(new int[]{R.attr.windowIsTranslucent}).getBoolean(0, false) : false;
            b.put("isPause", Boolean.valueOf(Boolean.TRUE.equals(boolValueOf)));
            b.put("isTranslucent", Boolean.valueOf(z2));
            return b;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return b;
        }
    }

    public static synchronized boolean a(int i, boolean z) {
        try {
            if (com.igexin.push.core.e.l == null) {
                return false;
            }
            String str = com.igexin.push.core.e.G;
            if (AssistUtils.BRAND_HW.equalsIgnoreCase(str) || AssistUtils.BRAND_HON.equalsIgnoreCase(str)) {
                int iIntValue = ((Integer) o.b(com.igexin.push.core.e.l, o.h, 0)).intValue();
                if (!z) {
                    i += iIntValue;
                }
                o.a(com.igexin.push.core.e.l, o.h, Integer.valueOf(i));
                Bundle bundle = new Bundle();
                bundle.putString("package", com.igexin.push.core.e.g);
                bundle.putString(bolts.c.f, a(com.igexin.push.core.e.l));
                bundle.putInt("badgenumber", i);
                Uri uri = Uri.parse("content://com.huawei.android.launcher.settings/badge/");
                Uri uri2 = Uri.parse("content://com.hihonor.android.launcher.settings/badge/");
                if (TextUtils.isEmpty(com.igexin.push.core.e.l.getContentResolver().getType(uri))) {
                    uri = uri2;
                }
                com.igexin.push.core.e.l.getContentResolver().call(uri, "change_badge", (String) null, bundle);
                return true;
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return false;
    }

    public static boolean a(String... strArr) {
        for (int i = 0; i < 5; i++) {
            if (TextUtils.isEmpty(strArr[i])) {
                return true;
            }
        }
        return false;
    }

    private static boolean b() {
        try {
            if (f != null) {
                return f.booleanValue();
            }
            Boolean boolValueOf = Boolean.valueOf((!"Xiaomi".equalsIgnoreCase(com.igexin.push.core.e.G) && TextUtils.isEmpty(c("ro.miui.ui.version.name")) && TextUtils.isEmpty(c("ro.miui.ui.version.code"))) ? false : true);
            f = boolValueOf;
            return boolValueOf.booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b(int i, boolean z) {
        try {
            if (com.igexin.push.core.e.l == null || !"vivo".equalsIgnoreCase(com.igexin.push.core.e.G)) {
                return false;
            }
            Intent intent = new Intent();
            intent.setAction("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
            intent.putExtra(ALPParamConstant.PACKAGENAME, com.igexin.push.core.e.l.getPackageName());
            Intent launchIntentForPackage = com.igexin.push.core.e.l.getPackageManager().getLaunchIntentForPackage(com.igexin.push.core.e.l.getPackageName());
            if (launchIntentForPackage == null || launchIntentForPackage.getComponent() == null) {
                return false;
            }
            int iIntValue = ((Integer) o.b(com.igexin.push.core.e.l, o.i, 0)).intValue();
            if (!z) {
                i += iIntValue;
            }
            o.a(com.igexin.push.core.e.l, o.i, Integer.valueOf(i));
            intent.putExtra("className", launchIntentForPackage.getComponent().getClassName());
            intent.putExtra("notificationNum", i);
            intent.addFlags(16777216);
            com.igexin.push.core.e.l.sendBroadcast(intent);
            return true;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static boolean b(String str) {
        try {
            if (TextUtils.isEmpty(g)) {
                g = c();
                com.igexin.c.a.c.a.b("GT", " gtcVersion = " + g);
            }
            String[] strArrSplit = g.split("\\.");
            String[] strArrSplit2 = str.split("\\.");
            if (strArrSplit.length == 4 && strArrSplit2.length == 4) {
                for (int i = 0; i < 3; i++) {
                    int i2 = Integer.parseInt(strArrSplit2[i]);
                    int i3 = Integer.parseInt(strArrSplit[i]);
                    if (i3 != i2) {
                        return i3 < i2;
                    }
                }
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return false;
    }

    private static String c() {
        try {
            Field declaredField = BuildConfig.class.getDeclaredField("VERSION_NAME");
            declaredField.setAccessible(true);
            return ((String) declaredField.get(null)).substring(4);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return "";
        }
    }

    private static String c(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
            try {
                String line = bufferedReader.readLine();
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    com.igexin.c.a.c.a.a(e2);
                }
                return line;
            } catch (Exception unused) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                        com.igexin.c.a.c.a.a(e3);
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e4) {
                        com.igexin.c.a.c.a.a(e4);
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean c(int i, boolean z) {
        try {
            if (com.igexin.push.core.e.l == null || !"oppo".equalsIgnoreCase(com.igexin.push.core.e.G)) {
                return false;
            }
            int iIntValue = ((Integer) o.b(com.igexin.push.core.e.l, o.j, 0)).intValue();
            if (!z) {
                i += iIntValue;
            }
            o.a(com.igexin.push.core.e.l, o.j, Integer.valueOf(i));
            Intent intent = new Intent("com.oppo.unsettledevent");
            intent.putExtra(ALPParamConstant.PACKAGENAME, com.igexin.push.core.e.l.getPackageName());
            intent.putExtra("number", i);
            intent.putExtra("upgradeNumber", i);
            List<ResolveInfo> listQueryBroadcastReceivers = com.igexin.push.core.e.l.getPackageManager().queryBroadcastReceivers(intent, 0);
            if (listQueryBroadcastReceivers != null && listQueryBroadcastReceivers.size() > 0) {
                com.igexin.push.core.e.l.sendBroadcast(intent);
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("app_badge_count", i);
            com.igexin.push.core.e.l.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (String) null, bundle);
            return true;
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return false;
        }
    }

    private static Intent d(String str) throws URISyntaxException {
        boolean z;
        int i;
        String strSubstring;
        int iLastIndexOf = str.lastIndexOf(35);
        if (iLastIndexOf < 0) {
            return new Intent("android.intent.action.VIEW", Uri.parse(str));
        }
        int i2 = iLastIndexOf + 1;
        boolean z2 = true;
        if (str.regionMatches(i2, "action(", 0, 7)) {
            int i3 = i2 + 7;
            int iIndexOf = str.indexOf(41, i3);
            strSubstring = str.substring(i3, iIndexOf);
            i = iIndexOf + 1;
            z = true;
        } else {
            z = false;
            i = i2;
            strSubstring = null;
        }
        Intent intent = new Intent(strSubstring);
        int i4 = 33;
        if (str.regionMatches(i, "categories(", 0, 11)) {
            int i5 = i + 11;
            int iIndexOf2 = str.indexOf(41, i5);
            while (i5 < iIndexOf2) {
                int iIndexOf3 = str.indexOf(33, i5);
                if (iIndexOf3 < 0 || iIndexOf3 > iIndexOf2) {
                    iIndexOf3 = iIndexOf2;
                }
                if (i5 < iIndexOf3) {
                    intent.addCategory(str.substring(i5, iIndexOf3));
                }
                i5 = iIndexOf3 + 1;
            }
            i = iIndexOf2 + 1;
            z = true;
        }
        if (str.regionMatches(i, "type(", 0, 5)) {
            int i6 = i + 5;
            int iIndexOf4 = str.indexOf(41, i6);
            intent.setType(str.substring(i6, iIndexOf4));
            i = iIndexOf4 + 1;
            z = true;
        }
        if (str.regionMatches(i, "launchFlags(", 0, 12)) {
            int i7 = i + 12;
            int iIndexOf5 = str.indexOf(41, i7);
            intent.setFlags(Integer.decode(str.substring(i7, iIndexOf5)).intValue());
            intent.setFlags((~(67 | 128)) & intent.getFlags());
            i = iIndexOf5 + 1;
            z = true;
        }
        if (str.regionMatches(i, "component(", 0, 10)) {
            int i8 = i + 10;
            int iIndexOf6 = str.indexOf(41, i8);
            int iIndexOf7 = str.indexOf(33, i8);
            if (iIndexOf7 >= 0 && iIndexOf7 < iIndexOf6) {
                intent.setComponent(new ComponentName(str.substring(i8, iIndexOf7), str.substring(iIndexOf7 + 1, iIndexOf6)));
            }
            i = iIndexOf6 + 1;
            z = true;
        }
        if (str.regionMatches(i, "extras(", 0, 7)) {
            int i9 = i + 7;
            int iIndexOf8 = str.indexOf(41, i9);
            int i10 = -1;
            if (iIndexOf8 == -1) {
                throw new URISyntaxException(str, "EXTRA missing trailing ')'", i9);
            }
            if (intent.getExtras() == null) {
                intent.putExtras(new Bundle());
            }
            Bundle extras = intent.getExtras();
            while (i9 < iIndexOf8) {
                int iIndexOf9 = str.indexOf(61, i9);
                int i11 = i9 + 1;
                if (iIndexOf9 <= i11 || i9 >= iIndexOf8) {
                    throw new URISyntaxException(str, "EXTRA missing '='", i9);
                }
                char cCharAt = str.charAt(i9);
                String strSubstring2 = str.substring(i11, iIndexOf9);
                int i12 = iIndexOf9 + 1;
                int iIndexOf10 = str.indexOf(i4, i12);
                if (iIndexOf10 == i10 || iIndexOf10 >= iIndexOf8) {
                    iIndexOf10 = iIndexOf8;
                }
                if (i12 >= iIndexOf10) {
                    throw new URISyntaxException(str, "EXTRA missing '!'", i12);
                }
                String strSubstring3 = str.substring(i12, iIndexOf10);
                if (cCharAt == 'B') {
                    extras.putBoolean(strSubstring2, Boolean.parseBoolean(strSubstring3));
                } else if (cCharAt == 'S') {
                    extras.putString(strSubstring2, Uri.decode(strSubstring3));
                } else if (cCharAt == 'f') {
                    extras.putFloat(strSubstring2, Float.parseFloat(strSubstring3));
                } else if (cCharAt == 'i') {
                    extras.putInt(strSubstring2, Integer.parseInt(strSubstring3));
                } else if (cCharAt == 'l') {
                    extras.putLong(strSubstring2, Long.parseLong(strSubstring3));
                } else {
                    if (cCharAt != 's') {
                        switch (cCharAt) {
                            case 'b':
                                extras.putByte(strSubstring2, Byte.parseByte(strSubstring3));
                                break;
                            case 'c':
                                extras.putChar(strSubstring2, Uri.decode(strSubstring3).charAt(0));
                                break;
                            case 'd':
                                try {
                                    extras.putDouble(strSubstring2, Double.parseDouble(strSubstring3));
                                } catch (NumberFormatException unused) {
                                    throw new URISyntaxException(str, "EXTRA value can't be parsed", iIndexOf10);
                                }
                                break;
                            default:
                                throw new URISyntaxException(str, "EXTRA has unknown type", iIndexOf10);
                        }
                        throw new URISyntaxException(str, "EXTRA value can't be parsed", iIndexOf10);
                    }
                    extras.putShort(strSubstring2, Short.parseShort(strSubstring3));
                }
                char cCharAt2 = str.charAt(iIndexOf10);
                if (cCharAt2 == ')') {
                    intent.putExtras(extras);
                } else {
                    if (cCharAt2 != '!') {
                        throw new URISyntaxException(str, "EXTRA missing '!'", iIndexOf10);
                    }
                    i9 = iIndexOf10 + 1;
                    i4 = 33;
                    i10 = -1;
                }
            }
            intent.putExtras(extras);
        } else {
            z2 = z;
        }
        intent.setData(z2 ? Uri.parse(str.substring(0, iLastIndexOf)) : Uri.parse(str));
        if (intent.getAction() != null) {
            return intent;
        }
        intent.setAction("android.intent.action.VIEW");
        return intent;
    }
}
