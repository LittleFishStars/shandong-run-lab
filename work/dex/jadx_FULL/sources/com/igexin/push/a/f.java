package com.igexin.push.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.igexin.push.core.ServiceManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class f extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f37865a = "NotiClickAct";

    @Override // com.igexin.push.a.b
    public final void a(Activity activity) {
    }

    @Override // com.igexin.push.a.b
    public final boolean a() {
        return false;
    }

    @Override // com.igexin.push.a.b
    public final void b(Activity activity) {
        try {
            Context applicationContext = activity.getApplicationContext();
            com.igexin.push.core.a.b.d();
            Intent intent = new Intent(activity, (Class<?>) com.igexin.push.core.a.b.a(applicationContext));
            Intent intent2 = activity.getIntent();
            if (intent2 != null && intent2.hasExtra("action") && intent2.hasExtra("broadcast_intent")) {
                intent.putExtra("action", intent2.getStringExtra("action"));
                intent.putExtra("broadcast_intent", (Intent) intent2.getParcelableExtra("broadcast_intent"));
            }
            ServiceManager.getInstance().b(applicationContext, intent);
            com.igexin.c.a.c.a.a(this.f37865a + "|GetuiActivity create " + intent.toString(), new Object[0]);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a(this.f37865a + "|put GetuiActivity exception" + th.toString(), new Object[0]);
        }
        activity.finish();
    }

    @Override // com.igexin.push.a.b
    public final boolean b() {
        return false;
    }

    @Override // com.igexin.push.a.b
    public final void c() {
    }

    @Override // com.igexin.push.a.b
    public final void d() {
    }

    @Override // com.igexin.push.a.b
    public final void e() {
    }

    @Override // com.igexin.push.a.b
    public final void f() {
    }

    @Override // com.igexin.push.a.b
    public final void g() {
    }

    @Override // com.igexin.push.a.b
    public final void h() {
    }

    @Override // com.igexin.push.a.b
    public final void i() {
    }

    @Override // com.igexin.push.a.b
    public final void j() {
    }

    @Override // com.igexin.push.a.b
    public final void k() {
    }
}
