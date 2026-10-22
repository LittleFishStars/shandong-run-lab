package com.ipd.dsp.internal.q1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
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
public class c extends a {
    public c(Context context, com.ipd.dsp.internal.p1.d.a aVar) {
        super(context, aVar);
        setOrientation(1);
    }

    @Override // com.ipd.dsp.internal.q1.a
    public void a(com.ipd.dsp.internal.e1.d dVar, com.ipd.dsp.internal.j1.b bVar, float f, boolean z) {
        super.a(dVar, bVar, f, z);
        if (!dVar.p) {
            setOnClickListener(this);
        }
        int iA = (int) s.a(getContext(), 2.0f);
        int iA2 = (int) s.a(getContext(), 4.0f);
        int iA3 = (int) s.a(getContext(), 24.0f);
        com.ipd.dsp.internal.t0.b bVar2 = new com.ipd.dsp.internal.t0.b(getContext());
        bVar2.setBackgroundColor(-16777216);
        bVar2.a(com.ipd.dsp.internal.t0.a.DATUM_HEIGHT, f, 1.0f);
        View viewA = a(dVar, bVar, z);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        viewA.setLayoutParams(layoutParams);
        bVar2.addView(viewA, layoutParams);
        if (o.c(dVar.k) || o.c(dVar.m)) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setPadding(iA2, iA2, iA2, iA2);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
            gradientDrawable.setColors(new int[]{Color.parseColor("#00000000"), Color.parseColor("#88000000")});
            frameLayout.setBackground(gradientDrawable);
            TextView textView = new TextView(getContext());
            textView.setGravity(16);
            textView.setMaxLines(1);
            textView.setTextSize(12.0f);
            textView.setTextColor(-1);
            textView.setText(o.c(dVar.m) ? dVar.m : dVar.k);
            frameLayout.addView(textView);
            if (dVar.p) {
                this.f.add(textView);
                textView.setOnClickListener(this);
            }
            bVar2.addView(frameLayout, new FrameLayout.LayoutParams(-1, -2));
        }
        if (dVar.r.b()) {
            g gVar = new g(getContext());
            gVar.a(dVar.r.D, 2);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 80;
            bVar2.addView(gVar, layoutParams2);
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 1.0f;
        layoutParams3.gravity = 17;
        addView(bVar2, layoutParams3);
        if (!TextUtils.isEmpty(dVar.l)) {
            TextView textView2 = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.setMargins(0, iA, 0, iA2);
            textView2.setGravity(16);
            textView2.setMaxLines(2);
            textView2.setTextSize(10.0f);
            textView2.setTextColor(Color.parseColor("#FF666666"));
            textView2.setText(dVar.l);
            if (dVar.p) {
                this.f.add(textView2);
                textView2.setOnClickListener(this);
            }
            addView(textView2, layoutParams4);
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams5.setMargins(0, iA, 0, 0);
        linearLayout.setLayoutParams(layoutParams5);
        com.ipd.dsp.internal.s1.a aVar = new com.ipd.dsp.internal.s1.a(getContext());
        aVar.a(dVar.t);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.gravity = 8388627;
        linearLayout.addView(aVar, layoutParams6);
        if (o.c(dVar.m) && o.c(dVar.k)) {
            TextView textView3 = new TextView(getContext());
            textView3.setGravity(8388627);
            textView3.setMaxLines(1);
            textView3.setSingleLine();
            textView3.setTextSize(10.0f);
            textView3.setTypeface(Typeface.DEFAULT_BOLD);
            textView3.setText(dVar.k);
            LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -1);
            layoutParams7.weight = 1.0f;
            layoutParams7.gravity = 16;
            layoutParams7.setMarginStart(12);
            linearLayout.addView(textView3, layoutParams7);
            if (dVar.p) {
                this.f.add(textView3);
                textView3.setOnClickListener(this);
            }
        } else {
            View view = new View(getContext());
            LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(0, 0);
            layoutParams8.weight = 1.0f;
            linearLayout.addView(view, layoutParams8);
        }
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(iA3, iA3);
        layoutParams9.gravity = 8388629;
        imageView.setPadding(iA2, iA2, iA2, iA2);
        imageView.setImageResource(R.drawable.ipd_close_dark);
        this.f.add(imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.bpa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f40808a.a(view2);
            }
        });
        linearLayout.addView(imageView, layoutParams9);
        addView(linearLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void a(View view) {
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

    public final View a(com.ipd.dsp.internal.e1.d dVar, com.ipd.dsp.internal.j1.b bVar, boolean z) {
        if (TextUtils.isEmpty(dVar.q.f)) {
            com.ipd.dsp.internal.t0.c cVar = new com.ipd.dsp.internal.t0.c(getContext());
            cVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
            IPDGlideHelper.loadImage(getContext(), cVar, dVar.o);
            return cVar;
        }
        h hVar = new h(getContext(), dVar, bVar, z);
        this.h = hVar;
        hVar.h();
        return this.h;
    }
}
