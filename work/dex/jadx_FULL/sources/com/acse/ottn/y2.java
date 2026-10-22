package com.acse.ottn;

import android.content.Context;
import android.content.Intent;
import java.io.ObjectStreamException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class y2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static y2 f23301a;

    public static y2 a() {
        if (f23301a == null) {
            synchronized (y2.class) {
                if (f23301a == null) {
                    f23301a = new y2();
                }
            }
        }
        return f23301a;
    }

    public final Object b() throws ObjectStreamException {
        return f23301a;
    }

    public void a(Context context) {
        n3.a().a("oaid_permission", Boolean.TRUE);
        context.startActivity(new Intent("android.settings.SETTINGS"));
    }
}
