package com.byazt.gt;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.byazt.bj.a;
import com.byazt.bj.da;
import com.byazt.bj.n;
import com.byazt.bj.u;
import com.byazt.bj.uj;
import com.byazt.bj.yp;
import com.byazt.cd.ve;
import com.byazt.cd.x;
import com.byazt.sz.sp;
import com.byazt.vn.RoundImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 20})
public class c extends com.byazt.xj.c<YogaLayout> {
    public da cf;
    public a kz;
    public com.byazt.bj.c mq;
    public com.byazt.bj.c vi;
    public yp vp;
    public n yo;

    /* JADX INFO: renamed from: com.byazt.gt.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 44})
    public static class C0419c extends com.byazt.xj.c.C0576c {
        public boolean aw;
        public boolean bx;
        public int cu;
        public float d;
        public int eo;
        public int h;
        public boolean hd;
        public boolean ic;
        public float md;
        public float nb;
        public int or;
        public float p;
        public boolean pf;
        public int qp;
        public boolean sv;
        public int yv;
        public int zb;

        public C0419c(com.byazt.xj.c cVar) {
            super(cVar);
            this.yv = 1;
            this.p = 0.0f;
            this.md = 1.0f;
            this.h = com.byazt.bj.c.AUTO.c();
            this.d = -1.0f;
            this.eo = u.RELATIVE.c();
        }

        private void uj() {
            com.byazt.xj.c cVar = this.zm;
            if (cVar instanceof c) {
                if (((c) cVar).kk() == n.ROW && this.zm.or() == -2 && this.c == -1.0f && !this.zm.hd()) {
                    this.c = -2.0f;
                    this.md = 1.0f;
                    this.p = 1.0f;
                    this.pf = true;
                    this.d = -1.0f;
                }
                if (((c) this.zm).kk() == n.COLUMN && this.zm.cu() == -2 && this.tt == -1.0f && !this.zm.hd()) {
                    this.tt = -2.0f;
                    this.md = 1.0f;
                    this.p = 1.0f;
                    this.pf = true;
                    this.d = -1.0f;
                }
            }
        }

        @Override // com.byazt.xj.c.C0576c
        public String toString() {
            return "LayoutParams{mOrder=" + this.yv + ", mFlexGrow=" + this.p + ", mFlexShrink=" + this.md + ", mAlignSelf=" + this.h + ", mFlexBasis=" + this.d + ", mPosition=" + this.eo + ", mTop=" + this.zb + ", mBottom=" + this.or + ", mLeft=" + this.cu + ", mRight=" + this.qp + '}';
        }

        @Override // com.byazt.xj.c.C0576c
        /* JADX INFO: renamed from: tt, reason: merged with bridge method [inline-methods] */
        public YogaLayout.c c() {
            uj();
            YogaLayout.c cVar = new YogaLayout.c((int) this.c, (int) this.tt);
            cVar.t((int) (this.gt ? this.f29179a : this.n));
            cVar.yp((int) (this.rl ? this.sp : this.n));
            cVar.sl((int) (this.qy ? this.x : this.n));
            cVar.u((int) (this.gu ? this.i : this.n));
            cVar.c(this.yv);
            cVar.n(this.h);
            cVar.tt(this.p);
            cVar.ve(this.md);
            cVar.m(this.ve);
            cVar.nu(this.uj);
            if (this.pf) {
                cVar.uj(this.d);
            }
            cVar.a(this.eo);
            if (this.bx) {
                cVar.sp(this.zb);
            }
            if (this.sv) {
                cVar.i(this.or);
            }
            if (this.aw) {
                cVar.x(this.cu);
            }
            if (this.ic) {
                cVar.da(this.qp);
            }
            if (this.hd && ve()) {
                float f = this.nb;
                if (f > 0.0f) {
                    cVar.z(f);
                    cVar.ve(0.0f);
                    cVar.tt(0.0f);
                }
            }
            return cVar;
        }

        public boolean ve() {
            float f = this.c;
            if (f == -1.0f && this.tt == -1.0f) {
                return false;
            }
            return f == -2.0f || this.tt == -2.0f;
        }

