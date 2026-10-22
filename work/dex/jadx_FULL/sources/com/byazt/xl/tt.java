package com.byazt.xl;

import android.content.Context;
import android.view.View;
import com.byazt.xv.ThemeStatusBroadcastReceiver;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1459, 13})
public class tt implements da {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f29185a;
    public Context c;
    public u n;
    public com.byazt.mt.c tt;
    public x uj;
    public ThemeStatusBroadcastReceiver ve;

    public tt(Context context, u uVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.byazt.du.x xVar, x xVar2, com.byazt.wl.c cVar) {
        this(context, uVar, themeStatusBroadcastReceiver, z, xVar, xVar2, cVar, null);
    }

    public tt(Context context, u uVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.byazt.du.x xVar, x xVar2, com.byazt.wl.c cVar, com.byazt.mt.c cVar2) {
        this.c = context;
        this.n = uVar;
        this.ve = themeStatusBroadcastReceiver;
        this.uj = xVar2;
        if (cVar2 != null) {
            this.tt = cVar2;
        } else {
            this.tt = new com.byazt.mt.c(context, themeStatusBroadcastReceiver, z, xVar, uVar, cVar);
        }
        this.tt.c(this.uj);
        if (xVar instanceof com.byazt.du.sp) {
            this.f29185a = 3;
        } else {
            this.f29185a = 2;
        }
    }

    public void c(boolean z) {
        this.tt.tt(z);
    }

    public com.byazt.kn.uj tt() {
        com.byazt.mt.c cVar = this.tt;
        if (cVar != null) {
            return cVar.a();
        }
        return null;
    }

    @Override // com.byazt.xl.da
    public boolean c(final da.c cVar) {
        this.n.sp().c(this.f29185a);
        this.tt.c(new sp() { // from class: com.byazt.xl.tt.1
            @Override // com.byazt.xl.sp
            public void c(View view, yp ypVar) {
                if (cVar.ve()) {
                    return;
                }
                tt.this.n.sp().n(tt.this.f29185a);
                tt.this.n.sp().a(tt.this.f29185a);
                tt.this.n.sp().u();
                z zVarTt = cVar.tt();
                if (zVarTt == null) {
                    return;
                }
                zVarTt.c(tt.this.tt, ypVar);
                cVar.c(true);
            }

            @Override // com.byazt.xl.sp
            public void c(int i, String str) {
                tt.this.n.sp().c(tt.this.f29185a, i, str, cVar.tt(tt.this));
                if (cVar.tt(tt.this)) {
                    cVar.c(tt.this);
                    return;
                }
                z zVarTt = cVar.tt();
                if (zVarTt == null) {
                    return;
                }
                zVarTt.a_(i);
            }
        });
        return true;
    }

    @Override // com.byazt.xl.da
    public void c() {
        com.byazt.mt.c cVar = this.tt;
        if (cVar != null) {
            cVar.tt();
        }
    }
}
