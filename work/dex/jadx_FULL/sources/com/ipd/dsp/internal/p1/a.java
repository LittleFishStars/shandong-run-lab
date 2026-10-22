package com.ipd.dsp.internal.p1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.c2.s;
import com.ipd.dsp.internal.s1.g;
import com.ipd.dsp.open.IPDGlideHelper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@SuppressLint({"ViewConstructor"})
public class a extends com.ipd.dsp.internal.t0.b {
    public static final float m = 6.4f;
    public final com.ipd.dsp.internal.e1.d h;
    public String i;
    public float j;
    public com.ipd.dsp.internal.k1.a.c k;
    public boolean l;

    public a(@NonNull Context context, com.ipd.dsp.internal.e1.d dVar, com.ipd.dsp.internal.k1.a.c cVar) {
        super(context);
        this.i = "center";
        this.h = dVar;
        this.k = cVar;
        a(dVar);
        j();
        a(context);
    }

    public final void a(com.ipd.dsp.internal.e1.d dVar) {
        com.ipd.dsp.internal.e1.f fVar = dVar.s;
        this.i = fVar.f;
        this.j = com.ipd.dsp.internal.e1.f.a(fVar.g, 6.4f);
        this.l = dVar.r.b();
    }

    public void i() {
        removeAllViews();
        this.k = null;
    }

