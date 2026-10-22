package com.ipd.dsp.internal.r1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@SuppressLint({"ViewConstructor"})
public class g extends com.ipd.dsp.internal.x1.c implements j, com.ipd.dsp.internal.s1.h.b {
    public final int g;
    public com.ipd.dsp.internal.s1.h h;
    public View i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public List<View> n;
    public final com.ipd.dsp.internal.e1.d o;

    public g(@NonNull Context context, com.ipd.dsp.internal.e1.d dVar, com.ipd.dsp.internal.j1.b bVar, boolean z, boolean z2, boolean z3) {
        super(context);
        this.n = new ArrayList();
        this.o = dVar;
        int iA = (int) s.a(context, 5.0f);
        this.g = iA;
        float fA = s.a(context, 10.0f);
        if (z) {
            setBackground(new com.ipd.dsp.internal.u1.a.C0921a().a(-16777216).a());
        } else {
            setBackground(new com.ipd.dsp.internal.u1.a.C0921a().c(fA).a(-16777216).a());
        }
        int iA2 = (int) s.a(context, 4.0f);
        int iA3 = (int) s.a(context, 12.0f);
        int iA4 = (int) s.a(context, 22.0f);
        int iA5 = (int) s.a(context, 40.0f);
        int iA6 = (int) s.a(context, 60.0f);
        int iA7 = (int) s.a(context, 90.0f);
        com.ipd.dsp.internal.s1.h hVar = new com.ipd.dsp.internal.s1.h(context, dVar, bVar, z3, z);
        this.h = hVar;
        addView(hVar, new FrameLayout.LayoutParams(-1, -1));
        if (!z) {
            this.h.setVideoCoverCallback(this);
            View view = new View(context);
            this.i = view;
            view.setBackground(new com.ipd.dsp.internal.u1.a.C0921a().c(fA).a(-1, iA).a());
            this.i.setVisibility(8);
            addView(this.i, new FrameLayout.LayoutParams(-1, -1));
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        layoutParams.setMargins(iA3, 0, iA3, (z && z2) ? iA3 * 4 : iA3);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundResource(R.drawable.ipd_bg_light);
        frameLayout.setPadding(iA2, iA2, iA2, iA2);
        addView(frameLayout, layoutParams);
        ImageView imageView = new ImageView(context);
        this.j = imageView;
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(iA6, iA6));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, iA4);
        int i = iA6 + iA2;
        layoutParams2.leftMargin = i;
        int i2 = iA7 + iA2;
        layoutParams2.rightMargin = i2;
        TextView textView = new TextView(context);
        this.k = textView;
        textView.setGravity(48);
        this.k.setSingleLine(true);
        this.k.setTextColor(-16777216);
        this.k.setTextSize(16.0f);
        this.k.setTypeface(Typeface.DEFAULT_BOLD);
        frameLayout.addView(this.k, layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, iA5);
        layoutParams3.leftMargin = i;
        layoutParams3.topMargin = iA4;
        layoutParams3.rightMargin = i2;
        TextView textView2 = new TextView(context);
        this.l = textView2;
        textView2.setMaxLines(2);
        this.l.setGravity(48);
        this.l.setTextColor(-12303292);
        this.l.setTextSize(12.0f);
        frameLayout.addView(this.l, layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(iA7, iA5);
        layoutParams4.gravity = 8388629;
        TextView textView3 = new TextView(context);
        this.m = textView3;
        textView3.setTextSize(14.0f);
        this.m.setBackgroundResource(R.drawable.ipd_bg_blue);
        this.m.setLayoutParams(layoutParams4);
        this.m.setTextColor(-1);
        this.m.setGravity(17);
        frameLayout.addView(this.m, layoutParams4);
    }

    @Override // com.ipd.dsp.internal.r1.j
    public void a(boolean z) {
        com.ipd.dsp.internal.s1.h hVar = this.h;
        if (hVar != null) {
            hVar.a(z);
        }
    }

    @Override // com.ipd.dsp.internal.r1.j
    public void b() {
        com.ipd.dsp.internal.s1.h hVar = this.h;
        if (hVar != null) {
            hVar.m();
        }
    }

