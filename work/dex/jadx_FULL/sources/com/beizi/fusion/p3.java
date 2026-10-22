package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.CoordinateBean;
import com.beizi.fusion.widget.ScrollClickView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class p3 extends d2 implements a2 {
    protected AdSpacesBean.BuyerBean.RenderAds A0;
    protected List B0;
    protected List C0;
    protected View U;
    protected View V;
    protected View W;
    protected ViewGroup X;
    protected ViewGroup Y;
    protected ViewGroup Z;
    protected ViewGroup a0;
    protected ViewGroup b0;
    protected ViewGroup c0;
    protected ViewGroup d0;
    protected ViewGroup e0;
    protected ImageView f0;
    protected ImageView g0;
    protected ImageView h0;
    protected ImageView i0;
    protected TextView j0;
    protected TextView k0;
    protected TextView l0;
    protected TextView m0;
    protected TextView n0;
    protected long o0;
    protected float p0;
    protected float q0;
    protected boolean r0 = false;
    protected boolean s0 = false;
    protected boolean t0 = false;
    protected Context u0;
    protected Activity v0;
    protected tn w0;
    protected hn x0;
    protected CountDownTimer y0;
    protected AdSpacesBean.RenderViewBean z0;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p3.this.O0();
        }
    }

    public class b implements z3.c {
        public b() {
        }

        @Override // com.beizi.fusion.z3.c
        public void a() {
        }

        @Override // com.beizi.fusion.z3.c
        public void a(Bitmap bitmap) {
            p3.this.h0.setImageBitmap(bitmap);
        }
    }

    public class c extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27634a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(long j, long j2, int i, int i2, int i3) {
            super(j, j2);
            this.f27634a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (this.c == 1) {
                p3.this.U0();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            p3 p3Var = p3.this;
            TextView textView = p3Var.j0;
            if (textView == null || p3Var.g0 == null) {
                return;
            }
            int i = (int) (j / 1000.0f);
            if (this.f27634a - i < this.b) {
                textView.setText(String.valueOf(i));
            } else {
                textView.setVisibility(8);
                p3.this.g0.setVisibility(0);
            }
        }
    }

    public class d implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f27635a;
        float b;
        float c;
        float d;
        final /* synthetic */ boolean e;
        final /* synthetic */ int f;
        final /* synthetic */ String g;
        final /* synthetic */ hn.d h;

        public d(boolean z, int i, String str, hn.d dVar) {
            this.e = z;
            this.f = i;
            this.g = str;
            this.h = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            hn.d dVar;
            hn.d dVar2;
            hn.d dVar3;
            hn.d dVar4;
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f27635a = motionEvent.getX();
                this.b = motionEvent.getY();
                this.c = motionEvent.getX();
                this.d = motionEvent.getY();
                if (this.e) {
                    p3.this.X.onTouchEvent(motionEvent);
                } else {
                    p3.this.Z.dispatchTouchEvent(motionEvent);
                }
            } else if (action == 1) {
                jh.c("SlideClickUtil", "mCurPosX = " + this.c + ",mCurPosY = " + this.d + ",mPosX = " + this.f27635a + ",mPosY = " + this.b);
                float f = this.d;
                float f2 = this.b;
                float f3 = f - f2;
                float f4 = (float) this.f;
                if (f3 > f4) {
                    if (!TextUtils.isEmpty(p3.this.A0.getScrollCoordinate()) && !p3.this.A0.getScrollCoordinate().equals("-1:-1:-1:-1:-1:-1:-1:-1:-1")) {
                        p3.this.b(this.e);
                    } else if (ScrollClickView.DIR_DOWN.equalsIgnoreCase(this.g) && (dVar4 = this.h) != null) {
                        dVar4.b();
                    }
                } else if (f2 - f <= f4) {
                    float f5 = this.f27635a;
                    float f6 = this.c;
                    if (f5 - f6 > f4) {
                        if ("left".equalsIgnoreCase(this.g) && (dVar2 = this.h) != null) {
                            dVar2.b();
                        }
                    } else if (f6 - f5 > f4) {
                        if ("right".equalsIgnoreCase(this.g) && (dVar = this.h) != null) {
                            dVar.b();
                        }
                    } else if (this.e) {
                        p3.this.X.onTouchEvent(motionEvent);
                    } else {
                        p3.this.Z.dispatchTouchEvent(motionEvent);
                    }
                } else if (ScrollClickView.DIR_UP.equalsIgnoreCase(this.g) && (dVar3 = this.h) != null) {
                    dVar3.b();
                }
            } else if (action == 2) {
                this.c = motionEvent.getX();
                this.d = motionEvent.getY();
            }
            return true;
        }
    }

    public p3(Context context, long j, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, m3 m3Var, int i) {
        this.u0 = context;
        this.o0 = j;
        this.e = buyerBean;
        this.d = m3Var;
        this.D = i;
        this.f = forwardBean;
        this.p0 = so.h(context);
        this.q0 = so.e(context);
        W0();
        C();
    }

    private void X0() {
        m3 m3Var = this.d;
        if (m3Var == null) {
            return;
        }
        Log.d("BeiZis", x() + " NativeAdWorker:" + m3Var.C().toString());
        f();
        s5 s5Var = this.g;
        if (s5Var == s5.SUCCESS) {
            h1();
            if (this.W != null) {
                this.d.b(x(), this.W);
                return;
            } else {
                this.d.a(10140);
                return;
            }
        }
        if (s5Var == s5.FAIL) {
            Log.d("BeiZis", "other worker shown," + x() + " remove");
        }
    }

    private void Z0() {
        ((FrameLayout) this.U).removeView(this.W);
    }

    private void b(Activity activity) {
        if (activity == null || this.W == null) {
            return;
        }
        View decorView = activity.getWindow().getDecorView();
        this.U = decorView;
        if (decorView instanceof FrameLayout) {
            so.a(this.W);
            ((FrameLayout) this.U).addView(this.W);
            b(this.Y);
        }
    }

    private void c(int i, int i2) {
        a(this.X, this.A0.getBgCoordinate(), i, i2);
        int i3 = this.X.getLayoutParams().width;
        int i4 = this.X.getLayoutParams().height;
        b(i3, i4);
        h(i3, i4);
    }

    private void d(int i, int i2) {
        a(this.b0, this.A0.getCloseCoordinate(), i, i2);
    }

    private void e(int i, int i2) {
        a(this.l0, this.A0.getDescCoordinate(), i, i2);
        if (TextUtils.isEmpty(Q0())) {
            return;
        }
        this.l0.setText(Q0());
    }

    private void e1() {
        List<String> clickView = this.A0.getClickView();
        ArrayList arrayList = new ArrayList();
        if (clickView != null && clickView.size() > 0) {
            if (clickView.contains("bg")) {
                arrayList.add(this.X);
                arrayList.add(this.Z);
                arrayList.add(this.d0);
            } else if (clickView.contains("ad")) {
                arrayList.add(this.Z);
            } else {
                if (clickView.contains("image")) {
                    arrayList.add(this.a0);
                }
                if (clickView.contains("title")) {
                    arrayList.add(this.k0);
                }
                if (clickView.contains("desc")) {
                    arrayList.add(this.l0);
                }
                if (clickView.contains(RemoteMessageConst.Notification.ICON)) {
                    arrayList.add(this.h0);
                }
                if (clickView.contains("target")) {
                    arrayList.add(this.c0);
                }
            }
        }
        a(arrayList);
    }

    private void f(int i, int i2) {
        a(this.h0, this.A0.getIconCoordinate(), i, i2);
        if (this.h0.getVisibility() != 0 || TextUtils.isEmpty(R0())) {
            return;
        }
        z3.a(this.u0).a(R0(), new b());
    }

    private void g(int i, int i2) {
        a(this.a0, this.A0.getImageCoordinate(), i, i2);
        g1();
    }

    private void i(int i, int i2) {
        a(this.k0, this.A0.getTitleCoordinate(), i, i2);
        if (TextUtils.isEmpty(T0())) {
            return;
        }
        this.k0.setText(T0());
    }

    @Override // com.beizi.fusion.d2
    public void A0() {
        if (this.d == null || S0() == -1) {
            return;
        }
        this.h = this.e.getAppId();
        this.i = this.e.getSpaceId();
        this.c = this.e.getBuyerSpaceUuId();
        List<AdSpacesBean.RenderViewBean> renderView = this.e.getRenderView();
        this.B0 = renderView;
        if (renderView != null && renderView.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean = (AdSpacesBean.RenderViewBean) this.B0.get(0);
            this.z0 = renderViewBean;
            this.C0 = k6.a(renderViewBean.getDpLinkUrlList());
        }
        ik ikVar = this.f27152a;
        if (ikVar != null) {
            EventBean eventBeanB = ikVar.a().b(this.c);
            this.b = eventBeanB;
            if (eventBeanB != null) {
                D();
                a1();
            }
        }
    }

    @Override // com.beizi.fusion.d2
    public void G0() {
    }

    public void M0() {
        Log.d("BeiZis", "showUnifiedCustomAd Callback --> onADClicked()");
        m3 m3Var = this.d;
        if (m3Var != null && m3Var.z() != 2) {
            this.d.b(x());
        }
        if (this.s0) {
            return;
        }
        this.s0 = true;
        Y();
        I0();
        if (this.D != 2) {
            U0();
        }
    }

    public void N0() {
        Log.d("BeiZis", "showUnifiedCustomAd Callback --> onAdShow()");
        this.j = b2.ADSHOW;
        m3 m3Var = this.d;
        if (m3Var != null && m3Var.z() != 2) {
            this.d.d(x());
        }
        if (this.r0) {
            return;
        }
        this.r0 = true;
        f1();
        i0();
        d0();
        L0();
    }

    public abstract void O0();

    public abstract String P0();

    public abstract String Q0();

    public abstract String R0();

    public abstract int S0();

    public abstract String T0();

    public void U0() {
        Log.d("BeiZis", "UnifiedCustomAd onADClosed()");
        tn tnVar = this.w0;
        if (tnVar != null) {
            tnVar.q();
        }
        hn hnVar = this.x0;
        if (hnVar != null) {
            hnVar.b();
        }
        y();
        b0();
        c(this.v0);
    }

    public void V0() {
        if (this.A0 != null) {
            c((int) this.p0, (int) this.q0);
            this.g0.setOnClickListener(new a());
        }
        this.W = this.V;
        c1();
    }

    public void W0() {
        if (S0() == -1) {
            return;
        }
        View viewInflate = LayoutInflater.from(this.u0).inflate(S0(), (ViewGroup) null);
        this.V = viewInflate;
        this.X = (ViewGroup) viewInflate.findViewById(R.id.rl_bg_container);
        this.Y = (ViewGroup) this.V.findViewById(R.id.rl_anim_container);
        this.Z = (ViewGroup) this.V.findViewById(R.id.rl_container);
        this.a0 = (ViewGroup) this.V.findViewById(R.id.fl_img_container);
        this.f0 = (ImageView) this.V.findViewById(R.id.iv_imageview);
        this.b0 = (ViewGroup) this.V.findViewById(R.id.rl_close);
        this.j0 = (TextView) this.V.findViewById(R.id.tv_close);
        this.g0 = (ImageView) this.V.findViewById(R.id.iv_close);
        this.k0 = (TextView) this.V.findViewById(R.id.tv_title);
        this.l0 = (TextView) this.V.findViewById(R.id.tv_desc);
        this.h0 = (ImageView) this.V.findViewById(R.id.iv_icon);
        this.c0 = (ViewGroup) this.V.findViewById(R.id.rl_action);
        this.m0 = (TextView) this.V.findViewById(R.id.tv_action);
        this.d0 = (ViewGroup) this.V.findViewById(R.id.rl_slide_down_container);
        this.n0 = (TextView) this.V.findViewById(R.id.tv_slide_down_title);
        this.i0 = (ImageView) this.V.findViewById(R.id.iv_slide_down_arrow);
        this.e0 = (ViewGroup) this.V.findViewById(R.id.fl_event_container);
    }

    public void Y0() {
        try {
            if (V()) {
                X0();
            } else {
                A();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.d2
    public void a(Activity activity) {
        try {
            if (this.t0) {
                return;
            }
            this.t0 = true;
            this.v0 = activity;
            b(activity);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public abstract void a(List list);

    public abstract void a1();

    public abstract void b(boolean z);

    public abstract void b1();

    public abstract void c1();

    public void d1() {
    }

    public void f1() {
        AdSpacesBean.BuyerBean.RenderAds renderAds;
        if (this.j0 == null || this.g0 == null || (renderAds = this.A0) == null) {
            return;
        }
        if (renderAds.getAutoClose() == 0 && this.A0.getMinTime() == 0) {
            this.j0.setVisibility(8);
            this.g0.setVisibility(0);
        } else {
            this.g0.setVisibility(8);
            this.j0.setVisibility(0);
            a(this.A0.getAutoClose(), this.A0.getMinTime(), this.A0.getMaxTime());
        }
        this.b0.setVisibility(0);
    }

    @Override // com.beizi.fusion.d2
    public abstract void g();

    public abstract void g1();

    @Override // com.beizi.fusion.d2
    public b2 h() {
        return this.j;
    }

    public abstract void h1();

    @Override // com.beizi.fusion.d2
    public AdSpacesBean.BuyerBean m() {
        return this.e;
    }

    @Override // com.beizi.fusion.d2
    public View r() {
        return this.W;
    }

    @Override // com.beizi.fusion.d2
    public abstract String x();

    @Override // com.beizi.fusion.d2
    public void z0() {
        g0();
        K0();
        this.A0 = this.e.getRenderAds();
        b1();
    }

    private void h(int i, int i2) {
        b(this.d0, this.A0.getScrollCoordinate(), i, i2);
    }

    private void a(int i, int i2) {
        a(this.c0, this.A0.getActionCoordinate(), i, i2);
        if (TextUtils.isEmpty(P0())) {
            return;
        }
        this.m0.setText(P0());
    }

    private void b(View view) {
        if (view != null) {
            view.setVisibility(8);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(500L);
            view.setVisibility(0);
            view.startAnimation(translateAnimation);
        }
    }

    private void c(Activity activity) {
        if (activity != null) {
            if (this.U == null) {
                this.U = activity.getWindow().getDecorView();
            }
            if (this.U instanceof FrameLayout) {
                Z0();
            }
        }
        g();
    }

    private void a(int i, int i2, int i3) {
        CountDownTimer countDownTimer = this.y0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        c cVar = new c(600 + (((long) i3) * 1000), 1000L, i3, i2, i);
        this.y0 = cVar;
        cVar.start();
    }

    private void b(int i, int i2) {
        String adCoordinate = this.A0.getAdCoordinate();
        a(this.Z, adCoordinate, i, i2);
        a(this.e0, adCoordinate, i, i2);
        int i3 = this.Z.getLayoutParams().width;
        int i4 = this.Z.getLayoutParams().height;
        g(i3, i4);
        i(i3, i4);
        e(i3, i4);
        f(i3, i4);
        a(i3, i4);
        d(i3, i4);
        d1();
        e1();
    }

    private void a(View view, String str, int i, int i2) {
        RelativeLayout.LayoutParams layoutParams;
        boolean z;
        if (view == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            view.setVisibility(8);
            return;
        }
        if (str.equals("-1:-1:-1:-1:-1:-1:-1:-1:-1")) {
            view.setVisibility(8);
            return;
        }
        CoordinateBean coordinate = CoordinateBean.getCoordinate(str);
        if (coordinate == null) {
            view.setVisibility(8);
            return;
        }
        int[] iArrA = a(coordinate, i, i2);
        int[] iArrA2 = a(coordinate, i, i2, iArrA);
        boolean z2 = view instanceof TextView;
        if (z2) {
            layoutParams = new RelativeLayout.LayoutParams(iArrA2[0], -2);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(iArrA2[0], iArrA2[1]);
        }
        layoutParams.setMargins(iArrA[0], iArrA[1], iArrA[2], iArrA[3]);
        if (!coordinate.getTop().equals("-1") || coordinate.getBottom().equals("-1")) {
            z = false;
        } else {
            layoutParams.addRule(12, -1);
            z = true;
        }
        if (coordinate.getLeft().equals("-1") && !coordinate.getRight().equals("-1")) {
            layoutParams.addRule(11, -1);
        }
        view.setLayoutParams(layoutParams);
        if (!coordinate.getFontOrCorner().equals("-1")) {
            if (z2) {
                ((TextView) view).setTextSize(Float.parseFloat(coordinate.getFontOrCorner()));
            } else if (view.getBackground() instanceof GradientDrawable) {
                GradientDrawable gradientDrawable = (GradientDrawable) view.getBackground();
                if (view != this.b0 && view != this.c0) {
                    int iA = so.a(this.u0, Float.parseFloat(coordinate.getFontOrCorner()));
                    if (z) {
                        float f = iA;
                        gradientDrawable.setCornerRadii(new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f});
                    } else {
                        gradientDrawable.setCornerRadius(iA);
                    }
                } else {
                    gradientDrawable.setCornerRadius(iArrA2[1]);
                }
            }
        }
        if (coordinate.getColor().equals("-1")) {
            return;
        }
        if (z2) {
            ((TextView) view).setTextColor(Color.parseColor(coordinate.getColor()));
        } else if (view != this.e0) {
            if (view.getBackground() instanceof GradientDrawable) {
                ((GradientDrawable) view.getBackground()).setColor(Color.parseColor(coordinate.getColor()));
            } else {
                view.setBackgroundColor(Color.parseColor(coordinate.getColor()));
            }
        }
    }

    private int b(String str, int i) {
        if (str.contains("%")) {
            return (i * ((int) Float.parseFloat(str.substring(0, str.indexOf("%"))))) / 100;
        }
        return so.a(this.u0, Float.parseFloat(str));
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0145  */
    /* JADX WARN: Code duplicated, block: B:47:0x0170  */
    /* JADX WARN: Code duplicated, block: B:91:0x0266  */
    private void b(View view, String str, int i, int i2) {
        int iA;
        int i3;
        char c2;
        int i4;
        char c3;
        int i5;
        int iB;
        int iB2;
        if (view == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            view.setVisibility(8);
            return;
        }
        if (str.equals("-1:-1:-1:-1:-1:-1:-1:-1:-1")) {
            view.setVisibility(8);
            return;
        }
        CoordinateBean coordinate = CoordinateBean.getCoordinate(str);
        if (coordinate == null) {
            view.setVisibility(8);
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (!coordinate.getScale().equals("-1")) {
            this.n0.setText(coordinate.getScale());
        }
        if (!coordinate.getFontOrCorner().equals("-1")) {
            this.n0.setTextSize(Float.parseFloat(coordinate.getFontOrCorner()));
        }
        if (!coordinate.getColor().equals("-1")) {
            this.n0.setTextColor(Color.parseColor(coordinate.getColor()));
        }
        if (coordinate.getWidth().equals("-1")) {
            iA = 0;
            i3 = 0;
        } else {
            iA = so.a(this.u0, Float.parseFloat(coordinate.getWidth()));
            i3 = (int) (((double) iA) / 0.8d);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(iA, i3);
            layoutParams2.gravity = 1;
            this.i0.setLayoutParams(layoutParams2);
            this.i0.setImageDrawable(this.u0.getResources().getDrawable(R.drawable.beizi_slide_down_close_ad));
            ((AnimationDrawable) this.i0.getDrawable()).start();
        }
        int i6 = this.Z.getLayoutParams().width;
        int i7 = this.Z.getLayoutParams().height;
        this.n0.measure(View.MeasureSpec.makeMeasureSpec(com.google.common.collect.c.d, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(com.google.common.collect.c.d, Integer.MIN_VALUE));
        int measuredWidth = this.n0.getMeasuredWidth();
        int measuredHeight = this.n0.getMeasuredHeight();
        int iMax = Math.max(measuredWidth, iA);
        int i8 = measuredHeight + i3;
        int iA2 = so.a(this.u0, Float.parseFloat(coordinate.getHeight())) + i7;
        if (!coordinate.getHeight().equals("-1")) {
            layoutParams.addRule(12, -1);
            if (coordinate.getLeft().equals("-1")) {
                iB = 0;
            } else {
                if (coordinate.getLeft().contains("%")) {
                    iB = b(coordinate.getLeft(), i6) - (iMax / 2);
                } else {
                    iB = b(coordinate.getLeft(), i6);
                }
                if (iB <= 0) {
                    iB = 0;
                }
            }
            if (coordinate.getRight().equals("-1")) {
                iB2 = 0;
            } else {
                if (coordinate.getRight().contains("%")) {
                    iB2 = b(coordinate.getRight(), i6) - (iMax / 2);
                } else {
                    iB2 = b(coordinate.getRight(), i6);
                }
                if (iB2 <= 0) {
                    iB2 = 0;
                }
            }
            if (iB <= 0 && iB2 <= 0) {
                layoutParams.addRule(14, -1);
            } else if (iB > 0) {
                layoutParams.addRule(9, -1);
            } else {
                layoutParams.addRule(11, -1);
            }
            layoutParams.setMargins(iB, 0, iB2, iA2);
            i4 = 0;
        } else {
            int[] iArr = {0, 0, 0, 0};
            if (!coordinate.getLeft().equals("-1")) {
                if (coordinate.getLeft().contains("%")) {
                    i5 = 0;
                    iArr[0] = b(coordinate.getLeft(), i) - (iMax / 2);
                } else {
                    i5 = 0;
                    iArr[0] = b(coordinate.getLeft(), i);
                }
                if (iArr[i5] <= 0) {
                    iArr[i5] = i5;
                }
            }
            if (!coordinate.getTop().equals("-1")) {
                if (coordinate.getTop().contains("%")) {
                    c3 = 1;
                    iArr[1] = b(coordinate.getTop(), i2) - (i8 / 2);
                } else {
                    c3 = 1;
                    iArr[1] = b(coordinate.getTop(), i2);
                }
                if (iArr[c3] <= 0) {
                    iArr[c3] = 0;
                }
            }
            if (!coordinate.getRight().equals("-1")) {
                if (coordinate.getRight().contains("%")) {
                    iArr[2] = b(coordinate.getRight(), i) - (iMax / 2);
                } else {
                    iArr[2] = b(coordinate.getRight(), i);
                }
                if (iArr[2] <= 0) {
                    iArr[2] = 0;
                }
            }
            if (coordinate.getBottom().equals("-1")) {
                c2 = 0;
            } else {
                if (coordinate.getBottom().contains("%")) {
                    iArr[3] = b(coordinate.getBottom(), i2) - (i8 / 2);
                } else {
                    iArr[3] = b(coordinate.getBottom(), i2);
                }
                if (iArr[3] <= 0) {
                    c2 = 0;
                    iArr[3] = 0;
                } else {
                    c2 = 0;
                }
            }
            int i9 = iArr[c2];
            if (i9 <= 0 && iArr[2] <= 0) {
                layoutParams.addRule(14, -1);
            } else if (i9 > 0) {
                layoutParams.addRule(9, -1);
            } else {
                layoutParams.addRule(11, -1);
            }
            int i10 = iArr[1];
            if (i10 <= 0 && iArr[3] <= 0) {
                layoutParams.addRule(15, -1);
            } else if (i10 > 0) {
                layoutParams.addRule(10, -1);
            } else {
                layoutParams.addRule(12, -1);
            }
            i4 = 0;
            layoutParams.setMargins(iArr[0], iArr[1], iArr[2], iArr[3]);
        }
        view.setLayoutParams(layoutParams);
        view.setVisibility(i4);
        if (TextUtils.isEmpty(this.A0.getScrollCoordinate()) || this.A0.getScrollCoordinate().equals("-1:-1:-1:-1:-1:-1:-1:-1:-1")) {
            return;
        }
        a((View) this.X);
        a((View) this.e0);
    }

    private int[] a(CoordinateBean coordinateBean, int i, int i2, int[] iArr) {
        int iB;
        int iB2;
        if (coordinateBean.getWidth().equals("-1")) {
            iB = (i - iArr[0]) - iArr[2];
        } else {
            iB = b(coordinateBean.getWidth(), i);
        }
        if (!coordinateBean.getScale().equals("-1") && !coordinateBean.getScale().equals("0")) {
            iB2 = (int) (iB / Float.parseFloat(coordinateBean.getScale()));
        } else if (coordinateBean.getHeight().equals("-1")) {
            iB2 = (i2 - iArr[1]) - iArr[3];
        } else {
            iB2 = b(coordinateBean.getHeight(), i2);
        }
        return new int[]{iB, iB2};
    }

    private int[] a(CoordinateBean coordinateBean, int i, int i2) {
        String left = coordinateBean.getLeft();
        int iB = (left.equals("0%") || left.equals("0") || left.equals("-1")) ? 0 : b(left, i);
        String top = coordinateBean.getTop();
        int iB2 = (top.equals("0%") || top.equals("0") || top.equals("-1")) ? 0 : b(top, i2);
        String right = coordinateBean.getRight();
        int iB3 = (right.equals("0%") || right.equals("0") || right.equals("-1")) ? 0 : b(right, i);
        String bottom = coordinateBean.getBottom();
        return new int[]{iB, iB2, iB3, (bottom.equals("0%") || bottom.equals("0") || bottom.equals("-1")) ? 0 : b(bottom, i2)};
    }

    public void a(View view) {
        a(view, "", 30, (hn.d) null);
    }

    public void a(View view, String str, int i, hn.d dVar) {
        view.setOnTouchListener(new d(view == this.X, so.a(this.u0, i), str, dVar));
    }
}
