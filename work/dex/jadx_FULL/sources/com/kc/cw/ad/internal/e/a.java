package com.kc.cw.ad.internal.e;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.GravityCompat;
import com.beizi.fusion.widget.ScrollClickView;
import com.kc.cw.ad.AdActivity;
import com.kc.cw.ad.AdLifeControl;
import com.kc.cw.ad.FullScreenVideoAdListener;
import com.kc.cw.ad.IBidding;
import com.kc.cw.ad.InterstitialAdListener;
import com.kc.cw.ad.OnSensorListener;
import com.kc.cw.ad.RewardVideoAdListener;
import com.kc.cw.ad.SSAd;
import com.kc.cw.ad.SplashAdListener;
import com.kc.cw.ad.d.i;
import com.kc.cw.ad.d.j;
import com.kc.cw.ad.d.k;
import com.kc.cw.ad.d.l;
import com.kc.cw.ad.internal.activity.EndingPageActivity;
import com.kc.cw.ad.internal.activity.StopoverDialogActivity;
import com.kc.cw.ad.internal.o;
import com.kc.cw.ad.internal.p;
import com.kc.cw.ad.internal.q;
import com.kc.cw.ad.internal.t;
import com.kc.cw.ad.internal.utilities.ViewUtil;
import com.kc.cw.ad.internal.v;
import com.kc.cw.ad.internal.video.VideoStateListener;
import com.kc.cw.ad.model.AdLogoInfo;
import com.kc.cw.ad.model.ComplianceInfo;
import com.kc.cw.ad.model.ShakeValue;
import com.kc.cw.ad.utils.OctUtil;
import com.kc.cw.ad.utils.ThreadUtils;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class a extends FrameLayout implements ViewTreeObserver.OnGlobalLayoutListener, AdLifeControl, IBidding, com.kc.cw.ad.internal.a {
    private FullScreenVideoAdListener A;
    private RewardVideoAdListener B;
    private com.kc.cw.ad.a.a C;
    private final Handler D;
    private b E;
    private com.kc.cw.ad.internal.d.b F;
    private com.kc.cw.ad.internal.d.h G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private AppCompatTextView N;
    private AppCompatTextView O;
    private ImageView P;
    private com.kc.cw.ad.b.a Q;
    private com.kc.cw.ad.b.a R;
    private AppCompatImageView S;
    private AppCompatTextView T;
    private ProgressBar U;
    private FrameLayout V;
    private FrameLayout W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.kc.cw.ad.internal.b.f f38976a;
    private ViewGroup aA;
    private final String aB;
    private String aC;
    private String aD;
    private String aE;
    private String aF;
    private Pair<String, Integer> aG;
    private boolean aH;
    private boolean aI;
    private boolean aJ;
    private boolean aK;
    private boolean aL;
    private float aM;
    private float aN;
    private int aO;
    private l aP;
    private k aQ;
    private j aR;
    private OnSensorListener aS;
    private VideoStateListener aT;
    private com.kc.cw.ad.internal.k.a aU;
    private com.kc.cw.ad.internal.k.a aV;
    private final c aW;
    private boolean aX;
    private LinearLayout aa;
    private int ab;
    private String ac;
    private String ad;
    private String ae;
    private int af;
    private int ag;
    private int ah;
    private long ai;
    private long aj;
    private boolean ak;
    private boolean al;
    private boolean am;
    private boolean an;
    private boolean ao;
    private boolean ap;
    private boolean aq;
    private boolean ar;
    private Boolean as;
    private boolean at;
    private int au;
    private com.kc.cw.ad.d av;
    private com.kc.cw.ad.internal.e.b aw;
    private boolean ax;
    private boolean ay;
    private boolean az;
    protected C1008a b;
    protected com.kc.cw.ad.internal.e.c c;
    protected com.kc.cw.ad.internal.d d;
    protected com.kc.cw.ad.internal.b.a.C1001a e;
    public com.kc.cw.ad.internal.c f;
    protected p g;
    protected boolean h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    protected boolean o;
    protected boolean p;
    protected boolean q;
    protected boolean r;
    protected boolean s;
    protected Context t;
    private ViewGroup u;
    private int v;
    private int w;
    private float x;
    private SplashAdListener y;
    private InterstitialAdListener z;

    /* JADX INFO: renamed from: com.kc.cw.ad.internal.e.a$17, reason: invalid class name */
    @Keep
    public class AnonymousClass17 implements com.kc.cw.ad.internal.c.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f38985a;

        public AnonymousClass17(a aVar) {
            this.f38985a = aVar;
        }

        @Override // com.kc.cw.ad.internal.c.d.a
        public void a(int i, boolean z, String str) {
            if (z && !TextUtils.isEmpty(str)) {
                try {
                    if (new JSONObject(str).optBoolean("isValid") && this.f38985a.aG != null) {
                        a aVar = this.f38985a;
                        aVar.a((String) aVar.aG.first, ((Integer) this.f38985a.aG.second).intValue());
                    }
                } catch (Exception e) {
                    com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
                }
            } else if (this.f38985a.aO > 0) {
                new Handler().postDelayed(new Runnable(this) { // from class: com.kc.cw.ad.internal.e.a.17.1

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final AnonymousClass17 f38986a;

                    {
                        this.f38986a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        this.f38986a.f38985a.r();
                        a.M(this.f38986a.f38985a);
                    }
                }, 200L);
            }
            if (z || this.f38985a.aO == 0) {
                this.f38985a.d(z);
            }
        }
    }

    /* JADX INFO: renamed from: com.kc.cw.ad.internal.e.a$a, reason: collision with other inner class name */
    @Keep
    public static class C1008a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EnumC1009a f39012a = EnumC1009a.UNCHANGE;
        public boolean b = false;

        /* JADX INFO: renamed from: com.kc.cw.ad.internal.e.a$a$a, reason: collision with other inner class name */
        @Keep
        public enum EnumC1009a {
            UNCHANGE,
            STATE_PREPARE_CHANGE,
            STATE_BACKGROUND,
            FINISHCLOSE
        }

        public void a(EnumC1009a enumC1009a) {
            synchronized (this) {
                EnumC1009a enumC1009a2 = EnumC1009a.STATE_PREPARE_CHANGE;
                if (enumC1009a == enumC1009a2 && this.f39012a == EnumC1009a.UNCHANGE) {
                    this.f39012a = enumC1009a2;
                }
                EnumC1009a enumC1009a3 = EnumC1009a.STATE_BACKGROUND;
                if (enumC1009a == enumC1009a3 && this.f39012a == enumC1009a2) {
                    this.f39012a = enumC1009a3;
                }
                EnumC1009a enumC1009a4 = EnumC1009a.FINISHCLOSE;
                if (enumC1009a == enumC1009a4 && this.f39012a == enumC1009a3 && this.b) {
                    this.f39012a = enumC1009a4;
                }
            }
        }

        public void a(boolean z) {
            this.b = z;
        }

        public boolean a() {
            return this.b;
        }

        public void b() {
            this.f39012a = EnumC1009a.UNCHANGE;
        }

        public EnumC1009a c() {
            return this.f39012a;
        }
    }

    @Keep
    public class b implements com.kc.cw.ad.internal.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f39014a;
        private final Handler b;
        private com.kc.cw.ad.internal.b.b c;

        public b(a aVar, Handler handler) {
            this.f39014a = aVar;
            this.b = handler;
        }

        @Override // com.kc.cw.ad.internal.b
        public void a() {
            if (this.f39014a.an) {
                return;
            }
            this.f39014a.an = true;
            this.f39014a.C();
            a aVar = this.f39014a;
            if (aVar.f38976a != null && !aVar.L) {
                this.f39014a.f38976a.ac();
            }
            this.b.post(new Runnable(this) { // from class: com.kc.cw.ad.internal.e.a.b.3

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final b f39017a;

                {
                    this.f39017a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.f39017a.f39014a.y != null) {
                        this.f39017a.f39014a.y.onAdClosed();
                    } else if (this.f39017a.f39014a.z != null) {
                        this.f39017a.f39014a.z.onAdClosed();
                    } else if (this.f39017a.f39014a.A != null) {
                        this.f39017a.f39014a.A.onAdClosed();
                    } else if (this.f39017a.f39014a.B != null) {
                        this.f39017a.f39014a.B.onRewardVideoAdClosed();
                    }
                    this.f39017a.f39014a.b.b();
                }
            });
        }

        @Override // com.kc.cw.ad.internal.b
        public void a(int i) {
            this.b.post(new Runnable(this, i) { // from class: com.kc.cw.ad.internal.e.a.b.2

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final int f39016a;
                final b b;

                {
                    this.b = this;
                    this.f39016a = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.b.f39014a.b(this.f39016a);
                }
            });
        }

        @Override // com.kc.cw.ad.internal.b
        public void a(long j) {
            this.b.post(new Runnable(this, j) { // from class: com.kc.cw.ad.internal.e.a.b.5

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final long f39019a;
                final b b;

                {
                    this.b = this;
                    this.f39019a = j;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.b.f39014a.y == null || this.b.c == null || !this.b.c.a().equals(p.SPLASH)) {
                        return;
                    }
                    this.b.f39014a.y.onAdTick(this.f39019a);
                }
            });
        }

        @Override // com.kc.cw.ad.internal.b
        public void a(com.kc.cw.ad.internal.b.b bVar) {
            this.c = bVar;
            if (bVar.a().equals(p.NATIVE) || bVar.a().equals(p.DRAW) || bVar.a().equals(p.BANNER)) {
                a(80103);
                return;
            }
            com.kc.cw.ad.internal.d dVar = this.f39014a.d;
            if (dVar != null && dVar.l()) {
                this.f39014a.ar = true;
                this.f39014a.w();
                return;
            }
            com.kc.cw.ad.internal.b.f fVar = this.f39014a.f38976a;
            if (fVar != null && fVar.r() == 1) {
                a(80100);
                this.f39014a.v();
                if (this.f39014a.aq) {
                    return;
                }
                com.kc.cw.ad.internal.b.a.b(this.f39014a.f38976a);
                return;
            }
            a aVar = this.f39014a;
            com.kc.cw.ad.internal.b.f fVar2 = aVar.f38976a;
            if (fVar2 == null) {
                a(80100);
                return;
            }
            aVar.p = fVar2.P();
            this.f39014a.setPrice(bVar.c());
            this.f39014a.setTagId(bVar.d());
            this.f39014a.setValidTime(bVar.e());
            this.f39014a.l();
            if (this.f39014a.f38976a.m() == p.REWARD) {
                a aVar2 = this.f39014a;
                aVar2.a(aVar2.f38976a.w());
            }
            this.b.post(new Runnable(this) { // from class: com.kc.cw.ad.internal.e.a.b.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final b f39015a;

                {
                    this.f39015a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    View adView = this.f39015a.f39014a.getAdView();
                    if (adView == null) {
                        return;
                    }
                    adView.getViewTreeObserver().addOnGlobalLayoutListener(this.f39015a.f39014a);
                }
            });
        }

        @Override // com.kc.cw.ad.internal.b
        public void a(com.kc.cw.ad.internal.e.c cVar) {
            this.f39014a.setCreativeWidth(cVar.getCreativeWidth());
            this.f39014a.setCreativeHeight(cVar.getCreativeHeight());
            if (this.f39014a.a(cVar)) {
                com.kc.cw.ad.d.b.f.c("OctopusAd_Time", "Displayable");
                a aVar = this.f39014a;
                aVar.s = true;
                aVar.E();
                this.f39014a.o();
            }
        }

        @Override // com.kc.cw.ad.internal.b
        public void a(boolean z) {
            this.f39014a.a(z);
            a aVar = this.f39014a;
            com.kc.cw.ad.internal.b.f fVar = aVar.f38976a;
            if (fVar != null) {
                a.a(fVar, aVar.aW);
                a aVar2 = this.f39014a;
                aVar2.at = aVar2.f38976a.S();
                a aVar3 = this.f39014a;
                aVar3.am = aVar3.f38976a.T();
                a aVar4 = this.f39014a;
                aVar4.as = aVar4.f38976a.R();
            }
        }

        @Override // com.kc.cw.ad.internal.b
        public void b() {
            this.b.post(new Runnable(this) { // from class: com.kc.cw.ad.internal.e.a.b.4

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final b f39018a;

                {
                    this.f39018a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Log.i("OctopusAd", "enter Octopus ad click");
                    this.f39018a.f39014a.C();
                    this.f39018a.f39014a.b.a(C1008a.EnumC1009a.STATE_PREPARE_CHANGE);
                    boolean z = Boolean.TRUE == this.f39018a.f39014a.as || !(Boolean.FALSE == this.f39018a.f39014a.as || this.f39018a.f39014a.ap || this.f39018a.f39014a.at || this.f39018a.f39014a.am);
                    a aVar = this.f39018a.f39014a;
                    com.kc.cw.ad.internal.b.f fVar = aVar.f38976a;
                    if (fVar != null) {
                        fVar.b(aVar.J && z);
                    }
                    if (this.f39018a.f39014a.J && z) {
                        if (this.f39018a.f39014a.y != null) {
                            this.f39018a.f39014a.y.onAdClicked();
                            return;
                        }
                        if (this.f39018a.f39014a.z != null) {
                            this.f39018a.f39014a.z.onAdClicked();
                        } else if (this.f39018a.f39014a.A != null) {
                            this.f39018a.f39014a.A.onAdClicked();
                        } else if (this.f39018a.f39014a.B != null) {
                            this.f39018a.f39014a.B.onRewardVideoAdClicked();
                        }
                    }
                }
            });
        }

        @Override // com.kc.cw.ad.internal.b
        public void c() {
        }

        @Override // com.kc.cw.ad.internal.b
        public void d() {
        }
    }

    @Keep
    public interface c {
        void a();
    }

    public a(Context context, ViewGroup viewGroup, String str) {
        super(context, null, 0);
        this.b = new C1008a();
        this.D = new Handler(this, Looper.getMainLooper()) { // from class: com.kc.cw.ad.internal.e.a.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final a f38977a;

            {
                this.f38977a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
            }
        };
        this.d = null;
        this.e = null;
        this.H = false;
        this.K = false;
        this.h = false;
        this.L = false;
        this.af = 0;
        this.ag = 0;
        this.ak = true;
        this.al = true;
        this.au = 0;
        this.ay = false;
        this.az = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.aG = null;
        this.aH = false;
        this.aI = false;
        this.aJ = false;
        this.aK = false;
        this.aO = 2;
        this.aW = new c(this) { // from class: com.kc.cw.ad.internal.e.a.29

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final a f38999a;

            {
                this.f38999a = this;
            }

            @Override // com.kc.cw.ad.internal.e.a.c
            public void a() {
                if (this.f38999a.an || this.f38999a.ao || this.f38999a.ap) {
                    return;
                }
                this.f38999a.x();
            }
        };
        this.aX = false;
        this.u = viewGroup;
        this.aB = str;
        a(context, (AttributeSet) null);
    }

    public a(Context context, String str) {
        super(context, null, 0);
        this.b = new C1008a();
        this.D = new Handler(this, Looper.getMainLooper()) { // from class: com.kc.cw.ad.internal.e.a.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final a f38977a;

            {
                this.f38977a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
            }
        };
        this.d = null;
        this.e = null;
        this.H = false;
        this.K = false;
        this.h = false;
        this.L = false;
        this.af = 0;
        this.ag = 0;
        this.ak = true;
        this.al = true;
        this.au = 0;
        this.ay = false;
        this.az = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.aG = null;
        this.aH = false;
        this.aI = false;
        this.aJ = false;
        this.aK = false;
        this.aO = 2;
        this.aW = new c(this) { // from class: com.kc.cw.ad.internal.e.a.29

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final a f38999a;

            {
                this.f38999a = this;
            }

            @Override // com.kc.cw.ad.internal.e.a.c
            public void a() {
                if (this.f38999a.an || this.f38999a.ao || this.f38999a.ap) {
                    return;
                }
                this.f38999a.x();
            }
        };
        this.aX = false;
        this.aB = str;
        a(context, (AttributeSet) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        this.r = true;
        G();
        if (getAdDispatcher() != null) {
            getAdDispatcher().a();
        }
        com.kc.cw.ad.b.a aVar = this.Q;
        if (aVar != null) {
            aVar.d();
        }
        com.kc.cw.ad.internal.e.b bVar = this.aw;
        if (bVar != null) {
            Activity activityB = b(bVar.getView());
            if (!k() || activityB == null || activityB.isFinishing() || !(activityB instanceof AdActivity)) {
                return;
            }
            activityB.finish();
        }
    }

    private void B() {
        com.kc.cw.ad.internal.b.f fVar = this.f38976a;
        if (fVar == null || !fVar.V() || this.aJ) {
            return;
        }
        this.aJ = true;
        OctUtil.a().a(getContext().getApplicationContext(), 1004);
        q.a().a(getAdSlotId(), getRequestId(), System.currentTimeMillis() - getExposeTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        com.kc.cw.ad.internal.b.f fVar = this.f38976a;
        if (fVar == null || !fVar.V() || this.aK || getContext() == null) {
            return;
        }
        this.aK = true;
        OctUtil.a().a(getContext().getApplicationContext(), 1005);
    }

    private void D() {
        com.kc.cw.ad.a.c.l lVarJ;
        if (this.f38976a == null || !q.a().f() || (lVarJ = this.f38976a.j()) == null || TextUtils.isEmpty(lVarJ.c())) {
            return;
        }
        q.a().a(this.f38976a.ag());
        if (lVarJ.b() == 1) {
            this.C = q.a().l.get(lVarJ.c());
        }
        com.kc.cw.ad.a.a aVar = this.C;
        if (aVar == null || !aVar.j() || this.C.f() < getPrice()) {
            com.kc.cw.ad.a.a aVar2 = new com.kc.cw.ad.a.a();
            this.C = aVar2;
            aVar2.a(getPrice());
            this.C.a(this.ai);
            this.C.b(this.aj);
            this.C.a(getRequestId());
            this.C.b(lVarJ.a());
            this.C.b(lVarJ.c());
            this.C.c(lVarJ.d());
            this.C.a(this.f38976a.U());
            this.C.e(this.f38976a.Z());
            com.kc.cw.ad.internal.b.f fVar = this.f38976a;
            if (fVar != null && fVar.a() != null) {
                this.C.d(this.f38976a.X());
                this.C.a(this.f38976a.a().t());
            }
            q.a().l.put(lVarJ.c(), this.C);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        com.kc.cw.ad.d dVar = this.av;
        if (dVar == null) {
            return;
        }
        String videoUrl = dVar.getVideoUrl();
        this.aC = videoUrl;
        if (TextUtils.isEmpty(videoUrl)) {
            b(false);
            return;
        }
        com.kc.cw.ad.internal.b.f fVar = this.f38976a;
        if (fVar != null && (!fVar.z() || "m3u8".equalsIgnoreCase(this.f38976a.h()))) {
            b(true);
            return;
        }
        com.kc.cw.ad.internal.d.h hVarB = q.a().b();
        this.G = hVarB;
        if (hVarB != null) {
            if (hVarB.b(this.aC)) {
                b(true);
                return;
            } else if (this.f38976a != null) {
                com.kc.cw.ad.internal.d.b bVar = new com.kc.cw.ad.internal.d.b(this) { // from class: com.kc.cw.ad.internal.e.a.15

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final a f38983a;

                    {
                        this.f38983a = this;
                    }

                    @Override // com.kc.cw.ad.internal.d.b
                    public void a(File file, String str, int i) {
                        if (i == 100) {
                            this.f38983a.b(true);
                        }
                    }
                };
                this.F = bVar;
                this.G.a(bVar, this.aC);
                n();
                return;
            }
        }
        b(false);
    }

    private void F() {
        if (this.G == null || this.F == null || TextUtils.isEmpty(this.aC)) {
            return;
        }
        this.G.b(this.F, this.aC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        com.kc.cw.ad.b.a aVar = this.R;
        if (aVar != null) {
            aVar.d();
        }
        LinearLayout linearLayout = this.aa;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        com.kc.cw.ad.internal.b.f fVar = this.f38976a;
        if (fVar != null && fVar.M() && this.ak) {
            Map<String, Object> mapAb = this.f38976a.ab();
            if (mapAb != null && !mapAb.isEmpty()) {
                mapAb.put("landingPageUrl", this.f38976a.Y());
                Intent intent = new Intent(getContext(), (Class<?>) StopoverDialogActivity.class);
                intent.setFlags(268435456);
                Bundle bundle = new Bundle();
                bundle.putSerializable("mapData", (Serializable) mapAb);
                intent.putExtra("bundleData", bundle);
                getContext().startActivity(intent);
                this.aU = new com.kc.cw.ad.internal.k.a(this) { // from class: com.kc.cw.ad.internal.e.a.27

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final a f38997a;

                    {
                        this.f38997a = this;
                    }

                    @Override // com.kc.cw.ad.internal.k.a
                    public void a(String str) {
                        if ("adClick".equals(str)) {
                            a aVar = this.f38997a;
                            aVar.a(aVar.getRandomClickPosition());
                            return;
                        }
                        if ("getReward".equals(str)) {
                            if (this.f38997a.P != null) {
                                this.f38997a.P.setVisibility(0);
                            }
                            this.f38997a.q();
                        } else if ("StopoverFinish".equals(str)) {
                            if (this.f38997a.Q != null) {
                                this.f38997a.Q.c();
                            }
                            com.kc.cw.ad.internal.k.a().b(this.f38997a.aU);
                            this.f38997a.aU = null;
                        }
                    }
                };
                com.kc.cw.ad.internal.k.a().a(this.aU);
                com.kc.cw.ad.b.a aVar = this.Q;
                if (aVar != null) {
                    aVar.b();
                }
            }
            this.ak = false;
        }
    }

    private void I() {
        l lVar = this.aP;
        if (lVar != null) {
            lVar.a();
            this.aP = null;
        }
        j jVar = this.aR;
        if (jVar != null) {
            jVar.a();
        }
        k kVar = this.aQ;
        if (kVar != null) {
            kVar.b();
        }
    }

    public static /* synthetic */ int M(a aVar) {
        int i = aVar.aO;
        aVar.aO = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MotionEvent motionEvent, boolean z, com.kc.cw.ad.a.d dVar) {
        try {
            if (motionEvent.getAction() != 0) {
                if (motionEvent.getAction() == 1 && motionEvent.getRawX() - this.aM <= 100.0f && motionEvent.getRawY() - this.aN <= 100.0f) {
                    dVar.c((int) motionEvent.getRawX());
                    dVar.d((int) motionEvent.getRawY());
                    dVar.b(String.valueOf(System.currentTimeMillis()));
                    View adView = getAdView();
                    if (adView != null) {
                        dVar.e(adView.getWidth());
                        dVar.f(adView.getHeight());
                    }
                    a(dVar);
                    return;
                }
                return;
            }
            this.aM = motionEvent.getRawX();
            this.aN = motionEvent.getRawY();
            dVar.a((int) motionEvent.getRawX());
            dVar.b((int) motionEvent.getRawY());
            dVar.a(String.valueOf(System.currentTimeMillis()));
            dVar.d(String.valueOf(System.currentTimeMillis()));
            dVar.c(String.valueOf(System.currentTimeMillis() / 1000));
            if (!z || this.K) {
                return;
            }
            int iA = i.a(150);
            dVar.c((int) motionEvent.getRawX());
            dVar.d((int) motionEvent.getRawY());
            dVar.b(String.valueOf(System.currentTimeMillis() + ((long) (iA + 50))));
            View adView2 = getAdView();
            if (adView2 != null) {
                dVar.e(adView2.getWidth());
                dVar.f(adView2.getHeight());
            }
            a(dVar);
            this.K = true;
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    private void a(com.kc.cw.ad.a.c.u uVar) {
        View adView;
        try {
            if (this.aP == null || uVar == null || (adView = getAdView()) == null) {
                return;
            }
            this.aP.a(uVar);
            this.aP.a(adView);
            View viewA = this.aP.a(adView, adView, 10.0f, uVar.e(), getMediaType(), false);
            if (viewA != null) {
                if (uVar.b() == 1) {
                    this.au = 7;
                }
                this.aP.a(new l.a(this) { // from class: com.kc.cw.ad.internal.e.a.18

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final a f38987a;

                    {
                        this.f38987a = this;
                    }

                    @Override // com.kc.cw.ad.d.l.a
                    public void a(com.kc.cw.ad.a.d dVar) {
                        this.f38987a.a(dVar);
                        if (this.f38987a.aS != null) {
                            this.f38987a.aS.onShakeTrigger(1, dVar.o(), dVar.p());
                        }
                    }
                });
                com.kc.cw.ad.a.d dVar = new com.kc.cw.ad.a.d(1);
                if (uVar.i() == 1) {
                    viewA.setOnTouchListener(new View.OnTouchListener(this, dVar) { // from class: com.kc.cw.ad.internal.e.a.19

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        final com.kc.cw.ad.a.d f38988a;
                        final a b;

                        {
                            this.b = this;
                            this.f38988a = dVar;
                        }

                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            a aVar = this.b;
                            aVar.a(motionEvent, aVar.at, this.f38988a);
                            return true;
                        }
                    });
                } else {
                    viewA.setOnClickListener(null);
                }
                ViewParent parent = adView instanceof FrameLayout ? (FrameLayout) adView : adView.getParent();
                if ((parent instanceof FrameLayout) && uVar.g() == 1) {
                    ((FrameLayout) parent).addView(viewA);
                }
            }
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public static void a(com.kc.cw.ad.internal.b.f fVar, c cVar) {
        com.kc.cw.ad.a.c.w wVarL;
        com.kc.cw.ad.a.c.g gVarA;
        if (fVar == null || (wVarL = fVar.L()) == null || (gVarA = wVarL.a()) == null) {
            return;
        }
        if (gVarA.a() == 1) {
            com.kc.cw.ad.d.e.a(new Runnable(cVar) { // from class: com.kc.cw.ad.internal.e.a.23

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final c f38993a;

                {
                    this.f38993a = cVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        c cVar2 = this.f38993a;
                        if (cVar2 != null) {
                            cVar2.a();
                        }
                    } catch (Throwable th) {
                        com.kc.cw.ad.d.b.f.a("OctopusAd", "A Throwable Caught", th);
                    }
                }
            }, gVarA.b());
        }
    }

    private void a(String str) {
        View viewA;
        try {
            k kVar = this.aQ;
            if (kVar != null) {
                kVar.a();
                View adView = getAdView();
                if (adView == null || (viewA = this.aQ.a(ViewUtil.px2dip(getContext(), adView.getWidth()), ViewUtil.px2dip(getContext(), adView.getHeight()), str)) == null) {
                    return;
                }
                a(ScrollClickView.DIR_UP, 100, new k.a(this) { // from class: com.kc.cw.ad.internal.e.a.21

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final a f38991a;

                    {
                        this.f38991a = this;
                    }

                    @Override // com.kc.cw.ad.d.k.a
                    public void a(com.kc.cw.ad.a.d dVar) {
                        this.f38991a.a(dVar);
                    }
                });
                ViewParent parent = adView instanceof FrameLayout ? (FrameLayout) adView : adView.getParent();
                if (parent instanceof FrameLayout) {
                    ((FrameLayout) parent).addView(viewA);
                }
            }
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.c("OctopusAd", "An Exception Caught: " + e.getMessage());
        }
    }

    private void a(String str, int i, k.a aVar) {
        if (aVar != null) {
            this.aQ.a(aVar);
        }
        int iDip2px = ViewUtil.dip2px(getContext(), i);
        com.kc.cw.ad.a.d dVar = new com.kc.cw.ad.a.d(3);
        View adView = getAdView();
        if (adView == null) {
            return;
        }
        dVar.e(adView.getWidth());
        dVar.f(adView.getHeight());
        setScrollClick(new View.OnTouchListener(this, dVar, iDip2px, str, aVar) { // from class: com.kc.cw.ad.internal.e.a.26

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            float f38996a;
            float b;
            float c;
            float d;
            float e;
            float f;
            final com.kc.cw.ad.a.d g;
            final int h;
            final String i;
            final k.a j;
            final a k;

            {
                this.k = this;
                this.g = dVar;
                this.h = iDip2px;
                this.i = str;
                this.j = aVar;
            }

            /* JADX WARN: Code duplicated, block: B:17:0x0062 A[PHI: r6
              0x0062: PHI (r6v38 com.kc.cw.ad.d.k$a) = (r6v25 com.kc.cw.ad.d.k$a), (r6v31 com.kc.cw.ad.d.k$a), (r6v37 com.kc.cw.ad.d.k$a), (r6v44 com.kc.cw.ad.d.k$a) binds: [B:43:0x00d7, B:34:0x00b1, B:25:0x008c, B:16:0x0060] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                k.a aVar2;
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f38996a = motionEvent.getX();
                    this.b = motionEvent.getY();
                    this.c = motionEvent.getX();
                    this.d = motionEvent.getY();
                    this.e = motionEvent.getRawX();
                    this.f = motionEvent.getRawY();
                    this.g.a((int) motionEvent.getRawX());
                    this.g.b((int) motionEvent.getRawY());
                    this.g.a(String.valueOf(System.currentTimeMillis()));
                    this.g.d(String.valueOf(System.currentTimeMillis()));
                    this.g.c(String.valueOf(System.currentTimeMillis() / 1000));
                } else if (action == 1) {
                    this.g.c((int) motionEvent.getRawX());
                    this.g.d((int) motionEvent.getRawY());
                    this.g.b(String.valueOf(System.currentTimeMillis()));
                    float f = this.d;
                    float f2 = this.b;
                    if (f - f2 <= 0.0f || Math.abs(f - f2) <= this.h) {
                        float f3 = this.d;
                        float f4 = this.b;
                        if (f3 - f4 >= 0.0f || Math.abs(f3 - f4) <= this.h) {
                            float f5 = this.c;
                            float f6 = this.f38996a;
                            if (f5 - f6 >= 0.0f || Math.abs(f5 - f6) <= this.h) {
                                float f7 = this.c;
                                float f8 = this.f38996a;
                                if (f7 - f8 < 0.0f && Math.abs(f7 - f8) > this.h && "right".equalsIgnoreCase(this.i) && (aVar2 = this.j) != null) {
                                    aVar2.a(this.g);
                                }
                            } else if ("left".equalsIgnoreCase(this.i) && (aVar2 = this.j) != null) {
                                aVar2.a(this.g);
                            }
                        } else if (ScrollClickView.DIR_UP.equalsIgnoreCase(this.i) && (aVar2 = this.j) != null) {
                            aVar2.a(this.g);
                        }
                    } else if (ScrollClickView.DIR_DOWN.equalsIgnoreCase(this.i) && (aVar2 = this.j) != null) {
                        aVar2.a(this.g);
                    }
                } else if (action == 2) {
                    this.c = motionEvent.getX();
                    this.d = motionEvent.getY();
                }
                return true;
            }
        });
    }

    public static boolean a(com.kc.cw.ad.internal.b.f fVar) {
        com.kc.cw.ad.a.c.w wVarL;
        com.kc.cw.ad.a.c.g gVarA;
        return (fVar == null || (wVarL = fVar.L()) == null || (gVarA = wVarL.a()) == null || gVarA.c() != 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.SSAdAlertDialogStyle);
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.ss_dialog_close_confirm, (ViewGroup) null);
            builder.setView(viewInflate);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_quit);
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_wait);
            textView.setText(String.format(Locale.US, "观看满 %d 秒即可获得奖励\n确认离开吗？", Integer.valueOf(this.af)));
            AlertDialog alertDialogCreate = builder.create();
            textView2.setOnClickListener(new View.OnClickListener(this, alertDialogCreate) { // from class: com.kc.cw.ad.internal.e.a.11

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final AlertDialog f38979a;
                final a b;

                {
                    this.b = this;
                    this.f38979a = alertDialogCreate;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f38979a.dismiss();
                    this.b.y();
                }
            });
            textView3.setOnClickListener(new View.OnClickListener(this, alertDialogCreate) { // from class: com.kc.cw.ad.internal.e.a.13

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final AlertDialog f38981a;
                final a b;

                {
                    this.b = this;
                    this.f38981a = alertDialogCreate;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f38981a.dismiss();
                }
            });
            alertDialogCreate.show();
            com.kc.cw.ad.d dVar = this.av;
            if (dVar != null) {
                dVar.m();
            } else {
                com.kc.cw.ad.b.a aVar = this.Q;
                if (aVar != null) {
                    aVar.b();
                }
            }
            alertDialogCreate.setOnDismissListener(new DialogInterface.OnDismissListener(this) { // from class: com.kc.cw.ad.internal.e.a.14

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final a f38982a;

                {
                    this.f38982a = this;
                }

                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (this.f38982a.av != null) {
                        this.f38982a.av.n();
                    } else if (this.f38982a.Q != null) {
                        this.f38982a.Q.c();
                    }
                }
            });
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    private void b(String str) {
        View adView;
        View viewA;
        try {
            if (this.aR == null || (adView = getAdView()) == null || (viewA = this.aR.a(ViewUtil.px2dip(getContext(), adView.getWidth()), ViewUtil.px2dip(getContext(), adView.getHeight()), str, true)) == null) {
                return;
            }
            viewA.setOnTouchListener(new View.OnTouchListener(this, new com.kc.cw.ad.a.d(1)) { // from class: com.kc.cw.ad.internal.e.a.22

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final com.kc.cw.ad.a.d f38992a;
                final a b;

                {
                    this.b = this;
                    this.f38992a = dVar;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    a aVar = this.b;
                    aVar.a(motionEvent, aVar.at, this.f38992a);
                    return true;
                }
            });
            ViewParent parent = adView instanceof FrameLayout ? (FrameLayout) adView : adView.getParent();
            if (parent instanceof FrameLayout) {
                ((FrameLayout) parent).addView(viewA);
            }
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.c("OctopusAd", "An Exception Caught: " + e.getMessage());
        }
    }

    private void c(int i) {
        try {
            View adView = getAdView();
            if (adView == null) {
                return;
            }
            ViewParent parent = adView instanceof FrameLayout ? (FrameLayout) adView : adView.getParent();
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.ss_countdown_click, (ViewGroup) null);
            int i2 = R.id.rl_auto;
            this.aa = (LinearLayout) viewInflate.findViewById(i2);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_auto);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_stop);
            this.aa.setVisibility(0);
            com.kc.cw.ad.b.a aVar = new com.kc.cw.ad.b.a(((long) i) * 1000, 50L);
            this.R = aVar;
            aVar.a(new com.kc.cw.ad.b.b(this, textView) { // from class: com.kc.cw.ad.internal.e.a.24

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final TextView f38994a;
                final a b;

                {
                    this.b = this;
                    this.f38994a = textView;
                }

                @Override // com.kc.cw.ad.b.b
                public void a() {
                    this.b.au = 3;
                    this.b.ap = true;
                    if (this.b.aw != null) {
                        this.b.aw.a(this.b.au, this.b.getRandomClickPosition());
                    }
                    this.b.G();
                }

                @Override // com.kc.cw.ad.b.b
                public void a(long j) {
                    int i3 = (int) ((j / 1000) + 1);
                    this.f38994a.setText(String.format(Locale.US, "%d秒后自动跳转详情页", Integer.valueOf(i3)));
                    if (i3 <= 3) {
                        this.f38994a.setBackgroundResource(R.drawable.ss_bg_common_orange);
                    }
                }

                @Override // com.kc.cw.ad.b.b
                public void b() {
                }
            });
            this.R.a();
            textView2.setOnClickListener(new View.OnClickListener(this) { // from class: com.kc.cw.ad.internal.e.a.25

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final a f38995a;

                {
                    this.f38995a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f38995a.G();
                }
            });
            viewInflate.findViewById(i2).setVisibility(0);
            q qVarA = q.a();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
            layoutParams.setMargins(0, 0, 0, (int) TypedValue.applyDimension(1, 50.0f, qVarA.r()));
            if (parent instanceof FrameLayout) {
                ((FrameLayout) parent).addView(viewInflate, layoutParams);
            }
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.c("OctopusAd", "An Exception Caught: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        o.a(new com.kc.cw.ad.internal.l("REWARD", getAdSlotId(), getRequestId(), System.currentTimeMillis() - getExposeTime(), z ? 1 : 0, this.aE));
    }

    private void e(boolean z) {
        com.kc.cw.ad.d.b.f.a("OctopusAd", "octopus clickable = " + z);
        if (z) {
            return;
        }
        a(new View.OnTouchListener(this) { // from class: com.kc.cw.ad.internal.e.a.20

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final a f38990a;

            {
                this.f38990a = this;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getAdView() {
        com.kc.cw.ad.d dVar = this.av;
        if (dVar != null) {
            return dVar;
        }
        com.kc.cw.ad.internal.e.b bVar = this.aw;
        if (bVar != null) {
            return bVar.c;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kc.cw.ad.a.d getRandomClickPosition() {
        int screenWidth;
        int screenHeight;
        try {
            if (this.aq || this.ar) {
                screenWidth = ViewUtil.getScreenWidth(getContext());
                screenHeight = ViewUtil.getScreenHeight(getContext());
            } else {
                View adView = getAdView();
                if (adView != null) {
                    screenWidth = adView.getWidth();
                    screenHeight = adView.getHeight();
                } else {
                    screenWidth = 0;
                    screenHeight = 0;
                }
                if (screenWidth == 0 || screenHeight == 0) {
                    screenWidth = ViewUtil.getScreenWidth(getContext());
                    screenHeight = ViewUtil.getScreenWidth(getContext());
                }
            }
            int iA = i.a(screenWidth);
            int iA2 = i.a(screenHeight);
            int iA3 = i.a(150);
            com.kc.cw.ad.a.d dVar = new com.kc.cw.ad.a.d(1);
            dVar.a(iA);
            dVar.b(iA2);
            dVar.a(String.valueOf(System.currentTimeMillis()));
            dVar.d(String.valueOf(System.currentTimeMillis()));
            dVar.c(String.valueOf(System.currentTimeMillis() / 1000));
            dVar.c(iA);
            dVar.d(iA2);
            dVar.b(String.valueOf(System.currentTimeMillis() + ((long) (iA3 + 50))));
            dVar.e(screenWidth);
            dVar.f(screenHeight);
            return dVar;
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
            return null;
        }
    }

    private void u() {
        try {
            a(this.f38976a, this.aW);
            a(0, 30, 0, 0);
            int iH = this.ah;
            if (iH < 3) {
                iH = this.aw.h();
            }
            a(iH);
            ViewGroup viewGroup = this.u;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                this.u.addView(this, new ViewGroup.LayoutParams(-1, -1));
            }
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        com.kc.cw.ad.internal.b.f fVar;
        com.kc.cw.ad.a.c.w wVarL;
        com.kc.cw.ad.a.c.p pVarC;
        if (this.aq || (fVar = this.f38976a) == null || (wVarL = fVar.L()) == null || (pVarC = wVarL.c()) == null) {
            return;
        }
        if (pVarC.a() == 1) {
            this.aq = true;
            this.f38976a.c(true);
            new Handler().postDelayed(new Runnable(this) { // from class: com.kc.cw.ad.internal.e.a.30

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final a f39001a;

                {
                    this.f39001a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f39001a.z();
                }
            }, pVarC.c());
            if (pVarC.b() == 1) {
                com.kc.cw.ad.internal.k.a aVar = new com.kc.cw.ad.internal.k.a(this) { // from class: com.kc.cw.ad.internal.e.a.31

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final a f39002a;

                    {
                        this.f39002a = this;
                    }

                    @Override // com.kc.cw.ad.internal.k.a
                    public void a(String str) {
                        if ("AppBackground".equals(str)) {
                            this.f39002a.M = true;
                        }
                    }
                };
                com.kc.cw.ad.internal.k.a().a(aVar);
                new Handler().postDelayed(new Runnable(this, aVar) { // from class: com.kc.cw.ad.internal.e.a.32

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final com.kc.cw.ad.internal.k.a f39003a;
                    final a b;

                    {
                        this.b = this;
                        this.f39003a = aVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (!this.b.M) {
                            this.b.x();
                        }
                        com.kc.cw.ad.internal.k.a().b(this.f39003a);
                    }
                }, pVarC.d());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        com.kc.cw.ad.a.c.w wVarL;
        com.kc.cw.ad.a.c.p pVarC;
        com.kc.cw.ad.internal.b.f fVar = this.f38976a;
        if (fVar == null || (wVarL = fVar.L()) == null || (pVarC = wVarL.c()) == null) {
            return;
        }
        if (pVarC.a() == 1) {
            this.f38976a.d(true);
            new Handler().postDelayed(new Runnable(this) { // from class: com.kc.cw.ad.internal.e.a.33

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final a f39004a;

                {
                    this.f39004a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f39004a.z();
                }
            }, pVarC.c());
            if (pVarC.b() == 1) {
                com.kc.cw.ad.internal.k.a aVar = new com.kc.cw.ad.internal.k.a(this) { // from class: com.kc.cw.ad.internal.e.a.34

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final a f39005a;

                    {
                        this.f39005a = this;
                    }

                    @Override // com.kc.cw.ad.internal.k.a
                    public void a(String str) {
                        if ("AppBackground".equals(str)) {
                            this.f39005a.M = true;
                        }
                    }
                };
                com.kc.cw.ad.internal.k.a().a(aVar);
                new Handler().postDelayed(new Runnable(this, aVar) { // from class: com.kc.cw.ad.internal.e.a.2

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final com.kc.cw.ad.internal.k.a f38989a;
                    final a b;

                    {
                        this.b = this;
                        this.f38989a = aVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (!this.b.M) {
                            this.b.x();
                        }
                        com.kc.cw.ad.internal.k.a().b(this.f38989a);
                    }
                }, pVarC.d());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        com.kc.cw.ad.internal.b.f fVar;
        int i;
        if (this.aw == null || (fVar = this.f38976a) == null) {
            return;
        }
        if (a(fVar)) {
            i = 0;
            this.ap = false;
        } else {
            this.ap = true;
            i = 9;
        }
        this.au = i;
        this.aw.a(this.au, getRandomClickPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (!this.am || this.ao) {
            A();
            return;
        }
        this.au = 2;
        com.kc.cw.ad.d dVar = this.av;
        if (dVar != null) {
            dVar.setOpt(2);
        } else {
            com.kc.cw.ad.internal.e.b bVar = this.aw;
            if (bVar != null) {
                bVar.c(2);
            }
        }
        a(getRandomClickPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        com.kc.cw.ad.internal.b.f fVar = this.f38976a;
        if (fVar != null) {
            fVar.a(g(), (com.kc.cw.ad.a) null);
        }
    }

    public Context a(View view) {
        if (view == null) {
            return null;
        }
        Context baseContext = view.getContext() instanceof MutableContextWrapper ? ((MutableContextWrapper) view.getContext()).getBaseContext() : getContext();
        if (baseContext instanceof Activity) {
            return baseContext;
        }
        return null;
    }

    public void a(int i) {
        try {
            com.kc.cw.ad.b.a aVar = this.Q;
            if (aVar != null) {
                aVar.d();
            }
            if (i <= 0) {
                this.af = 5;
            } else {
                this.af = i;
            }
            this.N = ViewUtil.createCountDown(getContext(), this.af, this.l, this.m, this.x);
            com.kc.cw.ad.b.a aVar2 = new com.kc.cw.ad.b.a(((long) this.af) * 1000, 50L);
            this.Q = aVar2;
            aVar2.a(new com.kc.cw.ad.b.b(this) { // from class: com.kc.cw.ad.internal.e.a.7

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final a f39009a;

                {
                    this.f39009a = this;
                }

                @Override // com.kc.cw.ad.b.b
                public void a() {
                    try {
                        if (this.f39009a.N != null) {
                            this.f39009a.N.setText("跳过 0");
                        }
                        C1008a c1008a = this.f39009a.b;
                        if (c1008a != null) {
                            c1008a.a(true);
                            if (this.f39009a.b.a()) {
                                if (this.f39009a.b.c() == C1008a.EnumC1009a.UNCHANGE || this.f39009a.b.c() == C1008a.EnumC1009a.STATE_PREPARE_CHANGE) {
                                    this.f39009a.L = true;
                                    if (this.f39009a.getAdDispatcher() != null) {
                                        this.f39009a.getAdDispatcher().a();
                                    }
                                }
                            }
                        }
                    } catch (Exception unused) {
                    }
                }

                @Override // com.kc.cw.ad.b.b
                public void a(long j) {
                    try {
                        if (this.f39009a.N == null) {
                            return;
                        }
                        this.f39009a.getAdDispatcher().a(j);
                        this.f39009a.N.setText(String.format(Locale.US, "跳过 %d", Integer.valueOf((int) ((j / 1000) + 1))));
                    } catch (Exception unused) {
                    }
                }

                @Override // com.kc.cw.ad.b.b
                public void b() {
                }
            });
            this.Q.a();
            com.kc.cw.ad.internal.b.f fVar = this.f38976a;
            if (fVar != null) {
                this.am = fVar.T();
                this.f38976a.a(this.Q);
            }
            this.N.setOnClickListener(new View.OnClickListener(this) { // from class: com.kc.cw.ad.internal.e.a.8

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final a f39010a;

                {
                    this.f39010a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f39010a.y();
                }
            });
            AppCompatTextView appCompatTextView = this.N;
            if (appCompatTextView != null) {
                ViewUtil.removeChildFromParent(appCompatTextView);
                addView(this.N);
            }
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public void a(int i, int i2, int i3) {
        try {
            ViewUtil.removeChildFromParent(this.P);
            ViewUtil.removeChildFromParent(this.N);
            com.kc.cw.ad.b.a aVar = this.Q;
            if (aVar != null) {
                aVar.d();
            }
            if (this.P == null) {
                ImageView imageViewCreateImageCloseButton = ViewUtil.createImageCloseButton(getContext(), this.l, 1.0f);
                this.P = imageViewCreateImageCloseButton;
                imageViewCreateImageCloseButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.kc.cw.ad.internal.e.a.9

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final a f39011a;

                    {
                        this.f39011a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!this.f39011a.aH) {
                            View adView = this.f39011a.getAdView();
                            if (adView == null) {
                                return;
                            }
                            if (this.f39011a.af > 0) {
                                this.f39011a.b(adView.getContext());
                                return;
                            }
                        }
                        this.f39011a.y();
                    }
                });
            }
            if (i != -1 && this.N == null) {
                this.m = 30;
                this.af = Math.min(i, i3);
                this.N = ViewUtil.createCountDown(getContext(), this.af, this.l, this.m, this.x);
                if (i2 > 0) {
                    this.P.setVisibility(8);
                    int i4 = this.af;
                    if (i4 > i2) {
                        this.ag = i4 - i2;
                    }
                }
                com.kc.cw.ad.b.a aVar2 = new com.kc.cw.ad.b.a(((long) this.af) * 1000, 50L);
                this.Q = aVar2;
                aVar2.a(new com.kc.cw.ad.b.b(this) { // from class: com.kc.cw.ad.internal.e.a.10

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final a f38978a;

                    {
                        this.f38978a = this;
                    }

                    @Override // com.kc.cw.ad.b.b
                    public void a() {
                        a aVar3 = this.f38978a;
                        if (aVar3.r) {
                            return;
                        }
                        if (aVar3.P != null) {
                            this.f38978a.P.setVisibility(0);
                        }
                        this.f38978a.q();
                        this.f38978a.p();
                        com.kc.cw.ad.internal.b.f fVar = this.f38978a.f38976a;
                        if (fVar != null && fVar.C()) {
                            this.f38978a.L = true;
                            this.f38978a.A();
                        } else if (this.f38978a.av == null) {
                            this.f38978a.t();
                        }
                    }

                    @Override // com.kc.cw.ad.b.b
                    public void a(long j) {
                        a aVar3 = this.f38978a;
                        if (aVar3.r || aVar3.N == null || this.f38978a.P == null || this.f38978a.aH) {
                            return;
                        }
                        int i5 = (int) ((j / 1000) + 1);
                        this.f38978a.N.setText(String.format(Locale.US, "奖励将于 %d 秒后发放", Integer.valueOf(i5)));
                        if (i5 <= this.f38978a.ag && this.f38978a.P.getVisibility() == 8) {
                            this.f38978a.P.setVisibility(0);
                        }
                        if (this.f38978a.af - i5 == 2 && this.f38978a.ak) {
                            this.f38978a.H();
                        }
                    }

                    @Override // com.kc.cw.ad.b.b
                    public void b() {
                    }
                });
                this.Q.a();
                com.kc.cw.ad.d dVar = this.av;
                if (dVar != null) {
                    dVar.setCountDownTimer(this.Q);
                }
            }
            View adView = getAdView();
            if (adView == null) {
                return;
            }
            ViewParent parent = adView instanceof FrameLayout ? (FrameLayout) adView : adView.getParent();
            if (parent instanceof FrameLayout) {
                ImageView imageView = this.P;
                if (imageView != null) {
                    ((FrameLayout) parent).addView(imageView);
                }
                AppCompatTextView appCompatTextView = this.N;
                if (appCompatTextView != null) {
                    ((FrameLayout) parent).addView(appCompatTextView);
                }
            }
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        this.k = i;
        this.l = i2;
        this.m = i3;
        this.n = i4;
    }

    public void a(int i, int i2, View view) {
        try {
            ViewUtil.removeChildFromParent(this.P);
            ViewUtil.removeChildFromParent(this.N);
            if (this.P == null) {
                ImageView imageViewCreateImageCloseButton = ViewUtil.createImageCloseButton(getContext(), this.l, this.x);
                this.P = imageViewCreateImageCloseButton;
                imageViewCreateImageCloseButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.kc.cw.ad.internal.e.a.5

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final a f39007a;

                    {
                        this.f39007a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        this.f39007a.y();
                    }
                });
            }
            if (i2 > 0) {
                this.af = i2;
            } else if (i > 0) {
                this.af = i;
            }
            if (this.af > 0) {
                this.P.setVisibility(8);
                this.N = ViewUtil.createInterstitialCountDown(getContext(), this.l, this.x);
                com.kc.cw.ad.b.a aVar = new com.kc.cw.ad.b.a(((long) this.af) * 1000, 50L);
                this.Q = aVar;
                aVar.a(new com.kc.cw.ad.b.b(this) { // from class: com.kc.cw.ad.internal.e.a.6

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final a f39008a;

                    {
                        this.f39008a = this;
                    }

                    @Override // com.kc.cw.ad.b.b
                    public void a() {
                        com.kc.cw.ad.internal.b.f fVar = this.f39008a.f38976a;
                        if (fVar != null && fVar.C()) {
                            if (this.f39008a.N != null) {
                                this.f39008a.N.setText("0");
                            }
                            this.f39008a.L = true;
                            this.f39008a.A();
                            return;
                        }
                        if (this.f39008a.N == null || this.f39008a.P == null) {
                            return;
                        }
                        this.f39008a.N.setVisibility(8);
                        this.f39008a.P.setVisibility(0);
                    }

                    @Override // com.kc.cw.ad.b.b
                    public void a(long j) {
                        if (this.f39008a.N == null) {
                            return;
                        }
                        this.f39008a.N.setText(String.valueOf((int) ((j / 1000) + 1)));
                    }

                    @Override // com.kc.cw.ad.b.b
                    public void b() {
                    }
                });
                this.Q.a();
            }
            ViewParent parent = view instanceof FrameLayout ? (FrameLayout) view : view.getParent();
            if (parent instanceof FrameLayout) {
                ImageView imageView = this.P;
                if (imageView != null) {
                    ((FrameLayout) parent).addView(imageView);
                }
                AppCompatTextView appCompatTextView = this.N;
                if (appCompatTextView != null) {
                    ((FrameLayout) parent).addView(appCompatTextView);
                }
            }
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public void a(Context context) {
    }

    public void a(Context context, AttributeSet attributeSet) {
        com.kc.cw.ad.d.b.f.c("OctopusAd_Time", "AdViewImpl setup 开始 mRequestId : " + this.aD);
        setBackgroundColor(0);
        this.E = new b(this, this.D);
        this.aD = com.kc.cw.ad.internal.c.p.a();
        this.d = new com.kc.cw.ad.internal.d(context, this.aD);
        try {
            com.kc.cw.ad.internal.c.f.a(getContext().getApplicationContext());
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
        }
        setPadding(0, 0, 0, 0);
        this.f = new com.kc.cw.ad.internal.c(this);
        this.aP = new l(getContext());
        this.aQ = new k(getContext());
        this.aR = new j(getContext());
    }

    public void a(View.OnTouchListener onTouchListener) {
        View adView = getAdView();
        if (adView == null) {
            return;
        }
        adView.setOnTouchListener(onTouchListener);
    }

    public void a(ViewGroup viewGroup) {
        try {
            if ((this.p && !this.o) || !this.s) {
                this.q = true;
                this.aA = viewGroup;
                return;
            }
            if (this.az) {
                return;
            }
            this.az = true;
            ViewUtil.removeChildFromParent(this);
            if (viewGroup != null) {
                this.u = viewGroup;
            }
            com.kc.cw.ad.internal.b.f fVar = this.f38976a;
            if (fVar != null) {
                fVar.b();
                this.at = this.f38976a.S();
                this.am = this.f38976a.T();
                this.as = this.f38976a.R();
                Log.e("OctopusAd", "enter Octopus ad show");
                this.f38976a.a(g(), new com.kc.cw.ad.a(this) { // from class: com.kc.cw.ad.internal.e.a.12

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final a f38980a;

                    {
                        this.f38980a = this;
                    }

                    @Override // com.kc.cw.ad.a
                    public void a(boolean z) {
                        this.f38980a.a(z);
                    }
                });
            }
            u();
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.c("OctopusAd", "An Exception Caught: " + e.getMessage());
        }
    }

    public void a(com.kc.cw.ad.a.d dVar) {
        com.kc.cw.ad.internal.e.b bVar = this.aw;
        if (bVar != null) {
            bVar.a(this.au, dVar);
        }
    }

    public void a(com.kc.cw.ad.d dVar) {
        try {
            ProgressBar progressBar = this.U;
            if (progressBar == null) {
                this.U = ViewUtil.createLoadingView(getContext(), this.x);
                ViewParent parent = dVar.getParent();
                if (parent instanceof FrameLayout) {
                    ((FrameLayout) parent).addView(this.U);
                }
            } else {
                progressBar.setVisibility(0);
            }
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.c("OctopusAd", "An Exception Caught: " + e.getMessage());
        }
    }

    public void a(com.kc.cw.ad.d dVar, boolean z) {
        try {
            ViewUtil.removeChildFromParent(this.S);
            AppCompatImageView appCompatImageViewCreateMuteButton = ViewUtil.createMuteButton(getContext(), z, this.l, this.x);
            this.S = appCompatImageViewCreateMuteButton;
            appCompatImageViewCreateMuteButton.setOnClickListener(new View.OnClickListener(this, dVar) { // from class: com.kc.cw.ad.internal.e.a.4

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final com.kc.cw.ad.d f39006a;
                final a b;

                {
                    this.b = this;
                    this.f39006a = dVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.kc.cw.ad.d dVar2;
                    if (this.b.S == null || (dVar2 = this.f39006a) == null) {
                        return;
                    }
                    this.b.S.setImageResource(dVar2.g() ? R.drawable.ss_voice_off : R.drawable.ss_voice_on);
                }
            });
            ViewParent parent = dVar.getParent();
            if (parent instanceof FrameLayout) {
                ((FrameLayout) parent).addView(this.S);
            }
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public void a(AdLogoInfo adLogoInfo, int i) {
        try {
            ViewUtil.removeChildFromParent(this.V);
            ViewUtil.removeChildFromParent(this.W);
            float f = 1.0f;
            float f2 = i > 0 ? i / 640.0f : 1.0f;
            if (f2 <= 1.0f) {
                f = f2;
            }
            if (!TextUtils.isEmpty(adLogoInfo.getAdurl())) {
                this.W = ViewUtil.createLogoImageView(new MutableContextWrapper(getContext()), adLogoInfo, 6, f);
            }
            AdLogoInfo adLogoInfo2 = new AdLogoInfo();
            adLogoInfo2.setType(AdLogoInfo.TYPE_TEXT);
            adLogoInfo2.setAdurl("广告");
            if (TextUtils.isEmpty(adLogoInfo2.getAdurl())) {
                return;
            }
            this.V = ViewUtil.createAdImageView(new MutableContextWrapper(getContext()), adLogoInfo2, 3, GravityCompat.END, f);
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.c("OctopusAd", "An Exception Caught: " + e.getMessage());
        }
    }

    public void a(AdLogoInfo adLogoInfo, AdLogoInfo adLogoInfo2, int i) {
        try {
            ViewUtil.removeChildFromParent(this.V);
            ViewUtil.removeChildFromParent(this.W);
            float f = 1.0f;
            float f2 = i > 0 ? i / 640.0f : 1.0f;
            if (f2 <= 1.0f) {
                f = f2;
            }
            if (!TextUtils.isEmpty(adLogoInfo.getAdurl())) {
                this.V = ViewUtil.createAdImageView(new MutableContextWrapper(getContext()), adLogoInfo, 0, GravityCompat.START, f);
            }
            if (TextUtils.isEmpty(adLogoInfo2.getAdurl())) {
                return;
            }
            this.W = ViewUtil.createLogoImageView(new MutableContextWrapper(getContext()), adLogoInfo2, 0, f);
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.c("OctopusAd", "An Exception Caught: " + e.getMessage());
        }
    }

    public void a(ComplianceInfo complianceInfo, float f) {
        this.T = ViewUtil.createComplianceView(getContext(), complianceInfo, f, false);
    }

    public void a(String str, int i) {
        RewardVideoAdListener rewardVideoAdListener;
        if (!this.J || (rewardVideoAdListener = this.B) == null) {
            return;
        }
        rewardVideoAdListener.onRewarded(new v(str, i));
    }

    public void a(HashMap map) {
        if (!map.isEmpty() && map.containsKey("REWARD_ITEM")) {
            String str = (String) map.get("REWARD_ITEM");
            try {
                if (str == null) {
                    this.aG = Pair.create("", 0);
                    return;
                }
                JSONObject jSONObject = new JSONObject(str);
                this.aE = jSONObject.optString("callback_url");
                this.aG = Pair.create(jSONObject.optString("name"), Integer.valueOf(jSONObject.optInt("amount")));
                if (TextUtils.isEmpty(this.aE) || getAdParameters() == null) {
                    return;
                }
                String extraData = getExtraData();
                if (!TextUtils.isEmpty(extraData)) {
                    this.aE += "&extra=" + extraData;
                }
                String userId = getUserId();
                if (TextUtils.isEmpty(userId)) {
                    return;
                }
                this.aE += "&userId=" + userId;
            } catch (JSONException unused) {
                com.kc.cw.ad.internal.c.f.e(com.kc.cw.ad.internal.c.f.h, "Error parse reward item: " + str);
                this.aG = Pair.create("", 0);
            }
        }
    }

    public void a(boolean z) {
        com.kc.cw.ad.internal.b.f fVar;
        if (this.I) {
            return;
        }
        this.I = true;
        this.J = z;
        if (z && (fVar = this.f38976a) != null) {
            this.J = fVar.Q();
        }
        if (this.J) {
            SplashAdListener splashAdListener = this.y;
            if (splashAdListener != null) {
                splashAdListener.onAdShown();
            } else {
                InterstitialAdListener interstitialAdListener = this.z;
                if (interstitialAdListener != null) {
                    interstitialAdListener.onAdShown();
                } else {
                    FullScreenVideoAdListener fullScreenVideoAdListener = this.A;
                    if (fullScreenVideoAdListener != null) {
                        fullScreenVideoAdListener.onAdShown();
                    } else {
                        RewardVideoAdListener rewardVideoAdListener = this.B;
                        if (rewardVideoAdListener != null) {
                            rewardVideoAdListener.onRewardVideoAdShown();
                        }
                    }
                }
            }
        }
        com.kc.cw.ad.internal.b.f fVar2 = this.f38976a;
        if (fVar2 != null) {
            fVar2.a(this.C, this.J);
        }
        if (this.C != null && getRequestId().equals(this.C.a())) {
            q.a().l.remove(this.C.b());
        }
        B();
    }

    @Override // com.kc.cw.ad.internal.a
    public boolean a() {
        com.kc.cw.ad.internal.d dVar = this.d;
        return (dVar == null || !dVar.q() || this.e == null) ? false : true;
    }

    public boolean a(com.kc.cw.ad.internal.b.a.C1001a c1001a) {
        com.kc.cw.ad.internal.c cVar;
        this.e = c1001a;
        if (!a()) {
            SplashAdListener splashAdListener = this.y;
            if (splashAdListener != null) {
                splashAdListener.onAdFailedToLoad(80000);
            } else {
                InterstitialAdListener interstitialAdListener = this.z;
                if (interstitialAdListener != null) {
                    interstitialAdListener.onAdFailedToLoad(80000);
                } else {
                    FullScreenVideoAdListener fullScreenVideoAdListener = this.A;
                    if (fullScreenVideoAdListener != null) {
                        fullScreenVideoAdListener.onAdFailedToLoad(80000);
                    } else {
                        RewardVideoAdListener rewardVideoAdListener = this.B;
                        if (rewardVideoAdListener != null) {
                            rewardVideoAdListener.onRewardVideoAdFailedToLoad(80000);
                        }
                    }
                }
            }
            return false;
        }
        if (getWindowVisibility() == 0 && (cVar = this.f) != null) {
            cVar.a();
            this.f.c();
            this.f.a(this.aB);
            this.H = true;
            this.i = 1;
            this.j = 0;
            return true;
        }
        com.kc.cw.ad.internal.c cVar2 = this.f;
        if (cVar2 != null) {
            cVar2.a();
            this.f.c();
            this.f.a(this.aB);
            this.H = true;
            this.i = 1;
            this.j = 0;
        }
        return false;
    }

    public abstract boolean a(com.kc.cw.ad.internal.e.c cVar);

    public Activity b(View view) {
        return (Activity) a(view);
    }

    public void b(int i) {
        if (this.aX) {
            return;
        }
        SplashAdListener splashAdListener = this.y;
        if (splashAdListener != null) {
            splashAdListener.onAdFailedToLoad(i);
        } else {
            InterstitialAdListener interstitialAdListener = this.z;
            if (interstitialAdListener != null) {
                interstitialAdListener.onAdFailedToLoad(i);
            } else {
                FullScreenVideoAdListener fullScreenVideoAdListener = this.A;
                if (fullScreenVideoAdListener != null) {
                    fullScreenVideoAdListener.onAdFailedToLoad(i);
                } else {
                    RewardVideoAdListener rewardVideoAdListener = this.B;
                    if (rewardVideoAdListener != null) {
                        rewardVideoAdListener.onRewardVideoAdFailedToLoad(i);
                    }
                }
            }
        }
        this.aX = true;
    }

    public void b(boolean z) {
        com.kc.cw.ad.internal.b.f fVar;
        if (this.o || (fVar = this.f38976a) == null || fVar.r() != 0) {
            return;
        }
        this.o = true;
        SplashAdListener splashAdListener = this.y;
        if (splashAdListener != null) {
            splashAdListener.onAdCacheLoaded(z);
            return;
        }
        InterstitialAdListener interstitialAdListener = this.z;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdCacheLoaded(z);
            return;
        }
        FullScreenVideoAdListener fullScreenVideoAdListener = this.A;
        if (fullScreenVideoAdListener != null) {
            fullScreenVideoAdListener.onAdCacheLoaded(z);
            return;
        }
        RewardVideoAdListener rewardVideoAdListener = this.B;
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onRewardVideoCached(z);
        }
    }

    public boolean b() {
        return p.SPLASH == this.g;
    }

    public void c(View view) {
        try {
            ViewUtil.removeChildFromParent(this.V);
            ViewUtil.removeChildFromParent(this.W);
            ViewParent parent = view instanceof FrameLayout ? (FrameLayout) view : view.getParent();
            if (parent instanceof FrameLayout) {
                if (this.V != null) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 42, 8388691);
                    layoutParams.setMargins(30, 0, 0, 50);
                    ((FrameLayout) parent).addView(this.V, layoutParams);
                    this.V.setVisibility(0);
                }
                if (this.W != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, 42, 8388693);
                    layoutParams2.setMargins(0, 0, 30, 50);
                    ((FrameLayout) parent).addView(this.W, layoutParams2);
                    this.W.setVisibility(0);
                }
            }
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.c("OctopusAd", "An Exception Caught: " + e.getMessage());
        }
    }

    public void c(boolean z) {
        setOpensNativeBrowser(z);
    }

    public boolean c() {
        return p.INTERSTITIAL == this.g;
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void cancel() {
        destroy();
    }

    public void d(View view) {
        try {
            ViewUtil.removeChildFromParent(this.O);
            this.l = getMediaType() == p.INTERSTITIAL ? 10 : 30;
            this.k = this.av == null ? 0 : 30;
            this.aF = com.kc.cw.ad.internal.c.q.a("https://www.adintl.cn/sdkFeedback.html?slotId=${SLOT_ID}&sdkVersion=${SDK_VERSION}&deviceId=${DEVICE_ID}", getAdSlotId(), SSAd.getOaid(getContext()));
            AppCompatTextView appCompatTextViewCreateFeedBackButton = ViewUtil.createFeedBackButton(getContext(), this.aF, this.k, this.l, this.x);
            this.O = appCompatTextViewCreateFeedBackButton;
            appCompatTextViewCreateFeedBackButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.kc.cw.ad.internal.e.a.3

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final a f39000a;

                {
                    this.f39000a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    ViewUtil.openLocalBrowser(this.f39000a.aF, 0);
                    com.kc.cw.ad.internal.b.f fVar = this.f39000a.f38976a;
                    if (fVar != null) {
                        fVar.c();
                    }
                }
            });
            ViewParent parent = view instanceof FrameLayout ? (FrameLayout) view : view.getParent();
            if (parent instanceof FrameLayout) {
                ((FrameLayout) parent).addView(this.O);
            }
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.c("OctopusAd", "An Exception Caught: " + e.getMessage());
        }
    }

    public boolean d() {
        return p.REWARD == this.g;
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void destroy() {
        com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.f38946a, "called destroy() on AdView");
        G();
        if (this.aU != null) {
            com.kc.cw.ad.internal.k.a().b(this.aU);
        }
        if (this.aV != null) {
            com.kc.cw.ad.internal.k.a().b(this.aV);
        }
        com.kc.cw.ad.internal.b.f fVar = this.f38976a;
        if (fVar != null) {
            fVar.al();
        }
        com.kc.cw.ad.internal.c cVar = this.f;
        if (cVar != null) {
            cVar.b();
            this.f.a();
            this.f = null;
        }
        com.kc.cw.ad.internal.e.c cVar2 = this.c;
        if (cVar2 != null) {
            cVar2.k();
            this.c = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0041  */
    public void e(View view) {
        int i;
        try {
            AppCompatTextView appCompatTextView = this.T;
            if (appCompatTextView != null) {
                ViewUtil.removeChildFromParent(appCompatTextView);
                ViewParent parent = view instanceof FrameLayout ? (FrameLayout) view : view.getParent();
                if (parent instanceof FrameLayout) {
                    com.kc.cw.ad.internal.b.f fVar = this.f38976a;
                    if (fVar != null) {
                        int iP = fVar.p();
                        if (!getMediaType().equals(p.INTERSTITIAL) || iP <= 0) {
                            i = -1;
                        } else {
                            i = (int) (iP * q.a().t);
                            int screenWidth = ViewUtil.getScreenWidth(getContext());
                            if (i > screenWidth) {
                                i = screenWidth;
                            }
                        }
                    } else {
                        i = -1;
                    }
                    ((FrameLayout) parent).addView(this.T, new FrameLayout.LayoutParams(i, -2, 80));
                }
            }
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.c("OctopusAd", "An Exception Caught: " + e.getMessage());
        }
    }

    public boolean e() {
        return p.FULLSCREEN == this.g;
    }

    public boolean f() {
        return this.ay;
    }

    public boolean g() {
        long jCurrentTimeMillis;
        long jG;
        com.kc.cw.ad.internal.d dVar = this.d;
        if (dVar == null || dVar.g() <= 0) {
            jCurrentTimeMillis = System.currentTimeMillis();
            jG = this.ai;
        } else {
            jCurrentTimeMillis = System.currentTimeMillis();
            jG = this.d.g();
        }
        return jCurrentTimeMillis - jG <= this.aj;
    }

    public com.kc.cw.ad.internal.b getAdDispatcher() {
        return this.E;
    }

    public com.kc.cw.ad.internal.d getAdParameters() {
        return this.d;
    }

    public com.kc.cw.ad.internal.b.a.C1001a getAdRequest() {
        return this.e;
    }

    public com.kc.cw.ad.b getAdSize() {
        return new com.kc.cw.ad.b(this.v, this.w);
    }

    public String getAdSlotId() {
        com.kc.cw.ad.internal.d dVar = this.d;
        return dVar == null ? "" : dVar.c();
    }

    public long getExposeTime() {
        com.kc.cw.ad.internal.d dVar = this.d;
        return dVar != null ? dVar.i() : System.currentTimeMillis();
    }

    public String getExtraData() {
        return this.ad;
    }

    public Map<String, Object> getMediaExtraInfo() {
        com.kc.cw.ad.internal.b.f fVar = this.f38976a;
        return fVar != null ? fVar.ab() : Collections.emptyMap();
    }

    public boolean getOpensNativeBrowser() {
        return this.d.o();
    }

    public int getPrice() {
        return this.ab;
    }

    public String getRequestId() {
        com.kc.cw.ad.internal.d dVar = this.d;
        return (dVar == null || TextUtils.isEmpty(dVar.f())) ? this.aD : this.d.f();
    }

    public ShakeValue getShakeValue() {
        com.kc.cw.ad.internal.b.f fVar = this.f38976a;
        if (fVar != null) {
            return fVar.aa();
        }
        return null;
    }

    public ViewGroup getSplashParent() {
        return this.u;
    }

    public String getTagId() {
        return this.ac;
    }

    public String getUserId() {
        return this.ae;
    }

    public VideoStateListener getVideoStateListener() {
        return this.aT;
    }

    public void h() {
        o.a(new com.kc.cw.ad.internal.l("LOAD", getAdSlotId(), getRequestId()));
    }

    public void i() {
        ProgressBar progressBar = this.U;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public boolean j() {
        return this.H;
    }

    public abstract boolean k();

    public void l() {
        if (this.ay) {
            return;
        }
        this.ay = true;
        this.ai = System.currentTimeMillis();
        SplashAdListener splashAdListener = this.y;
        if (splashAdListener != null) {
            splashAdListener.onAdLoaded();
        } else {
            InterstitialAdListener interstitialAdListener = this.z;
            if (interstitialAdListener != null) {
                interstitialAdListener.onAdLoaded();
            } else {
                FullScreenVideoAdListener fullScreenVideoAdListener = this.A;
                if (fullScreenVideoAdListener != null) {
                    fullScreenVideoAdListener.onAdLoaded();
                } else {
                    RewardVideoAdListener rewardVideoAdListener = this.B;
                    if (rewardVideoAdListener != null) {
                        rewardVideoAdListener.onRewardVideoAdLoaded();
                    }
                }
            }
        }
        D();
    }

    public void m() {
        if (this.aL || this.f38976a == null) {
            return;
        }
        if (d() || e()) {
            this.aL = true;
            com.kc.cw.ad.a.c.y yVarK = this.f38976a.k();
            if (yVarK == null || yVarK.a() != 1) {
                return;
            }
            c(yVarK.b());
        }
    }

    public void n() {
        if (TextUtils.isEmpty(this.aC)) {
            return;
        }
        ThreadUtils.runOnThreadPool(new Runnable(this) { // from class: com.kc.cw.ad.internal.e.a.16

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final a f38984a;

            {
                this.f38984a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.kc.cw.ad.internal.d.h hVarB = q.a().b();
                if (hVarB == null || hVarB.b(this.f38984a.aC)) {
                    return;
                }
                InputStream inputStreamOpenStream = null;
                try {
                    try {
                        inputStreamOpenStream = new URL(hVarB.a(this.f38984a.aC)).openStream();
                        while (inputStreamOpenStream.read(new byte[1024]) != -1) {
                        }
                        inputStreamOpenStream.close();
                    } catch (Exception unused) {
                        this.f38984a.b(false);
                        com.kc.cw.ad.internal.c.f.a(com.kc.cw.ad.internal.c.f.f38946a, "preload fail:" + this.f38984a.aC);
                        if (inputStreamOpenStream == null) {
                            return;
                        }
                    }
                    try {
                        inputStreamOpenStream.close();
                    } catch (Exception e) {
                        com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
                    }
                } catch (Throwable th) {
                    if (inputStreamOpenStream != null) {
                        try {
                            inputStreamOpenStream.close();
                        } catch (Exception e2) {
                            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e2);
                        }
                    }
                    throw th;
                }
            }
        });
    }

    public void o() {
        if (this.q) {
            if (this.g == p.SPLASH) {
                a(this.aA);
            } else {
                a(this.t);
            }
        }
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void onCreateLifeCycle() {
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void onDestroyLifeCycle() {
        com.kc.cw.ad.internal.c cVar = this.f;
        if (cVar != null) {
            cVar.a();
        }
        C();
        F();
        I();
        s();
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0070  */
    /* JADX WARN: Code duplicated, block: B:40:? A[RETURN, SYNTHETIC] */
    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        com.kc.cw.ad.a.c.o oVarK;
        com.kc.cw.ad.a.c.u uVarC;
        com.kc.cw.ad.a.c.s sVarD;
        com.kc.cw.ad.a.c.r rVarB;
        View adView = getAdView();
        if (adView == null) {
            return;
        }
        adView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        com.kc.cw.ad.internal.b.f fVar = this.f38976a;
        if (fVar == null || (oVarK = fVar.K()) == null) {
            return;
        }
        com.kc.cw.ad.a.c.m mVarA = oVarK.a();
        boolean z = false;
        if (mVarA == null) {
            if (b() || d()) {
            }
            uVarC = oVarK.c();
            if (uVarC != null && uVarC.a() == 1) {
                a(uVarC);
            }
            sVarD = oVarK.d();
            if (sVarD != null && sVarD.a() == 1) {
                a(sVarD.b());
            }
            rVarB = oVarK.b();
            if (rVarB != null && rVarB.a() == 1) {
                b(rVarB.b());
            }
            if (this.av == null) {
                m();
            }
        }
        if (mVarA.a() == 1) {
            z = true;
        }
        e(z);
        uVarC = oVarK.c();
        if (uVarC != null) {
            a(uVarC);
        }
        sVarD = oVarK.d();
        if (sVarD != null) {
            a(sVarD.b());
        }
        rVarB = oVarK.b();
        if (rVarB != null) {
            b(rVarB.b());
        }
        if (this.av == null) {
            m();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void onPauseLifeCycle() {
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void onRestartLifeCycle() {
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void onResumeLifeCycle() {
        com.kc.cw.ad.internal.b.f fVar;
        C1008a c1008a = this.b;
        C1008a.EnumC1009a enumC1009a = C1008a.EnumC1009a.FINISHCLOSE;
        c1008a.a(enumC1009a);
        if (this.b.c() == enumC1009a) {
            getAdDispatcher().a();
        }
        if ((this.ax || ((fVar = this.f38976a) != null && fVar.W())) && this.ao && getMediaType() == p.INTERSTITIAL) {
            A();
        }
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void onStartLifeCycle() {
    }

    @Override // com.kc.cw.ad.AdLifeControl
    public void onStopLifeCycle() {
        this.b.a(C1008a.EnumC1009a.STATE_BACKGROUND);
    }

    public void p() {
        RewardVideoAdListener rewardVideoAdListener;
        if (this.aI || !this.J || (rewardVideoAdListener = this.B) == null) {
            return;
        }
        this.aI = true;
        rewardVideoAdListener.onRewardVideoAdComplete();
    }

    public void q() {
        if (this.aH || this.aG == null) {
            return;
        }
        this.aH = true;
        AppCompatTextView appCompatTextView = this.N;
        if (appCompatTextView != null) {
            appCompatTextView.setText("恭喜获得奖励");
        }
        if (!TextUtils.isEmpty(this.aE)) {
            r();
        } else {
            Pair<String, Integer> pair = this.aG;
            a((String) pair.first, ((Integer) pair.second).intValue());
        }
    }

    public void r() {
        new t(this.aE).a(new AnonymousClass17(this)).b();
    }

    public abstract void s();

    @Override // com.kc.cw.ad.IBidding
    public void sendLossNotice(int i, String str, String str2) {
        try {
            this.f38976a.a(i, str, str2);
            v();
            if (this.aq) {
                return;
            }
            com.kc.cw.ad.internal.b.a.b(this.f38976a);
        } catch (Throwable th) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "A Throwable Caught", th);
        }
    }

    @Override // com.kc.cw.ad.IBidding
    public void sendWinNotice(int i) {
        try {
            this.f38976a.b(i);
        } catch (Throwable th) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "A Throwable Caught", th);
        }
    }

    public void setAdSlotId(String str) {
        com.kc.cw.ad.internal.d dVar = this.d;
        if (dVar != null) {
            dVar.b(str);
        }
    }

    public void setAdVideoView(com.kc.cw.ad.d dVar) {
        this.av = dVar;
    }

    public void setAdWebView(com.kc.cw.ad.internal.e.b bVar) {
        this.aw = bVar;
    }

    public void setChannel(String str) {
        com.kc.cw.ad.internal.d dVar = this.d;
        if (dVar != null) {
            dVar.c(str);
        }
    }

    public void setClickBackClose(boolean z) {
        this.ax = z;
    }

    public void setCountDownTime(int i) {
        this.ah = i;
    }

    public void setCreativeHeight(int i) {
        this.w = i;
    }

    public void setCreativeWidth(int i) {
        this.v = i;
        if (c()) {
            int i2 = this.v;
            float f = i2 > 0 ? i2 / 640.0f : 1.0f;
            this.x = f;
            if (f <= 1.0f) {
                return;
            }
        }
        this.x = 1.0f;
    }

    public void setExtraData(String str) {
        this.ad = str;
    }

    public void setFullScreenVideoAdListener(FullScreenVideoAdListener fullScreenVideoAdListener) {
        com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.c, com.kc.cw.ad.internal.c.f.a(R.string.set_full_screen_video_ad_listener));
        this.A = fullScreenVideoAdListener;
    }

    public void setInterstitialAdListener(InterstitialAdListener interstitialAdListener) {
        com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.c, com.kc.cw.ad.internal.c.f.a(R.string.set_interstitial_ad_listener));
        this.z = interstitialAdListener;
    }

    public void setIsBoost(boolean z) {
        this.d.b(z);
    }

    public void setIsClicked(boolean z) {
        this.ao = z;
        G();
    }

    public void setOnSensorListener(OnSensorListener onSensorListener) {
        this.aS = onSensorListener;
    }

    public void setOpensNativeBrowser(boolean z) {
        this.d.c(z);
    }

    public void setPrice(int i) {
        this.ab = i;
    }

    public void setRequestId(String str) {
        com.kc.cw.ad.internal.d dVar = this.d;
        if (dVar != null) {
            dVar.d(str);
        }
    }

    public void setRewardVideoAdListener(RewardVideoAdListener rewardVideoAdListener) {
        com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.c, com.kc.cw.ad.internal.c.f.a(R.string.set_reward_video_ad_listener));
        this.B = rewardVideoAdListener;
    }

    public void setScrollClick(View.OnTouchListener onTouchListener) {
        View adView = getAdView();
        if (adView == null) {
            return;
        }
        adView.setOnTouchListener(onTouchListener);
    }

    public void setSplashAdListener(SplashAdListener splashAdListener) {
        com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.c, com.kc.cw.ad.internal.c.f.a(R.string.set_splash_ad_listener));
        this.y = splashAdListener;
    }

    public void setTagId(String str) {
        this.ac = str;
    }

    public void setUserId(String str) {
        this.ae = str;
    }

    public void setValidTime(long j) {
        q.x = j;
        this.aj = j;
    }

    public void setVideoStateListener(VideoStateListener videoStateListener) {
        this.aT = videoStateListener;
    }

    public void t() {
        com.kc.cw.ad.internal.b.f fVar;
        if (this.r || (fVar = this.f38976a) == null || !fVar.N() || this.f38976a.C() || !this.al) {
            return;
        }
        Map<String, Object> mapAb = this.f38976a.ab();
        if (mapAb != null && !mapAb.isEmpty()) {
            Intent intent = new Intent(getContext(), (Class<?>) EndingPageActivity.class);
            intent.setFlags(268435456);
            Bundle bundle = new Bundle();
            bundle.putSerializable("mapData", (Serializable) mapAb);
            intent.putExtra("bundleData", bundle);
            getContext().startActivity(intent);
            this.aV = new com.kc.cw.ad.internal.k.a(this) { // from class: com.kc.cw.ad.internal.e.a.28

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final a f38998a;

                {
                    this.f38998a = this;
                }

                @Override // com.kc.cw.ad.internal.k.a
                public void a(String str) {
                    if ("adClick".equals(str)) {
                        a aVar = this.f38998a;
                        aVar.a(aVar.getRandomClickPosition());
                    } else {
                        if (!"feedBackClick".equals(str) || TextUtils.isEmpty(this.f38998a.aF)) {
                            return;
                        }
                        ViewUtil.openLocalBrowser(this.f38998a.aF, 0);
                    }
                }
            };
            com.kc.cw.ad.internal.k.a().a(this.aV);
        }
        this.al = false;
    }
}
