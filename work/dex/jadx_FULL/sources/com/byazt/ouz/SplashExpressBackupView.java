package com.byazt.ouz;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.ete.xd;
import com.byazt.ete.zb;
import com.byazt.oq.GifView;
import com.byazt.ui.UpieImageView;
import com.byazt.un.NativeVideoTsView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 2188})
public class SplashExpressBackupView extends BackupView implements com.byazt.dh.ve.InterfaceC0386ve {
    public NativeVideoTsView gt;
    public TextView m;
    public com.byazt.uph.tt my;
    public Button nu;
    public FrameLayout rh;
    public com.byazt.dh.ve.InterfaceC0386ve rl;
    public NativeExpressView u;
    public View yp;
    public GifView z;

    public SplashExpressBackupView(Context context) {
        super(context);
        this.c = context;
        this.n = "splash_ad";
    }

    private void a() {
        da();
        this.z.setVisibility(0);
        this.rh.setVisibility(8);
        c(this.z, this.tt, this.my);
        this.m.setText(this.tt.op());
        if (this.tt.mf() != null) {
            pf.c((View) this.nu, 8);
        } else {
            pf.c((View) this.nu, 0);
            this.nu.setText(this.tt.tj());
            c((View) this.nu, true);
        }
        setExpressBackupListener(this.yp);
    }

    private void da() {
        View viewC = c(this.c);
        if (viewC == null) {
            return;
        }
        addView(viewC);
    }

    private void i() {
        GifView gifView = new GifView(this.c);
        gifView.setScaleType(ImageView.ScaleType.FIT_XY);
        c(gifView, this.tt, this.my);
        addView(gifView, new ViewGroup.LayoutParams(-1, -1));
        setExpressBackupListener(this);
    }

    private void n() {
        da();
        this.z.setVisibility(0);
        this.rh.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.z.getLayoutParams();
        layoutParams.height = pf.ve(this.c, 291.0f);
        this.z.setLayoutParams(layoutParams);
        c(this.z, this.tt, this.my);
        this.m.setText(this.tt.op());
        if (this.tt.mf() != null) {
            pf.c((View) this.nu, 8);
        } else {
            pf.c((View) this.nu, 0);
            this.nu.setText(this.tt.tj());
            c((View) this.nu, true);
        }
        setExpressBackupListener(this.yp);
    }

    private void setExpressBackupListener(View view) {
        ic icVar = this.tt;
        if (icVar == null || icVar.pl() != 1) {
            return;
        }
        c(view, true);
    }

