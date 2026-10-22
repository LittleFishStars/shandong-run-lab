package com.baidu.mapauto.auth.store;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mapauto.auth.base.d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f26669a;
    public final SharedPreferences.Editor b;

    public a(Context context) {
        SharedPreferences sharedPreferences = context == null ? null : context.getSharedPreferences("license_auth", 0);
        this.f26669a = sharedPreferences;
        this.b = sharedPreferences != null ? sharedPreferences.edit() : null;
    }
}
