package com.amap.api.col.p0003l;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class hn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f25969a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public hs f926a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public u f927a;
    public long b;

    public interface a {
        void onDownload(byte[] bArr, long j);

        void onException(Throwable th);

        void onFinish();

        void onStop();
    }

    public hn(hs hsVar) {
        this(hsVar, (byte) 0);
    }

    public final void a() {
        u uVar = this.f927a;
        if (uVar != null) {
            uVar.j();
        }
    }

    public final void b(a aVar) {
        try {
            u uVar = new u();
            this.f927a = uVar;
            uVar.t(this.b);
            this.f927a.k(this.f25969a);
            hl.b();
            if (hl.b(this.f926a)) {
                this.f926a.setDegradeType(hs.b.NEVER_GRADE);
                this.f927a.l(this.f926a, aVar);
            } else {
                this.f926a.setDegradeType(hs.b.DEGRADE_ONLY);
                this.f927a.l(this.f926a, aVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public hn(hs hsVar, byte b) {
        this(hsVar, 0L, -1L, false);
    }

    public hn(hs hsVar, long j, long j2, boolean z) {
        this.f926a = hsVar;
        this.f25969a = j;
        this.b = j2;
        hsVar.setHttpProtocol(z ? hs.c.HTTPS : hs.c.HTTP);
        this.f926a.setDegradeAbility(hs.a.SINGLE);
    }
}
