package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Bundle;
import com.zj.adlib.aoa;
import com.zj.adlib.zwa;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class c extends it implements bs.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f25899a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bundle f753a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public bs f754a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public bu f755a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public bx f756a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f757a;

    public c(bx bxVar, Context context) {
        this.f753a = new Bundle();
        this.f757a = false;
        this.f756a = bxVar;
        this.f25899a = context;
    }

    public final void a() {
        this.f757a = true;
        bs bsVar = this.f754a;
        if (bsVar != null) {
            bsVar.d();
        } else {
            cancelTask();
        }
        bu buVar = this.f755a;
        if (buVar != null) {
            buVar.b();
        }
    }

    public final void b() {
        Bundle bundle = this.f753a;
        if (bundle != null) {
            bundle.clear();
            this.f753a = null;
        }
    }

    @Override // com.amap.api.col.3l.bs.a
    public final void c() {
        bu buVar = this.f755a;
        if (buVar != null) {
            buVar.h();
        }
    }

    public final String d() {
        return zwa.f0(this.f25899a);
    }

    public final void e() throws IOException {
        bs bsVar = new bs(new aoa(this.f756a.getUrl(), d(), this.f756a.v(), this.f756a.w()), this.f756a.getUrl(), this.f25899a, this.f756a);
        this.f754a = bsVar;
        bsVar.c(this);
        bx bxVar = this.f756a;
        this.f755a = new bu(bxVar, bxVar);
        if (this.f757a) {
            return;
        }
        this.f754a.a();
    }

    @Override // com.amap.api.col.p0003l.it
    public final void runTask() {
        if (this.f756a.u()) {
            this.f756a.a(by.a.file_io_exception);
            return;
        }
        try {
            e();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public c(bx bxVar, Context context, byte b) {
        this(bxVar, context);
    }
}
