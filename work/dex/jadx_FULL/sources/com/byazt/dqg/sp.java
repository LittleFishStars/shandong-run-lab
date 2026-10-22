package com.byazt.dqg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.ete.bx;
import com.byazt.ete.ic;
import com.byazt.ete.xd;
import com.byazt.ete.zb;
import com.byazt.ff.TTRoundRectImageView;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.omf.gt;
import com.byazt.ui.UpieImageView;
import com.byazt.yj.gr;
import com.byazt.yj.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 74, 91})
public class sp extends tt {
    public TextView m;
    public UpieImageView my;
    public TextView nu;
    public TextView rh;
    public ImageView yp;
    public TTRoundRectImageView z;

    public sp(TTBaseVideoActivity tTBaseVideoActivity, ic icVar, boolean z) {
        super(tTBaseVideoActivity, icVar, z);
    }

    private float a() {
        return pf.uj(this.tt, pf.i((Context) this.tt));
    }

    private float n() {
        return pf.uj(this.tt, pf.x((Context) this.tt));
    }

    private void tt() {
        int i = (int) (this.n * 1000.0f);
        if (i == 666 || i == 1500 || i == 1777 || i == 562 || i == 1000) {
            return;
        }
        c(this.uj == 1 ? 0.562f : 1.777f);
    }

    private void ve() {
        TextView textView;
        this.yp = (ImageView) this.tt.findViewById(2114387712);
        this.z = (TTRoundRectImageView) this.tt.findViewById(2114387722);
        this.m = (TextView) this.tt.findViewById(2114387702);
        this.nu = (TextView) this.tt.findViewById(2114387962);
        this.rh = (TextView) this.tt.findViewById(2114387719);
        if (com.byazt.ic.c.uj(this.ve)) {
            UpieImageView upieImageView = new UpieImageView(this.yp.getContext(), com.byazt.ic.c.i(this.ve), com.byazt.nj.c.c(this.ve), com.byazt.ic.c.da(this.ve));
            this.my = upieImageView;
            upieImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        if (!TextUtils.isEmpty(this.ve.tj()) && (textView = this.nu) != null) {
            textView.setText(this.ve.tj());
        }
        if (xd.z(this.ve) == null || !ic.ve(this.ve)) {
            c(this.yp, this.my);
            pf.c((View) this.yp, 0);
            pf.c((View) this.i, 8);
        } else {
            pf.c((View) this.yp, 8);
            pf.c((View) this.i, 0);
        }
        zb zbVarTe = this.ve.te();
        if (zbVarTe != null) {
            com.byazt.xky.tt.c(zbVarTe).to(this.z);
        }
        TextView textView2 = this.m;
        if (textView2 != null) {
            textView2.setText(yp());
        }
        TextView textView3 = this.rh;
        if (textView3 != null) {
            textView3.setText(z());
        }
        pf.c((TextView) this.tt.findViewById(2114387658), this.ve);
    }

    @Override // com.byazt.dqg.tt
    public void c() {
        super.c();
        this.i = (FrameLayout) this.tt.findViewById(2114387915);
        c((View) this.sp);
        if (com.byazt.ex.c.c(this.ve)) {
            uj();
        } else {
            ve();
            tt();
        }
    }

    @Override // com.byazt.dqg.tt
    public void uj(int i) {
        pf.c((View) this.sl, i);
    }

    private void uj() {
        this.sl = (RelativeLayout) this.tt.findViewById(2114387844);
        this.t = (TextView) this.tt.findViewById(2114387716);
        if (bx.c(this.ve)) {
            String strX = bx.x(this.ve);
            if (TextUtils.isEmpty(strX)) {
                return;
            }
            com.byazt.xky.tt.c(strX).config(Bitmap.Config.ARGB_4444).type(2).to(new gr<Bitmap>() { // from class: com.byazt.dqg.sp.2
                @Override // com.byazt.yj.gr
                public void onFailed(int i, String str, Throwable th) {
                }

                @Override // com.byazt.yj.gr
                public void onSuccess(m<Bitmap> mVar) {
                    Bitmap bitmapC = com.byazt.or.tt.c(sp.this.tt, mVar.getResult(), 25);
                    if (bitmapC == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(sp.this.tt.getResources(), bitmapC);
                    com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.dqg.sp.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup viewGroup = sp.this.sp;
                            if (viewGroup != null) {
                                viewGroup.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        }
    }

    private void c(View view) {
        ic icVar = this.ve;
        if (icVar == null || view == null) {
            return;
        }
        final float fJy = icVar.jy();
        if (fJy <= 0.0f) {
            return;
        }
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.byazt.dqg.sp.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), pf.ve(gt.getContext(), fJy));
            }
        });
        view.setClipToOutline(true);
    }

    private void c(float f) {
        float fMin;
        float fMax;
        int iMax;
        float fN = n();
        float fA = a();
        if (this.uj == 2) {
            fMin = Math.max(fN, fA);
            fMax = Math.min(fN, fA);
        } else {
            fMin = Math.min(fN, fA);
            fMax = Math.max(fN, fA);
        }
        int iMin = (int) (Math.min(fMin, fMax) * this.ve.qe());
        if (this.uj != 2) {
            TTBaseVideoActivity tTBaseVideoActivity = this.tt;
            fMax -= pf.uj(tTBaseVideoActivity, pf.da((Context) tTBaseVideoActivity));
        }
        if (this.uj != 2) {
            float f2 = iMin;
            iMin = (int) Math.max((fMax - (((fMin - f2) - f2) / f)) / 2.0f, 0.0f);
            iMax = iMin;
        } else {
            float f3 = iMin;
            iMax = (int) Math.max((fMin - (((fMax - f3) - f3) * f)) / 2.0f, 0.0f);
        }
        float f4 = iMin;
        float f5 = iMax;
        try {
            this.tt.getWindow().getDecorView().setPadding(pf.ve(this.tt, f5), pf.ve(this.tt, f4), pf.ve(this.tt, f5), pf.ve(this.tt, f4));
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.dqg.tt
    public void c(com.byazt.hkv.tt ttVar, com.byazt.hkv.tt ttVar2) {
        c(this.nu, ttVar, ttVar);
        c(this.t, ttVar, ttVar);
        c(this.i, ttVar2, ttVar2);
        c(this.yp, ttVar2, ttVar2);
        c(this.z, ttVar2, ttVar2);
        c(this.m, ttVar2, ttVar2);
        c(this.rh, ttVar2, ttVar2);
        c(this.sp, ttVar2, ttVar2);
        c(this.my, ttVar2, ttVar2);
    }

    private void c(View view, com.byazt.hkv.tt ttVar, View.OnTouchListener onTouchListener) {
        if (view == null) {
            return;
        }
        view.setOnTouchListener(onTouchListener);
        view.setOnClickListener(ttVar);
    }
}
