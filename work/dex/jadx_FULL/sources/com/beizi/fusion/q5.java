package com.beizi.fusion;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class q5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private sa f27678a;
    private cm c;
    private String d;
    private byte[] e;
    private File g;
    private final m5 b = m5.a();
    private boolean f = true;

    public q5 a(byte[] bArr) {
        this.e = bArr;
        return this;
    }

    public void b(String str) {
        this.c = cm.GET;
        this.d = str;
    }

    public void c(String str) {
        this.c = cm.POST;
        this.d = str;
    }

    public void d(String str) {
        this.c = cm.STREAM;
        this.d = str;
    }

    public q5 a(boolean z) {
        this.f = z;
        return this;
    }

    public void a(String str, String str2) {
        this.b.put(str, str2);
    }

    public void a(String str, File file) {
        this.c = cm.DOWNLOAD;
        this.d = str;
        this.g = file;
    }

    public void a(String str) {
        this.c = cm.CACHE_IMAGE;
        this.d = str;
    }

    public q5 a(sa saVar) {
        this.f27678a = saVar;
        return this;
    }

    public void a(Context context) {
        fb fbVar = (fb) cn.a().b(context);
        qa qaVarA = j9.a(new k9(this.d, this.c, this.e, this.b, this.f), this.f27678a);
        if (qaVarA != null) {
            if (qaVarA instanceof gh) {
                ((gh) qaVarA).a(this.g);
            }
            fbVar.b(qaVarA);
            return;
        }
        a(ui.a.ERROR_METHOD);
    }

    public qa a() {
        qa qaVarA = j9.a(new k9(this.d, this.c, this.e, this.b, this.f), this.f27678a);
        if (qaVarA instanceof gh) {
            ((gh) qaVarA).a(this.g);
        }
        return qaVarA;
    }

    private void a(nc ncVar) {
        sa saVar = this.f27678a;
        if (saVar != null) {
            saVar.a(ncVar);
        }
    }
}
