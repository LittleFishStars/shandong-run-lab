package com.beizi.fusion;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class r6 implements kc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Application f27714a;
    private String b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final r6 f27715a = new r6();
    }

    private r6() {
    }

    public static void a(Application application) {
        if (application == null) {
            return;
        }
        r6 r6Var = a.f27715a;
        r6Var.f27714a = application;
        a(application, r6Var);
    }

    @Override // com.beizi.fusion.kc
    public void a(Exception exc) {
    }

    public static void a(Context context, kc kcVar) {
        vj.a(context).a(kcVar);
    }

    public static boolean a(Context context) {
        return vj.a(context).a();
    }

    @Override // com.beizi.fusion.kc
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            a(new tj("OAID is empty"));
        } else {
            this.b = str;
        }
    }
}
