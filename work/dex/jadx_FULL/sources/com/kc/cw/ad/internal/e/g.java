package com.kc.cw.ad.internal.e;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.kc.cw.ad.internal.a.i;
import com.kc.cw.ad.internal.c.t;
import com.kc.cw.ad.internal.p;
import com.kc.cw.ad.internal.q;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class g extends com.kc.cw.ad.internal.e.a {
    private String A;
    private c B;
    private a C;
    protected boolean u;
    private int v;
    private boolean w;
    private boolean x;
    private boolean y;
    private com.kc.cw.ad.internal.a.b z;

    /* JADX INFO: renamed from: com.kc.cw.ad.internal.e.g$1, reason: invalid class name */
    @Keep
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int[] f39028a;

        static {
            int[] iArr = new int[a.values().length];
            f39028a = iArr;
            try {
                iArr[a.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f39028a[a.TOP_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f39028a[a.TOP_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f39028a[a.CENTER_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f39028a[a.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f39028a[a.CENTER_RIGHT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f39028a[a.BOTTOM_LEFT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f39028a[a.BOTTOM_CENTER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f39028a[a.BOTTOM_RIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    @Keep
    public enum a {
        TOP_LEFT,
        TOP_CENTER,
        TOP_RIGHT,
        CENTER_LEFT,
        CENTER,
        CENTER_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_CENTER,
        BOTTOM_RIGHT;

        public int a() {
            switch (AnonymousClass1.f39028a[ordinal()]) {
                case 1:
                    return 51;
                case 2:
                    return 49;
                case 3:
                    return 8388661;
                case 4:
                    return 8388627;
                case 5:
                default:
                    return 17;
                case 6:
                    return 8388629;
                case 7:
                    return 8388691;
                case 8:
                    return 81;
                case 9:
                    return 8388693;
            }
        }
    }

    @Keep
    public class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final g f39030a;
        private final c b;
        private final com.kc.cw.ad.internal.a.b c;

        public b(g gVar, c cVar, com.kc.cw.ad.internal.a.b bVar) {
            this.f39030a = gVar;
            this.b = cVar;
            this.c = bVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            animation.setAnimationListener(null);
            c cVar = this.b;
            com.kc.cw.ad.internal.a.b bVar = this.c;
            if (cVar == null || bVar == null) {
                return;
            }
            cVar.getView().getHandler().post(new Runnable(this, bVar, cVar) { // from class: com.kc.cw.ad.internal.e.g.b.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final com.kc.cw.ad.internal.a.b f39031a;
                final c b;
                final b c;

                {
                    this.c = this;
                    this.f39031a = bVar;
                    this.b = cVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f39031a.clearAnimation();
                    this.b.k();
                    this.f39031a.a();
                }
            });
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public g(Context context, ViewGroup viewGroup, String str) {
        super(context, viewGroup, str);
        this.A = str;
    }

    @Override // com.kc.cw.ad.internal.e.a
    public void a(Context context, AttributeSet attributeSet) {
        super.a(context, attributeSet);
        com.kc.cw.ad.d.b.f.c("OctopusAd_Time", "SplashAdViewImpl setup 开始");
        this.v = -1;
        this.u = false;
        this.x = false;
        this.y = false;
        if (q.a().d == 0) {
            this.z = new com.kc.cw.ad.internal.a.b(getContext(), i.NONE, com.kc.cw.ad.internal.a.h.UP, 500L);
        }
        View view = (View) getParent();
        if (view != null) {
            int measuredHeight = view.getMeasuredHeight();
            int measuredHeight2 = view.getMeasuredHeight();
            q qVarA = q.a();
            int iP = (int) ((measuredHeight / qVarA.p()) + 0.5f);
            this.d.b((int) ((measuredHeight2 / qVarA.o()) + 0.5f));
            this.d.c(iP);
        }
        p pVar = p.SPLASH;
        this.g = pVar;
        this.d.a(pVar);
        this.f.a(this.v, this.A);
    }

    @Override // com.kc.cw.ad.internal.e.a
    public boolean a(com.kc.cw.ad.internal.b.a.C1001a c1001a) {
        h();
        if (!super.a(c1001a)) {
            return false;
        }
        this.w = true;
        return true;
    }

    @Override // com.kc.cw.ad.internal.e.a
    public boolean a(c cVar) {
        if (cVar == null || cVar.j() || cVar.getView() == null || cVar.getAdWebView() == null) {
            b(80102);
            com.kc.cw.ad.internal.c.f.e(com.kc.cw.ad.internal.c.f.f38946a, "Loaded an ad with an invalid displayable");
            return false;
        }
        if (this.c == cVar) {
            b(80102);
            return false;
        }
        this.B = cVar;
        if (getTransitionType() == i.NONE) {
            removeAllViews();
            c cVar2 = this.c;
            if (cVar2 != null) {
                cVar2.k();
            }
            View view = cVar.getView();
            if (view instanceof com.kc.cw.ad.d) {
                setBackgroundColor(-16777216);
            }
            addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (view.getLayoutParams() != null) {
                ((FrameLayout.LayoutParams) view.getLayoutParams()).gravity = getAdAlignment().a();
            }
            cVar.l();
        } else if (this.z != null) {
            if (cVar.getView().getLayoutParams() != null) {
                ((FrameLayout.LayoutParams) cVar.getView().getLayoutParams()).gravity = getAdAlignment().a();
                this.z.setLayoutParams(cVar.getView().getLayoutParams());
            }
            if (getChildCount() == 0 || indexOfChild(this.z) == -1) {
                removeAllViews();
                if (cVar.getView() instanceof com.kc.cw.ad.d) {
                    cVar.l();
                }
                addView(this.z, 0);
                this.z.addView(cVar.getView());
            } else {
                if (cVar.getView() instanceof com.kc.cw.ad.d) {
                    cVar.l();
                }
                this.z.addView(cVar.getView());
                this.z.showNext();
            }
            c cVar3 = this.c;
            if (cVar3 != null) {
                if (cVar3.getView().getAnimation() != null) {
                    cVar3.getView().getAnimation().setAnimationListener(new b(this, cVar3, this.z));
                } else {
                    cVar3.k();
                }
            }
        }
        this.c = cVar;
        return true;
    }

    public a getAdAlignment() {
        if (this.C == null) {
            this.C = a.CENTER;
        }
        return this.C;
    }

    @Override // com.kc.cw.ad.internal.a
    public p getMediaType() {
        return p.SPLASH;
    }

    public boolean getResizeAdToFitContainer() {
        return this.x;
    }

    public i getTransitionType() {
        com.kc.cw.ad.internal.a.b bVar = this.z;
        return bVar != null ? bVar.getTransitionType() : i.NONE;
    }

    @Override // com.kc.cw.ad.internal.e.a
    public boolean k() {
        return false;
    }

    @Override // com.kc.cw.ad.internal.e.a, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.y || z) {
            q qVarA = q.a();
            int iO = (int) (((i3 - i) / qVarA.o()) + 0.5f);
            int iP = (int) (((i4 - i2) / qVarA.p()) + 0.5f);
            if (iO >= this.d.j() && (iP >= this.d.k() || iO <= 0 || iP <= 0)) {
                this.d.b(iO);
                this.d.c(iP);
                this.y = true;
            } else {
                com.kc.cw.ad.internal.c cVar = this.f;
                if (cVar != null) {
                    cVar.a();
                }
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            if (getChildAt(0) instanceof WebView) {
                t.b((WebView) getChildAt(0));
                return;
            }
            return;
        }
        com.kc.cw.ad.d.b.f.c("OctopusAd", "enter onWindowVisibilityChanged before dismantleBroadcast");
        com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.f38946a, com.kc.cw.ad.internal.c.f.a(R.string.hidden));
        if (this.f != null && this.w) {
            u();
        }
        if (getChildAt(0) instanceof WebView) {
            t.c((WebView) getChildAt(0));
        }
    }

    @Override // com.kc.cw.ad.internal.e.a
    public void s() {
        c cVar = this.B;
        if (cVar != null) {
            cVar.o();
            this.B = null;
        }
        com.kc.cw.ad.d.b.f.c("OctopusAd", "enter activityOnDestroy before dismantleBroadcast");
        if (this.f != null) {
            u();
        }
    }

    public void u() {
        com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.c, com.kc.cw.ad.internal.c.f.a(R.string.stop));
        this.f.a();
        this.w = false;
    }
}