    private void sp() {
        da();
        this.z.setVisibility(8);
        this.rh.setVisibility(0);
        if (xd.z(this.tt) != null) {
            NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) c(this.u);
            this.gt = nativeVideoTsView;
            nativeVideoTsView.setVideoAdInteractionListener(this);
            if (this.gt == null) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.rh.addView(this.gt, layoutParams);
        }
        this.m.setText(this.tt.op());
        if (this.tt.mf() != null) {
            pf.c((View) this.nu, 8);
        } else {
            pf.c((View) this.nu, 0);
            this.nu.setText(this.tt.tj());
            c((View) this.nu, true);
        }
        setExpressBackupListener(this.yp);
    }

    private void tt() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f28915a, this.sp);
        }
        layoutParams.width = this.f28915a;
        layoutParams.height = this.sp;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        c(this.tt.id(), this.tt);
    }

    private boolean uj() {
        ic icVar = this.tt;
        return icVar != null && icVar.by() == 2;
    }

    private boolean ve() {
        NativeExpressView nativeExpressView = this.u;
        if (nativeExpressView instanceof NativeExpressVideoView) {
            return false;
        }
        boolean z = nativeExpressView instanceof NativeExpressView;
        return true;
    }

    private void x() {
        NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) c(this.u);
        this.gt = nativeVideoTsView;
        nativeVideoTsView.setVideoAdInteractionListener(this);
        NativeVideoTsView nativeVideoTsView2 = this.gt;
        if (nativeVideoTsView2 == null) {
            return;
        }
        addView(nativeVideoTsView2);
        setExpressBackupListener(this);
    }

    @Override // com.byazt.ouz.BackupView
    public void c(View view, int i, com.byazt.ete.gr grVar) {
        NativeExpressView nativeExpressView = this.u;
        if (nativeExpressView != null) {
            nativeExpressView.c(view, i, grVar, -1);
        }
    }

    public com.byazt.dh.ve getVideoController() {
        NativeVideoTsView nativeVideoTsView = this.gt;
        if (nativeVideoTsView == null) {
            return null;
        }
        return nativeVideoTsView.getNativeVideoController();
    }

    @Override // com.byazt.dh.ve.InterfaceC0386ve
    public void onProgressUpdate(long j, long j2) {
    }

    @Override // com.byazt.dh.ve.InterfaceC0386ve
    public void onVideoAdContinuePlay() {
    }

    @Override // com.byazt.dh.ve.InterfaceC0386ve
    public void onVideoAdPaused() {
    }

    @Override // com.byazt.dh.ve.InterfaceC0386ve
    public void onVideoAdStartPlay() {
    }

    @Override // com.byazt.dh.ve.InterfaceC0386ve
    public void onVideoComplete() {
        com.byazt.dh.ve.InterfaceC0386ve interfaceC0386ve = this.rl;
        if (interfaceC0386ve != null) {
            interfaceC0386ve.onVideoComplete();
        }
    }

    public void setVideoAdListener(com.byazt.dh.ve.InterfaceC0386ve interfaceC0386ve) {
        this.rl = interfaceC0386ve;
    }

    public void c(com.byazt.uph.tt ttVar, ic icVar, NativeExpressView nativeExpressView) {
        this.tt = icVar;
        this.u = nativeExpressView;
        this.f28915a = pf.ve(this.c, nativeExpressView.getExpectExpressWidth());
        this.sp = pf.ve(this.c, this.u.getExpectExpressWidth());
        this.my = ttVar;
        tt();
        this.u.addView(this, new ViewGroup.LayoutParams(-1, -1));
    }

    private void c(int i, ic icVar) {
        if (!ve()) {
            if (i != 5) {
                x();
                return;
            } else {
                sp();
                return;
            }
        }
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        i();
                        return;
                    }
                }
            }
            if (uj()) {
                i();
                return;
            } else {
                a();
                return;
            }
        }
        n();
    }

    private View c(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackground(com.byazt.vfu.n.tt());
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = pf.ve(context, 79.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setText("今日推荐");
        textView.setGravity(17);
        textView.setTextSize(2, 30.0f);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        textView.setTextColor(Color.parseColor("#895434"));
        linearLayout.addView(textView);
        TextView textView2 = new TextView(context);
        this.m = textView2;
        textView2.setId(2114387471);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 218.0f, resources.getDisplayMetrics()), -2);
        layoutParams3.topMargin = pf.ve(context, 31.0f);
        layoutParams3.gravity = 1;
        this.m.setLayoutParams(layoutParams3);
        this.m.setGravity(1);
        this.m.setTextSize(2, 15.0f);
        this.m.setTextColor(Color.parseColor("#895434"));
        this.m.setSingleLine(false);
        linearLayout.addView(this.m);
        GifView gifView = new GifView(context);
        this.z = gifView;
        gifView.setId(2114387470);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 219.0f, resources.getDisplayMetrics()));
        layoutParams4.topMargin = pf.ve(context, 29.0f);
        layoutParams4.setMarginStart(pf.ve(context, 15.0f));
        layoutParams4.setMarginEnd(pf.ve(context, 15.0f));
        layoutParams4.gravity = 1;
        this.z.setLayoutParams(layoutParams4);
        this.z.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(this.z);
        FrameLayout frameLayout = new FrameLayout(context);
        this.rh = frameLayout;
        frameLayout.setId(2114387469);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 185.0f, resources.getDisplayMetrics()));
        layoutParams5.setMarginStart(pf.ve(context, 15.0f));
        layoutParams5.setMarginEnd(pf.ve(context, 15.0f));
        this.rh.setLayoutParams(layoutParams5);
        this.rh.setVisibility(8);
        linearLayout.addView(this.rh);
        Button button = new Button(context);
        this.nu = button;
        button.setId(2114387468);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 145.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 43.0f, resources.getDisplayMetrics()));
        layoutParams6.topMargin = pf.ve(context, 37.0f);
        layoutParams6.gravity = 1;
        this.nu.setLayoutParams(layoutParams6);
        this.nu.setText("立即下载");
        this.nu.setTextColor(Color.parseColor("#ffffff"));
        this.nu.setTypeface(Typeface.defaultFromStyle(1));
        this.nu.setBackground(com.byazt.vfu.n.tt(context));
        linearLayout.addView(this.nu);
        return linearLayout;
    }

    private void c(GifView gifView) {
        zb zbVar = this.tt.pa().get(0);
        if (zbVar != null) {
            com.byazt.xky.tt.c(zbVar).to(gifView);
        }
        if (com.byazt.ic.c.uj(this.tt)) {
            UpieImageView upieImageView = new UpieImageView(gifView.getContext(), com.byazt.ic.c.i(this.tt), com.byazt.nj.c.c(this.tt), com.byazt.ic.c.da(this.tt));
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            com.byazt.ic.c.c(gifView, upieImageView);
        }
    }

    public void c(byte[] bArr, GifView gifView) {
        if (bArr == null || gifView == null) {
            return;
        }
        gifView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        gifView.c(bArr, false);
    }

    public void c(Drawable drawable, GifView gifView) {
        if (drawable == null || gifView == null) {
            return;
        }
        gifView.setImageDrawable(drawable);
    }

    public void c(GifView gifView, ic icVar, com.byazt.uph.tt ttVar) {
        Drawable drawableC;
        if (ttVar == null) {
            c(gifView);
            return;
        }
        if (ttVar.n()) {
            c(ttVar.ve(), gifView);
            return;
        }
        if (icVar.pa() == null || icVar.pa().get(0) == null) {
            return;
        }
        if (ttVar.c() != null) {
            drawableC = new BitmapDrawable(ttVar.c());
        } else {
            drawableC = com.byazt.aas.m.c(ttVar.ve(), icVar.pa().get(0).tt());
        }
        c(drawableC, gifView);
        if (com.byazt.ic.c.uj(this.tt)) {
            UpieImageView upieImageView = new UpieImageView(gifView.getContext(), com.byazt.ic.c.i(this.tt), com.byazt.nj.c.c(this.tt), com.byazt.ic.c.da(this.tt));
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            com.byazt.ic.c.c(gifView, upieImageView);
        }
    }

    @Override // com.byazt.ouz.BackupView
    public void c(View view, boolean z) {
        ic icVar = this.tt;
        if (icVar == null || icVar.mf() == null || this.tt.mf().c() != 1) {
            return;
        }
        super.c(view, z);
    }
}
