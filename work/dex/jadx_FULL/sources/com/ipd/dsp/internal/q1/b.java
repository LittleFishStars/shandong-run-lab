package com.ipd.dsp.internal.q1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ipd.dsp.R;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.c2.s;
import com.ipd.dsp.internal.s1.g;
import com.ipd.dsp.internal.s1.h;
import com.ipd.dsp.open.IPDGlideHelper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@SuppressLint({"ViewConstructor"})
public class b extends a {
    public final boolean j;

    public b(Context context, com.ipd.dsp.internal.p1.d.a aVar, boolean z) {
        super(context, aVar);
        setOrientation(1);
        this.j = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r13v0, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r16v0, types: [android.view.View, android.view.View$OnClickListener, android.view.ViewGroup, com.ipd.dsp.internal.q1.a, com.ipd.dsp.internal.q1.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r9v2, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    @Override // com.ipd.dsp.internal.q1.a
    public void a(com.ipd.dsp.internal.e1.d dVar, com.ipd.dsp.internal.j1.b bVar, float f, boolean z) {
        super.a(dVar, bVar, f, z);
        ?? linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        addView(linearLayout, layoutParams);
        if (!dVar.p) {
            this.f.add(this);
            setOnClickListener(this);
        }
        int iA = (int) s.a(getContext(), 2.0f);
        int iA2 = (int) s.a(getContext(), 4.0f);
        int iA3 = (int) s.a(getContext(), 24.0f);
        View viewB = b(dVar, bVar, f, z);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams2.gravity = 17;
        viewB.setLayoutParams(layoutParams2);
        ?? linearLayout2 = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        layoutParams3.setMargins(iA2, 0, iA2, 0);
        linearLayout2.setLayoutParams(layoutParams3);
        linearLayout2.setOrientation(1);
        ?? linearLayout3 = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams4.weight = 1.0f;
        linearLayout3.setLayoutParams(layoutParams4);
        linearLayout3.setOrientation(1);
        if (o.c(dVar.k) || o.c(dVar.m)) {
            TextView textView = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.bottomMargin = iA;
            textView.setLayoutParams(layoutParams5);
            textView.setGravity(16);
            textView.setMaxLines(1);
            textView.setTextSize(12.0f);
            textView.setTextColor(Color.parseColor("#FF333333"));
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setText(o.c(dVar.m) ? dVar.m : dVar.k);
            if (dVar.p) {
                this.f.add(textView);
                textView.setOnClickListener(this);
            }
            linearLayout3.addView(textView);
        }
        if (!TextUtils.isEmpty(dVar.l)) {
            TextView textView2 = new TextView(getContext());
            textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textView2.setGravity(48);
            textView2.setMaxLines(2);
            textView2.setTextSize(10.0f);
            textView2.setTextColor(Color.parseColor("#FF666666"));
            textView2.setText(dVar.l);
            if (dVar.p) {
                this.f.add(textView2);
                textView2.setOnClickListener(this);
            }
            linearLayout3.addView(textView2);
        }
        LinearLayout linearLayout4 = new LinearLayout(getContext());
        linearLayout4.setOrientation(0);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams6.setMargins(0, iA, 0, 0);
        linearLayout4.setLayoutParams(layoutParams6);
        com.ipd.dsp.internal.s1.a aVar = new com.ipd.dsp.internal.s1.a(getContext());
        aVar.a(dVar.t);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.gravity = 8388627;
        linearLayout4.addView(aVar, layoutParams7);
        if (o.c(dVar.m) && o.c(dVar.k)) {
            TextView textView3 = new TextView(getContext());
            textView3.setGravity(8388627);
            textView3.setMaxLines(1);
            textView3.setSingleLine();
            textView3.setTextSize(10.0f);
            textView3.setTypeface(Typeface.DEFAULT_BOLD);
            textView3.setText(dVar.k);
            LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(0, -1);
            layoutParams8.weight = 1.0f;
            layoutParams8.gravity = 16;
            layoutParams8.setMarginStart(12);
            linearLayout4.addView(textView3, layoutParams8);
            if (dVar.p) {
                this.f.add(textView3);
                textView3.setOnClickListener(this);
            }
        } else {
            View view = new View(getContext());
            LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(0, 0);
            layoutParams9.weight = 1.0f;
            linearLayout4.addView(view, layoutParams9);
        }
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(iA3, iA3);
        layoutParams10.gravity = 8388629;
        imageView.setPadding(iA2, iA2, iA2, iA2);
        imageView.setImageResource(R.drawable.ipd_close_dark);
        this.f.add(imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.vka
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f45376a.a(view2);
            }
        });
        linearLayout4.addView(imageView, layoutParams10);
        linearLayout2.addView(linearLayout3);
        linearLayout2.addView(linearLayout4);
        linearLayout.addView(this.j ? viewB : linearLayout2);
        ?? r9 = viewB;
        if (this.j) {
            r9 = linearLayout2;
        }
        linearLayout.addView(r9);
        if (dVar.r.b()) {
            g gVar = new g(getContext());
            gVar.a(dVar.r.D, 2);
            addView(gVar, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    public final View b(com.ipd.dsp.internal.e1.d dVar, com.ipd.dsp.internal.j1.b bVar, float f, boolean z) {
        if (TextUtils.isEmpty(dVar.q.f)) {
            com.ipd.dsp.internal.t0.c cVar = new com.ipd.dsp.internal.t0.c(getContext());
            cVar.a(com.ipd.dsp.internal.t0.a.DATUM_HEIGHT, f, 1.0f);
            cVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
            IPDGlideHelper.loadImage(getContext(), cVar, dVar.o);
            return cVar;
        }
        com.ipd.dsp.internal.t0.b bVar2 = new com.ipd.dsp.internal.t0.b(getContext());
        bVar2.setBackgroundColor(-16777216);
        bVar2.a(com.ipd.dsp.internal.t0.a.DATUM_HEIGHT, f, 1.0f);
        h hVar = new h(getContext(), dVar, bVar, z);
        this.h = hVar;
        hVar.h();
        bVar2.addView(this.h, new FrameLayout.LayoutParams(-1, -1));
        return bVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void a(View view) {
        removeAllViews();
        ViewParent parent = getParent();
        if (parent != 0) {
            try {
                ((ViewGroup) parent.getParent()).removeView((View) parent);
            } catch (Throwable unused) {
            }
        }
        com.ipd.dsp.internal.p1.d.a aVar = this.g;
        if (aVar != null) {
            aVar.c();
        }
    }
}
