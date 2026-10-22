package com.ipd.dsp.internal.p1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import com.ipd.dsp.R;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.c2.r;
import com.ipd.dsp.internal.c2.s;
import com.ipd.dsp.internal.s1.g;
import com.ipd.dsp.internal.t1.h;
import com.ipd.dsp.internal.t1.l;
import com.ipd.dsp.internal.t1.n;
import com.ipd.dsp.open.IPDGlideHelper;
import java.util.ArrayList;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@SuppressLint({"ViewConstructor"})
public class f extends com.ipd.dsp.internal.x1.c {
    public ImageView g;
    public TextView h;
    public com.ipd.dsp.internal.t1.c i;
    public com.ipd.dsp.internal.s1.a j;
    public final boolean k;
    public final boolean l;
    public ArrayList<View> m;
    public boolean n;
    public n o;
    public com.ipd.dsp.internal.k1.a.c p;
    public g q;

    public f(@NonNull Context context, com.ipd.dsp.internal.k1.a.c cVar, boolean z, boolean z2) {
        super(context);
        this.m = new ArrayList<>();
        this.p = cVar;
        this.k = z;
        this.l = z2;
        j();
        b(context);
    }

    private void b(Context context) {
        View view;
        int iA = (int) s.a(context, 5.0f);
        int i = iA * 2;
        int i2 = iA * 9;
        int i3 = iA * 14;
        try {
            ImageView imageView = new ImageView(context);
            this.g = imageView;
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.g.setBackgroundColor(-1);
            addView(this.g);
        } catch (Throwable th) {
            r.a(th);
        }
        try {
            this.i = a(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            this.i.setLayoutParams(layoutParams);
            addView(this.i);
            this.m.addAll(this.i.getClickableViews());
        } catch (Throwable th2) {
            r.a(th2);
        }
        if (this.n && (view = this.o) != null) {
            addView(view);
        }
        try {
            this.q = new g(getContext());
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 80;
            addView(this.q, layoutParams2);
        } catch (Throwable th3) {
            r.a(th3);
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        try {
            com.ipd.dsp.internal.s1.a aVar = new com.ipd.dsp.internal.s1.a(context, -12303292, -3355444);
            this.j = aVar;
            aVar.setCornerRadius((int) s.a(context, 8.0f));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.setMargins(0, 0, i, 0);
            linearLayout.addView(this.j, layoutParams3);
        } catch (Throwable th4) {
            r.a(th4);
        }
        try {
            this.h = new TextView(context);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i3, -2);
            this.h.setBackgroundResource(R.drawable.ipd_bg_ret);
            this.h.setTextColor(-1);
            this.h.setTextSize(12.0f);
            this.h.setGravity(17);
            linearLayout.addView(this.h, layoutParams4);
        } catch (Throwable th5) {
            r.a(th5);
        }
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = GravityCompat.END;
        layoutParams5.setMargins(0, i2, i, 0);
        addView(linearLayout, layoutParams5);
    }

    private void j() {
        setBackgroundColor(0);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        com.ipd.dsp.internal.t1.c cVar = this.i;
        if (cVar != null) {
            try {
                cVar.d();
            } catch (Throwable unused) {
            }
        }
    }

    public void a(com.ipd.dsp.internal.e1.d dVar) {
        if (!dVar.p) {
            this.m.add(this);
        }
        this.m.add(this.h);
        if (this.g != null) {
            IPDGlideHelper.loadImageCenterCrop(getContext(), this.g, dVar.o);
        }
        if (this.i != null) {
            if (o.c(dVar.m)) {
                this.i.setText(dVar.m);
            } else {
                this.i.setText(dVar.r.a());
            }
            this.i.post(new Runnable() { // from class: com.zj.adlib.k2b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42729a.k();
                }
            });
        }
        if (this.q != null && dVar.r.b()) {
            this.q.a(dVar.r.D, 0);
        }
        com.ipd.dsp.internal.s1.a aVar = this.j;
        if (aVar != null) {
            aVar.a(dVar.t);
        }
    }

    public ArrayList<View> getClickableViews() {
        return this.m;
    }

    public TextView getSkipBtn() {
        return this.h;
    }

    public void i() {
        removeAllViews();
        this.g = null;
        this.h = null;
        this.i = null;
        this.o = null;
        this.p = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.ipd.dsp.internal.k1.a.c cVar = this.p;
        if (cVar != null) {
            cVar.onDetachedFromWindow();
        }
        ArrayList<View> arrayList = this.m;
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                View view = arrayList.get(i);
                i++;
                try {
                    view.setOnClickListener(null);
                } catch (Throwable unused) {
                }
            }
            this.m.clear();
            this.m = null;
        }
        com.ipd.dsp.internal.t1.c cVar2 = this.i;
        if (cVar2 != null) {
            try {
                cVar2.a();
            } catch (Throwable unused2) {
            }
            this.i = null;
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            com.ipd.dsp.internal.k1.a.c cVar = this.p;
            if (cVar != null) {
                cVar.a();
                return;
            }
            return;
        }
        com.ipd.dsp.internal.k1.a.c cVar2 = this.p;
        if (cVar2 != null) {
            cVar2.b();
        }
    }

    public final com.ipd.dsp.internal.t1.c a(Context context) {
        if (this.k) {
            int iNextInt = new Random().nextInt(3);
            if (iNextInt != 1 && iNextInt != 2) {
                return new com.ipd.dsp.internal.t1.f(context);
            }
            return new h(context, iNextInt);
        }
        if (this.l && new Random().nextInt(2) == 1) {
            this.n = true;
            this.o = new n(context);
            return new l(context, this.o, new Random().nextInt(3));
        }
        return new com.ipd.dsp.internal.t1.d(context);
    }
}
