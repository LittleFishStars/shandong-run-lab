package com.kuaishou.weapon.p0;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.res.Configuration;
import android.provider.Settings;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class dj {
    public static String a(String str) {
        if (str.contains("http")) {
            str = str.replace("https://", "").replace("http://", "");
        }
        return str.contains(WVNativeCallbackUtil.SEPERATER) ? str.substring(0, str.indexOf(WVNativeCallbackUtil.SEPERATER)) : str;
    }

    public static Set b(Context context) {
        return null;
    }

    public static int c(Context context) {
        try {
            return a(context, "show_touches");
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int d(Context context) {
        try {
            return a(context, "pointer_location");
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int e(Context context) {
        try {
            Configuration configuration = context.getResources().getConfiguration();
            return configuration.keyboard == 1 || configuration.hardKeyboardHidden == 2 ? 0 : 1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String a(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j));
        } catch (Exception unused) {
            return "";
        }
    }

    public static Set a(Context context) {
        try {
            List<AccessibilityServiceInfo> installedAccessibilityServiceList = ((AccessibilityManager) context.getSystemService("accessibility")).getInstalledAccessibilityServiceList();
            HashSet hashSet = new HashSet();
            for (AccessibilityServiceInfo accessibilityServiceInfo : installedAccessibilityServiceList) {
                if (accessibilityServiceInfo != null && !TextUtils.isEmpty(accessibilityServiceInfo.getId())) {
                    hashSet.add(accessibilityServiceInfo.getId());
                }
            }
            if (hashSet.size() > 0) {
                return hashSet;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private static int a(Context context, String str) {
        try {
            return Settings.System.getInt(context.getContentResolver(), str, 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int a() {
        BufferedReader bufferedReader = null;
        try {
            FileInputStream fileInputStream = (FileInputStream) Class.forName("java.io.FileInputStream").getConstructor(String.class).newInstance("/sys/class/power_supply/usb/online");
            if (fileInputStream != null) {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream), 1000);
                try {
                    String line = bufferedReader2.readLine();
                    if (!TextUtils.isEmpty(line) && TextUtils.equals(line, "1")) {
                        try {
                            bufferedReader2.close();
                        } catch (Throwable unused) {
                        }
                        return 1;
                    }
                    bufferedReader = bufferedReader2;
                } catch (Throwable unused2) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    return 0;
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused4) {
                }
            }
            return 0;
        } catch (Throwable unused5) {
        }
    }

    public static Set a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() <= 0) {
                return null;
            }
            HashSet hashSet = new HashSet();
            for (int i = 0; i < jSONArray.length(); i++) {
                hashSet.add(jSONArray.get(i));
            }
            return hashSet;
        } catch (Exception unused) {
            return null;
        }
    }
}
