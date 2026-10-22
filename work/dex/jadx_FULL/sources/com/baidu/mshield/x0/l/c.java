package com.baidu.mshield.x0.l;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.ac.F;
import com.baidu.mshield.x0.d.d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f26755a;
    public SharedPreferences.Editor b;
    public SharedPreferences c;
    public SharedPreferences.Editor d;

    public c(Context context) {
        try {
            SharedPreferences platformSharedSharedPreferences = F.getInstance().getPlatformSharedSharedPreferences(context);
            this.f26755a = platformSharedSharedPreferences;
            this.b = platformSharedSharedPreferences.edit();
            SharedPreferences platformPrivateSharedPreferences = F.getInstance().getPlatformPrivateSharedPreferences(context);
            this.c = platformPrivateSharedPreferences;
            this.d = platformPrivateSharedPreferences.edit();
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public String a() {
        return this.f26755a.getString("s_h_d_id", "");
    }

    public String b() {
        return this.f26755a.getString("rpnewuid", "");
    }

    public String c() {
        String string = this.f26755a.getString("rpnewuidn", "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            return new String(com.baidu.mshield.b.f.a.a(Base64.decode(string, 10), com.baidu.mshield.b.f.a.a(24)), "UTF-8");
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public String d() {
        return this.f26755a.getString("xytk", "");
    }

    public void e(String str) {
        this.b.putString("xytk2", str);
        this.b.apply();
    }

    public void f(String str) {
        this.b.putString("sgud", str);
        this.b.commit();
    }

    public void a(String str) {
        this.b.putString("rpnewuid", str);
        this.b.commit();
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.b.putString("rpnewuidn", "");
            this.b.commit();
            return;
        }
        try {
            this.b.putString("rpnewuidn", new String(Base64.encode(com.baidu.mshield.b.f.a.b(str.getBytes("UTF-8"), com.baidu.mshield.b.f.a.a(24)), 10), "UTF-8"));
            this.b.commit();
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public void d(String str) {
        this.b.putString("xytk", str);
        this.b.apply();
    }

    public String e() {
        return this.f26755a.getString("xytk2", "");
    }

    public String f() {
        return this.f26755a.getString("sgud", "");
    }

    public void c(String str) {
        this.d.putString("p_s_p_c", str);
        this.d.commit();
    }
}
