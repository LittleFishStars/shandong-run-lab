package com.ipd.dsp.internal.p1;

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
import com.ipd.dsp.internal.s1.g;
import com.ipd.dsp.internal.s1.h;
import com.ipd.dsp.internal.t1.i;
import com.ipd.dsp.open.IPDGlideHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@SuppressLint({"ViewConstructor"})
public class c extends com.ipd.dsp.internal.x1.c {
    public h g;
    public ImageView h;
    public ImageView i;
    public TextView j;
    public TextView k;
    public com.ipd.dsp.internal.t1.b l;
    public com.ipd.dsp.internal.s1.a m;
    public g n;
    public List<View> o;
    public final com.ipd.dsp.internal.e1.d p;
    public com.ipd.dsp.internal.k1.a.c q;
    public boolean r;
    public final boolean s;
    public com.ipd.dsp.internal.c2.f.b t;

    public class a implements com.ipd.dsp.internal.c2.f.b {
        public a() {
        }

        @Override // com.ipd.dsp.internal.c2.f.b
        public void onPause() {
            if (c.this.g != null) {
                c.this.g.m();
            }
        }

        @Override // com.ipd.dsp.internal.c2.f.b
        public void onResume() {
            if (c.this.g != null) {
                c.this.g.n();
            }
        }
    }

