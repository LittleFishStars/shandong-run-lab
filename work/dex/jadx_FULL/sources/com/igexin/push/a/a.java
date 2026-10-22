package com.igexin.push.a;

import android.app.Activity;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f37854a;

    public static a a() {
        if (f37854a == null) {
            synchronized (a.class) {
                if (f37854a == null) {
                    f37854a = new a();
                }
            }
        }
        return f37854a;
    }

    public static b a(Activity activity) {
        String stringExtra = activity.getIntent().getStringExtra("action");
        if (TextUtils.isEmpty(stringExtra)) {
            activity.finish();
            return null;
        }
        stringExtra.hashCode();
        if (stringExtra.equals(com.igexin.push.core.b.r)) {
            return new g();
        }
        if (stringExtra.equals("com.igexin.action.notification.click")) {
            return new f();
        }
        activity.finish();
        return null;
    }
}
