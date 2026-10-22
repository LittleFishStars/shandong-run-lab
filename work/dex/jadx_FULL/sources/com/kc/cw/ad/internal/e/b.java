package com.kc.cw.ad.internal.e;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kc.cw.ad.internal.c.p;
import com.kc.cw.ad.internal.j;
import com.kc.cw.ad.internal.q;
import com.kc.cw.ad.internal.utilities.ImageManager;
import com.kc.cw.ad.internal.utilities.ViewUtil;
import com.kc.cw.ad.utils.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f39020a;
    public FrameLayout c;
    private final Context f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean e = false;
    public com.kc.cw.ad.internal.b.f b = null;
    public com.kc.cw.ad.d d = null;
    private int o = -1;
    private boolean p = true;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;
    private int t = 0;

    /* JADX INFO: renamed from: com.kc.cw.ad.internal.e.b$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements ImageManager.BitmapLoadedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ImageView f39022a;
        final b b;

        /* JADX INFO: renamed from: com.kc.cw.ad.internal.e.b$2$1, reason: invalid class name */
        @Keep
        public class AnonymousClass1 implements com.kc.cw.ad.d.d.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Bitmap f39023a;
            final AnonymousClass2 b;

            public AnonymousClass1(AnonymousClass2 anonymousClass2, Bitmap bitmap) {
                this.b = anonymousClass2;
                this.f39023a = bitmap;
            }

            @Override // com.kc.cw.ad.d.d.a
            public void a(Bitmap bitmap) {
                ThreadUtils.runOnUIThread(new Runnable(this, bitmap) { // from class: com.kc.cw.ad.internal.e.b.2.1.1

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final Bitmap f39024a;
                    final AnonymousClass1 b;

                    {
                        this.b = this;
                        this.f39024a = bitmap;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (this.f39024a != null) {
                                this.b.b.f39022a.setBackground(new BitmapDrawable(this.b.b.b.f.getResources(), this.f39024a));
                            }
                            AnonymousClass1 anonymousClass1 = this.b;
                            anonymousClass1.b.f39022a.setImageBitmap(anonymousClass1.f39023a);
                            a aVar = this.b.b.b.f39020a;
                            if (aVar != null) {
                                aVar.b(true);
                                this.b.b.b.f39020a.o();
                            }
                        } catch (Exception unused) {
                            a aVar2 = this.b.b.b.f39020a;
                            if (aVar2 != null) {
                                aVar2.b(false);
                                this.b.b.b.f39020a.o();
                            }
                        }
                    }
                });
            }
        }

        public AnonymousClass2(b bVar, ImageView imageView) {
            this.b = bVar;
            this.f39022a = imageView;
        }

        @Override // com.kc.cw.ad.internal.utilities.ImageManager.BitmapLoadedListener
        public void onBitmapLoadFailed() {
            a aVar = this.b.f39020a;
            if (aVar != null) {
                aVar.b(false);
                this.b.f39020a.o();
            }
        }

        @Override // com.kc.cw.ad.internal.utilities.ImageManager.BitmapLoadedListener
        public void onBitmapLoaded(Bitmap bitmap) {
            com.kc.cw.ad.d.d.a(this.b.f, bitmap, new AnonymousClass1(this, bitmap));
        }
    }

    public b(a aVar) {
        this.f = new MutableContextWrapper(aVar.getContext());
        this.f39020a = aVar;
        aVar.setAdWebView(this);
    }

    private void a(FrameLayout.LayoutParams layoutParams) {
        FrameLayout frameLayout = this.c;
        if (frameLayout != null) {
            a aVar = this.f39020a;
            if (aVar instanceof g) {
                if (((g) aVar).getResizeAdToFitContainer()) {
                    layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
                }
                frameLayout = this.c;
            }
            frameLayout.setLayoutParams(layoutParams);
        }
    }

    private void g(int i) {
        this.i = i;
    }

    private void h(int i) {
        this.j = i;
    }

    public Context a() {
        return this.f;
    }

    public void a(int i, com.kc.cw.ad.a.d dVar) {
        a aVar;
        if (this.b == null || (aVar = this.f39020a) == null || aVar.getAdDispatcher() == null || this.c == null) {
            return;
        }
        if (this.f39020a.g()) {
            this.f39020a.getAdDispatcher().b();
        }
        this.f39020a.setIsClicked(true);
        this.b.a(this.f39020a.getOpensNativeBrowser());
        this.b.a(this.f39020a.getSplashParent() == null ? this.c : this.f39020a.getSplashParent(), i, this.f39020a.g(), dVar);
    }

    public void a(com.kc.cw.ad.internal.b.f fVar) {
        int i;
        if (fVar == null) {
            return;
        }
        this.b = fVar;
        h(fVar.o());
        g(fVar.p());
        d(fVar.H());
        e(fVar.G());
        f(fVar.J());
        if (fVar.D()) {
            this.m = fVar.E();
        } else {
            this.m = -1;
        }
        if (fVar.F() != 0) {
            this.n = fVar.F();
        } else {
            this.n = -1;
        }
        if (this.m == -1 && this.n == -1 && fVar.af() != com.kc.cw.ad.a.g.a.ADP_REWARD) {
            this.m = 0;
        } else {
            int i2 = this.m;
            if (i2 != -1 && (i = this.n) != -1 && i2 > i) {
                this.m = i;
            }
        }
        this.p = fVar.A();
        this.q = fVar.x();
        this.r = fVar.y();
        this.l = fVar.I();
        this.o = -1;
        boolean zS = fVar.S();
        FrameLayout frameLayout = new FrameLayout(this.f);
        this.c = frameLayout;
        this.c.setOnTouchListener(new h(frameLayout, zS, new h.a(this) { // from class: com.kc.cw.ad.internal.e.b.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final b f39021a;

            {
                this.f39021a = this;
            }

            @Override // com.kc.cw.ad.internal.e.h.a
            public void a(View view, com.kc.cw.ad.a.d dVar) {
                b bVar = this.f39021a;
                bVar.a(bVar.t, dVar);
            }
        }));
        b(0);
    }

    public boolean a(int i) {
        return b(this.o + i);
    }

    public HashMap<String, Object> b() {
        com.kc.cw.ad.internal.b.f fVar = this.b;
        if (fVar == null) {
            return null;
        }
        return fVar.w();
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00ef A[PHI: r2 r3
      0x00ef: PHI (r2v11 android.widget.FrameLayout$LayoutParams) = (r2v10 android.widget.FrameLayout$LayoutParams), (r2v15 android.widget.FrameLayout$LayoutParams) binds: [B:41:0x00ed, B:35:0x00ba] A[DONT_GENERATE, DONT_INLINE]
      0x00ef: PHI (r3v6 android.widget.FrameLayout) = (r3v5 android.widget.FrameLayout), (r3v13 android.widget.FrameLayout) binds: [B:41:0x00ed, B:35:0x00ba] A[DONT_GENERATE, DONT_INLINE]] */
    public boolean b(int i) {
        int creativeHeight;
        int creativeWidth;
        FrameLayout.LayoutParams layoutParams;
        FrameLayout frameLayout;
        com.kc.cw.ad.internal.b.f fVar = this.b;
        if (fVar != null && this.o != i) {
            if (!fVar.n().isEmpty() && this.b.n().size() > i) {
                Pair<j, String> pair = this.b.n().get(i);
                if (p.a((String) pair.second)) {
                    p();
                    return false;
                }
                if (pair.first == j.VIDEO) {
                    if (this.d == null) {
                        this.d = new com.kc.cw.ad.d(this);
                    }
                    this.d.a((String) pair.second);
                    this.s = true;
                } else {
                    float fO = q.a().o();
                    float fP = q.a().p();
                    float fQ = q.a().q();
                    if (getCreativeWidth() == -1 && getCreativeHeight() == -1) {
                        creativeWidth = -1;
                        creativeHeight = -1;
                    } else {
                        creativeHeight = (int) ((getCreativeHeight() * fQ) + 0.5f);
                        creativeWidth = (int) ((getCreativeWidth() * fQ) + 0.5f);
                    }
                    if (e() == 0 && f() == 0) {
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(creativeWidth, creativeHeight, 17);
                        if (this.b.m() == com.kc.cw.ad.internal.p.SPLASH) {
                            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
                            frameLayout = this.c;
                            if (frameLayout != null) {
                                frameLayout.setLayoutParams(layoutParams);
                            }
                        } else {
                            a(layoutParams2);
                        }
                    } else {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(creativeWidth, creativeHeight, 8388659);
                        layoutParams3.setMargins((int) ((e() * fO) + 0.5f), (int) ((f() * fP) + 0.5f), 0, 0);
                        if (this.b.m() == com.kc.cw.ad.internal.p.SPLASH) {
                            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
                            frameLayout = this.c;
                            if (frameLayout != null) {
                                frameLayout.setLayoutParams(layoutParams);
                            }
                        } else {
                            a(layoutParams3);
                        }
                    }
                    a aVar = this.f39020a;
                    if (aVar != null) {
                        aVar.p = true;
                    }
                    ImageView imageView = new ImageView(this.f);
                    ImageManager.with(this.f).getBitmap((String) pair.second, new AnonymousClass2(this, imageView));
                    FrameLayout frameLayout2 = this.c;
                    if (frameLayout2 != null) {
                        frameLayout2.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
                    }
                    this.s = false;
                }
                this.o = i;
                return true;
            }
            p();
        }
        return false;
    }

    public c c() {
        com.kc.cw.ad.d dVar;
        return (!this.s || (dVar = this.d) == null) ? this : dVar;
    }

    public void c(int i) {
        this.t = i;
    }

    public void d(int i) {
        this.g = i;
    }

    public boolean d() {
        return this.b.af() != com.kc.cw.ad.a.g.a.ADP_REWARD ? this.o == 0 : this.b.n().get(this.o).first == j.VIDEO;
    }

    public int e() {
        return this.g;
    }

    public void e(int i) {
        this.h = i;
    }

    public int f() {
        return this.h;
    }

    public void f(int i) {
        this.k = i;
    }

    public int g() {
        return this.m;
    }

    @Override // com.kc.cw.ad.internal.e.c
    public b getAdWebView() {
        return this;
    }

    @Override // com.kc.cw.ad.internal.e.c
    public int getCreativeHeight() {
        return this.j;
    }

    @Override // com.kc.cw.ad.internal.e.c
    public int getCreativeWidth() {
        return this.i;
    }

    @Override // com.kc.cw.ad.internal.e.c
    public View getView() {
        return this.c;
    }

    public int h() {
        return this.n;
    }

    public boolean i() {
        return this.p;
    }

    @Override // com.kc.cw.ad.internal.e.c
    public boolean j() {
        return this.e;
    }

    @Override // com.kc.cw.ad.internal.e.c
    public void k() {
        ThreadUtils.runOnUIThread(new Runnable(this) { // from class: com.kc.cw.ad.internal.e.b.3

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final b f39025a;

            {
                this.f39025a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar;
                b bVar = this.f39025a;
                if (bVar.c == null || (aVar = bVar.f39020a) == null || aVar.getMediaType() == com.kc.cw.ad.internal.p.SPLASH) {
                    return;
                }
                this.f39025a.c.removeAllViews();
                ViewUtil.removeChildFromParent(this.f39025a.c);
            }
        });
    }

    @Override // com.kc.cw.ad.internal.e.c
    public void l() {
        a aVar;
        FrameLayout frameLayout = this.c;
        if (frameLayout == null || (aVar = this.f39020a) == null) {
            return;
        }
        aVar.d(frameLayout);
        this.f39020a.c(this.c);
        this.f39020a.e(this.c);
        com.kc.cw.ad.internal.p mediaType = this.f39020a.getMediaType();
        com.kc.cw.ad.internal.p pVar = com.kc.cw.ad.internal.p.INTERSTITIAL;
        if (mediaType == pVar || this.f39020a.getMediaType() == com.kc.cw.ad.internal.p.FULLSCREEN) {
            this.f39020a.a(g(), h(), this.c);
        }
        com.kc.cw.ad.internal.p mediaType2 = this.f39020a.getMediaType();
        com.kc.cw.ad.internal.p pVar2 = com.kc.cw.ad.internal.p.REWARD;
        if (mediaType2 == pVar2) {
            this.f39020a.a(h(), g(), h());
        }
        if (this.f39020a.getAdDispatcher() != null) {
            if (this.f39020a.getMediaType() == pVar || this.f39020a.getMediaType() == com.kc.cw.ad.internal.p.FULLSCREEN || this.f39020a.getMediaType() == pVar2) {
                r();
            }
        }
    }

    public boolean m() {
        return this.q;
    }

    public boolean n() {
        return this.r;
    }

    @Override // com.kc.cw.ad.internal.e.c
    public void o() {
        k();
    }

    public void p() {
        this.e = true;
    }

    public int q() {
        return this.l;
    }

    public void r() {
        a aVar;
        com.kc.cw.ad.internal.b.f fVar = this.b;
        if (fVar == null || (aVar = this.f39020a) == null) {
            return;
        }
        fVar.a(aVar.g(), new com.kc.cw.ad.a(this) { // from class: com.kc.cw.ad.internal.e.b.4

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final b f39026a;

            {
                this.f39026a = this;
            }

            @Override // com.kc.cw.ad.a
            public void a(boolean z) {
                a aVar2 = this.f39026a.f39020a;
                if (aVar2 == null || aVar2.getAdDispatcher() == null) {
                    return;
                }
                this.f39026a.f39020a.getAdDispatcher().a(z);
            }
        });
    }

    public int s() {
        return this.k;
    }
}
