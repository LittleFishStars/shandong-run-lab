package com.ipd.dsp.internal.r1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.ipd.dsp.R;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.c2.r;
import com.ipd.dsp.internal.c2.s;
import com.ipd.dsp.internal.t1.m;
import com.ipd.dsp.internal.t1.n;
import com.ipd.dsp.open.IPDGlideHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@SuppressLint({"ViewConstructor"})
public class d extends com.ipd.dsp.internal.x1.c implements b {
    public com.ipd.dsp.internal.t0.c g;
    public com.ipd.dsp.internal.t0.c h;
    public TextView i;
    public TextView j;
    public com.ipd.dsp.internal.t1.b k;
    public List<View> l;
    public com.ipd.dsp.internal.e1.d m;
    public final boolean n;

    public d(@NonNull Context context, com.ipd.dsp.internal.e1.d dVar, boolean z, boolean z2) {
        super(context);
        this.l = new ArrayList();
        this.m = dVar;
        this.n = z;
        float fA = s.a(context, 10.0f);
        if (z) {
            setBackground(new com.ipd.dsp.internal.u1.a.C0921a().a(-1).a());
        } else {
            setBackground(new com.ipd.dsp.internal.u1.a.C0921a().c(fA).a(-1).a());
        }
        int iA = (int) s.a(context, 12.0f);
        int iA2 = (int) s.a(context, 24.0f);
        int iA3 = (int) s.a(context, 48.0f);
        int iA4 = (int) s.a(context, 60.0f);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        addView(linearLayout);
        com.ipd.dsp.internal.t0.c cVar = new com.ipd.dsp.internal.t0.c(context);
        this.g = cVar;
        com.ipd.dsp.internal.t0.a aVar = com.ipd.dsp.internal.t0.a.DATUM_WIDTH;
        cVar.a(aVar, com.ipd.dsp.internal.e1.f.a(dVar.s.g, 1.7777778f), 1.0f);
        linearLayout.addView(this.g);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setGravity(1);
        linearLayout2.setOrientation(1);
        linearLayout.addView(linearLayout2, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(iA4, iA4);
        layoutParams2.setMargins(0, iA2, 0, 0);
        com.ipd.dsp.internal.t0.c cVar2 = new com.ipd.dsp.internal.t0.c(context);
        this.h = cVar2;
        cVar2.a(aVar, 1.0f, 1.0f);
        linearLayout2.addView(this.h, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(iA2, iA2, iA2, 0);
        TextView textView = new TextView(context);
        this.i = textView;
        textView.setGravity(16);
        this.i.setSingleLine(true);
        this.i.setTextColor(-16777216);
        this.i.setTextSize(22.0f);
        this.i.setTypeface(Typeface.DEFAULT_BOLD);
        linearLayout2.addView(this.i, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.setMargins(iA, iA, iA, 0);
        TextView textView2 = new TextView(context);
        this.j = textView2;
        textView2.setGravity(16);
        this.j.setMaxLines(2);
        this.j.setTextColor(-12303292);
        this.j.setTextSize(20.0f);
        this.j.setEllipsize(TextUtils.TruncateAt.END);
        linearLayout2.addView(this.j, layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, iA3);
        layoutParams5.setMargins(iA2, 0, iA2, (z && z2) ? iA4 : iA2);
        com.ipd.dsp.internal.e1.c cVar3 = this.m.w;
        if (cVar3.g) {
            int iNextInt = new Random().nextInt(3);
            if (iNextInt == 0) {
                layoutParams5.height = iA4;
                this.k = new com.ipd.dsp.internal.t1.g(context);
            } else {
                this.k = new com.ipd.dsp.internal.t1.i(context, iNextInt);
            }
            this.k.setBackgroundResource(R.drawable.ipd_bg_blue);
        } else if (cVar3.i && new Random().nextInt(2) == 1) {
            n nVar = new n(getContext());
            m mVar = new m(context, nVar, new Random().nextInt(2) + 1);
            this.k = mVar;
            mVar.setBackgroundResource(R.drawable.ipd_bg_blue);
            addView(nVar);
        } else {
            layoutParams5.height = iA4;
            this.k = new com.ipd.dsp.internal.t1.e(context);
        }
        this.k.setGravity(17);
        linearLayout.addView(this.k, layoutParams5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        com.ipd.dsp.internal.t1.b bVar = this.k;
        if (bVar != null) {
            bVar.d();
        }
    }

    @Override // com.ipd.dsp.internal.r1.b
    public void a(String str) {
        com.ipd.dsp.internal.t1.b bVar;
        if (TextUtils.isEmpty(str) || (bVar = this.k) == null || !bVar.b()) {
            return;
        }
        this.k.a(str);
    }

    @Override // com.ipd.dsp.internal.r1.b
    public void e() {
        com.ipd.dsp.internal.t1.b bVar = this.k;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.ipd.dsp.internal.r1.b
    public List<View> getClickableViews() {
        return this.l;
    }

    @Override // com.ipd.dsp.internal.r1.b
    public void h() {
        com.ipd.dsp.internal.e1.d dVar = this.m;
        if (dVar == null) {
            return;
        }
        if (!dVar.p) {
            this.l.add(this);
        }
        if (this.g != null && o.c(this.m.o)) {
            if (this.n) {
                IPDGlideHelper.loadImageCenterCrop(getContext(), this.g, this.m.o);
            } else {
                IPDGlideHelper.loadImageRoundedCorners(getContext(), this.g, this.m.o, 10.0f, 10.0f, 0.0f, 0.0f);
            }
        }
        if (this.h != null && o.c(this.m.n)) {
            IPDGlideHelper.loadImageRoundedCorners(getContext(), this.h, this.m.n, 10);
        }
        if (this.i != null && o.c(this.m.k)) {
            this.i.setText(this.m.k);
        }
        if (this.j != null && o.c(this.m.l)) {
            this.j.setText(this.m.l);
        }
        com.ipd.dsp.internal.t1.b bVar = this.k;
        if (bVar != null) {
            if (this.m.p) {
                this.l.add(bVar);
            }
            if (o.c(this.m.m)) {
                this.k.setText(this.m.m);
            } else {
                this.k.setText(this.m.r.a());
            }
            this.k.post(new Runnable() { // from class: com.zj.adlib.jta
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42672a.i();
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeAllViews();
        List<View> list = this.l;
        if (list != null) {
            Iterator<View> it = list.iterator();
            while (it.hasNext()) {
                try {
                    it.next().setOnClickListener(null);
                } catch (Throwable th) {
                    r.a(th);
                }
            }
            this.l.clear();
            this.l = null;
        }
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        com.ipd.dsp.internal.t1.b bVar = this.k;
        if (bVar != null) {
            try {
                bVar.a();
            } catch (Throwable th2) {
                r.a(th2);
            }
            this.k = null;
        }
        this.m = null;
        super.onDetachedFromWindow();
    }
}
