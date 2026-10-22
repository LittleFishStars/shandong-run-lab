package com.beizi.fusion;

import android.content.Context;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.AdItemModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.NativeModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.AdTraceModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class tf extends uf {
    private hc.a A;
    private final a B;
    private uc C;
    private tc z;

    public class a implements qe {
        private a() {
        }

        @Override // com.beizi.fusion.ya
        public void a(pe peVar) {
        }

        @Override // com.beizi.fusion.qe
        public void g(xa xaVar) {
            tf.this.o.a(xaVar, tf.this.d, tf.this.n());
            uc ucVar = tf.this.C;
            if (ucVar != null) {
                ucVar.c();
            }
        }
    }

    public class b extends z0.a implements oe {
        private b() {
            super();
        }

        @Override // com.beizi.fusion.oe
        public void a(xa xaVar) {
            tc tcVar = tf.this.z;
            if (tcVar != null) {
                tcVar.h();
            }
        }

        @Override // com.beizi.fusion.oe
        public void b(xa xaVar) {
            tc tcVar = tf.this.z;
            if (tcVar != null) {
                tcVar.k();
            }
        }

        @Override // com.beizi.fusion.oe
        public void h(xa xaVar) {
            tc tcVar = tf.this.z;
            if (tcVar != null) {
                tcVar.i();
            }
        }

        @Override // com.beizi.fusion.oe
        public void k(xa xaVar) {
            tc tcVar = tf.this.z;
            if (tcVar != null) {
                tcVar.j();
            }
        }
    }

    public tf(Context context, AdItemModel adItemModel, ba baVar, AdTraceModel adTraceModel) {
        super(context, adItemModel, baVar, adTraceModel);
        this.B = new a();
    }

    @Override // com.beizi.fusion.z0
    public x9 m() {
        return new b();
    }

    public void s() {
        c3 c3Var = this.u;
        if (c3Var != null) {
            c3Var.a();
        }
    }

    public qe t() {
        return this.B;
    }

    public void a(tc tcVar) {
        this.z = tcVar;
    }

    public void a(uc ucVar) {
        this.C = ucVar;
    }

    @Override // com.beizi.fusion.z0
    public dc a(String str, int i, NativeModel nativeModel, String str2) {
        dc dcVarA = super.a(str, i, nativeModel, str2);
        if (dcVarA instanceof hc) {
            ((hc) dcVarA).a(this.A);
        }
        return dcVarA;
    }

    public void a(hc.a aVar) {
        this.A = aVar;
    }
}
