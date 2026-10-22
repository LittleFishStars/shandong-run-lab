package com.alipay.sdk.m.f0;

import android.content.Context;
import com.kuaishou.weapon.p0.bo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f25432a = new a();

    public static a a() {
        return f25432a;
    }

    public String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName;
        } catch (Exception unused) {
            return bo.e;
        }
    }
}
