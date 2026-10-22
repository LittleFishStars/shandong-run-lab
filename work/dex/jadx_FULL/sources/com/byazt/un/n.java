package com.byazt.un;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.ete.xd;
import com.byazt.lbn.TTViewStub;
import com.byazt.nr.d;
import com.byazt.nr.m;
import com.byazt.nr.z;
import com.byazt.omf.gt;
import com.byazt.sgn.yp;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 96, 46})
public class n extends a {
    public TextView aw;
    public boolean b;
    public View bm;
    public View bx;
    public boolean dz;
    public yp f;
    public final View.OnTouchListener g;
    public ColorStateList gx;
    public float gy;
    public ImageView hd;
    public float hj;
    public float hq;
    public TextView ic;
    public boolean ir;
    public final Rect iu;
    public int j;
    public int kk;
    public final d kp;
    public TextView l;
    public View lo;
    public ImageView lr;
    public TextView lt;
    public int ma;
    public final Rect mm;
    public TextView nb;
    public float nt;
    public final Rect ny;
    public int os;
    public int oz;
    public ImageView pf;
    public final Rect pn;
    public SeekBar pu;
    public boolean q;
    public final Rect r;
    public ColorStateList s;
    public TextView sv;
    public ImageView tk;
    public TextView to;
    public int tx;
    public int v;
    public boolean vp;
    public ColorStateList xd;
    public float y;
    public int yf;
    public boolean yo;

