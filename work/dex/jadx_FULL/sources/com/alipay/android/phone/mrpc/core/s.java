package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Boolean f25333a;

    public static final boolean a(Context context) {
        Boolean bool = f25333a;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean boolValueOf = Boolean.valueOf((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 2) != 0);
            f25333a = boolValueOf;
            return boolValueOf.booleanValue();
        } catch (Exception e) {
            Log.e("MiscUtils", "", e);
            return false;
        }
    }
}
