package com.byazt.un;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.camera.video.AudioStats;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.afw.nu;
import com.byazt.bzd.sl;
import com.byazt.bzd.t;
import com.byazt.dna.qp;
import com.byazt.ete.ic;
import com.byazt.ete.pu;
import com.byazt.ete.xd;
import com.byazt.ete.z;
import com.byazt.lbn.TTViewStub;
import com.byazt.nc.u;
import com.byazt.nr.d;
import com.byazt.nr.da;
import com.byazt.nr.m;
import com.byazt.nr.rh;
import com.byazt.omf.gt;
import com.byazt.omf.x;
import com.byazt.omf.zb;
import com.byazt.oq.GifView;
import com.byazt.ouz.NativeExpressVideoView;
import com.byazt.yj.gr;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 96, 2485})
@SuppressLint({"ViewConstructor"})
public class NativeVideoTsView extends FrameLayout implements com.byazt.dh.ve.c, qp.c, com.byazt.un.uj.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f29101a;
    public boolean aw;
    public boolean b;
    public ve bm;
    public int bx;
    public boolean c;
    public long cu;
    public final d d;
    public RelativeLayout da;
    public boolean eo;
    public boolean gr;
    public final AtomicBoolean gt;
    public boolean gu;
    public long h;
    public boolean hd;
    public boolean i;
    public boolean ic;
    public boolean kk;
    public boolean kp;
    public ViewTreeObserver l;
    public View.OnAttachStateChangeListener lo;
    public ViewTreeObserver.OnGlobalLayoutListener lr;
    public com.byazt.sy.sp lt;
    public int m;
    public boolean md;
    public uj my;
    public com.byazt.dh.ve n;
    public boolean nb;
    public AtomicBoolean nu;
    public long or;
    public NativeExpressVideoView p;
    public boolean pf;
    public ViewGroup pu;
    public boolean q;
    public com.byazt.dh.ve.InterfaceC0386ve qp;
    public boolean qy;
    public boolean rh;
    public String rl;
    public ImageView sl;
    public FrameLayout sp;
    public int sv;
    public ImageView t;
    public tt tk;
    public com.byazt.it.ve to;
    public boolean tt;
    public volatile boolean tx;
    public ImageView u;
    public ic uj;
    public AtomicBoolean v;
    public final Context ve;
    public boolean x;
    public boolean yp;
    public boolean yv;
    public String z;
    public TTViewStub zb;
    public boolean zm;

    public interface c {
        void c(View view, int i);
    }

    @com.byazt.zqa.c(c = {0, 1, 96, 1447})
    public class tt implements Runnable {
        public volatile boolean tt;

        private tt() {
        }

        public Runnable c(boolean z) {
            this.tt = z;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeVideoTsView.this.tt(this.tt);
        }
    }

    public interface uj {
        void c(boolean z, long j, long j2, long j3, boolean z2, boolean z3);
    }

    @com.byazt.zqa.c(c = {0, 1, 96, 1442})
    public static class ve implements gr {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f29102a;
        public z c;
        public String n;
        public int sp;
        public WeakReference<ViewGroup> tt;
        public ic uj;
        public WeakReference<GifView> ve = new WeakReference<>(null);

        public ve(z zVar, ViewGroup viewGroup, ic icVar, String str, int i, int i2) {
            this.c = zVar;
            this.tt = new WeakReference<>(viewGroup);
            this.uj = icVar;
            this.n = str;
            this.f29102a = i;
            this.sp = i2;
        }

        @Override // com.byazt.yj.gr
        public void onFailed(int i, String str, Throwable th) {
            m.uj("copflg", "fail: ".concat(String.valueOf(str)));
            GifView gifView = this.ve.get();
            if (gifView != null) {
                gifView.setVisibility(8);
            }
            com.byazt.ddx.uj.c(this.uj, this.n, 2);
        }

        @Override // com.byazt.yj.gr
        public void onSuccess(final com.byazt.yj.m mVar) {
            try {
                ViewGroup viewGroup = this.tt.get();
                if (viewGroup == null) {
                    return;
                }
                viewGroup.postDelayed(new Runnable() { // from class: com.byazt.un.NativeVideoTsView.ve.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            ViewGroup viewGroup2 = (ViewGroup) ve.this.tt.get();
                            if (viewGroup2 == null) {
                                return;
                            }
                            Context context = viewGroup2.getContext();
                            ve veVar = ve.this;
                            veVar.c(context, veVar.c, mVar, viewGroup2);
                        } catch (Exception e) {
                            m.c(e);
                        }
                    }
                }, 100L);
            } catch (Exception e) {
                onFailed(1002, "", e);
            }
        }

        private int c() {
            if (this.c.a() > AudioStats.AUDIO_AMPLITUDE_NONE) {
                return (int) (((double) this.sp) * this.c.a());
            }
            return this.sp / 2;
        }

        private void c(Context context, FrameLayout.LayoutParams layoutParams, int i) {
            if (this.c.ve() == 2) {
                layoutParams.gravity = 8388693;
                layoutParams.rightMargin = i;
                layoutParams.bottomMargin = i;
            } else {
                layoutParams.gravity = 8388659;
                layoutParams.leftMargin = i;
                layoutParams.topMargin = pf.ve(context, 19.0f);
            }
        }

        private void c(Object obj, com.byazt.yj.m mVar, GifView gifView) {
            if (obj instanceof byte[]) {
                if (mVar.isGif()) {
                    gifView.c((byte[]) obj, false);
                    gifView.setRepeatConfig(false);
                } else {
                    gifView.setImageDrawable(com.byazt.aas.m.c((byte[]) obj, 0));
                }
            }
        }

        private void c(GifView gifView) {
            if (gifView == null || gifView.getParent() == null) {
                return;
            }
            ((ViewGroup) gifView.getParent()).removeView(gifView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(Context context, z zVar, com.byazt.yj.m mVar, ViewGroup viewGroup) {
            FrameLayout.LayoutParams layoutParams;
            GifView gifView = new GifView(context);
            gifView.setAdjustViewBounds(true);
            gifView.setBackgroundColor(0);
            int iVe = pf.ve(context, 12.0f);
            this.f29102a = viewGroup.getWidth() <= 0 ? this.f29102a : viewGroup.getWidth();
            this.sp = viewGroup.getHeight() <= 0 ? this.sp : viewGroup.getHeight();
            int iC = c();
            if (zVar.c() == 3) {
                if (iC > pf.ve(context, 88.0f)) {
                    iC = pf.ve(context, 88.0f);
                }
            } else if (zVar.c() == 4 && iC > pf.ve(context, 178.0f)) {
                iC = pf.ve(context, 178.0f);
            }
            int i = this.f29102a - iVe;
            int iSp = (int) (((double) iC) * zVar.sp());
            if (iSp > i && iSp > 0 && i > 0) {
                layoutParams = new FrameLayout.LayoutParams(i, -2);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, iC);
            }
            c(context, layoutParams, iVe);
            gifView.setVisibility(0);
            c(mVar.getResult(), mVar, gifView);
            c(this.ve.get());
            viewGroup.addView(gifView, layoutParams);
            this.ve = new WeakReference<>(gifView);
            com.byazt.ddx.uj.c(this.uj, this.n, 0);
        }
    }

    public NativeVideoTsView(Context context, ic icVar) {
        this(context, icVar, false, false);
    }

    private void cu() {
        pf.n(this.t);
        pf.n(this.da);
    }

    private void d() {
        if (this.pu == null) {
            return;
        }
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.setClipChildren(false);
                if (viewGroup.hashCode() == this.pu.hashCode()) {
                    this.pu.hashCode();
                    return;
                }
            }
        }
    }

    private void eo() {
        if (this.to == null) {
            this.to = getKvCache();
        }
        com.byazt.dh.ve veVar = this.n;
        if (veVar == null || nu() || !this.to.get("key_video_is_update_flag", false)) {
            return;
        }
        boolean z = this.to.get("key_native_video_complete", false);
        long j = this.to.get("key_video_current_play_position", -1L);
        long j2 = this.to.get("key_video_total_play_duration", veVar.yp() + veVar.t());
        long j3 = this.to.get("key_video_duration", veVar.yp());
        veVar.ve(z);
        if (z) {
            veVar.tt(j3);
        } else {
            veVar.tt(j);
        }
        veVar.ve(j2);
        veVar.uj(j3);
        this.to.put("key_video_is_update_flag", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.it.ve getKvCache() {
        ic icVar = this.uj;
        return com.byazt.vif.uj.c(icVar == null ? null : icVar.jl(), "sp_multi_native_video_data");
    }

    private void gr() {
        com.byazt.dh.ve veVar = this.n;
        if (veVar == null) {
            return;
        }
        veVar.uj(this.c);
        ((com.byazt.un.uj) this.n).c((com.byazt.un.uj.c) this);
        this.n.c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gu() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        ViewTreeObserver viewTreeObserver = this.l;
        if (viewTreeObserver == null || (onGlobalLayoutListener = this.lr) == null) {
            return;
        }
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    private void h() {
        if (nu()) {
            return;
        }
        if (this.to == null) {
            this.to = getKvCache();
        }
        this.to.put("key_video_isfromvideodetailpage", false);
        this.to.put("key_video_is_from_detail_page", false);
    }

    private boolean md() {
        if (nu()) {
            return false;
        }
        if (this.to == null) {
            this.to = getKvCache();
        }
        return this.to.get("key_video_is_from_detail_page", false) || this.to.get("key_video_isfromvideodetailpage", false);
    }

    private boolean or() {
        return 5 == gt.tt().a(nb.t(this.uj));
    }

    private boolean p() {
        View view;
        if (!t.c(this.uj)) {
            view = this;
        } else if (pu.c(this.uj) == 2) {
            view = this.p;
        } else {
            ViewParent parent = getParent();
            view = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        }
        return zb.tt(view, com.byazt.qqc.ve.c().c(50, this.uj), 5);
    }

    private void qy() {
        if (!(this instanceof NativeDrawVideoTsView) || this.nu.get() || x.m().sv() == null) {
            return;
        }
        this.u.setImageBitmap(x.m().sv());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.u.getLayoutParams();
        int iVe = pf.ve(getContext(), this.m);
        layoutParams.width = iVe;
        layoutParams.height = iVe;
        this.u.setLayoutParams(layoutParams);
        this.nu.set(true);
    }

    private void rl() {
        addView(c(this.ve));
        H_();
    }

    private void x() {
        c(0L, 0);
        this.qp = null;
    }

    private void yv() {
        boolean zP = p();
        if (this.tx && zP) {
            com.byazt.dh.ve veVar = this.n;
            if (veVar instanceof com.byazt.un.uj) {
                ((com.byazt.un.uj) veVar).h();
            }
            this.tx = false;
        } else {
            if (this.tk == null) {
                this.tk = new tt();
            } else {
                da.tt().removeCallbacks(this.tk);
            }
            this.tk.c(zP);
            da.tt().post(this.tk);
        }
        this.d.sendEmptyMessageDelayed(1, this.or);
    }

    private boolean zb() {
        return 2 == gt.tt().a(nb.t(this.uj));
    }

    private boolean zm() {
        return TextUtils.equals(this.z, "splash_ad") || TextUtils.equals(this.z, "cache_splash_ad");
    }

    public void H_() {
        this.n = c(this.ve, this.sp, this.uj, this.z, !nu(), this.gr, this.zm);
        gr();
        this.lo = new View.OnAttachStateChangeListener() { // from class: com.byazt.un.NativeVideoTsView.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                NativeVideoTsView nativeVideoTsView = NativeVideoTsView.this;
                nativeVideoTsView.l = nativeVideoTsView.f29101a.getViewTreeObserver();
                if (NativeVideoTsView.this.l == null || NativeVideoTsView.this.lr == null) {
                    return;
                }
                NativeVideoTsView.this.l.addOnGlobalLayoutListener(NativeVideoTsView.this.lr);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                NativeVideoTsView.this.gu();
            }
        };
        this.lr = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.un.NativeVideoTsView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int width = NativeVideoTsView.this.f29101a.getWidth();
                int height = NativeVideoTsView.this.f29101a.getHeight();
                ((com.byazt.un.uj) NativeVideoTsView.this.n).c(width, height);
                NativeVideoTsView.this.gu();
                NativeVideoTsView.this.tt(width, height);
            }
        };
    }

    public void I_() {
        pf.c((View) this.da, 8);
        com.byazt.dh.ve.InterfaceC0386ve interfaceC0386ve = this.qp;
        if (interfaceC0386ve != null && !this.kk) {
            this.kk = true;
            interfaceC0386ve.onVideoAdStartPlay();
        }
        pf.c((View) this.da, 8);
        com.byazt.sy.sp spVar = this.lt;
        if (spVar != null) {
            spVar.c();
        }
    }

    public boolean da() {
        return this.b;
    }

    public com.byazt.dh.ve getNativeVideoController() {
        return this.n;
    }

    public boolean getVideoError() {
        return this.gu;
    }

    public void gt() {
        d dVar = this.d;
        if (dVar != null) {
            dVar.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.byazt.dna.qp.c
    public void handleMsg(Message message) {
        if (message.what != 1) {
            return;
        }
        yv();
    }

    @Override // com.byazt.un.uj.c
    public void i() {
        this.tx = true;
        if (this.d.hasMessages(1)) {
            return;
        }
        this.d.sendEmptyMessage(1);
    }

    public boolean m() {
        return this.x;
    }

    public void my() {
        if (this.n != null) {
            cu();
            this.n.tt();
        }
    }

    public boolean nu() {
        return this.tt;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        super.onAttachedToWindow();
        if (this.aw) {
            ViewGroup viewGroup = this.f29101a;
            if (viewGroup != null && (onAttachStateChangeListener = this.lo) != null) {
                viewGroup.addOnAttachStateChangeListener(onAttachStateChangeListener);
            }
            uj();
            com.byazt.qw.x.c(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        super.onDetachedFromWindow();
        ViewGroup viewGroup = this.f29101a;
        if (viewGroup != null && (onAttachStateChangeListener = this.lo) != null) {
            viewGroup.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
        n();
        this.bm = null;
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.aw) {
            uj();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        sl();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        n();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        com.byazt.dh.ve veVar;
        com.byazt.dh.ve veVar2;
        com.byazt.dh.ve veVar3;
        com.byazt.dh.ve veVar4;
        super.onWindowFocusChanged(z);
        if (this.aw) {
            this.nb = z;
            eo();
            if (md() && (veVar4 = this.n) != null && veVar4.gt()) {
                h();
                pf.c((View) this.da, 8);
                uj(true);
                x();
                return;
            }
            sp();
            if (!nu() && z() && (veVar2 = this.n) != null && !veVar2.m()) {
                if (this.d != null) {
                    if (z && (veVar3 = this.n) != null && !veVar3.gt()) {
                        this.d.obtainMessage(1).sendToTarget();
                        return;
                    } else {
                        this.d.removeMessages(1);
                        tt(false);
                        return;
                    }
                }
                return;
            }
            if (z()) {
                return;
            }
            if (!z && (veVar = this.n) != null && veVar.nu() != null && this.n.nu().isPlaying()) {
                this.d.removeMessages(1);
                tt(false);
            } else if (z) {
                this.d.obtainMessage(1).sendToTarget();
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        com.byazt.dh.ve veVar;
        com.byazt.dh.ve veVar2;
        com.byazt.dh.ve veVar3;
        super.onWindowVisibilityChanged(i);
        if (this.aw) {
            d();
            eo();
            if (this.q) {
                this.q = i == 0;
            }
            if (md() && (veVar3 = this.n) != null && veVar3.gt()) {
                h();
                pf.c((View) this.da, 8);
                uj(true);
                x();
                return;
            }
            sp();
            if (nu() || !z() || (veVar = this.n) == null || veVar.m() || this.uj == null) {
                return;
            }
            boolean zTt = zb.tt(this, com.byazt.qqc.ve.c().c(20, this.uj), 5);
            isShown();
            if (this.md && xd.z(this.uj) != null && zTt) {
                com.byazt.jzl.a aVarC = xd.c(4, this.uj);
                aVarC.setCid(this.uj.uj());
                aVarC.setWidth(this.f29101a.getWidth());
                aVarC.setHeight(this.f29101a.getHeight());
                aVarC.setLogExtra(this.uj.w_());
                aVarC.setCurrent(this.h);
                aVarC.setQuiet(m());
                c(aVarC);
                pf.c((View) this.da, 8);
            } else {
                try {
                    StringBuilder sb = new StringBuilder("onWindowVisibilityChanged materialMeta.getVideo() is null ");
                    sb.append(this.da == null);
                    sb.append(" ");
                    sb.append(this.q);
                    sb.append(" ");
                    sb.append(hashCode());
                    m.uj("NativeVideoAdView", sb.toString());
                    if (this.q && this.da == null) {
                        t();
                        pf.c((View) this.da, 0);
                    }
                } catch (Throwable th) {
                    m.c(th);
                }
            }
            if (i != 0 || !this.nb || this.d == null || (veVar2 = this.n) == null || veVar2.gt()) {
                return;
            }
            this.d.obtainMessage(1).sendToTarget();
        }
    }

    public void rh() {
        com.byazt.dh.tt ttVarRh;
        com.byazt.dh.ve veVar = this.n;
        if (veVar == null || (ttVarRh = veVar.rh()) == null) {
            return;
        }
        ttVarRh.c();
        View viewVe = ttVarRh.ve();
        if (viewVe != null) {
            viewVe.setVisibility(8);
            if (viewVe.getParent() != null) {
                ((ViewGroup) viewVe.getParent()).removeView(viewVe);
            }
        }
    }

    public void setAdCreativeClickListener(c cVar) {
        com.byazt.dh.ve veVar = this.n;
        if (veVar != null) {
            ((com.byazt.un.uj) veVar).c(cVar);
        }
    }

    public void setComplete(boolean z) {
        com.byazt.dh.ve veVar = this.n;
        if (veVar != null) {
            veVar.ve(z);
        }
    }

    public void setControllerStatusCallBack(uj ujVar) {
        this.my = ujVar;
    }

    public void setDrawVideoListener(com.byazt.uz.c cVar) {
        com.byazt.dh.ve veVar = this.n;
        if (veVar != null) {
            ((com.byazt.un.uj) veVar).c(cVar);
        }
    }

    public void setEasyPlayableEventSender(com.byazt.sy.sp spVar) {
        this.lt = spVar;
    }

    public void setEnableAutoCheck(boolean z) {
        this.aw = z;
    }

    public void setEnableBlur(boolean z) {
        this.i = z;
    }

    public void setIsAutoPlay(boolean z) {
        ic icVar;
        if (this.eo || (icVar = this.uj) == null) {
            return;
        }
        int iA = gt.tt().a(nb.t(icVar));
        if (z && iA != 4 && (!rh.n(this.ve) ? !(!rh.a(this.ve) ? rh.uj(this.ve) : zb() || or()) : !zb())) {
            z = false;
        }
        this.c = z;
        com.byazt.dh.ve veVar = this.n;
        if (veVar != null) {
            veVar.uj(z);
        }
        if (this.c) {
            pf.c((View) this.da, 8);
        } else {
            t();
            RelativeLayout relativeLayout = this.da;
            if (relativeLayout != null) {
                pf.c((View) relativeLayout, 0);
                if (xd.z(this.uj) != null) {
                    com.byazt.xky.tt.c(xd.tt(this.uj)).to(this.sl);
                    c(this.sl, xd.tt(this.uj));
                } else {
                    m.uj("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
                }
            }
        }
        this.eo = true;
    }

    public void setIsQuiet(boolean z) {
        this.x = z;
        com.byazt.dh.ve veVar = this.n;
        if (veVar != null) {
            veVar.tt(z);
        }
    }

    public void setMaterialMeta(ic icVar) {
        this.uj = icVar;
    }

    public void setNativeExpressVideoView(NativeExpressVideoView nativeExpressVideoView) {
        this.p = nativeExpressVideoView;
    }

    public void setNativeRenderAd(boolean z) {
        this.b = z;
    }

    public void setNativeVideoAdListener(com.byazt.dh.ve.c cVar) {
        com.byazt.dh.ve veVar = this.n;
        if (veVar != null) {
            veVar.c(cVar);
        }
    }

    public void setNativeVideoController(com.byazt.dh.ve veVar) {
        this.n = veVar;
    }

    public void setNeedNativeVideoPlayBtnVisible(boolean z) {
        this.yp = z;
    }

    public void setVideoAdClickListenerTTNativeAd(u uVar) {
        com.byazt.dh.ve veVar = this.n;
        if (veVar != null) {
            ((com.byazt.un.uj) veVar).c(uVar);
        }
    }

    public void setVideoAdInteractionListener(com.byazt.dh.ve.InterfaceC0386ve interfaceC0386ve) {
        this.qp = interfaceC0386ve;
    }

    public void setVideoAdLoadListener(com.byazt.dh.ve.uj ujVar) {
        com.byazt.dh.ve veVar = this.n;
        if (veVar != null) {
            veVar.c(ujVar);
        }
    }

    public void setVideoCacheUrl(String str) {
        this.rl = str;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 4 || i == 8) {
            yp();
        }
    }

    public void sl() {
        uj ujVar;
        com.byazt.dh.ve veVar;
        if (this.tt || (ujVar = this.my) == null || (veVar = this.n) == null) {
            return;
        }
        ujVar.c(veVar.gt(), this.n.yp(), this.n.yp() + this.n.t(), this.n.sl(), this.c, this.x);
    }

    public void sp() {
        ic icVar = this.uj;
        if (icVar == null) {
            return;
        }
        int iA = gt.tt().a(nb.t(icVar));
        if (iA == 1) {
            this.c = rh.uj(this.ve);
        } else if (iA == 2) {
            this.c = rh.n(this.ve) || rh.uj(this.ve) || rh.a(this.ve) || rh.ve(gt.getContext()) == 1;
        } else if (iA == 3) {
            this.c = false;
        } else if (iA == 4) {
            this.rh = true;
        } else if (iA == 5) {
            this.c = rh.uj(this.ve) || rh.a(this.ve);
        }
        if (this.tt) {
            this.x = false;
        } else {
            this.x = this.uj.ab() == 1;
        }
        if ("splash_ad".equals(this.z)) {
            this.c = true;
            this.x = true;
        }
        com.byazt.dh.ve veVar = this.n;
        if (veVar != null) {
            veVar.uj(this.c);
        }
    }

    public void t() {
        TTViewStub tTViewStub;
        if (zm() || this.ve == null || (tTViewStub = this.zb) == null || tTViewStub.getParent() == null || this.uj == null || this.da != null) {
            return;
        }
        if (this.zb.getParent() != null && (this.zb.getParent() instanceof ViewGroup)) {
            this.da = (RelativeLayout) this.zb.c();
        }
        this.sl = (ImageView) findViewById(2114387954);
        ImageView imageView = (ImageView) findViewById(2114387847);
        this.u = imageView;
        if (this.yp) {
            pf.c((View) imageView, 0);
        }
        if (!TextUtils.isEmpty(xd.tt(this.uj))) {
            com.byazt.xky.tt.c(xd.tt(this.uj)).to(this.sl);
            c(this.sl, xd.tt(this.uj));
        }
        qy();
    }

    public boolean u() {
        ic icVar = this.uj;
        return icVar != null && icVar.il() == 4 && pu.c(this.uj) == 1 && !TextUtils.equals("draw_ad", this.z);
    }

    public void yp() {
        if (!this.gt.get()) {
            this.gt.set(true);
            if (this.n != null) {
                d dVar = this.d;
                if (dVar != null) {
                    dVar.removeCallbacksAndMessages(null);
                }
                this.n.c(true, 3);
            }
        }
        this.v.set(false);
    }

    public boolean z() {
        return this.c;
    }

    public NativeVideoTsView(Context context) {
        this(context, null, false, false);
    }

    public void n() {
        this.my = null;
        rh();
        yp();
    }

    public void tt(long j, int i) {
        this.gu = true;
    }

    public void uj() {
        com.byazt.dh.ve veVar = this.n;
        if (veVar == null) {
            H_();
        } else if ((veVar instanceof com.byazt.un.uj) && !nu()) {
            ((com.byazt.un.uj) this.n).sv();
        }
        if (this.n == null || !this.gt.get()) {
            return;
        }
        this.gt.set(false);
        sp();
        if (!z()) {
            if (this.n.gt()) {
                uj(true);
                return;
            }
            m.c("NativeVideoAdView", "attachTask.......mRlImgCover.....VISIBLE");
            t();
            pf.c((View) this.da, 0);
            return;
        }
        ImageView imageView = this.t;
        if (imageView != null) {
            pf.c((View) imageView, 8);
        }
        if (xd.z(this.uj) == null) {
            m.uj("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
            return;
        }
        com.byazt.jzl.a aVarC = xd.c(4, this.uj);
        aVarC.setCid(this.uj.uj());
        aVarC.setWidth(this.f29101a.getWidth());
        aVarC.setHeight(this.f29101a.getHeight());
        aVarC.setLogExtra(this.uj.w_());
        aVarC.setCurrent(0L);
        aVarC.setAudio(t.c(this.uj));
        aVarC.setQuiet(m());
        if (zm()) {
            String splashCacheDir = sl.c(0).getSplashCacheDir();
            if (this.uj.ox()) {
                splashCacheDir = sl.c();
            }
            aVarC.setCacheParentDir(splashCacheDir);
        }
        c(aVarC);
        this.n.ve(false);
    }

    public void ve(boolean z) {
        com.byazt.sy.sp spVar = this.lt;
        if (spVar != null) {
            spVar.c(z);
        }
    }

    public NativeVideoTsView(Context context, ic icVar, boolean z, boolean z2) {
        this(context, icVar, z, z2, com.byazt.dyf.tt.AD_TAG_FEED, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(int i, int i2) {
        if (nu()) {
            return;
        }
        ic icVar = this.uj;
        z zVarQi = icVar == null ? null : icVar.qi();
        if (zVarQi != null && i2 > 0) {
            if (!zVarQi.x()) {
                com.byazt.ddx.uj.c(this.uj, this.z, 1);
                return;
            }
            this.bx = i;
            this.sv = i2;
            if (this.bm == null) {
                this.bm = new ve(zVarQi, this.f29101a, this.uj, this.z, i, i2);
            }
            com.byazt.xky.tt.c(zVarQi.n()).type(3).config(Bitmap.Config.RGB_565).to(this.bm);
        }
    }

    public NativeVideoTsView(Context context, ic icVar, String str, boolean z, boolean z2) {
        this(context, icVar, false, false, str, z, z2);
    }

    public NativeVideoTsView(Context context, ic icVar, boolean z, boolean z2, String str, boolean z3, boolean z4) {
        super(context);
        this.c = true;
        this.x = true;
        this.tt = false;
        this.qy = false;
        this.gu = false;
        this.gr = false;
        this.zm = true;
        this.yv = false;
        this.yp = true;
        this.z = com.byazt.dyf.tt.AD_TAG_FEED;
        this.m = 50;
        this.md = true;
        this.nu = new AtomicBoolean(false);
        this.eo = false;
        this.rh = false;
        this.or = 50L;
        this.cu = 500L;
        this.nb = true;
        this.pf = false;
        this.aw = true;
        this.ic = true;
        this.kp = false;
        this.gt = new AtomicBoolean(false);
        this.q = true;
        this.tx = false;
        this.v = new AtomicBoolean(false);
        this.z = str;
        this.ve = context;
        this.uj = icVar;
        this.tt = z;
        this.yv = z2;
        this.gr = z3;
        this.zm = z4;
        this.d = new d(com.byazt.bzd.x.tt(), this);
        setContentDescription("NativeVideoAdView");
        sp();
        rl();
        com.byazt.bzd.x.tt(new Runnable() { // from class: com.byazt.un.NativeVideoTsView.1
            @Override // java.lang.Runnable
            public void run() {
                if (NativeVideoTsView.this.to == null) {
                    NativeVideoTsView nativeVideoTsView = NativeVideoTsView.this;
                    nativeVideoTsView.to = nativeVideoTsView.getKvCache();
                }
            }
        });
    }

    @Override // com.byazt.dh.ve.c
    public void c(long j, int i) {
        this.kp = true;
        com.byazt.dh.ve.InterfaceC0386ve interfaceC0386ve = this.qp;
        if (interfaceC0386ve != null) {
            interfaceC0386ve.onVideoComplete();
        }
    }

    @Override // com.byazt.dh.ve.c
    public void c() {
        if (this.qp == null || !zm()) {
            return;
        }
        this.qp.onVideoComplete();
    }

    @Override // com.byazt.dh.ve.c
    public void c(long j, long j2) {
        com.byazt.dh.ve veVar;
        if (j != j2) {
            this.kp = false;
        }
        com.byazt.dh.ve.InterfaceC0386ve interfaceC0386ve = this.qp;
        if (interfaceC0386ve != null) {
            interfaceC0386ve.onProgressUpdate(j, j2);
        }
        if (p() || (veVar = this.n) == null) {
            return;
        }
        veVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(boolean z) {
        if (this.kp || this.qy == z) {
            return;
        }
        if (!z) {
            da.tt().removeCallbacks(this.tk);
        }
        this.qy = z;
        ve(z);
        if (this.uj == null || this.n == null) {
            return;
        }
        boolean zMd = md();
        h();
        if (zMd && this.n.gt()) {
            uj(true);
            x();
            return;
        }
        if (z && !this.n.gt() && !this.n.m()) {
            if (this.n.nu() != null && this.n.nu().isPaused()) {
                if (this.c) {
                    if ("ALP-AL00".equals(((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getDeviceModel())) {
                        this.n.x();
                    } else {
                        ((com.byazt.un.uj) this.n).a(zMd);
                    }
                    com.byazt.dh.ve.InterfaceC0386ve interfaceC0386ve = this.qp;
                    if (interfaceC0386ve != null) {
                        interfaceC0386ve.onVideoAdContinuePlay();
                        return;
                    }
                    return;
                }
                this.qy = false;
                return;
            }
            if (this.c && this.n.nu() == null) {
                if (!this.gt.get()) {
                    this.gt.set(true);
                }
                this.v.set(false);
                uj();
                return;
            }
            return;
        }
        if (this.n.nu() == null || !this.n.nu().isPlaying()) {
            return;
        }
        this.n.a();
        com.byazt.dh.ve.InterfaceC0386ve interfaceC0386ve2 = this.qp;
        if (interfaceC0386ve2 != null) {
            interfaceC0386ve2.onVideoAdPaused();
        }
    }

    private View c(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setId(2114387848);
        layoutParams.gravity = 17;
        frameLayout.setVisibility(8);
        this.f29101a = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        frameLayout2.setId(2114387756);
        layoutParams2.gravity = 17;
        frameLayout2.setLayoutParams(layoutParams2);
        frameLayout.addView(frameLayout2);
        this.sp = frameLayout2;
        TTViewStub tTViewStub = new TTViewStub(context, new com.byazt.wol.n());
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        tTViewStub.setId(2114387607);
        tTViewStub.setLayoutParams(layoutParams3);
        frameLayout.addView(tTViewStub);
        this.zb = tTViewStub;
        return frameLayout;
    }

    public void c(final ImageView imageView, String str) {
        if (imageView == null || !com.byazt.ic.c.c(this.uj) || com.byazt.ic.c.sp(this.uj)) {
            return;
        }
        com.byazt.xky.tt.c(str).config(Bitmap.Config.ARGB_4444).type(2).to(new gr<Bitmap>() { // from class: com.byazt.un.NativeVideoTsView.2
            @Override // com.byazt.yj.gr
            public void onFailed(int i, String str2, Throwable th) {
            }

            @Override // com.byazt.yj.gr
            public void onSuccess(com.byazt.yj.m<Bitmap> mVar) {
                Bitmap result;
                if (mVar == null || (result = mVar.getResult()) == null) {
                    return;
                }
                final Bitmap bitmapC = com.byazt.or.tt.c(NativeVideoTsView.this.ve, result, 25);
                com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.un.NativeVideoTsView.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (bitmapC != null) {
                            imageView.setBackground(new BitmapDrawable(bitmapC));
                        }
                    }
                });
            }
        }, 4);
    }

    public void uj(boolean z) {
        com.byazt.dh.ve veVar = this.n;
        if (veVar != null) {
            veVar.ve(z);
            com.byazt.dh.tt ttVarRh = this.n.rh();
            if (ttVarRh != null) {
                ttVarRh.tt();
                View viewVe = ttVarRh.ve();
                if (viewVe != null) {
                    if (viewVe.getParent() != null) {
                        ((ViewGroup) viewVe.getParent()).removeView(viewVe);
                    }
                    viewVe.setVisibility(0);
                    addView(viewVe);
                    ttVarRh.c(this.uj, new WeakReference<>(this.ve), false);
                }
            }
        }
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.zb.getParent() != null && (this.zb.getParent() instanceof ViewGroup)) {
            this.da = (RelativeLayout) this.zb.c();
        }
        ImageView imageView = (ImageView) findViewById(2114387954);
        this.sl = imageView;
        imageView.setImageDrawable(null);
        this.u = (ImageView) findViewById(2114387847);
        com.byazt.xky.tt.c(str).to(this.sl);
        c(this.sl, str);
        pf.c((View) this.da, 0);
    }

    public void tt(boolean z, boolean z2) {
        this.ic = z;
        this.hd = z2;
    }

    public void tt(int i) {
        if (rh.ve(gt.getContext()) == 0) {
            return;
        }
        if (this.n.nu() != null) {
            if (this.n.nu().isPlaying() && i == 2) {
                tt(false);
                d dVar = this.d;
                if (dVar != null) {
                    dVar.removeMessages(1);
                }
                c(true);
                return;
            }
            if (this.n.nu().isPaused() && i == 3) {
                this.c = true;
                tt(true);
                sp();
                d dVar2 = this.d;
                if (dVar2 != null) {
                    dVar2.sendEmptyMessageDelayed(1, this.or);
                }
                c(false);
                return;
            }
        }
        if (z() || this.v.get()) {
            return;
        }
        this.v.set(true);
        if (xd.z(this.uj) != null) {
            cu();
            com.byazt.jzl.a aVarC = xd.c(4, this.uj);
            aVarC.setCid(this.uj.uj());
            aVarC.setWidth(this.f29101a.getWidth());
            aVarC.setHeight(this.f29101a.getHeight());
            aVarC.setLogExtra(this.uj.w_());
            aVarC.setCurrent(this.h);
            aVarC.setQuiet(m());
            aVarC.setCacheParentDir(sl.c(this.uj.xx()).getOtherCacheDir());
            c(aVarC);
        } else {
            m.uj("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        }
        d dVar3 = this.d;
        if (dVar3 != null) {
            dVar3.sendEmptyMessageDelayed(1, this.or);
        }
        c(false);
    }

    public com.byazt.dh.ve c(Context context, ViewGroup viewGroup, ic icVar, String str, boolean z, boolean z2, boolean z3) {
        return new com.byazt.un.uj(context, viewGroup, icVar, str, z, z2, z3);
    }

    public boolean c(long j, boolean z, boolean z2) {
        boolean zC = false;
        this.f29101a.setVisibility(0);
        if (this.n == null) {
            this.n = new com.byazt.un.uj(this.ve, this.sp, this.uj, this.z, this.gr, this.zm);
            gr();
        }
        this.h = j;
        if (nu()) {
            this.n.c(false);
            if (xd.z(this.uj) != null) {
                com.byazt.jzl.a aVarC = xd.c(4, this.uj);
                aVarC.setCid(this.uj.uj());
                aVarC.setWidth(this.f29101a.getWidth());
                aVarC.setHeight(this.f29101a.getHeight());
                aVarC.setLogExtra(this.uj.w_());
                aVarC.setCurrent(j);
                aVarC.setQuiet(m());
                if (z2) {
                    this.n.tt(aVarC);
                    return true;
                }
                zC = c(aVarC);
            }
            if (((j > 0 && !z && !z2) || (j > 0 && z && !this.yv)) && (this.n instanceof com.byazt.nj.c)) {
                nu.c cVar = new nu.c();
                cVar.c(this.n.sl());
                cVar.ve(this.n.yp());
                cVar.tt(this.n.t());
                com.byazt.dh.ve veVar = this.n;
                ((com.byazt.nj.c) veVar).tt(veVar.rh(), cVar);
            }
            return zC;
        }
        if (u() || this.i) {
            c(this.ve, 25, xd.tt(this.uj));
        }
        return true;
    }

    public boolean c(com.byazt.jzl.a aVar) {
        if (this.n == null) {
            return false;
        }
        this.md = false;
        this.or = this.cu;
        if (this.hd) {
            aVar.setQuiet(this.ic);
        }
        return this.n.c(aVar);
    }

    public void tt() {
        if (rh.ve(gt.getContext()) == 0) {
            return;
        }
        if (this.n.nu() != null) {
            if (this.n.nu().isPlaying()) {
                tt(false);
                d dVar = this.d;
                if (dVar != null) {
                    dVar.removeMessages(1);
                }
                c(true);
                return;
            }
            if (this.n.nu().isPaused()) {
                this.c = true;
                tt(true);
                sp();
                d dVar2 = this.d;
                if (dVar2 != null) {
                    dVar2.sendEmptyMessageDelayed(1, this.or);
                }
                c(false);
                return;
            }
        }
        if (z() || this.v.get()) {
            return;
        }
        this.v.set(true);
        if (xd.z(this.uj) != null) {
            cu();
            com.byazt.jzl.a aVarC = xd.c(4, this.uj);
            aVarC.setCid(this.uj.uj());
            aVarC.setWidth(this.f29101a.getWidth());
            aVarC.setHeight(this.f29101a.getHeight());
            aVarC.setLogExtra(this.uj.w_());
            aVarC.setCurrent(this.h);
            aVarC.setQuiet(m());
            c(aVarC);
        } else {
            m.uj("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        }
        d dVar3 = this.d;
        if (dVar3 != null) {
            dVar3.sendEmptyMessageDelayed(1, this.or);
        }
        c(false);
    }

    @Override // com.byazt.un.uj.c
    public void c(int i) {
        sp();
    }

    public void c(boolean z) {
        if (this.t == null) {
            this.t = new ImageView(getContext());
            if (x.m().sv() != null) {
                this.t.setImageBitmap(x.m().sv());
            } else {
                com.byazt.nr.z.c(gt.getContext(), "tt_new_play_video", this.t, 320);
            }
            this.t.setScaleType(ImageView.ScaleType.FIT_XY);
            int iVe = pf.ve(getContext(), this.m);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iVe, iVe);
            layoutParams.gravity = 17;
            this.f29101a.addView(this.t, layoutParams);
        }
        if (z) {
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(8);
        }
    }

    public void c(int i, int i2) {
        com.byazt.dh.ve veVar = this.n;
        if (veVar != null) {
            ((com.byazt.un.uj) veVar).c(i, i2);
        }
    }

    public void c(final Context context, final int i, String str) {
        final com.byazt.dh.tt ttVarRh;
        com.byazt.dh.ve veVar = this.n;
        if (veVar == null || (ttVarRh = veVar.rh()) == null) {
            return;
        }
        com.byazt.xky.tt.c(str).config(Bitmap.Config.ARGB_4444).type(2).to(new gr<Bitmap>() { // from class: com.byazt.un.NativeVideoTsView.5
            @Override // com.byazt.yj.gr
            public void onFailed(int i2, String str2, Throwable th) {
            }

            @Override // com.byazt.yj.gr
            public void onSuccess(com.byazt.yj.m<Bitmap> mVar) {
                Bitmap bitmapC = com.byazt.or.tt.c(context, mVar.getResult(), i);
                if (bitmapC == null) {
                    return;
                }
                final BitmapDrawable bitmapDrawable = new BitmapDrawable(NativeVideoTsView.this.getResources(), bitmapC);
                com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.un.NativeVideoTsView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.byazt.dh.tt ttVar = ttVarRh;
                        if (ttVar != null) {
                            ttVar.c(bitmapDrawable);
                        }
                    }
                });
            }
        }, 4);
    }
}
