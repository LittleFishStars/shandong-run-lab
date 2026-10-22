package com.byazt.sgn;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.byazt.ete.ic;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 211, 71})
public class x extends AlertDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.xs.c f29019a;
    public JSONObject c;
    public String n;
    public com.byazt.ux.sp sp;
    public JSONObject tt;
    public sp.c uj;
    public Context ve;
    public boolean x;

    public x(String str, Context context, JSONObject jSONObject, JSONObject jSONObject2, com.byazt.ux.sp spVar, ic icVar) {
        super(context);
        this.sp = spVar;
        this.ve = context;
        this.c = jSONObject;
        this.n = str;
        this.tt = jSONObject2;
        this.f29019a = new com.byazt.xs.c(context, icVar);
    }

    private void tt() {
        if (this.c == null || this.tt == null || this.f29019a == null) {
            return;
        }
        this.x = false;
        final FrameLayout frameLayout = new FrameLayout(this.ve);
        this.f29019a.c(this.c, this.tt, new com.byazt.ux.sp() { // from class: com.byazt.sgn.x.1
            @Override // com.byazt.ux.sp
            public void c(int i, String str) {
                x.this.x = true;
                if (x.this.sp != null) {
                    FrameLayout frameLayout2 = frameLayout;
                    if (frameLayout2 != null) {
                        frameLayout2.removeAllViews();
                    }
                    x.this.sp.c(i, str);
                }
            }

            @Override // com.byazt.ux.sp
            public void c(com.byazt.xj.ve<View> veVar) {
                x.this.x = false;
                if (x.this.sp != null) {
                    x.this.sp.c(null);
                }
                frameLayout.addView(veVar.i(), new FrameLayout.LayoutParams(veVar.or(), veVar.cu()));
                x.this.setContentView(frameLayout);
            }
        });
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        sp.c cVar = this.uj;
        if (cVar != null) {
            cVar.ve(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.byazt.vfu.sp.tt(this);
        tt();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.x) {
            hide();
            dismiss();
        }
    }

    public String c() {
        return this.n;
    }

    public void c(sp.c cVar) {
        this.uj = cVar;
        com.byazt.xs.c cVar2 = this.f29019a;
        if (cVar2 != null) {
            cVar2.c(cVar);
        }
    }

    public void c(com.byazt.ux.sp spVar) {
        this.sp = spVar;
    }
}