    public c(Context context, com.ipd.dsp.internal.e1.d dVar, com.ipd.dsp.internal.j1.b bVar, boolean z) {
        super(context);
        this.o = new ArrayList();
        this.t = new a();
        this.p = dVar;
        boolean zB = dVar.r.b();
        this.s = zB;
        setBackground(new com.ipd.dsp.internal.u1.a.C0921a().a(-16777216).a());
        this.r = z;
        int iA = (int) s.a(context, 12.0f);
        int iA2 = (int) s.a(context, 24.0f);
        int iA3 = (int) s.a(context, 36.0f);
        int iA4 = (int) s.a(context, 60.0f);
        h hVar = new h(context, dVar, bVar, this.r);
        this.g = hVar;
        addView(hVar, new FrameLayout.LayoutParams(-1, -1));
        int iA5 = (int) s.a(context, 5.0f);
        int iA6 = (int) s.a(context, 15.0f);
        int i = iA6 * 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
        layoutParams.setMargins(iA6, iA6, iA6, iA6);
        ImageView imageView = new ImageView(context);
        this.h = imageView;
        imageView.setLayoutParams(layoutParams);
        this.h.setPadding(iA5, iA5, iA5, iA5);
        this.h.setBackgroundResource(R.drawable.ipd_bg_circle);
        this.h.setImageResource(this.r ? R.drawable.ipd_volume_off : R.drawable.ipd_volume_on);
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.opa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f43805a.a(view);
            }
        });
        addView(this.h, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundResource(R.drawable.ipd_bg_immersive_dark);
        frameLayout.setPadding(iA, iA, iA, iA);
        addView(frameLayout, layoutParams2);
        ImageView imageView2 = new ImageView(context);
        this.i = imageView2;
        frameLayout.addView(imageView2, new FrameLayout.LayoutParams(iA4, iA4));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        int i2 = iA4 + iA;
        layoutParams3.leftMargin = i2;
        TextView textView = new TextView(context);
        this.j = textView;
        textView.setSingleLine(true);
        this.j.setTextColor(-1);
        this.j.setTextSize(18.0f);
        this.j.setTypeface(Typeface.DEFAULT_BOLD);
        frameLayout.addView(this.j, layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, iA3);
        layoutParams4.leftMargin = i2;
        layoutParams4.topMargin = iA2 + iA;
        TextView textView2 = new TextView(context);
        this.k = textView2;
        textView2.setMaxLines(2);
        this.k.setTextColor(-3355444);
        this.k.setTextSize(12.0f);
        frameLayout.addView(this.k, layoutParams4);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, iA4);
        layoutParams5.topMargin = i2;
        layoutParams5.bottomMargin = zB ? iA3 + iA : iA;
        if (dVar.w.g) {
            int iNextInt = new Random().nextInt(3);
            if (iNextInt == 0) {
                this.l = new com.ipd.dsp.internal.t1.g(context);
            } else {
                this.l = new i(context, iNextInt);
            }
            this.l.setBackgroundResource(R.drawable.ipd_bg_blue);
        } else {
            this.l = new com.ipd.dsp.internal.t1.e(context);
        }
        this.l.setLayoutParams(layoutParams5);
        this.l.setGravity(17);
        frameLayout.addView(this.l, layoutParams5);
        if (zB) {
            this.n = new g(context);
            FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams6.gravity = 80;
            addView(this.n, layoutParams6);
        }
        int iA7 = (int) s.a(context, 16.0f);
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams7.gravity = 8388693;
        layoutParams7.bottomMargin = iA;
        layoutParams7.setMarginEnd(iA7);
        com.ipd.dsp.internal.s1.a aVar = new com.ipd.dsp.internal.s1.a(context);
        this.m = aVar;
        aVar.setLayoutParams(layoutParams7);
        addView(this.m, layoutParams7);
    }

    public void e() {
        g gVar;
        com.ipd.dsp.internal.t1.b bVar = this.l;
        if (bVar != null) {
            bVar.a();
        }
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        h hVar = this.g;
        if (hVar != null) {
            hVar.i();
        }
        if (!this.s || (gVar = this.n) == null) {
            return;
        }
        gVar.bringToFront();
    }

    public List<View> getClickableViews() {
        return this.o;
    }

    public Bitmap getVideoCapture() {
        h hVar = this.g;
        if (hVar != null) {
            return hVar.getCapture();
        }
        return null;
    }

    public void h() {
        g gVar;
        com.ipd.dsp.internal.e1.d dVar = this.p;
        if (dVar == null) {
            return;
        }
        if (!dVar.p) {
            this.o.add(this);
        }
        ImageView imageView = this.h;
        if (imageView != null) {
            this.o.add(imageView);
        }
        h hVar = this.g;
        if (hVar != null) {
            hVar.h();
            com.ipd.dsp.internal.c2.f.a().a(this.t);
        }
        if (this.i != null && o.c(this.p.n)) {
            IPDGlideHelper.loadImageRoundedCorners(getContext(), this.i, this.p.n, 10);
        }
        if (this.j != null && o.c(this.p.k)) {
            this.j.setText(this.p.k);
        }
        if (this.k != null && o.c(this.p.l)) {
            this.k.setText(this.p.l);
        }
        com.ipd.dsp.internal.t1.b bVar = this.l;
        if (bVar != null) {
            if (this.p.p) {
                this.o.add(bVar);
            }
            if (o.c(this.p.m)) {
                this.l.setText(this.p.m);
            } else {
                this.l.setText(this.p.r.a());
            }
            this.l.post(new Runnable() { // from class: com.zj.adlib.apa
                @Override // java.lang.Runnable
                public final void run() {
                    this.f40580a.i();
                }
            });
        }
        if (this.s && (gVar = this.n) != null) {
            gVar.a(this.p.r.D, 0);
        }
        com.ipd.dsp.internal.s1.a aVar = this.m;
        if (aVar != null) {
            aVar.a(this.p.t);
        }
    }

    public final /* synthetic */ void i() {
        com.ipd.dsp.internal.t1.b bVar = this.l;
        if (bVar != null) {
            bVar.d();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
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
        this.i = null;
        this.j = null;
        this.k = null;
        com.ipd.dsp.internal.t1.b bVar = this.l;
        if (bVar != null) {
            try {
                bVar.a();
            } catch (Throwable th2) {
                r.a(th2);
            }
            this.l = null;
        }
        h hVar = this.g;
        if (hVar != null) {
            hVar.l();
            this.g = null;
        }
        this.m = null;
        this.h = null;
        try {
            removeAllViews();
        } catch (Throwable th3) {
            r.a(th3);
        }
        com.ipd.dsp.internal.k1.a.c cVar = this.q;
        if (cVar != null) {
            cVar.onDetachedFromWindow();
            this.q = null;
        }
        if (this.t != null) {
            com.ipd.dsp.internal.c2.f.a().b(this.t);
            this.t = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            com.ipd.dsp.internal.k1.a.c cVar = this.q;
            if (cVar != null) {
                cVar.a();
                return;
            }
            return;
        }
        com.ipd.dsp.internal.k1.a.c cVar2 = this.q;
        if (cVar2 != null) {
            cVar2.b();
        }
    }

    public void setVideoListener(h.a aVar) {
        h hVar = this.g;
        if (hVar != null) {
            hVar.setInteractionListener(aVar);
        }
    }

    public void setVisibilityListener(com.ipd.dsp.internal.k1.a.c cVar) {
        this.q = cVar;
    }

    public final /* synthetic */ void a(View view) {
        boolean z = this.r;
        this.r = !z;
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setImageResource(!z ? R.drawable.ipd_volume_off : R.drawable.ipd_volume_on);
        }
        h hVar = this.g;
        if (hVar != null) {
            hVar.a(this.r);
        }
    }

    public void a(String str) {
        com.ipd.dsp.internal.t1.b bVar;
        if (TextUtils.isEmpty(str) || (bVar = this.l) == null) {
            return;
        }
        bVar.a(str);
    }
}
