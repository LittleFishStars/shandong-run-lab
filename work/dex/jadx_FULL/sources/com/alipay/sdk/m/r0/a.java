package com.alipay.sdk.m.r0;

import android.content.Context;
import android.content.SharedPreferences;
import com.alipay.sdk.m.q0.f;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f25499a;
    public SharedPreferences b;
    public SharedPreferences.Editor c = null;
    public Context d;
    public boolean e;

    public a(Context context, String str, String str2, boolean z, boolean z2) {
        this.b = null;
        this.e = z2;
        this.f25499a = str2;
        this.d = context;
        if (context != null) {
            this.b = context.getSharedPreferences(str2, 0);
        }
    }

    public final void a() {
        SharedPreferences sharedPreferences;
        if (this.c != null || (sharedPreferences = this.b) == null) {
            return;
        }
        this.c = sharedPreferences.edit();
    }

    public void b(String str) {
        if (f.b(str) || str.equals("t")) {
            return;
        }
        a();
        SharedPreferences.Editor editor = this.c;
        if (editor != null) {
            editor.remove(str);
        }
    }

    public void a(String str, String str2) {
        if (f.b(str) || str.equals("t")) {
            return;
        }
        a();
        SharedPreferences.Editor editor = this.c;
        if (editor != null) {
            editor.putString(str, str2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0021  */
    public boolean b() {
        boolean z;
        Context context;
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editor = this.c;
        if (editor == null) {
            z = true;
        } else {
            if (!this.e && this.b != null) {
                editor.putLong("t", jCurrentTimeMillis);
            }
            if (this.c.commit()) {
                z = true;
            } else {
                z = false;
            }
        }
        if (this.b != null && (context = this.d) != null) {
            this.b = context.getSharedPreferences(this.f25499a, 0);
        }
        return z;
    }

    public String a(String str) {
        SharedPreferences sharedPreferences = this.b;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!f.b(string)) {
                return string;
            }
        }
        return "";
    }
}
