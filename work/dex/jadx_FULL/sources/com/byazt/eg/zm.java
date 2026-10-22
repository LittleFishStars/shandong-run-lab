package com.byazt.eg;

import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 16, 482})
public final class zm implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28467a;
    public final gu c;
    public m n;
    public final com.byazt.yx.da tt;
    public final boolean uj;
    public final yv ve;

    @com.byazt.zqa.c(c = {0, 1, 16, 21})
    public final class c extends com.byazt.kh.tt {
        public final a ve;

        public c(a aVar) {
            super("OkHttp %s", zm.this.x());
            this.ve = aVar;
        }

        public String c() {
            return zm.this.ve.c().sp();
        }

        public void tt() {
            md mdVar;
            yv yvVar = zm.this.ve;
            if (yvVar == null || (mdVar = yvVar.f28464a) == null) {
                return;
            }
            mdVar.sl();
        }

        @Override // com.byazt.kh.tt
        public void ve() {
            md mdVar;
            boolean z = false;
            try {
                try {
                    try {
                        yv yvVar = zm.this.ve;
                        if (yvVar != null && (mdVar = yvVar.f28464a) != null) {
                            mdVar.c();
                        }
                        h hVarI = zm.this.i();
                        try {
                            if (zm.this.tt.tt()) {
                                this.ve.c(zm.this, new IOException("Canceled"));
                            } else {
                                this.ve.c(zm.this, hVarI);
                            }
                            if (hVarI.ve == 0) {
                                throw new IOException(hVarI.uj);
                            }
                        } catch (IOException e) {
                            e = e;
                            z = true;
                            if (z) {
                                com.byazt.xb.n.tt().c(4, "Callback failure for " + zm.this.sp(), e);
                            } else {
                                zm.this.n.c(zm.this, e);
                                this.ve.c(zm.this, e);
                            }
                        }
                    } catch (Throwable th) {
                        zm.this.c.my().tt(this);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                zm.this.n.c(zm.this, new IOException(e3));
                this.ve.c(zm.this, new IOException(e3));
            }
            zm.this.c.my().tt(this);
        }
    }

    private zm(gu guVar, yv yvVar, boolean z) {
        this.c = guVar;
        this.ve = yvVar;
        this.uj = z;
        this.tt = new com.byazt.yx.da(guVar, z);
    }

    private void da() {
        this.tt.c(com.byazt.xb.n.tt().c("response.body().close()"));
    }

    @Override // com.byazt.eg.n
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public zm n() {
        return c(this.c, this.ve, this.uj);
    }

    public h i() throws IOException {
        ArrayList arrayList = new ArrayList(this.c.qy());
        arrayList.add(this.tt);
        arrayList.add(new com.byazt.yx.c(this.c.a()));
        arrayList.add(new com.byazt.umr.c(this.c.sp()));
        arrayList.add(new com.byazt.iq.c(this.c));
        if (!this.uj) {
            arrayList.addAll(this.c.gu());
        }
        arrayList.add(new com.byazt.yx.tt(this.uj));
        return new com.byazt.yx.sp(arrayList, null, null, null, 0, this.ve, this, this.n, this.c.c(), this.c.tt(), this.c.ve()).c(this.ve);
    }

    public String sp() {
        StringBuilder sb = new StringBuilder();
        sb.append(uj() ? "canceled " : "");
        sb.append(this.uj ? "web socket" : "call");
        sb.append(" to ");
        sb.append(x());
        return sb.toString();
    }

    @Override // com.byazt.eg.n
    public h tt() throws IOException {
        synchronized (this) {
            if (this.f28467a) {
                throw new IllegalStateException("Already Executed");
            }
            this.f28467a = true;
        }
        da();
        try {
            try {
                md mdVar = this.ve.f28464a;
                if (mdVar != null) {
                    mdVar.c();
                }
                this.c.my().c(this);
                h hVarI = i();
                if (hVarI == null) {
                    throw new IOException("Canceled");
                }
                if (hVarI.ve == 0) {
                    throw new IOException(hVarI.uj);
                }
                this.c.my().tt(this);
                return hVarI;
            } catch (IOException e) {
                this.n.c(this, e);
                this.c.my().tt(this);
                return null;
            } catch (Exception e2) {
                this.n.c(this, new IOException(e2));
                this.c.my().tt(this);
                return null;
            }
        } catch (Throwable th) {
            this.c.my().tt(this);
            throw th;
        }
    }

    @Override // com.byazt.eg.n
    public boolean uj() {
        return this.tt.tt();
    }

    @Override // com.byazt.eg.n
    public void ve() {
        this.tt.c();
    }

    public String x() {
        return this.ve.c().u();
    }

    public static zm c(gu guVar, yv yvVar, boolean z) {
        zm zmVar = new zm(guVar, yvVar, z);
        zmVar.n = guVar.gr().c(zmVar);
        return zmVar;
    }

    @Override // com.byazt.eg.n
    public yv c() {
        return this.ve;
    }

    @Override // com.byazt.eg.n
    public void c(a aVar) {
        try {
            synchronized (this) {
                if (!this.f28467a) {
                    this.f28467a = true;
                } else {
                    throw new IllegalStateException("Already Executed");
                }
            }
            da();
            this.c.my().c(new c(aVar));
        } catch (Throwable th) {
            if (aVar != null) {
                aVar.c(this, new IOException(th.getMessage()));
            }
        }
    }
}
