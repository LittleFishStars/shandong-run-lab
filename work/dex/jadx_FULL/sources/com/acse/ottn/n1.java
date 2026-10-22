package com.acse.ottn;

import android.content.Context;
import android.content.SharedPreferences;
import com.acse.ottn.util.HelpShopAppUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f23100a = o1.c().b() + "_info";
    public static SharedPreferences b;
    public static n1 c;
    public static SharedPreferences.Editor d;

    public n1(Context context) {
        b();
    }

    public static synchronized n1 a() {
        try {
            if (HelpShopAppUtil.getContext() == null) {
                return null;
            }
            if (c == null) {
                c = new n1(HelpShopAppUtil.getContext());
            }
            return c;
        } catch (Exception unused) {
            if (c == null) {
                c = new n1();
            }
            return c;
        }
        throw th;
    }

    public void b() {
        try {
            if (b == null) {
                SharedPreferences sharedPreferences = HelpShopAppUtil.getContext().getSharedPreferences(f23100a, 0);
                b = sharedPreferences;
                if (sharedPreferences != null) {
                    d = sharedPreferences.edit();
                }
            }
        } catch (Exception unused) {
            if (b == null) {
                SharedPreferences sharedPreferences2 = HelpShopAppUtil.getContext().getSharedPreferences(HelpShopAppUtil.getContext().getPackageName() + "_info", 0);
                b = sharedPreferences2;
                if (sharedPreferences2 != null) {
                    d = sharedPreferences2.edit();
                }
            }
        }
    }

    public Long c(String str) {
        SharedPreferences sharedPreferences = b;
        if (sharedPreferences == null || c == null) {
            return 0L;
        }
        return Long.valueOf(sharedPreferences.getLong(str, 0L));
    }

    public String d(String str) {
        SharedPreferences sharedPreferences = b;
        return (sharedPreferences == null || c == null) ? "" : sharedPreferences.getString(str, "");
    }

    public n1() {
        try {
            if (b == null) {
                SharedPreferences sharedPreferences = HelpShopAppUtil.getContext().getSharedPreferences("acse_info", 0);
                b = sharedPreferences;
                if (sharedPreferences != null) {
                    d = sharedPreferences.edit();
                }
            }
        } catch (Exception e) {
            h2.a("preferences", e.getMessage());
        }
    }

    public void b(String str, String str2) {
        SharedPreferences.Editor editor = d;
        if (editor == null) {
            return;
        }
        editor.putString(str, str2).apply();
    }

    public String a(String str, String str2) {
        SharedPreferences sharedPreferences = b;
        return (sharedPreferences == null || c == null) ? str2 : sharedPreferences.getString(str, str2);
    }

    public void b(String str, int i) {
        SharedPreferences.Editor editor = d;
        if (editor == null) {
            return;
        }
        editor.putInt(str, i).apply();
    }

    public void a(String str, long j) {
        SharedPreferences.Editor editor = d;
        if (editor == null) {
            return;
        }
        editor.putLong(str, j).apply();
    }

    public int b(String str) {
        SharedPreferences sharedPreferences = b;
        if (sharedPreferences == null || c == null) {
            return 0;
        }
        return sharedPreferences.getInt(str, 0);
    }

    public int a(String str, int i) {
        SharedPreferences sharedPreferences = b;
        return (sharedPreferences == null || c == null) ? i : sharedPreferences.getInt(str, i);
    }

    public void a(String str, boolean z) {
        SharedPreferences.Editor editor = d;
        if (editor == null) {
            return;
        }
        editor.putBoolean(str, z).apply();
    }

    public boolean a(String str) {
        SharedPreferences sharedPreferences = b;
        if (sharedPreferences == null || c == null) {
            return false;
        }
        return sharedPreferences.getBoolean(str, false);
    }
}
