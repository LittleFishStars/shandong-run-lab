package com.kwad.sdk.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Deprecated
public class bq {
    static final String TAG = "bq";

    public static void a(String str, String str2, int i) {
        SharedPreferences sharedPreferencesM1068if = m1068if(str);
        if (sharedPreferencesM1068if == null) {
            return;
        }
        sharedPreferencesM1068if.edit().putInt(str2, i).apply();
    }

    public static void az(String str, String str2) {
        SharedPreferences sharedPreferencesM1068if = m1068if(str);
        if (sharedPreferencesM1068if == null) {
            return;
        }
        sharedPreferencesM1068if.edit().remove(str2).apply();
    }

    public static int b(String str, String str2, int i) {
        SharedPreferences sharedPreferencesM1068if = m1068if(str);
        return sharedPreferencesM1068if == null ? i : sharedPreferencesM1068if.getInt(str2, i);
    }

    public static void h(String str, String str2, String str3) {
        a(str, str2, str3, false);
    }

    public static String i(String str, String str2, String str3) {
        String string;
        try {
            SharedPreferences sharedPreferencesM1068if = m1068if(str);
            if (sharedPreferencesM1068if != null && (string = sharedPreferencesM1068if.getString(str2, str3)) != null && !TextUtils.isEmpty(string)) {
                return (TextUtils.equals(string, str3) || !com.kwad.sdk.core.a.c.isEncodeKsSdk(string)) ? string : com.kwad.sdk.core.a.c.decodeKsSdk(string);
            }
            return str3;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return "";
        }
    }

    @Nullable
    /* JADX INFO: renamed from: if, reason: not valid java name */
    public static SharedPreferences m1068if(String str) {
        try {
            return ServiceProvider.Ud().getSharedPreferences(str, 0);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }

    public static void j(String str, String str2, String str3) {
        if (com.kwad.sdk.core.a.c.isEncodeKsSdk(str)) {
            return;
        }
        h(str2, str3, com.kwad.sdk.core.a.c.encodeKsSdk(str));
    }

    public static void l(String str, String str2, boolean z) {
        SharedPreferences sharedPreferencesM1068if = m1068if(str);
        if (sharedPreferencesM1068if == null) {
            return;
        }
        sharedPreferencesM1068if.edit().putBoolean(str2, z).apply();
    }

    public static boolean m(String str, String str2, boolean z) {
        SharedPreferences sharedPreferencesM1068if = m1068if(str);
        return sharedPreferencesM1068if == null ? z : sharedPreferencesM1068if.getBoolean(str2, z);
    }

    public static void a(String str, String str2, long j) {
        SharedPreferences sharedPreferencesM1068if = m1068if(str);
        if (sharedPreferencesM1068if == null) {
            return;
        }
        sharedPreferencesM1068if.edit().putLong(str2, j).apply();
    }

    public static long b(String str, String str2, long j) {
        SharedPreferences sharedPreferencesM1068if = m1068if(str);
        return sharedPreferencesM1068if == null ? j : sharedPreferencesM1068if.getLong(str2, j);
    }

    public static void a(String str, String str2, String str3, boolean z) {
        try {
            SharedPreferences sharedPreferencesM1068if = m1068if(str);
            if (sharedPreferencesM1068if == null) {
                return;
            }
            if (z && !com.kwad.sdk.core.a.c.isEncodeKsSdk(str3)) {
                sharedPreferencesM1068if.edit().putString(str2, com.kwad.sdk.core.a.c.encodeKsSdk(str3)).apply();
            } else {
                sharedPreferencesM1068if.edit().putString(str2, str3).apply();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static <T> void a(String str, Map<String, T> map) {
        SharedPreferences sharedPreferencesM1068if = m1068if(str);
        if (sharedPreferencesM1068if == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1068if.edit();
        for (Map.Entry<String, T> entry : map.entrySet()) {
            try {
                a(editorEdit, entry.getKey(), entry.getValue());
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.e(TAG, Log.getStackTraceString(th));
            }
        }
        editorEdit.apply();
    }

    private static void a(SharedPreferences.Editor editor, String str, Object obj) {
        if (str != null) {
            if (obj instanceof Integer) {
                editor.putInt(str, ((Integer) obj).intValue());
                return;
            }
            if (obj instanceof Long) {
                editor.putLong(str, ((Long) obj).longValue());
                return;
            }
            if (obj instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) obj).booleanValue());
                return;
            }
            if (obj instanceof Float) {
                editor.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Set) {
                editor.putStringSet(str, (Set) obj);
            } else if (obj instanceof String) {
                editor.putString(str, String.valueOf(obj));
            }
        }
    }
}
