package com.ipd.dsp.internal.r1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.ipd.dsp.R;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.c2.r;
import com.ipd.dsp.internal.c2.s;
import com.ipd.dsp.open.IPDGlideHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@SuppressLint({"ViewConstructor"})
public class i extends com.ipd.dsp.internal.x1.c implements j, com.ipd.dsp.internal.s1.h.b {
    public final int g;
    public FrameLayout h;
    public com.ipd.dsp.internal.s1.h i;
    public View j;
    public com.ipd.dsp.internal.t0.c k;
    public TextView l;
    public TextView m;
    public com.ipd.dsp.internal.t1.b n;
    public List<View> o;
    public final com.ipd.dsp.internal.e1.d p;

    public i(@NonNull Context context, com.ipd.dsp.internal.e1.d dVar, com.ipd.dsp.internal.j1.b bVar, boolean z, boolean z2, boolean z3) {
        super(context);
        this.o = new ArrayList();
        this.p = dVar;
        int iA = (int) s.a(context, 5.0f);
        this.g = iA;
        float fA = s.a(context, 10.0f);
        if (z) {
            setBackgroundColor(-1);
        } else {
            setBackground(new com.ipd.dsp.internal.u1.a.C0921a().c(fA).a(-1).a());
        }
        int iA2 = (int) s.a(context, 12.0f);
        int iA3 = (int) s.a(context, 24.0f);
        int iA4 = (int) s.a(context, 48.0f);
        int iA5 = (int) s.a(context, 60.0f);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setPadding(iA2, iA2, iA2, iA2);
        linearLayout.setOrientation(1);
        addView(linearLayout);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout.addView(linearLayout2, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.gravity = 16;
        layoutParams2.weight = 1.0f;
        FrameLayout frameLayout = new FrameLayout(context);
        this.h = frameLayout;
        linearLayout2.addView(frameLayout, layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams3.setMargins(iA, iA, iA, iA);
        com.ipd.dsp.internal.s1.h hVar = new com.ipd.dsp.internal.s1.h(context, dVar, bVar, z3, z);
        this.i = hVar;
        hVar.setBackgroundColor(0);
        this.i.a((com.ipd.dsp.internal.s1.h.b) this, true);
        this.h.addView(this.i, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -1);
        layoutParams4.weight = 1.0f;
        LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setGravity(17);
        linearLayout3.setOrientation(1);
        linearLayout3.setPadding(iA2, 0, iA2, 0);
        linearLayout2.addView(linearLayout3, layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(iA5, iA5);
        com.ipd.dsp.internal.t0.c cVar = new com.ipd.dsp.internal.t0.c(context);
        this.k = cVar;
        cVar.a(com.ipd.dsp.internal.t0.a.DATUM_WIDTH, 1.0f, 1.0f);
        linearLayout3.addView(this.k, layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.setMargins(0, iA3, 0, 0);
        TextView textView = new TextView(context);
        this.l = textView;
        textView.setGravity(16);
        this.l.setSingleLine(true);
        this.l.setTextColor(-16777216);
        this.l.setTextSize(22.0f);
        this.l.setTypeface(Typeface.DEFAULT_BOLD);
        linearLayout3.addView(this.l, layoutParams6);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.setMargins(0, iA2, 0, 0);
        TextView textView2 = new TextView(context);
        this.m = textView2;
        textView2.setGravity(16);
        this.m.setMaxLines(3);
        this.m.setTextColor(-12303292);
        this.m.setTextSize(20.0f);
        this.m.setEllipsize(TextUtils.TruncateAt.END);
        linearLayout3.addView(this.m, layoutParams7);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, iA4);
        layoutParams8.setMargins(iA3, iA3, iA3, (z && z2) ? iA2 + iA3 : 0);
        if (dVar.w.g) {
            int iNextInt = new Random().nextInt(3);
            if (iNextInt == 0) {
                layoutParams8.height = iA5;
                this.n = new com.ipd.dsp.internal.t1.g(context);
            } else {
                this.n = new com.ipd.dsp.internal.t1.i(context, iNextInt);
            }
            this.n.setBackgroundResource(R.drawable.ipd_bg_blue);
        } else {
            layoutParams8.height = iA5;
            this.n = new com.ipd.dsp.internal.t1.e(context);
        }
        this.n.setLayoutParams(layoutParams8);
        this.n.setGravity(17);
        linearLayout.addView(this.n, layoutParams8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        com.ipd.dsp.internal.t1.b bVar = this.n;
        if (bVar != null) {
            bVar.d();
        }
    }

    @Override // com.ipd.dsp.internal.r1.j
    public void a(boolean z) {
        com.ipd.dsp.internal.s1.h hVar = this.i;
        if (hVar != null) {
            hVar.a(z);
        }
    }

    @Override // com.ipd.dsp.internal.r1.j
    public void b() {
        com.ipd.dsp.internal.s1.h hVar = this.i;
        if (hVar != null) {
            hVar.m();
        }
    }

    @Override // com.ipd.dsp.internal.r1.j
    public void c() {
        com.ipd.dsp.internal.s1.h hVar = this.i;
        if (hVar != null) {
            hVar.o();
        }
    }

    @Override // com.ipd.dsp.internal.r1.j
    public void d() {
        com.ipd.dsp.internal.s1.h hVar = this.i;
        if (hVar != null) {
            hVar.k();
        }
    }

    @Override // com.ipd.dsp.internal.r1.b
    public void e() {
        com.ipd.dsp.internal.t1.b bVar = this.n;
        if (bVar != null) {
            bVar.a();
        }
        com.ipd.dsp.internal.s1.h hVar = this.i;
        if (hVar != null) {
            hVar.i();
        }
    }

    @Override // com.ipd.dsp.internal.r1.j
    public void f() {
        com.ipd.dsp.internal.s1.h hVar = this.i;
        if (hVar != null) {
            hVar.n();
        }
    }

    @Override // com.ipd.dsp.internal.s1.h.b
    public void g() {
        this.h.setBackground(new com.ipd.dsp.internal.u1.a.C0921a().c(this.g * 2).a(-16777216).a(-1, this.g).a());
        this.i.post(new Runnable() { // from class: com.zj.adlib.dab
            @Override // java.lang.Runnable
            public final void run() {
                this.f41143a.i();
            }
        });
    }

    @Override // com.ipd.dsp.internal.r1.b
    public List<View> getClickableViews() {
        return this.o;
    }

    @Override // com.ipd.dsp.internal.r1.j
    public Bitmap getVideoCapture() {
        com.ipd.dsp.internal.s1.h hVar = this.i;
        if (hVar != null) {
            return hVar.getCapture();
        }
        return null;
    }

    @Override // com.ipd.dsp.internal.r1.b
    public void h() {
        com.ipd.dsp.internal.e1.d dVar = this.p;
        if (dVar == null) {
            return;
        }
        if (!dVar.p) {
            this.o.add(this);
        }
        com.ipd.dsp.internal.s1.h hVar = this.i;
        if (hVar != null) {
            hVar.h();
        }
        if (this.k != null && o.c(this.p.n)) {
            IPDGlideHelper.loadImageRoundedCorners(getContext(), this.k, this.p.n, 10);
        }
        if (this.l != null && o.c(this.p.k)) {
            this.l.setText(this.p.k);
        }
        if (this.m != null && o.c(this.p.l)) {
            this.m.setText(this.p.l);
        }
        com.ipd.dsp.internal.t1.b bVar = this.n;
        if (bVar != null) {
            if (this.p.p) {
                this.o.add(bVar);
            }
            if (o.c(this.p.m)) {
                this.n.setText(this.p.m);
            } else {
                this.n.setText(this.p.r.a());
            }
            this.n.post(new Runnable() { // from class: com.zj.adlib.jab
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42543a.j();
                }
            });
        }
    }

    public final /* synthetic */ void i() {
        if (this.h != null) {
            View view = new View(getContext());
            this.j = view;
            view.setBackground(new com.ipd.dsp.internal.u1.a.C0921a().c(this.g * 2).a(-1, this.g).a());
            this.h.addView(this.j, new FrameLayout.LayoutParams(this.h.getWidth(), this.h.getHeight()));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        List<View> list = this.o;
        if (list != null) {
            Iterator<View> it = list.iterator();
            while (it.hasNext()) {
                try {
                    it.next().setOnClickListener(null);
                } catch (Throwable th) {
                    r.a(th);
                }
            }
            this.o.clear();
            this.o = null;
        }
        this.k = null;
        this.l = null;
        this.m = null;
        com.ipd.dsp.internal.t1.b bVar = this.n;
        if (bVar != null) {
            try {
                bVar.a();
            } catch (Throwable th2) {
                r.a(th2);
            }
            this.n = null;
        }
        com.ipd.dsp.internal.s1.h hVar = this.i;
        if (hVar != null) {
            try {
                hVar.l();
            } catch (Throwable th3) {
                r.a(th3);
            }
            this.i = null;
        }
        this.h = null;
        try {
            removeAllViews();
        } catch (Throwable th4) {
            r.a(th4);
        }
        super.onDetachedFromWindow();
    }

    @Override // com.ipd.dsp.internal.r1.j
    public void setVideoListener(com.ipd.dsp.internal.s1.h.a aVar) {
        com.ipd.dsp.internal.s1.h hVar = this.i;
        if (hVar != null) {
            hVar.setInteractionListener(aVar);
        }
    }

    @Override // com.ipd.dsp.internal.r1.b
    public void a(String str) {
        com.ipd.dsp.internal.t1.b bVar;
        if (TextUtils.isEmpty(str) || (bVar = this.n) == null || !bVar.b()) {
            return;
        }
        this.n.a(str);
    }
}
