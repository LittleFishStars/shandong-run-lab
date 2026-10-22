package com.baidu.mshield.x6.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mshield.ac.F;
import com.baidu.mshield.x6.f.f;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f26758a;
    public SharedPreferences.Editor b;

    public c(Context context) {
        try {
            SharedPreferences platformSharedSharedPreferences = F.getInstance().getPlatformSharedSharedPreferences(context);
            this.f26758a = platformSharedSharedPreferences;
            this.b = platformSharedSharedPreferences.edit();
        } catch (Throwable th) {
            f.b(th);
        }
    }

    public void a(String str) {
        this.b.putString("xytk", str);
        this.b.commit();
    }

    public String b() {
        return this.f26758a.getString("xytk", "");
    }

    public String c() {
        return this.f26758a.getString("xytk2", "");
    }

    public void d(String str) {
        this.b.putString("xytkrt", str);
        this.b.commit();
    }

    public String e() {
        return this.f26758a.getString("xytk_m", "");
    }

    public String f() {
        return this.f26758a.getString("xytkrt", "");
    }

    public void b(String str) {
        this.b.putString("xytk2", str);
        this.b.commit();
    }

    public void c(String str) {
        this.b.putString("xytkrt2", str);
        this.b.commit();
    }

    public String a() {
        return this.f26758a.getString("wmcudd", "");
    }

    public String d() {
        return this.f26758a.getString("xytkrt2", "");
    }
}
