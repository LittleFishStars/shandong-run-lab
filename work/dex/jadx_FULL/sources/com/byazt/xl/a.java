package com.byazt.xl;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1459, 34})
public class a implements da {
    public Context c;
    public c tt;
    public u ve;

    public a(Context context, u uVar, c cVar) {
        this.c = context;
        this.tt = cVar;
        this.ve = uVar;
    }

    @Override // com.byazt.xl.da
    public void c() {
    }

    @Override // com.byazt.xl.da
    public boolean c(final da.c cVar) {
        this.ve.sp().i();
        this.tt.c(new sp() { // from class: com.byazt.xl.a.1
            @Override // com.byazt.xl.sp
            public void c(View view, yp ypVar) {
                if (cVar.ve()) {
                    return;
                }
                z zVarTt = cVar.tt();
                if (zVarTt != null) {
                    zVarTt.c(a.this.tt, ypVar);
                }
                cVar.c(true);
            }

            @Override // com.byazt.xl.sp
            public void c(int i, String str) {
                z zVarTt = cVar.tt();
                if (zVarTt != null) {
                    zVarTt.a_(i);
                }
            }
        });
        return true;
    }

    public void c(ve veVar) {
        this.tt.c(veVar);
    }
}
