package com.baidu.mshield;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f26698a;
    public SharedPreferences.Editor b;

    public a(Context context) {
        try {
            SharedPreferences sharedPreferencesC = com.baidu.mshield.sharedpreferences.a.a(context).c("msgzpfc");
            this.f26698a = sharedPreferencesC;
            this.b = sharedPreferencesC.edit();
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.c(th.getMessage());
        }
    }

    public boolean a() {
        return this.f26698a.getInt("cloud_sw", 0) == 1;
    }

    public int b() {
        return this.f26698a.getInt("wm_in_ma_cco", 3);
    }

    public void a(String str, int i) {
        this.b.putInt("wm_in_cco" + str, i);
        this.b.commit();
    }

    public int a(String str) {
        return this.f26698a.getInt("wm_in_cco" + str, 0);
    }
}
