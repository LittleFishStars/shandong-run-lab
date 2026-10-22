package com.beizi.fusion;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeExpressContainer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class b6 extends ca {
    protected String o;
    protected final a p;
    protected View q;
    protected pd r;
    private final b s;

    public static final class b extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private y9 f27094a;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(y9 y9Var) {
            this.f27094a = y9Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context != null) {
                fh.a(context.getApplicationContext()).a(this);
            }
            y9 y9Var = this.f27094a;
            if (y9Var != null) {
                n1 n1Var = n1.ERROR_ACTIVITY_ISSUE;
                y9Var.a(n1Var.b(), n1Var.c());
            }
        }
    }

    public b6(Context context, ba baVar, d dVar) {
        super(context, baVar, dVar);
        this.p = j();
        this.s = new b();
    }

    private void c(Context context) {
        if (context != null) {
            fh.a(context.getApplicationContext()).a(this.s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.d = true;
    }

    public abstract pd b(rd rdVar);

    public void b(Map map) {
        pd pdVar = this.r;
        if (pdVar == null || pdVar.f() == null) {
            return;
        }
        this.r.f().a(map);
    }

    public void i() {
        y9 y9Var = (y9) c();
        if (y9Var != null) {
            y9Var.onAdLoaded();
        }
    }

    public abstract a j();

    public void k() {
        this.d = false;
        pd pdVar = this.r;
        if (pdVar != null) {
            pdVar.b();
        }
        View view = this.q;
        if (view == null || !(view instanceof ScopeExpressContainer)) {
            return;
        }
        ((ScopeExpressContainer) view).onViewDestroy();
    }

    public Map l() {
        pd pdVar = this.r;
        return pdVar != null ? pdVar.e() : Collections.EMPTY_MAP;
    }

    public int m() {
        pd pdVar = this.r;
        if (pdVar == null || pdVar.f() == null) {
            return 0;
        }
        return this.r.f().getECPM();
    }

    public boolean n() {
        pd pdVar = this.r;
        if (pdVar != null) {
            return pdVar.j();
        }
        return false;
    }

    @Override // com.beizi.fusion.ca
    public void a(List list) {
        rd rdVar = (rd) list.get(0);
        if (rdVar != null) {
            this.r = b(rdVar);
            i();
            a(rdVar);
        }
    }

    public void b(n1 n1Var) {
        y9 y9Var = (y9) c();
        if (y9Var != null) {
            y9Var.a(n1Var.b(), n1Var.c());
        }
    }

    public class a implements sd, td, ud, vd {
        public a() {
        }

        @Override // com.beizi.fusion.vd
        public void a(int i) {
        }

        @Override // com.beizi.fusion.ud
        public void a(View view) {
            b6.this.o();
            if (l()) {
                b6.this.q = view;
            }
            y9 y9Var = (y9) b6.this.c();
            if (y9Var != null) {
                y9Var.e();
            }
        }

        @Override // com.beizi.fusion.sd
        public void b() {
            y9 y9Var = (y9) b6.this.c();
            if (y9Var != null) {
                y9Var.b();
            }
        }

        @Override // com.beizi.fusion.vd
        public void d() {
            y9 y9Var = (y9) b6.this.c();
            if (y9Var instanceof te) {
                ((te) y9Var).f();
            }
        }

        @Override // com.beizi.fusion.vd
        public void e() {
        }

        @Override // com.beizi.fusion.ud
        public void f() {
            b6.this.b(n1.ERROR_RENDER_FAILED);
        }

        @Override // com.beizi.fusion.vd
        public void g() {
            View view = b6.this.q;
            if (view != null) {
                ScopeExpressContainer.d.a(view);
            }
            y9 y9Var = (y9) b6.this.c();
            if (y9Var instanceof te) {
                ((te) y9Var).d();
            }
        }

        public abstract boolean l();

        @Override // com.beizi.fusion.td
        public void onAdClicked() {
            y9 y9Var = (y9) b6.this.c();
            b6 b6Var = b6.this;
            if (b6Var.f27135a == d.SPLASH) {
                b6Var.a(System.currentTimeMillis());
            }
            if (y9Var != null) {
                y9Var.onAdClicked();
            }
        }

        @Override // com.beizi.fusion.sd
        public void onAdClosed() {
            y9 y9Var = (y9) b6.this.c();
            if (y9Var != null) {
                y9Var.onAdClosed();
            }
        }

        @Override // com.beizi.fusion.sd
        public void onAdShown() {
            y9 y9Var = (y9) b6.this.c();
            if (y9Var != null) {
                y9Var.onAdShown();
            }
        }

        @Override // com.beizi.fusion.vd
        public void a() {
            y9 y9Var = (y9) b6.this.c();
            if (y9Var instanceof te) {
                ((te) y9Var).a();
            }
        }
    }

    public void b(Context context) {
        if (!b()) {
            a(context);
            if (wf.a(context, this.c.g(), this.f27135a, this.o)) {
                return;
            }
            c(context);
            return;
        }
        b(n1.ERROR_UNITE_CONTROL);
    }

    @Override // com.beizi.fusion.ca
    public void a(y9 y9Var) {
        super.a((ea) y9Var);
        this.s.a(y9Var);
    }

    public void a(rd rdVar) {
        this.r.a((td) this.p);
        this.r.a((sd) this.p);
        this.r.a((vd) this.p);
        this.r.a((ud) this.p);
    }

    public void a(Map map) {
        pd pdVar = this.r;
        if (pdVar == null || pdVar.f() == null) {
            return;
        }
        this.r.f().b(map);
    }

    public View a(boolean z) {
        View view = this.q;
        if (view == null || !z) {
            return view;
        }
        a(view);
        return null;
    }

    private void a(View view) {
        com.beizi.fusion.a aVar = this.e;
        if (aVar != null) {
            this.o = aVar.a(this.c, view);
        }
    }

    private void a(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.asnp.ad.ACTION_ACTIVITY_RESULT");
        if (context != null) {
            fh.a(context.getApplicationContext()).a(this.s, intentFilter);
        }
    }
}
