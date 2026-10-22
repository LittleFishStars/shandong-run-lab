package com.baidu.mshield.x6.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mshield.x6.f.f;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f26756a;

    public a(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("msgzpfc", 4);
            this.f26756a = sharedPreferences;
            sharedPreferences.edit();
        } catch (Throwable th) {
            f.b(th);
        }
    }

    public String a(String str) {
        return this.f26756a.getString(str, "");
    }
}
