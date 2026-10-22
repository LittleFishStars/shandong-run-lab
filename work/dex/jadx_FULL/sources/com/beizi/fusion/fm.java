package com.beizi.fusion;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class fm extends wo {

    public static class a extends wo.a implements uc {
        private uc e;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(uc ucVar) {
            this.e = ucVar;
        }

        @Override // com.beizi.fusion.uc
        public void c() {
            uc ucVar = this.e;
            if (ucVar != null) {
                ucVar.c();
            }
        }
    }

    public fm(rd rdVar) {
        super(rdVar);
    }

    public void a(hc.a aVar) {
        ib ibVar = this.f26990a;
        if (ibVar instanceof tf) {
            ((tf) ibVar).a(aVar);
        }
    }

    @Override // com.beizi.fusion.wo
    public wo.a l() {
        return new a();
    }

    public void m() {
        ib ibVar = this.f26990a;
        if (ibVar instanceof tf) {
            ((tf) ibVar).s();
        }
    }

    public qe n() {
        ib ibVar = this.f26990a;
        if (ibVar instanceof tf) {
            return ((tf) ibVar).t();
        }
        return null;
    }

    public void a(tc tcVar) {
        ib ibVar = this.f26990a;
        if (ibVar instanceof tf) {
            ((tf) ibVar).a(tcVar);
        }
    }

    public void a(uc ucVar) {
        if (this.f26990a instanceof tf) {
            wo.a aVar = this.b;
            if (aVar instanceof a) {
                ((a) aVar).a(ucVar);
                ((tf) this.f26990a).a((uc) this.b);
            }
        }
    }
}
