package com.ipd.dsp.internal.k1;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.ipd.dsp.ad.DspBannerAd;
import com.ipd.dsp.internal.c2.r;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b extends a implements a.c {
    public DspBannerAd.InteractionListener n;
    public boolean o;
    public ArrayList<View> p;

    public b(com.ipd.dsp.internal.e1.d dVar, com.ipd.dsp.internal.j1.b bVar) {
        super(dVar, bVar);
        this.o = false;
        this.p = new ArrayList<>();
    }

    public final /* synthetic */ void a(View view) {
        if (this.i == null) {
            return;
        }
        d();
        DspBannerAd.InteractionListener interactionListener = this.n;
        if (interactionListener != null) {
            interactionListener.onBannerAdClick();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r2v4 android.view.View
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    @Override // com.ipd.dsp.internal.k1.a
    public void b(@androidx.annotation.NonNull android.content.Context r7) {
        /*
            r6 = this;
            android.util.DisplayMetrics r0 = new android.util.DisplayMetrics
            r0.<init>()
            java.lang.String r1 = "window"
            java.lang.Object r1 = r7.getSystemService(r1)
            android.view.WindowManager r1 = (android.view.WindowManager) r1
            android.view.Display r1 = r1.getDefaultDisplay()
            r1.getMetrics(r0)
            float r0 = r0.density
            r1 = 1098907648(0x41800000, float:16.0)
            float r0 = com.ipd.dsp.internal.c2.s.a(r0, r1)
            int r0 = (int) r0
            com.ipd.dsp.internal.p1.a r1 = new com.ipd.dsp.internal.p1.a
            com.ipd.dsp.internal.e1.d r2 = r6.f
            r1.<init>(r7, r2, r6)
            java.util.ArrayList<android.view.View> r2 = r6.p
            r2.add(r1)
            com.zj.adlib.oka r2 = new com.zj.adlib.oka
            r2.<init>()
            r1.setOnClickListener(r2)
            android.widget.ImageView r2 = new android.widget.ImageView
            r2.<init>(r7)
            android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams
            r3.<init>(r0, r0)
            r0 = 8388613(0x800005, float:1.175495E-38)
            r3.gravity = r0
            r2.setLayoutParams(r3)
            int r0 = com.ipd.dsp.R.drawable.ipd_bg_circle
            r2.setBackgroundResource(r0)
            int r0 = com.ipd.dsp.R.drawable.ipd_close
            r2.setImageResource(r0)
            java.util.ArrayList<android.view.View> r0 = r6.p
            r0.add(r2)
            com.zj.adlib.ela r0 = new com.zj.adlib.ela
            r0.<init>()
            r2.setOnClickListener(r0)
            com.ipd.dsp.internal.s1.a r0 = new com.ipd.dsp.internal.s1.a
            r0.<init>(r7)
            com.ipd.dsp.internal.e1.d r3 = r6.f
            com.ipd.dsp.internal.e1.h r3 = r3.t
            r0.a(r3)
            android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams
            r4 = -2
            r3.<init>(r4, r4)
            r5 = 8388693(0x800055, float:1.1755063E-38)
            r3.gravity = r5
            r0.setLayoutParams(r3)
            com.ipd.dsp.internal.x1.c r3 = new com.ipd.dsp.internal.x1.c
            r3.<init>(r7)
            r6.i = r3
            android.widget.FrameLayout$LayoutParams r7 = new android.widget.FrameLayout$LayoutParams
            r3 = -1
            r7.<init>(r3, r4)
            r3 = 17
            r7.gravity = r3
            com.ipd.dsp.internal.x1.c r3 = r6.i
            r3.setLayoutParams(r7)
            com.ipd.dsp.internal.x1.c r7 = r6.i
            r7.addView(r1)
            com.ipd.dsp.internal.x1.c r7 = r6.i
            r7.addView(r0)
            com.ipd.dsp.internal.x1.c r7 = r6.i
            r7.addView(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipd.dsp.internal.k1.b.b(android.content.Context):void");
    }

    @Override // com.ipd.dsp.internal.k1.a
    public void g() {
        try {
            ArrayList<View> arrayList = this.p;
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
                this.p.clear();
                this.p = null;
            }
            com.ipd.dsp.internal.x1.c cVar = this.i;
            if (cVar != null) {
                ((com.ipd.dsp.internal.p1.a) cVar).i();
                ViewParent parent = this.i.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.i);
                }
                this.i = null;
            }
        } catch (Throwable unused2) {
        }
        try {
            super.g();
        } catch (Throwable unused3) {
        }
    }

    public final /* synthetic */ void l() {
        h();
        DspBannerAd.InteractionListener interactionListener = this.n;
        if (interactionListener != null) {
            interactionListener.onBannerAdShow();
        }
    }

    @Override // com.ipd.dsp.internal.k1.a.c
    public void onDetachedFromWindow() {
        g();
    }

    public void a(DspBannerAd.InteractionListener interactionListener) {
        this.n = interactionListener;
    }

    @Override // com.ipd.dsp.internal.k1.a.c
    public synchronized void a() {
        if (!this.o) {
            this.o = true;
            com.ipd.dsp.internal.x1.c cVar = this.i;
            if (cVar != null) {
                cVar.post(new Runnable() { // from class: com.zj.adlib.yla
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f46062a.l();
                    }
                });
            }
        }
    }

    public final /* synthetic */ void b(View view) {
        try {
            ViewParent parent = this.i.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(this.i);
            }
        } catch (Throwable th) {
            r.a(th);
        }
        com.ipd.dsp.internal.j1.b bVar = this.g;
        if (bVar != null) {
            com.ipd.dsp.internal.h1.a.a(bVar, com.ipd.dsp.internal.h1.a.e.D);
        }
        DspBannerAd.InteractionListener interactionListener = this.n;
        if (interactionListener != null) {
            interactionListener.onBannerAdClose();
        }
    }

    @Override // com.ipd.dsp.internal.k1.a.c
    public synchronized void b() {
    }
}