    public final void j() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 16;
        setLayoutParams(layoutParams);
        a(com.ipd.dsp.internal.t0.a.DATUM_WIDTH, 6.4f, 1.0f);
        setBackgroundColor(-1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.ipd.dsp.internal.k1.a.c cVar = this.k;
        if (cVar != null) {
            cVar.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        com.ipd.dsp.internal.k1.a.c cVar;
        super.onWindowVisibilityChanged(i);
        if (i != 0 || (cVar = this.k) == null) {
            return;
        }
        cVar.a();
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0090  */
    /* JADX WARN: Code duplicated, block: B:16:0x00ed A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:21:0x0112  */
    /* JADX WARN: Code duplicated, block: B:24:0x014f  */
    /* JADX WARN: Code duplicated, block: B:26:0x017c  */
    /* JADX WARN: Code duplicated, block: B:28:0x018a  */
    /* JADX WARN: Code duplicated, block: B:30:? A[RETURN, SYNTHETIC] */
    public final void a(Context context) {
        FrameLayout.LayoutParams layoutParams;
        LinearLayout linearLayout;
        g gVar;
        LinearLayout linearLayout2;
        StringBuilder sb;
        boolean zC;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        float f = displayMetrics.density;
        LinearLayout linearLayout3 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 1.0f;
        linearLayout3.setLayoutParams(layoutParams2);
        linearLayout3.setOrientation(0);
        com.ipd.dsp.internal.t0.c cVar = new com.ipd.dsp.internal.t0.c(context);
        String str = this.i;
        int iHashCode = str.hashCode();
        if (iHashCode == -1364013995) {
            str.equals("center");
        } else {
            if (iHashCode == 3317767 && str.equals("left")) {
                cVar.a(com.ipd.dsp.internal.t0.a.DATUM_HEIGHT, this.j, 1.0f);
                cVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
                layoutParams = new FrameLayout.LayoutParams(-2, -1);
                layoutParams.gravity = 8388627;
            }
            cVar.setLayoutParams(layoutParams);
            IPDGlideHelper.loadImage(context, cVar, this.h.o);
            linearLayout3.addView(cVar);
            if (this.i.equals("left")) {
                linearLayout2 = new LinearLayout(context);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams3.gravity = GravityCompat.START;
                linearLayout2.setLayoutParams(layoutParams3);
                linearLayout2.setOrientation(1);
                int iA = (int) s.a(f, 2.0f);
                int iA2 = (int) s.a(f, 12.0f);
                linearLayout2.setPadding(iA2, iA, iA2, iA);
                linearLayout3.addView(linearLayout2);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams4.gravity = GravityCompat.START;
                TextView textView = new TextView(context);
                textView.setLayoutParams(layoutParams4);
                textView.setTextColor(-16777216);
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                sb = new StringBuilder(this.h.k);
                zC = o.c(this.h.k);
                if (o.c(this.h.m)) {
                    if (zC) {
                        sb.append(" - ");
                    }
                    sb.append(this.h.m);
                }
                textView.setText(sb.toString());
                textView.setTextSize(12.0f);
                linearLayout2.addView(textView);
                if (!TextUtils.isEmpty(this.h.l)) {
                    LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, 0);
                    layoutParams5.gravity = 8388691;
                    layoutParams5.weight = 1.0f;
                    TextView textView2 = new TextView(context);
                    textView2.setLayoutParams(layoutParams5);
                    textView2.setGravity(16);
                    textView2.setTextColor(-16777216);
                    textView2.setText(this.h.l);
                    textView2.setTextSize(10.0f);
                    linearLayout2.addView(textView2);
                }
            }
            linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.addView(linearLayout3);
            addView(linearLayout);
            if (this.l) {
                gVar = new g(context);
                gVar.a(this.h.r.D, 2);
                gVar.setPadding(gVar.getPaddingLeft(), gVar.getPaddingTop(), (int) s.a(f, 36.0f), gVar.getPaddingBottom());
                if (this.i.equals("center")) {
                    FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams6.gravity = 80;
                    addView(gVar, layoutParams6);
                    return;
                }
                linearLayout.addView(gVar, new LinearLayout.LayoutParams(-1, -2));
            }
        }
        cVar.setScaleType(ImageView.ScaleType.FIT_XY);
        layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        cVar.setLayoutParams(layoutParams);
        IPDGlideHelper.loadImage(context, cVar, this.h.o);
        linearLayout3.addView(cVar);
        if (this.i.equals("left")) {
            linearLayout2 = new LinearLayout(context);
            FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-2, -1);
            layoutParams7.gravity = GravityCompat.START;
            linearLayout2.setLayoutParams(layoutParams7);
            linearLayout2.setOrientation(1);
            int iA3 = (int) s.a(f, 2.0f);
            int iA4 = (int) s.a(f, 12.0f);
            linearLayout2.setPadding(iA4, iA3, iA4, iA3);
            linearLayout3.addView(linearLayout2);
            LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams8.gravity = GravityCompat.START;
            TextView textView3 = new TextView(context);
            textView3.setLayoutParams(layoutParams8);
            textView3.setTextColor(-16777216);
            textView3.setTypeface(Typeface.DEFAULT_BOLD);
            sb = new StringBuilder(this.h.k);
            zC = o.c(this.h.k);
            if (o.c(this.h.m)) {
                if (zC) {
                    sb.append(" - ");
                }
                sb.append(this.h.m);
            }
            textView3.setText(sb.toString());
            textView3.setTextSize(12.0f);
            linearLayout2.addView(textView3);
            if (!TextUtils.isEmpty(this.h.l)) {
                LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, 0);
                layoutParams9.gravity = 8388691;
                layoutParams9.weight = 1.0f;
                TextView textView4 = new TextView(context);
                textView4.setLayoutParams(layoutParams9);
                textView4.setGravity(16);
                textView4.setTextColor(-16777216);
                textView4.setText(this.h.l);
                textView4.setTextSize(10.0f);
                linearLayout2.addView(textView4);
            }
        }
        linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.addView(linearLayout3);
        addView(linearLayout);
        if (this.l) {
            gVar = new g(context);
            gVar.a(this.h.r.D, 2);
            gVar.setPadding(gVar.getPaddingLeft(), gVar.getPaddingTop(), (int) s.a(f, 36.0f), gVar.getPaddingBottom());
            if (this.i.equals("center")) {
                FrameLayout.LayoutParams layoutParams10 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams10.gravity = 80;
                addView(gVar, layoutParams10);
                return;
            }
            linearLayout.addView(gVar, new LinearLayout.LayoutParams(-1, -2));
        }
    }
}
