package com.byazt.cc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.but.TTCountdownViewForBtn;
import com.byazt.but.TTCountdownViewForCircle;
import com.byazt.ete.ic;
import com.byazt.ete.iu;
import com.byazt.ete.r;
import com.byazt.nr.m;
import com.byazt.nr.my;
import com.byazt.nr.z;
import com.byazt.omf.gt;
import com.byazt.ouz.NativeExpressView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 448, 790})
public class TsView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SplashClickBar f28345a;
    public final Context c;
    public FrameLayout da;
    public TextView i;
    public int m;
    public TextView n;
    public ic sl;
    public NativeExpressView sp;
    public boolean t;
    public com.byazt.but.uj tt;
    public c u;
    public FrameLayout uj;
    public ImageView ve;
    public String x;
    public boolean yp;
    public FrameLayout z;

    public interface c {
        void onAttachedToWindow();

        void onDetachedFromWindow();

        void onWindowFocusChanged(boolean z);
    }

    public TsView(Context context, String str, ic icVar) {
        super(context);
        this.t = false;
        this.yp = false;
        this.c = context;
        this.x = str;
        this.sl = icVar;
        ve();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getCountDownLayout() {
        com.byazt.but.uj ujVar = this.tt;
        if (ujVar == null) {
            return null;
        }
        return ujVar.getView();
    }

    private boolean n() {
        ic icVar = this.sl;
        return icVar != null && icVar.by() == 2;
    }

    private void setComplianceBarLayout(ic icVar) {
        r rVarVl;
        if (this.i == null || !tt(icVar) || (rVarVl = icVar.vl()) == null) {
            return;
        }
        int iC = rVarVl.c();
        int iTt = rVarVl.tt();
        int iVe = rVarVl.ve();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = pf.ve(gt.getContext(), 25.0f);
        layoutParams.rightMargin = pf.ve(gt.getContext(), 25.0f);
        this.i.setPadding(20, 20, 20, 20);
        this.i.setHighlightColor(0);
        if (iC == 2) {
            layoutParams.gravity = 80;
            if (uj()) {
                layoutParams.bottomMargin = pf.ve(gt.getContext(), iVe);
            } else {
                layoutParams.bottomMargin = pf.ve(gt.getContext(), iTt);
            }
        } else {
            layoutParams.gravity = 48;
            if (uj()) {
                layoutParams.topMargin = pf.ve(gt.getContext(), iVe);
            } else {
                layoutParams.topMargin = pf.ve(gt.getContext(), iTt);
            }
        }
        this.da.setLayoutParams(layoutParams);
    }

    private boolean uj() {
        return getHeight() < pf.tt(gt.getContext())[1];
    }

    public com.byazt.but.uj getCountDownView() {
        return this.tt;
    }

    public View getDislikeView() {
        return getCountDownLayout();
    }

    public FrameLayout getEasyPlayableLayout() {
        return this.z;
    }

    public NativeExpressView getNativeExpressView() {
        return this.sp;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!n() && !this.yp) {
            post(new com.byazt.bwm.sp("splash_btn_adjust") { // from class: com.byazt.cc.TsView.2
                @Override // java.lang.Runnable
                public void run() {
                    TsView tsView = TsView.this;
                    pf.c(tsView, tsView.getCountDownLayout());
                    TsView tsView2 = TsView.this;
                    pf.c(tsView2, tsView2.ve);
                }
            });
        }
        c cVar = this.u;
        if (cVar != null) {
            cVar.onAttachedToWindow();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (gt.tt().yv() == 0) {
            return;
        }
        if (gt.tt().yv() != 1 || uj()) {
            if ((gt.tt().yv() == 2 && uj()) || this.m == configuration.orientation) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            setLayoutParams(layoutParams);
            this.m = configuration.orientation;
            pf.c(this, new pf.c() { // from class: com.byazt.cc.TsView.1
                @Override // com.byazt.aas.pf.c
                public void c(View view) {
                    int height = TsView.this.getHeight();
                    int width = TsView.this.getWidth();
                    if (TsView.this.m != 2) {
                        view.setRotation(0.0f);
                        m.c("TSView", "onConfigurationChanged: Width = " + TsView.this.getWidth() + ", Height = " + TsView.this.getHeight());
                        return;
                    }
                    ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                    layoutParams2.width = height;
                    layoutParams2.height = width;
                    view.setLayoutParams(layoutParams2);
                    view.setRotation(-90.0f);
                    m.c("TSView", "onConfigurationChanged: newWidth = " + height + ", newHeight = " + width);
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.u;
        if (cVar != null) {
            cVar.onDetachedFromWindow();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.t) {
            return;
        }
        SplashClickBar splashClickBar = this.f28345a;
        if (splashClickBar != null) {
            splashClickBar.setBtnLayout(!uj());
        }
        this.t = true;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        c cVar = this.u;
        if (cVar != null) {
            cVar.onWindowFocusChanged(z);
        }
    }

    public void setAdlogoViewVisibility(int i) {
        pf.c((View) this.n, i);
    }

    public void setAttachedToWindowListener(c cVar) {
        this.u = cVar;
    }

    public void setComplianceBarVisibility(int i) {
        if (i == 8) {
            pf.c((View) this.f28345a, i);
        }
    }

    public void setCountDownTime(int i) {
        com.byazt.but.uj ujVar = this.tt;
        if (ujVar != null) {
            ujVar.setCountDownTime(i);
        }
    }

    public void setCountDownViewPosition(ic icVar) {
        com.byazt.but.uj ujVar = this.tt;
        if (ujVar == null || ujVar.getView() == null || icVar == null) {
            return;
        }
        View view = this.tt.getView();
        iu iuVarCg = icVar.cg();
        if (iuVarCg == null) {
            return;
        }
        int iC = iuVarCg.c();
        int iVe = pf.ve(this.c, iuVarCg.tt());
        int iVe2 = pf.ve(this.c, iuVarCg.ve());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (iC == 1) {
            layoutParams.gravity = 8388659;
            layoutParams.leftMargin = iVe;
            layoutParams.topMargin = iVe2;
        } else if (iC == 3) {
            layoutParams.gravity = 8388691;
            layoutParams.leftMargin = iVe;
            layoutParams.bottomMargin = iVe2;
        } else if (iC != 4) {
            layoutParams.gravity = 8388661;
            layoutParams.rightMargin = iVe;
            layoutParams.topMargin = iVe2;
        } else {
            layoutParams.gravity = 8388693;
            layoutParams.rightMargin = iVe;
            layoutParams.bottomMargin = iVe2;
        }
        view.setLayoutParams(layoutParams);
    }

    public void setExpressView(NativeExpressView nativeExpressView) {
        if (nativeExpressView == null) {
            return;
        }
        this.sp = nativeExpressView;
        if (nativeExpressView.getParent() != null) {
            ((ViewGroup) this.sp.getParent()).removeView(this.sp);
        }
        this.uj.addView(this.sp);
        setExpressViewVisibility(0);
    }

    public void setExpressViewVisibility(int i) {
        pf.c((View) this.uj, i);
    }

    public void setIsShowSuccess(boolean z) {
        this.yp = z;
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        my.c("不允许在Splash广告中注册OnClickListener");
    }

    public final void setOnClickListenerInternal(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        my.c("不允许在Splash广告中注册OnTouchListener");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void setOnTouchListenerInternal(View.OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
    }

    public void setSkipIconVisibility(int i) {
        pf.c(getCountDownLayout(), i);
    }

    public final void setSkipListener(View.OnClickListener onClickListener) {
        com.byazt.but.uj ujVar = this.tt;
        if (ujVar == null || ujVar.getView() == null) {
            return;
        }
        this.tt.getView().setOnClickListener(onClickListener);
    }

    public void setSlideUpTouchListener(View.OnTouchListener onTouchListener) {
        setOnTouchListenerInternal(onTouchListener);
    }

    public void setVideoViewVisibility(int i) {
        pf.c((View) this.ve, i);
    }

    public void setVideoVoiceVisibility(int i) {
        pf.c((View) this.ve, i);
    }

    public final void setVoiceViewImageDrawable(Drawable drawable) {
        ImageView imageView = this.ve;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public final void setVoiceViewListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.ve;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    private View c(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(2114387582);
        this.uj = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.uj.setId(2114387581);
        this.uj.setLayoutParams(layoutParams);
        frameLayout.addView(this.uj);
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        this.z = frameLayout2;
        frameLayout.addView(frameLayout2);
        this.ve = new ImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 30.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 30.0f, resources.getDisplayMetrics()));
        layoutParams2.gravity = 8388659;
        layoutParams2.topMargin = pf.ve(this.c, 16.0f);
        layoutParams2.leftMargin = pf.ve(this.c, 16.0f);
        this.ve.setId(2114387580);
        this.ve.setLayoutParams(layoutParams2);
        z.c(this.c, "tt_splash_mute", this.ve, 320);
        pf.c((View) this.ve, 8);
        frameLayout.addView(this.ve);
        this.tt = c(frameLayout, context);
        this.n = new TextView(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        this.n.setId(2114387578);
        this.n.setGravity(17);
        layoutParams3.gravity = 8388691;
        layoutParams3.bottomMargin = pf.ve(this.c, 40.0f);
        layoutParams3.leftMargin = pf.ve(this.c, 20.0f);
        com.byazt.fh.uj.c(this.c, 1, this.n);
        this.n.setLayoutParams(layoutParams3);
        frameLayout.addView(this.n);
        return frameLayout;
    }

    private boolean tt(ic icVar) {
        r rVarVl;
        return (icVar == null || icVar.i() != 4 || icVar.rh() == null || (rVarVl = icVar.vl()) == null || rVarVl.c() == 0) ? false : true;
    }

    private void ve() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        try {
            View viewC = c(this.c);
            if (viewC == null) {
                return;
            }
            addView(viewC);
            SplashClickBar splashClickBar = new SplashClickBar(getContext(), this.sl);
            this.f28345a = splashClickBar;
            addView(splashClickBar);
            this.m = getResources().getConfiguration().orientation;
        } catch (Throwable unused) {
        }
    }

    public void tt() {
        TextView textView = this.n;
        if (textView != null) {
            textView.setVisibility(8);
        }
        com.byazt.but.uj ujVar = this.tt;
        if (ujVar == null || ujVar.getView() == null) {
            return;
        }
        this.tt.c(true);
        this.tt.getView().setVisibility(8);
    }

    public void c(ic icVar) {
        SplashClickBar splashClickBar = this.f28345a;
        if (splashClickBar == null) {
            return;
        }
        try {
            splashClickBar.c(icVar);
            pf.c(this.n, icVar);
        } catch (Throwable th) {
            m.c(th);
        }
    }

    public void c(int i, com.byazt.hkv.c cVar) {
        SplashClickBar splashClickBar = this.f28345a;
        if (splashClickBar != null) {
            splashClickBar.c(cVar);
        }
        if (i == 1) {
            cVar.c(this);
            setOnClickListenerInternal(cVar);
            setOnTouchListenerInternal(cVar);
        }
    }

    public void c() {
        TextView textView = this.n;
        if (textView != null) {
            z.c(this.c, "tt_ad_logo_backup", textView, 320);
        }
    }

    public com.byazt.but.uj c(FrameLayout frameLayout, Context context) {
        com.byazt.but.uj tTCountdownViewForBtn;
        FrameLayout.LayoutParams layoutParams;
        Resources resources = context.getResources();
        ic icVar = this.sl;
        iu iuVarCg = icVar == null ? null : icVar.cg();
        if ((iuVarCg == null ? 1 : iuVarCg.uj()) == 1) {
            tTCountdownViewForBtn = new TTCountdownViewForCircle(context);
            layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()));
        } else {
            tTCountdownViewForBtn = new TTCountdownViewForBtn(context);
            layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 76.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 26.0f, resources.getDisplayMetrics()));
        }
        if (tTCountdownViewForBtn.getView() != null) {
            tTCountdownViewForBtn.getView().setId(2114387579);
            layoutParams.gravity = 8388661;
            layoutParams.topMargin = pf.ve(this.c, 16.0f);
            layoutParams.rightMargin = pf.ve(this.c, 16.0f);
            tTCountdownViewForBtn.getView().setLayoutParams(layoutParams);
            frameLayout.addView(tTCountdownViewForBtn.getView());
        }
        return tTCountdownViewForBtn;
    }
}
