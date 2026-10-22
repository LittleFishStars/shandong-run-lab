package com.beizi.fusion;

import android.content.Context;
import android.os.Handler;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class yi extends k3 {
    private ki P;
    private String Q;
    private mi R;

    public class a implements oi {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ oi f28066a;

        public a(oi oiVar) {
            this.f28066a = oiVar;
        }

        @Override // com.beizi.fusion.oi
        public void onAdShown() {
            if (yi.this.t) {
                yi.this.u = true;
                u3.b().a(yi.this.r);
            }
            oi oiVar = this.f28066a;
            if (oiVar != null) {
                oiVar.onAdShown();
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f28067a;

        public b(int i) {
            this.f28067a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ki kiVar = yi.this.P;
            if (kiVar != null) {
                kiVar.onAdFailed(this.f28067a);
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ki kiVar = yi.this.P;
            if (kiVar != null) {
                kiVar.onAdFailed(3);
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            yi yiVar = yi.this;
            ki kiVar = yiVar.P;
            if (kiVar != null) {
                kiVar.a(yiVar.R);
            }
        }
    }

    public yi(Context context, String str, int i) {
        super(context, str, th.NATIVE);
    }

    public void g(String str) {
        this.Q = str;
    }

    @Override // com.beizi.fusion.k3
    public String s() {
        return this.Q;
    }

    public void a(ki kiVar) {
        this.P = kiVar;
    }

    public void a(View view, oi oiVar) {
        mi miVar = this.R;
        if (miVar == null || view == null || oiVar == null) {
            return;
        }
        miVar.a(view, new a(oiVar));
    }

    @Override // com.beizi.fusion.k3
    public void a(int i) {
        if (this.P == null || this.j || this.g) {
            return;
        }
        this.j = true;
        Handler handler = this.J;
        if (handler != null) {
            handler.post(new b(i));
        }
    }

    @Override // com.beizi.fusion.k3
    public void a(on onVar) {
        mi miVarO = onVar.O();
        this.R = miVarO;
        if (miVarO == null) {
            Handler handler = this.J;
            if (handler != null) {
                handler.post(new c());
                return;
            }
            return;
        }
        e(onVar.U());
        a(onVar.c());
        b(onVar.i0());
        g(this.R.c());
        ((c4) this.R).e(this.t);
        ((c4) this.R).e(this.l);
        Handler handler2 = this.J;
        if (handler2 != null) {
            handler2.post(new d());
        }
    }
}