    public n(Context context, View view, boolean z, EnumSet<com.byazt.dh.tt.c> enumSet, ic icVar, com.byazt.dh.ve veVar, boolean z2) {
        super(context, view, z, enumSet, icVar, veVar, z2, null);
        this.kp = new d(Looper.getMainLooper(), this);
        this.b = false;
        this.q = false;
        this.kk = 0;
        this.tx = 0;
        this.v = 0;
        this.os = 0;
        this.oz = 0;
        this.r = new Rect();
        this.iu = new Rect();
        this.j = 0;
        this.ma = 0;
        this.yf = 0;
        this.f = null;
        this.ir = false;
        this.g = new View.OnTouchListener() { // from class: com.byazt.un.n.8
            public float tt;

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                float x = motionEvent.getX();
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 0) {
                    if (actionMasked == 1) {
                        n.this.ir = Math.abs(this.tt - motionEvent.getX()) < 10.0f;
                    } else if (actionMasked == 2) {
                        view2.getParent().requestDisallowInterceptTouchEvent(true);
                    } else if (actionMasked == 3) {
                        view2.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                } else {
                    this.tt = x;
                }
                return false;
            }
        };
        this.ny = new Rect();
        this.mm = new Rect();
        this.pn = new Rect();
        this.yv = gt.getContext().getApplicationContext();
        uj(z2);
        this.c = view;
        this.rl = z;
        yp ypVar = new yp(this);
        this.f = ypVar;
        ypVar.c(this.rl);
        DisplayMetrics displayMetrics = this.yv.getResources().getDisplayMetrics();
        this.ma = displayMetrics.widthPixels;
        this.yf = displayMetrics.heightPixels;
        this.gr = enumSet == null ? EnumSet.noneOf(com.byazt.dh.tt.c.class) : enumSet;
        this.eo = veVar;
        this.zm = icVar;
        uj(8);
        c(context, this.c, icVar);
        uj();
        m();
    }

    private void d() {
        TextView textView = this.to;
        if (textView != null) {
            textView.setTextSize(0, this.hj);
            ColorStateList colorStateList = this.xd;
            if (colorStateList != null) {
                this.to.setTextColor(colorStateList);
            }
            this.to.setAlpha(this.hq);
            this.to.setShadowLayer(pf.ve(this.yv, 1.0f), 0.0f, 0.0f, 1912602624);
            TextView textView2 = this.to;
            Rect rect = this.ny;
            pf.tt(textView2, rect.left, rect.top, rect.right, rect.bottom);
        }
        TextView textView3 = this.lt;
        if (textView3 != null) {
            textView3.setTextSize(0, this.nt);
            ColorStateList colorStateList2 = this.gx;
            if (colorStateList2 != null) {
                this.lt.setTextColor(colorStateList2);
            }
            this.lt.setAlpha(this.gy);
            this.lt.setShadowLayer(pf.ve(this.yv, 1.0f), 0.0f, 0.0f, 1912602624);
            TextView textView4 = this.lt;
            Rect rect2 = this.mm;
            pf.tt(textView4, rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
        ImageView imageView = this.tk;
        if (imageView != null) {
            Rect rect3 = this.pn;
            pf.tt(imageView, rect3.left, rect3.top, rect3.right, rect3.bottom);
        }
        ImageView imageView2 = this.tk;
        if (imageView2 != null) {
            z.c(this.yv, "tt_enlarge_video", imageView2, 320);
        }
        TextView textView5 = this.aw;
        if (textView5 != null) {
            ColorStateList colorStateList3 = this.s;
            if (colorStateList3 != null) {
                textView5.setTextColor(colorStateList3);
            }
            this.aw.setAlpha(this.y);
            TextView textView6 = this.aw;
            Rect rect4 = this.mm;
            pf.tt(textView6, rect4.left, rect4.top, rect4.right, rect4.bottom);
        }
        View view = this.bx;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.j;
            this.bx.setLayoutParams(layoutParams);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            gradientDrawable.setColors(new int[]{Color.parseColor("#FF1A1A1A"), Color.parseColor("#00000000")});
            this.bx.setBackground(gradientDrawable);
        }
        tt(this.dz, true);
    }

    private boolean eo() {
        ic icVar = this.zm;
        if (icVar == null) {
            return false;
        }
        int iKz = icVar.kz();
        return iKz == 1 || iKz == 2;
    }

    private void h() {
        DisplayMetrics displayMetrics = this.yv.getResources().getDisplayMetrics();
        TextView textView = this.to;
        if (textView != null) {
            this.hj = textView.getTextSize();
            this.to.setTextSize(2, 14.0f);
            ColorStateList textColors = this.to.getTextColors();
            this.xd = textColors;
            if (textColors != null) {
                this.to.setTextColor(16777215);
            }
            this.hq = this.to.getAlpha();
            this.to.setAlpha(0.85f);
            this.to.setShadowLayer(0.0f, pf.ve(this.yv, 0.5f), pf.ve(this.yv, 0.5f), -1308622848);
            ViewGroup.LayoutParams layoutParams = this.to.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.ny.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                pf.tt(this.to, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.ny.top, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.ny.bottom);
            }
        }
        TextView textView2 = this.lt;
        if (textView2 != null) {
            this.nt = textView2.getTextSize();
            this.lt.setTextSize(2, 14.0f);
            ColorStateList textColors2 = this.lt.getTextColors();
            this.gx = textColors2;
            if (textColors2 != null) {
                this.lt.setTextColor(16777215);
            }
            this.gy = this.lt.getAlpha();
            this.lt.setAlpha(0.85f);
            this.lt.setShadowLayer(0.0f, pf.ve(this.yv, 0.5f), pf.ve(this.yv, 0.5f), -1308622848);
            ViewGroup.LayoutParams layoutParams2 = this.lt.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                this.mm.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                TextView textView3 = this.lt;
                int iApplyDimension = (int) TypedValue.applyDimension(1, 14.0f, displayMetrics);
                Rect rect = this.mm;
                pf.tt(textView3, iApplyDimension, rect.top, rect.right, rect.bottom);
            }
        }
        ImageView imageView = this.tk;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                this.pn.set(marginLayoutParams3.leftMargin, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin, marginLayoutParams3.bottomMargin);
                ImageView imageView2 = this.tk;
                Rect rect2 = this.pn;
                pf.tt(imageView2, rect2.left, rect2.top, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.pn.bottom);
            }
        }
        ImageView imageView3 = this.tk;
        if (imageView3 != null) {
            z.c(this.yv, "tt_shrink_fullscreen", imageView3, 320);
        }
        TextView textView4 = this.aw;
        if (textView4 != null) {
            ColorStateList textColors3 = textView4.getTextColors();
            this.s = textColors3;
            if (textColors3 != null) {
                this.aw.setTextColor(16777215);
            }
            this.y = this.aw.getAlpha();
            this.aw.setAlpha(0.85f);
            ViewGroup.LayoutParams layoutParams4 = this.aw.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                this.iu.set(marginLayoutParams4.leftMargin, marginLayoutParams4.topMargin, marginLayoutParams4.rightMargin, marginLayoutParams4.bottomMargin);
                TextView textView5 = this.aw;
                int iApplyDimension2 = (int) TypedValue.applyDimension(1, 1.0f, displayMetrics);
                Rect rect3 = this.mm;
                pf.tt(textView5, iApplyDimension2, rect3.top, rect3.right, rect3.bottom);
            }
        }
        View view = this.bx;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            this.j = layoutParams5.height;
            layoutParams5.height = (int) TypedValue.applyDimension(1, 49.0f, displayMetrics);
            this.bx.setLayoutParams(layoutParams5);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            gradientDrawable.setColors(new int[]{Color.parseColor("#66000000"), Color.parseColor("#00000000")});
            this.bx.setBackground(gradientDrawable);
        }
        tt(this.dz, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ShapeDrawable tt(int i, String str) {
        Context context = gt.getContext();
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(Color.parseColor("#FFFFFFFF"));
        int iVe = pf.ve(context, i);
        shapeDrawable.setIntrinsicWidth(iVe);
        shapeDrawable.setIntrinsicHeight(iVe);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(pf.ve(context, 1.0f));
        paint.setColor(Color.parseColor(str));
        return shapeDrawable;
    }

    @Override // com.byazt.un.a
    public void a() {
        this.kp.removeMessages(1);
    }

    @Override // com.byazt.un.a, com.byazt.sgn.z.tt
    public boolean da() {
        return this.b;
    }

    @Override // com.byazt.un.a, com.byazt.dna.qp.c
    public void handleMsg(Message message) {
        if (message.what != 1) {
            return;
        }
        t();
    }

    @Override // com.byazt.un.a
    public void i() {
        this.pu.setProgress(0);
        this.pu.setSecondaryProgress(0);
        this.z.setProgress(0);
        this.z.setSecondaryProgress(0);
        this.lt.setText("00:00");
        this.to.setText("00:00");
        uj(8);
        if (md()) {
            this.tt.setVisibility(8);
        }
        ImageView imageView = this.f29103a;
        if (imageView != null) {
            imageView.setImageDrawable(null);
            this.f29103a.setBackground(null);
        }
        uj(8);
        pf.c(this.lo, 8);
        pf.c(this.x, 8);
        pf.c((View) this.i, 8);
        pf.c(this.da, 8);
        pf.c((View) this.sl, 8);
        pf.c((View) this.t, 8);
        pf.c((View) this.u, 8);
        com.byazt.sgn.z zVar = this.p;
        if (zVar != null) {
            zVar.c(true);
        }
    }

    @Override // com.byazt.un.a
    public void n() {
        this.kp.removeMessages(1);
        this.kp.sendMessageDelayed(this.kp.obtainMessage(1), 2000L);
    }

    @Override // com.byazt.un.a
    public boolean sl() {
        return this.rl;
    }

    @Override // com.byazt.un.a
    public void sp() {
        ic icVar;
        if (com.byazt.ex.c.c(this.zm)) {
            qy();
            return;
        }
        pf.a(this.uj);
        pf.a(this.n);
        pf.n(this.bm);
        if (this.f29103a != null && (icVar = this.zm) != null && !TextUtils.isEmpty(xd.tt(icVar))) {
            pf.a(this.f29103a);
            com.byazt.xky.tt.c(xd.tt(this.zm)).to(this.f29103a);
            c(this.f29103a, xd.tt(this.zm));
        }
        if (this.ve.getVisibility() == 0) {
            pf.c((View) this.ve, 8);
        }
    }

    @Override // com.byazt.un.a, com.byazt.sgn.z.tt
    public void t() {
        c(true, false);
    }

    @Override // com.byazt.un.a
    public boolean u() {
        return this.qy;
    }

    @Override // com.byazt.un.a
    public void uj() {
        super.uj();
        this.f.c(this.c);
        pf.c((View) this.pf, (this.rl || this.gr.contains(com.byazt.dh.tt.c.hideCloseBtn)) ? 8 : 0);
        this.pf.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.un.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.rl()) {
                    n nVar = n.this;
                    nVar.md.ve(nVar, view);
                }
            }
        });
        pf.c((View) this.nb, (!this.rl || this.gr.contains(com.byazt.dh.tt.c.alwayShowBackBtn)) ? 0 : 8);
        this.nb.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.un.n.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.rl()) {
                    n nVar = n.this;
                    nVar.md.uj(nVar, view);
                }
            }
        });
        this.hd.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.un.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.rl()) {
                    n nVar = n.this;
                    nVar.md.n(nVar, view);
                }
            }
        });
        this.lr.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.un.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                n.this.tt(false, true);
                n.this.x();
                n.this.sp();
                n.this.rl();
            }
        });
        this.tk.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.un.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.rl()) {
                    n nVar = n.this;
                    nVar.md.tt(nVar, view);
                }
            }
        });
        this.pu.setThumbOffset(0);
        this.pu.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.byazt.un.n.7
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (n.this.rl()) {
                    n nVar = n.this;
                    nVar.md.c(nVar, i, z);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (!n.this.b && n.this.yv != null) {
                    seekBar.setThumb(n.tt(22, "#1E000000"));
                }
                if (n.this.rl()) {
                    seekBar.setThumbOffset(0);
                    n nVar = n.this;
                    nVar.md.tt(nVar, seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (!n.this.b && n.this.yv != null) {
                    seekBar.setThumb(n.tt(15, "#1E000000"));
                }
                if (n.this.rl()) {
                    seekBar.setThumbOffset(0);
                    n nVar = n.this;
                    nVar.md.c(nVar, seekBar.getProgress());
                }
            }
        });
        this.pu.setOnTouchListener(this.g);
    }

    @Override // com.byazt.un.a
    public boolean ve(int i) {
        SeekBar seekBar = this.pu;
        return seekBar != null && i > seekBar.getSecondaryProgress();
    }

    @Override // com.byazt.un.a
    public void x() {
        pf.n(this.uj);
        pf.n(this.bm);
    }

    @Override // com.byazt.un.a, com.byazt.sgn.yp.c
    public void yp() {
        t();
        ve(false);
    }

    @Override // com.byazt.un.a, com.byazt.sgn.yp.c
    public boolean z() {
        com.byazt.sgn.z zVar = this.p;
        return zVar != null && zVar.c();
    }

    private void a(boolean z) {
        if (z) {
            h();
        } else {
            d();
        }
    }

    @Override // com.byazt.un.a, com.byazt.dh.tt
    @SuppressLint({"ClickableViewAccessibility"})
    public /* bridge */ /* synthetic */ void c(ic icVar, WeakReference weakReference, boolean z) {
        c(icVar, (WeakReference<Context>) weakReference, z);
    }

    @Override // com.byazt.un.a
    public void ve(boolean z) {
        TextView textView = this.sv;
        if (textView != null) {
            pf.c((View) textView, (!this.rl && z) ? 0 : 8);
        }
    }

    @Override // com.byazt.un.a
    public void c(Context context, View view, ic icVar) {
        super.c(context, view, icVar);
        this.nb = (TextView) view.findViewById(2114387759);
        this.pf = (ImageView) view.findViewById(2114387678);
        this.bx = view.findViewById(2114387605);
        this.hd = (ImageView) view.findViewById(2114387897);
        this.sv = (TextView) view.findViewById(2114387730);
        this.aw = (TextView) view.findViewById(2114387706);
        this.ic = (TextView) view.findViewById(2114387846);
        this.bm = view.findViewById(2114387823);
        this.lr = (ImageView) view.findViewById(2114387618);
        this.l = (TextView) view.findViewById(2114387860);
        this.pu = (SeekBar) view.findViewById(2114387872);
        this.lt = (TextView) view.findViewById(2114387668);
        this.to = (TextView) view.findViewById(2114387811);
        this.lo = view.findViewById(2114387628);
        this.tk = (ImageView) view.findViewById(2114387661);
        this.sp = (TTViewStub) view.findViewById(2114387744);
    }

    @Override // com.byazt.un.a
    public void tt(boolean z) {
        int i = da() ? this.yf : this.nu;
        int i2 = da() ? this.ma : this.rh;
        if (this.gt <= 0 || this.my <= 0 || i <= 0) {
            return;
        }
        if (!sl() && !da() && !this.gr.contains(com.byazt.dh.tt.c.fixedSize)) {
            i2 = com.byazt.lbn.tt.c.tt;
        }
        int i3 = this.my;
        int i4 = this.gt;
        int i5 = (int) (i4 * ((i * 1.0f) / i3));
        if (i5 > i2) {
            i = (int) (i3 * ((i2 * 1.0f) / i4));
        } else {
            i2 = i5;
        }
        if (!z && !da()) {
            i = this.nu;
            i2 = this.rh;
        }
        this.tt.c(i, i2);
    }

    @Override // com.byazt.un.a
    public void uj(int i) {
        this.gu = i;
        pf.c(this.c, i);
        if (i != 0) {
            this.vp = false;
        } else if (this.yo) {
            this.vp = true;
        }
    }

    @Override // com.byazt.un.a
    public void c(String str) {
        TextView textView = this.sv;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.aw;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    @Override // com.byazt.un.a
    public void tt(int i) {
        View view = this.lo;
        if (view != null && view.getVisibility() == 0) {
            pf.c((View) this.z, 8);
            return;
        }
        pf.c((View) this.z, 0);
        this.pu.setProgress(i);
        this.z.setProgress(i);
    }

    @Override // com.byazt.un.a
    public void c(long j, long j2) {
        this.lt.setText(com.byazt.vv.c.c(j2));
        this.to.setText(com.byazt.vv.c.c(j));
        this.pu.setProgress(com.byazt.vv.c.c(j, j2));
    }

    @Override // com.byazt.un.a
    public void tt(ViewGroup viewGroup) {
        View view;
        m.uj("FullScreen", "Detail exitFullScreen.....");
        if (viewGroup == null || (view = this.c) == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        this.b = false;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.c.getLayoutParams();
        marginLayoutParams.width = this.v;
        marginLayoutParams.height = this.os;
        marginLayoutParams.leftMargin = this.tx;
        marginLayoutParams.topMargin = this.kk;
        this.c.setLayoutParams(marginLayoutParams);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(3, this.oz);
            viewGroup.setLayoutParams(layoutParams2);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            Rect rect = this.r;
            pf.tt(viewGroup, rect.left, rect.top, rect.right, rect.bottom);
        }
        tt(true);
        z.c(this.yv, "tt_enlarge_video", this.tk, 320);
        this.pu.setThumb(tt(15, "#1E000000"));
        this.pu.setThumbOffset(0);
        com.byazt.vv.c.c(this.c, true);
        a(this.b);
        pf.c(this.bx, 8);
        if (this.gr.contains(com.byazt.dh.tt.c.alwayShowBackBtn)) {
            pf.c((View) this.nb, 0);
        }
    }

    @Override // com.byazt.un.a, com.byazt.dh.tt
    public void c() {
        c(false, this.rl);
        zm();
    }

    @Override // com.byazt.un.a
    public void c(long j) {
        this.to.setText(com.byazt.vv.c.c(j));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.byazt.un.a
    @SuppressLint({"ClickableViewAccessibility"})
    public void c(ic icVar, WeakReference<Context> weakReference, boolean z) {
        ic icVar2;
        if (icVar == null) {
            return;
        }
        if (com.byazt.ex.c.c(icVar)) {
            c(gt.getContext(), this.c);
            rh();
            return;
        }
        c(this.c, gt.getContext());
        c(false, this.rl);
        pf.c(this.x, 0);
        pf.c((View) this.i, 0);
        pf.c(this.da, 0);
        if (this.i != null && (icVar2 = this.zm) != null && !TextUtils.isEmpty(xd.tt(icVar2))) {
            com.byazt.xky.tt.c(xd.tt(this.zm)).to(this.i);
            c(this.i, xd.tt(this.zm));
        }
        pf.c((View) this.yp, 0);
        pf.c((View) this.sl, 8);
        pf.c((View) this.t, 8);
        pf.c((View) this.u, 8);
        pf.c(this.yp, "重新播放");
        pf.c(this.yp, new View.OnClickListener() { // from class: com.byazt.un.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                tt ttVar = n.this.md;
                if (ttVar != null) {
                    ttVar.c();
                }
            }
        }, "video_ad_button");
        pf.c(this.yp, (View.OnTouchListener) null, "video_ad_button");
        if (eo()) {
            pf.c(this.da, 8);
        }
    }

    @Override // com.byazt.un.a
    public void c(ViewGroup viewGroup) {
        if (viewGroup != null && (this.c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            this.b = true;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.c.getLayoutParams();
            this.tx = marginLayoutParams.leftMargin;
            this.kk = marginLayoutParams.topMargin;
            this.v = marginLayoutParams.width;
            this.os = marginLayoutParams.height;
            marginLayoutParams.width = -1;
            marginLayoutParams.height = -1;
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.leftMargin = 0;
            this.c.setLayoutParams(marginLayoutParams);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                int[] rules = layoutParams2.getRules();
                this.oz = rules.length > 0 ? rules[3] : 0;
                layoutParams2.addRule(3, 0);
                viewGroup.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                this.r.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                pf.tt(viewGroup, 0, 0, 0, 0);
            }
            tt(true);
            z.c(this.yv, "tt_shrink_video", this.tk, 320);
            this.pu.setThumb(tt(18, "#00000000"));
            this.pu.setThumbOffset(0);
            com.byazt.vv.c.c(this.c, false);
            a(this.b);
            pf.c(this.bx, 8);
            if (!this.rl) {
                pf.c((View) this.pf, 8);
                pf.c((View) this.nb, 8);
            } else if (this.gr.contains(com.byazt.dh.tt.c.hideCloseBtn)) {
                pf.c((View) this.pf, 8);
            }
        }
    }

    @Override // com.byazt.un.a
    public void c(boolean z, boolean z2, boolean z3) {
        pf.c(this.lo, 0);
        pf.c((View) this.z, 0);
        if (this.b) {
            pf.c(this.bx, 0);
            pf.c((View) this.aw, 0);
        } else if (z3) {
            pf.c(this.bx, 8);
        }
        pf.c((View) this.ve, (!z || this.uj.getVisibility() == 0) ? 8 : 0);
        if (!this.rl && !this.b) {
            if (!this.gr.contains(com.byazt.dh.tt.c.hideCloseBtn) && !z3) {
                pf.c((View) this.pf, 0);
            }
            pf.c((View) this.nb, z3 ? 8 : 0);
        }
        pf.c((View) this.lt, 0);
        pf.c((View) this.to, 0);
        if (eo()) {
            pf.c((View) this.pu, 8);
        } else {
            pf.c((View) this.pu, 0);
        }
    }

    @Override // com.byazt.un.a
    public void c(boolean z, boolean z2) {
        pf.c(this.lo, 8);
        pf.c(this.bx, 8);
        pf.c((View) this.z, z ? 0 : 8);
        pf.c((View) this.ve, 8);
        if (!this.rl && !this.b) {
            pf.c((View) this.pf, 8);
            if (!this.gr.contains(com.byazt.dh.tt.c.alwayShowBackBtn)) {
                pf.c((View) this.nb, 8);
            }
        } else if (this.gr.contains(com.byazt.dh.tt.c.hideCloseBtn)) {
            pf.c((View) this.pf, 8);
        }
        if (z2) {
            pf.c((View) this.pf, 8);
            pf.c((View) this.nb, 8);
        }
        ve(false);
    }

    @Override // com.byazt.un.a, com.byazt.sgn.yp.c
    public void c(View view, boolean z) {
        if (da()) {
            String str = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
            ic icVar = this.zm;
            if (icVar != null && !TextUtils.isEmpty(icVar.v_())) {
                c(this.zm.v_());
            }
            this.ic.setText(str);
        } else {
            c("");
            this.ic.setText("");
        }
        if (this.h) {
            return;
        }
        ve(this.rl && !this.b);
        if (rl()) {
            this.md.c(this, view, true, this.uj.getVisibility() != 0);
        }
    }
}
