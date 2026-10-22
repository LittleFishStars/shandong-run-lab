package com.ipd.dsp.internal.q1;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.ipd.dsp.internal.c2.f;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.c2.s;
import com.ipd.dsp.internal.s1.h;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class a extends LinearLayout implements View.OnClickListener {
    public ArrayList<View> f;
    public com.ipd.dsp.internal.p1.d.a g;
    public h h;
    public f.b i;

    /* JADX INFO: renamed from: com.ipd.dsp.internal.q1.a$a, reason: collision with other inner class name */
    public class C0912a implements f.b {
        public C0912a() {
        }

        @Override // com.ipd.dsp.internal.c2.f.b
        public void onPause() {
            h hVar = a.this.h;
            if (hVar != null) {
                hVar.m();
            }
        }

        @Override // com.ipd.dsp.internal.c2.f.b
        public void onResume() {
            h hVar = a.this.h;
            if (hVar != null) {
                hVar.n();
            }
        }
    }

    public a(Context context, com.ipd.dsp.internal.p1.d.a aVar) {
        super(context);
        this.f = new ArrayList<>();
        this.g = aVar;
        int iA = (int) s.a(context, 4.0f);
        setPadding(iA, iA, iA, iA);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
    }

    public void a(com.ipd.dsp.internal.e1.d dVar, com.ipd.dsp.internal.j1.b bVar, float f, boolean z) {
        if (o.c(dVar.q.f)) {
            this.i = new C0912a();
            f.a().a(this.i);
        }
    }

    public void b() {
        h hVar = this.h;
        if (hVar != null) {
            hVar.m();
        }
    }

    public void c() {
        h hVar = this.h;
        if (hVar != null) {
            hVar.n();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.ipd.dsp.internal.p1.d.a aVar = this.g;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h hVar = this.h;
        if (hVar != null) {
            try {
                hVar.l();
            } catch (Throwable unused) {
            }
            this.h = null;
        }
        if (this.i != null) {
            f.a().b(this.i);
            this.i = null;
        }
    }

    public void a() {
        ArrayList<View> arrayList = this.f;
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
            this.f.clear();
            this.f = null;
        }
        this.g = null;
    }
}
