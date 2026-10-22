package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class dn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f40122a = "plc001_t_re";
    public static final String b = "wlpauct2";
    public static final String c = "plc001_pd_ptip_pi";
    public static final String d = "wiipaot";
    public static final int e = 1;
    public static final String f = "a1_p_s_p_s";
    public static final String g = "a1_p_s_p_s_c_b";
    private static dn j;
    private SharedPreferences h;
    private SharedPreferences.Editor i;

    private dn(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(bg.r, 4);
            this.h = sharedPreferences;
            this.i = sharedPreferences.edit();
        } catch (Throwable unused) {
        }
    }

    public static synchronized dn a(Context context) {
        try {
            if (j == null) {
                j = new dn(context);
            }
        } catch (Exception unused) {
            return null;
        }
        return j;
    }

    public boolean b(String str) {
        return this.h.getBoolean(str, false);
    }

    public void b(String str, String str2) {
        try {
            this.i.putString(str, str2);
            this.i.apply();
        } catch (Exception unused) {
        }
    }

    public static dn a() {
        return j;
    }

    public long a(String str) {
        return this.h.getLong(str, 0L);
    }

    public void a(String str, long j2, boolean z) {
        try {
            this.i.putLong(str, j2);
            if (z) {
                this.i.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public int a(String str, int i) {
        try {
            return this.h.getInt(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    public void a(String str, int i, boolean z) {
        try {
            this.i.putInt(str, i);
            if (z) {
                this.i.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public void a(String str, Boolean bool, boolean z) {
        try {
            SharedPreferences.Editor editor = this.i;
            if (editor != null) {
                editor.putBoolean(str, bool.booleanValue());
                if (z) {
                    this.i.apply();
                }
            }
        } catch (Exception unused) {
        }
    }

    public String a(String str, String str2) {
        return this.h.getString(str, str2);
    }
}
