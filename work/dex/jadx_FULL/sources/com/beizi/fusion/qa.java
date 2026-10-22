package com.beizi.fusion;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class qa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected ke f27685a;
    protected boolean b;
    protected sa c;
    private final Set d = new HashSet();

    public qa(ke keVar, sa saVar) {
        this.f27685a = keVar;
        this.b = keVar.d();
        this.c = saVar;
    }

    private void a(int i, String str) {
    }

    public void a(nc ncVar) {
        this.d.clear();
        sa saVar = this.c;
        if (saVar != null) {
            saVar.a(ncVar);
        }
    }

    public void a(int i, InputStream inputStream) {
        this.d.clear();
        sa saVar = this.c;
        if (saVar != null) {
            saVar.a(i, inputStream);
        }
    }

    public void a(String str) {
        this.d.add(str);
    }

    public void a(String str, int i) {
        if (this.b) {
            if (this.d.contains(str)) {
                a(ui.a.ERROR_REDIRECT_LOOP);
                return;
            } else {
                this.f27685a = new k9(str, this.f27685a);
                run();
                return;
            }
        }
        a(i, str);
    }
}