    @Override // com.ipd.dsp.internal.r1.j
    public void c() {
        com.ipd.dsp.internal.s1.h hVar = this.h;
        if (hVar != null) {
            hVar.o();
        }
    }

    @Override // com.ipd.dsp.internal.r1.j
    public void d() {
        com.ipd.dsp.internal.s1.h hVar = this.h;
        if (hVar != null) {
            hVar.k();
        }
    }

    @Override // com.ipd.dsp.internal.r1.b
    public void e() {
        com.ipd.dsp.internal.s1.h hVar = this.h;
        if (hVar != null) {
            hVar.i();
        }
    }

    @Override // com.ipd.dsp.internal.r1.j
    public void f() {
        com.ipd.dsp.internal.s1.h hVar = this.h;
        if (hVar != null) {
            hVar.n();
        }
    }

    @Override // com.ipd.dsp.internal.s1.h.b
    public void g() {
        setBackground(new com.ipd.dsp.internal.u1.a.C0921a().c(this.g * 2).a(-16777216).a(-1, this.g).a());
        View view = this.i;
        if (view != null) {
            view.setVisibility(0);
        }
        com.ipd.dsp.internal.s1.h hVar = this.h;
        if (hVar != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) hVar.getLayoutParams();
            int i = this.g / 2;
            layoutParams.setMargins(i, 0, i, 0);
            this.h.setLayoutParams(layoutParams);
        }
    }

    @Override // com.ipd.dsp.internal.r1.b
    public List<View> getClickableViews() {
        return this.n;
    }

    @Override // com.ipd.dsp.internal.r1.j
    public Bitmap getVideoCapture() {
        com.ipd.dsp.internal.s1.h hVar = this.h;
        if (hVar != null) {
            return hVar.getCapture();
        }
        return null;
    }

    @Override // com.ipd.dsp.internal.r1.b
    public void h() {
        com.ipd.dsp.internal.e1.d dVar = this.o;
        if (dVar == null) {
            return;
        }
        if (!dVar.p) {
            this.n.add(this);
        }
        com.ipd.dsp.internal.s1.h hVar = this.h;
        if (hVar != null) {
            hVar.h();
        }
        if (this.j != null && o.c(this.o.n)) {
            IPDGlideHelper.loadImageRoundedCorners(getContext(), this.j, this.o.n, 10);
        }
        if (this.k != null && o.c(this.o.k)) {
            this.k.setText(this.o.k);
        }
        if (this.l != null && o.c(this.o.l)) {
            this.l.setText(this.o.l);
        }
        TextView textView = this.m;
        if (textView != null) {
            if (this.o.p) {
                this.n.add(textView);
            }
            if (o.c(this.o.m)) {
                this.m.setText(this.o.m);
            } else {
                this.m.setText(this.o.r.a());
            }
            this.m.setText("查看详情");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        List<View> list = this.n;
        if (list != null) {
            Iterator<View> it = list.iterator();
            while (it.hasNext()) {
                try {
                    it.next().setOnClickListener(null);
                } catch (Throwable th) {
                    r.a(th);
                }
            }
            this.n.clear();
            this.n = null;
        }
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        com.ipd.dsp.internal.s1.h hVar = this.h;
        if (hVar != null) {
            try {
                hVar.l();
            } catch (Throwable th2) {
                r.a(th2);
            }
            this.h = null;
        }
        this.i = null;
        try {
            removeAllViews();
        } catch (Throwable th3) {
            r.a(th3);
        }
        super.onDetachedFromWindow();
    }

    @Override // com.ipd.dsp.internal.r1.j
    public void setVideoListener(com.ipd.dsp.internal.s1.h.a aVar) {
        com.ipd.dsp.internal.s1.h hVar = this.h;
        if (hVar != null) {
            hVar.setInteractionListener(aVar);
        }
    }

    @Override // com.ipd.dsp.internal.r1.b
    public void a(String str) {
        TextView textView;
        if (TextUtils.isEmpty(str) || (textView = this.m) == null || textView.getVisibility() != 0) {
            return;
        }
        this.m.setText(str);
    }
}
