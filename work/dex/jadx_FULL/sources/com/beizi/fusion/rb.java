package com.beizi.fusion;

import android.content.Context;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class rb extends da implements mb {
    protected final b6 d;

    public rb(Context context, ba baVar) {
        super(context, baVar);
        this.d = (b6) super.a();
    }

    public void a(Context context) {
        if (context == null || !this.d.f()) {
            return;
        }
        this.d.a(true);
        this.d.b(context);
    }

    @Override // com.beizi.fusion.mb
    public void b(Map map) {
        b6 b6Var = this.d;
        if (b6Var != null) {
            b6Var.a(map);
        }
    }

    public void d() {
        b6 b6Var = this.d;
        if (b6Var != null) {
            b6Var.k();
        }
    }

    public Map e() {
        b6 b6Var = this.d;
        return b6Var != null ? b6Var.l() : Collections.EMPTY_MAP;
    }

    public boolean f() {
        b6 b6Var = this.d;
        return b6Var != null && b6Var.n();
    }

    @Override // com.beizi.fusion.mb
    public int getECPM() {
        b6 b6Var = this.d;
        if (b6Var != null) {
            return b6Var.m();
        }
        return 0;
    }

    @Override // com.beizi.fusion.mb
    public void a(Map map) {
        b6 b6Var = this.d;
        if (b6Var != null) {
            b6Var.b(map);
        }
    }
}