        @Override // com.byazt.xj.c.C0576c
        public void c(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            super.c(context, str, str2);
            str.hashCode();
            switch (str) {
                case "flexBasis":
                    this.pf = true;
                    float fC = ve.c(str2, -1.0f);
                    this.d = fC;
                    this.d = x.c(context, fC);
                    break;
                case "bottom":
                    this.sv = true;
                    this.or = (int) x.c(context, ve.c(str2, 0));
                    break;
                case "top":
                    this.bx = true;
                    this.zb = (int) x.c(context, ve.c(str2, 0));
                    break;
                case "left":
                    this.aw = true;
                    this.cu = (int) x.c(context, ve.c(str2, 0));
                    break;
                case "order":
                    this.yv = ve.c(str2, 1);
                    break;
                case "ratio":
                    this.hd = true;
                    this.nb = ve.c(str2, 0.0f);
                    break;
                case "right":
                    this.ic = true;
                    this.qp = (int) x.c(context, ve.c(str2, 0));
                    break;
                case "position":
                    this.eo = u.c(str2).c();
                    break;
                case "flexShrink":
                    this.md = ve.c(str2, 1.0f);
                    break;
                case "flexGrow":
                    this.p = ve.c(str2, 0.0f);
                    break;
                case "alignSelf":
                    this.h = com.byazt.bj.c.c(str2).c();
                    break;
            }
        }
    }

    public c(Context context) {
        super(context);
        this.yo = n.ROW;
        this.vp = yp.NO_WRAP;
        this.kz = a.FLEX_START;
        com.byazt.bj.c cVar = com.byazt.bj.c.STRETCH;
        this.vi = cVar;
        this.mq = cVar;
    }

    @Override // com.byazt.xj.ve
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public YogaLayout c() {
        YogaLayout yogaLayout = new YogaLayout(this.tt);
        yogaLayout.c(this);
        this.cf = yogaLayout.getYogaNode();
        return yogaLayout;
    }

    public n kk() {
        return this.yo;
    }

    @Override // com.byazt.xj.c
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public C0419c x() {
        return new C0419c(this);
    }

    @Override // com.byazt.xj.ve
    public void yv() {
        ImageView.ScaleType scaleType;
        if (this.aw) {
            sp spVar = this.nt;
            if (spVar != null) {
                spVar.c();
            }
            com.byazt.sa.n.c().tt().c(this.i, this.pf, new com.byazt.sa.c.InterfaceC0516c() { // from class: com.byazt.gt.c.1
                @Override // com.byazt.sa.c.InterfaceC0516c
                public void c(Bitmap bitmap) {
                    if (bitmap == null) {
                        if (c.this.nt != null) {
                            sp spVar2 = c.this.nt;
                            c cVar = c.this;
                            spVar2.tt(cVar, cVar.pf);
                            return;
                        }
                        return;
                    }
                    if (c.this.nt != null) {
                        sp spVar3 = c.this.nt;
                        c cVar2 = c.this;
                        spVar3.c(cVar2, cVar2.pf);
                    }
                    final Bitmap bitmapC = x.c(c.this.tt, bitmap, (int) c.this.sv);
                    if (bitmapC != null) {
                        x.c(new Runnable() { // from class: com.byazt.gt.c.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.c(new BitmapDrawable(bitmapC));
                            }
                        });
                    }
                }
            });
            return;
        }
        sp spVar2 = this.nt;
        if (spVar2 != null) {
            spVar2.c();
        }
        RoundImageView roundImageView = new RoundImageView(this.tt);
        com.byazt.sa.n.c().tt().c(this.i, this.pf, roundImageView, this.n.getWidth(), this.n.getHeight(), new com.byazt.sa.c.InterfaceC0516c() { // from class: com.byazt.gt.c.2
            @Override // com.byazt.sa.c.InterfaceC0516c
            public void c(Bitmap bitmap) {
                if (bitmap == null) {
                    if (c.this.nt != null) {
                        sp spVar3 = c.this.nt;
                        c cVar = c.this;
                        spVar3.tt(cVar, cVar.pf);
                        return;
                    }
                    return;
                }
                if (c.this.nt != null) {
                    sp spVar4 = c.this.nt;
                    c cVar2 = c.this;
                    spVar4.c(cVar2, cVar2.pf);
                }
            }
        });
        if (!this.ic || (scaleType = this.bx) == ImageView.ScaleType.FIT_XY) {
            roundImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            roundImageView.setScaleType(scaleType);
        }
        roundImageView.setCornerRadius(this.hd);
        YogaLayout.c cVar = new YogaLayout.c(-1, -1);
        cVar.a(u.ABSOLUTE.c());
        cVar.sp(0.0f);
        cVar.x(0.0f);
        T t = this.n;
        if (t instanceof YogaLayout) {
            ((YogaLayout) t).addView(roundImageView, 0, cVar);
            c(roundImageView);
        }
    }

    @Override // com.byazt.xj.ve
    public void t() {
        if (this.eo) {
            this.cf.tt(uj.ALL, this.yv);
        }
        if (this.zb) {
            this.cf.tt(uj.LEFT, this.p);
        }
        if (this.or) {
            this.cf.tt(uj.RIGHT, this.md);
        }
        if (this.cu) {
            this.cf.tt(uj.TOP, this.h);
        }
        if (this.qp) {
            this.cf.tt(uj.BOTTOM, this.d);
        }
    }

    @Override // com.byazt.xj.c, com.byazt.xj.ve
    public void tt() {
        super.tt();
        this.cf.c(this.yo);
        this.cf.c(this.vp);
        this.cf.c(this.kz);
        this.cf.c(this.vi);
        this.cf.ve(this.mq);
        this.cf.c(true);
    }

    @Override // com.byazt.xj.ve
    public void c(Drawable drawable) {
        ImageView.ScaleType scaleType;
        RoundImageView roundImageView = new RoundImageView(this.tt);
        roundImageView.setImageDrawable(drawable);
        if (this.ic && (scaleType = this.bx) != ImageView.ScaleType.FIT_XY) {
            roundImageView.setScaleType(scaleType);
        } else {
            roundImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        roundImageView.setCornerRadius(this.hd);
        YogaLayout.c cVar = new YogaLayout.c(-1, -1);
        cVar.a(u.ABSOLUTE.c());
        cVar.sp(0.0f);
        cVar.x(0.0f);
        T t = this.n;
        if (t instanceof YogaLayout) {
            ((YogaLayout) t).addView(roundImageView, 0, cVar);
            c(roundImageView);
        }
    }

    private void c(final RoundImageView roundImageView) {
        this.n.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.gt.c.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                da daVarC;
                if (c.this.n == null || (daVarC = ((YogaLayout) c.this.n).c(roundImageView)) == null) {
                    return;
                }
                int width = c.this.n.getWidth();
                daVarC.uj(width);
                int height = c.this.n.getHeight();
                daVarC.a(height);
                roundImageView.setCornerRadius(c.this.hd);
                c.this.n.requestLayout();
                if (width > 0 || height > 0) {
                    c.this.n.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        });
    }

    @Override // com.byazt.xj.c
    public void c(com.byazt.xj.ve veVar) {
        super.c(veVar);
    }

    @Override // com.byazt.xj.c
    public void c(com.byazt.xj.ve veVar, ViewGroup.LayoutParams layoutParams) {
        if (veVar == null) {
            return;
        }
        ((com.byazt.xj.c) this).c.add(veVar);
        View viewI = veVar.i();
        if (viewI != null) {
            ((YogaLayout) this.n).addView(viewI, layoutParams);
        }
    }

    @Override // com.byazt.xj.ve
    public void c(String str, String str2) {
        super.c(str, str2);
        str.hashCode();
        switch (str) {
            case "alignItems":
                this.vi = com.byazt.bj.c.c(str2);
                break;
            case "flexDirection":
                this.yo = n.c(str2);
                break;
            case "alignContent":
                this.mq = com.byazt.bj.c.c(str2);
                break;
            case "flexWrap":
                this.vp = yp.c(str2);
                break;
            case "justifyContent":
                this.kz = a.c(str2);
                break;
        }
    }
}
