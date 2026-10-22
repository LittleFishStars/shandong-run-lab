package com.beizi.fusion;

import android.content.Context;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.AdItemModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.AdTraceModel;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class a1 implements jb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final ib f26990a;

    public static class a implements ef, ad, wd {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private sd f26991a;
        private td b;
        private vd c;

        public void a(sd sdVar) {
            this.f26991a = sdVar;
        }

        @Override // com.beizi.fusion.ec
        public void b() {
            sd sdVar = this.f26991a;
            if (sdVar != null) {
                sdVar.b();
            }
        }

        @Override // com.beizi.fusion.ef
        public void d() {
            vd vdVar = this.c;
            if (vdVar != null) {
                vdVar.d();
            }
        }

        @Override // com.beizi.fusion.ef
        public void e() {
            vd vdVar = this.c;
            if (vdVar != null) {
                vdVar.e();
            }
        }

        @Override // com.beizi.fusion.ad
        public void f() {
        }

        @Override // com.beizi.fusion.ef
        public void g() {
            vd vdVar = this.c;
            if (vdVar != null) {
                vdVar.g();
            }
        }

        @Override // com.beizi.fusion.ad
        public void onAdClicked() {
            td tdVar = this.b;
            if (tdVar != null) {
                tdVar.onAdClicked();
            }
        }

        @Override // com.beizi.fusion.ec
        public void onAdClosed() {
            sd sdVar = this.f26991a;
            if (sdVar != null) {
                sdVar.onAdClosed();
            }
        }

        @Override // com.beizi.fusion.ec
        public void onAdShown() {
            sd sdVar = this.f26991a;
            if (sdVar != null) {
                sdVar.onAdShown();
            }
        }

        public void a(td tdVar) {
            this.b = tdVar;
        }

        public void a(vd vdVar) {
            this.c = vdVar;
        }

        @Override // com.beizi.fusion.ef
        public void a() {
            vd vdVar = this.c;
            if (vdVar != null) {
                vdVar.a();
            }
        }

        @Override // com.beizi.fusion.ef
        public void a(int i) {
            vd vdVar = this.c;
            if (vdVar != null) {
                vdVar.a(i);
            }
        }

        @Override // com.beizi.fusion.wd
        public void a(String str) {
            if (this.f26991a != null) {
                throw null;
            }
        }
    }

    public a1(Context context, AdItemModel adItemModel, ba baVar, AdTraceModel adTraceModel) {
        this.f26990a = a(context, adItemModel, baVar, adTraceModel);
    }

    public abstract ib a(Context context, AdItemModel adItemModel, ba baVar, AdTraceModel adTraceModel);

    @Override // com.beizi.fusion.jb
    public void b() {
        ib ibVar = this.f26990a;
        if (ibVar != null) {
            ibVar.b();
        }
    }

    @Override // com.beizi.fusion.jb
    public Map e() {
        ib ibVar = this.f26990a;
        return ibVar != null ? ibVar.e() : Collections.EMPTY_MAP;
    }

    @Override // com.beizi.fusion.jb
    public mb f() {
        return this.f26990a.f();
    }

    @Override // com.beizi.fusion.jb
    public boolean j() {
        ib ibVar = this.f26990a;
        return ibVar != null && ibVar.j();
    }

    public final void k() {
        ib ibVar = this.f26990a;
        if (ibVar instanceof z0) {
            ((z0) ibVar).p();
        }
    }
}
