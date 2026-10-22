package com.kc.cw.ad.internal.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.kc.cw.ad.IBidding;
import com.kc.cw.ad.NativeAdListener;
import com.kc.cw.ad.NativeAdResponse;
import com.kc.cw.ad.internal.c.j;
import com.kc.cw.ad.internal.c.m;
import com.kc.cw.ad.internal.c.s;
import com.kc.cw.ad.internal.l;
import com.kc.cw.ad.internal.o;
import com.kc.cw.ad.internal.p;
import com.kc.cw.ad.internal.q;
import com.kc.cw.ad.utils.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c extends com.kc.cw.ad.internal.b.a implements IBidding, com.kc.cw.ad.internal.a {
    public com.kc.cw.ad.internal.c b;
    private NativeAdListener c;
    private a d;
    private boolean e;
    private boolean f;
    private Context g;
    private com.kc.cw.ad.internal.d h;
    private int i;
    private String j;
    private final String k;
    private String l;
    private long m;
    private long n;
    private boolean o = false;
    private boolean p = false;

    @Keep
    public class a implements com.kc.cw.ad.internal.b, j.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        j f38870a;
        NativeAdResponse b;
        final c c;

        private a(c cVar) {
            this.c = cVar;
        }

        @Override // com.kc.cw.ad.internal.b
        public void a() {
            NativeAdResponse nativeAdResponse = this.b;
            if (nativeAdResponse != null) {
                nativeAdResponse.destroy();
                this.b = null;
            }
        }

        /* JADX WARN: Failed to analyze thrown exceptions
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
        	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:130)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
        	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
         */
        @Override // com.kc.cw.ad.internal.b
        public void a(int i) {
            ThreadUtils.runOnUIThread(new Runnable(this, i) { // from class: com.kc.cw.ad.internal.b.c.a.3

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final int f38873a;
                final a b;

                {
                    this.b = this;
                    this.f38873a = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.b.c.c != null) {
                        this.b.c.c.onAdFailed(this.f38873a);
                    }
                }
            });
            this.c.p = false;
        }

        @Override // com.kc.cw.ad.internal.b
        public void a(long j) {
        }

        @Override // com.kc.cw.ad.internal.b
        public void a(b bVar) {
            if (!bVar.a().equals(p.NATIVE) && !bVar.a().equals(p.BANNER) && !bVar.a().equals(p.DRAW)) {
                a(80103);
                return;
            }
            NativeAdResponse nativeAdResponseB = bVar.b();
            if (nativeAdResponseB == null) {
                return;
            }
            this.b = nativeAdResponseB;
            e eVar = (e) nativeAdResponseB;
            eVar.a(this.c);
            eVar.a(this.c.i());
            eVar.a(this.c.g);
            if (this.c.h.l()) {
                eVar.h();
                return;
            }
            if (eVar.a() == 1) {
                a(80100);
                eVar.g();
                if (eVar.i()) {
                    return;
                }
                com.kc.cw.ad.internal.b.a.b(eVar.b());
                return;
            }
            this.c.o = true;
            this.c.n = System.currentTimeMillis();
            this.c.a(bVar.c());
            this.c.d(bVar.d());
            this.c.a(bVar.e());
            this.c.g(nativeAdResponseB.getLandingPageUrl());
            eVar.a(this.c.n, this.c.m);
            if (!this.c.e && !this.c.f) {
                if (this.c.c != null) {
                    this.c.c.onAdLoaded(nativeAdResponseB);
                }
                this.c.p = false;
                return;
            }
            this.f38870a = new j();
            if (this.c.e) {
                this.f38870a.a(new j.b(this, nativeAdResponseB) { // from class: com.kc.cw.ad.internal.b.c.a.1

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final NativeAdResponse f38871a;
                    final a b;

                    {
                        this.b = this;
                        this.f38871a = nativeAdResponseB;
                    }

                    @Override // com.kc.cw.ad.internal.c.j.b
                    public void a() {
                        com.kc.cw.ad.internal.c.f.e(com.kc.cw.ad.internal.c.f.e, "Image downloading logFailed for url " + this.f38871a.getImageUrl());
                    }

                    @Override // com.kc.cw.ad.internal.c.j.b
                    public void a(Bitmap bitmap) {
                        this.f38871a.setImage(bitmap);
                    }
                }, nativeAdResponseB.getImageUrl());
            }
            if (this.c.f) {
                this.f38870a.a(new j.b(this, nativeAdResponseB) { // from class: com.kc.cw.ad.internal.b.c.a.2

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final NativeAdResponse f38872a;
                    final a b;

                    {
                        this.b = this;
                        this.f38872a = nativeAdResponseB;
                    }

                    @Override // com.kc.cw.ad.internal.c.j.b
                    public void a() {
                        com.kc.cw.ad.internal.c.f.e(com.kc.cw.ad.internal.c.f.e, "Image downloading logFailed for url " + this.f38872a.getIconUrl());
                    }

                    @Override // com.kc.cw.ad.internal.c.j.b
                    public void a(Bitmap bitmap) {
                        this.f38872a.setIcon(bitmap);
                    }
                }, nativeAdResponseB.getIconUrl());
            }
            this.f38870a.a(this);
            this.f38870a.a();
        }

        @Override // com.kc.cw.ad.internal.b
        public void a(com.kc.cw.ad.internal.e.c cVar) {
        }

        @Override // com.kc.cw.ad.internal.b
        public void a(boolean z) {
        }

        @Override // com.kc.cw.ad.internal.b
        public void b() {
        }

        @Override // com.kc.cw.ad.internal.b
        public void c() {
        }

        @Override // com.kc.cw.ad.internal.b
        public void d() {
        }

        @Override // com.kc.cw.ad.internal.c.j.c
        public void e() {
            if (this.c.c != null) {
                this.c.c.onAdLoaded(this.b);
            }
            this.f38870a = null;
            this.b = null;
            this.c.p = false;
        }
    }

    public c(Context context, String str, p pVar, String str2) {
        this.g = context;
        this.k = str2;
        com.kc.cw.ad.internal.c.b.a(context.getApplicationContext());
        s.a(context.getApplicationContext());
        m.a(context.getApplicationContext());
        com.kc.cw.ad.internal.d dVar = new com.kc.cw.ad.internal.d(context, com.kc.cw.ad.internal.c.p.a());
        this.h = dVar;
        dVar.b(str);
        this.h.a(1);
        this.h.a(pVar);
        com.kc.cw.ad.internal.c cVar = new com.kc.cw.ad.internal.c(this);
        this.b = cVar;
        cVar.a(-1, str2);
        this.d = new a();
    }

    public void a(int i) {
        this.i = i;
    }

    public void a(long j) {
        q.x = j;
        this.m = j;
    }

    public void a(NativeAdListener nativeAdListener) {
        this.c = nativeAdListener;
    }

    public void a(boolean z) {
        this.h.c(z);
    }

    @Override // com.kc.cw.ad.internal.a
    public boolean a() {
        return this.h.q();
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:130)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
     */
    public boolean a(com.kc.cw.ad.internal.b.a.C1001a c1001a) {
        if (this.p) {
            com.kc.cw.ad.internal.c.f.e(com.kc.cw.ad.internal.c.f.l, "Still loading last nativead ad , won't load a new ad");
            return false;
        }
        k();
        if (!this.h.q()) {
            a aVar = this.d;
            if (aVar != null) {
                aVar.a(80000);
            }
            return false;
        }
        this.b.a();
        this.b.c();
        this.b.a(this.k);
        this.p = true;
        return true;
    }

    public void b(boolean z) {
        a(z);
    }

    public void c(String str) {
        this.h.b(str);
    }

    public boolean c() {
        return this.h.o();
    }

    public String d() {
        return this.h.c();
    }

    public void d(String str) {
        this.j = str;
    }

    public int e() {
        return this.i;
    }

    public void e(String str) {
        this.h.c(str);
    }

    public String f() {
        return this.j;
    }

    public void f(String str) {
        this.h.d(str);
    }

    public void g(String str) {
        this.l = str;
    }

    public boolean g() {
        return this.o;
    }

    @Override // com.kc.cw.ad.internal.a
    public p getMediaType() {
        return this.h.p();
    }

    public boolean h() {
        return System.currentTimeMillis() - this.n < this.m;
    }

    public String i() {
        return !TextUtils.isEmpty(this.h.f()) ? this.h.f() : this.h.a();
    }

    public com.kc.cw.ad.internal.d j() {
        return this.h;
    }

    public void k() {
        o.a(new l("LOAD", d(), i()));
    }

    public com.kc.cw.ad.internal.b l() {
        return this.d;
    }

    public void m() {
        this.d.a();
    }

    @Override // com.kc.cw.ad.IBidding
    public void sendLossNotice(int i, String str, String str2) {
        NativeAdResponse nativeAdResponse;
        try {
            a aVar = this.d;
            if (aVar == null || (nativeAdResponse = aVar.b) == null) {
                return;
            }
            e eVar = (e) nativeAdResponse;
            eVar.a(i, str, str2);
            eVar.g();
        } catch (Throwable th) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "A Throwable Caught", th);
        }
    }

    @Override // com.kc.cw.ad.IBidding
    public void sendWinNotice(int i) {
        NativeAdResponse nativeAdResponse;
        try {
            a aVar = this.d;
            if (aVar == null || (nativeAdResponse = aVar.b) == null) {
                return;
            }
            ((e) nativeAdResponse).b(i);
        } catch (Throwable th) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "A Throwable Caught", th);
        }
    }
}
