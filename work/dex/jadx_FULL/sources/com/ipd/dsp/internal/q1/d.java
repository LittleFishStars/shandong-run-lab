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
public class d extends a {
    public final int j;

    public d(Context context, com.ipd.dsp.internal.p1.d.a aVar, int i) {
        super(context, aVar);
        setOrientation(1);
        this.j = i;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private View b(com.ipd.dsp.internal.e1.d dVar, com.ipd.dsp.internal.j1.b bVar, float f, boolean z) {
        View view;
        com.ipd.dsp.internal.t0.b bVar2 = new com.ipd.dsp.internal.t0.b(getContext());
        bVar2.a(com.ipd.dsp.internal.t0.a.DATUM_HEIGHT, f, 1.0f);
        if (TextUtils.isEmpty(dVar.q.f)) {
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            IPDGlideHelper.loadImageCenterCrop(getContext(), imageView, dVar.o);
            view = imageView;
        } else {
            bVar2.setBackgroundColor(-16777216);
            h hVar = new h(getContext(), dVar, bVar, z);
            this.h = hVar;
            hVar.h();
            view = this.h;
        }
        if (dVar.p) {
            this.f.add(view);
            view.setOnClickListener(this);
        }
        bVar2.addView(view, new FrameLayout.LayoutParams(-1, -1));
        if (dVar.r.b()) {
            g gVar = new g(getContext());
            gVar.a(dVar.r.D, 2);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            bVar2.addView(gVar, layoutParams);
        }
        return bVar2;
    }

    @Override // com.ipd.dsp.internal.q1.a
    public void a(com.ipd.dsp.internal.e1.d dVar, com.ipd.dsp.internal.j1.b bVar, float f, boolean z) {
        View view;
        super.a(dVar, bVar, f, z);
        if (!dVar.p) {
            this.f.add(this);
            setOnClickListener(this);
        }
        int iA = (int) s.a(getContext(), 2.0f);
        int iA2 = (int) s.a(getContext(), 4.0f);
        int iA3 = (int) s.a(getContext(), 18.0f);
        int iA4 = (int) s.a(getContext(), 24.0f);
        View viewB = b(dVar, bVar, f, z);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.gravity = 17;
        layoutParams.weight = 1.0f;
        viewB.setLayoutParams(layoutParams);
        if (this.j == 0) {
            addView(viewB);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setPadding(0, iA, 0, iA);
            linearLayout.setOrientation(0);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            if (o.c(dVar.n)) {
                com.ipd.dsp.internal.t0.c cVar = new com.ipd.dsp.internal.t0.c(getContext());
                cVar.a(com.ipd.dsp.internal.t0.a.DATUM_HEIGHT, 1.0f, 1.0f);
                cVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
                IPDGlideHelper.loadImage(getContext(), cVar, dVar.n);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, iA3);
                layoutParams2.setMarginEnd(iA2);
                if (dVar.p) {
                    this.f.add(cVar);
                    cVar.setOnClickListener(this);
                }
                linearLayout.addView(cVar, layoutParams2);
            }
            if (o.c(dVar.k) || o.c(dVar.m)) {
                TextView textView = new TextView(getContext());
                textView.setLayoutParams(new LinearLayout.LayoutParams(-2, iA3));
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
                linearLayout.addView(textView);
            }
            addView(this.j == 1 ? viewB : linearLayout);
            if (TextUtils.isEmpty(dVar.l)) {
                if (this.j == 1) {
                    view = viewB;
                    view = linearLayout;
                }
                view = viewB;
                addView(view);
            } else {
                TextView textView2 = new TextView(getContext());
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(0, 0, 0, iA2);
                textView2.setLayoutParams(layoutParams3);
                textView2.setGravity(16);
                textView2.setMaxLines(2);
                textView2.setTextSize(10.0f);
                textView2.setTextColor(Color.parseColor("#FF666666"));
                textView2.setText(dVar.l);
                if (dVar.p) {
                    this.f.add(textView2);
                    textView2.setOnClickListener(this);
                }
                View view2 = linearLayout;
                if (this.j != 1) {
                    view2 = textView2;
                }
                addView(view2);
                View view3 = viewB;
                if (this.j == 1) {
                    view3 = textView2;
                }
                addView(view3);
            }
        }
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.setMargins(0, iA, 0, 0);
        linearLayout2.setLayoutParams(layoutParams4);
        com.ipd.dsp.internal.s1.a aVar = new com.ipd.dsp.internal.s1.a(getContext());
        aVar.a(dVar.t);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 8388627;
        linearLayout2.addView(aVar, layoutParams5);
        if ((this.j == 0 && (o.c(dVar.m) || o.c(dVar.k))) || (this.j != 0 && o.c(dVar.m) && o.c(dVar.k))) {
            String str = (this.j == 0 && o.c(dVar.m)) ? dVar.m : dVar.k;
            TextView textView3 = new TextView(getContext());
            textView3.setGravity(8388627);
            textView3.setMaxLines(1);
            textView3.setSingleLine();
            textView3.setTextSize(10.0f);
            textView3.setTypeface(Typeface.DEFAULT_BOLD);
            textView3.setText(str);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -1);
            layoutParams6.weight = 1.0f;
            layoutParams6.gravity = 16;
            layoutParams6.setMarginStart(12);
            linearLayout2.addView(textView3, layoutParams6);
            if (dVar.p) {
                this.f.add(textView3);
                textView3.setOnClickListener(this);
            }
        } else {
            View view4 = new View(getContext());
            LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, 0);
            layoutParams7.weight = 1.0f;
            linearLayout2.addView(view4, layoutParams7);
        }
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(iA4, iA4);
        layoutParams8.gravity = 8388629;
        imageView.setPadding(iA2, iA2, iA2, iA2);
        imageView.setImageResource(R.drawable.ipd_close_dark);
        this.f.add(imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.hta
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                this.f42201a.a(view5);
            }
        });
        linearLayout2.addView(imageView, layoutParams8);
        addView(linearLayout2);
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
}
