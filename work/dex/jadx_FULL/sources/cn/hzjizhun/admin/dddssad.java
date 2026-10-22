package cn.hzjizhun.admin;

import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class dddssad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f22712a = false;

    public static void a(Object obj) {
        if (f22712a) {
            if (obj == null) {
                obj = "<null>";
            }
            Log.d("OAID", obj.toString());
        }
    }
}
