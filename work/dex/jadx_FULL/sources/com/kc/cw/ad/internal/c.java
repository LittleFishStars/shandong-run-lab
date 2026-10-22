package com.kc.cw.ad.internal;

import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c {
    private final com.kc.cw.ad.internal.a d;
    private s e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f38932a = -1;
    private long b = -1;
    private long c = -1;
    private a f = a.STOPPED;
    private boolean g = false;

    /* JADX INFO: renamed from: com.kc.cw.ad.internal.c$1, reason: invalid class name */
    @Keep
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int[] f38933a;
        static final int[] b;

        static {
            int[] iArr = new int[p.values().length];
            b = iArr;
            try {
                iArr[p.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[p.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[p.FULLSCREEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[p.REWARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[p.NATIVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[p.BANNER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[p.DRAW.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[p.PREFETCH.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[a.values().length];
            f38933a = iArr2;
            try {
                iArr2[a.STOPPED.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f38933a[a.SINGLE_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f38933a[a.AUTO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    @Keep
    public enum a {
        STOPPED,
        SINGLE_REQUEST,
        AUTO_REFRESH
    }

    public c(com.kc.cw.ad.internal.a aVar) {
        this.d = aVar;
        com.kc.cw.ad.d.b.f.c("OctopusAd_Time", "AdFetcher 开始");
    }

    public void a() {
        s sVar = this.e;
        if (sVar != null) {
            sVar.c();
            this.e = null;
        }
        com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.f38946a, com.kc.cw.ad.internal.c.f.a(R.string.stop));
        this.c = System.currentTimeMillis();
        this.f = a.STOPPED;
    }

    public void a(int i, String str) {
        boolean z = this.f38932a != i;
        this.f38932a = i;
        if (!z || this.f.equals(a.STOPPED)) {
            return;
        }
        com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.f38946a, "AdFetcher refresh mPeriod changed to " + this.f38932a);
        com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.f38946a, "Resetting AdFetcher");
        a();
        a(str);
    }

    public void a(String str) {
        a aVar;
        com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.f38946a, com.kc.cw.ad.internal.c.f.a(R.string.start));
        int i = AnonymousClass1.f38933a[this.f.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            com.kc.cw.ad.internal.c.f.a(com.kc.cw.ad.internal.c.f.f38946a, com.kc.cw.ad.internal.c.f.a(R.string.fetcher_start_single));
            b(str);
            return;
        }
        if (this.f38932a <= 0) {
            com.kc.cw.ad.internal.c.f.a(com.kc.cw.ad.internal.c.f.f38946a, com.kc.cw.ad.internal.c.f.a(R.string.fetcher_start_single));
            b(str);
            aVar = a.SINGLE_REQUEST;
        } else {
            b(str);
            aVar = a.AUTO_REFRESH;
        }
        this.f = aVar;
    }

    public void b() {
        this.g = true;
    }

    public void b(String str) {
        com.kc.cw.ad.internal.a aVar;
        s fVar;
        try {
            if (!this.g && (aVar = this.d) != null && aVar.a()) {
                this.b = System.currentTimeMillis();
                switch (AnonymousClass1.b[this.d.getMediaType().ordinal()]) {
                    case 1:
                        fVar = new f((com.kc.cw.ad.internal.e.g) this.d, str);
                        this.e = fVar;
                        break;
                    case 2:
                    case 3:
                    case 4:
                        fVar = new f((com.kc.cw.ad.internal.e.f) this.d, str);
                        this.e = fVar;
                        break;
                    case 5:
                    case 6:
                    case 7:
                        fVar = new com.kc.cw.ad.internal.b.d((com.kc.cw.ad.internal.b.c) this.d, str);
                        this.e = fVar;
                        break;
                    case 8:
                        fVar = new r(str);
                        this.e = fVar;
                        break;
                }
                this.e.a();
            }
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public void c() {
        this.b = -1L;
        this.c = -1L;
    }
}
